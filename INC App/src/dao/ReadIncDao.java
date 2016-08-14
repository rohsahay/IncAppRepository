package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import utl.ConnectionFactory;
import dto.IncDto;
public class ReadIncDao {
	static Connection conn=null;
	static ResultSet rs=null;
	static PreparedStatement ps= null;
	static final Logger logger = LogManager.getLogger();
	public static ArrayList<IncDto> read(String analyst,String startRow,String endRow)throws SQLException{
		
			logger.info("Welcome to read inc dao!");
			
			String casenmbr=null;
			String date=null;
			String desc=null;
			String pendingwth=null;
			String status=null;
			String comnt=null;
			String fe_analyst=null;
			String serialNo=null;
			
			ArrayList<IncDto> inc=new ArrayList<IncDto>();
			IncDto incident=null;

		try{
			conn=ConnectionFactory.getConnection();
			String readQuery="SELECT * FROM(SELECT CASE,DATE_TIME,DECRIPTION,PENDING_WITH,STATUS,COMMENTS,FE_ANALYST,rownum rn FROM (SELECT * FROM INCIDENT_TABLE WHERE FE_ANALYST=?)WHERE rownum <= ?)WHERE rn >= ?";
			ps=conn.prepareStatement(readQuery);
			//pagination is supposed to have 10 rows
			ps.setFetchSize(11);  
//			logger.info("fetch size"+ps.getFetchSize());
			ps.setString(1,analyst);
			ps.setString(2,endRow);
			ps.setString(3,startRow);
			ResultSet rs=ps.executeQuery();
			logger.info("getting incidents..");
			
			while(rs.next()){
				casenmbr=rs.getString(1);
				date=rs.getString(2);
				desc=rs.getString(3);
				pendingwth=rs.getString(4);
				status=rs.getString(5);
				comnt=rs.getString(6);
				fe_analyst=rs.getString(7);
				serialNo=rs.getString(8);
				logger.info(casenmbr+" "+date+" "+desc+" "+pendingwth+" "+status+" "+comnt+" "+fe_analyst+" "+serialNo);
				
				incident=new IncDto();
				incident.setCasenmbr(casenmbr);
				incident.setDate(date);
				incident.setDesc(desc);
				incident.setPendingwth(pendingwth);
				incident.setStatus(status);
				incident.setComnt(comnt);
				incident.setAnalyst(fe_analyst);
				incident.setSerialNo(serialNo);
				
				inc.add(incident);
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			ps.close();
        	conn.close();
		}
		return inc;
	}
}
