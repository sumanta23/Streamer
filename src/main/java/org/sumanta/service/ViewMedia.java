package org.sumanta.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sumanta.bean.Media;
import org.sumanta.dao.manageMedia;

/**
 * Servlet implementation class ViewMedia
 */
@WebServlet("/ViewMedia")
public class ViewMedia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewMedia() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Media> mediaArray=new ArrayList<Media>();
		manageMedia std=new manageMedia();
		
		mediaArray=(ArrayList<Media>) std.viewMedia();
		
		request.setAttribute("mediadetails", mediaArray);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/viewmedia.jsp");
		   dispatcher.forward( request, response );
	}

}
