package org.sumanta.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sumanta.bean.Media;
import org.sumanta.dao.manageMedia;


/**
 * Servlet implementation class AddMedia
 */
@WebServlet("/AddMedia")
public class AddMedia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMedia() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd=request.getRequestDispatcher("jsp/addvideo.jsp");	//Forwarding page to viewallocatedawd.jsp page
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		//out.print("hello");
		String path=request.getParameter("path");
		Media media=new Media();
		media.setPath(path);
		System.out.println("going into");
		manageMedia mst=new manageMedia();
		out.println(media.getId());
		mst.addMedia(media);
		
		response.sendRedirect("ViewMedia");
	}

}
