package client.api._01;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

public class MessageClientTest {

	public static void main(String[] args) {
		String URI = "http://localhost:8080/Lesson4/resteasy/message-client-api/message";
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URI);
		Invocation.Builder builder = target.request();
		String message = builder.get(String.class);
		System.out.println(message);
		
		URI = "http://localhost:8080/Lesson4/resteasy/message-client-api/messages";
		client = ClientBuilder.newClient();
		target = client.target(URI);
		builder = target.request();
		List<String> result = builder.get(new GenericType<List<String>>() {});
		System.out.println(result);
	}
}
