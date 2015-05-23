package GUILayer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;

import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

import javax.swing.JToggleButton;

public class CalendarCell extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Languages language;
	
	public static void main(String[] args, int day, int month, int year) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalendarCell frame = new CalendarCell(day, month, year);
					frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon.png")));
					frame.setTitle("1000FRYD");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public CalendarCell(int day, int month, int year) {
		language = new Languages();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 425, 350);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		JLabel label_1 = new JLabel();
		label_1.setBounds(12, 13, 148, 24);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setOpaque(true);
		label_1.setFont(new Font("Arial", Font.PLAIN, 16));
		label_1.setBackground(new Color(230, 230, 250));
		label_1.setLayout(new BorderLayout());
		label_1.setText(day+"  "+language.months(month-1)+"  "+year);
		panel.add(label_1);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel tabEvent = new JPanel();//-----------------------------------------------------------------------------event
		tabbedPane.addTab(language.tabs(0), null, tabEvent, null);
		tabEvent.setLayout(null);
		
		String[] petStrings = {"Bird", "Dog", "aaa"};
		JComboBox comboBox = new JComboBox(petStrings);
		comboBox.setBounds(62, 14, 315, 21);
		tabEvent.add(comboBox);
		comboBox.setEditable(true);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(12, 78, 365, 153);
		tabEvent.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblName = new JLabel(language.labelsVolunter(0)+":");
		lblName.setBounds(12, 13, 47, 22);
		tabEvent.add(lblName);
		
		JButton btnAdd = new JButton(language.buttoms(0));
		btnAdd.setBounds(62, 40, 97, 25);
		tabEvent.add(btnAdd);
		
		JButton btnEdit = new JButton(language.buttoms(2));
		btnEdit.setBounds(171, 40, 97, 25);
		tabEvent.add(btnEdit);
		
		JButton btnRemove = new JButton(language.buttoms(1));
		btnRemove.setBounds(280, 40, 97, 25);
		tabEvent.add(btnRemove);//-----------------------------------------------------------------------------event
		
		JPanel tabVolunteer = new JPanel();//-----------------------------------------------------------------------------volunteer
		tabbedPane.addTab(language.tabs(1), null, tabVolunteer, null);
		tabVolunteer.setLayout(null);
		
		String[] petStrings2 = {"Bird", "Dog", "aaa"};
		JComboBox comboBox2 = new JComboBox(petStrings2);
		comboBox2.setBounds(62, 14, 315, 21);
		tabVolunteer.add(comboBox2);
		comboBox2.setEditable(true);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(12, 78, 365, 153);
		tabVolunteer.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblName2 = new JLabel(language.labelsVolunter(0)+":");
		lblName2.setBounds(12, 13, 47, 22);
		tabVolunteer.add(lblName2);
		
		JButton btnAdd2 = new JButton(language.buttoms(0));
		btnAdd2.setBounds(62, 40, 97, 25);
		tabVolunteer.add(btnAdd2);
		
		JButton btnEdit2 = new JButton(language.buttoms(2));
		btnEdit2.setBounds(171, 40, 97, 25);
		tabVolunteer.add(btnEdit2);
		
		JButton btnRemove2 = new JButton(language.buttoms(1));
		btnRemove2.setBounds(280, 40, 97, 25);
		tabVolunteer.add(btnRemove2);//-----------------------------------------------------------------------------volunteer
		
		JPanel tabSignUp = new JPanel();//-----------------------------------------------------------------------------sign up
		tabbedPane.addTab(language.tabs(2), null, tabSignUp, null);
		tabSignUp.setLayout(null);
		
		String[] petStrings3 = {"Bird", "Dog", "aaa"};
		JComboBox comboBox3 = new JComboBox(petStrings3);
		comboBox3.setBounds(62, 14, 315, 21);
		tabSignUp.add(comboBox3);
		comboBox3.setEditable(true);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(12, 78, 365, 153);
		tabSignUp.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblName3 = new JLabel(language.labelsVolunter(0)+":");
		lblName3.setBounds(12, 13, 47, 22);
		tabSignUp.add(lblName3);
		
		JButton btnAdd3 = new JButton(language.buttoms(0));
		btnAdd3.setBounds(62, 40, 97, 25);
		tabSignUp.add(btnAdd3);
		
		JButton btnEdit3 = new JButton(language.buttoms(2));
		btnEdit3.setBounds(171, 40, 97, 25);
		tabSignUp.add(btnEdit3);
		
		JButton btnRemove3 = new JButton(language.buttoms(1));
		btnRemove3.setBounds(280, 40, 97, 25);
		tabSignUp.add(btnRemove3);//-----------------------------------------------------------------------------sign up
	}
}
