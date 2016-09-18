package in.xgen.exception;

public class UserAlreadyExitsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6285531163385841975L;

	public UserAlreadyExitsException(String msg){
		super(msg);
	}
}
