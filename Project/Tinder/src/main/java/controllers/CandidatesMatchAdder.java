package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exceptions.DBException;
import model.DAO.UserDAO;
import model.POJO.*;

public class CandidatesMatchAdder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session==null){
			response.sendRedirect("/Home");
		}
		else{
			List<User> users = (List<User>) session.getAttribute("userCandidates");
			try {
				users.addAll(UserDAO.getFirstThreeNearbyUsers((String)session.getAttribute("username")));
			} catch (DBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.setAttribute("userCandidates", users);
		}
	}

}
