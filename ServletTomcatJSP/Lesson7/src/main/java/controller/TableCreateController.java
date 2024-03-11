package controller;

import java.io.IOException;

import dao.ConnectionManager;
import dao.TableCreator;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/createTable")
public class TableCreateController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TableCreator.createTable(new ConnectionManager().getMySQLDataSource());
	}
}
