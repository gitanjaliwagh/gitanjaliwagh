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

import com.whatsappweb.dao.WhatsappDAOInterface;
import com.whatsappweb.entity.WhatsappUser;
import com.whatsappweb.utility.DAOFactory;
public class LoginServlet extends HttpServlet {
	
	private static Logger log = Logger.getLogger(LoginServlet.class);
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("entering into LoginServlet file");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		WhatsappUser wu=new WhatsappUser();
		wu.setUsername(username);
		wu.setPassword(password);
		
		WhatsappDAOInterface wd=DAOFactory.createObjectHibernate();
        boolean b=wd.loginProfileDAO(wu);
        log.info("getting value of b from dao "+b);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body><center>");
		if(b) {
			
			ServletContext sc=getServletContext();
			sc.setAttribute("username", username);
			
			HttpSession ss=request.getSession(true);
			ss.setAttribute("username", username);
			ss.setAttribute("pwd", password);
			
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/Dashboard.html");
			rd.include(request, response);
			
			out.println("<br><br><br><br>");
			out.println("<center><h1>welcome "+wu.getUsername()+"</h1></center>");
			
			
		}
		else {
			out.println("<font color=red><b>Invalid id and password</b></font>");
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/Login.html");
			rd.include(request,response);
		}
		out.println("</center></body></html>");		
	}
	

}
