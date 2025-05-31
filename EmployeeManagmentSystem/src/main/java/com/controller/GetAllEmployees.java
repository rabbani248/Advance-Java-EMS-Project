package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDAO;
import com.model.Employee;


@WebServlet("/findAll")
public class GetAllEmployees extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		EmployeeDAO dao = new EmployeeDAO();
		try {
			List<Employee> empList = dao.findAll();
			Iterator<Employee> it = empList.iterator();
			while(it.hasNext()) {
				System.out.println(it.next());
				System.out.println();
			}
			request.setAttribute("empList", empList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("viewemps.jsp");
			dispatcher.forward(request, response);
		}
		catch(ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}
	}

}
