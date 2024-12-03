package ws.service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import model.Employee;

@WebService(endpointInterface = "ws.service.EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {
	
	public static List<Employee> employees = new ArrayList<>();

	@Override
	public void addEmployee(Employee employee) {
		employees.add(employee);
	}

	@Override
	public Employee getEmployee(int id) {
		return employees.stream().filter(x -> x.getId() == id).findFirst().get();
	}

}
