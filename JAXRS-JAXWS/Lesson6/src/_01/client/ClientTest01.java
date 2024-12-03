package _01.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import _01.ws.service.HelloMyService;

public class ClientTest01 {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws MalformedURLException {
		String address = "http://localhost:8080/lesson6/hello.service";
		URL url = new URL(address);
		QName qname = new QName("http://service.ws._01/", "HelloMyServiceImplService");
		Service service = Service.create(url, qname);
		
		HelloMyService myService = service.getPort(HelloMyService.class);
		String msg = myService.getWelcomeMessage("test name", "test surname");
		System.out.println(msg);
	}
}
