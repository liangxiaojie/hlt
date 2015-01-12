package sra.urm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import sra.urm.service.MenuService;
import sra.urm.service.RoleAndMenuService;
import sra.urm.vo.Menu;
import sra.urm.vo.RoleMenu;

import com.cmbc.edw.bs.AbstractBizService;
import com.cmbc.edw.dao.IIntegratedDAO;
/**
 * 角色和菜单维护
 * 
 * @author xie_guanjie
 * @version 2013-4-27
 * 
 * */
public class RoleAndMenuServiceImpl extends AbstractBizService implements
		RoleAndMenuService {

	private IIntegratedDAO daoSupportTemplate;

	public void setDaoSupportTemplate(IIntegratedDAO daoSupportTemplate) {
		this.daoSupportTemplate = daoSupportTemplate;
	}
	
	/**
	 * 角色关联菜单查询列表
	 * 
	 * @param roleCode
	 * @return List
	 */
	
	public List queryRoleAndMenus(String roleCode) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("roleCode", roleCode);
		List listAll = new ArrayList();
		List list = new ArrayList();
		// 查询到此角色没有的菜单
		listAll = daoSupportTemplate.getMybatisTemplate().query4list("sra.urm.queryRoleNoMenus", map);
		// 查询到此角色对应的菜单
		list = daoSupportTemplate.getMybatisTemplate().query4list("sra.urm.queryRoleAndMenus", map);
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			Menu menu = (Menu) iterator.next();
			menu.setChecked(true);
			listAll.add(menu);
		}
		List buileTree = new ArrayList();
		Iterator iterator2 = listAll.iterator();
		while (iterator2.hasNext()) {
			Menu menu = (Menu) iterator2.next();
			if(menu.getMenuCode().equals(menu.getParentCode())){
				buileTree.add(bulidTree(menu,listAll));
			}
		}
		return buileTree;
	}
	
	private Menu bulidTree(Menu menu, List list) {
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			Menu menuChild = (Menu) iterator.next();
			if (menuChild.getParentCode().equals(menu.getMenuCode())&&!menu.getMenuCode().equals(menuChild.getMenuCode())) {
				menu.getChildren().add(menuChild);
				bulidTree(menuChild, list);
			}
		}
		return menu;
	}
	/**
	 * 角色删除 时，删除角色和菜单关联表内角色对应的菜单信息
	 * 
	 * @param roleCode
	 */
	
	public void deleteMenuOfRole(String[] roleCode) {
		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("roleCodes", roleCode);
		daoSupportTemplate.getMybatisTemplate().delete("sra.urm.deleteMenuOfRole", map);
	}

	/**
	 * 更新角色菜单信息
	 * 
	 * @param roleCode
	 * @param menuCodes
	 */
	
	public void updateMenusOfRole(String roleCode, List menuCodes) {
		Map<String, String[]> map = new HashMap<String, String[]>();
		String []roleCodes = {roleCode};
		map.put("roleCodes",roleCodes);
		// 删除此角色对应的所有菜单信息
		daoSupportTemplate.getMybatisTemplate().delete("sra.urm.deleteMenuOfRole", map);
		// 保存此角色选择的所有菜单信息
		Iterator iterator = menuCodes.iterator();
		while (iterator.hasNext()) {
			//获取菜单编号
			String menuCode = (String)iterator.next();
			//新建角色菜单对象
			RoleMenu roleMenuVO = new RoleMenu();
			//根据菜单编号获取菜单对象
			MenuService menuService = new MenuServiceImpl();
				if(menuCode!=null&&!"".equals(menuCode)&&!"菜单编号".equals(menuCode)){
				roleMenuVO.setRoleCode(roleCode);
				roleMenuVO.setMenuCode(menuCode);
				daoSupportTemplate.getMybatisTemplate().insert("sra.urm.addMenuOfRole",roleMenuVO);
			}
		}

	}
	
	/**
	 * 查询当前角色对应的菜单的下级菜单（不包含本菜单）
	 * 
	 * @param menuCode
	 * 				菜单编号
	 * @param roleCode
	 * 				角色编号
	 * @return list
	 */
	
	public List<Menu> queryUnderMenus(String menuCode,String roleCode) {
		//此菜单的子菜单
		List listMenus = new ArrayList();
		//此角色对应的所有菜单
		List list = new ArrayList();
		//对此角色对应菜单的子菜单处理后的结果
		List listSelectMenus = new ArrayList();
		if(menuCode!=null&&!"".equals(menuCode)){
			Menu menuVO = (Menu) daoSupportTemplate.getMybatisTemplate().get("sra.urm.getMenu", menuCode);
			Map map = new HashMap();
			map.put("parentCode", menuVO.getParentCode());
			listMenus = daoSupportTemplate.getMybatisTemplate().query4list("sra.urm.queryMenus", map);
			list = daoSupportTemplate.getMybatisTemplate().query4list("sra.urm.queryRoleAndMenus", map);
			Iterator iterator = listMenus.iterator();
			Iterator iteratorAll = list.iterator();
			//遍历子菜单，如在此角色下增加select字段
			while (iterator.hasNext()) {
				Map<String,String> map1 = new HashMap<String, String>();
				map1 = (Map<String, String>)iterator.next();
				while(iteratorAll.hasNext()){
					Map<String,String> map2 = new HashMap<String, String>();
					map2 = (Map<String,String>)iteratorAll.next();
					if(!map2.isEmpty()&&!map1.isEmpty()&&map1.get("menuCode").equals(map2.get("menuCode"))){
						map1.put("checked", "true");
						break;
					}
				}
				listSelectMenus.add(map1);
			}
			
		}
		return listSelectMenus;
	}

}
