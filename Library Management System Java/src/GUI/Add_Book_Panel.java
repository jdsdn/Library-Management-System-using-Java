package GUI;

import java.awt.*;
import java.awt.event.*;		////////////////  JDATECHOOSER !!!!!!!!!!!!!!
import java.io.File;
import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.basic.BasicComboBoxUI;

import com.toedter.calendar.*;

import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;

@SuppressWarnings("serial")
public class Add_Book_Panel extends JPanel {

	public static JTextField txtbook_id, txtbook_isbn, txtbname, txtbtitle, txtbpubn, txtbedi, txtbpurd, txtbpod, txtrecd, txtbcop, txtcpy, txtbprc, txtbwurl, txtblang;
	public static JLabel lblimgicon, lblsavebarcode, lblbarcode;
	public static JTextArea txtbauth;
	public static JComboBox<String> cbbtype, cbbcat, cbbsubcat, cbbstats;
	public static JButton addb, clear;
	public static File file;
	public static FileInputStream fis;
	public static JDateChooser receive_date, purchase_date;
	public static int charcount = 0;
	private static boolean isbarshown = false;

	public Add_Book_Panel() 
	{
		setLayout(null);
		setBounds(0, 100, 1041, 450);
		setBackground(Color.white);
		setBorder(BorderFactory.createLineBorder(Color.decode("#820000"), 5));
		addMouseListener(new MouseAdapter() { public void mouseClicked(MouseEvent e) { grabFocus(); } });

		JPanel m = new JPanel();
		m.setBounds(0, 0, 1041, 45);
		m.setLayout(null);
		m.setBorder(BorderFactory.createLineBorder(Color.decode("#820000"), 5));
		m.setBackground(Color.decode("#820000"));

		JButton close = new JButton(new ImageIcon("./imgs/close_button.png"));
		close.setFocusable(false);

		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GUI.Manage_Book_Panel.f.dispose();
				try { Book_List_Panel.filltable(); } catch (SQLException e) { e.printStackTrace(); }
			}
		});

		JLabel title = new JLabel("Add Book");
		title.setFont(new Font("Serif", Font.BOLD, 25));
		title.setForeground(Color.white);

		m.add(title).setBounds(5, 8, 500, 30);
		m.add(close).setBounds(1005, 8, 30, 30);

		add(m);
		add(init());
	}

	private JPanel init()
	{
		JPanel c = new JPanel();

		c.setLayout(null);
		c.setBounds(0, 60, 1041, 400);
		c.setBackground(Color.white);
		c.setBorder(BorderFactory.createLineBorder(Color.decode("#820000"), 5));
		c.addMouseListener(new MouseAdapter() { public void mouseClicked(MouseEvent e) { grabFocus(); } });

		JPanel panel_bookicon = new JPanel();
		JPanel panel_barcode = new JPanel();

		panel_bookicon.setBackground(Color.WHITE);

		JLabel upload = new JLabel("<HTML><U>Upload</U></HTML>");
		JLabel remove = new JLabel("<HTML><U>Remove</U></HTML>");

		//		JLabel lblbooktype = new JLabel("Book Type:");
		//		JLabel lblisbn = new JLabel("Book Code:");
		//		JLabel lblbookname = new JLabel("Book Name:");
		//		JLabel lblbooktitle = new JLabel("Book Title:");
		//		JLabel lblbookauthors = new JLabel("Book Author/s:");
		//		JLabel lblbookpubname = new JLabel("Publication Name:");
		//		JLabel lblbookedition = new JLabel("Book Edition:");
		//		JLabel lblbookpurdate = new JLabel("Purchase Date:");
		//		JLabel lblbookpubdet = new JLabel("Publication/Other Details:");
		//		JLabel lblbookcat = new JLabel("Category:");
		//		JLabel lblbooksubcat = new JLabel("Sub-Category:");
		//		JLabel lblbookredate = new JLabel("Recieve Date:");
		//		JLabel lblbookcopies = new JLabel("Book Copies:");
		//		JLabel lblbookcopyrightyear = new JLabel("Copyright Year:");
		//		JLabel lblbookstatus = new JLabel("Status:");
		//		JLabel lblbooklanguage = new JLabel("Language:");
		//		JLabel lblbookprice = new JLabel("Book Price:");
		//		JLabel lblbwurl = new JLabel("Website URL:");

		receive_date = new JDateChooser();
		purchase_date = new JDateChooser();

		cbbtype = new JComboBox<String>();
		cbbcat = new JComboBox<String>();
		cbbsubcat = new JComboBox<String>();
		cbbstats = new JComboBox<String>();
		additems();

		addb = new JButton("Add new Book");
		clear = new JButton("Clear Fields");

		receive_date.setDateFormatString("yyyy/MM/dd");
		purchase_date.setDateFormatString("yyyy/MM/dd");

		cbbtype.setFocusable(false);
		cbbcat.setFocusable(false);
		cbbsubcat.setFocusable(false);
		cbbstats.setFocusable(false);

		addb.setFocusable(false);
		clear.setFocusable(false);

		((JTextField) receive_date.getDateEditor()).setEditable(false);
		((JTextField) purchase_date.getDateEditor()).setEditable(false);
		((JTextField) receive_date.getDateEditor()).setBorder(BorderFactory.createCompoundBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.white, 1), BorderFactory.createEmptyBorder(0, 1, 1, 1)), BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(2, 1, 1, 1, Color.gray), BorderFactory.createEmptyBorder(2, 3, 1, 1))));
		((JTextField) purchase_date.getDateEditor()).setBorder(BorderFactory.createCompoundBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.white, 1), BorderFactory.createEmptyBorder(0, 1, 1, 1)), BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(2, 1, 1, 1, Color.gray), BorderFactory.createEmptyBorder(2, 3, 1, 1))));
		//		purchase_date.getDateEditor().getUiComponent().addFocusListener(new FocusAdapter() {
		//		    @Override
		//		    public void focusGained(FocusEvent evt) {
		//		    	((JTextField) purchase_date.getDateEditor()).setForeground(Color.red);
		//		    }
		//		});
		cbbtype.setUI(new BasicComboBoxUI());
		cbbcat.setUI(new BasicComboBoxUI());
		cbbsubcat.setUI(new BasicComboBoxUI());
		cbbstats.setUI(new BasicComboBoxUI());

		addb.setBorder(new Custom_Renderers.Rounded_Border(10));
		clear.setBorder(new Custom_Renderers.Rounded_Border(10));

		addb.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent arg0) { add_book(); } });
		clear.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent arg0) { clear_fields(); } });

		txtbook_isbn = new JTextField();
		txtbname = new JTextField();
		txtbtitle = new JTextField();
		txtbauth = new JTextArea();
		txtbpubn = new JTextField();
		txtbedi = new JTextField();
		txtbpurd = new JTextField();
		txtbprc = new JTextField();
		txtbpod = new JTextField();
		txtrecd = new JTextField();
		txtbcop = new JTextField();
		txtcpy = new JTextField();
		txtbwurl = new JTextField();
		txtblang = new JTextField();
		txtbook_id = new JTextField();

		txtbauth.setLineWrap(true);

		txtbook_isbn.addFocusListener(new Listeners.UI_txtf_Listener());
		txtbname.addFocusListener(new Listeners.UI_txtf_Listener());
		txtbtitle.addFocusListener(new Listeners.UI_txtf_Listener());
		txtbauth.addFocusListener(new Listeners.UI_txtf_Listener());
		txtbpubn.addFocusListener(new Listeners.UI_txtf_Listener());
		txtbedi.addFocusListener(new Listeners.UI_txtf_Listener());
		txtbpurd.addFocusListener(new Listeners.UI_txtf_Listener());
		txtbprc.addFocusListener(new Listeners.UI_txtf_Listener());
		txtbpod.addFocusListener(new Listeners.UI_txtf_Listener());
		txtrecd.addFocusListener(new Listeners.UI_txtf_Listener());
		txtbcop.addFocusListener(new Listeners.UI_txtf_Listener());
		txtcpy.addFocusListener(new Listeners.UI_txtf_Listener());
		txtbwurl.addFocusListener(new Listeners.UI_txtf_Listener());
		txtblang.addFocusListener(new Listeners.UI_txtf_Listener());
		txtbook_id.addFocusListener(new Listeners.UI_txtf_Listener());

		getid();

		txtbook_isbn.setDocument(new Custom_Renderers.JTextFieldLimit(12));
		txtbook_isbn.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent arg0) {}
			public void keyReleased(KeyEvent arg0) { setbarcode(); }
			public void keyPressed(KeyEvent arg0) { setbarcode(); }
		});

		// experimentals . . .

		lblimgicon = new JLabel();
		lblbarcode = new JLabel();
		lblsavebarcode = new JLabel("<HTML><U>Save Barcode as Image</U></HTML>");

		lblsavebarcode.setForeground(Color.decode("#003296"));
		lblsavebarcode.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblsavebarcode.addMouseListener(new MouseAdapter()  { public void mouseClicked(MouseEvent arg0) { 
			if(isbarshown == true){ JOptionPane.showMessageDialog(null, "Save!"); }
		} });

		panel_bookicon.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY), "Book Image"));
		panel_bookicon.setLayout(null);
		panel_barcode.setLayout(null);

		lblimgicon.setBorder(BorderFactory.createLineBorder(Color.gray));
		panel_bookicon.add(lblimgicon).setBounds(10, 19, 130, 120);

		upload.setForeground(Color.decode("#003296"));
		remove.setForeground(Color.red);

		upload.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		remove.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		upload.addMouseListener(new MouseAdapter()  { public void mouseClicked(MouseEvent arg0) { getImage(); } });
		remove.addMouseListener(new MouseAdapter()  { public void mouseClicked(MouseEvent arg0) { lblimgicon.setIcon(null); } });

		panel_barcode.add(lblbarcode).setBounds(0, 0, 227, 100);;
		panel_barcode.add(lblsavebarcode).setBounds(0, 95, 140, 30);

		panel_bookicon.add(upload).setBounds(10, 143, 50, 15);
		panel_bookicon.add(remove).setBounds(93, 143, 50, 15);

		c.add(panel_bookicon).setBounds(10, 10, 150, 165);
		c.add(txtbook_id).setBounds(10, 200, 150, 30);

		c.add(panel_barcode).setBounds(795, 250, 227, 125);

		c.add(txtbook_isbn).setBounds(280, 50, 325, 30);
		c.add(txtbname).setBounds(280, 83, 450, 30);
		c.add(txtbtitle).setBounds(280, 115, 450, 30);
		c.add(txtbauth).setBounds(280, 148, 450, 50);
		c.add(txtbpubn).setBounds(280, 200, 450, 30);
		c.add(receive_date).setBounds(822, 83, 200, 30);
		c.add(purchase_date).setBounds(170, 268, 235, 30);
		c.add(txtrecd);//.setBounds(822, 83, 200, 30);
		c.add(txtbpurd);//.setBounds(170, 268, 235, 30);
		c.add(txtbcop).setBounds(822, 115, 200, 30);
		c.add(txtcpy).setBounds(822, 148, 200, 30);
		c.add(cbbstats).setBounds(822, 180, 200, 30);
		c.add(txtblang).setBounds(822, 213, 200, 30);
		c.add(txtbedi).setBounds(170, 235, 235, 30);
		c.add(txtbwurl).setBounds(487, 235, 243, 30);
		c.add(txtbprc).setBounds(480, 268, 250, 30);
		c.add(txtbpod).setBounds(170, 301, 560, 30);
		c.add(cbbtype).setBounds(280, 15, 325, 30);
		c.add(cbbcat).setBounds(695, 15, 325, 30);
		c.add(cbbsubcat).setBounds(695, 50, 325, 30);

		c.add(new JLabel("Book ID: ")).setBounds(11, 175, 100, 30);
		c.add(new JLabel("Recieve Date:")).setBounds(740, 83, 200, 30);
		c.add(new JLabel("Book Copies:")).setBounds(743, 115, 200, 30);
		c.add(new JLabel("Copyright Year:")).setBounds(732, 148, 200, 30);
		c.add(new JLabel("Status:")).setBounds(778, 180, 200, 30);
		c.add(new JLabel("Language:")).setBounds(760, 213, 200, 30);
		c.add(new JLabel("Book Type:")).setBounds(210, 20, 100, 20);
		c.add(new JLabel("Book ISBN:")).setBounds(210, 55, 100, 20);
		c.add(new JLabel("Book Name:")).setBounds(204, 85, 100, 20);
		c.add(new JLabel("Book Title:")).setBounds(213, 120, 100, 20);
		c.add(new JLabel("Book Author/s:")).setBounds(189, 150, 100, 20);
		c.add(new JLabel("Publication Name:")).setBounds(171, 198, 150, 30);
		c.add(new JLabel("Category:")).setBounds(635, 20, 100, 20);
		c.add(new JLabel("Sub-Category:")).setBounds(610, 55, 100, 20);
		c.add(new JLabel("Book Edition:")).setBounds(85, 240, 100, 20);
		c.add(new JLabel("Website URL:")).setBounds(410, 240, 100, 20);
		c.add(new JLabel("Purchase Date:")).setBounds(70, 273, 100, 20);
		c.add(new JLabel("Book Price:")).setBounds(410, 273, 100, 20);
		c.add(new JLabel("Publication/Other Details:")).setBounds(14, 305, 200, 20);
		c.add(new JLabel("<html>B<br>A<br>R<br>C<br>O<br>D<br>E</html>")).setBounds(765, 250, 10, 110);

		c.add(addb).setBounds(10, 350, 125, 30);
		c.add(clear).setBounds(140, 350, 125, 30);

		return c;
	}

	private void add_book()
	{
		if(checknullfields() == false)
		{

		}

		else
		{
			if(JOptionPane.showConfirmDialog(null, "Continue?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
			{
				int a = Integer.parseInt(txtbook_id.getText());
				long b = Long.parseLong(txtbook_isbn.getText());
				int c = Integer.parseInt(txtbedi.getText());
				int d = Integer.parseInt(txtbcop.getText());
				float e = Float.parseFloat(txtbprc.getText());

				String recdate = ((JTextField)receive_date.getDateEditor().getUiComponent()).getText();
				String purdate = ((JTextField)purchase_date.getDateEditor().getUiComponent()).getText();

				txtbpurd.setText(purdate);
				txtrecd.setText(recdate);

				Database.Book_Info bs = new Database.Book_Info(a, file, b, txtbname.getText(), txtbtitle.getText(), 
						cbbtype.getSelectedIndex() + 1 + "", txtbauth.getText(), c, cbbcat.getSelectedIndex() + 1 + "", 
						cbbsubcat.getSelectedIndex() + 1 + "", txtblang.getText(), cbbstats.getSelectedItem().toString(), 
						d, txtbpubn.getText(), txtbpod.getText(), txtbwurl.getText(), txtcpy.getText(), txtbpurd.getText(), 
						txtrecd.getText(), e);

				Database.Book_DAO.add_book(bs);
				getid();
				clear_fields();
				try { Book_List_Panel.filltable(); } catch (SQLException e1) { e1.printStackTrace(); }
				GUI.Manage_Book_Panel.f.dispose();
			}

			else return;
		}
	}

	public boolean checknullfields()
	{
		if(parseStrToInt(txtbook_isbn.getText()) == false || txtbook_isbn.getText().length() < 12) { JOptionPane.showMessageDialog(null, "Book ISBN should be 12 characters long and does not contain alphabetical characters"); return false; }
		if(parseStrToInt(txtbedi.getText()) == false) { JOptionPane.showMessageDialog(null, "Please Enter Valid Book Edition Number"); return false; }
		if(parseStrToInt(txtbcop.getText()) == false) { JOptionPane.showMessageDialog(null, "Please Enter Valid Book Copies"); return false; }
		if(parseStrToFloat(txtbprc.getText()) == false) { JOptionPane.showMessageDialog(null, "Please Enter Valid Book Price"); return false; }
		if(purchase_date.getDate() == null || receive_date.getDate() == null) { JOptionPane.showMessageDialog(null, "Please Enter Valid Recieve Date/Purchase Date"); return false; }
		if(Duration.between(purchase_date.getDate().toInstant(), receive_date.getDate().toInstant()).toDays() < 0) { JOptionPane.showMessageDialog(null, "Recieved Date should not be before the purchased date"); return false; }
		if(txtbname.getText().equalsIgnoreCase("")) { JOptionPane.showMessageDialog(null, "Book Name cannot be empty"); return false; }
		if(txtbtitle.getText().equalsIgnoreCase("")) { JOptionPane.showMessageDialog(null, "Book Title cannot be empty"); return false; }
		if(txtbauth.getText().equalsIgnoreCase("")) { JOptionPane.showMessageDialog(null, "Book Author cannot be empty"); return false; }
		if(txtblang.getText().equalsIgnoreCase("") || containsInt(txtblang.getText()) == true) { JOptionPane.showMessageDialog(null, "Please Enter Valid Book Language"); return false; }
		if(txtbpubn.getText().equalsIgnoreCase("")) { JOptionPane.showMessageDialog(null, "Publication Name cannot be empty"); return false; }
		if(txtcpy.getText().equalsIgnoreCase("")) { JOptionPane.showMessageDialog(null, "Copyright Year cannot be empty"); return false; }
		if(parseStrToInt(txtcpy.getText()) == false) { JOptionPane.showMessageDialog(null, "Please Enter Valid Copyright Year"); return false; }

		return true;
	}

	private void clear_fields()
	{
		cbbtype.setSelectedIndex(0);
		cbbcat.setSelectedIndex(0);
		cbbsubcat.setSelectedIndex(0);
		cbbstats.setSelectedIndex(0);

		txtbname.setText("");
		txtbtitle.setText("");
		txtbauth.setText("");
		txtbpubn.setText("");
		txtbedi.setText("");
		txtbpurd.setText("");
		txtbprc.setText("");
		txtbpod.setText("");
		txtrecd.setText("");
		txtbcop.setText("");
		txtcpy.setText("");
		txtbwurl.setText("");
		txtblang.setText("");
		txtbook_isbn.setText("");
		lblbarcode.removeAll();
		lblbarcode.revalidate();
		lblbarcode.repaint();
		receive_date.setDate(null);
		purchase_date.setDate(null);
		grabFocus();
	}

	public static void getid()
	{
		try 
		{ 
			PreparedStatement pstmt = Database.Connection_Factory.getConnection().prepareStatement("select count(*) from book_info");
			ResultSet resultSet = pstmt.executeQuery();

			if(resultSet.next()) 
			{
				int a = resultSet.getInt(1);
				txtbook_id.setText(String.format("%06d", a + 1));
			}

			txtbook_id.setEnabled(false);
			txtbook_id.setDisabledTextColor(Color.black);
		}

		catch (SQLException e) { e.printStackTrace(); }
	}

	private static void setbarcode() {

		lblbarcode.removeAll();
		Barcode barcode = null;

		if(txtbook_isbn.getText().equalsIgnoreCase("")) {
			isbarshown = false;
			return;
		}

		else if(txtbook_isbn.getText().length() >= 12)
		{
			charcount = 12;

			if(parseStrToInt(txtbook_isbn.getText())) 
			{
				try 
				{
					barcode = BarcodeFactory.createEAN13(txtbook_isbn.getText());
					//barcode.setFont(new Font("Tahoma", Font.PLAIN, 12));
					barcode.setFont(null);
					barcode.setBarHeight(100);
					barcode.setBarWidth(2);	
					barcode.setBorder(BorderFactory.createLineBorder(Color.black, 2));
					isbarshown = true;
				} 

				catch (BarcodeException e) {}

				lblbarcode.add(barcode);
				lblbarcode.revalidate();
				lblbarcode.repaint();
			}

			else
			{
				lblbarcode.removeAll();
				lblbarcode.revalidate();
				lblbarcode.repaint();
				isbarshown = false;
			}
		}

		else 
		{
			lblbarcode.removeAll();
			lblbarcode.revalidate();
			lblbarcode.repaint();
			isbarshown = false;
		}
	}

	private static void getImage() 
	{
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

		JFileChooser fc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png", "jpeg", "gif");

		fc.addChoosableFileFilter(filter);
		fc.setAcceptAllFileFilterUsed(false);

		int response = fc.showDialog(panel, "Select Image");

		try 
		{
			if (response == JFileChooser.APPROVE_OPTION) {

				file = fc.getSelectedFile();

				lblimgicon.setIcon(new ImageIcon(fc.getSelectedFile().getPath()));
			}
		}

		catch (Exception e) { }
	}

	private void additems() {
		cbbstats.addItem("Available");
		cbbstats.addItem("Not Available");
		cbbsubcat.addItem("");

		try 
		{ 
			PreparedStatement pstmt = Database.Connection_Factory.getConnection().prepareStatement("select category from book_categories");
			ResultSet resultSet = pstmt.executeQuery();

			while(resultSet.next()) 
			{
				cbbcat.addItem(resultSet.getString(1));
				cbbsubcat.addItem(resultSet.getString(1));
			}

			pstmt = Database.Connection_Factory.getConnection().prepareStatement("select types from book_types");
			resultSet = pstmt.executeQuery();

			while(resultSet.next())
			{
				cbbtype.addItem(resultSet.getString(1));
			}
		}

		catch (SQLException e) { e.printStackTrace(); }
	}

	public static boolean containsInt(String str) { return str.matches("\\d+"); }
	public static boolean parseStrToInt(String str) { return str.matches("\\d+"); }
	public static boolean parseStrToFloat(String str) { try { Float.parseFloat(str); return true; } catch (NumberFormatException ex) { return false; }  

	}
}