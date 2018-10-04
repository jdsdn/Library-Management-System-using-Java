package test;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

@SuppressWarnings("serial")
public class TheChooser extends JFrame {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TheChooser frame = new TheChooser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JPanel contentPane;
	private JFileChooser fc = new JFileChooser();
	private JLabel picPanel;
	private Connection con;
	
	String driverClassName = "com.mysql.jdbc.Driver";
	String connectionUrl = "jdbc:mysql://localhost:3306/Library_Database";
	String dbUser = "root";
	String dbPwd = "";
	
	final JComboBox<String> pics = new JComboBox<String>();

	FileInputStream fis = null;

	public TheChooser() throws ClassNotFoundException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Class.forName(driverClassName);
		final String INSERT_PICTURE = "insert into pictures(id, name, photo) values (?, ?, ?)";
		final Connection conn = (Connection) DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
		
		picPanel = new JLabel();
		picPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JButton searchButton = new JButton("Search Picture");
		
		searchButton.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JPanel panel = new JPanel();
				panel.setLayout(new BorderLayout());
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png", "jpeg");
				fc.addChoosableFileFilter(filter);
				fc.setAcceptAllFileFilterUsed(false);
				int response = fc.showDialog(panel, "Select Image");
				try {
					if (response == JFileChooser.APPROVE_OPTION) {

						String pathName = fc.getSelectedFile().getPath();
						File file = fc.getSelectedFile();
						fis = new FileInputStream(file);
						PreparedStatement ps = null;

						ps = conn.prepareStatement(INSERT_PICTURE);
						ps.setString(1, (pics.getItemCount()) + "");
						ps.setString(2, fc.getSelectedFile().getName());
						ps.setBinaryStream(3, fis, (int) file.length());
						ps.executeUpdate();
						
						pics.removeAllItems();
						fill();

						JOptionPane.showMessageDialog(null, pathName);
						JOptionPane.showMessageDialog(null, file.toString());
					} 
					
					else { JOptionPane.showMessageDialog(null, "Feel Free to Look Later"); }
					
				} catch (Exception e) { e.printStackTrace(); }
			}
		});
		
		searchButton.setBounds(141, 11, 139, 23);
		contentPane.add(searchButton);
		contentPane.add(pics).setBounds(10, 11, 100, 30);
		fill();
		picPanel.setBounds(10, 58, 414, 192);
		contentPane.add(picPanel);
	}
	
	private void fill() throws SQLException {
		pics.addItem("0");
		con = (Connection) DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
		
		String sql = "SELECT id, name, photo FROM pictures ";
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet resultSet = stmt.executeQuery();
		while (resultSet.next()) {
			String id = resultSet.getString(1);
			pics.addItem(id);
		}
		
		pics.addItemListener(new ItemListener() {
			
			public void itemStateChanged(ItemEvent arg0) {
				
				if(pics.getSelectedIndex() == 0) {
					picPanel.setIcon(null);
				}
				
				String sql = "SELECT photo FROM pictures where id=" + pics.getSelectedIndex();
				PreparedStatement stmt = null;
				try { stmt = con.prepareStatement(sql); } catch (SQLException e) { e.printStackTrace(); }
				
				ResultSet resultSet = null;
				
				try { resultSet = stmt.executeQuery(); } catch (SQLException e) { e.printStackTrace(); }
				
				try 
				{ 
					while (resultSet.next()) 
					{
						InputStream is = resultSet.getBinaryStream(1);
						Image photo = ImageIO.read(is);
						ImageIcon icon = new ImageIcon(photo); 
						picPanel.setIcon(icon);
					}
					
				} 
				
				catch (SQLException e) { e.printStackTrace(); } 
				catch (IOException e) { e.printStackTrace(); }
			}
		});
		
	}
}