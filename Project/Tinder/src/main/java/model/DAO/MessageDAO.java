package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;		

import exceptions.DBException;
import model.POJO.Chat;
import model.POJO.User;

public class MessageDAO {
	private static final String FIND_CHAT_ID = "SELECT chat_id FROM"
			+ " tinder.users_in_chats where user_id = ?"
			+ " and chat_id in(SELECT chat_id FROM "
			+ "tinder.users_in_chats where user_id = ?);";
	private static final String SEND_MESSAGE = 
			"insert into tinder.messages values(null,?,?,?);";
	
	public static void sendMessage(String msg,User from,User to) throws DBException{
		Connection conn = null;
		PreparedStatement stmnt = null;
		Chat chat = null;
		try {
			chat = new Chat(findChatId(from, to));
			conn = ConnectionDispatcher.getConnection();
			stmnt = conn.prepareStatement(SEND_MESSAGE);
			stmnt.setInt(1, from.getId());
			stmnt.setInt(2, chat.getId());
			stmnt.setString(3, msg);
			stmnt.execute();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Something went wrong with the Database.", e);
		} finally {
			ConnectionDispatcher.returnConnection(conn);
		}
	}

	public static int findChatId(User firstUser,User secondUser) throws DBException{
		Connection conn = null;
		PreparedStatement stmnt = null;
		ResultSet res = null;
		try {
			conn = ConnectionDispatcher.getConnection();
			stmnt = conn.prepareStatement(FIND_CHAT_ID);
			stmnt.setInt(1, firstUser.getId());
			stmnt.setInt(2, secondUser.getId());
			res = stmnt.executeQuery();
			if( res.next() ){
				return res.getInt(1);
			}
			else{
				throw new DBException("Failed to find chat between users user1:"
						+ firstUser + " user2:" + secondUser);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Something went wrong with the Database.", e);
		} finally {
			ConnectionDispatcher.returnConnection(conn);
		}
	}
}
