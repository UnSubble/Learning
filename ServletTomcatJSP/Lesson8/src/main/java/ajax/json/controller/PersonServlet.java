package ajax.json.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import com.google.gson.Gson;

import ajax.json.model.Person;
import ajax.json.model.Result;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/person.servlet")
public class PersonServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		
		StringBuffer jsonData = new StringBuffer();
		String line = "";
		
		while((line = br.readLine()) != null) {
			jsonData.append(line);
		}
		
		Gson gson = new Gson();
		System.out.println(gson.fromJson(jsonData.toString(), Person.class));
		
		Result result = new Result();
		result.setMessage("Basarili!");
		result.setReturnCode("200");
		
		String resultJson = gson.toJson(result);
		System.out.println(resultJson);
		
		PrintWriter pw = resp.getWriter();
		pw.println(resultJson);
		pw.close();
	}
}
