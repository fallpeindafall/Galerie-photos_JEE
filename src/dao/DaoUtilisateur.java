package dao;

import java.sql.*;
import java.util.ArrayList;

import beans.Utilisateur;

public class DaoUtilisateur

{
	ConnexionManager cm= new ConnexionManager();
	Connection connexion= cm.getInstance();
	private static final ArrayList<Utilisateur> listeUtilisateurs = new ArrayList<Utilisateur>();
	

	public  boolean ajouter(Utilisateur utilisateur)
	{
		
		
		try {
			//Statement statement2 = connexion.createStatement();
			String requete= "INSERT INTO Utilisateur (nom,prenom,login,password,profil) VALUES (?,?,?,?,?);";
			PreparedStatement prepareStatement= connexion.prepareStatement(requete);
			prepareStatement.setString(1,utilisateur.getNom());
			prepareStatement.setString(2,utilisateur.getPrenom());
			prepareStatement.setString(3,utilisateur.getLogin());
			prepareStatement.setString(4,utilisateur.getPassword());
			prepareStatement.setString(5,utilisateur.getProfil());
			int resultat= prepareStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//listeUtilisateurs.add(utilisateur);
		return true;
	}

	public  boolean modifier(Utilisateur utilisateur)
	{
		Utilisateur userUpdate=new Utilisateur();
		
		try {
			String requete= "UPDATE Utilisateur set nom=?, prenom=?, login=?, password=? WHERE id=?";
			PreparedStatement prepareStatement;
			prepareStatement = connexion.prepareStatement(requete);
			prepareStatement.setString(1,utilisateur.getNom());
			prepareStatement.setString(2,utilisateur.getPrenom());
			prepareStatement.setString(3,utilisateur.getLogin());
			prepareStatement.setString(4,utilisateur.getPassword());
			prepareStatement.setInt(5,utilisateur.getId());
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
			String requete= "DELETE from Utilisateur WHERE id=?";
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

	public  Utilisateur get(int id)
	{
Utilisateur userUpdate=new Utilisateur();
		
		try {
			String requete= "SELECT * from Utilisateur WHERE id=?";
			PreparedStatement prepareStatement;
			prepareStatement = connexion.prepareStatement(requete);
			prepareStatement.setInt(1,id);
			
			ResultSet resultat= prepareStatement.executeQuery();
			while(resultat.next()){
				userUpdate.setId(resultat.getInt("id"));
				userUpdate.setNom(resultat.getString("nom"));
				userUpdate.setPrenom(resultat.getString("prenom"));
			userUpdate.setLogin(resultat.getString("login"));
			userUpdate.setPassword(resultat.getString("password"));
			}
			
			return userUpdate;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static Utilisateur getByLogin(String login)
	{
		
		for (Utilisateur utilisateur : listeUtilisateurs)
		{
			if (utilisateur.getLogin().equals(login))
			{
				return utilisateur;
			}
		}

		return null;
	}

	public  ResultSet connexion() throws SQLException {
		//Utilisateur user=new Utilisateur();
		
//		ConnexionManager cm= new ConnexionManager();
//		Connection connexion= cm.getInstance();
		Statement statement = connexion.createStatement();
		ResultSet resultat= statement.executeQuery("SELECT * from Utilisateur");
		
//		while(resultat.next()){
//			
//			user.setId(resultat.getInt("id"));
//		user.setLogin(resultat.getString("login"));
//		user.setPassword(resultat.getString("password"));
			
		
			
			
			
		
		return resultat;
	}
	public  ArrayList<Utilisateur> getList()
	{
		listeUtilisateurs.clear();
		
		try {
			String requete= "SELECT * from Utilisateur";
			PreparedStatement prepareStatement;
			prepareStatement = connexion.prepareStatement(requete);
			ResultSet resultat= prepareStatement.executeQuery();
			while(resultat.next()){
				Utilisateur user= new Utilisateur();
				user.setId(resultat.getInt("id"));
				user.setNom(resultat.getString("nom"));
				user.setPrenom(resultat.getString("prenom"));
				user.setLogin(resultat.getString("login"));
				user.setPassword(resultat.getString("password"));
				
				listeUtilisateurs.add(user);
			
				
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return listeUtilisateurs;
	}
}
