package GUI;

import java.applet.Applet;
import java.awt.*;
import java.sql.SQLException;

import com.thehowtotutorial.splashscreen.JSplash;

import javax.swing.*;

public class Main_Frame {
	
	public static JPasswordField txtpass;
	public static JTextField txtuname;
	public static JButton submit, admin;
	public static JLabel invalid, uname, pass;
	public static JPanel staff_login;
	public static JFrame main_frame;
	public static Admin_Login_Panel ap;
	public static Main_Menu Main_Menu_Panel;
	public static Manage_Student_Panel msp;
	public static Manage_Book_Panel mbp;
	public static Search_Book_Panel sbp;
	public static Manage_Borrower_Panel mbwp;
	public static Settings_Panel sp;
	public static Generate_Report_Panel grp;
	private static int staff_id = 0;
	
	Main_Frame() throws SQLException {

		setDefaults();
				
		main_frame = new JFrame();
		main_frame.setTitle("Login - Y HASUHL SMART LIBRARY 0.69");
		main_frame.setSize(450, 300);
		main_frame.setResizable(false);
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main_frame.setLocationRelativeTo(null);
		
		JPanel b = new JPanel();
		b.setLayout(new OverlayLayout(b));

		staff_login = new JPanel(); 
		staff_login.setLayout(null);

		JLabel title = new JLabel("Y HASUHL SMART LIBRARY");
		pass = new JLabel("Password:");
		uname = new JLabel("User ID:");
		invalid = new JLabel("Invalid Username or Password. Please try again.");

		txtuname = new JTextField("123");
		txtpass = new JPasswordField("admin123");

		submit = new JButton("Login");
		admin = new JButton(Shortcut_Keys.getadl());

		title.setFont(new Font("Arial", Font.PLAIN, 24));
		pass.setFont(new Font("Tahoma", Font.PLAIN, 11));
		uname.setFont(new Font("Tahoma", Font.PLAIN, 11));

		invalid.setForeground(Color.RED);
		txtuname.setForeground(Color.black);
		txtpass.setForeground(Color.black);
		
		submit.setBorder(new Custom_Renderers.Rounded_Border(10));

		admin.setContentAreaFilled(false);
		invalid.setVisible(false);

		submit.setFocusable(false);
		admin.setFocusable(false);

		admin.getActionMap().put("admin login", Shortcut_Keys.getadl());
		admin.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put((KeyStroke) Shortcut_Keys.getadl().getValue(Action.ACCELERATOR_KEY), "admin login");

		txtuname.addKeyListener(new Listeners.MFrame_Listener());
		txtpass.addKeyListener(new Listeners.MFrame_Listener());
		txtuname.addFocusListener(new Listeners.MFrame_Listener());
		txtpass.addFocusListener(new Listeners.MFrame_Listener());
		submit.addActionListener(new Listeners.MFrame_Listener());

		staff_login.add(title).setBounds(63, 34, 350, 46);
		staff_login.add(pass).setBounds(86, 145, 50, 14);
		staff_login.add(uname).setBounds(96, 106, 100, 21);
		staff_login.add(txtpass).setBounds(151, 137, 195, 30);
		staff_login.add(txtuname).setBounds(151, 101, 195, 30);
		staff_login.add(submit).setBounds(246, 170, 100, 30);
		staff_login.add(invalid).setBounds(90, 200, 289, 50);
		staff_login.add(admin).setBounds(172, 63, 1, 1);

		b.add(staff_login).setBounds(0, 0, 450, 300);
		b.add(Main_Menu_Panel = new Main_Menu());
		
		b.add(ap = new Admin_Login_Panel());
		b.add(sbp = new Search_Book_Panel()); 
		b.add(sp = new Settings_Panel());
		b.add(grp = new Generate_Report_Panel());
		b.add(msp = new Manage_Student_Panel());
		b.add(mbwp = new Manage_Borrower_Panel());
		b.add(mbp = new Manage_Book_Panel());
		main_frame.setContentPane(b);
		//main_frame.setUndecorated(true);
		main_frame.setVisible(true);
	}
	
	public static void setDefaults()
	{
		UIDefaults def = UIManager.getLookAndFeelDefaults();
		def.put("TextField.border", BorderFactory.createCompoundBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.white, 1), BorderFactory.createEmptyBorder(0, 1, 1, 1)), BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(2, 1, 1, 1, Color.gray), BorderFactory.createEmptyBorder(2, 3, 1, 1))));
		def.put("TextField.selectionBackground", Color.decode("#820000"));
		def.put("TextField.selectionForeground", Color.white);
		def.put("PasswordField.selectionBackground", Color.decode("#820000"));
		def.put("PasswordField.selectionForeground", Color.white);
		def.put("PasswordField.border", BorderFactory.createCompoundBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.white, 1), BorderFactory.createEmptyBorder(0, 1, 1, 1)), BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(2, 1, 1, 1, Color.gray), BorderFactory.createEmptyBorder(2, 3, 1, 1))));
		def.put("TextArea.border", BorderFactory.createCompoundBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.white, 1), BorderFactory.createEmptyBorder(0, 1, 1, 1)), BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(2, 1, 1, 1, Color.gray), BorderFactory.createEmptyBorder(2, 3, 1, 1))));
		def.put("TextArea.selectionBackground", Color.decode("#820000"));
		def.put("TextArea.selectionForeground", Color.white);
		def.put("ComboBox.foreground", Color.black);
		def.put("ComboBox.background", Color.white);
		def.put("ComboBox.selectionForeground", Color.white);
		def.put("ComboBox.selectionBackground", Color.decode("#820000"));
		def.put("ComboBox.buttonDarkShadow", Color.gray);
		def.put("ComboBox.buttonBackground", Color.white);
		def.put("ComboBox.buttonHighlight",  Color.gray);
		def.put("ComboBox.buttonShadow", Color.white);
		def.put("ComboBox.border", new Custom_Renderers.Rounded_Corner_Border());
		def.put("ComboBox.disabledForeground", Color.DARK_GRAY);
		def.put("ToolTip.background", Color.decode("#820000"));
		def.put("ToolTip.foreground", Color.white);
		def.put("ToolTip.border", BorderFactory.createLineBorder(Color.decode("#820000")));
        def.put("TabbedPane.foreground", Color.white);
        def.put("TabbedPane.background", Color.decode("#820000"));
        def.put("TabbedPane.selected", Color.decode("#b70000"));
        def.put("TabbedPane.borderHightlightColor", Color.decode("#820000")); 
        def.put("TabbedPane.darkShadow", Color.decode("#820000"));
        def.put("TabbedPane.contentAreaColor", Color.decode("#b70000"));
//		def.put("ToolTip.font", new Font("Arial", Font.PLAIN, 11));
	}
	
	public static void main(String[] args) throws InterruptedException
	{
//		displaySplash();
		java.awt.EventQueue.invokeLater(new Runnable() { public void run() { 
		try { new Main_Frame(); } catch (SQLException e) { e.printStackTrace(); } } });
	}
	
	public static int getStaff_id() {
		return staff_id;
	}

	public static void setStaff_id(int staff_id) {
		Main_Frame.staff_id = staff_id;
	}

	public static void displaySplash() throws InterruptedException
	{
		JSplash splash = new JSplash(Main_Frame.class.getResource("frame_0_delay-0.01s.png"), true, true, false, "v1.01.31", null, Color.BLACK, Color.black);
		splash.splashOn();

		for (int i = 1; i <= 100; i++) 
		{
			if(i <= 20)
			{
				splash.setProgress(i, i + "% Loading Prerequisites");
			}

			if(i > 20 && i <= 60)
			{
				splash.setProgress(i, i + "% Fetching Database");
			}

			if(i > 60 && i <= 80)
			{
				splash.setProgress(i, i + "% Applying Configs");
			}

			if(i > 80 && i <= 90)
			{
				splash.setProgress(i, i + "% Finalizing");
			}

			if(i > 90 && i <= 95)
			{
				splash.setProgress(i, i + "% Done");
			}

			if(i > 95 && i <= 100)
			{
				splash.setProgress(i, "Now Starting App");
			}

			Thread.sleep(100);
			new Applet().setVisible(true);
		}

		Thread.sleep(1000);
		splash.splashOff();
	}
}