package dao;

import dto.LoginDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import utl.ConnectionFactory;

public class AdminLoginDao {
	Connection  conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	public boolean validate(LoginDto ldto)throws SQLException{
		try{
			System.out.println("welcome to AdminLoginDao");
			conn=ConnectionFactory.getConnection();
			String searchQuery="select * from AdminLogin where username=?  AND password=? ";
			ps=conn.prepareStatement(searchQuery);
			ps.setString(1,ldto.getName());	
			ps.setString(2,ldto.getPassword());
			System.out.println(ldto.getName());
			System.out.println(ldto.getPassword());
			rs=ps.executeQuery();
			System.out.println("got update from database successfully!!");
			
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
