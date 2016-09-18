package in.xgen.web.profile.user.dao;



import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import in.xgen.exception.UserAlreadyExitsException;
import in.xgen.web.profile.user.domain.User;
import in.xgen.web.profile.user.domain.UserToken;
import in.xgen.web.profile.user.utils.SessionUtils;

public class UserDAOImpl  implements UserDAO{

	private static Logger log = Logger.getLogger(UserDAOImpl.class);
	private Session sess = null;
	private Transaction trans = null;
	
	
	 
	
	public int saveUser(User usr) {
		// TODO Auto-generated method stub
		log.info("Saving User Details:"+usr);
		int seqId = 0;
		try{
		sess = SessionUtils.getSession();
		trans = sess.beginTransaction();
		
		seqId = (Integer)sess.save(usr);
		trans.commit();
		}catch(Exception e){
			log.error("Exception is raising while saving user details:"+e);
		}
		finally{
			if(sess.isOpen()){
				sess.close();
				
			}
		}
		
		return seqId;
	}


	 
	public List<Object[]> getUserByEmail(String emailId) {
		// TODO Auto-generated method stub
		log.info("Getting password using email:"+emailId);
		 String hqlQry = "select usr.password,usr.userId from User usr where usr.email = :emailid";
		 Query query = null;
		 List<Object[]> users = null; 
		 try{
			sess = SessionUtils.getSession();
			query = sess.createQuery(hqlQry);
			query.setParameter("emailid", emailId);
			users = query.list();
			
			
			}catch(Exception e){
				log.error("Exception is raising while saving user details:"+e);
			}
			finally{
				if(sess.isOpen()){
					sess.close();
					
				}
			}
		
		return users;
	}


	 
	public void saveUserToken(String identification, String token) {
		// TODO Auto-generated method stub
		
	}


	 
	public UserToken selectUsrToken(String email) {
		// TODO Auto-generated method stub
		return null;
	}


	 
	public void updateTokens(UserToken tokens) {
		// TODO Auto-generated method stub
		log.info("Start fetching authenrication key of userid:"+tokens);
		Query hqlQuery = null;
		UserToken usrTkn = null;
		try{
		
			sess = SessionUtils.getSession();
			hqlQuery = sess.createQuery("from UserToken where userId = :userId");
			hqlQuery.setParameter("userId", tokens.getUserId());
			
			usrTkn = (UserToken)hqlQuery.list().get(0);
		
			usrTkn.setIdentificationId(tokens.getIdentificationId());
			usrTkn.setTokens(tokens.getTokens());
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			log.debug("closing resource");
			if(sess!=null ||sess.isOpen()){
				sess.clear();
				sess.close();
				sess=null;
			}
		}
	}


	 
	public List<UserToken> getAuthKey(int  userId) {
		// TODO Auto-generated method stub
		
		log.info("Start fetching authenrication key of userid:"+userId);
		
		Criteria crit = null;
		List<UserToken> tokenList = null;
		try{
			
			sess = SessionUtils.getSession();
			crit = sess.createCriteria(UserToken.class);
			crit.add(Restrictions.eq("userId", userId));
			tokenList = crit.list();
			
		}catch(Exception e){
			log.error("Exception is raised while fetching the auth key"+e);
		}
		
		
		return tokenList;
	}


	 
	public int saveAuthKey(UserToken token) {
		// TODO Auto-generated method stub
		log.info("Start saving authkey");
		log.info("User Authentication Key"+token);
		Integer authKeyId = null;		
		 try{
			 
			
			 sess = SessionUtils.getSession();
			trans = sess.beginTransaction();
			authKeyId = (Integer) sess.save(token);
			trans.commit();
			
			}catch(Exception e){
				log.error("Exception is raising while saving user details:"+e);
			}
			finally{
				if(sess.isOpen()){
					sess.close();
					
				}
			}
		 
		 log.info("end saving authkey");
		 return authKeyId;
	}
	
	
		
	}
