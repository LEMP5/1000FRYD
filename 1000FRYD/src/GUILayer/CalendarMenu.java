package GUILayer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.border.MatteBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JSeparator;

import java.awt.SystemColor;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.JCheckBox;

import ControlLayer.*;
import DBLayer.*;
import ModelLayer.*;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class CalendarMenu extends JFrame {
	private static final long serialVersionUID = 1L;
	private Languages language;
	private Time time;
	private People[] user;
	private CtrPeople ctrPeople;
	private CtrGroup ctrG;
	private JPanel contentPane;
	private JPanel topPanel;
	private JPanel changePanelMiddle;
	private JPanel groupPanel1;
	private JPanel peoplePanel;
	private JPanel tabVolunteer;
	private JPanel tabMember;
	private JPanel tabPerson;
	
	public static void main(String[] args) {//, People[] user
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalendarMenu frame = new CalendarMenu();
					frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon.png")));
					frame.setVisible(true);
					frame.setTitle("1000FRYD");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public CalendarMenu() {
		ctrG = new CtrGroup();
		language = new Languages();
		time = new Time();
		ctrPeople = new CtrPeople();
		//user = ctrPeople.getPerson("aaa@a.aa");
		user = ctrPeople.getPerson("bbb@b.bb");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 976, 728);//999, 748
		setLocationRelativeTo(null);
		setResizable(false);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		topPanel = new JPanel();
		topPanel.setBackground(SystemColor.inactiveCaption);
		topPanel.setPreferredSize(new Dimension(100, 25));
		topPanel.setLayout(null);
		contentPane.add(topPanel, BorderLayout.NORTH);
		
		changePanelMiddle = new JPanel();
		changePanelMiddle.setLayout(null);
		contentPane.add(changePanelMiddle, BorderLayout.CENTER);
		
		topPanel();
		accountsMenu(user);
	}
	
	public void checkConnection(Color c)
	{
		Component[] aaa = topPanel.getComponents();
		for(Object a:aaa)
		{
			if(a instanceof JLabel)
			{
				if(((JLabel) a).getName() != null)
				{
					if(((JLabel) a).getName().equals("connection"))
					{
						((JLabel) a).setBackground(c);
					}
				}
			}
		}
	}
	
	private void topPanel() {
		JButton settingsButton = new JButton("");
		settingsButton.setBounds(945, 0, 25, 25);
		Image img = new ImageIcon(this.getClass().getResource("/settingicon.jpg")).getImage();
		settingsButton.setPreferredSize(new Dimension(25, 25));
		settingsButton.setIcon(new ImageIcon(img));
		settingsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		topPanel.add(settingsButton);
		
		int x = 0;
		for(int i = 0; i < 3; i++) {
			int choose = i;
			JLabel lblNewLabel = new JLabel(""+language.labelsTopPanel(i));
			lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setOpaque(true);
			lblNewLabel.setFont(new Font("Arial", Font.BOLD, 13));
			if(i == 0)
				lblNewLabel.setForeground(new Color(0, 0, 128));
			lblNewLabel.setBackground(SystemColor.inactiveCaption);
			lblNewLabel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					lblNewLabel.setBackground(new Color(222, 184, 135));
				}
				@Override
				public void mouseExited(MouseEvent arg0) {
					lblNewLabel.setBackground(SystemColor.inactiveCaption);
				}
				@Override
				public void mousePressed(MouseEvent arg0) {
					switch(choose) {
						case 0:
							tableCalendar(time.getActualDate(1), time.getActualDate(2), time.getActualDate(3));
						break;
						case 1:
							;
						break;
						case 2:
							accountsMenu(user);
						break;
					}
				}
			});
			lblNewLabel.setBounds(x, 0, lblNewLabel.getPreferredSize().width + 15, 25);
			x = x + lblNewLabel.getWidth();
			topPanel.add(lblNewLabel);
		}
		
		JLabel connection = new JLabel("");
		connection.setBorder(new LineBorder(new Color(0, 0, 0)));
		connection.setBackground(topPanel.getBackground());
		connection.setOpaque(true);
		connection.setBounds(925, 5, 15, 15);
		connection.setName("connection");
		topPanel.add(connection);
//		(new Thread(new CheckConnection(this))).start();ddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd
//		Thread thread = new Thread(new CheckConnection(this));
//		thread.start();
//		thread.interrupt();
	}
	
	private void refresh(JPanel p){
		p.removeAll();
		p.revalidate();
		p.repaint();
	}
	
	private void tableCalendar(int day, int month, int year){
		refresh(changePanelMiddle);
		boolean setStartDate = false;
		boolean resetDay = false;
		int week = time.numberOfWeek(month, year);
		int dayy = 1;
		int x = 12;
		int y = 29;
		int row = 0;
		for(int column = 0; column < 7; column++){
			final int cellDate[] = {dayy, month, year};
			JPanel changePanel_1 = new JPanel();
			changePanel_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {//System.out.println(cellDate[0]+"."+cellDate[1]+"."+cellDate[2]);
					CalendarCell.main(null, cellDate[0], cellDate[1], cellDate[2]);
				}
			});
			changePanel_1.setLayout(null);
			changePanel_1.setBorder(new MatteBorder(1, 1, 0, 0, (Color) new Color(95, 158, 160)));
			changePanel_1.setBackground(new Color(248, 248, 255));
			changePanel_1.setBounds(x, y, 135, 100);
			changePanelMiddle.add(changePanel_1);
			
			JLabel date_1 = new JLabel();//date_1.setHorizontalTextPosition(SwingConstants.CENTER);
			date_1.setHorizontalAlignment(SwingConstants.CENTER);
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBorder(null);
			scrollPane.setBounds(1, 51, 134, 49);
			changePanel_1.add(scrollPane);
			
			JTextArea event_1 = new JTextArea();
			scrollPane.setViewportView(event_1);
			event_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					System.out.println(cellDate[0]+"."+cellDate[1]+"."+cellDate[2]);
				}
			});
			event_1.setBackground(new Color(248, 248, 255));
			event_1.setLineWrap(true);
			event_1.setWrapStyleWord(true);
			event_1.setHighlighter(null);
			event_1.setEditable(false);
			event_1.setFont(new Font("Arial", Font.PLAIN, 12));
			event_1.setText("Fossils (dk)\nPiss Vortex (dk)\nAnti Ritual (dk)");
			
			JLabel people_1 = new JLabel();
			people_1.setHorizontalAlignment(SwingConstants.RIGHT);
			people_1.setText("2/3");
			people_1.setOpaque(true);
			people_1.setFont(new Font("Arial", Font.PLAIN, 12));
			people_1.setBackground(new Color(248, 248, 255));
			people_1.setBounds(99, 33, 31, 15);
			changePanel_1.add(people_1);
			
			if(column == time.getStartDay(month,year)-1 && setStartDate == false){
				date_1.setText(""+dayy);
				setStartDate = true;
			}
			else{
				if(dayy == time.getDaysInMonth(month,year)+1){
					dayy = 1;
					resetDay = true;
				}
				date_1.setText(""+dayy);
			}
			date_1.setOpaque(true);
			date_1.setFont(new Font("Arial", Font.PLAIN, 24));
			
			if(resetDay == true){
				date_1.setBackground(new Color(248, 248, 255));
				date_1.setHorizontalAlignment(SwingConstants.LEFT);
				cellDate[1] = month+1;
				cellDate[0] = dayy;
				if(dayy == time.getActualDate(1) && cellDate[1] == time.getActualDate(2) && year == time.getActualDate(3)){
					date_1.setBackground(new Color(255, 127, 80));
					date_1.setHorizontalAlignment(SwingConstants.CENTER);
				}
				if(month == 12){
					cellDate[1] = 1;
					cellDate[2] = year+1;
				}
			}
			else{
				date_1.setBackground(new Color(245, 222, 179));
				if(dayy == time.getActualDate(1) && month == time.getActualDate(2) && year == time.getActualDate(3))
					date_1.setBackground(new Color(255, 127, 80));
			}
			date_1.setBounds(1, 1, 26, 29);
			changePanel_1.add(date_1);
			
			if(column == 0){
				JLabel week_1 = new JLabel();
				week_1.setText(""+week);
				week_1.setOpaque(true);
				week_1.setFont(new Font("Arial", Font.PLAIN, 16));
				week_1.setHorizontalAlignment(SwingConstants.RIGHT);
				week_1.setBackground(new Color(248, 248, 255));
				week_1.setBounds(112, 1, 18, 19);
				changePanel_1.add(week_1);
				week++;
			}
			if(setStartDate == true)
				dayy++;
			else{
				int d = 0;
				if(month == 1){
					d = 31-time.getStartDay(1,year)+column+2;
					cellDate[1] = 12;
					cellDate[2] = year-1;
				}
				else{
					d = time.getDaysInMonth(month-1,year)-time.getStartDay(month,year)+column+2;
					cellDate[1] = month-1;
				}
				date_1.setText(""+d);
				date_1.setBackground(new Color(248, 248, 255));
				cellDate[0] = d;
			}
			x= x + 135;
			if(column == 6 && row < 5){
				column = -1;
				y = y + 100;
				x = 12;
				row++;
			}
		}
		x = 12;
		for(int column = 0; column < 7; column++){
			JLabel dayWeek = new JLabel(language.weekDays(column));
			dayWeek.setBounds(x, 13, 135, 16);
			dayWeek.setHorizontalTextPosition(SwingConstants.CENTER);
			dayWeek.setHorizontalAlignment(SwingConstants.CENTER);
			dayWeek.setOpaque(true);
			dayWeek.setFont(new Font("Arial", Font.PLAIN, 16));
			dayWeek.setBackground(new Color(230, 230, 250));
			changePanelMiddle.add(dayWeek);
			x = x + 135;
		}
		
		JPanel changePanel = new JPanel();
		changePanel.setBackground(new Color(230, 230, 250));
		changePanel.setBounds(12, 630, 945, 26);
		changePanel.setLayout(null);
		changePanelMiddle.add(changePanel);
		
		JLabel label_1 = new JLabel();
		label_1.setBounds(379, 2, 180, 25);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setOpaque(true);
		label_1.setFont(new Font("Arial", Font.PLAIN, 16));
		label_1.setBackground(new Color(230, 230, 250));
		label_1.setLayout(new BorderLayout());
		label_1.setText(language.months(month-1)+"  "+year);
		changePanel.add(label_1);
		
		Image img = new ImageIcon(this.getClass().getResource("/homeicon.jpg")).getImage();
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableCalendar(time.getActualDate(1), time.getActualDate(2), time.getActualDate(3));
				label_1.setText(language.months(time.getActualDate(2))+"  "+time.getActualDate(3));
			}
		});
		button.setBounds(920, 1, 25, 25);
		changePanel.add(button);
		button.setPreferredSize(new Dimension(25, 25));
		button.setIcon(new ImageIcon(img));
		
		Image img2 = new ImageIcon(this.getClass().getResource("/arrowiconleft.jpg")).getImage();
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(month == 1){
					tableCalendar(1, 12, year-1);
				}
				else{
					label_1.setText(language.months(month-1)+"  "+year);
					tableCalendar(day, month-1, year);
				}
			}
		});
		button_1.setPreferredSize(new Dimension(25, 25));
		button_1.setBounds(342, 1, 25, 25);
		changePanel.add(button_1);
		button_1.setIcon(new ImageIcon(img2));
		
		Image img3 = new ImageIcon(this.getClass().getResource("/arrowiconright.jpg")).getImage();
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(month == 12){
					tableCalendar(1, 1, year+1);
				}
				else{
					label_1.setText(language.months(month)+"  "+year);
					tableCalendar(day, month+1, year);
				}
			}
		});
		button_2.setPreferredSize(new Dimension(25, 25));
		button_2.setBounds(571, 1, 25, 25);
		changePanel.add(button_2);
		button_2.setIcon(new ImageIcon(img3));

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(new Color(95, 158, 160));
		separator.setBounds(957, 29, 17, 600);
		changePanelMiddle.add(separator);
		
		JSeparator separator2 = new JSeparator();
		separator2.setOrientation(SwingConstants.HORIZONTAL);
		separator2.setForeground(new Color(95, 158, 160));
		separator2.setBounds(12, 629, 945, 10);
		changePanelMiddle.add(separator2);
	}
	
	private void accountsMenu(People[] p)
	{
		refresh(changePanelMiddle);
		GroupMenu();
		peopleMenu(p);
	}
	
	private void peopleMenu(People[] p)
	{
		CopyPerson copyPerson = new CopyPerson();
		People[] pCopy = new People[p.length];
		for(int i = 0; i < p.length; i++) {
			if(p[i] != null) {
				if(p[i] instanceof Volunteer) {
					pCopy[i] = (Volunteer) copyPerson.getCopy(p[i]);
				}
				else if(p[i] instanceof Member) {
					pCopy[i] = (Member) copyPerson.getCopy(p[i]);
				}
				else if(p[i] instanceof Person) {
					pCopy[i] = (Person) copyPerson.getCopy(p[i]);
				}
			}
		}
		
		Image xIcon = new ImageIcon(this.getClass().getResource("/xicon.png")).getImage();
		Image vIcon = new ImageIcon(this.getClass().getResource("/vicon.png")).getImage();
		Image deleteicon = new ImageIcon(this.getClass().getResource("/deleteicon.png")).getImage();
		Image clearicon = new ImageIcon(this.getClass().getResource("/clearicon.png")).getImage();
		Image searchicon = new ImageIcon(this.getClass().getResource("/searchicon.png")).getImage();
		
		peoplePanel = new JPanel();
		peoplePanel.setBounds(12, 13, 200, 642);
		changePanelMiddle.add(peoplePanel);
		peoplePanel.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPanePeople = new JTabbedPane(JTabbedPane.TOP);//System.out.println(""+tabbedPanePeople.getSelectedComponent());
		tabbedPanePeople.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				System.out.println(""+tabbedPanePeople.getSelectedComponent().getName());
			}
		});
		peoplePanel.add(tabbedPanePeople, BorderLayout.CENTER);
		
		tabVolunteer = new JPanel();//-----------------------------------------------------------------------------Volunteer
		tabbedPanePeople.addTab("Volunteer", null, tabVolunteer, null);
		tabVolunteer.setName("Volunteer");
		tabVolunteer.setLayout(null);
		
		JLabel nameL = new JLabel("Name:");
		nameL.setBounds(10, 0, 173, 16);
		tabVolunteer.add(nameL);
		
		JTextField nameT = new JTextField();
		nameT.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				pCopy[0].setName(nameT.getText());
			}
		});
		nameT.setColumns(10);
		nameT.setBounds(10, 17, 173, 24);
		tabVolunteer.add(nameT);
		
		JLabel surnameL = new JLabel("Surname:");
		surnameL.setBounds(10, 54, 173, 16);
		tabVolunteer.add(surnameL);
		
		JTextField surnameT = new JTextField();
		surnameT.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				pCopy[0].setSurname(surnameT.getText());
			}
		});
		surnameT.setColumns(10);
		surnameT.setBounds(10, 71, 173, 24);
		tabVolunteer.add(surnameT);
		
		JLabel emailL = new JLabel("Email:");
		emailL.setBounds(10, 108, 173, 16);
		tabVolunteer.add(emailL);
		
		JTextField emailT = new JTextField();
		emailT.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				pCopy[0].setEmail(emailT.getText());
			}
		});
		emailT.setColumns(10);
		emailT.setBounds(10, 125, 173, 24);
		tabVolunteer.add(emailT);
		
		JLabel info1 = new JLabel("nie znaleziono");
		info1.setHorizontalAlignment(SwingConstants.RIGHT);
		info1.setBounds(10, 162, 84, 25);
		tabVolunteer.add(info1);
		
		JButton deleteB = new JButton("");
		deleteB.setIcon(new ImageIcon(deleteicon));
		deleteB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ctrPeople.deletePerson(p[0]);
					peopleMenu(user);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		deleteB.setBounds(106, 162, 25, 25);
		tabVolunteer.add(deleteB);
		
		JButton clearB = new JButton("");
		clearB.setIcon(new ImageIcon(clearicon));
		clearB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				People[] clear = {new Volunteer ("", "", "", "", "0", false, "", 0, true, false)};
				accountsMenu(clear);
			}
		});
		clearB.setBounds(132, 162, 25, 25);
		tabVolunteer.add(clearB);
		
		JButton searchB = new JButton("");
		searchB.setIcon(new ImageIcon(searchicon));
		searchB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				People[] pp = ctrPeople.getPerson(emailT.getText());
				boolean found = false;
				for(int i = 0; i < pp.length; i++) {
					if(pp[i] != null) {
						found = true;
						p[i] = pp[i];
					}
				}
				if(found == true)
					accountsMenu(p);
				else
					info1.setText("Not found");
			}
		});
		searchB.setBounds(158, 162, 25, 25);
		tabVolunteer.add(searchB);
		
		JPanel tab2 = new JPanel();
		tab2.setLayout(null);
		tab2.setBounds(10, 200, 173, 399);
		tabVolunteer.add(tab2);
		
		JLabel phoneL = new JLabel("Phone:");
		phoneL.setBounds(0, 0, 173, 16);
		tab2.add(phoneL);
		
		JTextField phoneT = new JTextField();
		phoneT.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				pCopy[0].setTelephoneNo(phoneT.getText());
			}
		});
		phoneT.setColumns(10);
		phoneT.setBounds(0, 17, 173, 24);
		tab2.add(phoneT);
		
		JLabel passwordResetS = new JLabel();
		passwordResetS.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if(!((Volunteer) pCopy[0]).getPassword().equals("0")) {
					passwordResetS.setIcon(new ImageIcon(vIcon));
					((Volunteer) pCopy[0]).setPassword("0");
				}
			}
		});
		passwordResetS.setOpaque(true);
		passwordResetS.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		passwordResetS.setBounds(0, 108, 20, 20);
		tab2.add(passwordResetS);
		
		JLabel passwordResetL = new JLabel("Password reset");
		passwordResetL.setHorizontalAlignment(SwingConstants.LEFT);
		passwordResetL.setBounds(27, 108, 146, 20);
		tab2.add(passwordResetL);
		
		JLabel avabilityS = new JLabel();
		avabilityS.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(((Volunteer) pCopy[0]).isAvailable() == true) {
					avabilityS.setIcon(new ImageIcon(xIcon));
					((Volunteer) pCopy[0]).setAvailable(false);
				}
				else {
					avabilityS.setIcon(new ImageIcon(vIcon));
					((Volunteer) pCopy[0]).setAvailable(true);
				}
			}
		});
		avabilityS.setOpaque(true);
		avabilityS.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		avabilityS.setBounds(0, 141, 20, 20);
		tab2.add(avabilityS);
		
		JLabel avabilityL = new JLabel("Availability");
		avabilityL.setHorizontalAlignment(SwingConstants.LEFT);
		avabilityL.setBounds(27, 141, 146, 20);
		tab2.add(avabilityL);
		
		JLabel bartokensL = new JLabel("Bartokens:");
		bartokensL.setBounds(0, 54, 173, 16);
		tab2.add(bartokensL);
		
		JTextField bartokensT = new JTextField();
		bartokensT.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				((Volunteer) pCopy[0]).setBartokens(Integer.parseInt(bartokensT.getText()));
			}
		});
		bartokensT.setColumns(10);
		bartokensT.setBounds(0, 71, 173, 24);
		tab2.add(bartokensT);
		
		JLabel paidS = new JLabel();
		paidS.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(((Volunteer) pCopy[0]).isPaid() == true) {
					paidS.setIcon(new ImageIcon(xIcon));
					((Volunteer) pCopy[0]).setPaid(false);
				}
				else {
					paidS.setIcon(new ImageIcon(vIcon));
					((Volunteer) pCopy[0]).setPaid(true);
				}
			}
		});
		paidS.setOpaque(true);
		paidS.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		paidS.setBounds(0, 207, 20, 20);
		tab2.add(paidS);
		
		JLabel paidL = new JLabel("Employee");
		paidL.setHorizontalAlignment(SwingConstants.LEFT);
		paidL.setBounds(27, 207, 146, 20);
		tab2.add(paidL);
		
		JComboBox groupC = new JComboBox(new Object[]{});
		//groupC.setName("comboVolunteer");
		ArrayList<String> list = ctrG.getGroupsToPerson(pCopy[0].getEmail());
		for(int i = 0; i < list.size(); i++) {
			groupC.addItem(list.get(i));
		}
		groupC.setBounds(0, 257, 173, 24);
		tab2.add(groupC);
		
		JLabel groupL = new JLabel("Group:");
		groupL.setBounds(0, 240, 173, 16);
		tab2.add(groupL);
		
		JButton addG = new JButton("");
		addG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		addG.setBounds(148, 285, 25, 25);
		tab2.add(addG);
		
		JButton deleteG = new JButton("");
		deleteG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		deleteG.setBounds(122, 285, 25, 25);
		tab2.add(deleteG);
		
		JLabel info2 = new JLabel("nie znaleziono");
		info2.setHorizontalAlignment(SwingConstants.RIGHT);
		info2.setBounds(0, 285, 110, 25);
		tab2.add(info2);
		
		JButton setB = new JButton("Set");
		setB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(p.length != 1) {
					try {
						ctrPeople.updatePerson(p[0], pCopy[0]);
						user = pCopy;
						accountsMenu(user);
					} catch (Exception e) {
						System.out.println("peopleMenu - Query exception: "+e);
					}
				}
				else {
					String[] dataV = new String[] {phoneT.getText(), nameT.getText(), surnameT.getText(), emailT.getText()};
					int i = 0;
					boolean empty = false;
//					while(i < dataV.length || empty != true) {
//						if(dataV[i].equals("")) {
//							empty = true;
//						}
//						i++;
//					}
					if(empty == false) {
						try {
							ctrPeople.createVolunteer(dataV[0], dataV[1], dataV[2], "english", p[0].getPassword(), pCopy[0].getPrivilege(), dataV[3],
									(Integer.parseInt(bartokensT.getText())), ((Volunteer) pCopy[0]).isAvailable(), ((Volunteer) pCopy[0]).isPaid());
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		});
		setB.setBounds(10, 323, 151, 25);
		tab2.add(setB);
		
		JButton cancelB = new JButton("Cancel");
		cancelB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accountsMenu(p);
			}
		});
		cancelB.setBounds(10, 361, 151, 25);
		tab2.add(cancelB);
		
		JLabel administatorS = new JLabel();
		administatorS.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(((Volunteer) pCopy[0]).getPrivilege() == true) {
					administatorS.setIcon(new ImageIcon(xIcon));
					pCopy[0].setPrivilege(false);
				}
				else {
					administatorS.setIcon(new ImageIcon(vIcon));
					pCopy[0].setPrivilege(true);
				}
			}
		});
		administatorS.setOpaque(true);
		administatorS.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		administatorS.setBounds(0, 174, 20, 20);
		tab2.add(administatorS);
		
		JLabel administratorL = new JLabel("Administrator");
		administratorL.setHorizontalAlignment(SwingConstants.LEFT);
		administratorL.setBounds(27, 174, 146, 20);
		tab2.add(administratorL);
		
		displayInfo(((Volunteer) pCopy[0]).getExperienceList());
		nameT.setText(((Volunteer) pCopy[0]).getName());
		surnameT.setText(((Volunteer) pCopy[0]).getSurname());
		emailT.setText(((Volunteer) pCopy[0]).getEmail());
		phoneT.setText(((Volunteer) pCopy[0]).getTelephoneNo());
		bartokensT.setText(""+((Volunteer) pCopy[0]).getBartokens());
		if(((Volunteer) pCopy[0]).getPassword().equals("0"))
			passwordResetS.setIcon(new ImageIcon(vIcon));
		else
			passwordResetS.setIcon(new ImageIcon(xIcon));
		if(((Volunteer) pCopy[0]).isAvailable() == true)
			avabilityS.setIcon(new ImageIcon(vIcon));
		else
			avabilityS.setIcon(new ImageIcon(xIcon));
		if(((Volunteer) pCopy[0]).getPrivilege() == true)
			administatorS.setIcon(new ImageIcon(vIcon));
		else
			administatorS.setIcon(new ImageIcon(xIcon));
		if(((Volunteer) pCopy[0]).isPaid() == true)
			paidS.setIcon(new ImageIcon(vIcon));
		else
			paidS.setIcon(new ImageIcon(xIcon));
		((Volunteer) pCopy[0]).getExperienceList();
		
		tabMember = new JPanel();//-----------------------------------------------------------------------------Member
		tabbedPanePeople.addTab("Member", null, tabMember, null);
		tabMember.setName("Member");
		tabMember.setLayout(null);
		
		tabPerson = new JPanel();//-----------------------------------------------------------------------------Person
		tabbedPanePeople.addTab("Person", null, tabPerson, null);
		tabPerson.setName("Person");
		tabPerson.setLayout(null);
	}
	
	private void peopleTabs(String tabName) {hjbjlk
		
	}
	
	private void GroupMenu()
	{
		ArrayList<Group> listG = ctrG.getAllGroups();
		groupPanel1 = new JPanel();
		groupPanel1.setBounds(758, 13, 212, 642);
		groupPanel1.setLayout(new BorderLayout(0, 0));
		changePanelMiddle.add(groupPanel1);
		
		JPanel groupPanel2 = new JPanel();
		JScrollPane groupScroll = new JScrollPane(groupPanel2);
		groupScroll.setBorder(null);
		groupPanel2.setLayout(null);
		groupPanel1.add(groupScroll, BorderLayout.CENTER);
		
		int y = 0;
		for(int i = 0; i < listG.size(); i++)
		{
			String nameG = listG.get(i).getName();
			JLabel group = new JLabel(nameG);
			group.setHorizontalTextPosition(SwingConstants.CENTER);
			group.setHorizontalAlignment(SwingConstants.CENTER);
			group.setOpaque(true);
			group.setFont(new Font("Arial", Font.BOLD, 13));
			group.setBackground(new Color(230, 230, 250));
			group.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					group.setBackground(new Color(216, 191, 216));
				}
				@Override
				public void mouseExited(MouseEvent arg0) {
					group.setBackground(new Color(230, 230, 250));
				}
				@Override
				public void mousePressed(MouseEvent arg0) {
					
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					for(Object a:tabVolunteer.getComponents()) {
						if(a instanceof JPanel) {
							for(Object a2:((JPanel) a).getComponents()) {
								if(a2 instanceof JComboBox) {
									((JComboBox) a2).addItem(nameG);
									((JComboBox) a2).setSelectedItem(nameG);
								}
							}
						}
					}
				}
			});
			group.setBounds(0, y, 195, 30);
			y = y + group.getHeight();
			groupPanel2.add(group);
		}
		
		JButton newGroupB = new JButton("Add new group");
		newGroupB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addNewGroup();
			}
		});
		newGroupB.setBounds(0, y, 195, 25);
		groupPanel2.add(newGroupB);
		
		groupPanel2.setPreferredSize(new Dimension(groupScroll.getX(), y + newGroupB.getHeight()));
		groupPanel1.add(groupScroll, BorderLayout.CENTER);
	}
	
	private void addNewGroup()
	{
		refresh(groupPanel1);
		
		groupPanel1.setLayout(null);
		JTextField nameGroupT = new JTextField();
		nameGroupT.setBounds(0, 17, 188, 24);
		groupPanel1.add(nameGroupT);
		nameGroupT.setColumns(10);
		
		JLabel nameGroup = new JLabel("Name of group:");
		nameGroup.setBounds(0, 0, 188, 16);
		groupPanel1.add(nameGroup);
		
		JLabel type = new JLabel("Access for:");
		type.setBounds(0, 54, 188, 16);
		groupPanel1.add(type);
		
		String[] petStrings5 = {"Volunteer", "Member", "Everyone"};
		JComboBox typeT = new JComboBox(petStrings5);
		typeT.setBounds(0, 71, 188, 24);
		groupPanel1.add(typeT);
		
		JButton setB = new JButton(""+language.buttoms(4));
		setB.setBounds(96, 108, 92, 25);
		setB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				accountsMenu(user);
			}
		});
		groupPanel1.add(setB);
		
		JButton cancelB = new JButton(""+language.buttoms(3));
		cancelB.setBounds(0, 108, 92, 25);
		cancelB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				accountsMenu(user);
			}
		});
		groupPanel1.add(cancelB);
		
		
		
		
//		JButton setB = new JButton(""+language.buttoms(4));
//		setB.setBounds(103, 0, 97, 25);
//		setB.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//			}
//		});
//		personPanel3.add(setB);
//		
//		JButton cancelB = new JButton(""+language.buttoms(3));
//		cancelB.setBounds(0, 0, 97, 25);
//		cancelB.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//			}
//		});
//		personPanel3.add(cancelB);
	}
	
	private void displayInfo(Object object)
	{
		String[] columsName = null;
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setBounds(224, 13, 522, 642);
		changePanelMiddle.add(scrollPane);
		
//		JTextArea infoT = new JTextArea();
//		scrollPane.setViewportView(infoT);
//		infoT.setEditable(false);
//		infoT.setLineWrap(true);
		
		JTable table = new JTable();
		scrollPane.setViewportView(table);
		DefaultTableModel tableModel = new DefaultTableModel() {
			   @Override
			   public boolean isCellEditable(int row, int column) {//return column == 1;only 1 column is editable //return false;
				   return column == 1;
			   }
		};
		table.setModel(tableModel);
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		table.setRowHeight(table.getFont().getSize());
		DefaultTableCellRenderer render = (DefaultTableCellRenderer) table.getDefaultRenderer(String.class);
		render.setHorizontalAlignment(SwingConstants.CENTER);
		table.setRowHeight(table.getFont().getSize() + 5);
		if(((ArrayList<Experience>) object) != null) {
			columsName = new String[] {"Job", "Experience"};
			for (int i = 0; i < columsName.length; i++) {
				tableModel.addColumn(columsName[i]);
			}
			for (int i = 0; i < ((ArrayList<Experience>) object).size(); i++) {
				tableModel.addRow(new Object[] {""+((ArrayList<Experience>) object).get(i).getJob(),
						""+((ArrayList<Experience>) object).get(i).getShifts()});
			}
		}
		for (int i = 0; i < columsName.length; i++) {
			table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
				public void valueChanged(ListSelectionEvent event) {
					//table.setValueAt("aaa", table.getSelectedRow(), table.getSelectedColumn());
					//System.out.println(table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()).toString());
				}
			});
		}
	}
}