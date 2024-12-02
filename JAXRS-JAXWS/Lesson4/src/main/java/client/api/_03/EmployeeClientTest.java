package client.api._03;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class EmployeeClientTest {

	public static void main(String[] args) {
		String URI = "http://localhost:8080/Lesson4/resteasy/employee-client-api/addEmployee";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URI);
		Invocation.Builder builder = target.request();
		Entity<Employee> jsonEntity = Entity.json(new Employee(1, "name", "surname"));
		Response response = builder.post(jsonEntity);
		System.out.println(response.readEntity(String.class));
		
		String URI2 = "http://localhost:8080/Lesson4/resteasy/employee-client-api/addEmployeeXML";
		Client client2 = ClientBuilder.newClient();
		WebTarget target2 = client2.target(URI2);
		Invocation.Builder builder2 = target2.request();
		Entity<Employee> xmlEntity = Entity.xml(new Employee(1, "name", "surname"));
		Response response2 = builder2.post(xmlEntity);
		System.out.println(response2.readEntity(String.class));

	}
}
