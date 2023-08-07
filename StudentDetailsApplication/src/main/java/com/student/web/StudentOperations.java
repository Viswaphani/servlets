package com.student.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.ArrayList;
import com.student.model.Student;
import com.student.dao.DAOImpl;
import com.student.dao.DAOInterface;

public class StudentOperations extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StudentOperations() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String operation = request.getParameter("Operation");
		List<Student> studentList;
		RequestDispatcher view = null;
		if(operation.equals("AddOperation")) {
			view = request.getRequestDispatcher("AddOperation.html");
		}else if(operation.equals("SearchOperation")) {
			view = request.getRequestDispatcher("SearchOperation.html");
		}else if(operation.equals("DeleteOperation")) {
			view = request.getRequestDispatcher("DeleteOperation.html");
		}else if(operation.equals("UpdateOperation")) {
			view = request.getRequestDispatcher("UpdateOperation.html");
		}
		view.forward(request, response);
	}
}
