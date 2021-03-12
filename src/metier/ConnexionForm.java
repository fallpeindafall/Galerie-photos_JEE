package metier;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import beans.Utilisateur;
import dao.DaoUtilisateur;

public class ConnexionForm {
	private static final String	CHAMP_LOGIN		= "login";
	private static final String	CHAMP_PASSWORD	= "password";

	private HttpServletRequest	request;
	private String				login;
	private String				statusMessage;
	
	public ConnexionForm(HttpServletRequest request)
	{
		this.request = request;
	}

	public  String connecter() throws SQLException
	
	{
		DaoUtilisateur utilisateur= new DaoUtilisateur();
		ResultSet users=utilisateur.connexion();
		Utilisateur user= new Utilisateur();
		FormUtils formulUtils = new FormUtils(request);

		login = formulUtils.getParameter(CHAMP_LOGIN);
		String password = formulUtils.getParameter(CHAMP_PASSWORD);
		//Utilisateur utilisateur = DaoUtilisateur.getByLogin(login);
				while(users.next()){
					if (users.getString("login").equals(login) && users.getString("password").equals(password))
					{
						user.setId(users.getInt("id"));
						user.setLogin(users.getString("login"));
						user.setPassword(users.getString("password"));
						user.setProfil(users.getString("profil"));
						HttpSession session = request.getSession();
						session.setAttribute("utilisateur", user);
						return users.getString("profil");
					}
					
					
				}
				user=null;
				
				if (user == null || !user.getPassword().equals(password))
				{
					statusMessage = "Echec de l'autentification : login et/ou mot de passe incorrect";
					return null;
				}

				

			return null;
			}

			public String getLogin()
			{
				return login;
			}

			public String getStatusMessage()
			{
				return statusMessage;
			}
}
