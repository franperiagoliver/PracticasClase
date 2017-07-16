package com.bpe.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class PersonServlet
 */
public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String dataTitle;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init");
		dataTitle = config.getInitParameter("dataTitle");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String number = request.getParameter("number");
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		pw.println("<html>");
		pw.println("<head><title>Person</title></head>");
		pw.println("<body>");
		if (dataTitle.isEmpty()) {
			pw.println("<h3>Person data</h3>");
		}
		else {
			pw.println("<h3>" + dataTitle + "</h3>");
		}
		pw.println("<table border='1' cellspacing='5'>");
		pw.println("<tr>");
		if (name.isEmpty()) {
			pw.println("<th>Name:</th><td>&nbsp</td>");
		}
		else {
			pw.println("<th>Name:</th><td>" + name + "</td>");
		}
		pw.println("</tr>");
		pw.println("<tr>");
		if (number.isEmpty()) {
			pw.println("<th>Number:</th><td>&nbsp</td>");
		}
		else {
			pw.println("<th>Number:</th><td>" + number + "</td>");
		}
		pw.println("</tr>");
		pw.println("</table>");
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		
		
	}

}
