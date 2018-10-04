package GUI;

import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class Search_Book_Panel extends JPanel {
	
	Image bgimage = null;
	
	public static JLabel lblTime, yhinc, lib, man, mans;
	public static JButton home_button, logout_button;
	public static ImageIcon home, home_hover, logout, logout_hover;
	public static JTabbedPane jtp;
	
	public Search_Book_Panel() {
		
		MediaTracker mt = new MediaTracker(this);
		bgimage = Toolkit.getDefaultToolkit().getImage("./imgs/gro2 - Copy.png");
		mt.addImage(bgimage, 0);
		try { mt.waitForAll(); } catch (InterruptedException e) { e.printStackTrace(); }

		setBorder(BorderFactory.createLineBorder(Color.black, 5));
		setVisible(false);
		setLayout(null);
		
		yhinc = new JLabel("HASUHL KAHYO INCORPORATED");
		lib = new JLabel("L i b r a r y");
		man = new JLabel("Management");
		mans = new JLabel("Search Books");
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
		
		jtp.add("<html><body><table width='322'>Search by Choice 1</table></body></html>", new JPanel());
		jtp.add("<html><body><table width='325'>Search by Choice 2</table></body></html>", new JPanel());
		jtp.add("<html><body><table width='322'>Search by Choice 3</table></body></html>", new JPanel());
		
		jtp.setFocusable(false);
		
		return jtp;
	}
	
	protected void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		g.drawImage(bgimage, 1, 1, null);
	}
}