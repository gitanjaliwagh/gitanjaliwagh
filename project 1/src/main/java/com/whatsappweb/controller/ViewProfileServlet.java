package com.whatsappweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.whatsappweb.dao.WhatsappDAOInterface;
import com.whatsappweb.entity.WhatsappUser;
import com.whatsappweb.utility.DAOFactory;


public class ViewProfileServlet extends HttpServlet {
	private static Logger log = Logger.getLogger(ViewProfileServlet.class);

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("entering into ViewProfileServlet file");
		HttpSession ss=request.getSession(true);
		Object oo1=ss.getAttribute("username");
		WhatsappUser wu=new WhatsappUser();
		wu.setUsername(oo1.toString());
		
        WhatsappDAOInterface wd=DAOFactory.createObjectHibernate();
		
		WhatsappUser b=wd.viewProfileDAO(wu);
		log.info("getting value of b from dao "+b);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html>");
			if(b!=null) {
				
				out.println("<head><link rel=\"stylesheet\" href=\"Dashboard.css\" >");
				out.println("<title>View Profile</title>");
				out.println("</head>");
				out.println("<body class=\"bg\">");
				out.println("<div class=\"viewdetails\">");
				out.println("<a href=DashboardServlet class=\"back\">Back</a>");
				out.println("<h2>"+b.getUsername()+"</h2><hr>");
				out.println("<div class=\"data\">");
				out.println("<p><b>Name:</b>"+b.getName()+"</p>");
				out.println("<p><b>Phone Number:</b>"+b.getPhone()+"</p>");
				out.println("<p><b>Age:</b>"+b.getAge()+"</p>");
				out.println("<p><b>Email Address:</b>"+b.getEmail()+"</p>");
				out.println("<p><b>Password:</b>"+b.getPassword()+"</p>");
				out.println("<button class=\"btn-edit\"><a href=EditProfileServlet class=\"btn\">Edit</a></button></div>");
				out.println("</div>");
				out.println("</body>");
				
		
				
			}
			else {
				out.println("profile not found");
			}
		out.println("</center></body></html>");
	}

}
