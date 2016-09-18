package in.xgen.web.profile.user.dao;

import java.util.List;

import in.xgen.web.profile.user.domain.User;
import in.xgen.web.profile.user.domain.UserToken;

public interface UserDAO {

	public int saveUser(User usr);
	public List<Object[]> getUserByEmail(String email);
	public void saveUserToken(String identification,String token);
	public UserToken selectUsrToken(String email);
	/**
	 * 
	 * Updating records in the database by UserToken object 
	 * 
	 * */
	public void updateTokens(UserToken tokens);
	/**
	 * 
	 * getAuthKey methods returns List of UserToken Object.This method takes userId as a parameter.On the basis of userid it returns List<br/>
	 * of UserTokens.
	 *  
	 * 
	 * 
	 * */
	public List<UserToken> getAuthKey(int userId);
	/**
	 * 
	 * 
	 * Save generated authenticated key.
	 * @param UserToken token:takes a parameter of UserToken object.
	 * 
	 * */
	public int saveAuthKey(UserToken token);
	

}
