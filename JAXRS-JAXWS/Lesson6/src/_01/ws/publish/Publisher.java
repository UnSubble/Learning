package _01.ws.publish;

import javax.xml.ws.Endpoint;

import _01.ws.service.HelloMyServiceImpl;

public class Publisher {

	public static void main(String[] args) {
		String address = "http://localhost:8080/lesson6/hello.service";
		Endpoint.publish(address, new HelloMyServiceImpl());
		System.out.println("Web service is running...");
	}
}
