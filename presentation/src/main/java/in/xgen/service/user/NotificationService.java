package in.xgen.service.user;

import in.xgen.vo.Notification;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public interface NotificationService {

	public Set<Notification> getNotification(int userId);
	public boolean hideNotificationFromUser(int userId);
	
	
	
}
