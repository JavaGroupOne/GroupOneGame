import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.sql.*;



@SuppressWarnings("serial")
public class ReportCard extends JFrame 
{
	
	Connection connection=null;
	private JPanel contentPane;
	public String username,fullname;
	public double mscore,itscore,sciscore,avgscore;
	public int stuid;
	private JLabel label_3,label,label_1,label_2,advisory;
	private JPanel panel,panel_1,panel_2;
	private JButton mathTestScore,avgScore,itTestScore,scienceTestScore;

	//acquire information via another class to enable representation in the dashboard view
	public ReportCard(String username, String fullname, double mscore, double itscore, double sciscore, double avgscore, int stuid) 
	{
		
		//GUI design
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\jara\\Documents\\pic\\ReportCard.png"));
		setTitle(fullname +"'s Report Card");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 718, 475);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label_3 = new JLabel("");
		label_3.setBounds(229, 0, 255, 73);
		label_3.setIcon(new ImageIcon("C:\\Users\\jara\\Documents\\pic\\logo3.png"));
		contentPane.add(label_3);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(Color.BLACK);
		panel.setBounds(42, 130, 177, 158);
		contentPane.add(panel);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\jara\\Documents\\pic\\Math2.png"));
		panel.add(label);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(268, 140, 177, 148);
		contentPane.add(panel_1);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\jara\\Documents\\pic\\IT2.png"));
		panel_1.add(label_1);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(479, 140, 177, 137);
		contentPane.add(panel_2);
		
		label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("C:\\Users\\jara\\Documents\\pic\\Science4.png"));
		panel_2.add(label_2);
		
		// score refereced based on function to enable in the respective buttonsfor display 
		mathTestScore = new JButton(String.valueOf(Math.round(((mscore)*100.0))/100.0 +"%")); 
		
		 
		// Formats buttons on JFrame
		mathTestScore.setFont(new Font("Tahoma", Font.BOLD, 22));
		mathTestScore.setForeground(Color.GRAY);
		mathTestScore.setBounds(65, 291, 131, 47);
		contentPane.add(mathTestScore);

		avgScore = new JButton(String.valueOf(Math.round(((avgscore)*100.0))/100.0 + "%"));
		avgScore.setForeground(Color.MAGENTA);
		avgScore.setFont(new Font("Tahoma", Font.BOLD, 24));
		avgScore.setBounds(551, 11, 141, 62);
		contentPane.add(avgScore);
		
		itTestScore = new JButton(String.valueOf(Math.round(((itscore)*100.0))/100.0 +"%"));
		itTestScore.setFont(new Font("Tahoma", Font.BOLD, 22));
		itTestScore.setForeground(Color.GRAY);
		itTestScore.setBounds(291, 291, 131, 47);
		contentPane.add(itTestScore);
		
		scienceTestScore = new JButton(String.valueOf(Math.round(((sciscore)*100.0))/100.0 +"%"));
		scienceTestScore.setForeground(Color.GRAY);
		scienceTestScore.setFont(new Font("Tahoma", Font.BOLD, 22));
		scienceTestScore.setBounds(504, 291, 131, 47);
		contentPane.add(scienceTestScore);
		
		advisory = new JLabel("An average of your overall score is calculated and used in the competition");
		advisory.setHorizontalAlignment(SwingConstants.CENTER);
		advisory.setFont(new Font("Gill Sans MT", Font.PLAIN, 17));
		advisory.setForeground(Color.WHITE);
		advisory.setBounds(70, 377, 560, 29);
		contentPane.add(advisory);
	}
}
