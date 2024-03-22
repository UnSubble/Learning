package com.unsubble.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.unsubble.entity.Employee;
import com.unsubble.service.EmployeeService;
import com.unsubble.service.EmployeeServiceImpl;

@WebServlet("/employeeController")
public class EmployeeServlet extends HttpServlet {
	
	private final EmployeeService employeeService = new EmployeeServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("employeeId"));
		
		employeeService.remove(id);
		
		List<Employee> allEmployees = employeeService.findAll();
		req.setAttribute("allEmployees", allEmployees);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("employee.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String surname = req.getParameter("surname");
		int salary = Integer.parseInt(req.getParameter("salary"));
		
		Employee employee = new Employee(name, surname, salary);
		employeeService.save(employee);
		
		List<Employee> allEmployees = employeeService.findAll();
		req.setAttribute("allEmployees", allEmployees);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("employee.jsp");
		dispatcher.forward(req, resp);
	}
}
