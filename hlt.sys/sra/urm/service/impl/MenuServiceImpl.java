package sra.urm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import sra.urm.service.MenuService;
import sra.urm.vo.Menu;
import sra.urm.vo.MenuBase;

import com.cmbc.edw.bs.AbstractBizService;
import com.cmbc.edw.dao.IIntegratedDAO;
import com.cmbc.edw.model.Page;
/**
 *菜单管理数据交互
 *@author xie_guanjie
 *@version 2013-4-23 
 *
 */
public class MenuServiceImpl extends AbstractBizService implements MenuService {
	private IIntegratedDAO daoSupportTemplate;

	public void setDaoSupportTemplate(IIntegratedDAO daoSupportTemplate) {
		this.daoSupportTemplate = daoSupportTemplate;
	}
	/**
	 * 菜单查询列表
	 * 
	 * @param map
	 * @param pageNo
	 * @param pageSize
	 * @return page
	 */
	public Page queryMenus(Map<String, String> map, int pageNo, int pageSize) {
		if(map.get("menuName")!=null&&!"".equals(map.get("menuName"))){
			map.put("menuName", "%"+map.get("menuName")+"%");
		}
		if(map.get("menuDesc")!=null&&!"".equals(map.get("menuDesc"))){
			 map.put("menuDesc", "%"+map.get("menuDesc")+"%");
		}
		return daoSupportTemplate.getMybatisTemplate().query4Page("sra.urm.queryMenus",
				"sra.urm.queryMenus4Count", map, pageNo, pageSize);
	}

	/**
	 * 菜单新增
	 * 
	 * @param menu
	 */
	
	public void addMenu(Menu menu) {
		if("root".equals(menu.getParentCode())||"1".equals(menu.getParentCode())){
			menu.setParentCode(menu.getMenuCode());
		}
		daoSupportTemplate.getMybatisTemplate().insert("sra.urm.addMenu", menu);
	}

	/**
	 * 菜单修改
	 * 
	 * @param menu
	 */
	
	public void updateMenu(Menu menu) {
		if("root".equals(menu.getParentCode())||"1".equals(menu.getParentCode())){
			menu.setParentCode(menu.getMenuCode());
		}
		daoSupportTemplate.update("sra.urm.updateMenu", menu);
	}

	/**
	 * 菜单删除
	 * 
	 * @param menuCodes
	 */
	
	public void deleteMenu(String[] menuCodes) {
		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("menuCodes", menuCodes);
		daoSupportTemplate.getMybatisTemplate().delete("sra.urm.deleteMenus", map);
	}

	/**
	 * 查询单个菜单
	 * 
	 * @param menuCode
	 * @return
	 */
	
	public Menu loadMenu(String menuCode) {
		return (Menu) daoSupportTemplate.getMybatisTemplate().get("sra.urm.getMenu", menuCode);
	}

	/**
     * 查询多个菜单
     * 
     * @param
     * @return List
     * 
     */
	
	public List<Menu> queryMenus4Combo() {
		List allMenus = new ArrayList();
		List buileTree = new ArrayList();
		allMenus = daoSupportTemplate.getMybatisTemplate().query4list("sra.urm.queryMenus");
		Iterator iterator = allMenus.iterator();
		while (iterator.hasNext()) {
			Menu menu = (Menu) iterator.next();
			if(menu.getMenuCode().equals(menu.getParentCode())){
				buileTree.add(bulidTree(menu,allMenus));
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
     * 查询多个菜单
     * 
     * @param
     * @return List
     * 
     */
	
	public List<MenuBase> queryMenuBases4Combo() {
		List allMenus = new ArrayList();
		List buileTree = new ArrayList();
		allMenus = daoSupportTemplate.getMybatisTemplate().query4list("sra.urm.queryMenuBases");
		Iterator iterator = allMenus.iterator();
		while (iterator.hasNext()) {
			MenuBase menu = (MenuBase) iterator.next();
			if(menu.getMenuCode().equals(menu.getParentCode())){
				buileTree.add(bulidTree(menu,allMenus));
			}
		}
		return buileTree;
	}
	private MenuBase bulidTree(MenuBase menu, List list) {
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			MenuBase menuChild = (MenuBase) iterator.next();
			if (menuChild.getParentCode().equals(menu.getMenuCode())&&!menu.getMenuCode().equals(menuChild.getMenuCode())) {
				menu.getChildren().add(menuChild);
				bulidTree(menuChild, list);
			}
		}
		return menu;
	}
}
