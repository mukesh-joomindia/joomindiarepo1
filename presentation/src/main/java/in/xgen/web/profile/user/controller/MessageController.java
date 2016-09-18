package in.xgen.web.profile.user.controller;

import in.xgen.service.user.MessageService;
import in.xgen.service.user.MessageServiceImpl;
import in.xgen.web.profile.user.dao.Messages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class MessageController
 */
public class MessageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(MessageController.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	
    public MessageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		log.info("Get Method invoked");
		List<Messages> messages = null; 
		MessageService msgService = null;
		PrintWriter writer = response.getWriter();
		JSONObject responseDetailsJson = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		msgService = new MessageServiceImpl();
		response.setContentType("application/json");
		 messages = msgService.showAllUserMsg();
		  if(messages!=null){
			  for(Messages msg:messages){
				  JSONObject jMsg = new JSONObject();
				  jMsg.put("id", msg.getMsgId());
				  jMsg.put("content", msg.getMsg());
				  jMsg.put("Time", msg.getMsgDate());
				  jMsg.put("Type", msg.getMsgType());
				  jMsg.put("sender", msg.getSendName());
				  jMsg.put("status", msg.getStatus());
				  jsonArray.add(jMsg);
			  }
		  }
		  responseDetailsJson.put("msg", jsonArray);
		  writer.print(responseDetailsJson);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
