package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import exceptions.DBException;
import exceptions.UnauthorizedException;
import model.DAO.MessageDAO;
import model.DAO.UserDAO;
import model.POJO.Message;
import model.POJO.User;

public class MessagesService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			response.setContentType("application/json");
			HttpSession session = request.getSession(false);
			if (session == null) {
				throw new UnauthorizedException("The user is not logged in.");
			}
			List<Message> toReturn = MessageDAO.getLastMessagesFrom(
					Integer.parseInt(request.getParameter("nummessages")),
					UserDAO.getUser(request.getParameter("username1")),
					UserDAO.getUser(request.getParameter("username2")),
					LocalDateTime.parse(request.getParameter("fromtime")));

			JSONObject json = new JSONObject();
			json.put("messages", toReturn);

			PrintWriter pw = response.getWriter();
			System.out.println("Prashtam json ot message service :" + json);
			pw.print(json);
			pw.flush();

		} catch (UnauthorizedException e) {
			e.printStackTrace();
			response.sendRedirect("./Home");
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		}
	}

}
