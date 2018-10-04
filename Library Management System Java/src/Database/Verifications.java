package Database;

import java.sql.*;

public class Verifications 
{
	public Verifications() { }
	
	static Connection connection = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;

	private static Connection getConnection() throws SQLException 
	{
		Connection conn;
		Connection_Factory.getInstance();
		conn = Connection_Factory.getConnection();
		return conn;
	}

	public static boolean access_granted(int ID, String password) throws SQLException
	{	
		Statement statement = getConnection().createStatement();
		rs = statement.executeQuery("select * from staff_login where Staff_ID="+ID+" and password='"+password+"'");
		return rs.next();
	}
	
	public static String getStaffName(int ID) throws SQLException
	{
		Statement statement = getConnection().createStatement();
		rs = statement.executeQuery("select Staff_Name from Staff_Info where Staff_ID="+ID+"");
		rs.first();
		return rs.getString(1);
	}
	
	public static boolean admin_access_granted(String username, String password) throws SQLException
	{
		Statement statement = getConnection().createStatement();
		rs = statement.executeQuery("select * from nigol_nimda where username='"+username+"' and password='"+password+"'");
		
		return rs.next();
	}
}