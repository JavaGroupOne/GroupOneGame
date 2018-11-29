import java.sql.*;
import javax.swing.*;


public class sqliteConnection 
{
	Connection conn=null;
	public static Connection dbConnector()
	{
		try
		{	//this enables connectivity requirement to SQlite DB. The location will need to be change
			//the SQLlite DB is portable and requires no installation. it is accessible to the Java project at all ties within the folder
			Class.forName("org.sqlite.JDBC");
			Connection conn=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\jara\\eclipse-workspace\\Login\\Login\\DB\\QuizDB.db");
			return conn;
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
}
