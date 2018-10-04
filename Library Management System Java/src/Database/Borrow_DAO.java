package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Borrow_DAO {

	static Connection connection = null;
	static PreparedStatement pstmt = null;
	static ResultSet resultSet = null;

	public Borrow_DAO() { }

	private static Connection getConnection() throws SQLException 
	{
		Connection conn;
		Connection_Factory.getInstance();
		conn = Connection_Factory.getConnection();
		return conn;
	}

	public static void return_book(Borrow_Info b)
	{
		try 
		{
			connection = getConnection();

			String query = "update transactionhistory t set t.Transaction_Type = ?, t.return_date = ?, t.Late_Fee = ? where t.Issue_Code = ?";
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, "Return Book");
			pstmt.setString(2, ((JTextField) GUI.Return_Book_Panel.return_date.getDateEditor().getUiComponent()).getText());
			pstmt.setString(3, GUI.Return_Book_Panel.txtFee.getText());
			pstmt.setInt(4, b.getIssue_code());
			pstmt.execute();
			
			query = "update book_info set bookcopies = bookcopies + 1 where book_id = ?";
			pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, b.getBook_id());
			pstmt.execute();

			query = "update book_info set status = 'Available' where bookcopies > 0";
			pstmt = connection.prepareStatement(query);
			pstmt.execute();

			JOptionPane.showMessageDialog(null, "Book Returned Successfully");
		} 

		catch (Exception e) { e.printStackTrace(); }

		finally 
		{
			try { if (pstmt != null) pstmt.close(); if (connection != null) connection.close(); } 
			catch (SQLException e) { e.printStackTrace(); } 
			catch (Exception e) { e.printStackTrace(); }
		}
	}

	public static boolean check_issue_codes(Borrow_Info b) throws SQLException
	{
		Statement statement = getConnection().createStatement();
		ResultSet rs = statement.executeQuery("Select * from borrower_list where student_id = "+b.getStudent_id()+" and book_id = "+b.getBook_id()+" ");

		return rs.next();
	}


	public static void issue_book(Borrow_Info b)
	{
		try 
		{
			String query = "Insert into transactionhistory values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			connection = getConnection();
			pstmt = connection.prepareStatement(query);

			pstmt.setInt(1, b.getIssue_code());
			pstmt.setInt(2, b.getBook_id());
			pstmt.setInt(3, b.getStudent_id());
			pstmt.setInt(4, GUI.Main_Frame.getStaff_id());
			pstmt.setString(5, "Book Issue");
			pstmt.setString(6, b.getBorrow_date());
			pstmt.setString(7, b.getReturn_date());
			pstmt.setString(8, "-");
			pstmt.setString(9, "-");

			pstmt.execute();

			query = "update book_info set bookcopies = bookcopies - 1 where book_id = ?";
			pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, b.getBook_id());
			pstmt.execute();

			query = "update book_info set status = 'Not Available' where bookcopies = 0";
			pstmt = connection.prepareStatement(query);
			pstmt.execute();

			JOptionPane.showMessageDialog(null, "Book Issued Successfully");
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