package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exceptions.DBException;
import model.DAO.UserDAO;

public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("./Home");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			UserDAO.registerUser(request.getParameter("username"), request.getParameter("password"),
					request.getParameter("email"), Boolean.parseBoolean(request.getParameter("gender")),
					Integer.parseInt(request.getParameter("age")));
			response.sendRedirect("./Home");
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", e.getMessage());
			request.getRequestDispatcher("WEB-INF/jsp/error.jsp").forward(request, response);
		}
	}

}
