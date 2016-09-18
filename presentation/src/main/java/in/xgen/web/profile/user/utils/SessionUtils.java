package in.xgen.web.profile.user.utils;



import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;


@SuppressWarnings("deprecation")
public class SessionUtils {

	private static final Logger LOG = Logger.getLogger(SessionUtils.class);
	private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
	private static Configuration cfg = null;
	private static SessionFactory sFactory = null;
	
	static{
		
		try{
		sFactory = new  AnnotationConfiguration().configure("/config/hibernate.cgf.xml").buildSessionFactory();
		LOG.info("Session factory is created");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		}
	
	
	public static Session getThreadLocalSession(){
		
		Session sess = (Session)threadLocal.get();
		
		if(sess==null){
			sess = sFactory.openSession();
			threadLocal.set(sess);
		}
		LOG.info("Getting and Setting session to thread local");
		return sess;
	}
	
	
	public static void closeThreadLocalSession(){
		Session sess = (Session)threadLocal.get();
		threadLocal.set(null);
		
		if(sess!=null){
			sess.close();
		}
		
		LOG.info("Thread Local Session is close successfully");
	}

	public static Session getSession(){
			LOG.info("Session Object created Successfully");
			return sFactory.openSession();
		   
	  }

	
	public static void closeSession(Session sess){
		
		if(sess!=null){
			sess.close();
		}
		
		LOG.info("Session close Sucessfully");
	}


}


   