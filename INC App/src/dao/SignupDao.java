package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.ResultSet;

import utl.HibernateUtil;
import dto.LoginDto;

public class SignupDao {
	Connection  conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	Session session = null;
	Transaction tx = null;
	static final Logger logger = LogManager.getLogger();
	
	public boolean signup(LoginDto ldto)throws SQLException{
		try{
			logger.info("welcome to sign-up dao for insert");
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			String id1 = (String) session.save(ldto);
			logger.info("Incident save called with transaction, id="+id1);
			tx.commit();
		}
		catch(Exception e){
			if (tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
			return false;
		}
		finally{
			if (session!=null){
				session.close();
			}	
		}
		return true;
	}
}
