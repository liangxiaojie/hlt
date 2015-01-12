package sra.urm.service;

import java.util.List;
import java.util.Map;

import com.cmbc.edw.model.Page;
import sra.urm.vo.Menu;
import sra.urm.vo.MenuBase;

/**
 * @author 菜单管理接口
 * 
 * @version 2013-4-22
 */
public interface MenuService {
	public final static String SPRINT_ID = "MenuService";

	/**
	 * 菜单查询列表
	 * 
	 * @param map
	 * @param pageNo
	 * @param pageSize
	 * @return page
	 */
	public Page queryMenus(Map<String, String> map, int pageNo, int pageSize);

	/**
	 * 菜单新增
	 * 
	 * @param menu
	 */
	public void addMenu(Menu menu);

	/**
	 * 菜单修改
	 * 
	 * @param menu
	 */
	public void updateMenu(Menu menu);

	/**
	 * 菜单删除
	 * 
	 * @param menuCodes
	 */
	public void deleteMenu(String[] menuCodes);

	/**
	 * 查询单个菜单
	 * 
	 * @param menuCode
	 * @return
	 */
	public Menu loadMenu(String menuCode);

	/**
     * 查询多个菜单
     * 
     * @param
     * @return List
     * 
     */
	public List<Menu> queryMenus4Combo();

	/**
     * 查询多个菜单
     * 
     * @param
     * @return List
     * 
     */
	List<MenuBase> queryMenuBases4Combo();
 
}
