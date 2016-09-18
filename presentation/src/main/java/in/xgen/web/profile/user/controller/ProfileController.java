package in.xgen.web.profile.user.controller;

import in.xgen.vo.ProfileVO;
import in.xgen.vo.UserVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpRequest;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfileController {

	private final Logger logger = Logger.getLogger(ProfileController.class);
	
	@RequestMapping(value="/profile",method=RequestMethod.GET)
	public ModelAndView displayLogin(HttpServletRequest req){
		logger.info("Invoked");
		
		System.out.println("Session in profile controller:"+req.getSession());
		
		UserVO user = (UserVO) req.getSession().getAttribute("userDetails");
		
		if(user==null){
			System.out.println("User is empty and Session in not created");
		}
		
		return new ModelAndView("profile","command",user);
	}

	
	
	@RequestMapping(value="/profile",method=RequestMethod.POST)
	public ModelAndView postProfile(HttpServletRequest req){
		logger.info("Invoked");
		
		System.out.println("Session in profile controller:"+req.getSession());
		
		UserVO user = (UserVO) req.getSession().getAttribute("userDetails");
		
		if(user==null){
			System.out.println("User is empty and Session in not created");
		}
		
		return new ModelAndView("profile","command",user);
	}
}
