package dao;

import dto.LoginDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.ResultSet;

import utl.ConnectionFactory;

public class UserLoginDao {
	
	Connection  conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	static final Logger logger = LogManager.getLogger();
	
	public boolean validate(LoginDto ldto)throws SQLException{
		try{
			logger.info("welcome to UserLoginDao");
			conn=ConnectionFactory.getConnection();
			String searchQuery="select * from UserLogin where username=?  AND password=? ";
			ps=conn.prepareStatement(searchQuery);
			ps.setString(1,ldto.getName());	
			ps.setString(2,ldto.getPassword());
			logger.info(ldto.getName());
			logger.info(ldto.getPassword());
			rs=ps.executeQuery();
			logger.info("got update from database successfully!!");
			
			if(rs.next())
				{	
					
					return true;
				}
				else
				{
					return false;
				}
							
		}
		catch(Exception e){
			e.printStackTrace();
        	throw new SQLException("Initialization failed, unable to get Db connection");
			
		}
		finally
        {
        	rs.close();
        	ps.close();
        	conn.close();
        }
	}
}
