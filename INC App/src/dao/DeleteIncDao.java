package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import utl.ConnectionFactory;

public class DeleteIncDao {
	static Connection conn=null;
	static ResultSet rs=null;
	static PreparedStatement ps= null;
	static final Logger logger = LogManager.getLogger();
	
	public static void delete(String analyst, String caseno)throws SQLException{
		try{
			logger.info("in DeleteIncDao");
			conn=ConnectionFactory.getConnection();
			String deleteQuery="DELETE FROM INCIDENT_TABLE WHERE CASE=? and FE_ANALYST=?";
			ps=conn.prepareStatement(deleteQuery);
			ps.setString(1,caseno);
			ps.setString(2,analyst);
			int n=ps.executeUpdate();
			if (n==1)
				logger.info("deletion successful");
			else
				logger.info("deletion unsuccessful");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			ps.close();
        	conn.close();
		}
	}
}
