package in.xgen.web.profile.user.controller;

import in.xgen.exception.UserNotFoundException;
import in.xgen.service.user.UserService;
import in.xgen.vo.User;
import in.xgen.vo.UserVO;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 */
@Controller
public class LoginController {
	private static final long serialVersionUID = 1L;
    private static Logger logger = Logger.getLogger(LoginController.class);   
    private UserService userService = null;
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

    public LoginController(UserService userService) {
        super();
        this.userService = userService;
        
    }

    @RequestMapping(value="/login",method=RequestMethod.GET)
	public  String getLoginPage(Model model)  {
		
    	model.addAttribute("userForm", new UserVO());
    	return "login";
	}

    
    @RequestMapping(value="/login", method=RequestMethod.POST)
	protected String processLogin(@ModelAttribute("userForm") UserVO user,Model model,HttpServletRequest request,HttpServletResponse response){
		// TODO Auto-generated method stub
	   	
		logger.info("Login Process is starting");
		HttpSession session = null;
		Cookie cookies = null;
		try {
			Integer userId = 0;
			System.out.println("Login IP:"+request.getRemoteAddr());
			userId = userService.loginUser(user.getEmail(), user.getPassword());
				session = request.getSession();
				//testing
				user.setUserId(userId);
				session.setAttribute("userDetails", user);
				cookies = new Cookie("token", ""+userId+System.currentTimeMillis());
				response.addCookie(cookies);
				return "forward:/profile";
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			
				model.addAttribute("error", "Please Check username and password");
			
				return "login";
			
		}
		
	}

	
	
}
