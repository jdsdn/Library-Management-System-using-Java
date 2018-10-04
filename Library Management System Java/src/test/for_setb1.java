package test;

import java.awt.Color;
import java.awt.EventQueue;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.*;

public class for_setb1 {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					for_setb1 window = new for_setb1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public for_setb1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("rawtypes")
	private void initialize() {
		frame = new JFrame();
		frame.setSize(850, 610);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel p = new JPanel();
		p.setBorder(new LineBorder(Color.DARK_GRAY, 5));
		p.setLayout(null);
		frame.setContentPane(p);

		JPanel title_panel = new JPanel();
		title_panel.setBackground(Color.DARK_GRAY);
		title_panel.setBounds(0, 0, 834, 45);
		p.add(title_panel);

		JPanel issue_panel = new JPanel();
		issue_panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Issue:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		issue_panel.setBounds(310, 51, 514, 60);
		p.add(issue_panel);
		issue_panel.setLayout(null);

		JLabel lblIssueDate = new JLabel("Issue Date:");
		lblIssueDate.setBounds(14, 24, 63, 14);
		issue_panel.add(lblIssueDate);

		JLabel lblDue_Date = new JLabel("Due Date:");
		lblDue_Date.setBounds(268, 24, 55, 14);
		issue_panel.add(lblDue_Date);

		final JDateChooser dateChooser = new JDateChooser();
		((JTextField) dateChooser.getDateEditor()).setEditable(false);
		dateChooser.setBounds(87, 17, 174, 30);
		issue_panel.add(dateChooser);

		final JDateChooser dateChooser_1 = new JDateChooser();
		//		dateChooser_1.setEnabled(false);
		//		((JTextField) dateChooser_1.getDateEditor()).setDisabledTextColor(Color.darkGray);
		((JTextField) dateChooser_1.getDateEditor()).setEditable(false);
		dateChooser_1.setBounds(333, 17, 174, 30);
		issue_panel.add(dateChooser_1);

		JPanel book_info_panel = new JPanel();
		book_info_panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Book Info:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		book_info_panel.setBounds(10, 113, 470, 448);
		p.add(book_info_panel);
		book_info_panel.setLayout(null);
		
		JLabel lblbook_isbn = new JLabel("Book ISBN:");
		lblbook_isbn.setBounds(10, 31, 100, 14);
		book_info_panel.add(lblbook_isbn);
		
		JPanel lblimg = new JPanel();
		lblimg.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblimg.setBounds(330, 18, 130, 120);
		book_info_panel.add(lblimg);
		
		JLabel lblBookName = new JLabel("Book Name:");
		lblBookName.setBounds(10, 61, 100, 14);
		book_info_panel.add(lblBookName);
		
		JLabel lblBookTitle = new JLabel("Book Title:");
		lblBookTitle.setBounds(10, 92, 100, 14);
		book_info_panel.add(lblBookTitle);
		
		JLabel lblBookType = new JLabel("Book Type:");
		lblBookType.setBounds(10, 124, 100, 14);
		book_info_panel.add(lblBookType);
		
		JLabel lblBookAuthors = new JLabel("Author/s:");
		lblBookAuthors.setBounds(10, 153, 100, 14);
		book_info_panel.add(lblBookAuthors);
		
		JLabel lblEdition = new JLabel("Edition:");
		lblEdition.setBounds(10, 182, 46, 14);
		book_info_panel.add(lblEdition);
		
		JLabel lblCategory = new JLabel("Category:");
		lblCategory.setBounds(10, 211, 100, 14);
		book_info_panel.add(lblCategory);
		
		JLabel lblSubcategory = new JLabel("Sub-Category:");
		lblSubcategory.setBounds(10, 240, 100, 14);
		book_info_panel.add(lblSubcategory);
		
		JLabel lblLanguage = new JLabel("Language:");
		lblLanguage.setBounds(10, 269, 100, 14);
		book_info_panel.add(lblLanguage);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(10, 298, 46, 14);
		book_info_panel.add(lblStatus);
		
		JLabel lblCopiesLeft = new JLabel("Copies Left:");
		lblCopiesLeft.setBounds(10, 328, 100, 14);
		book_info_panel.add(lblCopiesLeft);
		
		JLabel lblPublication = new JLabel("Publication:");
		lblPublication.setBounds(10, 357, 100, 14);
		book_info_panel.add(lblPublication);
		
		JLabel lblWebsite = new JLabel("Website:");
		lblWebsite.setBounds(10, 386, 75, 14);
		book_info_panel.add(lblWebsite);
		
		JLabel lblCopyrightYear = new JLabel("Copyright Year:");
		lblCopyrightYear.setBounds(10, 415, 100, 14);
		book_info_panel.add(lblCopyrightYear);

		JPanel student_info_panel = new JPanel();
		student_info_panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Student Info:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		student_info_panel.setBounds(485, 221, 339, 304);
		p.add(student_info_panel);
		student_info_panel.setLayout(null);
		
		JLabel lblStudentId = new JLabel("Student ID:");
		lblStudentId.setBounds(38, 33, 63, 14);
		student_info_panel.add(lblStudentId);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(110, 25, 207, 30);
		student_info_panel.add(comboBox_1);
		
		JLabel lblNewLabel = new JLabel("Student Name:");
		lblNewLabel.setBounds(16, 73, 100, 14);
		student_info_panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Student Course:");
		lblNewLabel_1.setBounds(10, 113, 100, 14);
		student_info_panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Student Year:");
		lblNewLabel_2.setBounds(25, 153, 100, 14);
		student_info_panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Student Gender:");
		lblNewLabel_3.setBounds(11, 193, 100, 14);
		student_info_panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Student Contact:");
		lblNewLabel_4.setBounds(9, 233, 100, 14);
		student_info_panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Student Status:");
		lblNewLabel_5.setBounds(17, 273, 100, 14);
		student_info_panel.add(lblNewLabel_5);

		JPanel search_panel = new JPanel();
		search_panel.setBounds(10, 51, 300, 60);
		p.add(search_panel);
		search_panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Search:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		search_panel.setLayout(null);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(64, 18, 224, 30);
		search_panel.add(comboBox);

		JLabel lblBookId = new JLabel("Book ID:");
		lblBookId.setBounds(8, 26, 46, 14);
		search_panel.add(lblBookId);

		JButton btnNewButton = new JButton("Return");
		btnNewButton.setBounds(614, 531, 100, 30);
		p.add(btnNewButton);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(722, 531, 100, 30);
		p.add(btnCancel);
		
		JPanel return_panel = new JPanel();
		return_panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Return:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		return_panel.setBounds(484, 113, 340, 104);
		p.add(return_panel);
		return_panel.setLayout(null);
		
		JDateChooser dateChooser_2 = new JDateChooser();
		dateChooser_2.setBounds(91, 24, 239, 30);
		return_panel.add(dateChooser_2);
		
		JLabel lblReturnDate_1 = new JLabel("Return Date:");
		lblReturnDate_1.setBounds(10, 24, 100, 30);
		return_panel.add(lblReturnDate_1);
		
		JLabel lblFee = new JLabel("Fee:");
		lblFee.setBounds(58, 65, 46, 30);
		return_panel.add(lblFee);
		
		textField = new JTextField();
		textField.setBounds(91, 65, 239, 30);
		return_panel.add(textField);

		dateChooser.getDateEditor().addPropertyChangeListener(
				new PropertyChangeListener() {
					public void propertyChange(PropertyChangeEvent e) {
						if(dateChooser.getDate() != null)
						{
							Calendar cal = Calendar.getInstance();
							cal.setTime(dateChooser.getDate());
							cal.add(Calendar.DAY_OF_MONTH, 7); // add days
							Date due_date = cal.getTime();
							dateChooser_1.setDate(due_date);
						}
					}
				});
	}
}
