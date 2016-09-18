package in.xgen.service.user;

import in.xgen.exception.UserAlreadyExitsException;
import in.xgen.exception.UserNotFoundException;
import in.xgen.vo.UserVO;



public interface UserService {

	public void registerUser(UserVO usr)throws UserAlreadyExitsException;
	public int loginUser(String emailId,String password) throws UserNotFoundException;
	public boolean checkUserExists(String email);
	public void sendMail(String toEmailId,String authToken);
}
