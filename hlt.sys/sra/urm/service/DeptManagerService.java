package sra.urm.service;

import java.util.List;

/**
 *  用户关联角色管理接口
 * @author xie_guanjie
 * 
 * @version 2013-5-23
 */
public interface DeptManagerService {

	public final static String SPRINT_ID = "DeptUserService";

	/**
	 * 部门关联部门管理员查询列表
	 * 
	 * @param deptId
	 * @return List
	 */
	public List queryDeptUsers(String deptId);
	
	/**
	 * 部门删除 时，删除部门和部门管理员关联表内部门对应的管理员信息
	 * 
	 * @param deptId
	 */
	public void deleteDeptUsers(String []deptId);
	
	/**
	 * 更新用户角色信息
	 * 
	 * @param deptId
	 * @param userIds
	 */
	public void updateDeptUsers(String deptId,List userIds);
	/**
	 *查询此部门下没有的用户 
	 * 
	 */
	public List queryDeptNoUsers(String deptId);
	/**
	 * 查询所选部门下的 人员
	 * @param deptId
	 * @return
	 */
	public List queryDeptUsersByDeptId(String deptId);
}
