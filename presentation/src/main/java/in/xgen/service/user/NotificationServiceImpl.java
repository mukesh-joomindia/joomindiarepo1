package in.xgen.service.user;

import in.xgen.vo.Notification;

import java.util.List;
import java.util.Set;

public class NotificationServiceImpl implements NotificationService{

	
	public Set<Notification> getNotification(int userId) {
		// TODO Auto-generated method stub
		List<Object> followerList = null;
		followerList = followerService.getAllFollower(userId);
		
		if(followerList.size()!=0){
			
		}
		
		return null;
	}

	
	public boolean hideNotificationFromUser(int userId) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private FollowerService followerService;

	public void setFollowerService(FollowerService followerService) {
		this.followerService = followerService;
	}

}
