package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dto.IncDto;
import utl.ConnectionFactory;

public class IncDao {
	Connection  conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	static final Logger logger = LogManager.getLogger();
	public boolean insert(IncDto idto)throws SQLException{
		int n=2;
		try{
			logger.info("welcome to inc dao for insert");
			conn=ConnectionFactory.getConnection();
			String insertQuery="insert into incident_table values(?,to_date(?,'yyyy/mm/dd'),?,?,?,?,?)";
			ps=conn.prepareStatement(insertQuery);
			ps.setString(1,idto.getCasenmbr());
			ps.setString(2,idto.getDate());
			ps.setString(3,idto.getDesc());
			ps.setString(4,idto.getPendingwth());
			ps.setString(5,idto.getStatus());
			ps.setString(6,idto.getComnt());
			ps.setString(7,idto.getAnalyst());
			n=ps.executeUpdate();
			logger.info(n);
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
	public boolean update(IncDto idto,String filter)throws SQLException{
		int n=2;
		try{
			logger.info("welcome to inc dao for update");
			conn=ConnectionFactory.getConnection();
			String updateQuery="UPDATE INCIDENT_TABLE SET CASE=?,DATE_TIME=to_date(?,'yyyy/mm/dd'),DECRIPTION=?,PENDING_WITH=?,STATUS=?,COMMENTS=?,FE_ANALYST=? WHERE CASE=?";
			ps=conn.prepareStatement(updateQuery);
			ps.setString(1,idto.getCasenmbr());
			ps.setString(2,idto.getDate());
			ps.setString(3,idto.getDesc());
			ps.setString(4,idto.getPendingwth());
			ps.setString(5,idto.getStatus());
			ps.setString(6,idto.getComnt());
			ps.setString(7,idto.getAnalyst());
			ps.setString(8,filter);
			n=ps.executeUpdate();
			logger.info(n);
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
