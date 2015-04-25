package GUILayer;

import java.awt.BorderLayout;
import java.awt.Color;
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

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.JCheckBox;

public class CalendarMenu extends JFrame {
	private static final long serialVersionUID = 1L;
	private Languages language;
	private Time time;
	//private CalendarControl control;
	private JPanel contentPane;
	private JPanel topPanel;
	private JPanel changePanelMiddle;
	private JTextField phononeT;
	private JTextField tokensT;
	private JPanel changePanel_2;
	private JPanel changePanel_3;
	
	public static void main(String[] args) {
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
		language = new Languages();
		time = new Time();
		//control = new CalendarControl();
		
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
		//tableCalendar(time.getActualDate(1), time.getActualDate(2), time.getActualDate(3));
		VolunteerMenu();
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
			
			changePanel_1.revalidate();
			changePanel_1.repaint();
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
			JLabel label_1 = new JLabel(language.weekDays(column));
			label_1.setBounds(x, 13, 135, 16);
			label_1.setHorizontalTextPosition(SwingConstants.CENTER);
			label_1.setHorizontalAlignment(SwingConstants.CENTER);
			label_1.setOpaque(true);
			label_1.setFont(new Font("Arial", Font.PLAIN, 16));
			label_1.setBackground(new Color(230, 230, 250));
			changePanelMiddle.add(label_1);
			x = x + 135;
		}
		
		JPanel changePanel = new JPanel();
		changePanel.setBackground(new Color(230, 230, 250));
		changePanel.setBounds(12, 630, 945, 26);
		changePanel.setLayout(null);
		changePanelMiddle.add(changePanel);
		
		JLabel label_1 = new JLabel();
		label_1.setBounds(379, 2, 180, 25);//label_1.setHorizontalTextPosition(SwingConstants.CENTER);
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
	
	private void topPanel()
	{
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
		for(int i = 0; i < 3; i++)
		{
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
					switch(choose)
					{
						case 0:
							tableCalendar(time.getActualDate(1), time.getActualDate(2), time.getActualDate(3));
						break;
						case 1:
							;
						break;
						case 2:
							VolunteerMenu();
						break;
					}
				}
			});
			lblNewLabel.setBounds(x, 0, lblNewLabel.getPreferredSize().width + 15, 25);
			x = x + lblNewLabel.getWidth();
			topPanel.add(lblNewLabel);
		}
	}
	
	private void VolunteerMenu()
	{
		refresh(changePanelMiddle);
		
		JLabel name = new JLabel(""+language.labelsVolunter(0)+":");
		name.setBounds(12, 13, 200, 16);
		changePanelMiddle.add(name);
		
		JTextField nameT = new JTextField();
		nameT.setBounds(12, 30, 200, 24);
		changePanelMiddle.add(nameT);
		nameT.setColumns(10);
		
		JLabel surname = new JLabel(""+language.labelsVolunter(1)+":");
		surname.setBounds(12, 67, 200, 16);
		changePanelMiddle.add(surname);
		
		JTextField surnameT = new JTextField();
		surnameT.setColumns(10);
		surnameT.setBounds(12, 84, 200, 24);
		changePanelMiddle.add(surnameT);
		
		JLabel email = new JLabel(""+language.labelsVolunter(2)+":");//37
		email.setBounds(12, 121, 200, 16);
		changePanelMiddle.add(email);
		
		JTextField emailT = new JTextField();//17//52
		emailT.setColumns(10);
		emailT.setBounds(12, 138, 200, 24);
		changePanelMiddle.add(emailT);
		
		JButton btn = new JButton("");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btn.setBounds(187, 175, 25, 25);
		changePanelMiddle.add(btn);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(150, 175, 25, 25);
		changePanelMiddle.add(button);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setBounds(113, 175, 25, 25);
		changePanelMiddle.add(button_1);
		
		JLabel info = new JLabel("New label");
		info.setHorizontalAlignment(SwingConstants.CENTER);
		info.setBounds(12, 213, 200, 16);
		changePanelMiddle.add(info);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setBounds(224, 13, 487, 377);
		changePanelMiddle.add(scrollPane);
		
		JTextArea infoT = new JTextArea();
		scrollPane.setViewportView(infoT);
		infoT.setEditable(false);
		infoT.setLineWrap(true);
		
		changePanel_2 = new JPanel();
		changePanel_2.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));
		changePanel_2.setBounds(12, 242, 200, 343);
		changePanelMiddle.add(changePanel_2);
		changePanel_2.setLayout(null);
		
		JLabel phone = new JLabel(""+language.labelsVolunter(3)+":");
		phone.setBounds(0, 13, 200, 16);
		changePanel_2.add(phone);
		
		phononeT = new JTextField();
		phononeT.setBounds(0, 30, 200, 24);
		changePanel_2.add(phononeT);
		phononeT.setColumns(10);
		
		changePanel_3 = new JPanel();
		changePanel_3.setBounds(0, 154, 200, 173);
		changePanel_2.add(changePanel_3);
		changePanel_3.setLayout(null);
		
		JLabel payments = new JLabel("Payments:");
		payments.setBounds(0, 0, 200, 16);
		changePanel_3.add(payments);
		
		JLabel label = new JLabel();
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if(label.getBackground() == Color.ORANGE)
					label.setBackground(new Color(240, 240, 240));
				else
					label.setBackground(Color.ORANGE);
			}
		});
		label.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		label.setOpaque(true);
		label.setBounds(152, 71, 24, 24);
		changePanel_3.add(label);
		
		String[] petStrings4 = {"24.04.2015 (nie zap³acone)", "25.04.2015 (paid)"};
		JComboBox paymentsT = new JComboBox(petStrings4);
		paymentsT.setBounds(0, 17, 200, 24);
		changePanel_3.add(paymentsT);
		
		JLabel privilages = new JLabel(""+language.labelsVolunter(4)+":");
		privilages.setBounds(0, 100, 200, 16);
		changePanel_2.add(privilages);
		
		String[] petStrings3 = {"Volunteer", "Member", "Administrator"};
		JComboBox privilagesT = new JComboBox(petStrings3);
		privilagesT.setBounds(0, 117, 200, 24);
		changePanel_2.add(privilagesT);
		privilagesT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	contentChangePanel_3(privilagesT.getSelectedItem().toString());
            }
        });
		//contentChangePanel_3(privilagesT.getSelectedItem().toString());
		
		JLabel reset = new JLabel(""+language.infoLabels(4));
		reset.setBounds(27, 67, 173, 20);
		changePanel_2.add(reset);
		reset.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel resetB = new JLabel();
		resetB.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if(resetB.getBackground() == Color.ORANGE)
					resetB.setBackground(new Color(240, 240, 240));
				else
					resetB.setBackground(Color.ORANGE);
			}
		});
		resetB.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		resetB.setOpaque(true);
		resetB.setBounds(0, 67, 20, 20);
		changePanel_2.add(resetB);
	}
	
	private void contentChangePanel_3(String choose)
	{
		switch(choose)
		{
			case "Volunteer":
				refresh(changePanel_3);
				
				JLabel tokens = new JLabel(""+language.labelsVolunter(7)+":");
				tokens.setBounds(0, 90, 200, 16);
				changePanel_3.add(tokens);
				
				tokensT = new JTextField();
				tokensT.setBounds(0, 107, 200, 22);
				changePanel_3.add(tokensT);
				tokensT.setColumns(10);
				
				JButton btnNewButton = new JButton(""+language.buttoms(4));
				btnNewButton.setBounds(0, 142, 97, 25);
				changePanel_3.add(btnNewButton);
				
				JButton btnNewButton_1 = new JButton(""+language.buttoms(3));
				btnNewButton_1.setBounds(103, 142, 97, 25);
				changePanel_3.add(btnNewButton_1);
				
				JLabel qualifications = new JLabel(""+language.labelsVolunter(6)+":");
				qualifications.setBounds(0, 0, 200, 16);
				changePanel_3.add(qualifications);
				
				String[] petStrings2 = {"Choose qualifications:", "aaa"};
				JComboBox qualificationsT = new JComboBox(petStrings2);
				qualificationsT.setBounds(0, 17, 200, 22);
				changePanel_3.add(qualificationsT);
				qualificationsT.setSelectedItem("text has changed");
			
				JButton addB = new JButton("");
				addB.setBounds(175, 52, 25, 25);
				changePanel_3.add(addB);
				addB.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				});
				
				JButton removeB = new JButton("");
				removeB.setBounds(138, 52, 25, 25);
				changePanel_3.add(removeB);
			
				JLabel lblNewLabel_1 = new JLabel(""+language.infoLabels(2));
				lblNewLabel_1.setBounds(0, 52, 126, 25);
				changePanel_3.add(lblNewLabel_1);
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
			break;
			case "Member":
				refresh(changePanel_3);
			break;
				
			case "Administrator":
				refresh(changePanel_3);
			break;
			
			case "":
				refresh(changePanel_3);
			break;
		}
	}
}