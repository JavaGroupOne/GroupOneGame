import java.sql.*;
import javax.swing.*;


public class sqliteConnection 
{
	Connection conn=null;
	public static Connection dbConnector()
	{
		try
		{
			Class.forName("org.sqlite.JDBC");
			Connection conn=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\jara\\eclipse-workspace\\Login\\DB\\QuizDB.db");
			//JOptionPane.showMessageDialog(null, "Successful Connection");
			return conn;
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"No Connection was made");
			return null;
		}
		
}
}