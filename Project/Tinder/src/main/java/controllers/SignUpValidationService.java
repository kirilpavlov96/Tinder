package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import exceptions.DBException;
import model.DAO.UserDAO;

public class SignUpValidationService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("./Home");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			response.setContentType("aplication/json");
			String username = request.getParameter("username");
			String email = request.getParameter("email");
			String age = request.getParameter("age");
			JSONObject resp = new JSONObject();
			if (username != null) {
				if (!UserDAO.isUsernameExisting(username) && username.length() <= 45) {
					resp.append("username", "OK");
				} else if (UserDAO.isUsernameExisting(username)) {
					resp.append("username", "This username is already in use!");
				} else {
					resp.append("username", "Too long username!");
				}
			}
			if (email != null) {
				if (!UserDAO.isEmailExisting(username) && username.length() <= 45) {
					resp.append("email", "OK");
				} else {
					resp.append("email", "This email is already in use!");
				}
			}
			if(age!=null){
				if(Integer.parseInt(age)>100){
					resp.append("age","You can't be that old!");
				}
				else if(Integer.parseInt(age)<1){
					resp.append("age","You can't be that young!");
				}
				else{
					resp.append("age","OK");
				}
			}
			PrintWriter pw = response.getWriter();
			pw.print(resp);
			pw.flush();
			
		} catch (DBException e) {
			e.printStackTrace();
		}
	}

}
