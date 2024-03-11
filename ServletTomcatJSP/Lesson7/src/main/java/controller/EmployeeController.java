package controller;

import java.io.IOException;
import java.util.List;

import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Employee;

@WebServlet(urlPatterns = "/employeeController")
public class EmployeeController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("employeeId"));
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		employeeDAO.removeEmployee(id);
		
		List<Employee> employeeList = employeeDAO.getEmployees();
		req.setAttribute("allEmployees", employeeList);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("employee.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String surname = req.getParameter("surname");
		int salary = Integer.parseInt(req.getParameter("salary"));
		
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		employeeDAO.insertEmployee(name, surname, salary);
		
		List<Employee> employeeList = employeeDAO.getEmployees();
		req.setAttribute("allEmployees", employeeList);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("employee.jsp");
		dispatcher.forward(req, resp);
	}
}
