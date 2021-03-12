package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.ConnexionForm;

/**
 * Servlet implementation class Authentication
 */
@WebServlet("/Authentication")
public class Authentication extends HttpServlet {
	private static final long	serialVersionUID	= 1L;
	private static final String	VUE_LOGIN			= "/WEB-INF/authentication.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		String path = request.getServletPath();

		if (path.equals("/Authentication"))
		{
			getServletContext().getRequestDispatcher(VUE_LOGIN).forward(request,
					response);
		}
		else
		{
			HttpSession session = request.getSession();

			session.invalidate();

			
			response.sendRedirect("Authentication");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		ConnexionForm form = new ConnexionForm(request);

		String profil="";
		try {
			profil = form.connecter();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
			if (profil.equals("admin") )
			{
				response.sendRedirect("Home");
			}
			else if (profil.equals("user"))
			{
				response.sendRedirect("AddImages");
			}
			else if(profil.equals(null))
			{
				request.setAttribute("form", form);
				getServletContext().getRequestDispatcher(VUE_LOGIN).forward(request,
						response);
			}
		
	}
	
	
	

}
