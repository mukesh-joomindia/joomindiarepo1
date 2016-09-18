package in.xgen.web.profile.user.dao;

import in.xgen.vo.Notification;

import java.util.List;

public interface NotificationDAO {

	public List<Notification> fetchAllNotification(int userId);
}
