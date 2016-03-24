package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exceptions.UnauthorizedException;
import model.DAO.UserDAO;
import model.POJO.User;

public class FirstCandidatePhotosAdder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			if (session == null) {
				throw new UnauthorizedException("User is not logged in.");
			} else {
				User firstUser = ((List<User>) session.getAttribute("userCandidates")).get(0);
				List<String> photos = (List<String>) session.getAttribute("firstCandidatePhotos");
				photos.addAll(UserDAO.getAllPhotosOfUser(firstUser.getUsername()));
				session.setAttribute("fistCandidatePhotos", photos);
			}
		} catch (UnauthorizedException e) {
			e.printStackTrace();
			response.sendRedirect("/Home");
		} catch(IndexOutOfBoundsException e){
			System.err.println("No more nearby users.");
		}
	}

}
