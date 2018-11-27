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
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class LoginDB extends JFrame 
{

	public static final String gettextFieldUsername = null;

	private JPanel contentPane;
	Connection connection=null;
	private JTextField textFieldUsername;
	private JPasswordField passwordField;
	public String username,fullname;
	public double mscore,itscore,sciscore,avgscore;
	public int stuid;
	public Calendar datetime;
	
	
	public LoginDB() 
	{
		connection=sqliteConnection.dbConnector();
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
		
		JLabel label = new JLabel("");
		label.setBounds(94, 0, 269, 73);
		label.setIcon(new ImageIcon("C:\\Users\\jara\\Documents\\pic\\logo3.png"));
		contentPane.add(label);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Gill Sans MT", Font.BOLD, 17));
		btnLogin.setBackground(SystemColor.textHighlight);
		btnLogin.setForeground(Color.WHITE);
		btnLogin.addActionListener(new ActionListener() 
		{
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) 
			{String username, fname, lname, fullname, query;

				try
				{
					query = "SELECT * FROM Userinfo WHERE usernam=? and passwor=? ";
					PreparedStatement Prepstat = connection.prepareStatement(query);
					Prepstat.setString(1, textFieldUsername.getText());
					Prepstat.setString(2, passwordField.getText());
					ResultSet ResultSet = Prepstat.executeQuery();
					
					int count = 0;
					while(ResultSet.next())
					{
						count++;

					}
					if (count == 1)
						{												
						ResultSet ResultSet2 = Prepstat.executeQuery();
						username = textFieldUsername.getText();
						username.equals(String.valueOf(textFieldUsername));
						fname = ResultSet2.getString("fname");
						lname = ResultSet2.getString("lname");
						int stuid = ResultSet2.getInt("stuid");
						double mscore = ResultSet2.getDouble("mscore");
						double itscore = ResultSet2.getDouble("itscore");
						double sciscore = ResultSet2.getDouble("sciscore");
						double avg = (mscore + itscore + sciscore)/3.0;
						double avgscore = (Math.round(((avg)*100.0))/100.0);
						fullname = fname +" "+ lname;
						java.sql.Date datetime = new java.sql.Date(new java.util.Date().getTime());

						String sql = "update Userinfo set avgscore ='"+avgscore+"',datetime ='"+ datetime +"'where usernam ='"+username+"'";
						//String sql2 = "update Userinfo set datetime='"+datetime+"' where usernam='"+username+"'";
						PreparedStatement Preps = connection.prepareStatement(sql);
						//PreparedStatement Preps2 = connection.prepareStatement(sql2);
						Preps.executeUpdate();
						//Preps2.executeUpdate();
						//Prepstat2.close();
						//Preps.execute();
						//Preps2.execute();
						ResultSet.close();
						Prepstat.close();
						
						
						UserDashboard UserDashboard = new UserDashboard(username,fullname,mscore,itscore,sciscore,avgscore,stuid);
						UserDashboard.setVisible(true);
						LoginDB.this.dispose();	
						ResultSet.close();
						}	
						else
						{
							JOptionPane.showMessageDialog(null, "Incorrect username or password. Try again...");				
						}
				}					
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}		
			}
		});
		btnLogin.setBounds(257, 208, 89, 23);
		contentPane.add(btnLogin);
		
		JLabel lblUsername = new JLabel("User Name:");
		lblUsername.setFont(new Font("Gill Sans MT", Font.PLAIN, 18));
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setBounds(68, 110, 116, 31);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
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
