import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;


@SuppressWarnings("serial")
public class MainDashboard extends JFrame 
{
	
	Connection connection=null;
	
	public String fullname1,fullname2,fullname3,score1,score2,score3;
	private String firstquery,secondquery,fname1,lname1,fname2,lname2,fname3,lname3;
	private JPanel contentPane,panel,panel_2,panel_3,panel_4,panel_1,panel_6,panel_5;
	private JLabel timeLabel,dateLabel,lblRegister,login,register,lblUserLogin,status,lblCompetitionStatus,prize,lblPrizes,winners,lblWinners,lblExit,label,label_1,lblabout,exit,about;
	private int day, month,year,second,minute,hour;
	private PreparedStatement Prepstat1,Prepstat2;
	private ResultSet ResultSet1,ResultSet2;

	
	public void clock()	//enables system current date and time with realtime seconds running
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
					day = calendar.get(Calendar.DAY_OF_MONTH);
					month = calendar.get(Calendar.MONTH);
					year = calendar.get(Calendar.YEAR);
					second = calendar.get(Calendar.SECOND);
					minute = calendar.get(Calendar.MINUTE);
					hour = calendar.get(Calendar.HOUR);
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
	
	//The dasboard layout and variable transfer/visibility into other classes as desired
	
	public MainDashboard(String fullname1,String fullname2,String fullname3,String score1,String score2,String score3) 
	{
		connection=sqliteConnection.dbConnector(); 	//Enable DB connection for query and update

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
		
		panel = new JPanel();
		panel.setBackground(new Color(51, 0, 0));
		panel.setBounds(14, 112, 139, 121);
		contentPane.add(panel);
			
		register = new JLabel("");
		register.addMouseListener(new MouseAdapter() //loads registration class when selected
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
		
		lblRegister = new JLabel("Register");
		lblRegister.setVerticalAlignment(SwingConstants.TOP);
		lblRegister.setForeground(Color.WHITE);
		lblRegister.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		lblRegister.setBackground(Color.WHITE);
		panel.add(lblRegister);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 165, 0));
		panel_2.setBounds(196, 112, 139, 121);
		contentPane.add(panel_2);
		
		login = new JLabel("");
		login.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mousePressed(MouseEvent e) //Login loads login class
			{		
				LoginDB LoginDB = new LoginDB();
				LoginDB.setVisible(true);
				MainDashboard.this.dispose();
			}
		});
		login.setIcon(new ImageIcon("C:\\Users\\jara\\Documents\\pic\\Login.png"));
		panel_2.add(login);
		
		lblUserLogin = new JLabel("User Login");
		lblUserLogin.setVerticalAlignment(SwingConstants.TOP);
		lblUserLogin.setForeground(Color.WHITE);
		lblUserLogin.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		lblUserLogin.setBackground(Color.WHITE);
		panel_2.add(lblUserLogin);
		
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 51, 51));
		panel_3.setBounds(374, 112, 139, 121);
		contentPane.add(panel_3);
		
		status = new JLabel("");
		status.addMouseListener(new MouseAdapter() //loads the status class
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
		
		lblCompetitionStatus = new JLabel("Status  ");
		lblCompetitionStatus.setVerticalAlignment(SwingConstants.TOP);
		lblCompetitionStatus.setForeground(Color.WHITE);
		lblCompetitionStatus.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		lblCompetitionStatus.setBackground(Color.WHITE);
		panel_3.add(lblCompetitionStatus);
		
		panel_4 = new JPanel();
		panel_4.setBackground(new Color(178, 34, 34));
		panel_4.setBounds(553, 112, 139, 121);
		contentPane.add(panel_4);
		
		prize = new JLabel("");
		prize.addMouseListener(new MouseAdapter() //Selection loads Prizes class 
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
		
		lblPrizes = new JLabel("Prizes  ");
		lblPrizes.setVerticalAlignment(SwingConstants.TOP);
		lblPrizes.setForeground(Color.WHITE);
		lblPrizes.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		lblPrizes.setBackground(Color.WHITE);
		panel_4.add(lblPrizes);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 51, 204));
		panel_1.setBounds(14, 268, 139, 121);
		contentPane.add(panel_1);
		
		
		//to display the winners lineup realtime via querying the DB
		winners = new JLabel("");
		winners.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mousePressed(MouseEvent arg0) 
			{
				String fullname1,fullname2,fullname3,score1,score2,score3;
				
				try
				{		
				firstquery = "SELECT DISTINCT fname AS 'First Name',lname AS 'Last Name',stuid AS 'Student ID#',mscore AS 'Mathematics',itscore AS 'IT',sciscore AS 'Science',avgscore AS 'Average' FROM Userinfo ORDER BY avgscore DESC, datetime ASC LIMIT 1";
				Prepstat1 = connection.prepareStatement(firstquery);
				ResultSet1 = Prepstat1.executeQuery();	
				fname1 = ResultSet1.getString("First Name");
				lname1 = ResultSet1.getString("Last Name");
				score1 = ResultSet1.getString("Average");
				fullname1 = fname1 +" "+ lname1;
				ResultSet1.close();
				Prepstat1.close();
	
				secondquery = "SELECT DISTINCT fname AS 'First Name',lname AS 'Last Name',stuid AS 'Student ID#',mscore AS 'Mathematics',itscore AS 'IT',sciscore AS 'Science',avgscore AS 'Average' FROM Userinfo ORDER BY avgscore DESC, datetime ASC LIMIT 1, 1";
				Prepstat2 = connection.prepareStatement(secondquery);
				ResultSet2 = Prepstat2.executeQuery();	
				fname2 = ResultSet2.getString("First Name");
				lname2 = ResultSet2.getString("Last Name");
				score2 = ResultSet2.getString("Average");
				fullname2 = fname2 +" "+ lname2;
				ResultSet2.close();
				Prepstat2.close();
				
				String third = "SELECT DISTINCT fname AS 'First Name',lname AS 'Last Name',stuid AS 'Student ID#',mscore AS 'Mathematics',itscore AS 'IT',sciscore AS 'Science',avgscore AS 'Average' FROM Userinfo ORDER BY avgscore DESC, datetime ASC LIMIT 2, 1";
				PreparedStatement Prepstat3 = connection.prepareStatement(third);
				ResultSet ResultSet3 = Prepstat3.executeQuery();	
				fname3 = ResultSet3.getString("First Name");
				lname3 = ResultSet3.getString("Last Name");
				score3 = ResultSet3.getString("Average");
				fullname3 = fname3 +" "+ lname3;
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
		
		//cotinued design layout with propts
		winners.setIcon(new ImageIcon("C:\\Users\\jara\\Documents\\pic\\Winners2.png"));
		panel_1.add(winners);
		
		lblWinners = new JLabel("Winners!");
		lblWinners.setVerticalAlignment(SwingConstants.TOP);
		lblWinners.setForeground(Color.WHITE);
		lblWinners.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		lblWinners.setBackground(Color.WHITE);
		panel_1.add(lblWinners);
		
		panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 1, 80));
		panel_5.setBounds(196, 268, 139, 121);
		contentPane.add(panel_5);
		
		about = new JLabel("");
		about.addMouseListener(new MouseAdapter() //loads the about class upon selection
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
		
		lblabout = new JLabel("About Us");
		lblabout.setVerticalAlignment(SwingConstants.TOP);
		lblabout.setForeground(Color.WHITE);
		lblabout.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		lblabout.setBackground(Color.WHITE);
		panel_5.add(lblabout);
		
		panel_6 = new JPanel();
		panel_6.setBackground(new Color(102, 0, 102));
		panel_6.setBounds(374, 268, 139, 121);
		contentPane.add(panel_6);
		
		exit = new JLabel("");
		exit.addMouseListener(new MouseAdapter() //Exit prompt
		{
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
		
		lblExit = new JLabel("Exit Program");
		panel_6.add(lblExit);
		lblExit.setVerticalAlignment(SwingConstants.TOP);
		lblExit.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		lblExit.setForeground(Color.WHITE);
		lblExit.setBackground(Color.WHITE);
		
		label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon("C:\\Users\\jara\\Documents\\pic\\logo3.png"));
		label.setBounds(230, 0, 234, 73);
		contentPane.add(label);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\jara\\Documents\\pic\\study3.png"));
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





