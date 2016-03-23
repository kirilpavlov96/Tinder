package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import exceptions.DBException;
import model.*;
import model.POJO.User;

public class UserDAO {

	private static final String REGISTER_USER = "INSERT INTO tinder.users "
			+ "values(null,?,?,?,true,'default',null,?,null,null);";
	private static final String IS_USER_EXISTING = "select count(id) from tinder.users where "
			+ "username = ? and password_hash = ?";
	private static final String GET_USER = "select * from tinder.users where username = ?";

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

	
	//not finished
	public static void registerUser(String username,String password,String email,boolean gender,int age) throws DBException {
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = ConnectionDispatcher.getConnection();
			st = (PreparedStatement) conn.prepareStatement(REGISTER_USER);
			st.setString(1, username);
			st.setString(2, password);
			st.setInt(3, age);
			st.setString(4, email);
			st.executeUpdate();
			
		} catch (Exception e) {
			throw new DBException("Something went wrong with the Database.", e);
			// TODO
		} finally {
			ConnectionDispatcher.returnConnection(conn);
		}
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
			if( rs.next() ){
			return new User(rs.getInt("id"),
					rs.getString("username"),
					rs.getString("password_hash"),
					rs.getInt("age"),
					rs.getBoolean("gender_is_male"),
					rs.getString("avatar_name"),
					rs.getInt("location_id"),
					rs.getString("email"),
					rs.getBoolean("wants_male"),
					rs.getBoolean("wants_female"));
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
