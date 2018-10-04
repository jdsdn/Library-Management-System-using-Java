package GUI;

import java.awt.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class Settings_Panel extends JPanel {
	
	Image bgimage = null;
	
	public static JLabel lblTime, yhinc, lib, man, mans;
	public static JButton home_button, logout_button;
	public static ImageIcon home, home_hover, logout, logout_hover;
	public static JTabbedPane jtp;
	
	public Settings_Panel() {
		
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
		mans = new JLabel("Settings");
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
				
		add(home_button).setBounds(11, 566, 91, 61);
		add(logout_button).setBounds(978, 566, 91, 61);
		add(lblTime).setBounds(965, 75, 150, 30);
		add(lib).setBounds(525, 588, 200, 30);
		add(man).setBounds(567, 610, 200, 30);
		add(mans).setBounds(15, 30, 350, 50);
		add(gettabp()).setBounds(20, 120, 1040, 428);
	}
	
	protected void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		g.drawImage(bgimage, 1, 1, null);
	}
	
	private static JTabbedPane gettabp() {
		
		jtp = new JTabbedPane();
		jtp.setUI(new Custom_Renderers.Spaced_Tabbed_Pane_UI());
		
		jtp.add("<html><body><table width='322'>Book Settings</table></body></html>", new Cats_Panel());
		
		jtp.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
//				if(jtp.getSelectedIndex() == 0) {
//				}
			}
		});
		
		jtp.setFocusable(false);
		
		return jtp;
	}
}