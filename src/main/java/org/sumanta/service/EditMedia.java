package org.sumanta.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sumanta.bean.Media;
import org.sumanta.dao.manageMedia;

/**
 * Servlet implementation class EditMedia
 */
@WebServlet("/EditMedia")
public class EditMedia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditMedia() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		manageMedia mngmda=new manageMedia();
		Media mda=mngmda.singleMediaDetails(id);
		System.out.println(mda.getId());
		request.setAttribute("mda", mda);
		RequestDispatcher rd=request.getRequestDispatcher("jsp/EditMedia.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		String path=request.getParameter("path");
		Media mda=new Media();
		mda.setId(Integer.parseInt(id));
		mda.setPath(path);
		manageMedia mngmda=new manageMedia();
		mngmda.updateMedia(mda, mda.getId());
		response.sendRedirect("ViewMedia");
	}

}
