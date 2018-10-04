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
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

@SuppressWarnings("serial")
public class Manage_Book_Panel extends JPanel {

	Image bgimage = null;

	public static JLabel lblTime, yhinc, lib, man, mans;
	public static JButton home_button, logout_button;
	public static ImageIcon home, home_hover, logout, logout_hover, addb_hover, editb_hover, addb_icon, editb_icon;
	public static JTabbedPane jtp;
	public static JTextField txtfilter;
	public static JButton editb, addb;
	public static JFrame f;

	public Manage_Book_Panel() {

		MediaTracker mt = new MediaTracker(this);
		bgimage = Toolkit.getDefaultToolkit().getImage("./imgs/gro2 - Copy.png");
		mt.addImage(bgimage, 0);
		try { mt.waitForAll(); } catch (InterruptedException e) { e.printStackTrace(); }

		setBorder(BorderFactory.createLineBorder(Color.black, 5));
		setVisible(false);
		setLayout(null);
		
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(txtfilter.getText().equals("")) txtfilter.setText("Filter");
				grabFocus();
				try { Book_List_Panel.filltable(); } catch (SQLException se) { se.printStackTrace(); }
			}
		});

		yhinc = new JLabel("HASUHL KAHYO INCORPORATED");
		lib = new JLabel("L i b r a r y");
		man = new JLabel("Management");
		mans = new JLabel("Book Management");
		lblTime = new JLabel("");

		yhinc.setFont(new Font("Serif", Font.BOLD, 42));
		lib.setFont(new Font("Serif", Font.BOLD, 22));
		man.setFont(new Font("Serif", Font.BOLD, 11));
		mans.setFont(new Font("Serif", Font.BOLD, 33));
		lblTime.setFont(new Font("Serif", Font.PLAIN, 18));

		yhinc.setForeground(Color.white);
		man.setForeground(Color.white);
		lib.setForeground(Color.white);
		mans.setForeground(Color.white);
		lblTime.setForeground(Color.white);

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
		
		addb_icon = new ImageIcon("./imgs/add_book.png");
		editb_icon = new ImageIcon("./imgs/edit_button.png");
		
		addb_hover = new ImageIcon("./imgs/add_book_hover.png");
		editb_hover = new ImageIcon("./imgs/edit_button_hover.png");
		
		editb = new JButton(editb_icon);
		addb = new JButton(addb_icon);
		
		editb.setFocusable(false);
		addb.setFocusable(false);
		
		editb.setBorder(BorderFactory.createLineBorder(Color.white));
		addb.setBorder(BorderFactory.createLineBorder(Color.white));
		
		addb.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent arg0) { showAdd(); } });
		editb.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent arg0) { Book_List_Panel.edit(); } });
		
		addb.addMouseListener(new Listeners.Main_Menu_Listener());
		editb.addMouseListener(new Listeners.Main_Menu_Listener());
		
		JLabel filtericon = new JLabel(new ImageIcon("./imgs/filter_icon.png"));
		txtfilter = new JTextField("Filter");
		txtfilter.setFont(new Font("Serif", Font.BOLD, 18));
		txtfilter.setForeground(Color.decode("#820000"));
		txtfilter.setBorder(BorderFactory.createCompoundBorder(Book_List_Panel.a, Book_List_Panel.d));
		
		txtfilter.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent arg0) { txtfilter.select(0, 0); if(txtfilter.getText().equals("")) { txtfilter.setText("Filter"); } }
			public void focusGained(FocusEvent arg0) { txtfilter.selectAll(); }
		});
		
		txtfilter.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent arg0) {
				String query = txtfilter.getText();
				filterTable(query);
			}
		});
		
		add(txtfilter).setBounds(66, 505, 150, 30);
		add(filtericon).setBounds(33, 504, 30, 30);
		add(editb).setBounds(950, 504, 80, 31);
		add(addb).setBounds(830, 504, 100, 31);

		add(gettabp()).setBounds(20, 120, 1040, 428);
		add(home_button).setBounds(11, 566, 91, 61);
		add(logout_button).setBounds(978, 566, 91, 61);
		add(lblTime).setBounds(965, 75, 150, 30);
		add(lib).setBounds(525, 588, 200, 30);
		add(man).setBounds(567, 610, 200, 30);
		add(mans).setBounds(15, 30, 350, 50);
	}
	
	public static void showAdd()
	{
		f = new JFrame();
		f.setSize(1041, 460);
		f.setLayout(null);
		f.setContentPane(new Add_Book_Panel());
		f.setUndecorated(true);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
	
	public static void showUpdate()
	{
		f = new JFrame();
		f.setSize(1041, 460);
		f.setLayout(null);
		f.setContentPane(new Update_Book_Panel());
		f.setUndecorated(true);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
	
	private static void filterTable(String query)
	{
		Book_List_Panel.dm = new TableRowSorter<DefaultTableModel>(Book_List_Panel.model);
		Book_List_Panel.table.setRowSorter(Book_List_Panel.dm);
		
		Book_List_Panel.dm.setRowFilter(RowFilter.regexFilter(query));
		Book_List_Panel.selectedIndex = -1;
	}

	private static JTabbedPane gettabp() {

		jtp = new JTabbedPane();
		jtp.setUI(new Custom_Renderers.Spaced_Tabbed_Pane_UI());

//		jtp.add("<html><body><table width='325'>List of Books</table></body></html>", new Book_List_Panel());
		jtp.add("<html><body><table width='200'>List of Books</table></body></html>", new Book_List_Panel());
		
		jtp.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(jtp.getSelectedIndex() == 1) {
					lblTime.grabFocus();
				}
			}
		});

		jtp.setFocusable(false);

		return jtp;
	}

	protected void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		g.drawImage(bgimage, 1, 1, null);
	}
}