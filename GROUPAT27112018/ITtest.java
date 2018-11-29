import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.*;

@SuppressWarnings("serial")
public class ITtest extends JFrame 
{
	Connection connection=null;
	//public double sciscore,mscore,itquizscorecal;
	public String username;	
	private JPanel contentPane;	
	private ArrayList<String[]> questions;
	private int countQuestions =15,increment = 0,correctAnsCount =0,index;
	private JButton btnNewButton_1,nextQues,btnSubmit;
	private JLabel timeLabel,dateLabel,correctCount,correctAns,ans1,ans2,ans3,ans4,label,quesNum;
	private JRadioButton rdbtnA,rdbtnB,rdbtnC,rdbtnD;
	private JMenuItem mntmNewMenuItem_1,mntmNewMenuItem;
	private JTextArea SciQuestion;
	private JMenuBar menuBar;
	private JMenu mnFile;
        private boolean iscorrect;	
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	//enables system current date and time with realtime seconds running
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

	//constructor
	public ITtest(String user) 
	{
		username=user;
		 initializeComponents(username);	
	}
	
	//initializes Components of the GUI
	public void initializeComponents(String username)
	{
		questions = new ArrayList<String[]>();	 
		updateQuestions();
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\jara\\Documents\\pic\\IT2.png"));
		setTitle("Information Technology");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 718, 475);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 165, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton_1 = new JButton("Check");
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) //listens for commited answer and register same to confirm right or wrong
			{
				if (checkAnswer()==true) 
				{
					correctAns.setText("Correct");
					correctAns.setForeground(new Color(0,102,0));	
				}
				else 
				{
					correctAns.setText("Incorrect");
					correctAns.setForeground(new Color(102,102,102));
				}
				rdbtnA.setEnabled(false);
				rdbtnB.setEnabled(false);
				rdbtnC.setEnabled(false);
				rdbtnD.setEnabled(false);
			}
		});
		
		btnNewButton_1.setBounds(251, 398, 101, 23);
		contentPane.add(btnNewButton_1);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\jara\\Documents\\pic\\IT2.png"));
		label.setBounds(291, 0, 156, 146);
		contentPane.add(label);
		
		menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 165, 0));
		menuBar.setBorderPainted(false);
		menuBar.setForeground(new Color(255, 165, 0));	
		menuBar.setBounds(0, 0, 33, 21);	
		contentPane.add(menuBar);
		
		mnFile = new JMenu("File");
		mnFile.setForeground(Color.BLACK);
		mnFile.setBackground(new Color(255, 165, 0));
		menuBar.add(mnFile);
		
		mntmNewMenuItem = new JMenuItem("START OVER"); //calls the restart test function
		mntmNewMenuItem.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{				
				clearQuestions();	 	 	 
			}
		});
		mnFile.add(mntmNewMenuItem);
		
		mntmNewMenuItem_1 = new JMenuItem("EXIT");
		mntmNewMenuItem_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{			
				ITtest.this.dispose();	
			}
		});
		mnFile.add(mntmNewMenuItem_1);
		
		rdbtnA = new JRadioButton("A)");
		rdbtnA.setForeground(Color.BLACK);
		buttonGroup.add(rdbtnA);
		rdbtnA.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnA.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
		rdbtnA.setBackground(new Color(255, 165, 0));
		rdbtnA.setBounds(162, 255, 46, 23);
		contentPane.add(rdbtnA);
		
		rdbtnB = new JRadioButton("B)");
		rdbtnB.setForeground(Color.BLACK);
		buttonGroup.add(rdbtnB);
		rdbtnB.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
		rdbtnB.setBackground(new Color(255, 165, 0));
		rdbtnB.setBounds(162, 291, 46, 23);
		contentPane.add(rdbtnB);
		
		rdbtnC = new JRadioButton("C)");
		rdbtnC.setForeground(Color.BLACK);
		buttonGroup.add(rdbtnC);
		rdbtnC.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
		rdbtnC.setBackground(new Color(255, 165, 0));
		rdbtnC.setBounds(162, 325, 46, 23);
		contentPane.add(rdbtnC);
		
		rdbtnD = new JRadioButton("D)");
		rdbtnD.setForeground(Color.BLACK);
		buttonGroup.add(rdbtnD);
		rdbtnD.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
		rdbtnD.setBackground(new Color(255, 165, 0));
		rdbtnD.setBounds(162, 360, 46, 23);
		contentPane.add(rdbtnD);
		
		SciQuestion = new JTextArea();
		SciQuestion.setForeground(Color.BLACK);
		SciQuestion.setFont(new Font("Gill Sans MT", Font.BOLD, 15));
		SciQuestion.setEditable(false);
		SciQuestion.setBackground(new Color(255, 165, 0));
		SciQuestion.setText(questions.get(index)[0]);
		SciQuestion.setLineWrap(true);
		SciQuestion.setWrapStyleWord(true);
		SciQuestion.setBounds(152, 146, 447, 98);
		contentPane.add(SciQuestion);
		
		quesNum = new JLabel(String.valueOf(increment));
		quesNum.setForeground(Color.BLACK);
		quesNum.setFont(new Font("Gill Sans MT", Font.BOLD, 15));
		quesNum.setBounds(104, 170, 18, 14);
		contentPane.add(quesNum);
		
		ans1 = new JLabel(questions.get(index)[2]);
		ans1.setForeground(Color.BLACK);
		ans1.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
		ans1.setBackground(Color.BLACK);
		ans1.setBounds(214, 255, 363, 23);
		contentPane.add(ans1);
		
		ans2 = new JLabel(questions.get(index)[3]);
		ans2.setForeground(Color.BLACK);
		ans2.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
		ans2.setBackground(Color.BLACK);
		ans2.setBounds(214, 291, 363, 23);
		contentPane.add(ans2);
		
		ans3 = new JLabel(questions.get(index)[4]);
		ans3.setForeground(Color.BLACK);
		ans3.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
		ans3.setBackground(Color.BLACK);
		ans3.setBounds(214, 325, 363, 23);
		contentPane.add(ans3);
		
		ans4 = new JLabel(questions.get(index)[5]);
		ans4.setForeground(Color.BLACK);
		ans4.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
		ans4.setBackground(Color.BLACK);
		ans4.setBounds(214, 360, 363, 23);
		contentPane.add(ans4);
		
		btnSubmit = new JButton("Submit"); //this triggers the display of correct answers out of the 15 questions
		btnSubmit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if (checkAnswer()== true)
				{
				correctAnsCount ++;
				}
				correctAns.setText(String.valueOf(correctAnsCount+"/15 Correct"));		
				updateScoreTable();
			}
		});
		btnSubmit.setBackground(new Color(0, 0, 204));
		btnSubmit.setForeground(Color.WHITE);
		btnSubmit.setBounds(374, 398, 101, 23);
		
		
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
		
		nextQues = new JButton("Next"); // This enables skipping through questions with respective answer options stored in an array
		nextQues.addActionListener(new ActionListener() 
		{
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) 
			{
				if (checkAnswer()== true)
				{
					correctAnsCount ++;
				}
				buttonGroup.clearSelection();
				rdbtnA.setEnabled(true);
				rdbtnB.setEnabled(true);
				rdbtnC.setEnabled(true);
				rdbtnD.setEnabled(true);
				correctAns.setText("");
				
				questions.remove(index);
				
				countQuestions--;
				updateQuestions();
				if (increment == 15)
				{
					nextQues.hide();
				    contentPane.add(btnSubmit);
				    }
				
				quesNum.setText(String.valueOf(increment));
				SciQuestion.setText(questions.get(index)[0]);
				ans1.setText(questions.get(index)[2]);
				ans2.setText((questions.get(index)[3]));
				ans3.setText(questions.get(index)[4]);
				ans4.setText(questions.get(index)[5]);	
			}
		});
		nextQues.setBounds(374, 398, 101, 23);
		contentPane.add(nextQues);
		
		correctAns = new JLabel("");
		correctAns.setForeground(Color.CYAN);
		correctAns.setFont(new Font("Gill Sans MT", Font.BOLD, 15));
		correctAns.setHorizontalAlignment(SwingConstants.CENTER);
		correctAns.setBounds(567, 360, 124, 61);
		contentPane.add(correctAns);
		
		correctCount = new JLabel("");
		correctCount.setBounds(606, 243, 96, 35);
		contentPane.add(correctCount);
	
		clock();	
	}
	
	//pulls question from database and saves it into a arraylist
	public ArrayList<String[]> getQuestions() 
	{
		String[] question;
		String allQues;
		PreparedStatement Prepstat1;
		ResultSet ResultSet1;
		
		try
		{	
		connection=sqliteConnection.dbConnector();
		allQues = "SELECT * from ITQuestions";
		Prepstat1 = connection.prepareStatement(allQues);
		ResultSet1 = Prepstat1.executeQuery();
		
		while (ResultSet1.next()) 
		{
			question  = new String[7];
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
	
	//randomly selects a question from Arraylist
	public void updateQuestions()
	{
		Random rand;
		increment++;
		questions =getQuestions();
			rand = new Random();
			index = rand.nextInt(countQuestions) + 0;	
	}
	// returns a true if answer is correct and false if incorrect
	public boolean checkAnswer()
	{
		String answer ="";
		iscorrect =false;
		
		if(rdbtnA.isSelected()== true) 
		{
			answer = ans1.getText();
		}
		else if(rdbtnB.isSelected()== true) 
		{
			answer = ans2.getText();
		}
		else if(rdbtnC.isSelected()== true) 
		{
			answer = ans3.getText();
		}
		else if(rdbtnD.isSelected()== true)
		{
			answer = ans4.getText();		
		}
		if(answer.equals(questions.get(index)[1].toString()))
		{
			iscorrect =true;		
		}	
	return iscorrect;
	}
	
	// refreshes test questions 
	@SuppressWarnings("deprecation")
	public void clearQuestions() 
	{	
		 increment = 0;
		 countQuestions =15;
		 correctAnsCount =0;
		 btnSubmit.hide();
		 nextQues.show();
		 initializeComponents(username);
	}
	public void updateScoreTable() //Calculation of the test score and average, and writing same to the database for the respective user
	{
		double itquizscore,itquizscorecal,itquizscorepercent;
		String sql,sql2;
		PreparedStatement Prepstat,Prepstat2;
		 
		itquizscore = Double.valueOf(correctAnsCount);
		itquizscorecal = (itquizscore/15.0)*100;
		itquizscorepercent = (Math.round(((itquizscorecal)*100.0))/100.0);
		JOptionPane.showMessageDialog(null, "Your Quiz is finished. Your score is "+itquizscorepercent+"%");
		
		try 
		{
			sql = "update Userinfo set itscore='"+itquizscorepercent+"' where usernam='"+username+"'";
			Prepstat = connection.prepareStatement(sql);
			sql2 = "update Userinfo set avgscore=(mscore+itscore+sciscore)/3 where usernam='"+username+"'";
			Prepstat2 = connection.prepareStatement(sql2);
			Prepstat.execute();
			Prepstat2.execute();
			Prepstat.close();
			Prepstat2.close();
		} 
		catch (Exception e) 
		{
		JOptionPane.showMessageDialog(null, e);
		}
	}	
}
