package com.student.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.student.model.Student;
import com.student.dao.DAOImpl;
import com.student.dao.DAOInterface;

public class AddOperationserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public AddOperationserv() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		DAOInterface dao = new DAOImpl();
		String name = request.getParameter("Name");
		int id = Integer.parseInt(request.getParameter("Id"));
		int marks = Integer.parseInt(request.getParameter("Marks"));
		String city = request.getParameter("City");
		
		/*response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("name " + name + "marks " + marks + "id " + id + "city " + city);*/
		
		Student st = new Student(id, marks, name, city);
		dao.addStudent(st);
		
		RequestDispatcher view = request.getRequestDispatcher("OperationsMenu.html");
		view.forward(request, response);
	}
}
