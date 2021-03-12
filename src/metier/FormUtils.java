package metier;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class FormUtils
{
	private HttpServletRequest	request;
	private Map<String, String>	erreurs;

	public FormUtils(HttpServletRequest request)
	{
		this.request = request;
	}

	public FormUtils(HttpServletRequest request, Map<String, String> erreurs)
	{
		this.request = request;
		this.erreurs = erreurs;
	}

	public String getParameter(String parametre)
	{
		String valeur = request.getParameter(parametre);
		return (valeur == null || valeur.trim().isEmpty()) ? null
				: valeur.trim();
	}
//	public String getParameter2(int parametre2)
//	{
//		int valeur = request.getParameter(parametre);
//		return (valeur==0 ) ? null
//				: valeur.trim();
//	}

	public void validerChamps(String... champs)
	{
		for (String champ : champs)
		{
			if (getParameter(champ) == null)
			{
				erreurs.put(champ, "Vous devez remplir ce champ");
			}
		}
	}
	

	public void validerPasswords(String champPassword, String champPasswordBis)
	{
		String password = getParameter(champPassword);
		String passwordBis = getParameter(champPasswordBis);

		if (password != null && !password.equals(passwordBis))
		{
			String message = "Les mots de passe ne sont pas conformes";
			erreurs.put(champPassword, message);
			erreurs.put(champPasswordBis, message);
		}
	}
}
