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

@WebServlet("/DeleteRow")
public class DeleteOperationServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public DeleteOperationServ() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOInterface dao = new DAOImpl();
		int id = Integer.parseInt(request.getParameter("Id"));
		dao.deleteStudent(id);
		RequestDispatcher view = request.getRequestDispatcher("OperationsMenu.html");
		view.forward(request, response);
	}
}
