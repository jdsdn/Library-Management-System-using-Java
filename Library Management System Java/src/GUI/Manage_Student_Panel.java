package GUI;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

@SuppressWarnings("serial")
public class Manage_Student_Panel extends JPanel 
{
	Image bgimage = null;
	SimpleDateFormat sdf;

	public static JLabel lblTime;
	public static JButton home_button, logout_button, edit;
	public static ImageIcon home, home_hover, logout, logout_hover;
	public static JPanel p;
	public static JTabbedPane tp;
	public static DefaultTableModel model;
	public static JTable table;
	public static JTextField txtfilter;
	public static JComboBox<String> cbofilter;
	public static int selectedIndex;
	
	public static Add_Student_Panel asp;
	public static Update_Student_Panel usp;
	
	private TableRowSorter<DefaultTableModel> dm;
	
	CompoundBorder d = new CompoundBorder(BorderFactory.createMatteBorder(2, 1, 1, 1, Color.white), BorderFactory.createEmptyBorder(2, 3, 1, 1));
	CompoundBorder a = new CompoundBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#820000")), BorderFactory.createEmptyBorder(0, 1, 1, 1));
	static String query = "select Student_ID as 'ID', Student_Name as 'Name', Student_Year as 'Year', Student_Course as 'Course', Student_Gender as 'Gender', Student_Contact as 'Contact', Student_Status as 'Status' from Student_Info";
	
	Manage_Student_Panel() throws SQLException 
	{
		MediaTracker mt = new MediaTracker(this);
		bgimage = Toolkit.getDefaultToolkit().getImage("./imgs/gro2 - Copy.png");
		mt.addImage(bgimage, 0);
		try { mt.waitForAll(); } catch (InterruptedException e) { e.printStackTrace(); }

		setBorder(BorderFactory.createLineBorder(Color.black, 5));
		setVisible(false);
		setLayout(null);

		p = new JPanel();
		p.setBackground(Color.white);
		p.setLayout(null);
		p.setBorder(BorderFactory.createLineBorder(Color.decode("#820000"), 5));
		
		JLabel lib = new JLabel("L i b r a r y");
		JLabel man = new JLabel("Management");
		JLabel mans = new JLabel("Student Management");
		JLabel lblshow = new JLabel("Show:");
		
		JLabel btnfilter = new JLabel(new ImageIcon("./imgs/filter_icon.png"));
		
		txtfilter = new JTextField("Filter");
		
		txtfilter.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent arg0) {
				filterTable(txtfilter.getText());
			}
		});
		
		txtfilter.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent arg0) { txtfilter.select(0, 0); if(txtfilter.getText().equals("")) { txtfilter.setText("Filter"); } }
			public void focusGained(FocusEvent arg0) { txtfilter.selectAll(); }
		});
		
		lib.setFont(new Font("Serif", Font.BOLD, 22));
		man.setFont(new Font("Serif", Font.BOLD, 11));
		mans.setFont(new Font("Serif", Font.BOLD, 33));
		txtfilter.setFont(new Font("Serif", Font.BOLD, 18));
		lblshow.setFont(new Font("Serif", Font.BOLD, 18));
		
		man.setForeground(Color.white);
		lib.setForeground(Color.white);
		mans.setForeground(Color.white);
		txtfilter.setForeground(Color.decode("#820000"));
		lblshow.setForeground(Color.decode("#820000"));
		
		txtfilter.setBorder(BorderFactory.createCompoundBorder(a, d));
		
		home = new ImageIcon("./imgs/home_button.png");
		home_hover = new ImageIcon("./imgs/home_button_hover.png");
		home_button = new JButton(home);
		home_button.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, Color.white));
		home_button.addMouseListener(new Listeners.Main_Menu_Listener());
		home_button.addActionListener(new Listeners.Main_Menu_Listener());
		
		logout = new ImageIcon("./imgs/ms_logout_button.png");
		logout_hover = new ImageIcon("./imgs/ms_logout_button_hover.png");
		logout_button = new JButton(logout);
		logout_button.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, Color.white));
		logout_button.addMouseListener(new Listeners.Main_Menu_Listener());
		logout_button.addActionListener(new Listeners.Main_Menu_Listener());
		
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(txtfilter.getText().equals("")) txtfilter.setText("Filter");
				grabFocus();
			}
		});
		
		p.add(gettable()).setBounds(10, 50, 580, 355);
//		add(getcbo()).setBounds(325, 135, 170, 30);
		add(txtfilter).setBounds(105, 135, 150, 30);
		add(btnfilter).setBounds(73, 135, 30, 30);
		add(p).setBounds(61, 122, 959, 416);
		add(home_button).setBounds(11, 566, 91, 61);
		add(logout_button).setBounds(978, 566, 91, 61);
		add(getTime()).setBounds(965, 75, 150, 30);
		add(lib).setBounds(525, 588, 200, 30);
		add(man).setBounds(567, 610, 200, 30);
		add(mans).setBounds(15, 30, 350, 50);
//		p.add(lblshow).setBounds(213, 13, 100, 30);
		p.add(gettabp()).setBounds(595, 10, 350, 395);
	}
	
	public static JLabel getTime() {
		lblTime = new JLabel("Time: ");
		Clock c1 = new Clock(lblTime,"E h:mm a   ");
	    Thread t1 = new Thread(c1);
	    t1.start();
	    
		lblTime.setFont(new Font("Serif", Font.PLAIN, 18));
		lblTime.setForeground(Color.white);
		
	    return lblTime;
	}
	
	public static JComboBox<String> getcbo() 
	{
		UIDefaults def = UIManager.getLookAndFeelDefaults();
		def.put("ComboBox.buttonDarkShadow", Color.decode("#820000"));
		def.put("ComboBox.buttonBackground", Color.white);
		def.put("ComboBox.buttonHighlight",  Color.decode("#820000"));
		def.put("ComboBox.buttonShadow", Color.white);
		def.put("ComboBox.foreground", Color.decode("#820000"));
		def.put("ComboBox.border", new Custom_Renderers.Rounded_Corner_Border_Red());
		
		cbofilter = new JComboBox<String>();
		cbofilter.setUI(new BasicComboBoxUI());
		cbofilter.setFocusable(false);
		
		cbofilter.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) 
			{
				if(cbofilter.getSelectedIndex() == 0)
				{
					String a = "select Student_ID as 'ID', Student_Name as 'Name', Student_Year as 'Year', Student_Course as 'Course', Student_Gender as 'Gender', Student_Contact as 'Contact', Student_Status as 'Status' from Student_Info";
					try { filltable(a); } 
					catch (SQLException e) { e.printStackTrace(); }
				}
				
				else if(cbofilter.getSelectedIndex() == 1)
				{
					String a = "select Student_ID as 'ID', Student_Name as 'Name', Student_Year as 'Year', Student_Course as 'Course', Student_Gender as 'Gender', Student_Contact as 'Contact', Student_Status as 'Status' from Student_Info where Student_Status = 'Active'";
					try { filltable(a); } 
					catch (SQLException e) { e.printStackTrace(); }
				}
				
				else
				{
					String a = "select Student_ID as 'ID', Student_Name as 'Name', Student_Year as 'Year', Student_Course as 'Course', Student_Gender as 'Gender', Student_Contact as 'Contact', Student_Status as 'Status' from Student_Info where Student_Status = 'Inactive'";
					try { filltable(a); } 
					catch (SQLException e) { e.printStackTrace(); }
				}
			}
		});
		
		cbofilter.addItem("All Students");
		cbofilter.addItem("Active Students Only");
		cbofilter.addItem("Inactive Students Only");
		
		return cbofilter;
	}
	
	public static JPanel gettable() throws SQLException
	{
		JPanel tbp = new JPanel();
		tbp.setLayout(null);	
		tbp.setVisible(true);

		table = new JTable() { private static final long serialVersionUID = 1L; public boolean isCellEditable(int row, int column) { return false; }; };
		
		JScrollPane jsp = new JScrollPane();
		jsp.setBounds(0, 0, 580, 355);
		jsp.setBorder(BorderFactory.createLineBorder(Color.decode("#820000"), 2));
		jsp.setVisible(true);
		jsp.setAutoscrolls(true);
		filltable(query);
		jsp.setViewportView(table);
		tbp.add(jsp);
		
		return tbp;
	}
	
	private static JTabbedPane gettabp() {
		
        Main_Frame.setDefaults();
		
		tp = new JTabbedPane();
		tp.setFocusable(false);
		
		tp.add("<html><body><table width='130'>Add Student</table></body></html>", asp = new Add_Student_Panel());
		tp.add("<html><body><table width='130'>Update Records</table></body></html>", usp = new Update_Student_Panel());
		
		tp.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(tp.getSelectedIndex() == 0) { try { filltable(query); } catch (SQLException e) { e.printStackTrace(); } Update_Student_Panel.clear(); }
				if(tp.getSelectedIndex() == 1) { Add_Student_Panel.clear(); }
			}
		});
		
		return tp;
	}

	protected void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		g.drawImage(bgimage, 1, 1, null);
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
				if(table.getSelectedRow() > -1) 
				{
					selectedIndex = table.getSelectedRow();
					int newrow = table.convertRowIndexToModel(table.getSelectedRow());
					tp.setSelectedIndex(1);
					
					String id = (model.getValueAt(newrow, 0).toString());
					String name = (model.getValueAt(newrow, 1).toString());
					int year = (int) (model.getValueAt(newrow, 2));
					String course = (model.getValueAt(newrow, 3).toString());
					String gender = (model.getValueAt(newrow, 4).toString());
					String contact = (model.getValueAt(newrow, 5).toString());
					String status = (model.getValueAt(newrow, 6).toString());
					
					Update_Student_Panel.txtstudent_id.setText(id);
					Update_Student_Panel.txtstudent_name.setText(name);
					Update_Student_Panel.txtstudent_course.setText(course);
					Update_Student_Panel.txtstudent_year.setText(year+"");
					Update_Student_Panel.txtcontactno.setText(contact); 
					
					if(gender.equalsIgnoreCase("Male")) { Update_Student_Panel.cbogender.setSelectedIndex(0); }
					else { Update_Student_Panel.cbogender.setSelectedIndex(1); }
					
					if(status.equalsIgnoreCase("Active")) { Update_Student_Panel.cbostatus.setSelectedIndex(0); }
					else { Update_Student_Panel.cbostatus.setSelectedIndex(1); }
					
					table.getSelectionModel().setSelectionInterval(selectedIndex, selectedIndex);
					
					if(txtfilter.getText().equals("")) txtfilter.setText("Filter");
					p.grabFocus();
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
		
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(2).setPreferredWidth(30);
		table.setRowHeight(25);
	}
	
	private void filterTable(String query)
	{
		dm = new TableRowSorter<DefaultTableModel>(model);
		table.setRowSorter(dm);

		dm.setRowFilter(RowFilter.regexFilter(query));
//		dm.setRowFilter(RowFilter.regexFilter(query, 1));
	}
}