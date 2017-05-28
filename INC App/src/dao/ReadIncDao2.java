package dao;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import utl.HibernateUtil;
import dto.IncDto2;
public class ReadIncDao2 {
		
	static final Logger logger = LogManager.getLogger();
	//Read has been made as an overloaded method
	public static ArrayList<IncDto2> read(String analyst,String startRow,String endRow)throws SQLException{
		ArrayList<IncDto2> inc=new ArrayList<IncDto2>();
		IncDto2 id = null;
		Session session = null;
		Transaction tx = null;
		try{
			logger.info("Welcome to readIncDao2!");
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String hql="FROM IncDto2 AS I WHERE I.feanalyst=:analyst";
			Query query = session.createQuery(hql);
			query.setParameter("analyst",analyst);
			query.setFirstResult(Integer.parseInt(startRow));
			query.setMaxResults(10);
			List results = query.list();
			
			logger.info("getting incidents..");
			Iterator ritr = results.listIterator();
			while(ritr.hasNext()){
				id = (IncDto2)ritr.next();
				
				logger.info("Incident number: "+id.getCasenmbr()+" Date: "+dateFormat.format(id.getDate())+" Description: "+id.getDesc());
				
				inc.add(id);
			}
			
		}
		catch(Exception e){
			if (tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		return inc;
	}
	
	public static ArrayList<IncDto2> read(String caseno)throws SQLException{
		ArrayList<IncDto2> inc=new ArrayList<IncDto2>();
		IncDto2 id = null;
		Session session = null;
		Transaction tx = null;
		try{
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			logger.info("Welcome to readIncDao2!");
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			String hql="FROM IncDto2 AS I WHERE I.casenmbr=:caseno";
			Query query = session.createQuery(hql);
			query.setParameter("caseno",caseno);
			List results = query.list();
			logger.info("getting incident..");
			Iterator ritr = results.listIterator();
			while(ritr.hasNext()){
				id = (IncDto2)ritr.next();
				
				logger.info("Incident number: "+id.getCasenmbr()+" Date: "+dateFormat.format(id.getDate())+" Description: "+id.getDesc());
				
				inc.add(id);
			}
		}
		catch(Exception e){
			if (tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		return inc;
	}
	
	
}
