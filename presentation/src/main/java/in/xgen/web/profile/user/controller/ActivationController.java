package in.xgen.web.profile.user.controller;

import in.xgen.service.user.AuthServiceImpl;
import in.xgen.service.user.AutheService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class ActivationController
 */
public class ActivationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Logger log = Logger.getLogger(ActivationController.class);   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActivationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		log.info("Get Protocol is identified");
		String regAuthToken = request.getParameter("regauth");
		log.debug("Auth Token:"+regAuthToken);
		AutheService authService = null;
		int status = 0;
		if(regAuthToken!=null){
			authService = new AuthServiceImpl();
			status = authService.regAuthVerification(regAuthToken);
			if(status==1){
				
				request.setAttribute("msg", "Account is Successfully Authentication");
				request.getRequestDispatcher("authentication.jsp").forward(request, response);
				log.info("Authentication Successful");
			}else{
				log.info("Authentication UnSuccessful");
				request.setAttribute("msg", "Your account is not verified");
				request.getRequestDispatcher("authentication.jsp").forward(request, response);
			}
		}else{
			log.info("Authentication Error");
			response.sendError(700,"InvalidUser.jsp");
		}
		
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
