import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class Register extends JFrame 
{
	Connection connection=null;
	private JPanel contentPane;
	private JTextField textFieldLnam,textFieldFnam,textFieldstu,textFieldusenam;
	private JPasswordField textFielduseconpass,textFieldusepass;
	private JLabel label,lblFirstName,lblLastName,lblStudentId,lblUsername,lblPassword,lblConfirmPassword,registerphoto;
	private JButton btnRegister;
	private String selectquery,insertquery,username,sql1,sql2,sql3,sql4;
	private Statement Prepstat;
	private PreparedStatement Prepstat2,Preps1,Preps2,Preps3,Preps4;
	private ResultSet ResultSet;
	
	public Register() 
	{
		connection=sqliteConnection.dbConnector();//DB connector
		
		
		//Registration GUI design
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\jara\\Documents\\pic\\Register3.png"));
		setTitle("Register");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 535, 389);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldLnam = new JTextField();
		textFieldLnam.setBounds(220, 134, 162, 20);
		contentPane.add(textFieldLnam);
		textFieldLnam.setColumns(10);
		
		textFieldstu = new JTextField();
		textFieldstu.setBounds(220, 165, 119, 20);
		contentPane.add(textFieldstu);
		textFieldstu.setColumns(10);
		
		textFieldusenam = new JTextField();
		textFieldusenam.setBounds(220, 196, 119, 20);
		contentPane.add(textFieldusenam);
		textFieldusenam.setColumns(10);
		
		textFieldFnam = new JTextField();
		textFieldFnam.setBounds(220, 103, 162, 20);
		contentPane.add(textFieldFnam);
		textFieldFnam.setColumns(10);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\jara\\Documents\\pic\\logo3.png"));
		label.setBounds(158, 0, 232, 73);
		contentPane.add(label);
		
		lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Gill Sans MT", Font.PLAIN, 16));
		lblFirstName.setForeground(Color.WHITE);
		lblFirstName.setBounds(65, 96, 104, 31);
		contentPane.add(lblFirstName);
		
		lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Gill Sans MT", Font.PLAIN, 16));
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setBounds(65, 127, 80, 31);
		contentPane.add(lblLastName);
		
		lblStudentId = new JLabel("Student ID#:");
		lblStudentId.setFont(new Font("Gill Sans MT", Font.PLAIN, 16));
		lblStudentId.setForeground(Color.WHITE);
		lblStudentId.setBounds(65, 152, 126, 43);
		contentPane.add(lblStudentId);
		
		lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Gill Sans MT", Font.PLAIN, 16));
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setBounds(65, 189, 115, 31);
		contentPane.add(lblUsername);
		
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Gill Sans MT", Font.PLAIN, 16));
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(65, 221, 115, 28);
		contentPane.add(lblPassword);
		
		//The registration checks the DB to ensure the usernam and password are unique before adding to the table. 
		//Additionally, 

		btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Gill Sans MT", Font.PLAIN, 17));
		btnRegister.addActionListener(new ActionListener() 
		{
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) 
			{
				//All fields are required to be filled out logic
				if (textFieldFnam.getText().equals("")||textFieldLnam.getText().equals("")||textFieldstu.getText().equals("")||textFieldusenam.getText().equals("")||textFieldusepass.getText().equals(""))				
					{
					JOptionPane.showMessageDialog(null, "Please fill out the registration form completely...");
					return;
					}		
				else if (textFieldusepass.getText().equals(textFielduseconpass.getText()) )
					{
						try
						{
						Prepstat = connection.createStatement();	//username and password DB comparison
						selectquery = "SELECT * FROM Userinfo WHERE usernam='"+textFieldusenam.getText()+"' or stuid='"+textFieldstu.getText()+"'";
						ResultSet = Prepstat.executeQuery(selectquery);
						if(ResultSet.next()==true)
							{
							JOptionPane.showMessageDialog(null, "Username/Student ID already used. Try again...");
							return;
							}	
						else
							{//Writing to DB when the checks are passed through as successful
							insertquery = "insert into Userinfo (fname,lname,stuid,usernam,passwor) values (?,?,?,?,?)";
							Prepstat2 = connection.prepareStatement(insertquery);	
							Prepstat2.setString (1, textFieldFnam.getText().trim());
							Prepstat2.setString (2, textFieldLnam.getText().trim());
							Prepstat2.setString (3, textFieldstu.getText().trim());
							Prepstat2.setString (4, textFieldusenam.getText().trim());
							Prepstat2.setString (5, textFieldusepass.getText().trim());							
							Prepstat2.execute();	
							
							username = textFieldusenam.getText();
							username.equals(String.valueOf(textFieldusenam));
							
							//Write zero values to the DB to enable immediate calculations
							sql1 = "update Userinfo set avgscore='"+0+"' where usernam='"+username+"'";
							sql2 = "update Userinfo set sciscore='"+0+"' where usernam='"+username+"'";
							sql3 = "update Userinfo set itscore='"+0+"' where usernam='"+username+"'";
							sql4 = "update Userinfo set mscore='"+0+"' where usernam='"+username+"'";
							Preps1 = connection.prepareStatement(sql1);
							Preps2 = connection.prepareStatement(sql2);
							Preps3 = connection.prepareStatement(sql3);
							Preps4 = connection.prepareStatement(sql4);
							Preps1.execute();
							Preps2.execute();
							Preps3.execute();
							Preps4.execute();
							
							JOptionPane.showMessageDialog(null, "Registration Completed!");
							}
						}
						catch (Exception e)
							{
							e.printStackTrace();
							}		
					}
				else
					{
						JOptionPane.showMessageDialog(null, "Password mismatch. Try again...");
						return;				
					}
				Register.this.dispose();
			}	
		});
		btnRegister.setBackground(SystemColor.textHighlight);
		btnRegister.setForeground(Color.WHITE);
		btnRegister.setBounds(413, 314, 92, 21);
		contentPane.add(btnRegister);
		
		lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setForeground(Color.WHITE);
		lblConfirmPassword.setFont(new Font("Gill Sans MT", Font.PLAIN, 16));
		lblConfirmPassword.setBounds(65, 252, 143, 28);
		contentPane.add(lblConfirmPassword);
		
		textFielduseconpass = new JPasswordField();
		textFielduseconpass.setBounds(220, 258, 119, 20);
		contentPane.add(textFielduseconpass);
		
		textFieldusepass = new JPasswordField();
		textFieldusepass.setBounds(220, 227, 119, 20);
		contentPane.add(textFieldusepass);
		
		registerphoto = new JLabel("");
		registerphoto.setIcon(new ImageIcon("C:\\Users\\jara\\Documents\\pic\\Register9.png"));
		registerphoto.setBounds(362, 165, 143, 115);
		contentPane.add(registerphoto);
	}
}
