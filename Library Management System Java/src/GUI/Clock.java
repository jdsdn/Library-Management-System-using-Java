package GUI;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JLabel;

public class Clock implements Runnable {
	static JLabel lblTime;
	SimpleDateFormat sdf;

	@SuppressWarnings("static-access")
	public Clock(JLabel lblTime, String format) {
		this.lblTime = lblTime;
		sdf = new SimpleDateFormat(format);
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
				set();
			}

			catch (InterruptedException ex) {
				System.out.println(ex);
			}
		}
	}

	public String timeNow() {
		Calendar now = Calendar.getInstance();
		String time = sdf.format(now.getTime());
		return time;
	}

	public void set() {
		
		lblTime.setText(timeNow());
		GUI.Main_Menu.lblTime.setText(lblTime.getText());
		GUI.Search_Book_Panel.lblTime.setText(lblTime.getText());
		GUI.Manage_Book_Panel.lblTime.setText(lblTime.getText());
		GUI.Manage_Borrower_Panel.lblTime.setText(lblTime.getText());
		GUI.Settings_Panel.lblTime.setText(lblTime.getText());
		GUI.Generate_Report_Panel.lblTime.setText(lblTime.getText());
		
	}
}