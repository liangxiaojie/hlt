package base.user.service.impl;

import java.util.Map;

import base.user.service.UserService;

import com.cmbc.edw.bs.AbstractBizService;
import com.cmbc.edw.model.Page;

public class UserServiceImpl extends AbstractBizService  implements UserService {

	public Page queryUser(Map map, int pageNo, int pageSize) {
		return mybatis().query4Page("hlt.base.queryUser","hlt.base.queryUserTotal",map, pageNo, pageSize);
	}
	
}
