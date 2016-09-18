package in.xgen.web.profile.user.dao;

import in.xgen.vo.Notification;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class NotificationDAOImpl implements NotificationDAO{

	private final Logger log = Logger.getLogger(NotificationDAOImpl.class);
	

	public List<Notification> fetchAllNotification(int userId) {
		// TODO Auto-generated method stub
		log.info("Fetching notification for userId:"+userId);
		List<Notification> notification = null;

				
		try{
		
		sess = sessionFactory.openSession();
		tx = sess.beginTransaction();
		crit = sess.createCriteria(Notification.class);
		crit.add(Restrictions.eq("senderId", userId));
		crit.setFirstResult(0);
		crit.setMaxResults(20);
		notification = crit.list();
		log.debug("Total No of the notification of the user:"+userId+" is\t"+notification.size());
		tx.commit();
		}
		catch(HibernateException he){
			log.error("Hibernate Exception is raised:"+he.getMessage());
		}
		finally{
			if(sess!=null ){
				sess.close();
				sess = null;
			}
			if(crit!=null ){
				crit=null;
			}
		}
		return notification;
		
	}
	
	private SessionFactory sessionFactory;
	private Session sess = null;
	private Transaction tx = null;
	private Criteria crit = null;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
