package com.student.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.dao.DAOImpl;
import com.student.dao.DAOInterface;
import com.student.model.Student;

public class SearchOperationServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String filter = request.getParameter("filter");
		DAOInterface dao = new DAOImpl();
		RequestDispatcher view;
		List<Student> allStudents = null;
		if(filter.equals("NoFilter")) {
			allStudents = dao.viewAllStudents();
			request.setAttribute("StudentList", allStudents);
		}
		/*response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("name " + allStudents.get(0).getName() + "marks " + allStudents.get(0).getMarks() + "id " +
				allStudents.get(0).getId() + "city " + allStudents.get(0).getCity());*/
		view = request.getRequestDispatcher("ShowList.jsp");
		view.forward(request, response);
	}
}
