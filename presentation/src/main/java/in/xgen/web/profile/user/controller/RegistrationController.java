
package in.xgen.web.profile.user.controller;

import in.xgen.annotation.PhoneValidator;
import in.xgen.exception.UserAlreadyExitsException;
import in.xgen.service.user.AddressService;
import in.xgen.service.user.AddressServiceImpl;
import in.xgen.service.user.UserService;
import in.xgen.service.user.UserServiceImpl;
import in.xgen.user.validator.UserFormValidator;
import in.xgen.vo.UserVO;
import in.xgen.web.profile.user.domain.City;
import in.xgen.web.profile.user.domain.Country;
import in.xgen.web.profile.user.domain.State;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;



@Controller

public class RegistrationController{

	private static Logger log = Logger.getLogger(RegistrationController.class);
	
	
	@Autowired
	@Qualifier("userFormValidator")
	private Validator validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	
	
	@RequestMapping(value="/registration",method=RequestMethod.GET)
	
	public String getRegistrationForm(Model model) {

			 
			UserVO user  = new UserVO();
			
			
			List<Country> countries= addressService.getAllCountries();
			List<State> states= addressService.getAllState();
			List<City> cities= addressService.getAllCity();
			
			user.setCountries(countries);
			user.setStates(states);
			user.setCities(cities);
			
			model.addAttribute("userForm", user);
			return "registration";
		
		
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String register( @ModelAttribute("userForm") @Validated UserVO user, BindingResult result, ModelMap model) {
		System.out.println("Registration start");
		UserService userService = new UserServiceImpl();
		ModelAndView mav = null;
		
		log.debug("User value in RegistrationController:"+user);
		try{
			
			//mav = new ModelAndView();
			if (result.hasErrors()) {
				//logger.info("Returning custSave.jsp page");
				return "registration";
			}
			userService.registerUser(user);
			model.addAttribute("userInfo",user);
			return "forward:/profile";
		}
		catch(UserAlreadyExitsException e){
			result.rejectValue("email", "message.regError");
			log.error(e);
			return "redirect:/registration";
		}
		
		
	}
	
	@Autowired
	private AddressService addressService = null;


	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}
	
	
	@RequestMapping(value="/webservice/address/country/",method=RequestMethod.GET,headers="Accept=application/json")
	public ResponseEntity<List<Country>> getAllCountry(){
		List<Country> countries= addressService.getAllCountries();
		
		if(countries.isEmpty()){
			return new ResponseEntity<List<Country>>(HttpStatus.NO_CONTENT);
		}
		else{
			return new ResponseEntity<List<Country>>(countries,HttpStatus.OK);
		}
		}
	
	@RequestMapping(value = "/webservice/address/country/{id}", method = RequestMethod.GET,headers="Accept=application/json")  
	 public ResponseEntity<Country> getCountryById(@PathVariable int id)  
	 {  
	  Country country = addressService.getCountryById(id);
	 
	  
	  if(country==null){
		  return new ResponseEntity<Country>(HttpStatus.NO_CONTENT);
	  }
	  else{
		  return new ResponseEntity<Country>(country,HttpStatus.OK);  
	  }
	    
	 } 

	
	
	
	@RequestMapping(value = "/webservice/address/country/", method = RequestMethod.POST,headers="Accept=application/json")  
	 public ResponseEntity<Void> getCountryById(@RequestBody Country country,UriComponentsBuilder ucBuilder)  
	 {  int id = 0;
		System.out.println("Creating country: " + country.getName());

		/*if (addressService.isUserExist(user)) {
			System.out.println("A User with name " + user.getName() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}*/

		id = addressService.saveCountry(country);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/webservice/address/country/{id}").buildAndExpand(country.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }
	
}
