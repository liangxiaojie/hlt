package sra.urm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sra.urm.service.RoleService;
import sra.urm.vo.Role;

import com.cmbc.edw.bs.AbstractBizService;
import com.cmbc.edw.dao.IIntegratedDAO;
import com.cmbc.edw.model.Page;

public class RoleServiceImpl extends AbstractBizService implements RoleService {
	
	private IIntegratedDAO daoSupportTemplate;

	public void setDaoSupportTemplate(IIntegratedDAO daoSupportTemplate) {
		this.daoSupportTemplate = daoSupportTemplate;
	}
	/**
	 * 角色查询列表
	 * 
	 * @param map
	 * @param pageNo
	 * @param pageSize
	 * @return page
	 */
	
	public Page queryRoles(Map<String, String> map, int pageNo, int pageSize) {
		if(map.get("roleName")!=null&&!"".equals(map.get("roleName"))){
			map.put("roleName", "%"+map.get("roleName")+"%");
		}
		if(map.get("roleDesc")!=null&&!"".equals(map.get("roleDesc"))){
			map.put("roleDesc", "%"+map.get("roleDesc")+"%");
		}
		return daoSupportTemplate.getMybatisTemplate().query4Page("sra.urm.queryRoles",
				"sra.urm.queryRoles4Count", map, pageNo, pageSize);
	}

	/**
	 * 角色新增
	 * 
	 * @param role
	 */
	
	public void addRole(Role role) {
		daoSupportTemplate.getMybatisTemplate().insert("sra.urm.addRole", role);
	}

	/**
	 * 角色修改
	 * 
	 * @param role
	 */
	
	public void updateRole(Role role) {
		daoSupportTemplate.update("sra.urm.updateRole", role);
	}

	/**
	 * 角色删除
	 * 
	 * @param roleCodes
	 * @return
	 */
	
	public void deleteRole(String[] roleCodes) {
		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("roleCodes", roleCodes);
		daoSupportTemplate.getMybatisTemplate().delete("sra.urm.deleteRoles", map);
		daoSupportTemplate.getMybatisTemplate().delete("sra.urm.deleteMenuOfRole", map);
	}

	/**
	 * 查询单个角色
	 * 
	 * @param roleCode
	 * @return role
	 */
	
	public Role loadRole(String roleCode) {
		return (Role) daoSupportTemplate.getMybatisTemplate().get("sra.urm.getRole", roleCode);
	}

	/**
     * 查询多个角色
     * 
     * @param
     * @return List
     * 
     */
	
	public List<Role> queryRoles4Combo() {
		return daoSupportTemplate.getMybatisTemplate().query4list("sra.urm.queryRoles");
	}
	
	/**
	 * 查询用户对应的角色
	 * 
	 * @param userId
	 * @return list
	 * 
	 * */
	
	public List<Role> loadRoleOfUser(String userId) {
		Map<String,String> map = new HashMap<String, String>();
		map.put("userId", userId);
		return daoSupportTemplate.getMybatisTemplate().query4list("sra.urm.queryUserAndRoles", map);
	}

}
