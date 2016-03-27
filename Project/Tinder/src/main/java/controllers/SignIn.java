package controllers;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;

import exceptions.DBException;
import model.DAO.UserDAO;
import model.POJO.User;

public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String longitude = request.getParameter("longitude");
		String latitude = request.getParameter("latitude");
		try {
			boolean isExisting = UserDAO.isUserAndPassExisting(username, password);
			if (isExisting) {
				HttpSession session = request.getSession();
				UserDAO.setLocation(username, Double.parseDouble(latitude), Double.parseDouble(longitude));
				User user = UserDAO.getUser(username);
				session.setAttribute("user", user);
				session.setAttribute("userCandidates", new LinkedList<User>());
				response.sendRedirect("./Home");
			} else {
				throw new ServletException("Ivalid username or password! :" + username + " " + password);
			}

		} catch (DBException e) {
			e.printStackTrace();
			request.setAttribute("errorMassage", e.getMessage());
			request.getRequestDispatcher("WEB-INF/jsp/error.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
			request.setAttribute("errorMassage", e.getMessage());
			request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request, response);
		}
	}

}
