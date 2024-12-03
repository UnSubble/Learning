package _01.ws.service;

import javax.jws.WebService;

@WebService(endpointInterface = "_01.ws.service.HelloMyService")
public class HelloMyServiceImpl implements HelloMyService {

	@Override
	public String getWelcomeMessage(String name, String surname) {
		return "Welcome, " + name + ", " + surname;
	}

}
