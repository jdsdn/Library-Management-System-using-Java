package GUI;

import java.awt.event.ActionEvent;
import javax.swing.*;

public class Shortcut_Keys 
{
	public static Action adl;
	
	static Action getadl()
	{
		adminlogin();
		return adl;
	}
	
	@SuppressWarnings("serial")
	static void adminlogin()
	{
		adl = new AbstractAction("doSomething") 
		{
		    public void actionPerformed(ActionEvent e) 
		    {
		    	Main_Frame.main_frame.setSize(450, 300);
		    	Main_Frame.main_frame.setLocationRelativeTo(null);
		    	Main_Frame.main_frame.setTitle("Administrator - Y HASUHL SMART LIBRARY 0.69");
		    	Main_Frame.staff_login.setVisible(false);
		    	Main_Frame.ap.setVisible(true);
		    	Admin_Login_Panel.txtuname.requestFocus();
		    }
		};

		adl.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control shift alt F12"));
	}
}