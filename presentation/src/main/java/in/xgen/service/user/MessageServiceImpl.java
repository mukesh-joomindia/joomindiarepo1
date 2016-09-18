package in.xgen.service.user;

import in.xgen.web.profile.user.dao.Messages;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageServiceImpl implements MessageService {

	private List<Messages> messages = null;
	

	public List<Messages> showAllUserMsg() {
		// TODO Auto-generated method stub
		
		messages = new ArrayList();
		Messages msg1 = new Messages();
		msg1.setMsg("Hello from Mukesh");
		msg1.setMsgDate(new Date());
		msg1.setMsgType("text");
		msg1.setSendName("Mukesh Kumar");
		msg1.setStatus(1);
		Messages msg2 = new Messages();
		msg1.setMsg("Hello from Mukesh");
		msg1.setMsgDate(new Date());
		msg1.setMsgType("text");
		msg1.setSendName("Mukesh Kumar");
		msg1.setStatus(1);
		
		Messages msg3 = new Messages();
		
		return messages;
	}

}
