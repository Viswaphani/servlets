package com.student.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.dao.DAOImpl;
import com.student.dao.DAOInterface;
import com.student.model.Student;

public class UpdateOperationServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateOperationServ() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		DAOInterface dao = new DAOImpl();
		String name = request.getParameter("Name");
		int id = Integer.parseInt(request.getParameter("Id"));
		int marks = Integer.parseInt(request.getParameter("Marks"));
		String city = request.getParameter("City");
		
		Student st = new Student(id, marks, name, city);
		dao.updateStudent(st);
		
		RequestDispatcher view = request.getRequestDispatcher("OperationsMenu.html");
		view.forward(request, response);
	}
}
