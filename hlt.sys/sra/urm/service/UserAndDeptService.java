package sra.urm.service;

import java.util.List;
import java.util.Map;

import com.cmbc.edw.model.Page;

import sra.urm.vo.Dept;
import sra.urm.vo.Role;

/**
 * 用户关联部门管理接口
 * @author xie_guanjie
 * 
 * @version 2013-8-05
 */
public interface UserAndDeptService {
	public final static String SPRINT_ID = "UserAndDeptService";

	/**
	 * 用户关联部门查询列表
	 * 
	 * @param userId
	 * @return List
	 */
	public List queryUserAndDepts(String userId);

	/**
	 * 用户删除 时，删除用户和部门关联表内用户对应的部门信息
	 * 
	 * @param userId
	 * @param deptId
	 */
	public void deleteDeptOfUser(String deptId,String []userId);
	/**
	 * 删除用户和用户部门关联信息
	 * 
	 * @param userId
	 */
	public void deleteDeptAndUser(String deptId,String[] userIds) ;
	/**
	 * 更新角色菜单信息
	 * 
	 * @param userIds
	 * @param deptId
	 */
	public void updateDeptsOfUser(List userIds,String deptId);

	/**
	 * 查询当前部门的下级部门（不包含本部门）
	 * 
	 * @param deptId
	 * 				部门编号
	 * @param userId
	 * 				用户编号
	 * @return list
	 */
	public List<Dept> queryUnderDepts(String deptId,String userId);
	/**
	 *查询当前用户所在部门 
	 * @param userId
	 * 					用户编号
	 * @param isManager
	 * 					是否部门管理员
	 * @return list 
	 */
	public List<Dept> queryUserDepts(String userId,String isManager);
	/**
	 * 查询当前部门下所有用户
	 * @param map
	 * @param pageNo
	 * @param pageSize
	 * @return page
	 * 
	 */
	public Page queryUsersOfDept(Map<String, String> map, int pageNo, int pageSize);
	
	/**
	 * 新增用户和部门关系信息
	 * 
	 * @param userIds
	 * @param deptId
	 */
	public void addDeptsAndUser(Map<String,String>map);
	/**
	 * 查询当前用户下可选择的角色
	 * @param userId
	 * 
	 */
	public List<Role> queryUserRoles(String userId);
	
	/**
	 * 部门管理员维护部门用户的角色
	 * @param userId
	 * @param roleCodes
	 */
	public void updateDeptUserRoles(String userId,List roleCodes);
	/**
	 * 判断用户是否已经属于部门并添加到指定部门
	 */
	public String addDeptsOfUser(String deptId, List userIds,String status);
	/**
	 * 判断是该用户是否有归属部门
	 */

	public String queryDeptsl(List userIds);
	
}
