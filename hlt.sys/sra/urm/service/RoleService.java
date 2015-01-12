package sra.urm.service;

import java.util.List;
import java.util.Map;

import com.cmbc.edw.model.Page;
import sra.urm.vo.Role;

/**
 * 角色管理接口
 * @author xie_guanjie
 * 
 * @version 2013-4-22
 */
public interface RoleService {
	public final static String SPRINT_ID = "RoleService";

	/**
	 * 角色查询列表
	 * 
	 * @param map
	 * @param pageNo
	 * @param pageSize
	 * @return page
	 */
	public Page queryRoles(Map<String, String> map, int pageNo, int pageSize);

	/**
	 * 角色新增
	 * 
	 * @param role
	 */
	public void addRole(Role role);

	/**
	 * 角色修改
	 * 
	 * @param role
	 */
	public void updateRole(Role role);

	/**
	 * 角色删除
	 * 
	 * @param roleCodes
	 * @return
	 */
	public void deleteRole(String[] roleCodes);

	/**
	 * 查询单个角色
	 * 
	 * @param roleCode
	 * @return role
	 */
	public Role loadRole(String roleCode);

	/**
	 * 查询用户对应的角色
	 * 
	 * @param userId
	 * @return Role
	 */
	public List<Role> loadRoleOfUser(String userId);
	
	/**
     * 查询多个角色
     * 
     * @param
     * @return List
     * 
     */
	public List<Role> queryRoles4Combo();

}
