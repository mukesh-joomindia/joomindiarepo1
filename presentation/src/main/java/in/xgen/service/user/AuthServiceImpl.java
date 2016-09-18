package in.xgen.service.user;

import java.util.List;

import org.apache.log4j.Logger;

import in.xgen.web.profile.user.dao.AuthDAO;
import in.xgen.web.profile.user.dao.AuthDAOImpl;
import in.xgen.web.profile.user.domain.UserToken;

public class AuthServiceImpl implements AutheService{

	private AuthDAO authDAO = null;
	private final Logger log = Logger.getLogger(AuthServiceImpl.class);
	
	
	public int regAuthVerification(String token) {
		// TODO Auto-generated method stub
	 log.info("Token verification start");
	 int status = 0;
	 List<UserToken> usrTokens = null;
	 authDAO = new AuthDAOImpl();
	 usrTokens = authDAO.getAuthK(token);
	 
	 for(UserToken uToken :usrTokens){
		 if(token.equals(uToken.getTokens())){
			 status = 1;
		 }
	 }
	 
		
		
		return status;
	}

}
