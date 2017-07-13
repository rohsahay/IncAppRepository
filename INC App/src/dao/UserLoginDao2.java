// this dao implements hibernate 

package dao;

import dto.LoginDto;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import utl.HibernateUtil;

public class UserLoginDao2 {
	
	
	static final Logger logger = LogManager.getLogger();
	Session session = null;
	Transaction tx = null;
	
	public boolean validate(LoginDto ldto)throws SQLException{
		try{
			logger.info("welcome to UserLoginDao2");
			
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			String hql = "FROM LoginDto AS L WHERE L.name=:emp_name AND L.password=:pwd AND L.privilege=:pvg";
			Query query = session.createQuery(hql);
			query.setParameter("emp_name",ldto.getName());
			query.setParameter("pwd",ldto.getPassword());
			query.setParameter("pvg",ldto.getPrivilege());
			logger.info(ldto.getName());
			logger.info(ldto.getPassword());
			logger.info(ldto.getPrivilege());
			List results = query.list();
			logger.info("got update from database successfully!!");
			tx.commit();
			
			Iterator ritr = results.listIterator();
/*			while(ritr.hasNext()){
			       LoginDto ld = (LoginDto)ritr.next();
			       System.out.println("Username: " + ld.getName()+" Password: "+ld.getPassword()+" Privilege: "+ld.getPrivilege()); 		            		            
			}					
*/			
			if(ritr.hasNext())
				{	
					logger.info("found value, returning TRUE");
					return true;
				}
				else
				{
					logger.info("no values found, returning FALSE");
					return false;
				}
							
		}
		catch(Exception e){
			if (tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
			e.getMessage();
        	throw new SQLException("Initialization failed, unable to get Db connection");
			
		}
		finally
        {
			if (session!=null){
				session.close();
			}
			
        }
	}
}
