package client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import model.Employee;
import ws.service.EmployeeService;

public class ClientTest01 {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws MalformedURLException {
		String address = "http://localhost:8080/Lesson6Tomcat/employeeServiceWS";
		URL url = new URL(address);
		QName qname = new QName("http://service.ws/", "EmployeeServiceImplService");
		Service service = Service.create(url, qname);
		
		EmployeeService myService = service.getPort(EmployeeService.class);
		myService.addEmployee(new Employee(1, "test", "test", 54));
		Employee e = myService.getEmployee(1);
		System.out.println(e);
	}
}
