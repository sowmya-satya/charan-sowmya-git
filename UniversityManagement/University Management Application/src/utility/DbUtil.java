package utility;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import exception.DaoException;

public class DbUtil {

	private static final String DBURL = "jdbc:mysql://localhost:3306/university";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Welcome123";

	public static Connection getConnection() throws DaoException {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = (Connection) DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
		} catch (SQLException | ClassNotFoundException e) {
			throw new DaoException(e);
		}
		return connection;
	}

	public static String closeConnection(Connection connection) throws DaoException {
		String result = "";

		try {
			connection.close();
			result = "Successfully closed the connection";
		} catch (SQLException ex) {
			throw new DaoException(ex);
		}
		return result;
	}

	public static void closeConnection(java.sql.Connection con) {
		// TODO Auto-generated method stub
		
	}

}
