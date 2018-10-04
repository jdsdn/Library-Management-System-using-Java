package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

@SuppressWarnings("serial")
public class Borrower_List_Panel extends JPanel {
	
	public static JTable table;
	public static DefaultTableModel model;
	
	public static int selectedIndex = -1;

	public Borrower_List_Panel() 
	{
		setLayout(null);
		setBackground(Color.white);
		
		addMouseListener(new MouseAdapter() { public void mouseClicked(MouseEvent e) { grabFocus(); try { filltable(); } catch (SQLException es) { es.printStackTrace(); } } });
		add(gettable()).setBounds(5, 5, 1025, 390);
	}
	
	public static JPanel gettable()
	{
		JPanel tbp = new JPanel();
		tbp.setLayout(null);	
		tbp.setVisible(true);
		tbp.setBorder(BorderFactory.createLineBorder(Color.decode("#820000"), 2));

		table = new JTable() { private static final long serialVersionUID = 1L; public boolean isCellEditable(int row, int column) { return false; }; };

		JScrollPane jsp = new JScrollPane();
		jsp.setBounds(0, 0, 1025, 350);
		jsp.setBorder(BorderFactory.createLineBorder(Color.decode("#820000"), 2));
		jsp.setVisible(true);
		jsp.getVerticalScrollBar().setUnitIncrement(10);
		jsp.setAutoscrolls(true);
		try { filltable(); } catch (SQLException e) { e.printStackTrace(); }
		jsp.setViewportView(table);

		tbp.add(jsp);

		return tbp;
	}
	
	public static void filltable() throws SQLException 
	{		
		String query = "select t.issue_code as 'Issue Code', bi.book_name as 'Book Name', si.Student_Name as 'Student Name', sti.Staff_Name as 'Staff In Charge', t.Transaction_Type as 'Transaction Type', t.borrow_date as 'Date Issued', t.due_date as 'Due Date' FROM transactionhistory t INNER JOIN book_info bi on t.Book_ID = bi.book_id INNER JOIN student_info si on t.Student_ID = si.Student_ID INNER JOIN staff_info sti on t.Staff_ID = sti.StaffID where transaction_type = 'Book Issue'";
		
		Statement stmt = Database.Connection_Factory.getConnection().createStatement();
		ResultSet rs = stmt.executeQuery(query);
		ResultSetMetaData metaData = rs.getMetaData();

		int columnCount = metaData.getColumnCount();

		Vector<String> columnNames = new Vector<String>();

		for (int column = 1; column <= columnCount; column++) 
		{
			columnNames.add(metaData.getColumnLabel(column));
		}

		Vector<Vector<Object>> data = new Vector<Vector<Object>>();

		while (rs.next()) 
		{
			Vector<Object> vector = new Vector<Object>();

			for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) 
			{
				vector.add(rs.getObject(columnIndex));
			}

			data.add(vector);
		}

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() 
		{
			public void valueChanged(ListSelectionEvent arg0) 
			{
				int selectedRowIndex = table.getSelectedRow();
				table.getSelectionModel().setSelectionInterval(selectedRowIndex, selectedRowIndex);
				selectedIndex = table.convertRowIndexToModel(table.getSelectedRow());
			}
		});

		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table.setShowGrid(false);
		table.setSelectionBackground(Color.decode("#b70000"));
		table.setSelectionForeground(Color.white);

		((DefaultTableCellRenderer)table.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
		model = new DefaultTableModel(data, columnNames);

		table.setModel(model);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table.setDefaultRenderer(String.class, centerRenderer);

		for(int i = 0; i < table.getColumnCount(); i++) 
		{
			table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}

		table.setFocusable(false);
		table.getTableHeader().setBackground(Color.decode("#820000"));
		table.getTableHeader().setForeground(Color.white);
		table.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 13));
		table.setRowHeight(25);
	}
	
	public static void returnbook()
	{
		if(selectedIndex > -1) 
		{
			GUI.Manage_Borrower_Panel.showReturn();
			 
		}

		else { JOptionPane.showMessageDialog(null, "Please Select a Record to Edit"); }
	}
}