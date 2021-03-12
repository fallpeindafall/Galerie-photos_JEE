package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.Album;

import beans.Utilisateur;

public class DaoAlbum {

	
	ConnexionManager cm= new ConnexionManager();
	Connection connexion= cm.getInstance();
	private static final ArrayList<Album> listeAlbums = new ArrayList<Album>();
	private static final ArrayList<Album> listeUserAlbums = new ArrayList<Album>();
	private static final ArrayList<Album> listeMyAlbums = new ArrayList<Album>();
	
	public  boolean ajouter(Album album, int id)
	{
		
		
		try {
			//Statement statement2 = connexion.createStatement();
			String requete= "INSERT INTO Album (nom, idUtilisateur, visibilite) VALUES (?,?,?);";
			PreparedStatement prepareStatement= connexion.prepareStatement(requete);
			prepareStatement.setString(1,album.getNom());
			prepareStatement.setInt(2,id);
			prepareStatement.setString(3,album.getVisibilite());
		
			
			int resultat= prepareStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return true;
	}

	public  boolean modifier(Album album)
	{
	
		
		try {
			String requete= "UPDATE Album set nom=?, visibilite=? WHERE id_album=?";
			PreparedStatement prepareStatement;
			prepareStatement = connexion.prepareStatement(requete);
			prepareStatement.setString(1,album.getNom());
			prepareStatement.setString(2,album.getVisibilite());
			prepareStatement.setInt(4,album.getId_album());
			int resultat= prepareStatement.executeUpdate();
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
			String requete= "DELETE from Album WHERE id_album=?";
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

	public  Album get(int id)
	{
		Album albumToUpdate=new Album();
		
		try {
			String requete= "SELECT * from Album WHERE id=?";
			PreparedStatement prepareStatement;
			prepareStatement = connexion.prepareStatement(requete);
			prepareStatement.setInt(1,id);
			
			ResultSet resultat= prepareStatement.executeQuery();
			while(resultat.next()){
				albumToUpdate.setId_album(resultat.getInt("id_album"));
				albumToUpdate.setNom(resultat.getString("nom"));
				albumToUpdate.setVisibilite(resultat.getString("visibilite"));
				
			
			}
			
			return albumToUpdate;
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
	
	public  ArrayList<Album> getPublicAlbums()
	{
		listeAlbums.clear();
		
		try {
			String requete= "SELECT * FROM Album WHERE visibilite=?";
			PreparedStatement prepareStatement;
			prepareStatement = connexion.prepareStatement(requete);
			prepareStatement.setString(1,"public");
			ResultSet resultat= prepareStatement.executeQuery();
			while(resultat.next()){
				Album alb= new Album();
				alb.setId_album(resultat.getInt("id_album"));
				alb.setNom(resultat.getString("nom"));
				alb.setVisibilite(resultat.getString("visibilite"));
				
				
				
				listeAlbums.add(alb);
			
				
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return listeAlbums;
	}
	public  ArrayList<Album> getAlbums(int id)
	{
		listeUserAlbums.clear();
		
		try {
			String requete= "SELECT * FROM Album WHERE idUtilisateur=? and visibilite=?";
			PreparedStatement prepareStatement;
			prepareStatement = connexion.prepareStatement(requete);
			prepareStatement.setInt(1,id);
			prepareStatement.setString(2,"prive");
			ResultSet resultat= prepareStatement.executeQuery();
			while(resultat.next()){
				Album alb= new Album();
				alb.setId_album(resultat.getInt("id_album"));
				alb.setNom(resultat.getString("nom"));
				alb.setVisibilite(resultat.getString("visibilite"));
			
				listeUserAlbums.add(alb);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return listeUserAlbums;
	}
	public  ArrayList<Album> getMyAlbums(int id)
	{
		listeMyAlbums.clear();
		
		try {
			String requete= "SELECT * FROM Album WHERE idUtilisateur=? ";
			PreparedStatement prepareStatement;
			prepareStatement = connexion.prepareStatement(requete);
			prepareStatement.setInt(1,id);
			ResultSet resultat= prepareStatement.executeQuery();
			while(resultat.next()){
				Album alb= new Album();
				alb.setId_album(resultat.getInt("id_album"));
				alb.setNom(resultat.getString("nom"));
				alb.setVisibilite(resultat.getString("visibilite"));
			
				listeMyAlbums.add(alb);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return listeMyAlbums;
	}
}
