package Listeners;

import java.awt.event.*;
import java.sql.SQLException;

public class Main_Menu_Listener implements MouseListener, ActionListener
{
	public void mouseClicked(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}

	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource().equals(GUI.Main_Menu.logout_button))
		{
			GUI.Main_Frame.main_frame.setTitle("Login - Y HASUHL SMART LIBRARY 0.69");
			GUI.Main_Frame.main_frame.setSize(450, 300);
			GUI.Main_Frame.main_frame.setLocationRelativeTo(null);
			GUI.Main_Frame.staff_login.setVisible(true);
			GUI.Main_Frame.Main_Menu_Panel.setVisible(false);
		}
		
		if(e.getSource().equals(GUI.Main_Menu.ms_button))
		{
			GUI.Main_Frame.msp.setVisible(true);
			GUI.Main_Frame.Main_Menu_Panel.setVisible(false);
		}
		
		if(e.getSource().equals(GUI.Main_Menu.mb_button))
		{
			try { GUI.Book_List_Panel.filltable(); } catch (SQLException e1) { e1.printStackTrace(); }
			GUI.Main_Frame.Main_Menu_Panel.setVisible(false);
			GUI.Main_Frame.mbp.setVisible(true);
		}
		
		if(e.getSource().equals(GUI.Main_Menu.sb_button))
		{
			GUI.Main_Frame.Main_Menu_Panel.setVisible(false);
			GUI.Main_Frame.sbp.setVisible(true);
		}
		
		if(e.getSource().equals(GUI.Main_Menu.manageborrower_button))
		{
			try { GUI.Borrower_List_Panel.filltable(); } catch (SQLException e1) { e1.printStackTrace(); }
			GUI.Main_Frame.Main_Menu_Panel.setVisible(false);
			GUI.Main_Frame.mbwp.setVisible(true);
		}
		
		if(e.getSource().equals(GUI.Main_Menu.settings))
		{
			try { GUI.Cats_Panel.filltable("select category_id as 'ID', category as 'Category' from book_categories"); } catch (SQLException e1) { e1.printStackTrace(); }
			try { GUI.Cats_Panel.filltable1("select type_id as 'ID', types as 'Types' from book_types"); } catch (SQLException e1) { e1.printStackTrace(); }
			GUI.Main_Frame.Main_Menu_Panel.setVisible(false);
			GUI.Main_Frame.sp.setVisible(true);
		}
		
		if(e.getSource().equals(GUI.Main_Menu.generate_report_button))
		{
			GUI.Main_Frame.Main_Menu_Panel.setVisible(false);
			GUI.Main_Frame.grp.setVisible(true);
		}
		
		if(e.getSource().equals(GUI.Manage_Student_Panel.home_button))
		{
			try { GUI.Manage_Student_Panel.filltable("select Student_ID as 'ID', Student_Name as 'Name', Student_Year as 'Year', Student_Course as 'Course', Student_Gender as 'Gender', Student_Contact as 'Contact', Student_Status as 'Status' from Student_Info"); } catch (SQLException e1) { e1.printStackTrace(); }
			GUI.Manage_Student_Panel.tp.setSelectedIndex(0);
			GUI.Main_Frame.Main_Menu_Panel.setVisible(true);
			GUI.Main_Frame.msp.setVisible(false);
		}
		
		if(e.getSource().equals(GUI.Manage_Student_Panel.logout_button))
		{
			try { GUI.Manage_Student_Panel.filltable("select Student_ID as 'ID', Student_Name as 'Name', Student_Year as 'Year', Student_Course as 'Course', Student_Gender as 'Gender', Student_Contact as 'Contact', Student_Status as 'Status' from Student_Info"); } catch (SQLException e1) { e1.printStackTrace(); }
			GUI.Manage_Student_Panel.tp.setSelectedIndex(0);
			GUI.Main_Frame.main_frame.setTitle("Login - Y HASUHL SMART LIBRARY 0.69");
			GUI.Main_Frame.main_frame.setSize(450, 300);
			GUI.Main_Frame.main_frame.setLocationRelativeTo(null);
			GUI.Main_Frame.staff_login.setVisible(true);
			GUI.Main_Frame.Main_Menu_Panel.setVisible(false);
			GUI.Main_Frame.msp.setVisible(false);
		}
		
		// manage books
		
		if(e.getSource().equals(GUI.Manage_Book_Panel.home_button))
		{
			try { GUI.Book_List_Panel.filltable(); } catch (SQLException e1) { e1.printStackTrace(); }
			GUI.Main_Frame.Main_Menu_Panel.setVisible(true);
			GUI.Main_Frame.mbp.setVisible(false);
		}
		
		if(e.getSource().equals(GUI.Manage_Book_Panel.logout_button))
		{
			GUI.Main_Frame.main_frame.setTitle("Login - Y HASUHL SMART LIBRARY 0.69");
			GUI.Main_Frame.main_frame.setSize(450, 300);
			GUI.Main_Frame.main_frame.setLocationRelativeTo(null);
			GUI.Main_Frame.staff_login.setVisible(true);
			GUI.Main_Frame.Main_Menu_Panel.setVisible(false);
			GUI.Main_Frame.mbp.setVisible(false);
		}
		
		// search book
		
		if(e.getSource().equals(GUI.Search_Book_Panel.home_button))
		{
			GUI.Main_Frame.Main_Menu_Panel.setVisible(true);
			GUI.Main_Frame.sbp.setVisible(false);
		}
		
		if(e.getSource().equals(GUI.Search_Book_Panel.logout_button))
		{
			GUI.Main_Frame.main_frame.setTitle("Login - Y HASUHL SMART LIBRARY 0.69");
			GUI.Main_Frame.main_frame.setSize(450, 300);
			GUI.Main_Frame.main_frame.setLocationRelativeTo(null);
			GUI.Main_Frame.staff_login.setVisible(true);
			GUI.Main_Frame.Main_Menu_Panel.setVisible(false);
			GUI.Main_Frame.sbp.setVisible(false);
		}
		
		// manage borrower
		
		if(e.getSource().equals(GUI.Manage_Borrower_Panel.home_button))
		{
			GUI.Main_Frame.Main_Menu_Panel.setVisible(true);
			GUI.Main_Frame.mbwp.setVisible(false);
			try { GUI.Transaction_List_Panel.filltable("select * from transactionhistory"); } catch (SQLException es) {es.printStackTrace(); }
		}
		
		if(e.getSource().equals(GUI.Manage_Borrower_Panel.logout_button))
		{
			GUI.Main_Frame.main_frame.setTitle("Login - Y HASUHL SMART LIBRARY 0.69");
			GUI.Main_Frame.main_frame.setSize(450, 300);
			GUI.Main_Frame.main_frame.setLocationRelativeTo(null);
			GUI.Main_Frame.staff_login.setVisible(true);
			GUI.Main_Frame.Main_Menu_Panel.setVisible(false);
			GUI.Main_Frame.mbwp.setVisible(false);
		}
		
		// settings
		
		if(e.getSource().equals(GUI.Settings_Panel.home_button))
		{
			GUI.Cats_Panel.txtaddcat.setText("");
			GUI.Cats_Panel.txtaddtype.setText("");
			GUI.Main_Frame.Main_Menu_Panel.setVisible(true);
			GUI.Main_Frame.sp.setVisible(false);
		}
		
		if(e.getSource().equals(GUI.Settings_Panel.logout_button))
		{
			GUI.Main_Frame.main_frame.setTitle("Login - Y HASUHL SMART LIBRARY 0.69");
			GUI.Main_Frame.main_frame.setSize(450, 300);
			GUI.Main_Frame.main_frame.setLocationRelativeTo(null);
			GUI.Main_Frame.staff_login.setVisible(true);
			GUI.Main_Frame.Main_Menu_Panel.setVisible(false);
			GUI.Main_Frame.sp.setVisible(false);
		}
		
		// generate report
		
		if(e.getSource().equals(GUI.Generate_Report_Panel.home_button))
		{
			GUI.Main_Frame.Main_Menu_Panel.setVisible(true);
			GUI.Main_Frame.grp.setVisible(false);
			try { GUI.Student_List_Panel.filltable(); } catch (SQLException ed) { ed.printStackTrace(); }
			try { GUI.Book_List_Panel.filltable(); } catch (SQLException eas) { eas.printStackTrace(); }
			GUI.Generate_Report_Panel.jtp.setSelectedIndex(0);
		}
		
		if(e.getSource().equals(GUI.Generate_Report_Panel.logout_button))
		{
			GUI.Main_Frame.main_frame.setTitle("Login - Y HASUHL SMART LIBRARY 0.69");
			GUI.Main_Frame.main_frame.setSize(450, 300);
			GUI.Main_Frame.main_frame.setLocationRelativeTo(null);
			GUI.Main_Frame.staff_login.setVisible(true);
			GUI.Main_Frame.Main_Menu_Panel.setVisible(false);
			GUI.Main_Frame.grp.setVisible(false);
		}
	}

	public void mouseEntered(MouseEvent e) 
	{
		if(e.getSource().equals(GUI.Main_Menu.logout_button)) { GUI.Main_Menu.logout_button.setIcon(GUI.Main_Menu.logout_hover); }
		if(e.getSource().equals(GUI.Main_Menu.manageborrower_button)){ GUI.Main_Menu.manageborrower_button.setIcon(GUI.Main_Menu.manageborrower_hover); }
		if(e.getSource().equals(GUI.Main_Menu.sb_button)) { GUI.Main_Menu.sb_button.setIcon(GUI.Main_Menu.sb_hover); }		
		if(e.getSource().equals(GUI.Main_Menu.mb_button)) { GUI.Main_Menu.mb_button.setIcon(GUI.Main_Menu.mb_hover); }		
		if(e.getSource().equals(GUI.Main_Menu.ms_button)) { GUI.Main_Menu.ms_button.setIcon(GUI.Main_Menu.ms_hover); }		
		if(e.getSource().equals(GUI.Main_Menu.settings )) { GUI.Main_Menu.settings.setIcon(GUI.Main_Menu.set_hover); }		
		if(e.getSource().equals(GUI.Main_Menu.generate_report_button)) { GUI.Main_Menu.generate_report_button.setIcon(GUI.Main_Menu.o1_hover); }		
		if(e.getSource().equals(GUI.Main_Menu.o2_button)) { GUI.Main_Menu.o2_button.setIcon(GUI.Main_Menu.o2_hover); }
		if(e.getSource().equals(GUI.Manage_Student_Panel.home_button)) { GUI.Manage_Student_Panel.home_button.setIcon(GUI.Manage_Student_Panel.home_hover); }
		if(e.getSource().equals(GUI.Manage_Student_Panel.logout_button)) { GUI.Manage_Student_Panel.logout_button.setIcon(GUI.Manage_Student_Panel.logout_hover); }
		if(e.getSource().equals(GUI.Manage_Book_Panel.addb)) { GUI.Manage_Book_Panel.addb.setIcon(GUI.Manage_Book_Panel.addb_hover); }
		if(e.getSource().equals(GUI.Manage_Book_Panel.editb)) { GUI.Manage_Book_Panel.editb.setIcon(GUI.Manage_Book_Panel.editb_hover); }
		if(e.getSource().equals(GUI.Manage_Borrower_Panel.btnborrow)) { GUI.Manage_Borrower_Panel.btnborrow.setIcon(GUI.Manage_Borrower_Panel.btnborrow_hover); }
		if(e.getSource().equals(GUI.Manage_Borrower_Panel.btnreturn)) { GUI.Manage_Borrower_Panel.btnreturn.setIcon(GUI.Manage_Borrower_Panel.btnreturn_hover); }
	}

	public void mouseExited(MouseEvent e)
	{
		if(e.getSource().equals(GUI.Main_Menu.logout_button)) { GUI.Main_Menu.logout_button.setIcon(GUI.Main_Menu.logout); }
		if(e.getSource().equals(GUI.Main_Menu.manageborrower_button)) { GUI.Main_Menu.manageborrower_button.setIcon(GUI.Main_Menu.manageborrower); }
		if(e.getSource().equals(GUI.Main_Menu.sb_button)) { GUI.Main_Menu.sb_button.setIcon(GUI.Main_Menu.sb); }
		if(e.getSource().equals(GUI.Main_Menu.mb_button)) { GUI.Main_Menu.mb_button.setIcon(GUI.Main_Menu.mb); }
		if(e.getSource().equals(GUI.Main_Menu.ms_button)) { GUI.Main_Menu.ms_button.setIcon(GUI.Main_Menu.ms); }
		if(e.getSource().equals(GUI.Main_Menu.settings )) { GUI.Main_Menu.settings.setIcon(GUI.Main_Menu.set); }
		if(e.getSource().equals(GUI.Main_Menu.generate_report_button)) { GUI.Main_Menu.generate_report_button.setIcon(GUI.Main_Menu.o1); }
		if(e.getSource().equals(GUI.Main_Menu.o2_button)) { GUI.Main_Menu.o2_button.setIcon(GUI.Main_Menu.o2); }
		if(e.getSource().equals(GUI.Manage_Student_Panel.home_button)) { GUI.Manage_Student_Panel.home_button.setIcon(GUI.Manage_Student_Panel.home); }
		if(e.getSource().equals(GUI.Manage_Student_Panel.logout_button)) { GUI.Manage_Student_Panel.logout_button.setIcon(GUI.Manage_Student_Panel.logout); }
		if(e.getSource().equals(GUI.Manage_Book_Panel.addb)) { GUI.Manage_Book_Panel.addb.setIcon(GUI.Manage_Book_Panel.addb_icon); }
		if(e.getSource().equals(GUI.Manage_Book_Panel.editb)) { GUI.Manage_Book_Panel.editb.setIcon(GUI.Manage_Book_Panel.editb_icon); }
		if(e.getSource().equals(GUI.Manage_Borrower_Panel.btnborrow)) { GUI.Manage_Borrower_Panel.btnborrow.setIcon(GUI.Manage_Borrower_Panel.btnborrow_icon); }
		if(e.getSource().equals(GUI.Manage_Borrower_Panel.btnreturn)) { GUI.Manage_Borrower_Panel.btnreturn.setIcon(GUI.Manage_Borrower_Panel.btnreturn_icon); }
	}
}