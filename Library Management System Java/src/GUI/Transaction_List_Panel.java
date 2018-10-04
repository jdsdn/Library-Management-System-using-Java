package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.io.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.table.*;

import com.toedter.calendar.JDateChooser;

import org.apache.poi.hssf.usermodel.*;

@SuppressWarnings("serial")
public class Transaction_List_Panel extends JPanel {

	public static JTable table;
	public static DefaultTableModel model;
	public static TableRowSorter<DefaultTableModel> dm;
	public static JTextField txtfilter;

	public static int selectedIndex = -1;

	static CompoundBorder d = new CompoundBorder(BorderFactory.createMatteBorder(2, 1, 1, 1, Color.white), BorderFactory.createEmptyBorder(2, 3, 1, 1));
	static CompoundBorder a = new CompoundBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#820000")), BorderFactory.createEmptyBorder(0, 1, 1, 1));

	static String query = "select t.Issue_Code as 'Issue Code', bi.book_name as 'Book Name', si.Student_Name as 'Student Name', sti.Staff_Name as 'Staff Name', t.Transaction_Type as 'Transaction Type', t.borrow_date as 'Issue Date', t.due_date as 'Due Date', t.return_date as 'Return Date', t.Late_Fee as 'Late Fee' from transactionhistory t INNER JOIN book_info Bi on t.Book_ID = bi.book_id inner JOIN student_info si on t.Student_ID = si.Student_ID INNER JOIN staff_info sti on t.Staff_ID = sti.StaffID";

	public static JDateChooser datefrom, dateto;

	public Transaction_List_Panel() 
	{
		setLayout(null);
		setBackground(Color.white);

		addMouseListener(new MouseAdapter() { public void mouseClicked(MouseEvent e) { if(txtfilter.getText().equals("")) txtfilter.setText("Filter"); grabFocus(); try { filltable(query); } catch (SQLException es) { es.printStackTrace(); } } });
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
		jsp.setBorder(BorderFactory.createLineBorder(Color.decode("#820000"), 2));
		jsp.setVisible(true);
		jsp.getVerticalScrollBar().setUnitIncrement(10);
		jsp.setAutoscrolls(true);
		try { filltable(query); } catch (SQLException e) { e.printStackTrace(); }
		jsp.setViewportView(table);

		datefrom = new JDateChooser();
		dateto = new JDateChooser();

		datefrom.setDateFormatString("yyyy/MM/dd");
		dateto.setDateFormatString("yyyy/MM/dd");

		JLabel lblshow = new JLabel("Show Records");
		JLabel lblfrom = new JLabel("From:");
		JLabel lblto = new JLabel("-     To:");
		JButton exprtToExcel = new JButton("Search");
		JButton cls = new JButton("Clear");
		JButton btntoexcel = new JButton("Export to Excel");
		
		JLabel filtericon = new JLabel(new ImageIcon("./imgs/filter_icon.png"));
		txtfilter = new JTextField("Filter");
		txtfilter.setFont(new Font("Serif", Font.BOLD, 18));
		txtfilter.setForeground(Color.decode("#820000"));
		txtfilter.setBorder(BorderFactory.createCompoundBorder(Book_List_Panel.a, Book_List_Panel.d));

		lblshow.setFont(new Font("Serif", Font.BOLD, 18));
		lblfrom.setFont(new Font("Serif", Font.BOLD, 18));
		lblto.setFont(new Font("Serif", Font.BOLD, 18));

		lblshow.setForeground(Color.decode("#820000"));
		lblfrom.setForeground(Color.decode("#820000"));
		lblto.setForeground(Color.decode("#820000"));

		exprtToExcel.setFocusable(false);
		cls.setFocusable(false);

		exprtToExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LocalDateTime from = LocalDateTime.ofInstant(datefrom.getDate().toInstant(), ZoneId.systemDefault());
				LocalDateTime to = LocalDateTime.ofInstant(dateto.getDate().toInstant(), ZoneId.systemDefault());

				Duration d = Duration.between(from, to);

				if(d.toDays() <= -1) { JOptionPane.showMessageDialog(null, "Date 'To' should not be before the date 'From'"); }
				else {
					String q = query + " where transaction_date >= '"+((JTextField) datefrom.getDateEditor()).getText()+"' and transaction_date <= '"+((JTextField) dateto.getDateEditor()).getText()+"'";
					try { filltable(q); } catch (SQLException e) { e.printStackTrace(); }
				}
			}
		});

		cls.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				datefrom.setDate(null);
				dateto.setDate(null);
				try { filltable(query); } catch (SQLException e) { e.printStackTrace(); }
			}
		});

		btntoexcel.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) {
				SimpleDateFormat sdf = new SimpleDateFormat("MMMMM_d_yyyy");
				try { exportTable(table, new File(sdf.format(new Date()).toString() + "_Report_File.xls")); } catch (IOException e) { e.printStackTrace(); }
			}
		});
		
		txtfilter.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent arg0) { txtfilter.select(0, 0); if(txtfilter.getText().equals("")) { txtfilter.setText("Filter"); } }
			public void focusGained(FocusEvent arg0) { txtfilter.selectAll(); }
		});
		
		txtfilter.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent arg0) {
				String querys = txtfilter.getText();
				Generate_Report_Panel.filterTable(querys);
			}
		});

		//tbp.add(lblshow).setBounds(10, 5, 150, 30);
		//tbp.add(lblfrom).setBounds(130, 5, 150, 30);
		//tbp.add(datefrom).setBounds(185, 7, 150, 30);
		//tbp.add(lblto).setBounds(360, 5, 150, 30);
		//tbp.add(dateto).setBounds(425, 7, 150, 30);
		//tbp.add(go).setBounds(580, 7, 100, 30);
		//tbp.add(cls).setBounds(685, 7, 100, 30);
		tbp.add(filtericon).setBounds(5, 344, 30, 30);
		tbp.add(txtfilter).setBounds(38, 344, 150, 30);
		tbp.add(jsp).setBounds(0, 0, 1025, 340);
		tbp.add(btntoexcel).setBounds(870, 344, 150, 30);

		return tbp;
	}

	public static void exportTable(JTable table, File file) throws IOException 
	{
		JFileChooser fc = new JFileChooser();
		fc.setSelectedFile(file);
		int returnVal = fc.showOpenDialog(new JPanel());

		if (returnVal == JFileChooser.APPROVE_OPTION) 
		{
			try {
				HSSFWorkbook fWorkbook = new HSSFWorkbook();
				HSSFSheet fSheet = fWorkbook.createSheet("new Sheet");
				HSSFCellStyle cellStyle = fWorkbook.createCellStyle();

				TableColumnModel tcm = table.getColumnModel();
				TableModel model = table.getModel();
				HSSFRow fRows = fSheet.createRow((short) 0);

				for(int j = 0; j < tcm.getColumnCount(); j++) 
				{
				   HSSFCell cell = fRows.createCell((short) j);
				   cell.setCellValue(tcm.getColumn(j).getHeaderValue().toString());
				}

				for (int i = 0; i < table.getRowCount(); i++) 
				{
					HSSFRow fRow = fSheet.createRow((short) i + 1);
					
					for (int j = 0; j < table.getColumnCount(); j++) 
					{
						HSSFCell cell = fRow.createCell((short) j);
						
						if(j == 0 || j == 8)
						{
//							cell.setCellValue(Integer.parseInt(model.getValueAt(i, j).toString()));
							cell.setCellValue(Integer.parseInt(model.getValueAt(table.convertRowIndexToModel(i), table.convertColumnIndexToModel(j)).toString()));
							cell.setCellStyle(cellStyle);
							continue;
						}
						
//						cell.setCellValue(model.getValueAt(i, j).toString());
						cell.setCellValue(model.getValueAt(table.convertRowIndexToModel(i), j).toString());
						cell.setCellStyle(cellStyle);
					}
				}
				
				fSheet.autoSizeColumn(0);
				fSheet.autoSizeColumn(1);
				fSheet.autoSizeColumn(2);
				fSheet.autoSizeColumn(3);
				fSheet.autoSizeColumn(4);
				fSheet.autoSizeColumn(5);
				fSheet.autoSizeColumn(6);
				fSheet.autoSizeColumn(7);
				fSheet.autoSizeColumn(8);
				
				FileOutputStream fileOutputStream;
				fileOutputStream = new FileOutputStream(fc.getSelectedFile());
				BufferedOutputStream bos = new BufferedOutputStream(fileOutputStream);
				fWorkbook.write(bos);
				bos.close();
				fWorkbook.close();
				fileOutputStream.close();
				
				JOptionPane.showMessageDialog(null, "Report Generated Successfully");
			}

			catch(Exception e){ e.printStackTrace(); }
		}
	}

	public static void filltable(String q) throws SQLException 
	{
		Statement stmt = Database.Connection_Factory.getConnection().createStatement();
		ResultSet rs = stmt.executeQuery(q);
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
}