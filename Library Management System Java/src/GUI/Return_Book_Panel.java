package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;

import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class Return_Book_Panel extends JPanel {

	public static JComboBox<String> cbobook_id, cbostudent_id;
	public static JTextField txtFee;
	public static JDateChooser issue_date, dueDateChooser_date, return_date;
	public static JLabel isbn, name, title, type, author, edition, category, sub_category, language, status, copies, publication, website, copyright;
	public static JLabel student_name, student_course, student_year, student_gender, student_contact, student_status, lblimgicon;
	public static Date duedate;
	public static int stu_id, book_id, issue_code;
	public static String date_issue, due_date; 
	
	public Return_Book_Panel() 
	{
		setLayout(null);
		setBackground(Color.white);
		setBorder(BorderFactory.createLineBorder(Color.decode("#820000"), 5));
		
		JButton btnReturn = new JButton("Return");
		JButton btnCancel = new JButton("Cancel");		
		JButton close = new JButton(new ImageIcon("./imgs/close_button.png"));

		close.setFocusable(false);
		btnReturn.setFocusable(false);
		btnCancel.setFocusable(false);
		
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(return_date.getDate() == null)
				{
					JOptionPane.showMessageDialog(null, "Error: Return Date Required");
				}
				
				else
				{
					if(JOptionPane.showConfirmDialog(null, "Return book?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
					{
						returnbook();
					}
				}
			}
		});

		close.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent arg0) { try { GUI.Borrower_List_Panel.filltable(); } catch (SQLException e) { e.printStackTrace(); } GUI.Manage_Borrower_Panel.frame.dispose(); } });
		btnCancel.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent arg0) { try { GUI.Borrower_List_Panel.filltable(); } catch (SQLException e) { e.printStackTrace(); } GUI.Manage_Borrower_Panel.frame.dispose(); } });

		add(btnCancel).setBounds(722, 531, 100, 30);
		add(btnReturn).setBounds(614, 531, 100, 30);
		add(close).setBounds(800, 8, 30, 30);
		add(getIssuePanel()).setBounds(310, 51, 514, 60);
		add(getTitlePanel()).setBounds(0, 0, 850, 45);
		add(getbook_info_panel()).setBounds(10, 113, 470, 448);
		add(getstudent_info_panel()).setBounds(484, 221, 339, 304);
		add(getsearch_panel()).setBounds(10, 51, 300, 60);	
		getid();
		setInfo();
		add(getReturn_Panel()).setBounds(484, 113, 340, 104);
	}
	
	private void returnbook()
	{
		Database.Borrow_DAO.return_book(new Database.Borrow_Info(issue_code, Integer.parseInt(cbostudent_id.getSelectedItem().toString()), Integer.parseInt(cbobook_id.getSelectedItem().toString()), ((JTextField) issue_date.getDateEditor().getUiComponent()).getText(), ((JTextField) dueDateChooser_date.getDateEditor().getUiComponent()).getText()));
		try { GUI.Borrower_List_Panel.filltable(); } catch (SQLException e) { e.printStackTrace(); }
		try { GUI.Book_List_Panel.filltable(); } catch (SQLException e) { e.printStackTrace(); }
		GUI.Manage_Borrower_Panel.frame.dispose();
	}
	
	public static int getid()
	{
		int a = 0;
		
		try 
		{ 
			PreparedStatement pstmt = Database.Connection_Factory.getConnection().prepareStatement("select count(*) from transactionhistory");
			ResultSet resultSet = pstmt.executeQuery();
			
			if(resultSet.next()) 
			{
				a = resultSet.getInt(1);
				a += 1;
			}
		}
		
		catch (SQLException e) { e.printStackTrace(); }
		
		return a;
	}

	private JPanel getsearch_panel()
	{
		JPanel search_panel = new JPanel();
		search_panel.setLayout(null);
		search_panel.setBorder(new TitledBorder(new LineBorder(Color.decode("#820000"), 2), "Search:", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		cbobook_id = new JComboBox<String>();
		cbobook_id.setUI(new BasicComboBoxUI());
		cbobook_id.setFocusable(false);
		cbobook_id.setEnabled(false);
		search_panel.add(cbobook_id).setBounds(64, 18, 224, 30);

		search_panel.add(new JLabel("Book ID:")).setBounds(8, 26, 46, 14);

		return search_panel;
	}

	private JPanel getReturn_Panel()
	{
		JPanel return_panel = new JPanel();
		return_panel.setBorder(new TitledBorder(new LineBorder(Color.decode("#820000"), 2), "Return:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		return_panel.setLayout(null);

		return_date = new JDateChooser();
		txtFee = new JTextField();

		((JTextField) return_date.getDateEditor()).setEditable(false);
		return_date.setFocusable(false);
		return_date.getJCalendar().setSelectableDateRange(issue_date.getDate(), new Date(Long.MAX_VALUE));
		return_date.setDateFormatString("yyyy/MM/dd");
		
		return_date.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				if(return_date.getDate() != null) {
					calc();
				}
			}
		});
		
		txtFee.setEnabled(false);
		txtFee.setDisabledTextColor(Color.darkGray);

		return_panel.add(new JLabel("Return Date:")).setBounds(10, 24, 100, 30);
		return_panel.add(new JLabel("Fee:")).setBounds(58, 65, 46, 30);
		return_panel.add(txtFee).setBounds(91, 65, 239, 30);
		return_panel.add(return_date).setBounds(91, 24, 239, 30);

		return return_panel;
	}
	
	private void calc()
	{
		LocalDateTime from = LocalDateTime.ofInstant(dueDateChooser_date.getDate().toInstant(), ZoneId.systemDefault());
		LocalDateTime to = LocalDateTime.ofInstant(return_date.getDate().toInstant(), ZoneId.systemDefault());
		
		Duration d = Duration.between(from, to);
		
		if(d.toDays() <= 0)
		{
			txtFee.setText("0");
		}
		
		else
		{
			txtFee.setText(""+(d.toDays() * 50));
		}
	}

	private JPanel getstudent_info_panel()
	{
		JPanel student_info_panel = new JPanel();
		student_info_panel.setBorder(new TitledBorder(new LineBorder(Color.decode("#820000"), 2), "Student Info:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		student_info_panel.setLayout(null);

		cbostudent_id = new JComboBox<String>();
		cbostudent_id.setUI(new BasicComboBoxUI());
		cbostudent_id.setFocusable(false);
		cbostudent_id.setEnabled(false);

		student_info_panel.add(new JLabel("Student ID:")).setBounds(38, 33, 63, 14);
		student_info_panel.add(new JLabel("Student Name:")).setBounds(16, 73, 100, 14);
		student_info_panel.add(new JLabel("Student Course:")).setBounds(10, 113, 100, 14);
		student_info_panel.add(new JLabel("Student Year:")).setBounds(25, 153, 100, 14);
		student_info_panel.add(new JLabel("Student Gender:")).setBounds(11, 193, 100, 14);
		student_info_panel.add(new JLabel("Student Contact:")).setBounds(9, 233, 100, 14);
		student_info_panel.add(new JLabel("Student Status:")).setBounds(17, 273, 100, 14);
		
		student_info_panel.add(student_name = new JLabel()).setBounds(115, 73, 300, 14); 
		student_info_panel.add(student_course = new JLabel()).setBounds(115, 113, 300, 14); 
		student_info_panel.add(student_year = new JLabel()).setBounds(115, 153, 300, 14); 
		student_info_panel.add(student_gender = new JLabel()).setBounds(115, 193, 300, 14); 
		student_info_panel.add(student_contact = new JLabel()).setBounds(115, 233, 300, 14); 
		student_info_panel.add(student_status = new JLabel()).setBounds(115, 273, 300, 14);

		student_info_panel.add(cbostudent_id).setBounds(111, 25, 207, 30);

		return student_info_panel;
	}
	
	public static void setInfo()
	{
		issue_code = Integer.parseInt(GUI.Borrower_List_Panel.model.getValueAt(GUI.Borrower_List_Panel.selectedIndex, 0).toString());
		date_issue = GUI.Borrower_List_Panel.model.getValueAt(GUI.Borrower_List_Panel.selectedIndex, 5).toString();
		due_date = GUI.Borrower_List_Panel.model.getValueAt(GUI.Borrower_List_Panel.selectedIndex, 6).toString();
		
		try 
		{
			PreparedStatement pstmt = Database.Connection_Factory.getConnection().prepareStatement("select * from transactionhistory where issue_code = " + issue_code);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				book_id = rs.getInt(2);
				stu_id = rs.getInt(3);
			}
			
		} catch (SQLException e1) { e1.printStackTrace(); }
		
		cbobook_id.addItem(""+book_id);
		cbostudent_id.addItem(""+stu_id);
		
		try 
		{
			Date dateissue = new SimpleDateFormat("yyyy/MM/dd").parse(date_issue);
			duedate = new SimpleDateFormat("yyyy/MM/dd").parse(due_date);
			
			issue_date.setDate(dateissue);
			dueDateChooser_date.setDate(duedate);
		} 
		
		catch (ParseException e) { e.printStackTrace(); }
		
		setStudent_info(stu_id);
		setBook_info(book_id);
	}
	
	private static void setStudent_info(int id)
	{
		try 
		{
			PreparedStatement pstmt = Database.Connection_Factory.getConnection().prepareStatement("select student_name, student_course, student_year, student_gender, student_contact, student_status from student_info where student_id="+id);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				student_name.setText(rs.getString(1));
				student_course.setText(rs.getString(2));
				student_year.setText(rs.getInt(3)+"");
				student_gender.setText(rs.getString(4));
				student_contact.setText(rs.getString(5));
				student_status.setText(rs.getString(6));
			}
		}

		catch (SQLException e) { e.printStackTrace(); }
	}
	
	private static void setBook_info(int id)
	{
		try 
		{
			Statement statement = Database.Connection_Factory.getConnection().createStatement();
			ResultSet rs = statement.executeQuery(""
					+ "select book_info.book_isbn, book_info.book_name, book_info.book_title, bt.types, book_info.book_authors, book_info.book_edition, cb.category, bc.category, book_info.language, book_info.status, " 
					+ "book_info.bookcopies, bp.publication_name, bp.publication_website, bp.publication_copyright_year, book_info.book_image "
					+ "from book_info "
					+ "inner join book b on book_info.book_id = b.book_id "
					+ "inner join book_purchase_info bpi on b.book_id = bpi.book_id "
					+ "inner join book_publication_info bp on b.book_id = bp.book_id "
					+ "inner join book_types bt on b.type_id = bt.type_id "
					+ "inner join book_categories cb on b.cat_id = cb.category_id "
					+ "inner join book_categories bc on b.subcat_id = bc.category_id "
					+ "where book_info.book_id = " + id);

			if(rs.next())
			{
				isbn.setText(rs.getString(1));
				name.setText(rs.getString(2));
				title.setText(rs.getString(3));
				type.setText(rs.getString(4));
				author.setText(rs.getString(5));
				edition.setText(rs.getInt(6)+"");
				category.setText(rs.getString(7));
				sub_category.setText(rs.getString(8));
				language.setText(rs.getString(9));
				status.setText(rs.getString(10));
				copies.setText(rs.getInt(11)+"");
				publication.setText(rs.getString(12));
				website.setText(rs.getString(13));
				copyright.setText(rs.getString(14));
				InputStream is = rs.getBinaryStream(15);
				Image photo = ImageIO.read(is);
				ImageIcon icon = new ImageIcon(photo);
				lblimgicon.setIcon(icon);
			}
		}

		catch (SQLException | IOException e) { e.printStackTrace(); }
	}

	private JPanel getbook_info_panel()
	{
		JPanel book_info_panel = new JPanel();
		book_info_panel.setBorder(new TitledBorder(new LineBorder(Color.decode("#820000"), 2), "Book Info:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		book_info_panel.setLayout(null);
		
		lblimgicon = new JLabel();
		lblimgicon.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		
		book_info_panel.add(new JLabel("Book ISBN:")).setBounds(10, 31, 100, 14);
		book_info_panel.add(new JLabel("Book Name:")).setBounds(10, 61, 100, 14);
		book_info_panel.add(new JLabel("Book Title:")).setBounds(10, 92, 100, 14);
		book_info_panel.add(new JLabel("Book Type:")).setBounds(10, 124, 100, 14);
		book_info_panel.add(new JLabel("Author/s:")).setBounds(10, 153, 100, 14);
		book_info_panel.add(new JLabel("Edition:")).setBounds(10, 182, 46, 14);
		book_info_panel.add(new JLabel("Category:")).setBounds(10, 211, 100, 14);
		book_info_panel.add(new JLabel("Sub-Category:")).setBounds(10, 240, 100, 14);
		book_info_panel.add(new JLabel("Language:")).setBounds(10, 269, 100, 14);
		book_info_panel.add(new JLabel("Status:")).setBounds(10, 298, 46, 14);
		book_info_panel.add(new JLabel("Copies Left:")).setBounds(10, 328, 100, 14);
		book_info_panel.add(new JLabel("Publication:")).setBounds(10, 357, 100, 14);
		book_info_panel.add(new JLabel("Website:")).setBounds(10, 386, 75, 14);
		book_info_panel.add(new JLabel("Copyright Year:")).setBounds(10, 415, 100, 14);
		
		book_info_panel.add(isbn = new JLabel()).setBounds(105, 31, 100, 14);
		book_info_panel.add(name = new JLabel()).setBounds(105, 61, 500, 14);
		book_info_panel.add(title = new JLabel()).setBounds(105, 92, 500, 14);
		book_info_panel.add(type = new JLabel()).setBounds(105, 124, 300, 14);
		book_info_panel.add(author = new JLabel()).setBounds(105, 153, 500, 14);
		book_info_panel.add(edition = new JLabel()).setBounds(105, 182, 100, 14);
		book_info_panel.add(category = new JLabel()).setBounds(105, 211, 500, 14);
		book_info_panel.add(sub_category = new JLabel()).setBounds(105, 240, 500, 14);
		book_info_panel.add(language = new JLabel()).setBounds(105, 269, 100, 14);
		book_info_panel.add(status = new JLabel()).setBounds(105, 298, 100, 14);
		book_info_panel.add(copies = new JLabel()).setBounds(105, 328, 100, 14);
		book_info_panel.add(publication = new JLabel()).setBounds(105, 357, 500, 14);
		book_info_panel.add(website = new JLabel()).setBounds(105, 386, 500, 14);
		book_info_panel.add(copyright = new JLabel()).setBounds(105, 415, 100, 14);
		book_info_panel.add(lblimgicon).setBounds(328, 18, 130, 120);

		return book_info_panel;
	}

	private JPanel getTitlePanel()
	{
		JPanel title_panel = new JPanel();
		title_panel.setBackground(Color.decode("#820000"));
		return title_panel;
	}

	private JPanel getIssuePanel()
	{
		JPanel issue_panel = new JPanel();
		issue_panel.setLayout(null);
		issue_panel.setBorder(new TitledBorder(new LineBorder(Color.decode("#820000"), 2), "Issue:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		issue_panel.add(new JLabel("Issue Date:")).setBounds(14, 24, 63, 14);
		issue_panel.add(new JLabel("Due Date:")).setBounds(268, 24, 55, 14);

		issue_date = new JDateChooser();
		((JTextField) issue_date.getDateEditor()).setEditable(false);
		issue_date.setDateFormatString("yyyy/MM/dd");
		issue_date.setBounds(87, 17, 174, 30);
		issue_panel.add(issue_date);

		dueDateChooser_date = new JDateChooser();
		((JTextField) dueDateChooser_date.getDateEditor()).setEditable(false);
		dueDateChooser_date.setBounds(333, 17, 174, 30);
		dueDateChooser_date.setDateFormatString("yyyy/MM/dd");
		issue_panel.add(dueDateChooser_date);
		
		issue_date.setEnabled(false);
		((JTextField) issue_date.getDateEditor()).setDisabledTextColor(Color.darkGray);
		
		dueDateChooser_date.setEnabled(false);
		((JTextField) dueDateChooser_date.getDateEditor()).setDisabledTextColor(Color.darkGray);

		return issue_panel;
	}
}