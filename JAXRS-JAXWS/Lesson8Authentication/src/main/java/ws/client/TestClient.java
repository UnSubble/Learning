package ws.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.handler.MessageContext;

import ws.exception.OrderWSException;
import ws.model.Order;
import ws.service.OrderWS;

public class TestClient {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws MalformedURLException, OrderWSException {
		System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
		
		URL url = new URL("http://localhost:8080/lesson8/orderws?wsdl");
		QName qname = new QName("http://service.ws/", "OrderWSImplService");
		Service service = Service .create(url,qname);

		OrderWS orderWS = service.getPort(OrderWS.class);
		
		Map<String, Object> requestContext = ((BindingProvider)orderWS).getRequestContext();

		Map<String, List<String>> requestHeaders = new HashMap<>();

		requestHeaders.put("username", Arrays.asList("admin"));
		requestHeaders.put("password", Arrays.asList("123456"));

		requestContext.put(MessageContext.HTTP_REQUEST_HEADERS, requestHeaders);

		Order order1 = orderWS.getOrder("Order-100");
		System.out.println(order1);
	}
}
