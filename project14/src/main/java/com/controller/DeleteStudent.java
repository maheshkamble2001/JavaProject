package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import com.utility.StudentDao;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import com.model.Student;

@WebServlet("/DeleteStudent")
public class DeleteStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pr = response.getWriter();
		
		Student st = new Student();
		st.setRollNo(Integer.parseInt(request.getParameter("id")));
		if(new StudentDao().deleteStudent(st)>0)
		{
			pr.print("<h1>Data deleted successfully!</h1>");
			RequestDispatcher rd = request.getRequestDispatcher("/ReadStudent");
			rd.include(request,response);
		}
		else {
			pr.print("<h1>Data failed to delete </h1>");
			RequestDispatcher rd = request.getRequestDispatcher("/ReadStudent");
			rd.include(request,response);
		}
	}

}
