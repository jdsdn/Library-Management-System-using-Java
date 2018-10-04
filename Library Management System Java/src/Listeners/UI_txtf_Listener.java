package Listeners;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.border.CompoundBorder;

public class UI_txtf_Listener implements FocusListener 
{
	CompoundBorder b = new CompoundBorder(BorderFactory.createMatteBorder(2, 1, 1, 1, Color.gray), BorderFactory.createEmptyBorder(2, 3, 1, 1));
	CompoundBorder c = new CompoundBorder(BorderFactory.createLineBorder(Color.white, 1), BorderFactory.createEmptyBorder(0, 1, 1, 1));
	CompoundBorder d = new CompoundBorder(BorderFactory.createMatteBorder(2, 1, 1, 1, Color.white), BorderFactory.createEmptyBorder(2, 3, 1, 1));
	CompoundBorder a = new CompoundBorder(BorderFactory.createMatteBorder(2, 1, 1, 1, Color.decode("#820000")), BorderFactory.createEmptyBorder(0, 1, 1, 1));
	
	public void focusGained(FocusEvent e) 
	{
		if(e.getSource().equals(GUI.Add_Student_Panel.txtstudent_name)) {			
			GUI.Add_Student_Panel.txtstudent_name.setBorder(BorderFactory.createCompoundBorder(a, d));
		}

		if(e.getSource().equals(GUI.Add_Student_Panel.txtstudent_course)) {			
			GUI.Add_Student_Panel.txtstudent_course.setBorder(BorderFactory.createCompoundBorder(a, d));
		}

		if(e.getSource().equals(GUI.Add_Student_Panel.txtstudent_id)) {			
			GUI.Add_Student_Panel.txtstudent_id.setBorder(BorderFactory.createCompoundBorder(a, d));
		}

		if(e.getSource().equals(GUI.Add_Student_Panel.txtcontactno)) {			
			GUI.Add_Student_Panel.txtcontactno.setBorder(BorderFactory.createCompoundBorder(a, d));
		}

		if(e.getSource().equals(GUI.Add_Student_Panel.txtstudent_year)) {			
			GUI.Add_Student_Panel.txtstudent_year.setBorder(BorderFactory.createCompoundBorder(a, d));
		}
		
		//update
		
		if(e.getSource().equals(GUI.Update_Student_Panel.txtstudent_name)) {			
			GUI.Update_Student_Panel.txtstudent_name.setBorder(BorderFactory.createCompoundBorder(a, d));
		}

		if(e.getSource().equals(GUI.Update_Student_Panel.txtstudent_course)) {			
			GUI.Update_Student_Panel.txtstudent_course.setBorder(BorderFactory.createCompoundBorder(a, d));
		}

		if(e.getSource().equals(GUI.Update_Student_Panel.txtstudent_id)) {			
			GUI.Update_Student_Panel.txtstudent_id.setBorder(BorderFactory.createCompoundBorder(a, d));
		}

		if(e.getSource().equals(GUI.Update_Student_Panel.txtcontactno)) {			
			GUI.Update_Student_Panel.txtcontactno.setBorder(BorderFactory.createCompoundBorder(a, d));
		}

		if(e.getSource().equals(GUI.Update_Student_Panel.txtstudent_year)) {			
			GUI.Update_Student_Panel.txtstudent_year.setBorder(BorderFactory.createCompoundBorder(a, d));
		}
		
		//add book panel
		if(e.getSource().equals(GUI.Add_Book_Panel.txtbook_isbn)) {
			GUI.Add_Book_Panel.txtbook_isbn.setBorder(BorderFactory.createCompoundBorder(a, d));
		}
		
		if(e.getSource().equals(GUI.Add_Book_Panel.txtbook_id)) {
			GUI.Add_Book_Panel.txtbook_id.setBorder(BorderFactory.createCompoundBorder(a, d));
		}
		
		if(e.getSource().equals(GUI.Add_Book_Panel.txtbook_isbn)) {
			GUI.Add_Book_Panel.txtbook_isbn.setBorder(BorderFactory.createCompoundBorder(a, d));
		}
		
		if(e.getSource().equals(GUI.Add_Book_Panel.txtbname)) {
			GUI.Add_Book_Panel.txtbname.setBorder(BorderFactory.createCompoundBorder(a, d));
		}
		
		if(e.getSource().equals(GUI.Add_Book_Panel.txtbtitle)) {
			GUI.Add_Book_Panel.txtbtitle.setBorder(BorderFactory.createCompoundBorder(a, d));
		}
		
		if(e.getSource().equals(GUI.Add_Book_Panel.txtbpubn)) {
			GUI.Add_Book_Panel.txtbpubn.setBorder(BorderFactory.createCompoundBorder(a, d));
		}
		
		if(e.getSource().equals(GUI.Add_Book_Panel.txtbauth)) {
			GUI.Add_Book_Panel.txtbauth.setBorder(BorderFactory.createCompoundBorder(a, d));
		}
		
		if(e.getSource().equals(GUI.Add_Book_Panel.txtbedi)) {
			GUI.Add_Book_Panel.txtbedi.setBorder(BorderFactory.createCompoundBorder(a, d));
		}
		
		if(e.getSource().equals(GUI.Add_Book_Panel.txtbpod)) {
			GUI.Add_Book_Panel.txtbpod.setBorder(BorderFactory.createCompoundBorder(a, d));
		}
		
		if(e.getSource().equals(GUI.Add_Book_Panel.txtbcop)) {
			GUI.Add_Book_Panel.txtbcop.setBorder(BorderFactory.createCompoundBorder(a, d));
		}
		
		if(e.getSource().equals(GUI.Add_Book_Panel.txtcpy)) {
			GUI.Add_Book_Panel.txtcpy.setBorder(BorderFactory.createCompoundBorder(a, d));
		}
		
		if(e.getSource().equals(GUI.Add_Book_Panel.txtbprc)) {
			GUI.Add_Book_Panel.txtbprc.setBorder(BorderFactory.createCompoundBorder(a, d));
		}

		if(e.getSource().equals(GUI.Add_Book_Panel.txtbwurl)) {
			GUI.Add_Book_Panel.txtbwurl.setBorder(BorderFactory.createCompoundBorder(a, d));
		}
		
		if(e.getSource().equals(GUI.Add_Book_Panel.txtblang)) {
			GUI.Add_Book_Panel.txtblang.setBorder(BorderFactory.createCompoundBorder(a, d));
		}
		
		if(e.getSource().equals(GUI.Add_Book_Panel.txtbook_id)) {
			GUI.Add_Book_Panel.txtbook_id.setBorder(BorderFactory.createCompoundBorder(a, d));
		}
		
		//update book panel
		
		if(e.getSource().equals(GUI.Update_Book_Panel.txtbook_isbn)) {
			GUI.Update_Book_Panel.txtbook_isbn.setBorder(BorderFactory.createCompoundBorder(a, d));
		}
		
		if(e.getSource().equals(GUI.Update_Book_Panel.txtbook_id)) {
			GUI.Update_Book_Panel.txtbook_id.setBorder(BorderFactory.createCompoundBorder(a, d));
		}
		
		if(e.getSource().equals(GUI.Update_Book_Panel.txtbook_isbn)) {
			GUI.Update_Book_Panel.txtbook_isbn.setBorder(BorderFactory.createCompoundBorder(a, d));
		}
		
		if(e.getSource().equals(GUI.Update_Book_Panel.txtbname)) {
			GUI.Update_Book_Panel.txtbname.setBorder(BorderFactory.createCompoundBorder(a, d));
		}
		
		if(e.getSource().equals(GUI.Update_Book_Panel.txtbtitle)) {
			GUI.Update_Book_Panel.txtbtitle.setBorder(BorderFactory.createCompoundBorder(a, d));
		}
		
		if(e.getSource().equals(GUI.Update_Book_Panel.txtbpubn)) {
			GUI.Update_Book_Panel.txtbpubn.setBorder(BorderFactory.createCompoundBorder(a, d));
		}
		
		if(e.getSource().equals(GUI.Update_Book_Panel.txtbauth)) {
			GUI.Update_Book_Panel.txtbauth.setBorder(BorderFactory.createCompoundBorder(a, d));
		}
		
		if(e.getSource().equals(GUI.Update_Book_Panel.txtbedi)) {
			GUI.Update_Book_Panel.txtbedi.setBorder(BorderFactory.createCompoundBorder(a, d));
		}
		
		if(e.getSource().equals(GUI.Update_Book_Panel.txtbpod)) {
			GUI.Update_Book_Panel.txtbpod.setBorder(BorderFactory.createCompoundBorder(a, d));
		}
		
		if(e.getSource().equals(GUI.Update_Book_Panel.txtbcop)) {
			GUI.Update_Book_Panel.txtbcop.setBorder(BorderFactory.createCompoundBorder(a, d));
		}
		
		if(e.getSource().equals(GUI.Update_Book_Panel.txtcpy)) {
			GUI.Update_Book_Panel.txtcpy.setBorder(BorderFactory.createCompoundBorder(a, d));
		}
		
		if(e.getSource().equals(GUI.Update_Book_Panel.txtbprc)) {
			GUI.Update_Book_Panel.txtbprc.setBorder(BorderFactory.createCompoundBorder(a, d));
		}

		if(e.getSource().equals(GUI.Update_Book_Panel.txtbwurl)) {
			GUI.Update_Book_Panel.txtbwurl.setBorder(BorderFactory.createCompoundBorder(a, d));
		}
		
		if(e.getSource().equals(GUI.Update_Book_Panel.txtblang)) {
			GUI.Update_Book_Panel.txtblang.setBorder(BorderFactory.createCompoundBorder(a, d));
		}
		
		if(e.getSource().equals(GUI.Update_Book_Panel.txtbook_id)) {
			GUI.Update_Book_Panel.txtbook_id.setBorder(BorderFactory.createCompoundBorder(a, d));
		}
	}

	public void focusLost(FocusEvent e) {
		if(e.getSource().equals(GUI.Add_Student_Panel.txtstudent_name)) {
			GUI.Add_Student_Panel.txtstudent_name.setBorder(BorderFactory.createCompoundBorder(c, b));
		}

		if(e.getSource().equals(GUI.Add_Student_Panel.txtstudent_course)) {
			GUI.Add_Student_Panel.txtstudent_course.setBorder(BorderFactory.createCompoundBorder(c, b));
		}

		if(e.getSource().equals(GUI.Add_Student_Panel.txtstudent_id)) {
			GUI.Add_Student_Panel.txtstudent_id.setBorder(BorderFactory.createCompoundBorder(c, b));
		}

		if(e.getSource().equals(GUI.Add_Student_Panel.txtcontactno)) {
			GUI.Add_Student_Panel.txtcontactno.setBorder(BorderFactory.createCompoundBorder(c, b));
		}

		if(e.getSource().equals(GUI.Add_Student_Panel.txtstudent_year)) {
			GUI.Add_Student_Panel.txtstudent_year.setBorder(BorderFactory.createCompoundBorder(c, b));
		}
		
		//update
		
		if(e.getSource().equals(GUI.Update_Student_Panel.txtstudent_name)) {
			GUI.Update_Student_Panel.txtstudent_name.setBorder(BorderFactory.createCompoundBorder(c, b));
		}

		if(e.getSource().equals(GUI.Update_Student_Panel.txtstudent_course)) {
			GUI.Update_Student_Panel.txtstudent_course.setBorder(BorderFactory.createCompoundBorder(c, b));
		}

		if(e.getSource().equals(GUI.Update_Student_Panel.txtstudent_id)) {
			GUI.Update_Student_Panel.txtstudent_id.setBorder(BorderFactory.createCompoundBorder(c, b));
		}

		if(e.getSource().equals(GUI.Update_Student_Panel.txtcontactno)) {
			GUI.Update_Student_Panel.txtcontactno.setBorder(BorderFactory.createCompoundBorder(c, b));
		}

		if(e.getSource().equals(GUI.Update_Student_Panel.txtstudent_year)) {
			GUI.Update_Student_Panel.txtstudent_year.setBorder(BorderFactory.createCompoundBorder(c, b));
		}
		
		//add book panel
		if(e.getSource().equals(GUI.Add_Book_Panel.txtbook_isbn)) {
			GUI.Add_Book_Panel.txtbook_isbn.setBorder(BorderFactory.createCompoundBorder(c, b));
		}
		
		if(e.getSource().equals(GUI.Add_Book_Panel.txtbook_id)) {
			GUI.Add_Book_Panel.txtbook_id.setBorder(BorderFactory.createCompoundBorder(c, b));
		}
		
		if(e.getSource().equals(GUI.Add_Book_Panel.txtbook_isbn)) {
			GUI.Add_Book_Panel.txtbook_isbn.setBorder(BorderFactory.createCompoundBorder(c, b));
		}
		
		if(e.getSource().equals(GUI.Add_Book_Panel.txtbname)) {
			GUI.Add_Book_Panel.txtbname.setBorder(BorderFactory.createCompoundBorder(c, b));
		}
		
		if(e.getSource().equals(GUI.Add_Book_Panel.txtbtitle)) {
			GUI.Add_Book_Panel.txtbtitle.setBorder(BorderFactory.createCompoundBorder(c, b));
		}
		
		if(e.getSource().equals(GUI.Add_Book_Panel.txtbpubn)) {
			GUI.Add_Book_Panel.txtbpubn.setBorder(BorderFactory.createCompoundBorder(c, b));
		}
		
		if(e.getSource().equals(GUI.Add_Book_Panel.txtbauth)) {
			GUI.Add_Book_Panel.txtbauth.setBorder(BorderFactory.createCompoundBorder(c, b));
		}
		
		if(e.getSource().equals(GUI.Add_Book_Panel.txtbedi)) {
			GUI.Add_Book_Panel.txtbedi.setBorder(BorderFactory.createCompoundBorder(c, b));
		}
		
		if(e.getSource().equals(GUI.Add_Book_Panel.txtbpod)) {
			GUI.Add_Book_Panel.txtbpod.setBorder(BorderFactory.createCompoundBorder(c, b));
		}
		
		if(e.getSource().equals(GUI.Add_Book_Panel.txtbcop)) {
			GUI.Add_Book_Panel.txtbcop.setBorder(BorderFactory.createCompoundBorder(c, b));
		}
		
		if(e.getSource().equals(GUI.Add_Book_Panel.txtcpy)) {
			GUI.Add_Book_Panel.txtcpy.setBorder(BorderFactory.createCompoundBorder(c, b));
		}
		
		if(e.getSource().equals(GUI.Add_Book_Panel.txtbprc)) {
			GUI.Add_Book_Panel.txtbprc.setBorder(BorderFactory.createCompoundBorder(c, b));
		}
		
		if(e.getSource().equals(GUI.Add_Book_Panel.txtbwurl)) {
			GUI.Add_Book_Panel.txtbwurl.setBorder(BorderFactory.createCompoundBorder(c, b));
		}
		
		if(e.getSource().equals(GUI.Add_Book_Panel.txtblang)) {
			GUI.Add_Book_Panel.txtblang.setBorder(BorderFactory.createCompoundBorder(c, b));
		}
		
		if(e.getSource().equals(GUI.Add_Book_Panel.txtbook_id)) {
			GUI.Add_Book_Panel.txtbook_id.setBorder(BorderFactory.createCompoundBorder(c, b));
		}
		
		//update book panel 
		
		if(e.getSource().equals(GUI.Update_Book_Panel.txtbook_isbn)) {
			GUI.Update_Book_Panel.txtbook_isbn.setBorder(BorderFactory.createCompoundBorder(c, b));
		}
		
		if(e.getSource().equals(GUI.Update_Book_Panel.txtbook_id)) {
			GUI.Update_Book_Panel.txtbook_id.setBorder(BorderFactory.createCompoundBorder(c, b));
		}
		
		if(e.getSource().equals(GUI.Update_Book_Panel.txtbook_isbn)) {
			GUI.Update_Book_Panel.txtbook_isbn.setBorder(BorderFactory.createCompoundBorder(c, b));
		}
		
		if(e.getSource().equals(GUI.Update_Book_Panel.txtbname)) {
			GUI.Update_Book_Panel.txtbname.setBorder(BorderFactory.createCompoundBorder(c, b));
		}
		
		if(e.getSource().equals(GUI.Update_Book_Panel.txtbtitle)) {
			GUI.Update_Book_Panel.txtbtitle.setBorder(BorderFactory.createCompoundBorder(c, b));
		}
		
		if(e.getSource().equals(GUI.Update_Book_Panel.txtbpubn)) {
			GUI.Update_Book_Panel.txtbpubn.setBorder(BorderFactory.createCompoundBorder(c, b));
		}
		
		if(e.getSource().equals(GUI.Update_Book_Panel.txtbauth)) {
			GUI.Update_Book_Panel.txtbauth.setBorder(BorderFactory.createCompoundBorder(c, b));
		}
		
		if(e.getSource().equals(GUI.Update_Book_Panel.txtbedi)) {
			GUI.Update_Book_Panel.txtbedi.setBorder(BorderFactory.createCompoundBorder(c, b));
		}
		
		if(e.getSource().equals(GUI.Update_Book_Panel.txtbpod)) {
			GUI.Update_Book_Panel.txtbpod.setBorder(BorderFactory.createCompoundBorder(c, b));
		}
		
		if(e.getSource().equals(GUI.Update_Book_Panel.txtbcop)) {
			GUI.Update_Book_Panel.txtbcop.setBorder(BorderFactory.createCompoundBorder(c, b));
		}
		
		if(e.getSource().equals(GUI.Update_Book_Panel.txtcpy)) {
			GUI.Update_Book_Panel.txtcpy.setBorder(BorderFactory.createCompoundBorder(c, b));
		}
		
		if(e.getSource().equals(GUI.Update_Book_Panel.txtbprc)) {
			GUI.Update_Book_Panel.txtbprc.setBorder(BorderFactory.createCompoundBorder(c, b));
		}
		
		if(e.getSource().equals(GUI.Update_Book_Panel.txtbwurl)) {
			GUI.Update_Book_Panel.txtbwurl.setBorder(BorderFactory.createCompoundBorder(c, b));
		}
		
		if(e.getSource().equals(GUI.Update_Book_Panel.txtblang)) {
			GUI.Update_Book_Panel.txtblang.setBorder(BorderFactory.createCompoundBorder(c, b));
		}
		
		if(e.getSource().equals(GUI.Update_Book_Panel.txtbook_id)) {
			GUI.Update_Book_Panel.txtbook_id.setBorder(BorderFactory.createCompoundBorder(c, b));
		}
	}
}