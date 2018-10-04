package GUI;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Admin_Login_Panel extends JPanel
{
	public static JPasswordField txtpass;
	public static JTextField txtuname;
	public static JButton submit, exit_admin, admin;
	public static JLabel invalid, uname, pass;
	
	Admin_Login_Panel()
	{
		setLayout(null);
		setBounds(0, 0, 450, 350);	
		setVisible(false);
		setBackground(Color.black);

		JLabel title = new JLabel("Administrator Mode");
		pass = new JLabel("Password:");
		uname = new JLabel("Username:");
		invalid = new JLabel("Invalid Username or Password. Please try again.");
		
		txtpass = new JPasswordField();
		txtuname = new JTextField();
		
		exit_admin = new JButton("Exit Admin Mode");
		submit = new JButton("Login");
		admin = new JButton(Shortcut_Keys.getadl());

		title.setFont(new Font("Arial", Font.PLAIN, 24));
		pass.setFont(new Font("Tahoma", Font.PLAIN, 11));
		uname.setFont(new Font("Tahoma", Font.PLAIN, 11));
		exit_admin.setFont(new Font("Tahoma", Font.PLAIN, 9));

		exit_admin.setForeground(Color.BLUE);
		title.setForeground(Color.white);
		uname.setForeground(Color.white);
		pass.setForeground(Color.white);
		invalid.setForeground(Color.RED);
		
		exit_admin.setToolTipText("Return to local user login screen");
		admin.setContentAreaFilled(false);
		invalid.setVisible(false);
		
		exit_admin.addActionListener(new Listeners.Admin_Listener());
		
		submit.setFocusable(false);
		exit_admin.setFocusable(false);
		admin.setFocusable(false);
		
		admin.getActionMap().put("admin login", Shortcut_Keys.getadl());
		admin.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put((KeyStroke) Shortcut_Keys.getadl().getValue(Action.ACCELERATOR_KEY), "admin login");

		txtuname.addKeyListener(new Listeners.Admin_Listener());
		txtpass.addKeyListener(new Listeners.Admin_Listener());
		txtuname.addFocusListener(new Listeners.Admin_Listener());
		txtpass.addFocusListener(new Listeners.Admin_Listener());
		submit.addActionListener(new Listeners.Admin_Listener());
		exit_admin.addActionListener(new Listeners.Admin_Listener());
		
		add(title).setBounds(130, 34, 350, 46);
		add(pass).setBounds(86, 145, 50, 14);
		add(uname).setBounds(86, 106, 55, 21);
		add(txtpass).setBounds(151, 137, 195, 30);
		add(txtuname).setBounds(151, 101, 195, 30);
		add(exit_admin).setBounds(150, 170, 100, 30);
		add(submit).setBounds(256, 170, 90, 30);
		add(invalid).setBounds(90, 200, 289, 50);
		add(admin).setBounds(-172, -63, 1, 1);
	}
}