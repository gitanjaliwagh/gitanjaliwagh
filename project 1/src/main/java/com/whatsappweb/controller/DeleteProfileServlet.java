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

/**
 * Servlet implementation class DeleteProfileServlet
 */
public class DeleteProfileServlet extends HttpServlet {
	private static Logger log = Logger.getLogger(DeleteProfileServlet.class);

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	log.info("entering into DeleteProfileServlet file");
	HttpSession ss=request.getSession(true);
	Object oo1=ss.getAttribute("username");
	WhatsappUser wu=new WhatsappUser();
	wu.setUsername(oo1.toString());
	
    WhatsappDAOInterface wd=DAOFactory.createObjectHibernate();

	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	out.println("<html><head><link rel=\"stylesheet\" href=\"Dashboard.css\" >");
	out.println("<title>Delete Page</title>");
	out.println("</head>");
	out.println("<body class=\"delete\">");
	
	out.println("");
	
	out.println("<form method=post action=DeleteProfileServlet class=\"form\">  ");
	out.println("<button type=button><a href=DashboardServlet class=\"back\">Back</a></button>");
	out.println("<font color=red><h2><center> Delete Profile</center></h2></font>");
	out.println("Username : <input type=text name=username id=username value=" +oo1.toString()+ " disabled><br><br></tr></td>");
	out.println("Password : <input type=password name=password id=password placeholder='Enter the password'><br><br></tr></td>");
	out.println("<button class=\"btn-delete\" type=submit onclick=\"ConfirmDelete()\">Delete</button>");
	out.println("</form> </table> ");
	out.println("<script>function ConfirmDelete() {");  
	out.println("  var x = confirm(\"Are you sure you want to delete?\");");
	out.println("  if (x) {return true;}");
	out.println("  else { return false;}"); 
	out.println("}</script>");
	out.println("</center></body></html>");

	String password = request.getParameter("password");
	//System.out.println(oo1.toString());

	wu.setPassword(password);
	int i = wd.deleteProfile(wu);
	out.println("<html><body><center><br><br>");
	if (i > 0) {
		RequestDispatcher rd=getServletContext().getRequestDispatcher("/Register.html");
		rd.forward(request, response);
		out.println("<font=5 color=orange><b>Profile Deleted Succesfully.</b></font>");

	} else if (password != null) {
		out.println("Please enter your password to continue");
	}

	out.println("</center></body></html>");	
	}
	

}
