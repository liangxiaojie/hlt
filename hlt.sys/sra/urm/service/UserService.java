package sra.urm.service;

import java.util.List;
import java.util.Map;

import com.cmbc.edw.model.Page;
import sra.urm.vo.User;

/**
 * 用户管理接口
 * @author xie_guanjie
 * 
 * @version 2013-4-22
 */
public interface UserService {
	public final static String SPRINT_ID = "UserService";

	/**
	 * 用户查询列表
	 * 
	 * @param map
	 * @param pageNo
	 * @param pageSize
	 * @return page
	 */
	public Page queryUsers(Map<String, String> map, int pageNo, int pageSize);
	public List queryDeptUsers(Map<String, String> map);
	/**
	 * 查询所有用户以及部门,没有部门的用户也查询出来
	 */
	public Page queryAllUserAndDepts(Map<String, String> map, int pageNo, int pageSize);
	/**
	 * 用户新增
	 * 
	 * @param user
	 */
	public void addUser(User user);

	/**
	 * 用户修改
	 * 
	 * @param user
	 */
	public void updateUser(User user);

	/**
	 * 用户删除
	 * 
	 * @param userIds
	 */
	public void deleteUser(String[] userIds);

	/**
	 * 查询单个用户
	 * 
	 * @param userId
	 * @return
	 */
	public User loadUser(String userId);

	/**
     * 查询多个用户
     * 
     * @param
     * @return List
     * 
     */
	public List<User> queryUsers4Combo();
	
	/**
	 * 查询多个用户 
	 * @param map
	 * 
	 * @return list
	 * */
	public List<User> queryUsersForList(String userId,String userName,String userOrg);
	
	/**
	 * 校验客户密码
	 * @param map
	 * 
	 * @return boolean
	 */
	public boolean checkUserPwd(String userId,String userPwd);
}
