package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.event.*;
import javax.swing.table.*;

import Database.Connection_Factory;

@SuppressWarnings("serial")
public class Cats_Panel extends JPanel {

	public static JTable table, table1;
	public static DefaultTableModel model, model1;
	public static TableRowSorter<DefaultTableModel> dm, dm1;

	public static int selectedIndex = -1, type_id, cat_id;
	public static JTextField txtfilter, txtfilter1 , txtaddcat, txtaddtype;
	public static JButton btnaddcat, btnaddtype, btnupdatecat, btnupdatetype;

	public static Connection connection;

	static CompoundBorder d = new CompoundBorder(BorderFactory.createMatteBorder(2, 1, 1, 1, Color.white), BorderFactory.createEmptyBorder(2, 3, 1, 1));
	static CompoundBorder a = new CompoundBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#820000")), BorderFactory.createEmptyBorder(0, 1, 1, 1));

	public Cats_Panel()
	{
		setLayout(null);
		setBackground(Color.white);

		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try { filltable("select category_id as 'ID', category as 'Category' from book_categories"); filltable1("select type_id as 'ID', types as 'Types' from book_types"); } catch (SQLException es) { es.printStackTrace(); }
				grabFocus();
			}
		});

		JLabel btnfilter = new JLabel(new ImageIcon("./imgs/filter_icon.png"));
		txtfilter = new JTextField("Filter Types");		

		JLabel btnfilter1 = new JLabel(new ImageIcon("./imgs/filter_icon.png"));
		txtfilter1 = new JTextField("Filter Categories");

		txtfilter.setFont(new Font("Serif", Font.BOLD, 18));
		txtfilter.setForeground(Color.decode("#820000"));
		txtfilter.setBorder(BorderFactory.createCompoundBorder(Book_List_Panel.a, Book_List_Panel.d));

		txtfilter1.setFont(new Font("Serif", Font.BOLD, 18));
		txtfilter1.setForeground(Color.decode("#820000"));
		txtfilter1.setBorder(BorderFactory.createCompoundBorder(Book_List_Panel.a, Book_List_Panel.d));

		txtaddcat = new JTextField();
		txtaddtype = new JTextField();

		btnaddcat = new JButton("Add");
		btnaddtype = new JButton("Add");
		btnupdatecat = new JButton("Update");
		btnupdatetype = new JButton("Update");

		btnaddcat.setFocusable(false);
		btnaddtype.setFocusable(false);
		btnupdatecat.setFocusable(false);
		btnupdatetype.setFocusable(false);

		btnaddcat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try { addcat(); } catch (SQLException e) { e.printStackTrace(); }
			}
		});

		btnaddtype.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try { addtype(); } catch (SQLException e) { e.printStackTrace(); }
			}
		});

		btnupdatecat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try { updatecat(); } catch (SQLException e) { e.printStackTrace(); }
			}
		});

		btnupdatetype.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try { updatetype(); } catch (SQLException e) { e.printStackTrace(); }
			}
		});

		txtaddcat.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent arg0) { txtaddcat.select(0, 0); }
			public void focusGained(FocusEvent arg0) { txtaddcat.selectAll(); }
		});

		txtaddtype.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent arg0) { txtaddtype.select(0, 0); }
			public void focusGained(FocusEvent arg0) { txtaddtype.selectAll(); }
		});

		txtfilter.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent arg0) { txtfilter.select(0, 0); if(txtfilter.getText().equals("")) { txtfilter.setText("Filter Types"); } }
			public void focusGained(FocusEvent arg0) { txtfilter.selectAll(); }
		});

		txtfilter1.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent arg0) { txtfilter1.select(0, 0); if(txtfilter1.getText().equals("")) { txtfilter1.setText("Filter Categories"); } }
			public void focusGained(FocusEvent arg0) { txtfilter1.selectAll(); }
		});
		
		txtfilter.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent arg0) {
				String query = txtfilter.getText();
				filterTable(query);
			}
		});
		
		txtfilter1.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent arg0) {
				String query = txtfilter1.getText();
				filterTable1(query);
			}
		});

		add(btnfilter).setBounds(530, 20, 30, 30);
		add(txtfilter).setBounds(562, 20, 150, 30);
		add(btnfilter1).setBounds(530, 205, 30, 30);
		add(txtfilter1).setBounds(562, 205, 150, 30);
		add(txtaddcat).setBounds(530, 55, 180, 30);
		add(txtaddtype).setBounds(530, 240, 180, 30);
		add(btnaddcat).setBounds(535, 90, 80, 30);
		add(btnupdatecat).setBounds(625, 90, 80, 30);
		add(btnaddtype).setBounds(535, 275, 80, 30);;
		add(btnupdatetype).setBounds(625, 275, 80, 30);;
		add(getCatsTable()).setBounds(25, 20, 500, 160);
		add(getbtypes()).setBounds(25, 205, 500, 160);
	}

	public static int getncats()
	{
		int a = 0;

		try 
		{ 
			PreparedStatement pstmt = Database.Connection_Factory.getConnection().prepareStatement("select count(*) from book_categories");
			ResultSet resultSet = pstmt.executeQuery();

			if(resultSet.next()) 
			{
				a = resultSet.getInt(1);
			}
		}

		catch (SQLException e) { e.printStackTrace(); }

		return a;
	}

	public static int getntype()
	{
		int a = 0;

		try 
		{ 
			PreparedStatement pstmt = Database.Connection_Factory.getConnection().prepareStatement("select count(*) from book_types");
			ResultSet resultSet = pstmt.executeQuery();

			if(resultSet.next()) 
			{
				a = resultSet.getInt(1);
			}
		}

		catch (SQLException e) { e.printStackTrace(); }

		return a;
	}

	public void addcat() throws SQLException
	{
		String query = "Insert into book_categories VALUES(?,?)";
		connection = getConnection();
		PreparedStatement pstmt = connection.prepareStatement(query);

		pstmt.setInt(1, getncats() + 1);
		pstmt.setString(2, txtaddcat.getText());

		pstmt.execute();
		JOptionPane.showMessageDialog(null, "Category Added Successfully");
		filltable("select category_id as 'ID', category as 'Category' from book_categories");
	}

	public void addtype() throws SQLException
	{
		String query = "Insert into book_types VALUES(?,?)";
		connection = getConnection();

		PreparedStatement pstmt = connection.prepareStatement(query);

		pstmt.setInt(1, getntype() + 1);
		pstmt.setString(2, txtaddtype.getText());

		pstmt.execute();
		JOptionPane.showMessageDialog(null, "Type Added Successfully");
		filltable1("select type_id as 'ID', types as 'Types' from book_types");
	}

	public void updatecat() throws SQLException
	{
		String query = "update book_categories set category = '"+txtaddcat.getText()+"' where category_id = "+cat_id+"";
		Statement stmt = Database.Connection_Factory.getConnection().createStatement();
		stmt.executeUpdate(query);
		txtaddcat.setText("");
		this.grabFocus();
		JOptionPane.showMessageDialog(null, "Category Updated Successfully");
		filltable("select category_id as 'ID', category as 'Category' from book_categories");
	}

	public void updatetype() throws SQLException
	{
		String query = "update book_types set types = '"+txtaddtype.getText()+"' where type_id = "+type_id+"";
		Statement stmt = Database.Connection_Factory.getConnection().createStatement();
		stmt.executeUpdate(query);
		txtaddtype.setText("");
		this.grabFocus();
		JOptionPane.showMessageDialog(null, "Type Updated Successfully");
		filltable1("select type_id as 'ID', types as 'Types' from book_types");
	}

	private Connection getConnection() throws SQLException 
	{
		Connection conn;
		Connection_Factory.getInstance();
		conn = Connection_Factory.getConnection();
		return conn;
	}

	public static JPanel getCatsTable()
	{
		JPanel tbp = new JPanel();
		tbp.setLayout(null);
		tbp.setVisible(true);
		tbp.setBorder(BorderFactory.createLineBorder(Color.decode("#820000"), 2));
		tbp.setBorder(BorderFactory.createLineBorder(Color.green, 2));

		table = new JTable() { private static final long serialVersionUID = 1L; public boolean isCellEditable(int row, int column) { return false; }; };

		JScrollPane jsp = new JScrollPane();
		jsp.setBounds(0, 0, 500, 160);
		jsp.setBorder(BorderFactory.createLineBorder(Color.decode("#820000"), 2));
		//		jsp.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
		jsp.setVisible(true);
		jsp.getVerticalScrollBar().setUnitIncrement(10);
		jsp.setAutoscrolls(true);
		try { filltable("select category_id as 'ID', category as 'Category' from book_categories"); } catch (SQLException e) { e.printStackTrace(); }
		jsp.setViewportView(table);

		tbp.add(jsp);

		return tbp;
	}

	public static JPanel getbtypes()
	{
		JPanel tbp = new JPanel();
		tbp.setLayout(null);	
		tbp.setVisible(true);
		tbp.setBorder(BorderFactory.createLineBorder(Color.decode("#820000"), 2));
		tbp.setBorder(BorderFactory.createLineBorder(Color.green, 2));

		table1 = new JTable() { private static final long serialVersionUID = 1L; public boolean isCellEditable(int row, int column) { return false; }; };

		JScrollPane jsp = new JScrollPane();
		jsp.setBounds(0, 0, 500, 160);
		jsp.setBorder(BorderFactory.createLineBorder(Color.decode("#820000"), 2));
		//		jsp.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
		jsp.setVisible(true);
		jsp.getVerticalScrollBar().setUnitIncrement(10);
		jsp.setAutoscrolls(true);
		try { filltable1("select type_id as 'ID', types as 'Types' from book_types"); } catch (SQLException e) { e.printStackTrace(); }
		jsp.setViewportView(table1);
		tbp.add(jsp);

		return tbp;
	}

	public static void filltable(String query) throws SQLException 
	{
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

				if(selectedRowIndex > -1)
				{
					table.getSelectionModel().setSelectionInterval(selectedRowIndex, selectedRowIndex);
					selectedIndex = table.convertRowIndexToModel(table.getSelectedRow());
					cat_id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
					txtaddcat.setText(model.getValueAt(selectedIndex, 1).toString());
				}	
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

	public static void filltable1(String query) throws SQLException 
	{
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

		table1.getSelectionModel().addListSelectionListener(new ListSelectionListener() 
		{
			public void valueChanged(ListSelectionEvent arg0) 
			{
				int selectedRowIndex = table1.getSelectedRow();

				if(selectedRowIndex > -1)
				{
					table1.getSelectionModel().setSelectionInterval(selectedRowIndex, selectedRowIndex);
					selectedIndex = table1.convertRowIndexToModel(table1.getSelectedRow());
					type_id = Integer.parseInt(model1.getValueAt(selectedIndex, 0).toString());
					txtaddtype.setText(model1.getValueAt(selectedIndex, 1).toString());
				}
			}
		});

		table1.getTableHeader().setReorderingAllowed(false);
		table1.getTableHeader().setResizingAllowed(false);
		table1.setShowGrid(false);
		table1.setSelectionBackground(Color.decode("#b70000"));
		table1.setSelectionForeground(Color.white);

		((DefaultTableCellRenderer)table1.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
		model1 = new DefaultTableModel(data, columnNames);

		table1.setModel(model1);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table1.setDefaultRenderer(String.class, centerRenderer);

		for(int i = 0; i < table.getColumnCount(); i++) 
		{
			table1.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}

		table1.setFocusable(false);
		table1.getTableHeader().setBackground(Color.decode("#820000"));
		table1.getTableHeader().setForeground(Color.white);
		table1.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 13));
		table1.setRowHeight(25);
	}
	
	private static void filterTable(String query)
	{
		dm = new TableRowSorter<DefaultTableModel>(model);
		table.setRowSorter(dm);
		dm.setRowFilter(RowFilter.regexFilter(query));
		txtaddcat.setText("");
	}
	
	private static void filterTable1(String query)
	{
		dm1 = new TableRowSorter<DefaultTableModel>(model1);
		table1.setRowSorter(dm1);
		dm1.setRowFilter(RowFilter.regexFilter(query));
		txtaddtype.setText("");
	}
}