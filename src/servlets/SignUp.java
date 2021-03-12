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
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long	serialVersionUID	= 1L;
	private static final String	VUE_SIGNUP			= "/WEB-INF/signup.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		String path = request.getServletPath();
		
		if (path.equals("/SignUp"))
		{
			getServletContext().getRequestDispatcher(VUE_SIGNUP).forward(request,
					response);
		}
		else
		{
			HttpSession session = request.getSession();

			session.invalidate();

			
			response.sendRedirect("/SignUp");
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

		
		
//		try {
//			if (form.connecter()==1)
//			{
//				response.sendRedirect("users/list");
//			}
//			else if (form.connecter()==2)
//			{
//				response.sendRedirect("users/list2");
//			}
//			else if(form.connecter()==0)
//			{
//				request.setAttribute("form", form);
//				getServletContext().getRequestDispatcher(VUE_SIGNUP).forward(request,
//						response);
//			}
//		} catch (SQLException | IOException | ServletException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
