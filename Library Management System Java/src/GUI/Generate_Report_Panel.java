package GUI;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

@SuppressWarnings("serial")
public class Generate_Report_Panel extends JPanel {
	
	Image bgimage = null;
	
	public static JLabel lblTime, yhinc, lib, man, mans;
	public static JButton home_button, logout_button;
	public static ImageIcon home, home_hover, logout, logout_hover;
	public static JTabbedPane jtp;
	
	public Generate_Report_Panel() {
		
		MediaTracker mt = new MediaTracker(this);
		bgimage = Toolkit.getDefaultToolkit().getImage("./imgs/gro2 - Copy.png");
		mt.addImage(bgimage, 0);
		try { mt.waitForAll(); } catch (InterruptedException e) { e.printStackTrace(); }

		setBorder(BorderFactory.createLineBorder(Color.black, 5));
		setVisible(false);
		setLayout(null);
		
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(GUI.Transaction_List_Panel.txtfilter.getText().equals("")) GUI.Transaction_List_Panel.txtfilter.setText("Filter");
				grabFocus();
			}
		});
		
		yhinc = new JLabel("HASUHL KAHYO INCORPORATED");
		lib = new JLabel("L i b r a r y");
		man = new JLabel("Management");
		mans = new JLabel("Generate Reports");
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
		
		add(gettabp()).setBounds(20, 115, 1040, 438);
		add(home_button).setBounds(11, 566, 91, 61);
		add(logout_button).setBounds(978, 566, 91, 61);
		add(lblTime).setBounds(965, 75, 150, 30);
		add(lib).setBounds(525, 588, 200, 30);
		add(man).setBounds(567, 610, 200, 30);
		add(mans).setBounds(15, 30, 350, 50);
	}
	
	private static JTabbedPane gettabp() {
		
		jtp = new JTabbedPane();
		jtp.setUI(new Custom_Renderers.Spaced_Tabbed_Pane_UI());
		
		jtp.add("<html><body><table width='322'>Student Information</table></body></html>", new Student_List_Panel());
		jtp.add("<html><body><table width='325'>Book Information</table></body></html>", new Book_List_Panel());
		jtp.add("<html><body><table width='322'>Transaction History</table></body></html>", new Transaction_List_Panel());
		
		jtp.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(jtp.getSelectedIndex() == 0) {
					try { GUI.Student_List_Panel.filltable(); } catch (SQLException e) { e.printStackTrace(); }
				}
				
				if(jtp.getSelectedIndex() == 1) {
					try { GUI.Book_List_Panel.filltable(); } catch (SQLException e) { e.printStackTrace(); }
				}
				
				if(jtp.getSelectedIndex() == 2) {
					try { GUI.Transaction_List_Panel.filltable("select t.Issue_Code as 'Issue Code', bi.book_name as 'Book Name', si.Student_Name as 'Student Name', sti.Staff_Name as 'Staff Name', t.Transaction_Type as 'Transaction Type', t.borrow_date as 'Issue Date', t.due_date as 'Due Date', t.return_date as 'Return Date', t.Late_Fee as 'Late Fee' from transactionhistory t INNER JOIN book_info Bi on t.Book_ID = bi.book_id inner JOIN student_info si on t.Student_ID = si.Student_ID INNER JOIN staff_info sti on t.Staff_ID = sti.StaffID"); } catch (SQLException e) {e.printStackTrace(); }
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
	
	public static void filterTable(String query)
	{
		Transaction_List_Panel.dm = new TableRowSorter<DefaultTableModel>(Transaction_List_Panel.model);
		Transaction_List_Panel.table.setRowSorter(Transaction_List_Panel.dm);
		Transaction_List_Panel.dm.setRowFilter(RowFilter.regexFilter(query));
		Transaction_List_Panel.selectedIndex = -1;
	}
}