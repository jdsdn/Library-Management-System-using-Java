package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class Manage_Borrower_Panel extends JPanel {
	
	Image bgimage = null;
	
	public static JLabel lblTime, yhinc, lib, man, mans;
	public static JButton home_button, logout_button;
	public static ImageIcon home, home_hover, logout, logout_hover, btnborrow_icon, btnreturn_icon, btnborrow_hover, btnreturn_hover;
	public static JTabbedPane jtp;
	public static JButton btnborrow, btnreturn;
	public static JFrame frame;
	
	public Manage_Borrower_Panel() {
		
		MediaTracker mt = new MediaTracker(this);
		bgimage = Toolkit.getDefaultToolkit().getImage("./imgs/gro2 - Copy.png");
		mt.addImage(bgimage, 0);
		try { mt.waitForAll(); } catch (InterruptedException e) { e.printStackTrace(); }

		setBorder(BorderFactory.createLineBorder(Color.black, 5));
		setVisible(false);
		setLayout(null);
		
		btnborrow_icon = new ImageIcon("./imgs/borrow_book.png");
		btnreturn_icon = new ImageIcon("./imgs/return_book.png");
		
		btnborrow_hover = new ImageIcon("./imgs/borrow_book_hover.png");
		btnreturn_hover = new ImageIcon("./imgs/return_book_hover.png");
		
		btnborrow = new JButton(btnborrow_icon);
		btnreturn = new JButton(btnreturn_icon);
		
		btnborrow.setFocusable(false);
		btnreturn.setFocusable(false);
		
		btnborrow.setBorder(BorderFactory.createLineBorder(Color.white));
		btnreturn.setBorder(BorderFactory.createLineBorder(Color.white));
		
		btnborrow.addMouseListener(new Listeners.Main_Menu_Listener());
		btnreturn.addMouseListener(new Listeners.Main_Menu_Listener());
		
		btnborrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { 
				showBorrow();
			}
		});
		
		btnreturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GUI.Borrower_List_Panel.returnbook();
			}
		});
		
		yhinc = new JLabel("HASUHL KAHYO INCORPORATED");
		lib = new JLabel("L i b r a r y");
		man = new JLabel("Management");
		mans = new JLabel("Manage Borrowers");
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
		
		add(btnreturn).setBounds(940, 509, 100, 31);
		add(btnborrow).setBounds(830, 509, 100, 31);
		
		add(gettabp()).setBounds(20, 115, 1040, 438);
		add(home_button).setBounds(11, 566, 91, 61);
		add(logout_button).setBounds(978, 566, 91, 61);
		add(lblTime).setBounds(965, 75, 150, 30);
		add(lib).setBounds(525, 588, 200, 30);
		add(man).setBounds(567, 610, 200, 30);
		add(mans).setBounds(15, 30, 350, 50);
	}
	
	public static void showBorrow()
	{
		frame = new JFrame();
		frame.setSize(835, 575);
		frame.setLocationRelativeTo(null);
		frame.setContentPane(new Issue_Book_Panel());
		frame.setUndecorated(true);
		frame.setVisible(true);
	}
	
	public static void showReturn()
	{
		frame = new JFrame();
		frame.setSize(835, 575);
		frame.setLocationRelativeTo(null);
		frame.setContentPane(new Return_Book_Panel());
		frame.setUndecorated(true);
		frame.setVisible(true);
	}
	
	private static JTabbedPane gettabp() {
		
		jtp = new JTabbedPane();
		jtp.setUI(new Custom_Renderers.Spaced_Tabbed_Pane_UI());
		
//		jtp.add("<html><body><table width='322'>Borrow a Book</table></body></html>", new JPanel());
//		jtp.add("<html><body><table width='325'>List of Borrowers</table></body></html>", new JPanel());
		jtp.add("<html><body><table width='200'>List of Borrowers</table></body></html>", new Borrower_List_Panel());
//		jtp.add("<html><body><table width='322'>Return a Book</table></body></html>", new JPanel());
		
		jtp.setFocusable(false);
		
		return jtp;
	}
	
	protected void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		g.drawImage(bgimage, 1, 1, null);
	}
}