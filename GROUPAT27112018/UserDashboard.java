
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
//import java.awt.FlowLayout;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import java.awt.Toolkit;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class UserDashboard extends JFrame
{
	private JPanel contentPane;
	public String username;
	public String fullname1,fullname2,fullname3,score1,score2,score3;

	public double mscore;
	public double itscore;
	public double sciscore;
	public double avgscore;
	public int stuid;
	private JLabel timeLabel;
	private JLabel dateLabel;

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
	
	
	public UserDashboard(String username, String fullname, double mscore, double itscore, double sciscore, double avgscore, int stuid)
	{	
		setResizable(false);
		setForeground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\jara\\Documents\\pic\\Login.png"));
		setTitle("User Dashboard");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 718, 475);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(UIManager.getBorder("MenuItem.border"));
		panel.setBackground(new Color(51, 0, 0));
		panel.setBounds(24, 256, 165, 151);
		contentPane.add(panel);
		
		JLabel Math = new JLabel("");
		Math.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) 
			{				
				MathTest MathTest = new MathTest();
				MathTest.setVisible(true);					
			}
		});
		Math.setForeground(Color.WHITE);
		Math.setIcon(new ImageIcon("C:\\Users\\jara\\Documents\\pic\\Math2.png"));
		panel.add(Math);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(UIManager.getBorder("MenuItem.border"));
		panel_2.setBackground(new Color(255, 165, 0));
		panel_2.setBounds(262, 256, 169, 151);
		contentPane.add(panel_2);
		
		JLabel informationTech = new JLabel("");
		informationTech.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) 
			{				
				ITtest ITtest = new ITtest();
				ITtest.setVisible(true);				
			}
		});
		informationTech.setIcon(new ImageIcon("C:\\Users\\jara\\Documents\\pic\\IT2.png"));
		panel_2.add(informationTech);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(UIManager.getBorder("MenuItem.border"));
		panel_3.setBackground(Color.PINK);
		panel_3.setBounds(508, 256, 169, 151);
		contentPane.add(panel_3);
		
		JLabel Science = new JLabel("");
		Science.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) 
			{			
				ScienceTest ScienceTest = new ScienceTest();
				ScienceTest.setVisible(true);							
			}
		});
		Science.setIcon(new ImageIcon("C:\\Users\\jara\\Documents\\pic\\Science4.png"));
		panel_3.add(Science);
		
		JPanel panel_4 = new JPanel();
		//FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBackground(Color.BLACK);
		panel_4.setBounds(579, 11, 58, 56);
		contentPane.add(panel_4);
		
		JLabel logout = new JLabel("");
		logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) 
			{				
				int YesOrNo = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?","Logout", JOptionPane.YES_NO_OPTION);
				if(YesOrNo == 0) 
				{
					MainDashboard MainDashboard = new MainDashboard(fullname1,fullname2,fullname3,score1,score2,score3);
					MainDashboard.setVisible(true);
					UserDashboard.this.dispose();
				}
				else 
				{

				}
			}
		});
		logout.setIcon(new ImageIcon("C:\\Users\\jara\\Documents\\pic\\logout.png"));
		panel_4.add(logout);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.setBackground(Color.BLACK);
		panel_5.setBounds(530, 116, 125, 112);
		contentPane.add(panel_5);
		
		JLabel ReportCard = new JLabel("");
		ReportCard.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) 
			{				
				ReportCard ReportCard = new ReportCard(username,fullname,mscore,itscore,sciscore,avgscore,stuid);
				ReportCard.setVisible(true);			
			}
		});
		panel_5.add(ReportCard);
		ReportCard.setIcon(new ImageIcon("C:\\Users\\jara\\Documents\\pic\\ReportCard.png"));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_6.setBackground(Color.BLACK);
		panel_6.setBounds(634, 17, 58, 50);
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
		exit.setIcon(new ImageIcon("C:\\Users\\jara\\Documents\\pic\\SmallExit.png"));
		panel_6.add(exit);
		
		JLabel logo = new JLabel("");
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		logo.setIcon(new ImageIcon("C:\\Users\\jara\\Documents\\pic\\logo3.png"));
		logo.setBounds(230, 0, 234, 73);
		contentPane.add(logo);
		
		JLabel lblWelcomeBack = new JLabel("Welcome back!");
		lblWelcomeBack.setFont(new Font("Gill Sans MT", Font.PLAIN, 22));
		lblWelcomeBack.setForeground(SystemColor.text);
		lblWelcomeBack.setBounds(24, 145, 309, 30);
		contentPane.add(lblWelcomeBack);
		
		JLabel lblusername = new JLabel(fullname);
		lblusername.setText(String.valueOf(fullname));	
		lblusername.setForeground(SystemColor.textHighlight);
		lblusername.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblusername.setBounds(24, 116, 246, 27);
		contentPane.add(lblusername);
		
		JLabel lblRememberYouNeed = new JLabel("Remember, you need to pass all three subjects to qualify.");
		lblRememberYouNeed.setForeground(Color.WHITE);
		lblRememberYouNeed.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		lblRememberYouNeed.setBounds(24, 173, 478, 27);
		contentPane.add(lblRememberYouNeed);
		
		JLabel lblYouCanAlso = new JLabel("You can also check your report card to track your progress.");
		lblYouCanAlso.setForeground(Color.WHITE);
		lblYouCanAlso.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		lblYouCanAlso.setBounds(24, 196, 478, 27);
		contentPane.add(lblYouCanAlso);
		
		JLabel stuID = new JLabel(String.valueOf("Student ID: " +stuid));
		stuID.setForeground(UIManager.getColor("textHighlight"));
		stuID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		stuID.setBounds(24, 65, 196, 40);
		contentPane.add(stuID);
		
		timeLabel = new JLabel("");
		timeLabel.setForeground(Color.LIGHT_GRAY);
		timeLabel.setBounds(24, 23, 151, 24);
		contentPane.add(timeLabel);
		
		dateLabel = new JLabel("");
		dateLabel.setForeground(Color.LIGHT_GRAY);
		dateLabel.setBounds(24, 0, 151, 24);
		contentPane.add(dateLabel);

		clock();
	}
}
	
	

