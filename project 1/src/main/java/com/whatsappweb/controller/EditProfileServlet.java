package com.whatsappweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.whatsappweb.dao.WhatsappDAOInterface;
import com.whatsappweb.entity.WhatsappUser;
import com.whatsappweb.utility.DAOFactory;


public class EditProfileServlet extends HttpServlet {
	private static Logger log = Logger.getLogger(EditProfileServlet.class);
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		log.info("entering into EditProfileServlet file");
		HttpSession ss=request.getSession(true);
		Object oo1=ss.getAttribute("username");
		WhatsappUser wu=new WhatsappUser();
		wu.setUsername(oo1.toString());
		WhatsappDAOInterface wd=DAOFactory.createObjectHibernate();
		
		WhatsappUser b=wd.viewProfileDAO(wu);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body><center><br><br>");
			if(b!=null) {
				
				
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/Edit.html");
				rd.include(request, response);
				
			}
			else {
				out.println("profile not found");
			}
			
			
		out.println("</center></body></html>");
		
		
		
		
		
		  out.println("</center></body></html>"); 
		  if (b != null) { 
			  String name1 =request.getParameter("fname");
		  String phone1 = request.getParameter("phone"); 
		  String age1 =request.getParameter("age"); 
		  String email1 = request.getParameter("email");
		  
		  String password1 =request.getParameter("password"); 
		  wu.setName(name1);
		  wu.setPhone(phone1);
		  wu.setAge(age1); 
		  wu.setEmail(email1); 
		  wu.setUsername(oo1.toString());
		  wu.setPassword(password1);
		  
		  int i = wd.editProfileDAO(wu); 
		  
		  log.info("getting value of i from dao "+i);
		  response.setContentType("text/html");
		  
		  out.println("<html><body><center><br><br>");
		  
		  if (i > 0) {
			  RequestDispatcher rd=getServletContext().getRequestDispatcher("/ViewProfileServelt");
				rd.include(request, response);
		  out.println("<font size=6 color=white><b>Profile Edited Successfully</font>"); 
		  }
		  else {
		  out.println("<font size=6 color=white><b>Something gone wrong</font>");
		  
		  }
		  
		  }
		 
		out.println("</center></body></html>");

	}
}

