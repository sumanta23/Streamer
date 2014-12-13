package org.sumanta.service;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sumanta.bean.Media;
import org.sumanta.dao.manageMedia;

/**
 * Servlet implementation class Player
 */
@WebServlet("/Player")
public class Player extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Player() {
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
		Media media=mngmda.singleMediaDetails(id);
		String path=media.getPath();
		String fileName=path;
		System.out.println(fileName);
		ServletOutputStream stream = null;
	    BufferedInputStream buf = null;
	    
	    try {
	      stream = response.getOutputStream();
	      File file = new File(fileName);
		
		if(path.substring(path.lastIndexOf(".")).equals("mp3"))
		{
			 response.setContentType("audio/mpeg3");
		}
		else if(path.substring(path.lastIndexOf(".")).equals("mp4"))
		{
			response.setContentType("vedio/mpeg4");
		}
	
	     
	      response.addHeader("Content-Disposition", "filename=" + fileName);

	      response.setContentLength((int) file.length());

	      FileInputStream input = new FileInputStream(file);
	      buf = new BufferedInputStream(input);
	      int readBytes = 0;
	      //read from the file; write to the ServletOutputStream
	      while ((readBytes = buf.read()) != -1)
	        stream.write(readBytes);
	    } catch (IOException ioe) {
	      throw new ServletException(ioe.getMessage());
	    } finally {
	      if (stream != null)
	        stream.close();
	      if (buf != null)
	        buf.close();
	    }
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
