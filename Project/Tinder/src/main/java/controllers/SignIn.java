package controllers;

import java.io.IOException;
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
		String longtitude = request.getParameter("longitude");
		String latitude = request.getParameter("latitude");

		try {
			boolean isExisting = UserDAO.isUserExisting(username, password);
			if(isExisting){
				HttpSession session = request.getSession(true);
				User user = UserDAO.getUser(username);
				session.setAttribute("user", user);
				response.sendRedirect("./Home");
			}
			else{
				throw new ServletException("Ivalid username or password!");
			}
			
		} catch (DBException e) {
			e.printStackTrace();
			request.setAttribute("errorMassage", e.getMessage());
			request.getRequestDispatcher("WEB-INF/jsp/error.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
			request.setAttribute("errorMassage", e.getMessage());
			request.getRequestDispatcher("WEB-INF/html/login.html").forward(request, response);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("./Home");
	}

}
