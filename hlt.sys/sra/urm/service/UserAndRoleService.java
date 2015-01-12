package sra.urm.service;

import java.util.List;
import java.util.Map;

/**
 *  用户关联角色管理接口
 * @author xie_guanjie
 * 
 * @version 2013-4-24
 */
public interface UserAndRoleService {
	public final static String SPRINT_ID = "UserAndRoleService";

	/**
	 * 用户关联角色查询列表
	 * 
	 * @param userId
	 * @return List
	 */
	public List queryUserAndRoles(String userId);
	public List queryMoreUserAndRoles(String userIds,String userNames);
	/**
	 * 用户删除 时，删除用户和角色关联表内用户对应的角色信息
	 * 
	 * @param userId
	 */
	public void deleteRoleOfUser(String []userId);
	
	/**
	 * 更新用户角色信息
	 * 
	 * @param userId
	 * @param roleCodes
	 */
	public void updateRolesOfUser(String userId,List roleCodes);

	public void updateRolesOfMoreUser(List users,List roleCodes);
}
