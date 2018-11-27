import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import javax.swing.UIManager;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class Welcome extends JFrame 
{
	public String fullname1,fullname2,fullname3,score1,score2,score3;
	private JPanel contentPane;
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome frame = new Welcome();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Welcome() 
	{
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\JARA\\Documents\\pic\\brain.png"));
		setTitle("Welcome");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 485, 345);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(UIManager.getBorder("MenuItem.border"));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGoToDashboard = new JButton("CLICK HERE FOR QUIZ DASHBOARD");
		btnGoToDashboard.setForeground(Color.WHITE);
		btnGoToDashboard.setBackground(new Color(255, 51, 102));
		btnGoToDashboard.setFont(new Font("Gill Sans MT", Font.BOLD, 14));
		btnGoToDashboard.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) 
			{
				MainDashboard MainDashboard = new MainDashboard(fullname1,fullname2,fullname3,score1,score2,score3);
				MainDashboard.setVisible(true);
				Welcome.this.dispose();
			}
		});
		btnGoToDashboard.setBounds(89, 279, 313, 27);
		contentPane.add(btnGoToDashboard);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\jara\\Documents\\pic\\logo3.png"));
		label.setBounds(108, 0, 233, 73);
		contentPane.add(label);
		
		JLabel lblMotivatYourself = new JLabel("Motivate yourself");
		lblMotivatYourself.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		lblMotivatYourself.setForeground(Color.WHITE);
		lblMotivatYourself.setBounds(22, 130, 185, 31);
		contentPane.add(lblMotivatYourself);
		
		JLabel lblAndClaimYour = new JLabel("and claim your title and prize!");
		lblAndClaimYour.setForeground(Color.WHITE);
		lblAndClaimYour.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		lblAndClaimYour.setBounds(22, 159, 304, 31);
		contentPane.add(lblAndClaimYour);
		
		JLabel lblEnterToday = new JLabel("ENTER TODAY!");
		lblEnterToday.setBackground(Color.BLACK);
		lblEnterToday.setForeground(new Color(255, 0, 0));
		lblEnterToday.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		lblEnterToday.setBounds(174, 245, 152, 31);
		contentPane.add(lblEnterToday);
		
		JLabel lblWelcomeTo = new JLabel("Welcome to");
		lblWelcomeTo.setForeground(Color.WHITE);
		lblWelcomeTo.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		lblWelcomeTo.setBounds(191, 11, 185, 31);
		contentPane.add(lblWelcomeTo);
		
		JLabel lblQuizCompetitionWhere = new JLabel("Quiz competition, where we make learning fun!");
		lblQuizCompetitionWhere.setForeground(new Color(30, 144, 255));
		lblQuizCompetitionWhere.setFont(new Font("Gill Sans MT", Font.PLAIN, 18));
		lblQuizCompetitionWhere.setBounds(57, 67, 362, 31);
		contentPane.add(lblQuizCompetitionWhere);
		
		JLabel happy = new JLabel("");
		happy.setIcon(new ImageIcon("C:\\Users\\jara\\Documents\\pic\\Happy2.png"));
		happy.setBounds(393, 147, 86, 95);
		contentPane.add(happy);
		
		JLabel pass = new JLabel("");
		pass.setIcon(new ImageIcon("C:\\Users\\jara\\Documents\\pic\\pass.png"));
		pass.setBounds(10, 185, 86, 108);
		contentPane.add(pass);	
	}
}
