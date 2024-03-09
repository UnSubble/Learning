package listener;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpServletRequest;

@WebListener
public class ServletRequestListenerImpl implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("requestDestroyed...");
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("requestInitialized");
		HttpServletRequest req = (HttpServletRequest) sre.getServletRequest();
		String path = req.getServletPath();
		String ip = req.getRemoteAddr();
		System.out.println(path);
		System.out.println(ip);
	}
}
