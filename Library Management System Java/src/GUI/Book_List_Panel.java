package GUI;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

@SuppressWarnings("serial")
public class Book_List_Panel extends JPanel {

	public static JTable table;
	public static DefaultTableModel model;
	public static TableRowSorter<DefaultTableModel> dm;

	public static int selectedIndex = -1;

	static CompoundBorder d = new CompoundBorder(BorderFactory.createMatteBorder(2, 1, 1, 1, Color.white), BorderFactory.createEmptyBorder(2, 3, 1, 1));
	static CompoundBorder a = new CompoundBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#820000")), BorderFactory.createEmptyBorder(0, 1, 1, 1));

	public Book_List_Panel() 
	{
		setLayout(null);
		setBackground(Color.white);

		addMouseListener(new MouseAdapter() { public void mouseClicked(MouseEvent e) { grabFocus(); try { filltable(); } catch (SQLException es) { es.printStackTrace(); } } });
		add(gettable()).setBounds(5, 5, 1025, 380);
	}

	public static JPanel gettable()
	{
		JPanel tbp = new JPanel();
		tbp.setLayout(null);	
		tbp.setVisible(true);
		tbp.setBorder(BorderFactory.createLineBorder(Color.decode("#820000"), 2));

		table = new JTable() { private static final long serialVersionUID = 1L; public boolean isCellEditable(int row, int column) { return false; }; };

		JScrollPane jsp = new JScrollPane();
		jsp.setBounds(0, 0, 1025, 340);
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
		String query = "SELECT bi.book_id as 'Book ID', bi.book_title as 'Book Title', bi.book_authors as 'Book Author/s', bt.types as 'Type', bi.book_edition as 'Edition', bc.category as 'Category', cb.category as 'Sub-Category', bi.status as 'Status'\r\n" + 
				"FROM book_info bi\r\n" + 
				"inner JOIN book b on bi.book_id = b.book_id\r\n" + 
				"inner JOIN book_types bt  on b.type_id = bt.type_id\r\n" + 
				"inner join book_categories bc on b.cat_id = bc.category_id\r\n" + 
				"inner join book_categories cb on b.subcat_id = cb.category_id";
		
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

		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(5);
		columnModel.getColumn(1).setPreferredWidth(200);
		columnModel.getColumn(2).setPreferredWidth(150);
		columnModel.getColumn(3).setPreferredWidth(5);
		columnModel.getColumn(4).setPreferredWidth(5);
		columnModel.getColumn(7).setPreferredWidth(25);
	}

	public static int getSelectedIndex() {
		return selectedIndex;
	}

	public static void edit()
	{
		if(selectedIndex > -1) 
		{
			GUI.Manage_Book_Panel.showUpdate();
			try { GUI.Update_Book_Panel.setinfo(); } catch (SQLException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); } catch (ParseException e) { e.printStackTrace(); } 
		}

		else { JOptionPane.showMessageDialog(null, "Please Select a Record to Edit"); }
	}
}