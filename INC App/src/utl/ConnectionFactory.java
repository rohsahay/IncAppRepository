package utl;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	private static Connection con=null;
	public static Connection getConnection(){
		try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","rohit","sahay");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return con;
	}
}
