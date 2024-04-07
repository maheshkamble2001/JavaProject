package com.controller;

import java.io.IOException;
import com.model.Student;
import com.utility.StudentDao;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.PrintWriter;
@WebServlet("/ReadStudent")
public class ReadStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pr = response.getWriter();
		
		List<Student> list =new StudentDao().getAllStudent();
		
		Iterator<Student> itr = list.iterator();
		pr.print("<table>");
		pr.print("<tr>");
		pr.print("<th> ID </th>");
		pr.print("<th> NAME </th>");
		pr.print("<th> MARKS </th>");
		pr.print("</tr>");
		
		while(itr.hasNext()) {
			Student student=itr.next();
			pr.print("<tr>");
			pr.print("<td>"+student.getRollNo()+"</td>");
			pr.print("<td>"+student.getName()+"</td>");
			pr.print("<td>"+student.getMarks()+"</td>");
			pr.print("<td>");
			pr.print("<a href='DeleteStudent?id="+student.getRollNo()+"&name="+student.getName()+"&marks="+student.getMarks()+"' >Delete</a>");
			pr.print("</td>");
			pr.print("<td>");
			pr.print("<a href='UpdateStudent.html?id="+student.getRollNo()+"&name="+student.getName()+"&marks="+student.getMarks()+"' >Update</a>");
			pr.print("</td>");
			pr.print("</tr>");
		}
		pr.print("<tr>");
		pr.print("<a href='AddInfo.html' > Add student </a>");
		pr.print("</tr>");
		pr.print("</table>");
	}

}
