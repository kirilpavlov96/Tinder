package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import exceptions.DBException;
import model.*;
import model.POJO.User;

public class UserDAO {

	private static final String REGISTER_USER = "INSERT INTO tinder.users "
			+ "values(null,?,?,?,?,'default',?,false,false,null,null,null,null,null);";
	private static final String IS_USER_EXISTING = "select count(id) from tinder.users where "
			+ "username = ? and password_hash = ?";
	private static final String GET_USER = "select * from tinder.users where username = ?";
	private static final String CHANGE_LOCATION = "UPDATE tinder.users " 
	+ "SET latitude = ?, longitude = ? "
			+ "WHERE id = ?;";
	private static final String FIND_CLOSE_USERS = 
			"select * from tinder.users "
			+ "where age between ? and ? and "
			+ "6371.009*sqrt(pow(radians(? - latitude),2) "
			+ "+ pow(cos((? + latitude)/2)*(radians(? - longitude)),2))"
			+ " <= ? limit 3;";
	private static final String FIND_PICTURES_OF_USER = 
			"SELECT * FROM tinder.pictures where owner_id = ?;";

	public static boolean isUserExisting(String username, String password) throws DBException {
		Connection conn = null;
		PreparedStatement st = null;
		boolean result = false;
		try {
			conn = ConnectionDispatcher.getConnection();
			st = conn.prepareStatement(IS_USER_EXISTING);
			st.setString(1, username);
			st.setString(2, password);
			ResultSet rs = st.executeQuery();
			rs.next();
			if (rs.getInt(1) == 1) {
				result = true;
			}
		} catch (Exception e) {
			throw new DBException("Can't check if this user (" + username + ") exists .", e);
		} finally {
			ConnectionDispatcher.returnConnection(conn);
		}
		return result;
	}

	// not finished
	public static void registerUser(String username, String password, String email, boolean gender, int age)
			throws DBException {
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = ConnectionDispatcher.getConnection();
			st = (PreparedStatement) conn.prepareStatement(REGISTER_USER);
			st.setString(1, username);
			st.setString(2, password);
			st.setInt(3, age);
			st.setBoolean(4, gender);
			st.setString(5, email);
			st.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Something went wrong with the Database.", e);
			// TODO
		} finally {
			ConnectionDispatcher.returnConnection(conn);
		}
	}

	public static boolean setLocation(String username, double latitude, double longitude) throws DBException {
		User toChangeLocation = getUser(username);
		int id = toChangeLocation.getId();
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = ConnectionDispatcher.getConnection();
			st = conn.prepareStatement(CHANGE_LOCATION);
			st.setDouble(1, latitude);
			st.setDouble(2, longitude);
			st.setInt(3, id);
			st.execute();

		} catch (Exception e) {
			throw new DBException("Something went wrong with the Database.", e);
			// TODO
		} finally {
			ConnectionDispatcher.returnConnection(conn);
		}

		return true;
	}

	public static List<User> getFirstThreeNearbyUsers(String username) throws DBException {
		User toFindFor = getUser(username);
		int maxAge = toFindFor.getMaxDesiredAge();
		int minAge = toFindFor.getMinDesiredAge();
		int searchDistance = toFindFor.getSearchDistance();
		double latitude = toFindFor.getLatitude();
		double longitude = toFindFor.getLongitude();
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		List<User> toReturn = new LinkedList<User>();
		try {
			conn = ConnectionDispatcher.getConnection();
			st = conn.prepareStatement(FIND_CLOSE_USERS);
			st.setInt(1, minAge);
			st.setInt(2, maxAge);
			st.setDouble(3, latitude);
			st.setDouble(4, latitude);
			st.setDouble(5, longitude);
			st.setInt(6, searchDistance);
			rs = st.executeQuery();
			
			while(rs.next()){
				toReturn.add(UserDAO.getUser(rs.getString("username")));
			}
		} catch (Exception e) {
			throw new DBException("Something went wrong with the Database.", e);
			// TODO
		} finally {
			ConnectionDispatcher.returnConnection(conn);
		}

		return toReturn;
	}

	public static List<String> getAllPhotosOfUser(String username) throws DBException {
		int idToSearchFor = UserDAO.getUser(username).getId();
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		List<String> toReturn = new LinkedList<String>();
		try {
			conn = ConnectionDispatcher.getConnection();
			st = conn.prepareStatement(FIND_PICTURES_OF_USER);
			st.setInt(1, idToSearchFor);
			rs = st.executeQuery();
			while(rs.next()){
				toReturn.add(rs.getString("name"));
			}
		} catch (Exception e) {
			throw new DBException("Something went wrong with the Database.", e);
			// TODO
		} finally {
			ConnectionDispatcher.returnConnection(conn);
		}
		return toReturn;
	}

	public static User getUser(String username) throws DBException {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = ConnectionDispatcher.getConnection();
			st = conn.prepareStatement(GET_USER);
			st.setString(1, username);
			rs = st.executeQuery();
			if (rs.next()) {
				return new User(rs.getInt("id"), rs.getString("username"), rs.getString("password_hash"),
						rs.getInt("age"), rs.getBoolean("gender_is_male"), rs.getString("avatar_name"),
						rs.getString("email"), rs.getBoolean("wants_male"), rs.getBoolean("wants_female"),
						rs.getDouble("longitude"), rs.getDouble("latitude"),rs.getInt("search_distance"),
						rs.getInt("max_desired_age"),rs.getInt("min_desired_age"));
			}
			return null;

		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Something went wrong with the Database.", e);
			// TODO
		} finally {
			ConnectionDispatcher.returnConnection(conn);
		}
	}
}
