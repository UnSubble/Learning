package response;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/download")
public class ResponseDownloadServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Content-Disposition", "attachment; filename=test.xlxsx");
		ServletOutputStream out = resp.getOutputStream();
		try (InputStream in = getServletContext().getResourceAsStream("myExcel.xlsx")) {
			byte[] content = new byte[1024];
			int read = 0;
			while ((read = in.read(content)) != -1) {
				out.write(content, 0, read);
			}
		}
	}
}
