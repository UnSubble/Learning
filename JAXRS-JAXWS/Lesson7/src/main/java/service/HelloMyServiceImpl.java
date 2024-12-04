package service;
public class HelloMyServiceImpl implements HelloMyService {

	@Override
	public String getWelcomeMessage(String name, String surname) {
		return "Welcome " + name + " " + surname + ", This is first example!";
	}

}
