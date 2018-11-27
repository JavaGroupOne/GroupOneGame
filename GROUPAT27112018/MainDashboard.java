import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class MainDashboard extends JFrame 
{
	public String fullname1,fullname2,fullname3,score1,score2,score3;
	Connection connection=null;
	private JPanel contentPane;
	private JLabel timeLabel,dateLabel;
	

	public void clock()
	{
		Thread clock = new Thread()
		{
			public void run()
			{
				try 
				{
					while (true)
					{
					Calendar calendar = new GregorianCalendar();
					int day = calendar.get(Calendar.DAY_OF_MONTH);
					int month = calendar.get(Calendar.MONTH);
					int year = calendar.get(Calendar.YEAR);
					int second = calendar.get(Calendar.SECOND);
					int minute = calendar.get(Calendar.MINUTE);
					int hour = calendar.get(Calendar.HOUR);
					timeLabel.setText("Time: "+hour+":" +minute+ ":" +second);
					dateLabel.setText("Date: "+day+"/"+month+ "/"+year);
					sleep(1000);
					}
				} 
					catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			}
		};
		clock.start();	
	}
	
	public MainDashboard(String fullname1,String fullname2,String fullname3,String score1,String score2,String score3) 
	{
		connection=sqliteConnection.dbConnector();

		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\jara\\Documents\\pic\\brain.png"));
		setTitle("Main Dashboard");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 718, 475);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 0, 0));
		panel.setBounds(14, 112, 139, 121);
		contentPane.add(panel);
			
		JLabel register = new JLabel("");
		register.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mousePressed(MouseEvent e) 
			{			
				Register Register = new Register();
				Register.setVisible(true);	
			}
		});
		register.setIcon(new ImageIcon("C:\\Users\\jara\\Documents\\pic\\Register3.png"));
		panel.add(register);
		JLabel lblRegister = new JLabel("Register");
		lblRegister.setVerticalAlignment(SwingConstants.TOP);
		lblRegister.setForeground(Color.WHITE);
		lblRegister.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		lblRegister.setBackground(Color.WHITE);
		panel.add(lblRegister);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 165, 0));
		panel_2.setBounds(196, 112, 139, 121);
		contentPane.add(panel_2);
		
		JLabel login = new JLabel("");
		login.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mousePressed(MouseEvent e) 
			{		
				LoginDB LoginDB = new LoginDB();
				LoginDB.setVisible(true);
				MainDashboard.this.dispose();
			}
		});
		login.setIcon(new ImageIcon("C:\\Users\\jara\\Documents\\pic\\Login.png"));
		panel_2.add(login);
		
		JLabel lblUserLogin = new JLabel("User Login");
		lblUserLogin.setVerticalAlignment(SwingConstants.TOP);
		lblUserLogin.setForeground(Color.WHITE);
		lblUserLogin.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		lblUserLogin.setBackground(Color.WHITE);
		panel_2.add(lblUserLogin);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 51, 51));
		panel_3.setBounds(374, 112, 139, 121);
		contentPane.add(panel_3);
		
		JLabel status = new JLabel("");
		status.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mousePressed(MouseEvent e) 
			{
				Status Status = new Status();
				Status.setVisible(true);
			}
		});
		status.setIcon(new ImageIcon("C:\\Users\\jara\\Documents\\pic\\CompetitionStatus2.png"));
		panel_3.add(status);
		
		JLabel lblCompetitionStatus = new JLabel("Status  ");
		lblCompetitionStatus.setVerticalAlignment(SwingConstants.TOP);
		lblCompetitionStatus.setForeground(Color.WHITE);
		lblCompetitionStatus.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		lblCompetitionStatus.setBackground(Color.WHITE);
		panel_3.add(lblCompetitionStatus);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(178, 34, 34));
		panel_4.setBounds(553, 112, 139, 121);
		contentPane.add(panel_4);
		
		JLabel prize = new JLabel("");
		prize.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mousePressed(MouseEvent e) 
			{			
				Prizes Prizes = new Prizes();
				Prizes.setVisible(true);			
			}
		});
		prize.setIcon(new ImageIcon("C:\\Users\\jara\\Documents\\pic\\Prize3.png"));
		panel_4.add(prize);
		
		JLabel lblPrizes = new JLabel("Prizes  ");
		lblPrizes.setVerticalAlignment(SwingConstants.TOP);
		lblPrizes.setForeground(Color.WHITE);
		lblPrizes.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		lblPrizes.setBackground(Color.WHITE);
		panel_4.add(lblPrizes);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 51, 204));
		panel_1.setBounds(14, 268, 139, 121);
		contentPane.add(panel_1);
		
		JLabel winners = new JLabel("");
		winners.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mousePressed(MouseEvent arg0) 
			{
				try
				{		
				String first = "SELECT DISTINCT fname AS 'First Name',lname AS 'Last Name',stuid AS 'Student ID#',mscore AS 'Mathematics',itscore AS 'IT',sciscore AS 'Science',avgscore AS 'Average' FROM Userinfo ORDER BY avgscore DESC, datetime ASC LIMIT 1";
				PreparedStatement Prepstat1 = connection.prepareStatement(first);
				ResultSet ResultSet1 = Prepstat1.executeQuery();	
				String fname1 = ResultSet1.getString("First Name");
				String lname1 = ResultSet1.getString("Last Name");
				String score1 = ResultSet1.getString("Average");
				String fullname1 = fname1 +" "+ lname1;
				ResultSet1.close();
				Prepstat1.close();
	
				String second = "SELECT DISTINCT fname AS 'First Name',lname AS 'Last Name',stuid AS 'Student ID#',mscore AS 'Mathematics',itscore AS 'IT',sciscore AS 'Science',avgscore AS 'Average' FROM Userinfo ORDER BY avgscore DESC, datetime ASC LIMIT 1, 1";
				PreparedStatement Prepstat2 = connection.prepareStatement(second);
				ResultSet ResultSet2 = Prepstat2.executeQuery();	
				String fname2 = ResultSet2.getString("First Name");
				String lname2 = ResultSet2.getString("Last Name");
				String score2 = ResultSet2.getString("Average");
				String fullname2 = fname2 +" "+ lname2;
				ResultSet2.close();
				Prepstat2.close();
				
				String third = "SELECT DISTINCT fname AS 'First Name',lname AS 'Last Name',stuid AS 'Student ID#',mscore AS 'Mathematics',itscore AS 'IT',sciscore AS 'Science',avgscore AS 'Average' FROM Userinfo ORDER BY avgscore DESC, datetime ASC LIMIT 2, 1";
				PreparedStatement Prepstat3 = connection.prepareStatement(third);
				ResultSet ResultSet3 = Prepstat3.executeQuery();	
				String fname3 = ResultSet3.getString("First Name");
				String lname3 = ResultSet3.getString("Last Name");
				String score3 = ResultSet3.getString("Average");
				String fullname3 = fname3 +" "+ lname3;
				ResultSet3.close();
				Prepstat3.close();
	
				Winners Winners = new Winners(fullname1,fullname2,fullname3,score1,score2,score3);
				Winners.setVisible(true);
				
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}	
			}		
		});
		winners.setIcon(new ImageIcon("C:\\Users\\jara\\Documents\\pic\\Winners2.png"));
		panel_1.add(winners);
		
		JLabel lblWinners = new JLabel("Winners!");
		lblWinners.setVerticalAlignment(SwingConstants.TOP);
		lblWinners.setForeground(Color.WHITE);
		lblWinners.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		lblWinners.setBackground(Color.WHITE);
		panel_1.add(lblWinners);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 1, 80));
		panel_5.setBounds(196, 268, 139, 121);
		contentPane.add(panel_5);
		
		JLabel about = new JLabel("");
		about.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mousePressed(MouseEvent e) 
			{				
				About About = new About();
				About.setVisible(true);
			}
		});
		about.setIcon(new ImageIcon("C:\\Users\\jara\\Documents\\pic\\About6.png"));
		panel_5.add(about);
		
		JLabel lblabout = new JLabel("About Us");
		lblabout.setVerticalAlignment(SwingConstants.TOP);
		lblabout.setForeground(Color.WHITE);
		lblabout.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		lblabout.setBackground(Color.WHITE);
		panel_5.add(lblabout);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(102, 0, 102));
		panel_6.setBounds(374, 268, 139, 121);
		contentPane.add(panel_6);
		
		JLabel exit = new JLabel("");
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) 
			{
				int YesOrNo = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the program?","Exit", JOptionPane.YES_NO_OPTION);
				if(YesOrNo == 0)
				{
				System.exit(0);
				}
				else
				{		
				}
			}
		});
		exit.setIcon(new ImageIcon("C:\\Users\\jara\\Documents\\pic\\Exit5.png"));
		panel_6.add(exit);
		
		JLabel lblExit = new JLabel("Exit Program");
		panel_6.add(lblExit);
		lblExit.setVerticalAlignment(SwingConstants.TOP);
		lblExit.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		lblExit.setForeground(Color.WHITE);
		lblExit.setBackground(Color.WHITE);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon("C:\\Users\\jara\\Documents\\pic\\logo3.png"));
		label.setBounds(230, 0, 234, 73);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\jara\\Documents\\pic\\study.gif"));;
		label_1.setBounds(523, 268, 179, 121);
		contentPane.add(label_1);

		timeLabel = new JLabel("");
		timeLabel.setForeground(Color.LIGHT_GRAY);
		timeLabel.setBounds(14, 22, 151, 24);
		contentPane.add(timeLabel);
		
		dateLabel = new JLabel("");
		dateLabel.setForeground(Color.LIGHT_GRAY);
		dateLabel.setBounds(14, 0, 151, 24);
		contentPane.add(dateLabel);
				
		clock();
	}
}





