package GUI;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JLabel;

public class GetTime implements Runnable 
{
	static JLabel lblTime;
	SimpleDateFormat sdf;
	
	public GetTime() {}
	
	@SuppressWarnings("static-access")
	public GetTime(JLabel lblTime, String format) 
	{
		this.lblTime = lblTime;
		sdf = new SimpleDateFormat(format);
	}

	public void run() 
	{
		while (true) 
		{
			try 
			{
				lblTime.setText(timeNow());
				Thread.sleep(1000);
			} 

			catch (InterruptedException ex) 
			{
				System.out.println(ex);
			}
		}
	}

	public String timeNow() 
	{
		Calendar now = Calendar.getInstance();
		String  time = sdf.format(now.getTime());  
		return time;
	}
	
	public String getDate()
	{
		String s = String.format("%s %tB %<te, %<tY", "", new Date());
		return s;
	}

	public String zero(int num) 
	{
		String number = (num < 10) ? ("0" + num) : ("" + num);
		return number;
	}
}