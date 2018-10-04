package Database;

import java.sql.*;
import javax.swing.JOptionPane;

public class Connection_Factory {

	String driverClassName = "com.mysql.jdbc.Driver";
	static String connectionUrl = "jdbc:mysql://localhost:3306/LibraryDatabase";
	static String dbUser = "root";
	static String dbPwd = "";

	private static Connection_Factory connectionFactory = null;

	private Connection_Factory() 
	{
		try { Class.forName(driverClassName); } 
		catch (ClassNotFoundException e) { e.printStackTrace(); }
	}

	public static Connection getConnection() throws SQLException 
	{
		Connection conn = null;
		try { conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd); } 
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Cannot Connect to Database!");
			System.exit(0);
		}
		
		return conn;
	}

	public static Connection_Factory getInstance()
	{
		if (connectionFactory == null) { connectionFactory = new Connection_Factory(); }
		return connectionFactory;
	}
}