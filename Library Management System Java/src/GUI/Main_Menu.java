package GUI;

import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class Main_Menu extends JPanel 
{
	Image bgimage = null;

	public static JLabel lblTime, lbllg, lblmanb, lblmb, lblms, lblsb, lblset, lblo1, lblo2, lib, man, yhinc, mode;
	public static JButton logout_button, manageborrower_button, mb_button, ms_button, sb_button, settings, generate_report_button, o2_button;
	public static ImageIcon logout_hover, manageborrower_hover, mb_hover, ms_hover, sb_hover, set_hover, o1_hover, o2_hover;
	public static ImageIcon logout, manageborrower, mb, ms, sb, set, o1, o2;
	
	Main_Menu() 
	{
		MediaTracker mt = new MediaTracker(this);
		bgimage = Toolkit.getDefaultToolkit().getImage("./imgs/gro - Copy.png");
		mt.addImage(bgimage, 0);
		try { mt.waitForAll(); } catch (InterruptedException e) { e.printStackTrace(); }
		
		setBorder(BorderFactory.createLineBorder(Color.black, 5));
		setVisible(false);
		setLayout(null);
		
		yhinc = new JLabel("HASUHL KAHYO INCORPORATED");
		mode = new JLabel("Administrator");
		lib = new JLabel("L i b r a r y");
		man = new JLabel("Management");
		lblTime = new JLabel("");
		
		yhinc.setFont(new Font("Serif", Font.BOLD, 42));
		mode.setFont(new Font("Serif", Font.BOLD, 27));
		lib.setFont(new Font("Serif", Font.BOLD, 27));
		man.setFont(new Font("Serif", Font.BOLD, 14));
		lblTime.setFont(new Font("Serif", Font.PLAIN, 21));
		
		yhinc.setForeground(Color.white);
		mode.setForeground(Color.white);
		man.setForeground(Color.white);
		lib.setForeground(Color.white);
		lblTime.setForeground(Color.white);

		logout = new ImageIcon("./imgs/logout_button.png");
		manageborrower = new ImageIcon("./imgs/manageborrower_button.png");
		mb = new ImageIcon("./imgs/mb_button.png");
		ms = new ImageIcon("./imgs/ms_button.png");
		sb = new ImageIcon("./imgs/sb_button.png");
		set = new ImageIcon("./imgs/settings.png");
		o1 = new ImageIcon("./imgs/o1.png");
		o2 = new ImageIcon("./imgs/o2.png");

		logout_hover = new ImageIcon("./imgs/logout_button_hover.png");
		manageborrower_hover = new ImageIcon("./imgs/manageborrower_button_hover.png");
		mb_hover = new ImageIcon("./imgs/mb_button_hover.png");
		ms_hover = new ImageIcon("./imgs/ms_button_hover.png");
		sb_hover = new ImageIcon("./imgs/sb_button_hover.png");
		set_hover = new ImageIcon("./imgs/settings_hover.png");
		o1_hover  = new ImageIcon("./imgs/o1_hover.png");
		o2_hover  = new ImageIcon("./imgs/o2_hover.png");

		logout_button = new JButton(logout);
		manageborrower_button = new JButton(manageborrower);
		mb_button = new JButton(mb);
		ms_button = new JButton(ms);
		sb_button = new JButton(sb);
		settings = new JButton(set);
		generate_report_button = new JButton(o1);
		o2_button = new JButton(o2);
		
		sb_button.addActionListener(new Listeners.Main_Menu_Listener());
		mb_button.addActionListener(new Listeners.Main_Menu_Listener());
		ms_button.addActionListener(new Listeners.Main_Menu_Listener());
		settings.addActionListener(new Listeners.Main_Menu_Listener());
		generate_report_button.addActionListener(new Listeners.Main_Menu_Listener());
		o2_button.addActionListener(new Listeners.Main_Menu_Listener());
		logout_button.addActionListener(new Listeners.Main_Menu_Listener());
		manageborrower_button.addActionListener(new Listeners.Main_Menu_Listener());

		sb_button.addMouseListener(new Listeners.Main_Menu_Listener());
		mb_button.addMouseListener(new Listeners.Main_Menu_Listener());
		ms_button.addMouseListener(new Listeners.Main_Menu_Listener());
		settings.addMouseListener(new Listeners.Main_Menu_Listener());
		generate_report_button.addMouseListener(new Listeners.Main_Menu_Listener());
		o2_button.addMouseListener(new Listeners.Main_Menu_Listener());
		logout_button.addMouseListener(new Listeners.Main_Menu_Listener());
		manageborrower_button.addMouseListener(new Listeners.Main_Menu_Listener());

		//add(yhinc).setBounds(360, 30, 1000, 50);
		
		add(mode).setBounds(45, 145, 200, 30);
		add(lblTime).setBounds(955, 95, 150, 30);
		add(logout_button).setBounds(835, 410, 159, 159);
		add(manageborrower_button).setBounds(836, 220, 159, 159);;
		add(sb_button).setBounds(580, 218, 159, 159);
		add(ms_button).setBounds(92, 218, 159, 159);
		add(mb_button).setBounds(337, 218, 159, 159);
		add(settings).setBounds(92, 415, 159, 159);
		add(generate_report_button).setBounds(338, 412, 159, 159);
		add(o2_button).setBounds(581, 410, 159, 159);
		add(lib).setBounds(75, 65, 200, 30);
		add(man).setBounds(129, 90, 100, 30);
	}

	protected void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		g.drawImage(bgimage, 1, 1, null);
	}
}