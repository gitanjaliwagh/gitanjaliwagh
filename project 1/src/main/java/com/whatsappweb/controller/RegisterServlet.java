package com.whatsappweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.whatsappweb.controller.RegisterServlet;
import com.whatsappweb.dao.WhatsappDAOInterface;
import com.whatsappweb.entity.WhatsappUser;
import com.whatsappweb.utility.DAOFactory;



public class RegisterServlet extends HttpServlet {
	private static Logger log = Logger.getLogger(RegisterServlet.class);
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("entering into RegisterServlet file");
		
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		String age=request.getParameter("age");
		String email=request.getParameter("email");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		WhatsappUser wu=new WhatsappUser();
		
		wu.setName(name);
		wu.setPhone(phone);
		wu.setAge(age);
		wu.setEmail(email);
		wu.setUsername(username);
		wu.setPassword(password);
		
		WhatsappDAOInterface wd=DAOFactory.createObjectHibernate();
		
		int i=wd.createProfileDAO(wu);
		
		log.info("getting value of i from dao "+i);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html>");
		if(i>0) {
			out.println("<head>");
			out.println("<link rel=\"stylesheet\" href=\"Congrats.css\"><title>Insert title here</title>");
			out.println("</head>");
			out.println("<body><div class=\"container\">" );
			out.println("<div class=\"bg-circles\">");
			out.println("<div id=\"circle-1\"></div><div id=\"circle-2\"></div><div id=\"circle-3\"></div>");
			out.println("</div>");
			out.println("<h1 id=\"title\">Congratulations </h1>");
			out.println("<p class=\"conf-text\">You have been registered successfully.Thank you for starting your journey with us.</p>");
			out.println("<button id=\"btn-continue\"><a href=\"Login.html\">Login</a></button>");
			out.println("</div></body>");
		}
		else {
			out.println("<font size=5 color=red><b>Registration Fail try again</b></font>");
		}
		out.println("</html>");
	}

}
