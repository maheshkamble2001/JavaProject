package com.controller;

import com.model.Student;
import com.utility.StudentDao;

import java.io.PrintWriter;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class UpdateStudent
 */
@WebServlet("/UpdateStudent")
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pr = response.getWriter();
		
		if(new StudentDao().updateStudent(new Student(Integer.parseInt(request.getParameter("id")),request.getParameter("name"),Double.parseDouble(request.getParameter("marks"))))>0)
		{
			pr.print("<h1>Data updated successfully</h1>");
			RequestDispatcher rd = request.getRequestDispatcher("/ReadStudent");
			rd.include(request,response);
		}
		else {
			pr.print("<h1>Data failed to update</h1>");
			RequestDispatcher rd = request.getRequestDispatcher("/ReadStudent");
			rd.include(request,response);
		}
	}

}
