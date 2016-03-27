package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exceptions.DBException;
import model.DAO.UserDAO;
import model.POJO.User;

public class DiscoverySettings extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (Home.checkValidSession(request, response)) {
			request.getRequestDispatcher("WEB-INF/jsp/discovery-settings.jsp").forward(request, response);
		}
		else{
			response.sendRedirect("./Home");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (Home.checkValidSession(request, response)) {
			int dist = Integer.parseInt(request.getParameter("search-distance"));
			int minAge = Integer.parseInt(request.getParameter("age-range").trim().split(";")[0]);
			int maxAge = Integer.parseInt(request.getParameter("age-range").trim().split(";")[1]);
			boolean showFemale = request.getParameter("show-women").equals("on")?true:false;
			boolean showMale = request.getParameter("show-men").equals("on")?true:false;
			try {
				UserDAO.setUserDiscoverySettings(((User)request.getSession(false).getAttribute("user")).getId(),
						showMale, showFemale, dist, minAge, maxAge);
			} catch (DBException e) {
				e.printStackTrace();
			}
			
		}
		doGet(request, response);
	}

}