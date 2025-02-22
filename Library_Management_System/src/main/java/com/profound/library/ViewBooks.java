package com.profound.library;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ViewBooks")
public class ViewBooks extends HttpServlet {
	
	public ViewBooks() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>View Book</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		out.println("<style>#bs-example-navbar-collapse-1{background: linear-gradient(to top left,red,blue);}</style>");
		out.println("<style>#bs-example-navbar-collapse-1{color:white);}</style>");
		request.getRequestDispatcher("navlibrarian.html").include(request, response);
		out.println(
				"<style>@import url('https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,400;0,500;1,400;1,500&display=swap</style>");
		out.println("<div class='container'>");
		out.print("<style>.container{font-family: 'Poppins', sans-serif;}</style>");

		List<BookBean> list = BookDao.view();

		out.println("<table class='table table-bordered table-striped'>");
		out.println(
				"<tr><th>Book Id</th><th>Name</th><th>Author</th><th>Quantity</th><th>Issued</th><th>Delete</th></tr>");
		out.print("<style>th{background-color:aqua;}</style>");
		for (BookBean bean : list) {
			out.println("<tr><td>" + bean.getBookID() + "</td><td>" + bean.getName() + "</td><td>" + bean.getAuthor()
					+ "<font color:green></td><td>" + bean.getQuantity() + "</td><td></font>" + bean.getIssued()
					+ "</td><td><a href='DeleteBook?callno=" + bean.getBookID() + "'>Delete</a></td></tr>");
		}
		out.println("</table>");

		out.println("</div>");

		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}
}
