package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Department;
import model.Employee;

@WebServlet(urlPatterns = "/employee")
public class EmployeeController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Department department = new Department();
		department.setId(100);
		department.setName("Software Engineering");

		Employee employee = new Employee();
		employee.setId(1);
		employee.setName("anil");
		employee.setSalary(25000);
		employee.setDepartment(department);

		req.setAttribute("employeeAttribute", employee);

		Map<String, String> map = new HashMap<>();
		map.put("key1", "value1");
		map.put("key2", "value2");
		map.put("key3", "value3");

		req.setAttribute("myMap", map);

		List<String> list = new ArrayList<>();
		list.add("asd");
		list.add("value2");

		req.setAttribute("myList", list);

		int[] arr = { 1, 2, 3, 4, 5 };
		
		req.setAttribute("myArray", arr);

		RequestDispatcher dispatcher = req.getRequestDispatcher("employee.jsp");
		dispatcher.forward(req, resp);
	}
}
