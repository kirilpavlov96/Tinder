package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import exceptions.DBException;
import exceptions.UnauthorizedException;
import model.DAO.UserDAO;
import model.POJO.User;

public class LikeDislikeService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("./Home");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			response.setContentType("application/json");
			User user = (User) request.getSession().getAttribute("user");
			if (user == null) {
				throw new UnauthorizedException("The user is not logged in.");
			}

			@SuppressWarnings("unchecked")
			List<User> users = (List<User>) request.getSession().getAttribute("userCandidates");
			if (users.size() == 0) {
				addCandidates(request, users);
				retrurnPhotosOfTheFirstUser(response, users);
			}
			else if(users.size()==1){
				likeOrDislikeAndRemoveTheTopUser(request, user, users);
				addCandidates(request, users);
				retrurnPhotosOfTheFirstUser(response, users);
			}
			else{
				likeOrDislikeAndRemoveTheTopUser(request, user, users);
				retrurnPhotosOfTheFirstUser(response, users);
			}

		} catch (UnauthorizedException e) {
			e.printStackTrace();
			response.sendRedirect("./Home");
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		}
	}

	private void retrurnPhotosOfTheFirstUser(HttpServletResponse response, List<User> users)
			throws DBException, IOException {
		JSONObject json = new JSONObject();
		if(users.size()==0){
			json.put("photos", new JSONArray(new LinkedList<String>().add("nousers.jpg")));
		}
		else{
			System.out.println(users.get(0));
			json.put("photos", new JSONArray(UserDAO.getAllPhotosOfUser(users.get(0).getUsername())));
		}
		PrintWriter pw = response.getWriter();
		System.out.println(json);
		pw.print(json);
		pw.flush();
	}

	private void likeOrDislikeAndRemoveTheTopUser(HttpServletRequest request, User user, List<User> users) throws DBException {
		if (((String) request.getParameter("action")).equals("Like")) {
			UserDAO.likeUser(user.getId(), users.get(0).getId());
		}
		if (((String) request.getParameter("action")).equals("Dislike")) {
			UserDAO.dislikeUser(user.getId(), users.get(0).getId());
		}
		users.remove(0);
	}

	private void addCandidates(HttpServletRequest request, List<User> users) {
		List<User> newUsers = null;
		try {
			newUsers = UserDAO
					.getFirstThreeNearbyUsers(((User) request.getSession().getAttribute("user")).getUsername());
		} catch (DBException e) {
			e.printStackTrace();
		}
		System.out.println(newUsers.size());
		users.addAll(newUsers);
		request.getSession().setAttribute("userCandidates", users);
	}

}
