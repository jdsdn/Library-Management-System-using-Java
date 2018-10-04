package test;

import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.*;
import java.util.Date;

import javax.swing.*;

import com.toedter.calendar.*;

@SuppressWarnings("serial")
public class for_setb extends JFrame 
{
	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblPublication;
	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() {
				
				try 
				{
					for_setb frame = new for_setb();
					frame.setVisible(true);
				} 
				
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	public for_setb() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(711, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 24, 150, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Book Edition:");
		lblNewLabel.setBounds(98, 65, 62, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblPurchase = new JLabel("Purchase Date:");
		lblPurchase.setBounds(86, 90, 74, 14);
		contentPane.add(lblPurchase);
		
		lblPublication = new JLabel("Publication/Other Details:");
		lblPublication.setBounds(38, 115, 122, 14);
		contentPane.add(lblPublication);
		
		
		////////
		
		//calculat days past from string
		
//		String recdate = ((JTextField)receive_date.getDateEditor().getUiComponent()).getText();
//		String purdate = ((JTextField)purchase_date.getDateEditor().getUiComponent()).getText();
//		
//		txtbpurd.setText(purdate);
//		txtrecd.setText(recdate);
//		
//		Instant pur = null;
//		Instant rec = null;
//
//		try 
//		{
//			pur = new SimpleDateFormat("yyyy/MM/dd").parse(purdate).toInstant();
//			rec = new SimpleDateFormat("yyyy/MM/dd").parse(recdate).toInstant();
//		} catch (ParseException e1) {
//			e1.printStackTrace();
//		}
//		
//		Duration dd = Duration.between(pur, rec);
//		JOptionPane.showMessageDialog(null, dd.toDays());
		
		/////////
		
		
		////////
		
		Date date = new Date();
		final JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(298, 165, 130, 20);
		dateChooser.setDate(date);
		dateChooser.setDateFormatString("yyyy/MM/dd");
		contentPane.add(dateChooser);
		
		final JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(298, 199, 130, 20);
		dateChooser_1.setDateFormatString("yyyy/MM/dd");
		contentPane.add(dateChooser_1);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(298, 234, 89, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
//				JOptionPane.showMessageDialog(null, dateChooser.getDate().toString() + " || " + dateChooser_1.getDate().toString());
				LocalDateTime from = LocalDateTime.ofInstant(dateChooser.getDate().toInstant(), ZoneId.systemDefault());
				LocalDateTime to = LocalDateTime.ofInstant(dateChooser_1.getDate().toInstant(), ZoneId.systemDefault());
				
				Duration d = Duration.between(from, to);
				JOptionPane.showMessageDialog(null, d.toDays());
			}
		});
		
		//////////
		
		
		
		
		
		
		
		
		
		
		
		
		setLocationRelativeTo(null);
	}
}
