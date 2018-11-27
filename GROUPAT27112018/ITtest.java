import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;

@SuppressWarnings("serial")
public class ITtest extends JFrame 
{
	Connection connection=null;
	private JLabel timeLabel,dateLabel;
	
	public void clock()
	{
		Thread clock = new Thread()
		{
			public void run()
			{
				int day,month,year,second,minute,hour;
				Calendar calendar;
				try 
				{
					while (true)
					{
					calendar = new GregorianCalendar();
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

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public ITtest() 
	{
		
		ArrayList<String[]> questions = new ArrayList<String[]>();
		int[] count = new int[15];
		questions =getQuestions();
			Random rand = new Random();
			 int i = rand.nextInt(14) + 0;
			 
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ITtest.class.getResource("/images/IT2.png")));
		setTitle("Information Technology");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 718, 475);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 165, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Check");
		btnNewButton_1.setBounds(288, 398, 110, 23);
		contentPane.add(btnNewButton_1);
		
		JButton startExam = new JButton("Start");
		startExam.setBounds(613, 111, 89, 23);
		contentPane.add(startExam);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ITtest.class.getResource("/images/IT2.png")));
		label.setBounds(291, 0, 156, 146);
		contentPane.add(label);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setForeground(new Color(255, 165, 0));
		menuBar.setBackground(new Color(255, 165, 0));		
		menuBar.setBounds(0, 0, 33, 21);
		contentPane.add(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setForeground(Color.BLACK);
		mnFile.setBackground(new Color(255, 165, 0));
		menuBar.add(mnFile);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Clear Answers");
		mnFile.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Exit");
		mntmNewMenuItem_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{			
				ITtest.this.dispose();	
			}
		});
		mnFile.add(mntmNewMenuItem_1);
		
		JRadioButton rdbtnA = new JRadioButton("A)");
		buttonGroup.add(rdbtnA);
		rdbtnA.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnA.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
		rdbtnA.setBackground(new Color(255, 165, 0));
		rdbtnA.setBounds(162, 255, 46, 23);
		contentPane.add(rdbtnA);
		
		JRadioButton rdbtnB = new JRadioButton("B)");
		buttonGroup.add(rdbtnB);
		rdbtnB.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
		rdbtnB.setBackground(new Color(255, 165, 0));
		rdbtnB.setBounds(162, 291, 46, 23);
		contentPane.add(rdbtnB);
		
		JRadioButton rdbtnC = new JRadioButton("C)");
		buttonGroup.add(rdbtnC);
		rdbtnC.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
		rdbtnC.setBackground(new Color(255, 165, 0));
		rdbtnC.setBounds(162, 325, 46, 23);
		contentPane.add(rdbtnC);
		
		JRadioButton rdbtnD = new JRadioButton("D)");
		buttonGroup.add(rdbtnD);
		rdbtnD.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
		rdbtnD.setBackground(new Color(255, 165, 0));
		rdbtnD.setBounds(162, 360, 46, 23);
		contentPane.add(rdbtnD);
		
		JTextArea itQuestion = new JTextArea();
		//itQuestion.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
		itQuestion.setFont(new Font("Gill Sans MT", Font.BOLD, 15));
		itQuestion.setEditable(false);
		itQuestion.setBackground(new Color(255, 165, 0));
		itQuestion.setText(questions.get(i)[0]);
		itQuestion.setLineWrap(true);
		itQuestion.setWrapStyleWord(true);
		itQuestion.setBounds(152, 165, 447, 79);
		contentPane.add(itQuestion);
		
		JLabel quesNum = new JLabel("1)");
		quesNum.setBounds(38, 148, 46, 14);
		contentPane.add(quesNum);
		
		JLabel ans1 = new JLabel(questions.get(i)[2]);
		ans1.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
		ans1.setBackground(Color.BLACK);
		ans1.setBounds(214, 255, 363, 23);
		contentPane.add(ans1);
		
		JLabel ans2 = new JLabel(questions.get(i)[3]);
		ans2.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
		ans2.setBackground(Color.BLACK);
		ans2.setBounds(214, 291, 363, 23);
		contentPane.add(ans2);
		
		JLabel ans3 = new JLabel(questions.get(i)[4]);
		ans3.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
		ans3.setBackground(Color.BLACK);
		ans3.setBounds(214, 325, 363, 23);
		contentPane.add(ans3);
		
		JLabel ans4 = new JLabel(questions.get(i)[5]);
		ans4.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
		ans4.setBackground(Color.BLACK);
		ans4.setBounds(214, 360, 363, 23);
		contentPane.add(ans4);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBackground(new Color(0, 0, 204));
		btnSubmit.setForeground(Color.WHITE);
		btnSubmit.setBounds(613, 144, 89, 23);
		contentPane.add(btnSubmit);
		
		timeLabel = new JLabel("");
		timeLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		timeLabel.setForeground(new Color(0, 0, 204));
		timeLabel.setBounds(551, 11, 151, 24);
		contentPane.add(timeLabel);
		
		dateLabel = new JLabel("");
		dateLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		dateLabel.setForeground(new Color(0, 0, 204));
		dateLabel.setBounds(551, 30, 151, 24);
		contentPane.add(dateLabel);
		
		JButton nextQues = new JButton("Next");
		nextQues.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				ArrayList<String[]> questions = new ArrayList<String[]>();
				int[] count = new int[15];
				questions =getQuestions();
		
				Random rand = new Random();
				int i = rand.nextInt(14) + 0;
				itQuestion.setText(questions.get(i)[0]);
				quesNum.setText(questions.get(i)[1]);
				ans1.setText(questions.get(i)[2]);
				 ans2.setText((questions.get(i)[3]));
				ans3.setText(questions.get(i)[4]);
				ans4.setText(questions.get(i)[5]);
				
			}
		});
		nextQues.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{		
			}
		});
		nextQues.setBounds(410, 398, 73, 23);
		contentPane.add(nextQues);

		
		JButton prevQues = new JButton("Previous");
		prevQues.setBounds(205, 398, 73, 23);
		contentPane.add(prevQues);
	
		clock();
		
	}
	
	public ArrayList<String[]> getQuestions() 
	{
		ArrayList<String[]> questions = new ArrayList<String[]>();

		try
		{	
		connection=sqliteConnection.dbConnector();
		String allQues = "SELECT * from ITQuestions";
		PreparedStatement Prepstat1 = connection.prepareStatement(allQues);
		ResultSet ResultSet1 = Prepstat1.executeQuery();
		
		while (ResultSet1.next()) {
			String[] question  = new String[6];
		question[0]=ResultSet1.getString("Questions");
		question[1]=ResultSet1.getString("Answers");
		question[2]=ResultSet1.getString("A");
		question[3]=ResultSet1.getString("B");
		question[4]=ResultSet1.getString("C");
		question[5]=ResultSet1.getString("D");
		questions.add(question);
				
		}
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
return questions;
	}
	
	
	
	
	
}
