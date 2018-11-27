import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class MathTest extends JFrame 
{
	private JPanel contentPane;

	public MathTest() 
	{
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\jara\\Documents\\pic\\Math2.png"));
		setTitle("Mathematics");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 718, 475);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setForeground(Color.WHITE);
		label.setIcon(new ImageIcon("C:\\Users\\jara\\Documents\\pic\\Math2.png"));
		label.setBounds(276, 0, 157, 162);
		contentPane.add(label);
		
		JButton btnClear = new JButton("Check");
		btnClear.setBounds(300, 382, 110, 23);
		contentPane.add(btnClear);
		
		JButton btnNextQuestion = new JButton("Next");
		btnNextQuestion.setBounds(447, 382, 110, 23);
		contentPane.add(btnNextQuestion);
		
		JButton btnNewButton = new JButton("Previous");
		btnNewButton.setBounds(152, 382, 110, 23);
		contentPane.add(btnNewButton);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setForeground(new Color(51, 0, 0));
		menuBar.setBackground(new Color(51, 0, 0));
		menuBar.setBounds(0, 0, 33, 21);
		contentPane.add(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setForeground(new Color(255, 255, 255));
		mnFile.setBackground(new Color(51, 0, 0));
		menuBar.add(mnFile);
		
		JMenuItem mntmCleaer = new JMenuItem("Clear Answers");
		mnFile.add(mntmCleaer);
		
		JMenuItem mntmTest = new JMenuItem("Exit");
		mntmTest.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				MathTest.this.dispose();
			}
		});
		mnFile.add(mntmTest);
	}
}
