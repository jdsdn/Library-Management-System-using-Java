package Listeners;

import java.awt.event.*;
import java.sql.SQLException;

import Database.Verifications;
import GUI.Admin_Login_Panel;
import GUI.Main_Frame;

public class Admin_Listener implements ActionListener, KeyListener, FocusListener
{
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource().equals(Admin_Login_Panel.exit_admin)) 
		{ 
			Main_Frame.main_frame.setTitle("Login - Y HASUHL SMART LIBRARY 0.69"); 
			Main_Frame.staff_login.setVisible(true); Main_Frame.ap.setVisible(false); 
			Admin_Login_Panel.invalid.setVisible(false);
		}
		
		if(e.getSource().equals(Admin_Login_Panel.submit)) { try { verify_admin(); } catch (SQLException e1) { e1.printStackTrace(); } }
	}
	
	public void keyReleased(KeyEvent e) 
	{ 
		if(e.getSource().equals(Admin_Login_Panel.txtuname)) { if(e.getKeyCode() == KeyEvent.VK_ENTER) { try { verify_admin(); } catch (SQLException e1) { e1.printStackTrace(); } } }
		if(e.getSource().equals(Admin_Login_Panel.txtpass)) { if(e.getKeyCode() == KeyEvent.VK_ENTER) { try { verify_admin(); } catch (SQLException e1) { e1.printStackTrace(); } } }
	}
	
	public void focusGained(FocusEvent e) 
	{
		if(e.getSource().equals(Admin_Login_Panel.txtuname)) { Admin_Login_Panel.txtuname.selectAll(); }
		if(e.getSource().equals(Admin_Login_Panel.txtpass)) { Admin_Login_Panel.txtpass.selectAll(); }
	}

	public void focusLost(FocusEvent e) 
	{
		if(e.getSource().equals(Admin_Login_Panel.txtuname)) { Admin_Login_Panel.txtuname.select(0, 0); }
		if(e.getSource().equals(Admin_Login_Panel.txtpass)) { Admin_Login_Panel.txtpass.select(0, 0); }
	}
	
	public void keyPressed(KeyEvent arg0) {}
	public void keyTyped(KeyEvent arg0) {}
	
	@SuppressWarnings("deprecation")
	public void verify_admin() throws SQLException
	{
		if(Admin_Login_Panel.txtuname.getText().equalsIgnoreCase("") || Admin_Login_Panel.txtpass.getText().equalsIgnoreCase(""))
		{
			Admin_Login_Panel.invalid.setVisible(true);
		}
		
		else
		{
			if(Verifications.admin_access_granted(Admin_Login_Panel.txtuname.getText(), Admin_Login_Panel.txtpass.getText()))
			{
				Admin_Login_Panel.invalid.setVisible(false);
				Admin_Login_Panel.txtuname.setText("");
				Admin_Login_Panel.txtpass.setText("");
				Admin_Login_Panel.txtuname.requestFocus();
			}
			
			else
			{
				Admin_Login_Panel.invalid.setVisible(true);
				Admin_Login_Panel.txtpass.setText("");
				Admin_Login_Panel.txtuname.requestFocus();
			}
		}
	}
}
