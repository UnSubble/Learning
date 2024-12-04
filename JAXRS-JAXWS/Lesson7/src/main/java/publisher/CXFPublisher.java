package publisher;

import org.apache.cxf.frontend.ServerFactoryBean;

import service.HelloMyService;
import service.HelloMyServiceImpl;

public class CXFPublisher {

	public static void main(String[] args) {
		String address = "http://localhost:8000/hello.cxf";

		ServerFactoryBean factory = new ServerFactoryBean();
		HelloMyServiceImpl helloService = new HelloMyServiceImpl();
		//

		factory.setServiceClass(HelloMyService.class);
		factory.setAddress(address);
		factory.setServiceBean(helloService);
		factory.create();

		System.out.println("CXF web service is publishing....");
	}
}
