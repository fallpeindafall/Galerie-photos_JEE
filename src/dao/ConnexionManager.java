package dao;
import java.sql.*;



public class ConnexionManager{
	Connection connexion;
	
	
	public  Connection getInstance(){ 
	
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connexion= DriverManager.getConnection("jdbc:mysql://localhost/galerie","root","");
			
			
			
			
			}
		catch(SQLTimeoutException e){
			System.out.println("Erreur, delain d'execution depasse: "+ e.getMessage());
		}
		catch(SQLException e){
			System.out.println("Erreur de connexion : "+ e.getMessage());
		}
		catch(ClassNotFoundException e){
				System.out.println("Erreur de connexion : "+ e.getMessage());
			}
		return connexion;
	}
}
