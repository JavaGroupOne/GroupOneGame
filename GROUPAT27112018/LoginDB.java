import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class LoginDB extends JFrame 
{
	Connection connection=null;

	public static final String gettextFieldUsername = null;
	
	
	public String username,fullname;
	public double mscore,itscore,sciscore,avgscore,avg;
	public int stuid;
	private JPanel contentPane;
	private JLabel label,lblUsername,lblPassword;
	private JButton btnLogin;
	private JTextField textFieldUsername;
	private JPasswordField passwordField;
	private PreparedStatement Prepstat,Preps,Preps2;
	private ResultSet ResultSet,ResultSet2;
	private String query,fname, lname,sql,sql2;
	private int count = 0;
	
	
	public LoginDB() 
	{
		connection=sqliteConnection.dbConnector();
		
		//GUI layout and design
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\jara\\Documents\\pic\\Login.png"));
		setTitle("User Login");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label = new JLabel("");
		label.setBounds(94, 0, 269, 73);
		label.setIcon(new ImageIcon("C:\\Users\\jara\\Documents\\pic\\logo3.png"));
		contentPane.add(label);
		
		// This listener when event confirmed will validate the user credentials and complete a check via the DB re existing scores for redundacy calculations
		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Gill Sans MT", Font.BOLD, 17));
		btnLogin.setBackground(SystemColor.textHighlight);
		btnLogin.setForeground(Color.WHITE);
		btnLogin.addActionListener(new ActionListener()  
		{
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) 
			{String username,  fullname;

				try
				{
					//username and password validation
					query = "SELECT * FROM Userinfo WHERE usernam=? and passwor=? ";
					Prepstat = connection.prepareStatement(query);
					Prepstat.setString(1, textFieldUsername.getText());
					Prepstat.setString(2, passwordField.getText());
					ResultSet = Prepstat.executeQuery();
					//while look to go the each row, if count equals 1, it means the username with respective password was found 
					count = 0;
					while(ResultSet.next())
					{
						count++;

					}
					if (count == 1)
						{												
						ResultSet2 = Prepstat.executeQuery();
						username = textFieldUsername.getText();
						username.equals(String.valueOf(textFieldUsername));
						fname = ResultSet2.getString("fname");
						lname = ResultSet2.getString("lname");
						stuid = ResultSet2.getInt("stuid");
						mscore = ResultSet2.getDouble("mscore");
						itscore = ResultSet2.getDouble("itscore");
						sciscore = ResultSet2.getDouble("sciscore");
						avg = (mscore + itscore + sciscore)/3.0;
						avgscore = (Math.round(((avg)*100.0))/100.0);
						fullname = fname +" "+ lname;
						java.sql.Date datetime = new java.sql.Date(new java.util.Date().getTime());

						sql = "update Userinfo set avgscore='"+avgscore+"' where usernam='"+username+"'";
						sql2 = "update Userinfo set datetime='"+datetime+"' where usernam='"+username+"'";
						Preps = connection.prepareStatement(sql);
						Preps2 = connection.prepareStatement(sql2);
						Preps.execute();
						Preps2.execute();
						//ResultSet2.close();	
						
						UserDashboard UserDashboard = new UserDashboard(username,fullname,stuid);
						UserDashboard.setVisible(true);
						LoginDB.this.dispose();	
						
						
						}
						else
						{
							//if the count is not equal to 1 it means the data entered is not validated via the DB
							JOptionPane.showMessageDialog(null, "Incorrect username or password. Try again...");				
						}
					ResultSet.close();
					Prepstat.close();
				}		
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}		
			}
		});
		btnLogin.setBounds(257, 208, 89, 23);
		contentPane.add(btnLogin);
		
		lblUsername = new JLabel("User Name:");
		lblUsername.setFont(new Font("Gill Sans MT", Font.PLAIN, 18));
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setBounds(68, 110, 116, 31);
		contentPane.add(lblUsername);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Gill Sans MT", Font.PLAIN, 18));
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(68, 159, 77, 28);
		contentPane.add(lblPassword);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(194, 110, 164, 31);
		contentPane.add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setBounds(194, 152, 164, 31);
		contentPane.add(passwordField);
	}
}
