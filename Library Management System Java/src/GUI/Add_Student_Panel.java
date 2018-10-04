package GUI;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;

@SuppressWarnings("serial")
public class Add_Student_Panel extends JPanel {

	private JLabel lblstudent_id, lblstudent_name, lblstudent_course, lblContactNo, lblStudentsGender, lblStudentsStatus;
	public static JTextField txtstudent_id, txtstudent_name, txtstudent_course, txtcontactno, txtstudent_year;
	private static JButton btnadd, btnclear;
	private static JComboBox<String> cbogender, cbostatus;
	
	public Add_Student_Panel() {

		setBounds(0, 0, 350, 395);
		setBackground(Color.white);
		setLayout(null);

		JLabel lblAddStudent = new JLabel("Add Student");
		JLabel lblStudentsYear = new JLabel("Student's Year");

		lblstudent_id = new JLabel("Student's ID");
		lblstudent_name = new JLabel("Student's Name");
		lblstudent_course = new JLabel("Student's Course");
		lblContactNo = new JLabel("Contact Number");
		lblStudentsStatus = new JLabel("Student's Status");
		lblStudentsGender = new JLabel("Student's Gender");
		btnadd = new JButton("Add New Student");
		btnclear = new JButton("Clear");

		txtstudent_id = new JTextField();
		txtstudent_name = new JTextField();
		txtstudent_course = new JTextField();
		txtcontactno = new JTextField();
		cbogender = new JComboBox<String>();
		cbostatus = new JComboBox<String>();
		txtstudent_year = new JTextField();

		txtstudent_name.addFocusListener(new Listeners.UI_txtf_Listener());
		txtstudent_course.addFocusListener(new Listeners.UI_txtf_Listener());
		txtstudent_id.addFocusListener(new Listeners.UI_txtf_Listener());
		txtcontactno.addFocusListener(new Listeners.UI_txtf_Listener());
		txtstudent_year.addFocusListener(new Listeners.UI_txtf_Listener());

		cbogender.addItem("Male");
		cbogender.addItem("Female");

		cbostatus.addItem("Active");
		cbostatus.addItem("Inactive");

		cbogender.setUI(new BasicComboBoxUI());
		cbostatus.setUI(new BasicComboBoxUI());
		
		btnadd.setBorder(new Custom_Renderers.Rounded_Border(10));
		btnclear.setBorder(new Custom_Renderers.Rounded_Border(10));

		btnadd.setFocusable(false);
		btnclear.setFocusable(false);
		cbogender.setFocusable(false);
		cbostatus.setFocusable(false);

		lblAddStudent.setFont(new Font("Sans Serif", Font.BOLD, 27));
		lblstudent_name.setFont(new Font("Sans Serif", Font.PLAIN, 12));
		lblstudent_course.setFont(new Font("Sans Serif", Font.PLAIN, 12));
		lblContactNo.setFont(new Font("Sans Serif", Font.PLAIN, 12));
		lblStudentsStatus.setFont(new Font("Sans Serif", Font.PLAIN, 12));
		lblStudentsGender.setFont(new Font("Sans Serif", Font.PLAIN, 12));
		lblStudentsYear.setFont(new Font("Sans Serif", Font.PLAIN, 12));
		lblstudent_id.setFont(new Font("Sans Serif", Font.PLAIN, 12));

		lblAddStudent.setForeground(Color.black);
		lblstudent_name.setForeground(Color.black);
		lblstudent_course.setForeground(Color.black);
		lblContactNo.setForeground(Color.black);
		lblStudentsStatus.setForeground(Color.black);
		lblStudentsGender.setForeground(Color.black);
		lblStudentsYear.setForeground(Color.black);
		lblstudent_id.setForeground(Color.black);
//		txtstudent_id.setSelectionColor(Color.cyan);

		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try { addStudent(); } catch (SQLException e) { e.printStackTrace(); }
			}
		});

		btnclear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clear();
			}
		});

		add(lblAddStudent).setBounds(94, 11, 215, 32);
		add(lblstudent_id).setBounds(16, 283, 72, 14);
		add(lblstudent_name).setBounds(14, 53, 93, 14);
		add(lblstudent_course).setBounds(14, 108, 110, 14);
		add(lblContactNo).setBounds(16, 218, 181, 14);
		add(lblStudentsGender).setBounds(40, 161, 110, 14);
		add(lblStudentsStatus).setBounds(205, 161, 110, 14);
		add(txtstudent_id).setBounds(90, 276, 72, 29);
		add(txtstudent_name).setBounds(14, 74, 314, 29);
		add(txtstudent_course).setBounds(14, 126, 314, 29);
		add(txtcontactno).setBounds(16, 237, 314, 29);
		add(txtstudent_year).setBounds(258, 276, 72, 29);
		add(lblStudentsYear).setBounds(170, 283, 83, 14);
		add(cbogender).setBounds(14, 179, 150, 30);
		add(cbostatus).setBounds(178, 179, 150, 30);
		add(btnadd).setBounds(20, 318, 150, 30);
		add(btnclear).setBounds(179, 318, 150, 30);
	}

	private void addStudent() throws SQLException {

		int d = Integer.parseInt(txtstudent_id.getText());
		String a = txtstudent_name.getText();
		String c = txtstudent_course.getText();
		String f = txtcontactno.getText();
		String e = cbogender.getSelectedItem().toString();
		String g = cbostatus.getSelectedItem().toString();
		int b  = Integer.parseInt(txtstudent_year.getText());

		Database.Student_Info s = new Database.Student_Info(a, b, c, d, e, f, g);
		Database.Student_DAO.add_student(s);
		clear();
		GUI.Manage_Student_Panel.filltable("select Student_ID as 'ID', Student_Name as 'Name', Student_Year as 'Year', Student_Course as 'Course', Student_Gender as 'Gender', Student_Contact as 'Contact', Student_Status as 'Status' from Student_Info");
	}

	static void clear() {
		txtstudent_id.setText("");
		txtstudent_name.setText("");
		txtstudent_course.setText("");
		txtcontactno.setText("");
		cbogender.setSelectedIndex(0);
		cbostatus.setSelectedIndex(0);
		txtstudent_year.setText("");
		txtstudent_name.requestFocus();
		try { Manage_Student_Panel.filltable("select Student_ID as 'ID', Student_Name as 'Name', Student_Year as 'Year', Student_Course as 'Course', Student_Gender as 'Gender', Student_Contact as 'Contact', Student_Status as 'Status' from Student_Info"); } catch (SQLException e) { e.printStackTrace(); }
	}

	public static boolean parseStrToInt(String str) {
		if (str.matches("\\d+")) { return true; } 
		else { return false; }
	}
}