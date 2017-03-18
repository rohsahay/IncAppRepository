package utl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Below classes to be imported for connection pool implementation
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionFactory {
	private static Connection con;
	public static Connection getConnection() throws NamingException, SQLException{
		
			
				
	//for connection without pool, direct connection to DB
	//			Class.forName("oracle.jdbc.driver.OracleDriver");
	//			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","rohit","sahay");
				
	//for pooled connection
	//copy jdbc driver jar in server /lib folder
	//make entry in web.xml (edit only from eclipse)
	//create datasource in context.xml (edit only from eclipse)
				Context initContext = new InitialContext();
				Context envContext  = (Context)initContext.lookup("java:/comp/env");
				DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle"); //jndi name of datasource in context.xml
				con = ds.getConnection();
				
				return con;
	}
}

