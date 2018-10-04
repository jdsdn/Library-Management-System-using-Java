package Listeners;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.border.CompoundBorder;

import Database.Verifications;
import GUI.*;

public class MFrame_Listener implements ActionListener, KeyListener, FocusListener 
{
	CompoundBorder b = new CompoundBorder(BorderFactory.createMatteBorder(2, 1, 1, 1, Color.gray), BorderFactory.createEmptyBorder(2, 3, 1, 1));
	CompoundBorder c = new CompoundBorder(BorderFactory.createLineBorder(Color.white, 1), BorderFactory.createEmptyBorder(0, 1, 1, 1));
	CompoundBorder d = new CompoundBorder(BorderFactory.createMatteBorder(2, 1, 1, 1, Color.white), BorderFactory.createEmptyBorder(2, 3, 1, 1));
	CompoundBorder a = new CompoundBorder(BorderFactory.createMatteBorder(2, 1, 1, 1, Color.decode("#820000")), BorderFactory.createEmptyBorder(0, 1, 1, 1));
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource().equals(GUI.Main_Frame.submit)) { try { Verify(); } catch (SQLException e1) { e1.printStackTrace(); } }
	}

	public void keyReleased(KeyEvent e) 
	{
		if(e.getSource().equals(GUI.Main_Frame.txtuname)) { if(e.getKeyCode() == KeyEvent.VK_ENTER) { try { Verify(); } catch (SQLException e1) { e1.printStackTrace(); } } }
		if(e.getSource().equals(GUI.Main_Frame.txtpass)) { if(e.getKeyCode() == KeyEvent.VK_ENTER) { try { Verify(); } catch (SQLException e1) { e1.printStackTrace(); } } }
	}

	public void focusGained(FocusEvent e) 
	{
		if(e.getSource().equals(Main_Frame.txtuname)) { Main_Frame.txtuname.setBorder(BorderFactory.createCompoundBorder(a, d)); Main_Frame.txtuname.selectAll(); }
		if(e.getSource().equals(Main_Frame.txtpass)) { Main_Frame.txtpass.setBorder(BorderFactory.createCompoundBorder(a, d)); Main_Frame.txtpass.selectAll(); }
	}

	public void focusLost(FocusEvent e) 
	{
		if(e.getSource().equals(Main_Frame.txtuname)) { Main_Frame.txtuname.setBorder(BorderFactory.createCompoundBorder(c, b)); Main_Frame.txtuname.select(0, 0); }
		if(e.getSource().equals(Main_Frame.txtpass)) { Main_Frame.txtpass.setBorder(BorderFactory.createCompoundBorder(c, b)); Main_Frame.txtpass.select(0, 0); }
	}

	public void keyPressed(KeyEvent arg0) {}
	public void keyTyped(KeyEvent arg0) {}

	@SuppressWarnings("deprecation")
	private void Verify() throws SQLException
	{
		if(GUI.Main_Frame.txtuname.getText().equalsIgnoreCase("") || GUI.Main_Frame.txtpass.getText().equalsIgnoreCase(""))
		{
			GUI.Main_Frame.invalid.setVisible(true);
			GUI.Main_Frame.uname.setForeground(Color.red);
			GUI.Main_Frame.pass.setForeground(Color.red);
			GUI.Main_Frame.txtpass.setText("");
			GUI.Main_Frame.txtuname.requestFocus();
			
			return;
		}
		
		else
		{
			if(parseStrToInt(GUI.Main_Frame.txtuname.getText()))
			{
				int a = Integer.parseInt(GUI.Main_Frame.txtuname.getText());
				String b = GUI.Main_Frame.txtpass.getText();

				if(Verifications.access_granted(a, b))
				{
					GUI.Main_Frame.Main_Menu_Panel.setVisible(true);
					GUI.Main_Frame.staff_login.setVisible(false);
					GUI.Main_Frame.main_frame.setTitle("Y HASUHL SMART LIBRARY 0.69");
					GUI.Main_Frame.main_frame.setSize(1085, 678);
					GUI.Main_Frame.main_frame.setLocationRelativeTo(null);
					GUI.Main_Frame.invalid.setVisible(false);
//					GUI.Main_Frame.txtuname.setText("");
//					GUI.Main_Frame.txtpass.setText("");
					GUI.Main_Frame.uname.setForeground(Color.black);
					GUI.Main_Frame.pass.setForeground(Color.black);
					GUI.Main_Frame.txtuname.requestFocus();
					GUI.Main_Frame.setStaff_id(a);
				}

				else
				{
					GUI.Main_Frame.invalid.setVisible(true);
					GUI.Main_Frame.uname.setForeground(Color.red);
					GUI.Main_Frame.pass.setForeground(Color.red);
					GUI.Main_Frame.txtpass.setText("");
					GUI.Main_Frame.txtuname.requestFocus();
				}
			}
			
			else
			{
				GUI.Main_Frame.invalid.setVisible(true);
				GUI.Main_Frame.uname.setForeground(Color.red);
				GUI.Main_Frame.pass.setForeground(Color.red);
				GUI.Main_Frame.txtpass.setText("");
				GUI.Main_Frame.txtuname.requestFocus();
			}
		}
	}
	
	public static boolean parseStrToInt(String str) 
	{
        if (str.matches("\\d+")) { return true; } 
        else { return false; }
    }
}