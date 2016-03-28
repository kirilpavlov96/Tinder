package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import exceptions.DBException;
import model.DAO.UserDAO;
import model.POJO.User;

public class UserPhotosService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("./Home");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession(false)==null){
			response.sendRedirect("./Home");
		}
		try {
			response.setContentType("application/json");
			JSONObject json = new JSONObject();
			json.put("photos", UserDAO.getAllPhotosOfUser(((User)request.getSession(false).getAttribute("user")).getUsername()));
			System.out.println(json);
			PrintWriter pw = response.getWriter();
			pw.print(json);
			pw.flush();
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		}
	}

}
