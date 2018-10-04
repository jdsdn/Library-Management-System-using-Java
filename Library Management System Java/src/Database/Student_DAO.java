package Database;

import java.sql.*;
import javax.swing.*;

public class Student_DAO 
{
	static Connection connection = null;
	static PreparedStatement pstmt = null;
	static ResultSet resultSet = null;

	public Student_DAO() { }

	private static Connection getConnection() throws SQLException 
	{
		Connection conn;
		Connection_Factory.getInstance();
		conn = Connection_Factory.getConnection();
		return conn;
	}

	public static void add_student(Student_Info student)
	{
		try 
		{
			String query = "Insert into student_info VALUES(?,?,?,?,?,?,?)";
			connection = getConnection();

			pstmt = connection.prepareStatement(query);
			
			pstmt.setString(1, student.getStudent_name());
			pstmt.setInt(2, student.getStudent_year());
			pstmt.setString(3, student.getStudent_course());
			pstmt.setInt(4, student.getStudent_id());
			pstmt.setString(5, student.getStudent_gender());
			pstmt.setString(6, student.getStudent_contact());
			pstmt.setString(7, student.getStudent_status());

			pstmt.execute();
			
			JOptionPane.showMessageDialog(null, "Student Added Successfully");
		} 

		catch (Exception e) { e.printStackTrace(); }

		finally 
		{
			try { if (pstmt != null) pstmt.close(); if (connection != null) connection.close(); } 
			catch (SQLException e) { e.printStackTrace(); } 
			catch (Exception e) { e.printStackTrace(); }
		}
	}

	public static void update_student(Student_Info student) 
	{
		try 
		{
			String queryString = "UPDATE student_info SET Student_Name=?, Student_Course=?, Student_Year=?, Student_Contact=?, Student_Status=?, Student_Gender=? WHERE Student_ID=?";
			connection = getConnection();

			pstmt = connection.prepareStatement(queryString);
			
			pstmt.setString(1, student.getStudent_name());
			pstmt.setString(2, student.getStudent_course());
			pstmt.setInt(3, student.getStudent_year());
			pstmt.setString(4, student.getStudent_contact());
			pstmt.setString(5, student.getStudent_status());
			pstmt.setString(6, student.getStudent_gender());
			pstmt.setInt(7, student.getStudent_id());
			
			
			pstmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Student Updated Successfully");
		}

		catch (Exception e) { e.printStackTrace(); }

		finally 
		{
			try { if (pstmt != null) pstmt.close(); if (connection != null) connection.close(); } 
			catch (SQLException e) { e.printStackTrace(); } 
			catch (Exception e) { e.printStackTrace(); }
		}
	}
}