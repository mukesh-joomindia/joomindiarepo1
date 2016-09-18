package in.xgen.service.user;

import in.xgen.web.profile.user.dao.FollowerDAO;

import java.util.List;

import org.apache.log4j.Logger;

public class FollowerServiceImpl implements FollowerService{

	private Logger log = Logger.getLogger(FollowerServiceImpl.class);
	
	public List<Object> getAllFollower(int profileId) {
		// TODO Auto-generated method stub
			log.info("Getting follower list of the user"+profileId);
			List followeList = null;
			followeList = followerDAO.getFollower(profileId);
			log.debug("Number of follower:"+followeList.size());
			return followeList;
	}

	
	public void setFollowerDAO(FollowerDAO followerDAO ){
		this.followerDAO = followerDAO;
	}
	
	private FollowerDAO followerDAO = null;
}
