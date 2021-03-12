package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddImages
 */
@WebServlet("/AddImages")
public class AddImages extends HttpServlet {
	private static final long	serialVersionUID	= 1L;
	private static final String	VUE_ACCUEIL			= "/WEB-INF/addimages.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		getServletContext().getRequestDispatcher(VUE_ACCUEIL).forward(request,
				response);
	}
	

}
