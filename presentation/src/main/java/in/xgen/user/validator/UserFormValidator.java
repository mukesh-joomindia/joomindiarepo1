package in.xgen.user.validator;

import in.xgen.vo.UserVO;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;



public class UserFormValidator implements Validator{


	public boolean supports(Class<?> classObj) {
		// TODO Auto-generated method stub
		return UserVO.class.equals(classObj);
	}


	public void validate(Object object, Errors errors) {
		// TODO Auto-generated method stub
		UserVO userVO = null;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"firstName","firstName.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"lastName","lastName.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password","password.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"email","email.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"repassword","repassword.required");
		userVO = (UserVO)object;
		
		if(userVO.getPassword().trim().equals(userVO.getRepassword().trim())){
			errors.rejectValue("password", "password.mismatch");
		}
		
	}

}
