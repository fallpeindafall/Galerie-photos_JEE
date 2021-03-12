package metier;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import beans.Utilisateur;
import dao.DaoUtilisateur;

public class SignUpForm
{
	private static final String	CHAMP_NOM			= "nom";
	private static final String	CHAMP_PRENOM		= "prenom";
	private static final String	CHAMP_LOGIN			= "login";
	private static final String	CHAMP_PASSWORD		= "password";
	private static final String	CHAMP_PASSWORD_BIS	= "passwordBis";

	Utilisateur					utilisateur;
	private HttpServletRequest	request;
	private Map<String, String>	erreurs				= new HashMap<String, String>();
	private String				statusMessage;

	public SignUpForm(HttpServletRequest request)
	{
		this.request = request;
	}

	public void ajouter()
	{
		FormUtils formUtils = new FormUtils(request, erreurs);
		String profil="2";
		String nom = formUtils.getParameter(CHAMP_NOM);
		String prenom = formUtils.getParameter(CHAMP_PRENOM);
		String login = formUtils.getParameter(CHAMP_LOGIN);
		String password = formUtils.getParameter(CHAMP_PASSWORD);

		formUtils.validerChamps(CHAMP_NOM, CHAMP_PRENOM, CHAMP_LOGIN,
				CHAMP_PASSWORD, CHAMP_PASSWORD_BIS);
		formUtils.validerPasswords(CHAMP_PASSWORD, CHAMP_PASSWORD_BIS);

		if (erreurs.isEmpty())
		{
			utilisateur = new Utilisateur(nom, prenom, login, password);
			utilisateur.setProfil(profil);
			DaoUtilisateur userDao= new DaoUtilisateur();

			if (userDao.ajouter(utilisateur))
			{
				statusMessage = "Ajout effectu�e avec succ�s";
			}
			else
			{
				statusMessage = "Une erreur inattendue s'est produite";
			}
		}
		else
		{
			utilisateur = new Utilisateur();
			utilisateur.setNom(nom);
			utilisateur.setPrenom(prenom);
			utilisateur.setLogin(login);
			utilisateur.setPassword(password);

			statusMessage = "Echec de l'ajout";
		}
	}

	public Map<String, String> getErreurs()
	{
		return erreurs;
	}

	public Utilisateur getUtilisateur()
	{
		return utilisateur;
	}

	public String getStatusMessage()
	{
		return statusMessage;
	}
}
