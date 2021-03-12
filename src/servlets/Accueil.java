package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoAlbum;
import dao.DaoPhoto;

/**
 * Servlet implementation class Accueil
 */
@WebServlet("")
public class Accueil extends HttpServlet
{
	private static final long	serialVersionUID	= 1L;
	private static final String	VUE_ACCUEIL			= "/WEB-INF/index.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
//		DaoAlbum daoAlb =new DaoAlbum();
//		DaoPhoto daoPhoto= new DaoPhoto();
//		System.out.print(daoPhoto.getPublicPhotos());
//		
//		request.setAttribute("photos", daoPhoto.getPublicPhotos());
//		request.setAttribute("albums", daoAlb.getPublicAlbums());
//	
		
		getServletContext().getRequestDispatcher(VUE_ACCUEIL).forward(request,
				response);
	}

}
