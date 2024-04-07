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


@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddStudent() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pr = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		double marks = Double.parseDouble(request.getParameter("marks"));
		Student st = new Student(id,name,marks);
		
		StudentDao  sd = new StudentDao();
		if(sd.addStudent(st)>0)
		{
			pr.print("<h1> Data added successfully!</h1>");
			RequestDispatcher rd = request.getRequestDispatcher("/ReadStudent");
			rd.include(request,response);
		}
		else {
			pr.print("<h1> Data failed to add </h1>");
			RequestDispatcher rd = request.getRequestDispatcher("/ReadStudent");
			rd.include(request,response);
		}
		
	}

}
