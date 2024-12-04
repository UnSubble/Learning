package ws.publisher;

import javax.xml.ws.Endpoint;

import ws.service.OrderWSImpl;

public class WebServicePublisher {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8080/lesson8/orderws", new OrderWSImpl());
		System.out.println("WebServicePublisher is starting....");
	}
}
