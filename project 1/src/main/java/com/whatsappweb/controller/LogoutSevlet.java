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

public class LogoutSevlet extends HttpServlet {
	

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		RequestDispatcher rd=getServletContext().getRequestDispatcher("/Login.html");
		rd.include(request, response);
		
		HttpSession session=request.getSession();
		session.invalidate();
		
		out.println("<html><body><center><br><br>");
		out.println("<font color=white><b>You are successfully logged out</b><br>");
		out.println("Please login again</font>");
		out.println("</center></body></html>");		
		out.close();
		
		
		
	}

}
