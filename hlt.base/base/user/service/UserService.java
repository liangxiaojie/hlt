package base.user.service;

import java.util.Map;

import com.cmbc.edw.model.Page;

public interface UserService {
	public final static String SPRING_ID = "base.user.UserService";
	
	public Page queryUser(Map map,int pageNo,int pageSize);
	
}
