package com.profound.library;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AddBook")
public class AddBook extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Add Book Form</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("navlibrarian.html").include(request, response);
		
		out.println("<div class='container'>");
		int bookid=Integer.parseInt(request.getParameter("bookid"));
		String name=request.getParameter("name");
		String author=request.getParameter("author");
		String squantity=request.getParameter("quantity");
		int quantity=Integer.parseInt(squantity);
		BookBean bean=new BookBean(name,author,quantity,bookid);
		int i=BookDao.save(bean);
		if(i>0){
			out.println("<h3 style='color:green'>Book saved successfully</h3>");
		}
		request.getRequestDispatcher("addbookform.html").include(request, response);
		out.println("</div>");
		
		
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}

}
