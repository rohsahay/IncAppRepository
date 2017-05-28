package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import dto.IncDto;
import dto.IncDto2;
import utl.ConnectionFactory;
import utl.HibernateUtil;

public class IncDao2 {
	Connection  conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	Session session = null;
	Transaction tx = null;
	static final Logger logger = LogManager.getLogger();
	public boolean insert(IncDto2 idto)throws SQLException{
		int n=2;
		try{
			logger.info("welcome to inc dao for insert");
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			String id1 = (String) session.save(idto);
			logger.info("Incident save called with transaction, id="+id1);
			tx.commit();
			logger.info(n);
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
	public boolean update(IncDto2 idto)throws SQLException{
		int n=2;
		try{
			logger.info("welcome to inc dao for update");
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			session.update(idto);
			tx.commit();
			logger.info(n);
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
	
	public void delete(String analyst, String casenmbr)throws SQLException{
		try{
			logger.info("in IncDao2 for deletion");
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			String hql="DELETE FROM IncDto2 AS I WHERE I.casenmbr=:casenmbr AND I.feanalyst=:analyst";
			Query query = session.createQuery(hql);
			query.setParameter("casenmbr",casenmbr);
			query.setParameter("analyst",analyst);
			
			int result = query.executeUpdate();
			tx.commit();
			if (result > 0)
				logger.info("deletion successful");
			else
				logger.info("deletion unsuccessful");
		}
		catch(Exception e){
			if (tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
		}
		finally{
			if (session!=null){
				session.close();
			}
		}
	}
	
}
