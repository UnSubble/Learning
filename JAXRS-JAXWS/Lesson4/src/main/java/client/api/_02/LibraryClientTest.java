package client.api._02;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

public class LibraryClientTest {

	public static void main(String[] args) {
		String URI = "http://localhost:8080/Lesson4/resteasy/library-client-api/book/{id}";
		
		Client client = ClientBuilder.newBuilder().build();
		WebTarget target = client.target(URI).resolveTemplate("id", 1); // pathparam vermek için kullanılır.
		Invocation.Builder builder = target.request();
		Response response = builder.get();
		Book book = response.readEntity(Book.class);
		System.out.println(book.getName());
		
		Response response2 = builder.get();
		Book book2 = response2.readEntity(new GenericType<Book>() {});
		System.out.println(book2.getName());
	}
}
