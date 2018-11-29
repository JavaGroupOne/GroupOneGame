import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class About extends JFrame 
{
	private JButton btnReadMe;
	private JLabel label,lblTheTeam,agraham,jallen,fmccalla,sferguson,gaustin,rfrue,bchang,chibbert,mbarton,lblAndrewGraham,lblJodiann,lblFayonMccalla,bchanglab,colletehibbert,lblMikhail,shanferguson,garaustin,ronfrue;
	private JTextArea txtrTheManagementTeam;
	
	
	public About() // GUI design
	{
		getContentPane().setBackground(Color.BLACK); // adds color to the frame
		setResizable(false); // prevents users from resizing frame
		setTitle("About Us");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // dictates howthe frame will work when the use closes it
		setBounds(100, 100, 718, 475);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\JARA\\Documents\\pic\\About6.png"));
		
		btnReadMe = new JButton("Click Here For \n Readme File"); //creats and labels a button
		btnReadMe.setBounds(426, 369, 225, 29);
		btnReadMe.setForeground(Color.WHITE); // changes the foreground color of the button
		btnReadMe.setBackground(Color.RED); // changes the background color of the button
		btnReadMe.addActionListener(new ActionListener()// Opens the readme text file when selected 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
				    
					Desktop.getDesktop().open(new java.io.File("C:\\Users\\JARA\\Documents\\pic\\Readme.txt"));
				}
				catch (Exception e)
				{e.printStackTrace();
				}		
			}
		});
		getContentPane().setLayout(null);// sets the layout of a frame
		getContentPane().add(btnReadMe); // adds a button to a frame
		
		label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\JARA\\Documents\\pic\\logo3.png")); //places a image on to a label
		label.setBounds(-1, 0, 235, 63);
		getContentPane().add(label);
		
		lblTheTeam = new JLabel("The Team");
		lblTheTeam.setHorizontalAlignment(SwingConstants.CENTER);
		lblTheTeam.setFont(new Font("Gill Sans MT", Font.PLAIN, 18));
		lblTheTeam.setForeground(Color.PINK);
		lblTheTeam.setBounds(284, 40, 134, 23);
		getContentPane().add(lblTheTeam);
		
		txtrTheManagementTeam = new JTextArea();
		txtrTheManagementTeam.setForeground(Color.WHITE);
		txtrTheManagementTeam.setBackground(Color.BLACK);
		txtrTheManagementTeam.setFont(new Font("Gill Sans MT", Font.PLAIN, 13));
		txtrTheManagementTeam.setText("The management team at GAMBROSIJAC has over Twenty Five (25) years' experience in creating quiz applications.  We pride ourselves in creating state of the art online platforms for quiz competitions tailored to cater to the emerging needs of various clientele.\n\nThe constant evolution of our platform is our way of providing optimized applications guaranteed to meet our clients every need. We strongly believe there is no better way of evolving than adding new features to our applications. This application will provide a hands-on experience of our latest quiz site GAMBROSIJAC.  \n\nThis latest application is useful for quiz competitions that use only multiple choice questions and are not specific to one area of specialization. \r\n");
		txtrTheManagementTeam.setBounds(9, 74, 692, 161);
		txtrTheManagementTeam.setLineWrap(true);
		txtrTheManagementTeam.setWrapStyleWord(true);
		getContentPane().add(txtrTheManagementTeam);
		
		agraham = new JLabel("New label");
		agraham.setIcon(new ImageIcon("C:\\Users\\JARA\\Documents\\pic\\agraham3.jpg"));//points to the picture
		agraham.setBounds(10, 246, 91, 68);
		getContentPane().add(agraham);
		
		jallen = new JLabel("");
		jallen.setIcon(new ImageIcon("C:\\Users\\JARA\\Documents\\pic\\jallen.jpg"));
		jallen.setBounds(142, 246, 87, 71);
		getContentPane().add(jallen);
		
		fmccalla = new JLabel("");
		fmccalla.setIcon(new ImageIcon("C:\\Users\\JARA\\Documents\\pic\\fmccalla.jpg"));
		fmccalla.setBounds(270, 246, 71, 71);
		getContentPane().add(fmccalla);
		
		sferguson = new JLabel("");
		sferguson.setIcon(new ImageIcon("C:\\Users\\JARA\\Documents\\pic\\sferguson.jpg"));
		sferguson.setBounds(384, 246, 71, 71);
		getContentPane().add(sferguson);
		
		gaustin = new JLabel("");
		gaustin.setIcon(new ImageIcon("C:\\Users\\JARA\\Documents\\pic\\gaustin.jpg"));
		gaustin.setBounds(481, 246, 82, 71);
		getContentPane().add(gaustin);
		
		rfrue = new JLabel("");
		rfrue.setIcon(new ImageIcon("C:\\Users\\JARA\\Documents\\pic\\rfrue.jpg"));
		rfrue.setBounds(599, 246, 91, 68);
		getContentPane().add(rfrue);
		
		bchang = new JLabel("");
		bchang.setIcon(new ImageIcon("C:\\Users\\JARA\\Documents\\pic\\bchang.jpg"));
		bchang.setBounds(14, 346, 87, 67);
		getContentPane().add(bchang);
		
		chibbert = new JLabel("");
		chibbert.setIcon(new ImageIcon("C:\\Users\\JARA\\Documents\\pic\\chibbert.jpg"));
		chibbert.setBounds(162, 346, 62, 67);
		getContentPane().add(chibbert);
		
		mbarton = new JLabel("");
		mbarton.setIcon(new ImageIcon("C:\\Users\\JARA\\Documents\\pic\\mbarton.jpg"));
		mbarton.setBounds(270, 346, 70, 63);
		getContentPane().add(mbarton);
		
		lblAndrewGraham = new JLabel("Andrew Graham");
		lblAndrewGraham.setFont(new Font("Gill Sans MT", Font.PLAIN, 12));
		lblAndrewGraham.setHorizontalAlignment(SwingConstants.CENTER);
		lblAndrewGraham.setForeground(Color.PINK);
		lblAndrewGraham.setBounds(9, 312, 92, 14);
		getContentPane().add(lblAndrewGraham);
		
		lblJodiann = new JLabel("Jodiann Allen");
		lblJodiann.setHorizontalAlignment(SwingConstants.CENTER);
		lblJodiann.setFont(new Font("Gill Sans MT", Font.PLAIN, 12));
		lblJodiann.setForeground(Color.PINK);
		lblJodiann.setBounds(152, 312, 71, 14);
		getContentPane().add(lblJodiann);
		
		lblFayonMccalla = new JLabel("Fayon McCalla");
		lblFayonMccalla.setFont(new Font("Gill Sans MT", Font.PLAIN, 12));
		lblFayonMccalla.setForeground(Color.PINK);
		lblFayonMccalla.setBounds(270, 312, 71, 14);
		getContentPane().add(lblFayonMccalla);
		
		bchanglab = new JLabel("Bryanna Chang");
		bchanglab.setHorizontalAlignment(SwingConstants.CENTER);
		bchanglab.setForeground(Color.PINK);
		bchanglab.setFont(new Font("Gill Sans MT", Font.PLAIN, 12));
		bchanglab.setBounds(9, 411, 92, 14);
		getContentPane().add(bchanglab);
		
		colletehibbert = new JLabel("Collette Hibbert");
		colletehibbert.setHorizontalAlignment(SwingConstants.CENTER);
		colletehibbert.setForeground(Color.PINK);
		colletehibbert.setFont(new Font("Gill Sans MT", Font.PLAIN, 12));
		colletehibbert.setBounds(142, 411, 92, 14);
		getContentPane().add(colletehibbert);
		
		lblMikhail = new JLabel("Mikhail Barton");
		lblMikhail.setHorizontalAlignment(SwingConstants.CENTER);
		lblMikhail.setForeground(Color.PINK);
		lblMikhail.setFont(new Font("Gill Sans MT", Font.PLAIN, 12));
		lblMikhail.setBounds(260, 411, 92, 14);
		getContentPane().add(lblMikhail);
		
		shanferguson = new JLabel("Shanika Ferguson");
		shanferguson.setHorizontalAlignment(SwingConstants.CENTER);
		shanferguson.setForeground(Color.PINK);
		shanferguson.setFont(new Font("Gill Sans MT", Font.PLAIN, 12));
		shanferguson.setBounds(372, 312, 92, 14);
		getContentPane().add(shanferguson);
		
		garaustin = new JLabel("Garie Austin");
		garaustin.setHorizontalAlignment(SwingConstants.CENTER);
		garaustin.setForeground(Color.PINK);
		garaustin.setFont(new Font("Gill Sans MT", Font.PLAIN, 12));
		garaustin.setBounds(481, 312, 92, 14);
		getContentPane().add(garaustin);
		
		ronfrue = new JLabel("Ronald Frue");
		ronfrue.setHorizontalAlignment(SwingConstants.CENTER);
		ronfrue.setForeground(Color.PINK);
		ronfrue.setFont(new Font("Gill Sans MT", Font.PLAIN, 12));
		ronfrue.setBounds(599, 312, 92, 14);
		getContentPane().add(ronfrue);
	}
}
