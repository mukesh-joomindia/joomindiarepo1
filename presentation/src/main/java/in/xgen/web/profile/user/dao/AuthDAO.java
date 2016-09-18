package in.xgen.web.profile.user.dao;

import in.xgen.web.profile.user.domain.UserToken;

import java.util.List;

public interface AuthDAO {

	public List<UserToken> getAuthK(String token);
	
}
