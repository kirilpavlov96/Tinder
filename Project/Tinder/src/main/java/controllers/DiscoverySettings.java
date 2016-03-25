package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DiscoverySettings extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/jsp/discovery-settings.jsp")
		.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getParameter("search-distance");
		request.getParameter("age-range");
		request.getParameter("show-women");
		request.getParameter("show-men");
		System.out.println("Tuka doyde toq request " 
		+ request.getParameter("search-distance") + " "
		+request.getParameter("age-range")+ " " +
		request.getParameter("show-women")+ " " +
		request.getParameter("show-men"));
		doGet(request, response);
	}

}