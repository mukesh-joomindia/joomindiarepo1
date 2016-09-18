package in.xgen.service.user;

import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

import in.xgen.exception.UserAlreadyExitsException;
import in.xgen.exception.UserNotFoundException;
import in.xgen.utils.HashGenerator;
import in.xgen.vo.UserVO;
import in.xgen.web.profile.user.dao.UserDAO;
import in.xgen.web.profile.user.dao.UserDAOImpl;
import in.xgen.web.profile.user.domain.User;
import in.xgen.web.profile.user.domain.UserToken;

public class UserServiceImpl implements UserService{

	private static Logger log = Logger.getLogger(UserServiceImpl.class);
	private UserDAO uDao = new UserDAOImpl();
	
	

	public void registerUser(UserVO usr) throws UserAlreadyExitsException{
		// TODO Auto-generated method stub
		log.info("User Registration is starting");
		log.debug(usr);
		 
		 String fullName = null;
		 String token = null;
		 UserToken userTokens = null;
		 int authSerialId = 0;
		 
		 if(checkUserExists(usr.getEmail())){
			try{
			   throw new UserAlreadyExitsException("User is already exists");
			 }catch(Exception e){
				log.error("User already exists:::::::::::::");
			}
		}else
		{
			User user = new User();
			UserDAO uDao = new UserDAOImpl();
			user.setFirstName(usr.getFirstName());
			user.setLastName(usr.getLastName());
			user.setEmail(usr.getEmail());
			System.out.println("User password:"+usr.getPassword()+"Generated hashcode:"+HashGenerator.generateHash(usr.getPassword()));
			user.setPassword(HashGenerator.generateHash(usr.getPassword()));

		try{
			int genUserId = uDao.saveUser(user);
			if (genUserId !=0);
			 {
			  fullName = usr.getFirstName().concat(usr.getLastName()) ;
			  token = generateRegToken(fullName, usr.getEmail());
			  userTokens = new UserToken();
			  
			  userTokens.setGeneratedTime(new Date());
			  userTokens.setIdentificationId(HashGenerator.generateHash(fullName));
			  userTokens.setTokens(token);
			  userTokens.setUserId(genUserId);
			  
			   authSerialId = uDao.saveAuthKey(userTokens);
			  
			    if(authSerialId!=0){
			    	sendMail(usr.getEmail(), token);
			    }
			   
			 }
		}
		catch(Exception e){
			log.error( e);
		}
		}
		
	}

	
	
	public int loginUser(String emailId,String pass) throws UserNotFoundException{
		// TODO Auto-generated method stub
				
		int userId = 0;
		String password;
		List<Object[]> users = uDao.getUserByEmail(emailId);
		
		if(users.isEmpty()){
			throw new UserNotFoundException("User not found");
		}
		
		for(Object[] obj:users){
			 userId = (Integer)obj[1];
			 password = (String)obj[0];
		
			 log.info("User id:"+userId);
			log.info("Original Passoword:"+pass);			
			log.info("Generated password:"+HashGenerator.generateHash(pass));
			log.info("System password:"+password);
			 
			 if(password.equals(HashGenerator.generateHash(pass))){
				 return userId;
			 
				 
			 
			 }
			 else{
				 throw new UserNotFoundException("Password is not matching");
			 }
		}
		
		return userId;
	}

	public void setUserDAO(UserDAO uDao){
		this.uDao = uDao;
	}


	public boolean checkUserExists(String emailId) {
		boolean isUserExist = false;
		List<Object[]> users = uDao.getUserByEmail(emailId);
		
		log.debug(users.size());
		
		if(!users.isEmpty()||users==null){
			isUserExist=true;
		}
		
		return isUserExist ;

	}

	
	public void sendMail(String toEmailId,String authToken) {
		// TODO Auto-generated method stub
		
		log.info("Sending mail to :"+toEmailId);
		log.debug("Mail id:"+toEmailId+"\t auth token:"+authToken);
		MimeMessage message = null;
		String fromId="dktest30@gmail.com";
		 Properties props = new Properties();
		 String subject ="Account Registration Conformation";
		 StringBuffer sb  = new StringBuffer(); 
		 props.put("mail.smtp.host", "smtp.gmail.com");  
		  props.put("mail.smtp.socketFactory.port", "465");  
		  props.put("mail.smtp.socketFactory.class",  
		            "javax.net.ssl.SSLSocketFactory");  
		  props.put("mail.smtp.auth", "true");  
		  props.put("mail.smtp.port", "465"); 
		  Session session = Session.getDefaultInstance(props,  
				   new javax.mail.Authenticator() {  
				   protected PasswordAuthentication getPasswordAuthentication() {  
				   return new PasswordAuthentication("dktest30@gmail.com","Test123*");//change accordingly  
				   }  
				  });  
		  
		  
		  try {  
			   message = new MimeMessage(session);  
			   message.setFrom(new InternetAddress("dktest30@gmail.com"));//change accordingly  
			   message.addRecipient(Message.RecipientType.TO,new InternetAddress(toEmailId.trim()));  
			   message.setSubject(subject);
			   sb.append("Hello "+toEmailId+"<br/>");
			   sb.append("Welcome to XgenFamily.To activate your acoount please click on below link or copy paste the link in your browser.<br/>");
			   sb.append("Activation link:<a href=http://10.11.13.88:8080/presentation/activation?regauth="+authToken+">Click Here</a>");
			   message.setContent(sb.toString(), "text/html; charset=utf-8");
			     
			   //send message  
			   Transport.send(message);  
			  
			   System.out.println("message sent successfully");  
			   
			  } catch (MessagingException e) {throw new RuntimeException(e);}  
			   
			 }  
		
	
	public String generateRegToken(String userName,String emailId){
			
				log.info("Key Generated for hash:"+userName.concat(emailId));
				return HashGenerator.generateHash(userName.concat(emailId));
	}
	
	
	}
	
	 
	

