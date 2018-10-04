package Database;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Book_DAO 
{
	static Connection connection = null;
	static PreparedStatement pstmt = null;
	static ResultSet resultSet = null;
	static FileInputStream fis;
	static File file;

	public Book_DAO() {}

	private static Connection getConnection() throws SQLException 
	{
		Connection conn;
		Connection_Factory.getInstance();
		conn = Connection_Factory.getConnection();
		return conn;
	}

	public static void add_book(Book_Info b)
	{
		try 
		{
			if(GUI.Add_Book_Panel.file == null) {

				file = new File("./imgs/no-image.png");
				fis = new FileInputStream(file);
			}

			else 
			{
				file = GUI.Add_Book_Panel.file;
				fis = new FileInputStream(file);
			}

			String query = "insert into book_info values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			connection = getConnection();

			pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, b.getBook_id());
			pstmt.setBinaryStream(2, fis, file.length());
			pstmt.setString(3, b.getBook_isbn() + "");
			pstmt.setString(4, b.getBook_name());
			pstmt.setString(5, b.getBook_title());
			pstmt.setString(6, b.getBook_authors());
			pstmt.setInt(7, b.getBook_edition());
			pstmt.setString(8, b.getLanguage());
			pstmt.setString(9, b.getStatus());
			pstmt.setInt(10, b.getBookcopies());

			pstmt.execute();
			
			query = "insert into book values (?, ?, ?, ?)";
			connection = getConnection();
			
			pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, b.getBook_id());
			pstmt.setString(2, b.getBook_type());
			pstmt.setString(3, b.getCategory());
			pstmt.setString(4, b.getSubcategory());
			
			pstmt.execute();
			
			query = "insert into book_publication_info values (?, ?, ?, ?, ?)";
			connection = getConnection();
			
			pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, b.getBook_id());
			pstmt.setString(2, b.getPublication_name());
			pstmt.setString(3, b.getPublication_details());
			pstmt.setString(4, b.getWebsite_url());
			pstmt.setString(5, b.getCopyrightyear());
			
			pstmt.execute();
			
			query = "insert into book_purchase_info values (?, ?, ?, ?)";
			connection = getConnection();
			
			pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, b.getBook_id());
			pstmt.setString(2, b.getPurchase_date());
			pstmt.setString(3, b.getRecieve_date());
			pstmt.setFloat(4, b.getBook_price());
			
			pstmt.execute();

			JOptionPane.showMessageDialog(null, "Book Added Successfully");
		} 

		catch (Exception e) { e.printStackTrace(); }

		finally 
		{
			try { if (pstmt != null) pstmt.close(); if (connection != null) connection.close(); } 
			catch (SQLException e) { e.printStackTrace(); } 
			catch (Exception e) { e.printStackTrace(); }
		}
	}

	public static void update_book(Book_Info b) 
	{
		try 
		{
			if(GUI.Update_Book_Panel.file == null) {

				file = new File("./imgs/no-image.png");
				fis = new FileInputStream(file);
			}

			else 
			{
				file = GUI.Update_Book_Panel.file;
				fis = new FileInputStream(file);
			}

			String query = "update book_info bi set bi.book_image = ?, bi.book_isbn = ?, bi.book_name = ?, bi.book_title = ?, bi.book_authors = ?, bi.book_edition = ?, bi.language = ?, bi.status = ?, bi.bookcopies = ? where bi.book_id = ?";
			connection = getConnection();

			pstmt = connection.prepareStatement(query);
			pstmt.setBinaryStream(1, fis, file.length());
			pstmt.setString(2, b.getBook_isbn() + "");
			pstmt.setString(3, b.getBook_name());
			pstmt.setString(4, b.getBook_title());
			pstmt.setString(5, b.getBook_authors());
			pstmt.setInt(6, b.getBook_edition());
			pstmt.setString(7, b.getLanguage());
			pstmt.setString(8, b.getStatus());
			pstmt.setInt(9, b.getBookcopies());
			pstmt.setInt(10, b.getBook_id());

			pstmt.execute();
			
			query = "update book b set b.type_id = ?, b.cat_id = ?, b.subcat_id = ? where b.book_id = ?";
			connection = getConnection();
			
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, b.getBook_type());
			pstmt.setString(2, b.getCategory());
			pstmt.setString(3, b.getSubcategory());
			pstmt.setInt(4, b.getBook_id());
			
			pstmt.execute();
			
			query = "update book_publication_info bpi set bpi.publication_name = ?, bpi.publication_details = ?, bpi.publication_website = ?, bpi.publication_copyright_year = ? WHERE bpi.book_id = ?";
			connection = getConnection();
			
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, b.getPublication_name());
			pstmt.setString(2, b.getPublication_details());
			pstmt.setString(3, b.getWebsite_url());
			pstmt.setString(4, b.getCopyrightyear());
			pstmt.setInt(5, b.getBook_id());
			
			pstmt.execute();
			
			query = "update book_purchase_info bp set bp.purchase_date = ?, bp.recieve_date = ?, bp.book_price = ? where bp.book_id = ?";
			connection = getConnection();
			
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, b.getPurchase_date());
			pstmt.setString(2, b.getRecieve_date());
			pstmt.setFloat(3, b.getBook_price());
			pstmt.setInt(4, b.getBook_id());
			
			pstmt.execute();

			JOptionPane.showMessageDialog(null, "Book Updated Successfully");
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