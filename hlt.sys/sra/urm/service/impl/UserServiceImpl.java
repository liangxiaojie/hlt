package sra.urm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sra.urm.service.UserService;
import sra.urm.vo.User;
import com.cmbc.edw.bs.AbstractBizService;
import com.cmbc.edw.dao.IIntegratedDAO;
import com.cmbc.edw.model.Page;
/**
 * 用户管理数据交互
 * 
 *@author xie_guanjie
 *@version 2013-4-23
 * 
 */
public class UserServiceImpl extends AbstractBizService implements UserService {
	private IIntegratedDAO daoSupportTemplate;

	public void setDaoSupportTemplate(IIntegratedDAO daoSupportTemplate) {
		this.daoSupportTemplate = daoSupportTemplate;
	}

	/**
	 * 用户查询列表
	 * 
	 * @param map
	 * @param pageNo
	 * @param pageSize
	 * @return page
	 */
	
	public Page queryUsers(Map<String, String> map, int pageNo, int pageSize) {
		if(map.get("userName")!=null&&!"".equals(map.get("userName"))){
			map.put("userName", "%"+map.get("userName")+"%");
		}
		return daoSupportTemplate.getMybatisTemplate().query4Page("sra.urm.queryUsers",
				"sra.urm.queryUsers4Count", map, pageNo, pageSize);
	}
	/**
	 * 查询所有用户以及部门,没有部门的用户也查询出来
	 */
	public Page queryAllUserAndDepts(Map<String, String> map, int pageNo, int pageSize){
		if(map.get("userName")!=null&&!"".equals(map.get("userName"))){
			map.put("userName", "%"+map.get("userName")+"%");
		}
		return daoSupportTemplate.getMybatisTemplate().query4Page("sra.urm.queryAllUserAndDepts",
				"sra.urm.queryUsers4Count", map, pageNo, pageSize);
	}
	/**
	 * 用户新增
	 * 
	 * @param user
	 */
	
	public void addUser(User user) {
		user.setUserPwd("123456");
		daoSupportTemplate.getMybatisTemplate().insert("sra.urm.addUser", user);
	}

	/**
	 * 用户修改
	 * 
	 * @param user
	 */
	
	public void updateUser(User user) {
		daoSupportTemplate.update("sra.urm.updateUser", user);
	}

	/**
	 * 用户删除
	 * 
	 * @param userIds
	 */
	
	public void deleteUser(String[] userIds) {
		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("userIds", userIds);
		daoSupportTemplate.getMybatisTemplate().delete("sra.urm.deleteUsers", map);
		daoSupportTemplate.getMybatisTemplate().delete("sra.urm.deleteRoleOfUser", map);
		//根据用户ID删除部门用户
		daoSupportTemplate.getMybatisTemplate().delete("sra.urm.deleteDeptOfUser", map);
	}

	/**
	 * 查询单个用户
	 * 
	 * @param userId
	 * @return
	 */
	
	public User loadUser(String userId) {
		return (User) daoSupportTemplate.getMybatisTemplate().get("sra.urm.getUser", userId);
	}

	/**
     * 查询多个用户
     * 
     * @param
     * @return List
     * 
     */
	
	public List<User> queryUsers4Combo() {
		return daoSupportTemplate.getMybatisTemplate().query4list("sra.urm.queryUsers");
	}
	
	/**
	 * 查询多个用户 
	 * @param map
	 * 
	 * @return list
	 * */
	
	public List<User> queryUsersForList(String userId,String userName,String userOrg){
		Map<String,String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("userName", userName);
		map.put("userOrg", userOrg);
		return daoSupportTemplate.getMybatisTemplate().query4list("sra.urm.queryUsers", map);
	}

	/**
	 * 校验客户密码
	 * @param map
	 * 
	 * @return boolean
	 */
	
	public boolean checkUserPwd(String userId, String userPwd) {
		User user = new User();
		user.setUserId(userId);
		user = (User)daoSupportTemplate.getMybatisTemplate().get("sra.urm.loadUser", user);
		if(user.getUserPwd()!=null&&userPwd.equals(user.getUserPwd())){
			return true;
		}
		return false;
	}

	
	public List queryDeptUsers(Map<String, String> map) {
		
		return daoSupportTemplate.getMybatisTemplate().query4list("sra.urm.queryUsers", map);
	}
}
