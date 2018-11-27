import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class ReportCard extends JFrame 
{
	private JPanel contentPane;
	public String username,fullname;
	public double mscore,itscore,sciscore,avgscore;
	public int stuid;
	
	public ReportCard(String username, String fullname, double mscore, double itscore, double sciscore, double avgscore, int stuid) 
	{
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
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(229, 0, 255, 73);
		label_3.setIcon(new ImageIcon("C:\\Users\\jara\\Documents\\pic\\logo3.png"));
		contentPane.add(label_3);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(Color.BLACK);
		panel.setBounds(42, 130, 177, 158);
		contentPane.add(panel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\jara\\Documents\\pic\\Math2.png"));
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(268, 140, 177, 148);
		contentPane.add(panel_1);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\jara\\Documents\\pic\\IT2.png"));
		panel_1.add(label_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(479, 140, 177, 137);
		contentPane.add(panel_2);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("C:\\Users\\jara\\Documents\\pic\\Science4.png"));
		panel_2.add(label_2);
		
		JButton mathTestScore = new JButton(String.valueOf(Math.round(((mscore)*100.0))/100.0 +"%"));
		mathTestScore.setFont(new Font("Tahoma", Font.BOLD, 22));
		mathTestScore.setForeground(Color.GRAY);
		mathTestScore.setBounds(65, 291, 131, 47);
		contentPane.add(mathTestScore);

		JButton avgScore = new JButton(String.valueOf(Math.round(((avgscore)*100.0))/100.0 + "%"));
		avgScore.setForeground(Color.MAGENTA);
		avgScore.setFont(new Font("Tahoma", Font.BOLD, 24));
		avgScore.setBounds(551, 11, 141, 62);
		contentPane.add(avgScore);
		
		JButton itTestScore = new JButton(String.valueOf(Math.round(((itscore)*100.0))/100.0 +"%"));
		itTestScore.setFont(new Font("Tahoma", Font.BOLD, 22));
		itTestScore.setForeground(Color.GRAY);
		itTestScore.setBounds(291, 291, 131, 47);
		contentPane.add(itTestScore);
		
		JButton scienceTestScore = new JButton(String.valueOf(Math.round(((sciscore)*100.0))/100.0 +"%"));
		scienceTestScore.setForeground(Color.GRAY);
		scienceTestScore.setFont(new Font("Tahoma", Font.BOLD, 22));
		scienceTestScore.setBounds(504, 291, 131, 47);
		contentPane.add(scienceTestScore);
		
		JLabel advisory = new JLabel("An average of your overall score is calculated and used in the competition");
		advisory.setHorizontalAlignment(SwingConstants.CENTER);
		advisory.setFont(new Font("Gill Sans MT", Font.PLAIN, 17));
		advisory.setForeground(Color.WHITE);
		advisory.setBounds(70, 377, 560, 29);
		contentPane.add(advisory);
	}
}
