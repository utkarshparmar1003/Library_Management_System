package com.profound.library;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
       
    public AddStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int roll=Integer.parseInt(request.getParameter("rno"));
		String name=request.getParameter("name");
		String branch=request.getParameter("branch");
		String year=request.getParameter("year");
		String address=request.getParameter("address");
		String pwd=request.getParameter("pwd");
		String email=request.getParameter("email");
		String phone=request.getParameter("ph");
		String uname=request.getParameter("usr");
		StudentDao sd = new StudentDao();
		
		sd.insertStudent(roll,name,branch,year,address,pwd,email,phone,uname);
		request.getRequestDispatcher("index.html").include(request, response);

	}

}