package sra.urm.service;

import java.util.List;

import sra.urm.vo.Menu;

/**
 * 角色关联菜单管理接口
 * @author xie_guanjie
 * 
 * @version 2013-4-26
 */
public interface RoleAndMenuService {
	public final static String SPRINT_ID = "RoleAndMenuService";

	/**
	 * 角色关联菜单查询列表
	 * 
	 * @param roleCode
	 * @return List
	 */
	public List queryRoleAndMenus(String roleCode);

	/**
	 * 角色删除 时，删除角色和菜单关联表内角色对应的菜单信息
	 * 
	 * @param roleCode
	 */
	public void deleteMenuOfRole(String []roleCode);
	
	/**
	 * 更新角色菜单信息
	 * 
	 * @param roleCode
	 * @param menuCodes
	 */
	public void updateMenusOfRole(String roleCode,List menuCodes);

	/**
	 * 查询当前菜单的下级菜单（不包含本菜单）
	 * 
	 * @param menuCode
	 * 				菜单编号
	 * @param roleCode
	 * 				角色编号
	 * @return list
	 */
	public List<Menu> queryUnderMenus(String menuCode,String roleCode);
}
