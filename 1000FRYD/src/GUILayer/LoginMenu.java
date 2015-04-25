package GUILayer;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

import javax.swing.SwingConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.border.LineBorder;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class LoginMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginMenu frame = new LoginMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 456, 335); //468, 346);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		startWindow();
		//createWindow();
		
	}
	
	private void picture()
	{
		JLabel background = new JLabel(new ImageIcon(getClass().getResource("/loginbackground.jpg")));
		getContentPane().add(background);
		background.setBounds(0, 0, 450, 300);
	}
	
	private void refresh()
	{
		contentPane.removeAll();
		contentPane.revalidate();
		contentPane.repaint();
	}
	
	private boolean check(int choose, Object a, Object b)
	{
		boolean check = false;
		switch(choose)
		{
			case 1:
				if(((JPasswordField) a).getText().equals(((JPasswordField) b).getText()))
					check = true;
			break;
			
			case 2:
				if(((JPasswordField) a).getText().length() <= ((JPasswordField) b).getText().length() &&
				!((JPasswordField) a).getText().equals(((JPasswordField) b).getText()))
					check = true;
			break;
			
			case 3:
				String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$";
				Pattern pattern = Pattern.compile(emailPattern);
				Matcher m = pattern.matcher(((JTextField) a).getText());
				if(m.find())
					check = true;
			break;
			
			case 4:
				Matcher m2 = Pattern.compile("^[0-9]{8}$").matcher(((JTextField) a).getText());
				if(m2.find())
					check = true;
			break;
		}
		return check;
	}
	
	private void startWindow()
	{
		JLabel lblInfo = new JLabel();
		lblInfo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInfo.setForeground(new Color(0, 0, 128));
		lblInfo.setBounds(79, 123, 124, 16);
		contentPane.add(lblInfo);
		
		JPasswordField passwordField = new JPasswordField();
		passwordField.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				lblInfo.setText("");
			}
		});
		passwordField.setBounds(147, 84, 165, 22);
		contentPane.add(passwordField);
		
		JTextField textField = new JTextField();
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				lblInfo.setText("");
			}
		});
		textField.setBounds(147, 49, 165, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setForeground(SystemColor.activeCaptionText);
		lblEmail.setBounds(63, 52, 72, 16);
		contentPane.add(lblEmail);
		
		JLabel lblNewAcc = new JLabel("Create an account");
		lblNewAcc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblNewAcc.setForeground(new Color(128, 0, 128));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewAcc.setForeground(new Color(128, 0, 0));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				createWindow();
			}
		});
		lblNewAcc.setForeground(new Color(128, 0, 0));
		lblNewAcc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewAcc.setBounds(326, 0, 120, 16);
		contentPane.add(lblNewAcc);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setForeground(SystemColor.activeCaptionText);
		lblPassword.setBounds(63, 87, 72, 16);
		contentPane.add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(passwordField.getText().length() == 0 && textField.getText().length() == 0)
					lblInfo.setText("Fill fields.");
			}
		});
		btnLogin.setBounds(215, 119, 97, 25);
		contentPane.add(btnLogin);
		
		picture();
	}
	
	private void createWindow()
	{
		refresh();
		
		JLabel lblInfo = new JLabel();
		lblInfo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInfo.setBounds(74, 122, 146, 16);
		lblInfo.setForeground(new Color(0, 0, 128));
		contentPane.add(lblInfo);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setForeground(SystemColor.activeCaptionText);
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(20, 16, 50, 16);
		contentPane.add(lblName);
		
		JTextField textName = new JTextField();
		Border defaultB =  textName.getBorder();
		textName.setBounds(74, 13, 116, 22);
		contentPane.add(textName);
		textName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last name:");
		lblLastName.setForeground(SystemColor.activeCaptionText);
		lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLastName.setBounds(0, 51, 70, 16);
		contentPane.add(lblLastName);
		
		JTextField textLastName = new JTextField();
		textLastName.setColumns(10);
		textLastName.setBounds(74, 48, 116, 22);
		contentPane.add(textLastName);
		
		JTextField textPhone = new JTextField();
		textPhone.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if(check(4, textPhone, null) == true)
				{
					textPhone.setBorder(defaultB);
					lblInfo.setText("");
				}
			    else
			    {
			    	textPhone.setBorder(new LineBorder(new Color(255, 0, 0), 3));
			    	lblInfo.setText("Incorrect format.");
			    }
			}
		});
		textPhone.setColumns(10);
		textPhone.setBounds(74, 83, 116, 22);
		contentPane.add(textPhone);
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setForeground(SystemColor.activeCaptionText);
		lblPhone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhone.setBounds(25, 86, 45, 16);
		contentPane.add(lblPhone);
		
		JTextField textEmail = new JTextField();
		textEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if(check(3, textEmail, null) == true)
				{
					textEmail.setBorder(defaultB);
					lblInfo.setText("");
				}
			    else
			    {
			    	textEmail.setBorder(new LineBorder(new Color(255, 0, 0), 3));
			    	lblInfo.setText("Incorrect format.");
			    }
			}
		});
		textEmail.setColumns(10);
		textEmail.setBounds(322, 13, 116, 22);
		contentPane.add(textEmail);
		
		JPasswordField textPassword = new JPasswordField();
		textPassword.setColumns(10);
		textPassword.setBounds(322, 48, 116, 22);
		contentPane.add(textPassword);
		
		JPasswordField textConfirmP = new JPasswordField();
		textConfirmP.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				if(check(1, textPassword, textConfirmP) == true)//if(textPassword.getText().equals(textConfirmP.getText()))
				{
					lblInfo.setText("");
					textConfirmP.setBorder(defaultB);
				}
//				if(textPassword.getText().length() <= textConfirmP.getText().length() &&
//						!textPassword.getText().equals(textConfirmP.getText()))
				if(check(2, textPassword, textConfirmP) == true)
				{
					textConfirmP.setBorder(new LineBorder(new Color(255, 0, 0), 3));
					lblInfo.setText("Incorrect password.");
				}
			}
		});
		textConfirmP.setColumns(10);
		textConfirmP.setBounds(322, 83, 116, 22);
		contentPane.add(textConfirmP);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setBounds(268, 16, 50, 16);
		contentPane.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setBounds(248, 51, 70, 16);
		contentPane.add(lblPassword);
		
		JLabel lblConfirmP = new JLabel("Repat password:");
		lblConfirmP.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConfirmP.setForeground(Color.BLACK);
		lblConfirmP.setBounds(221, 86, 97, 16);
		contentPane.add(lblConfirmP);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(check(1, textPassword, textConfirmP) == true && check(4, textPhone, null) == true
						&& check(3, textEmail, null) == true && textName.getText().length() != 0
						&& textLastName.getText().length() != 0)
				{
					lblInfo.setText("Account has added.");
				}
				else
				{
					lblInfo.setText("Fill the fields correctly.");
				}
			}
		});
		btnCreate.setBounds(341, 118, 97, 25);
		contentPane.add(btnCreate);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh();
				startWindow();
			}
		});
		btnCancel.setBounds(232, 118, 97, 25);
		contentPane.add(btnCancel);
		
		picture();
	}
}
