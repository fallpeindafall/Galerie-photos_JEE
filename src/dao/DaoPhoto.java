package dao;


import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;

import beans.Photo;

public class DaoPhoto {
	ConnexionManager cm= new ConnexionManager();
	Connection connexion= cm.getInstance();
	private static final ArrayList<Photo> listePublicPhotos = new ArrayList<Photo>();
	private static final ArrayList<Photo> listePhotos = new ArrayList<Photo>();
	
	public  boolean ajouter(Photo photo, int id, String album_name)
	
	{
		
		
		try {
			
			String requete1= "SELECT id_album FROM Album WHERE nom=?";
			PreparedStatement prepareStatement1= connexion.prepareStatement(requete1);
			prepareStatement1.setString(1,album_name);
			ResultSet resultat1= prepareStatement1.executeQuery();
			while(resultat1.next()){
				photo.setIdAlbum(resultat1.getInt("id_album"));
			}
			
			//Statement statement2 = connexion.createStatement();
			String requete= "INSERT INTO Photo (titre, hauteur, largeur, image, mots_cles, date_creation, description, id_albumfk) VALUES (?,?,?,?,?,?,?,?);";
			PreparedStatement prepareStatement= connexion.prepareStatement(requete);
			prepareStatement.setString(1,photo.getTitre());
			prepareStatement.setInt(2,photo.getHauteur());
			prepareStatement.setInt(3,photo.getLargeur());
			prepareStatement.setString(4,photo.getImage());
			prepareStatement.setString(5,photo.getMots_cles());
			//prepareStatement.setInt(6,);
			prepareStatement.setDate(6,photo.getDate_creation());
			prepareStatement.setString(7,photo.getDescription());
			prepareStatement.setInt(8,photo.getIdAlbum());
		
			
			int resultat= prepareStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return true;
	}

	public  boolean modifier(Photo photo)
	{
	
		
		try {
			String requete= "UPDATE Photo set titre=?, hauteur=? , largeur=? , "
					+ "mots_cles=?, date_creation=?, date_maj=?,"
					+ " description=?, id_albumfk=? WHERE id=? ";
			PreparedStatement prepareStatement;
			prepareStatement = connexion.prepareStatement(requete);
			prepareStatement.setString(1,photo.getTitre());
			prepareStatement.setInt(2,photo.getHauteur());
			prepareStatement.setInt(3,photo.getLargeur());
			
			prepareStatement.setString(4,photo.getMots_cles());
			
			prepareStatement.setDate(5,photo.getDate_creation());
			prepareStatement.setDate(6,photo.getDate_maj());
			prepareStatement.setString(7,photo.getDescription());
			prepareStatement.setInt(8,photo.getIdAlbum());
			prepareStatement.setInt(9,photo.getId());
			return true;
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public  boolean supprimer(int id)
	{
		try {
			String requete= "DELETE from Photo WHERE id=?";
			PreparedStatement prepareStatement;
			prepareStatement = connexion.prepareStatement(requete);
			prepareStatement.setInt(1,id);
			
			int resultat= prepareStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	public  Photo get(int id)
	{
		Photo photoToUpdate=new Photo();
		
		try {
			String requete= "SELECT * from Photo WHERE id=?";
			PreparedStatement prepareStatement;
			prepareStatement = connexion.prepareStatement(requete);
			prepareStatement.setInt(1,id);
			
			ResultSet resultat= prepareStatement.executeQuery();
			while(resultat.next()){
				photoToUpdate.setTitre(resultat.getString("titre"));
				photoToUpdate.setHauteur(resultat.getInt("hauteur"));
				photoToUpdate.setLargeur(resultat.getInt("largeur"));
				photoToUpdate.setImage(resultat.getString("image"));
				photoToUpdate.setMots_cles(resultat.getString("mots_cles"));
				photoToUpdate.setDate_creation(resultat.getDate("date_creation"));
				photoToUpdate.setDate_maj(resultat.getDate("date_maj"));
				photoToUpdate.setDescription(resultat.getString("description"));
				photoToUpdate.setIdAlbum(resultat.getInt("id_albumfk"));
				
			
			}
			
			return photoToUpdate;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	

	public  ResultSet connexion() throws SQLException {
		
		Statement statement = connexion.createStatement();
		ResultSet resultat= statement.executeQuery("SELECT * from Utilisateur");
		return resultat;
	}
	
	public  ArrayList<Photo> getPhotos(int id) throws UnsupportedEncodingException
	{
		listePhotos.clear();
		System.out.print(id);
		try {
			String requete= "SELECT  titre, hauteur, largeur , image, mots_cles, "  
										+ " date_creation, date_maj, description, id_albumfk, id_album, " 
										+ "  visibilite FROM Photo,Album WHERE Photo.id_albumfk=Album.id_album AND " 
										+ " idUtilisateur=?  and  visibilite=? " ;
			PreparedStatement prepareStatement;
			prepareStatement = connexion.prepareStatement(requete);
			
		prepareStatement.setInt(1,id);
		prepareStatement.setString(2,"prive");
//			prepareStatement.setInt(3,id);
			ResultSet resultat= prepareStatement.executeQuery();
			while(resultat.next()){
				Photo photo= new Photo();
				
				photo.setTitre(resultat.getString("titre"));
				photo.setHauteur(resultat.getInt("hauteur"));
				photo.setLargeur(resultat.getInt("largeur"));
				//photo.setImage(resultat.getString("image"));
				photo.setMots_cles(resultat.getString("mots_cles"));
				photo.setDate_creation(resultat.getDate("date_creation"));
				photo.setDate_maj(resultat.getDate("date_maj"));
				photo.setDescription(resultat.getString("description"));
				photo.setIdAlbum(resultat.getInt("id_albumfk"));
				
				byte[] encoded = Base64.getEncoder().encode(resultat.getBytes("image"));
				 String base64Encoded = new String(encoded, "UTF-8");
				photo.setImage(base64Encoded);
				
				listePhotos.add(photo);
			
				
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return listePhotos;
	}
	public  ArrayList<Photo> getPublicPhotos() throws UnsupportedEncodingException
	{
		listePublicPhotos.clear();
		
		try {
			String requete= "SELECT titre, hauteur, largeur , image, mots_cles," + 
					"date_creation, date_maj, description, id_albumfk, id_album, " + 
					" visibilite FROM Photo,Album WHERE Photo.id_albumfk=Album.id_album AND " + 
					"visibilite=? ";
					
			//String requete= "SELECT * FROM Photo p join Album a WHERE p.id_albmfk= a.id_album AND a.visibilite=?";
			PreparedStatement prepareStatement;
			prepareStatement = connexion.prepareStatement(requete);
			prepareStatement.setString(1,"public");
			ResultSet resultat= prepareStatement.executeQuery();
			while(resultat.next()){
				Photo photo= new Photo();
				
				photo.setTitre(resultat.getString("titre"));
				photo.setHauteur(resultat.getInt("hauteur"));
				photo.setLargeur(resultat.getInt("largeur"));
			
				photo.setMots_cles(resultat.getString("mots_cles"));
				photo.setDate_creation(resultat.getDate("date_creation"));
				photo.setDate_maj(resultat.getDate("date_maj"));
				photo.setDescription(resultat.getString("description"));
				photo.setIdAlbum(resultat.getInt("id_albumfk"));
				
				
				byte[] encoded = Base64.getEncoder().encode(resultat.getBytes("image"));
				 String base64Encoded = new String(encoded, "UTF-8");
				photo.setImage(base64Encoded);
				listePublicPhotos.add(photo);
			
				
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return listePublicPhotos;
	}
	
}

