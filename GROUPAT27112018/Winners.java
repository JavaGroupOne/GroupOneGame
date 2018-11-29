import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;


@SuppressWarnings("serial")
public class Winners extends JFrame 
{
	public String fullname1,fullname2,fullname3,score1,score2,score3;
	private JPanel contentPane;
	private JLabel secondPlace,firstPlace,thirdPlace,yay,secondPlaceName,firstPlaceName,thirdPlaceName,LogoGam,congrats;
	private JButton secondPlaceScore,firstPlaceScore,thirdPlaceScore;

	
	//This GUI diaplays the potential prizes. layout and design with fetching of images
	public Winners(String fullname1,String fullname2,String fullname3,String score1,String score2,String score3) 
	{
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\jara\\Documents\\pic\\Winners2.png"));
		setTitle("Winners!");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 718, 475);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		firstPlace = new JLabel("");
		firstPlace.setIcon(new ImageIcon("C:\\Users\\jara\\Documents\\pic\\first.png"));
		firstPlace.setBounds(308, 11, 97, 196);
		contentPane.add(firstPlace);
		
		secondPlace = new JLabel("");
		secondPlace.setIcon(new ImageIcon("C:\\Users\\jara\\Documents\\pic\\second.png"));
		secondPlace.setBounds(62, 68, 97, 204);
		contentPane.add(secondPlace);
		
		thirdPlace = new JLabel("");
		thirdPlace.setIcon(new ImageIcon("C:\\Users\\jara\\Documents\\pic\\third.png"));
		thirdPlace.setBounds(525, 68, 90, 196);
		contentPane.add(thirdPlace);
		
		yay = new JLabel("");
		yay.setIcon(new ImageIcon("C:\\Users\\jara\\Documents\\pic\\confetti3.png"));
		yay.setBounds(24, 0, 658, 216);
		contentPane.add(yay);
		
		secondPlaceScore = new JButton(String.valueOf(score2 +"%"));
		secondPlaceScore.setForeground(new Color(255, 51, 102));
		secondPlaceScore.setFont(new Font("Gill Sans MT", Font.BOLD, 16));
		secondPlaceScore.setBounds(62, 293, 89, 23);
		contentPane.add(secondPlaceScore);

		secondPlaceName = new JLabel(String.valueOf(fullname2));
		secondPlaceName.setHorizontalAlignment(SwingConstants.CENTER);
		secondPlaceName.setFont(new Font("Gill Sans MT", Font.PLAIN, 18));
		secondPlaceName.setForeground(Color.WHITE);
		secondPlaceName.setBounds(0, 256, 207, 48);
		contentPane.add(secondPlaceName);
		
		firstPlaceScore = new JButton(String.valueOf(score1 +"%"));
		firstPlaceScore.setForeground(new Color(255, 51, 102));
		firstPlaceScore.setFont(new Font("Gill Sans MT", Font.BOLD, 16));
		firstPlaceScore.setBounds(313, 232, 89, 23);
		contentPane.add(firstPlaceScore);
		
		
		firstPlaceName = new JLabel(String.valueOf(fullname1));
		firstPlaceName.setHorizontalAlignment(SwingConstants.CENTER);
		firstPlaceName.setForeground(Color.WHITE);
		firstPlaceName.setFont(new Font("Gill Sans MT", Font.PLAIN, 18));
		firstPlaceName.setBounds(227, 195, 254, 48);
		contentPane.add(firstPlaceName);
		
		thirdPlaceScore = new JButton(String.valueOf(score3 +"%"));
		thirdPlaceScore.setForeground(new Color(255, 51, 102));
		thirdPlaceScore.setFont(new Font("Gill Sans MT", Font.BOLD, 16));
		thirdPlaceScore.setBounds(536, 289, 89, 23);
		contentPane.add(thirdPlaceScore);
		
		thirdPlaceName = new JLabel(String.valueOf(fullname3));
		thirdPlaceName.setHorizontalAlignment(SwingConstants.CENTER);
		thirdPlaceName.setForeground(Color.WHITE);
		thirdPlaceName.setFont(new Font("Gill Sans MT", Font.PLAIN, 18));
		thirdPlaceName.setBounds(484, 252, 195, 48);
		contentPane.add(thirdPlaceName);
		
		LogoGam = new JLabel("");
		LogoGam.setIcon(new ImageIcon("C:\\Users\\jara\\Documents\\pic\\logo3.png"));
		LogoGam.setBounds(227, 355, 237, 67);
		contentPane.add(LogoGam);
		
		congrats = new JLabel("Cogratulations from");
		congrats.setForeground(Color.PINK);
		congrats.setFont(new Font("Gill Sans MT", Font.PLAIN, 18));
		congrats.setBounds(297, 347, 166, 48);
		contentPane.add(congrats);
	}
}
