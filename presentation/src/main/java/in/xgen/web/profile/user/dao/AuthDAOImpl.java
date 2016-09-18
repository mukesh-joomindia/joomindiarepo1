package in.xgen.web.profile.user.dao;

import in.xgen.web.profile.user.domain.UserToken;
import in.xgen.web.profile.user.utils.SessionUtils;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class AuthDAOImpl implements AuthDAO{

	private final Logger log = Logger.getLogger(AuthDAOImpl.class);
	private Session  sess = null;
	private Transaction trans = null;
	
	
	@Override
	public List<UserToken> getAuthK(String token) {
		// TODO Auto-generated method stub
		log.info("start");
		log.debug("Token:"+token);
		Criteria crit = null;
		List tokens = null;		
		 try{
			sess = SessionUtils.getSession();
			crit = sess.createCriteria(UserToken.class);
			crit.add(Restrictions.eq("tokens", token));
			tokens = crit.list();
			
			
			}catch(Exception e){
				log.error("Exception is raising while saving user details:"+e);
			}
			finally{
				if(sess.isOpen()){
					sess.close();
					
				}
			}
		 
		 log.info("end fetching auth key authkey");
		 return tokens;
		
		
	}

}
