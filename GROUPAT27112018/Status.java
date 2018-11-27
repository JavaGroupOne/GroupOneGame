import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.sql.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class Status extends JFrame 
{
	private JPanel contentPane;
	private JTable table;
	Connection connection=null;

	public Status()
	{
		connection=sqliteConnection.dbConnector();
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\jara\\Documents\\pic\\CompetitionStatus2.png"));
		setTitle("Status");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 718, 475);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\jara\\Documents\\pic\\logo3.png"));
		label.setBounds(247, 11, 236, 65);
		contentPane.add(label);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setForeground(Color.WHITE);
		btnRefresh.setBackground(SystemColor.textHighlight);
		btnRefresh.setFont(new Font("Gill Sans MT", Font.PLAIN, 17));
		btnRefresh.setBounds(600, 42, 89, 23);
		contentPane.add(btnRefresh);
		btnRefresh.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mousePressed(MouseEvent ag0) 
			{
				btnRefresh.doClick();
				try
				{
					String query = "SELECT DISTINCT fname AS 'First Name',lname AS 'Last Name',stuid AS 'Student ID#',mscore AS 'Mathematics',itscore AS 'IT',sciscore AS 'Science',avgscore AS 'Average', datetime AS 'Last Date' FROM Userinfo ORDER BY avgscore DESC, datetime ASC ";
					PreparedStatement prepStat = connection.prepareStatement(query);
					ResultSet resultSet = prepStat.executeQuery();
					//table.setModel(model);
					
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}		
			}
		});
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(27, 123, 662, 166);
		contentPane.add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JTextArea txtrTheAboveShows = new JTextArea();
		txtrTheAboveShows.setEditable(false);
		txtrTheAboveShows.setBackground(Color.BLACK);
		txtrTheAboveShows.setForeground(Color.WHITE);
		txtrTheAboveShows.setLineWrap(true);
		txtrTheAboveShows.setWrapStyleWord(true);
		txtrTheAboveShows.setFont(new Font("Gill Sans MT", Font.PLAIN, 15));
		txtrTheAboveShows.setText("The above shows all registered competitors and their respective score per subject. The table is sorted by average score in ascending order, then by the earliest date completed. This is to ensure fair play with regards to prize delivery; e.g.: if more than one competitor score 100% on average, or the same score rather, the first competitor to obtain this score will be ranked higher than the other competitor(s).");
		txtrTheAboveShows.setBounds(108, 300, 516, 115);
		contentPane.add(txtrTheAboveShows);
		
		JLabel lblClick = new JLabel("Click");
		lblClick.setFont(new Font("Gill Sans MT", Font.BOLD, 15));
		lblClick.setForeground(Color.PINK);
		lblClick.setBounds(624, 17, 46, 14);
		contentPane.add(lblClick);
	}
}
