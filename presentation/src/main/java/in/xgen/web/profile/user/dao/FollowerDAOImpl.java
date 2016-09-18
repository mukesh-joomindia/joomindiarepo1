package in.xgen.web.profile.user.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class FollowerDAOImpl implements FollowerDAO{

	private Logger log = Logger.getLogger(FollowerDAOImpl.class);
	private SessionFactory factory;
	Session sess = null;
	
	public List<Object> getFollower(int userId) {
		// TODO Auto-generated method stub
		List<Object> list = null;
		Query query = null;
		sess = factory.openSession();
	 	query = sess.createQuery("select follow_from_id from user_follower where follow_from_id = :userId and status=50");
		query.setParameter(userId, userId);
		list = query.list();
		log.debug("No of follower"+list.size());
		return  list;
	}

	public void setSessionFactory(SessionFactory factory){
		this.factory = factory;
	}
}
