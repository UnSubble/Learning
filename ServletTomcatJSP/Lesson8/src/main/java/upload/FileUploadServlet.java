package upload;

import java.util.Collection;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig
@WebServlet("/file.upload")
public class FileUploadServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Collection<Part> parts = request.getParts();
			for (Part part : parts) {
				System.out.println(part.getSubmittedFileName());
				part.write("C:/Users/user/Desktop/fileUpload/" + part.getSubmittedFileName());
			}

			request.setAttribute("message", "The file has been uploaded successfully.");
		} catch (Exception e) {
			request.setAttribute("message", "FATAL");
		}

		request.getRequestDispatcher("/result.jsp").forward(request, response);

	}
}
