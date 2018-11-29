import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;


@SuppressWarnings("serial")
public class Prizes extends JFrame 
{
	private JPanel contentPane;
	private JLabel label,label_1,label_2,egypt,tv,phone;
	private JTextArea award2Tv,award1Travel,Award3iPhone;
	
	
	
	//This GUI diaplays the potential prizes. layout and design with fetching of images
	public Prizes() 
	{
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\jara\\Documents\\pic\\Prize3.png"));
		setTitle("Prizes!");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 718, 475);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\jara\\Documents\\pic\\award1.png"));
		label.setBounds(34, 11, 59, 129);
		contentPane.add(label);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\jara\\Documents\\pic\\award2.png"));
		label_1.setBounds(34, 160, 59, 121);
		contentPane.add(label_1);
		
		label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("C:\\Users\\jara\\Documents\\pic\\award3.png"));
		label_2.setBounds(34, 302, 59, 107);
		contentPane.add(label_2);
		
		award2Tv = new JTextArea();
		award2Tv.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		award2Tv.setEditable(false);
		award2Tv.setBackground(Color.BLACK);
		award2Tv.setForeground(Color.WHITE);
		award2Tv.setText("Win a Samsung QN65Q6F Flat 65\u201D QLED 4K UHD 6 Series Smart TV 2018. Valued at $2,640.00 US. Experience dramatic depth from the darkest to brightest scenes. Smart TV with Bixby Voice: A revolutionary way to help find streaming and live TV shows with a universal guide, OneRemote and voice assistance. ");
		award2Tv.setLineWrap(true);
		award2Tv.setWrapStyleWord(true);
		award2Tv.setBounds(115, 164, 366, 127);
		contentPane.add(award2Tv);
		
		award1Travel = new JTextArea();
		award1Travel.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		award1Travel.setEditable(false);
		award1Travel.setText("Win an all expense paid trip to Egypt for seven days. Valued at $6,350.00 US. Home of the ancient Pharaohs, Egypt is a dazzling destination of temples and tombs that wow all who visit. It's not all historic treasures though. The last surviving of the Seven Wonders of the Ancient World, the Pyramids of Giza are one of the world's most recognisable landmarks.");
		award1Travel.setLineWrap(true);
		award1Travel.setWrapStyleWord(true);
		award1Travel.setBackground(Color.BLACK);
		award1Travel.setForeground(Color.WHITE);
		award1Travel.setBounds(115, 22, 366, 129);
		contentPane.add(award1Travel);
		
		Award3iPhone = new JTextArea();
		Award3iPhone.setText("Win a Samsung Galaxy Note 9 Factory Unlocked with 6.4\" Screen and 128GB, Midnight Black Smartphone. Valued at $1,370.00 US. The Note 9 gives you a quick network connection for incredibly fast streaming and downloading, so you can do more, uninterrupted. Get a phone with more freedom.");
		Award3iPhone.setLineWrap(true);
		Award3iPhone.setWrapStyleWord(true);
		Award3iPhone.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		Award3iPhone.setEditable(false);
		Award3iPhone.setForeground(Color.WHITE);
		Award3iPhone.setBackground(Color.BLACK);
		Award3iPhone.setBounds(115, 302, 366, 134);
		contentPane.add(Award3iPhone);
		
		egypt = new JLabel("");
		egypt.setIcon(new ImageIcon("C:\\Users\\jara\\Documents\\pic\\egypt2.jpg"));
		egypt.setBounds(496, 17, 182, 123);
		contentPane.add(egypt);
		
		tv = new JLabel("");
		tv.setIcon(new ImageIcon("C:\\Users\\jara\\Documents\\pic\\tv3.jpg"));
		tv.setBounds(491, 160, 186, 107);
		contentPane.add(tv);
		
		phone = new JLabel("");
		phone.setIcon(new ImageIcon("C:\\Users\\jara\\Documents\\pic\\phone.png"));
		phone.setBounds(523, 292, 154, 107);
		contentPane.add(phone);
	}
}
