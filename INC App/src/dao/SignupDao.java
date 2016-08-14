package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import utl.ConnectionFactory;
import dto.SignupDto;

public class SignupDao {
	Connection  conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	public boolean signup(SignupDto sdto)throws SQLException{
		int n=2;
		try{
			System.out.println("welcome to SignupDao");
			conn=ConnectionFactory.getConnection();
			String insertQuery="insert into userlogin values(?,?)";
			ps=conn.prepareStatement(insertQuery);
			ps.setString(1,sdto.getName());	
			ps.setString(2,sdto.getPassword());
			System.out.println(sdto.getName());
			System.out.println(sdto.getPassword());
			n=ps.executeUpdate();
			System.out.println(n);
			
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		finally{
			ps.close();
        	conn.close();
		}
		if(n==1){
			return true;
		}
		else{
			return false;
		}
	}

}
