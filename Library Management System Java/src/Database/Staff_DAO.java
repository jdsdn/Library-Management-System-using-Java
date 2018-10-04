package Database;

import java.sql.*;

import javax.swing.*;

public class Staff_DAO 
{
	Connection connection = null;
	PreparedStatement pstmt = null;
	ResultSet resultSet = null;
	
	public Staff_DAO() {}
	
	private Connection getConnection() throws SQLException 
	{
		Connection conn;
		Connection_Factory.getInstance();
		conn = Connection_Factory.getConnection();
		return conn;
	}
	
	@SuppressWarnings("unused")
	private void add_staff(Staff_Info st)
	{
		try 
		{
			String query = "Insert into Staff_Info VALUES(?,?,?,?)";
			connection = getConnection();

			pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, st.getStaff_ID());
			pstmt.setString(2, st.getStaff_Name());
			pstmt.setString(3, st.getDesignation());
			pstmt.setString(4, st.getDepartment());

			pstmt.execute();
			insert_staff_login_info(st.getStaff_ID(), st.getPassword());
			
			JOptionPane.showMessageDialog(null, "Student Added Successfully");
		} 

		catch (Exception e) { }

		finally 
		{
			try { if (pstmt != null) pstmt.close(); if (connection != null) connection.close(); } 
			catch (SQLException e) { e.printStackTrace(); } 
			catch (Exception e) { e.printStackTrace(); }
		}
	}
	
	public void insert_staff_login_info(int ID, String password)
	{
		try 
		{
			String query = "Insert into staff_login(ID, password) VALUES(?,?)";
			connection = getConnection();

			pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, ID);
			pstmt.setString(2, password);

			pstmt.execute();
		} 
		
		catch (Exception e) { }
	}
}