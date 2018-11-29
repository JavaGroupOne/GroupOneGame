import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


@SuppressWarnings("serial")
public class Status extends JFrame 
{
    Connection connection=null;
    private JPanel contentPane;
    static JTable table;
    private JButton btnRefresh;
    private JLabel label,lblClick;
    private JScrollPane scrollPane; 
    private JTextArea txtrTheAboveShows;

    public Status()
    {
        connection=sqliteConnection.dbConnector();//DB connector
        String[] ColNames = {"First Name", "Last Name", "Student ID#", "Mathematics", "IT","Science","Average","Last Date"};
       
        
        //GUI design and layout
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
        
        label = new JLabel("");
        label.setIcon(new ImageIcon("C:\\Users\\jara\\Documents\\pic\\logo3.png"));
        label.setBounds(247, 11, 236, 65);
        contentPane.add(label);
        
        btnRefresh = new JButton("Refresh"); //The refresh button enables a real-time data pull from the DB listed in tabular format of all registered users
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
                 String fname ="";
                 String lname ="";
                 String Studid ="";
                 String Mathematics ="";
                 String IT ="";
                 String Science ="";
                 String Average ="";
                 String LDate ="";
                try
                {
                    
                    //String query = "SELECT DISTINCT fname AS 'First Name',lname AS 'Last Name',stuid AS 'Student ID#',mscore AS 'Mathematics',itscore AS 'IT',sciscore AS 'Science',avgscore AS 'Average', datetime AS 'Last Date' FROM Userinfo ORDER BY avgscore DESC, datetime ASC LIMIT 10";
                    String query = "SELECT * FROM(SELECT DISTINCT fname AS 'First Name',lname AS 'Last Name',stuid AS 'Student ID#',mscore AS 'Mathematics',itscore AS 'IT',sciscore AS 'Science',avgscore AS 'Average', datetime AS 'Last Date' FROM Userinfo ORDER BY avgscore DESC, datetime ASC LIMIT 10)";
                    PreparedStatement prepStat = connection.prepareStatement(query);
                    ResultSet resultSet = prepStat.executeQuery();
                     int index = 1;
                    if (resultSet.next())
                    {
                                              
                        fname = resultSet.getString("First Name");
                        lname = resultSet.getString("Last Name");
                        Studid = resultSet.getString("Student ID#");
                        Mathematics = resultSet.getString("Mathematics");
                        IT = resultSet.getString("IT");
                        Science = resultSet.getString("Science");
                        Average = resultSet.getString("Average");
                        LDate = resultSet.getString("Last Date");
                        DefaultTableModel model = new DefaultTableModel();
                        model.setColumnIdentifiers(ColNames);
                        table.setModel(model);
                        index++;
                        model.addRow(new Object[]{fname, lname, Studid, Mathematics, IT, Science, Average,LDate});
                        
                       }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }       
            }
        });
        scrollPane = new JScrollPane(); //Scroll enabled to facilitate viewing scalability of registered users
        scrollPane.setEnabled(false);
        scrollPane.setBounds(27, 123, 662, 166);
        contentPane.add(scrollPane);
        
        table = new JTable();
       
        
       
        scrollPane.setViewportView(table);
        
        txtrTheAboveShows = new JTextArea();
        txtrTheAboveShows.setEditable(false);
        txtrTheAboveShows.setBackground(Color.BLACK);
        txtrTheAboveShows.setForeground(Color.WHITE);
        txtrTheAboveShows.setLineWrap(true);
        txtrTheAboveShows.setWrapStyleWord(true);
        txtrTheAboveShows.setFont(new Font("Gill Sans MT", Font.PLAIN, 15));
        txtrTheAboveShows.setText("The above shows all registered competitors and their respective score per subject. The table is sorted by average score in ascending order, then by the earliest date completed. This is to ensure fair play with regards to prize delivery; e.g.: if more than one competitor score 100% on average, or the same score rather, the first competitor to obtain this score will be ranked higher than the other competitor(s).");
        txtrTheAboveShows.setBounds(108, 300, 516, 115);
        contentPane.add(txtrTheAboveShows);
        
        lblClick = new JLabel("Click");
        lblClick.setFont(new Font("Gill Sans MT", Font.BOLD, 15));
        lblClick.setForeground(Color.PINK);
        lblClick.setBounds(624, 17, 46, 14);
        contentPane.add(lblClick);
    }
}
