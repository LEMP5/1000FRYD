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

import ControlLayer.CtrPeople;
import ModelLayer.*;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class LoginMenu extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private CtrPeople ctrPeople;
	
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
	
	public LoginMenu() {
		ctrPeople = new CtrPeople();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 456, 335); //468, 346);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		startWindow(null);
	}
	
	private void picture() {
		JLabel background = new JLabel(new ImageIcon(getClass().getResource("/loginbackground.jpg")));
		getContentPane().add(background);
		background.setBounds(0, 0, 450, 300);
	}
	
	private void refresh() {
		contentPane.removeAll();
		contentPane.revalidate();
		contentPane.repaint();
	}
	
	private boolean check(int choose, String a, String b) {
		boolean check = false;
		switch(choose) {
			case 1:
			break;
			case 2:
				if(a.equals(b))
					check = true;
			break;
			case 3:
				String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$";
				Pattern pattern = Pattern.compile(emailPattern);
				Matcher m = pattern.matcher(a);
				if(m.find() || a.length() == 0)
					check = true;
			break;
			case 4:
//				Matcher m2 = Pattern.compile("^[0-9]{8}$").matcher(a);
//				if(m2.find())
//					check = true;
			break;
			case 5:
				if(a.length() >= 4 || a.length() == 0)
					check = true;
			break;
		}
		return check;
	}
	
	private void startWindow(String emaill) {
		refresh();
		JLabel info = new JLabel();
		info.setHorizontalAlignment(SwingConstants.RIGHT);
		info.setForeground(new Color(0, 0, 128));
		info.setBounds(12, 123, 191, 16);
		contentPane.add(info);
		
		JPasswordField passwordT = new JPasswordField();
		Border defaultB =  passwordT.getBorder();
		passwordT.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if(check(5, passwordT.getText(), null) != true) {
					info.setText("Type in at least 4 characters.");
					passwordT.setBorder(new LineBorder(new Color(255, 0, 0), 3));
				}
				else {
					passwordT.setBorder(defaultB);
					info.setText("");
				}
			}
		});
		passwordT.setBounds(147, 84, 165, 22);
		contentPane.add(passwordT);
		
		JTextField emailT = new JTextField(emaill);
		emailT.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if(check(3, emailT.getText(), null) == false) {
					info.setText("Incorect format");
					emailT.setBorder(new LineBorder(new Color(255, 0, 0), 3));
				}
				else {
					emailT.setBorder(defaultB);
					info.setText("");
				}
			}
		});
		emailT.setBounds(147, 49, 165, 22);
		contentPane.add(emailT);
		emailT.setColumns(10);
		
		JLabel email = new JLabel("E-mail:");
		email.setHorizontalAlignment(SwingConstants.RIGHT);
		email.setForeground(SystemColor.activeCaptionText);
		email.setBounds(63, 52, 72, 16);
		contentPane.add(email);
		
		JLabel password = new JLabel("Password:");
		password.setHorizontalAlignment(SwingConstants.RIGHT);
		password.setForeground(SystemColor.activeCaptionText);
		password.setBounds(63, 87, 72, 16);
		contentPane.add(password);
		
		JButton loginB = new JButton("Login");
		loginB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				People p = null;
				if(passwordT.getText().length() == 0 && emailT.getText().length() == 0 && info.getText().length() == 0)
					info.setText("Fill fields.");
				else if(check(3, emailT.getText(), null) == true) {
					People[] listP = ctrPeople.getPerson(emailT.getText());
					for(People a: listP) {
						if(a != null)
							p = a;
					}
					if(p != null) {
						if(p.getPassword().equals("0"))
							createWindow(p);
						else {
							if(emailT.getText().equals(p.getEmail()) && passwordT.getText().equals(p.getPassword())) {
								setVisible(false);
								CalendarMenu.main(null);//, listP);
							}
							else {
								if(info.getText().length() == 0)
									info.setText("Incorrect data.");
							}
						}
					}
				}
			}
		});
		loginB.setBounds(215, 119, 97, 25);
		contentPane.add(loginB);
		
		picture();
	}
	
	private void createWindow(People p)
	{
		refresh();
		JLabel lblInfo = new JLabel();
		lblInfo.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfo.setBounds(223, 145, 131, 16);
		lblInfo.setForeground(new Color(0, 0, 128));
		contentPane.add(lblInfo);
		
		JPasswordField textPassword = new JPasswordField();
		Border defaultB =  textPassword.getBorder();
		textPassword.setColumns(10);
		textPassword.setBounds(191, 48, 116, 22);
		contentPane.add(textPassword);
		
		JPasswordField textConfirmP = new JPasswordField();
		textConfirmP.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
			}
		});
		textConfirmP.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				if(check(2, textPassword.getText(), textConfirmP.getText()) == false) {
					textConfirmP.setBorder(new LineBorder(new Color(255, 0, 0), 3));
					lblInfo.setText("Incorrect password.");
				}
				else {
					textConfirmP.setBorder(defaultB);
					lblInfo.setText("");
				}
			}
		});
		textConfirmP.setColumns(10);
		textConfirmP.setBounds(191, 83, 116, 22);
		contentPane.add(textConfirmP);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setBounds(119, 48, 70, 22);
		contentPane.add(lblPassword);
		
		JLabel lblConfirmP = new JLabel("Repat password:");
		lblConfirmP.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConfirmP.setForeground(Color.BLACK);
		lblConfirmP.setBounds(92, 83, 97, 22);
		contentPane.add(lblConfirmP);
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				People pNew = null;
				if(lblInfo.getText() != null) {
					CopyPerson copyPerson = new CopyPerson();
					pNew = copyPerson.getCopy(p);
					pNew.setPassword(textConfirmP.getText());
				}
				try {
					ctrPeople.updatePerson(p, pNew);
					startWindow(p.getEmail());
				} catch (Exception ex) {
					System.out.println("createWindow - Query exception: "+ex);
				}
			}
		});
		btnNewButton.setBounds(223, 118, 84, 25);
		contentPane.add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				startWindow(null);
			}
		});
		btnCancel.setBounds(127, 118, 84, 25);
		contentPane.add(btnCancel);
		
		picture();
	}
}
