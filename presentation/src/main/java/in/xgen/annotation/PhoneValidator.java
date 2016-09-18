package in.xgen.annotation;

import java.lang.annotation.Annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
public class PhoneValidator implements ConstraintValidator<Phone,String>{

	
	
	public void initialize(Phone arg0) {
		// TODO Auto-generated method stub
		
	}

	
	public boolean isValid(String phoneNo, ConstraintValidatorContext cvc) {
		// TODO Auto-generated method stub
		if(phoneNo==null||phoneNo.equals("")){
		return false;
		}
		if (phoneNo.matches("\\d{10}")) return true;
		 //validating phone number with -, . or spaces
		else if(phoneNo.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) return true;
		//validating phone number with extension length from 3 to 5
		 else if(phoneNo.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}")) return true;
		//validating phone number where area code is in braces ()
		 else if(phoneNo.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")) return true;
		//return false if nothing matches the input
		 else return false;
	}

	
}
