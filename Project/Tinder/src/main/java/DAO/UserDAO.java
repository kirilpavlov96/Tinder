package DAO;

import java.sql.ResultSet;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import exceptions.DBException;
import model.*;

public class UserDAO {

	private static final String IS_USER_EXISTING = "select count(id) from tinder.users where "
			+ "username = ? and password_hash = ?";

	public static boolean isUserExisting(String username, String password) throws DBException {
		Connection conn = null;
		PreparedStatement st = null;
		boolean result = false;
		try {
			conn = ConnectionDispatcher.getConnection();
			st = (PreparedStatement) conn.prepareStatement(IS_USER_EXISTING);
			st.setString(1, username);
			st.setString(2, password);
			ResultSet rs = st.executeQuery();
			rs.next();
			if (rs.getInt(1) > 0) {
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
	public static boolean registerUser(User user) throws DBException {
		Connection conn = null;
		PreparedStatement st = null;
		boolean result = false;
		try {
			conn = ConnectionDispatcher.getConnection();
			st = (PreparedStatement) conn.prepareStatement("INSERT INTO tinder.users "
					+ "");
			
			ResultSet rs = st.executeQuery();
			rs.next();
			if (rs.getInt(1) > 0) {
				result = true;
			}
		} catch (Exception e) {
			throw new DBException("Something went wrong with the Database.", e);
		} finally {
			ConnectionDispatcher.returnConnection(conn);
		}
		return result;
	}
}
