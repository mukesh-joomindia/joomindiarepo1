package in.xgen.web.listner;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionIdListener;
import javax.servlet.http.HttpSessionListener;

public class SessionTracker implements HttpSessionListener,	HttpSessionBindingListener, HttpSessionAttributeListener,HttpSessionIdListener {

	
	public void sessionIdChanged(HttpSessionEvent event, String oldSessionId) {
		// TODO Auto-generated method stub

		System.out.println("Event Session id:"+event.getSession().getId());
		System.out.println("Old Session Id:"+oldSessionId);
		
		
		
	}

	
	public void attributeAdded(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub

		System.out.println("Bind Atrribute name:"+event.getName());
		
	}

	
	public void attributeRemoved(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub

		System.out.println("Attribute remooved from :"+event.getName());
	}

	
	public void attributeReplaced(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub

		System.out.println("Attribute replaced from :"+event.getName());
	}

	
	public void valueBound(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		
		System.out.println("Attribute Binding :"+event.getName());

	}

	
	public void valueUnbound(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		
		System.out.println("value unbond from :"+event.getName()+"Event value:"+event.getValue());

	}

	
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		
		System.out.println("Session is created");

	}

	
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		System.out.println("Session is destroyed");

	}

}
