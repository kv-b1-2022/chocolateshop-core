package in.chocoapp.util;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;

import in.chocoapp.exception.DBException;

public class ConnectionUtil {
	private static Logger log = LogManager.getLogger(ConnectionUtil.class);

	public static Connection getConnection() throws Exception {
		Connection connect = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://101.53.133.59:3306/revature_training_db", "rev_user",
					"rev_user");
		} catch (CommunicationsException e) {
			log.warn(e.getMessage());
			e.printStackTrace();
			throw new DBException("Couldn't connect to server, check your internet connection");
		} catch (Exception e) {
			log.warn(e.getMessage());
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return connect;
	}
}
