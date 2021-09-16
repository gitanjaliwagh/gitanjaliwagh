package com.whatsappweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;


public class DashboardServlet extends HttpServlet {
	private static Logger log = Logger.getLogger(DashboardServlet.class);

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("entering into DashboardServlet file");
		
		ServletContext sc=getServletContext();
		Object oo=sc.getAttribute("username");
		HttpSession ss=request.getSession(true);
		Object oo1=ss.getAttribute("pwd");
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		RequestDispatcher rd=getServletContext().getRequestDispatcher("/Dashboard.html");
		rd.forward(request, response);
		out.println("<head>");
		 out.println("<title>Dashboard</title></head>");
		 out.println("<body><br><br><br><br><br><br><br>");
		out.println("<center><h3>Welcome "+oo1+"<h3></center>");
		 out.println("</body></html>");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		 * out.println("<html>");
		 * out.println("<head><link rel=\"stylesheet\" href=\"Dashboard.css\" >");
		 * out.println("<title>Dashboard</title></head>");
		 * out.println("<body><br><br>");
		 * 
		 * out.println("<center><h1>Welcome"+" "+oo+"</h1> "); out.
		 * println("<a href=ViewProfileServlet class=\"view\"> view profile</a><br><a href=Edit.html class=\"view\"> Edit profile</a><br>"
		 * ); out.println("<a href=LogoutSevlet class=\"view\"> Logout</a><br>");
		 * out.println("<a href=DeleteProfileServlet class=\"view\"> Delete Profile</a>"
		 * ); out.println("</center></body></html>");
		 */
	}

}
