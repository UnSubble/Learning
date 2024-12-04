package service;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface HelloMyService {

	@WebMethod
	public String getWelcomeMessage(String name, String surname);
}
