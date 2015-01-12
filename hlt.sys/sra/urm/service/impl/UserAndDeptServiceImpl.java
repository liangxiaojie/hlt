package sra.urm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sra.urm.service.DeptService;
import sra.urm.service.UserAndDeptService;
import sra.urm.vo.Dept;
import sra.urm.vo.DeptUser;
import sra.urm.vo.Role;
import sra.urm.vo.User;
import sra.urm.vo.UserRole;

import com.cmbc.edw.bs.AbstractBizService;
import com.cmbc.edw.dao.IIntegratedDAO;
import com.cmbc.edw.model.Page;

/**
 * 用户和部门维护
 * 
 * @author xie_guanjie
 * @version 2013-8-05
 * 
 * */
public class UserAndDeptServiceImpl extends AbstractBizService implements
		UserAndDeptService {

	private IIntegratedDAO daoSupportTemplate;

	public void setDaoSupportTemplate(IIntegratedDAO daoSupportTemplate) {
		this.daoSupportTemplate = daoSupportTemplate;
	}

	/**
	 * 用户关联部门查询列表
	 * 
	 * @param userId
	 * @return List
	 */
	
	public List queryUserAndDepts(String userId) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		List listAll = new ArrayList();
		List list = new ArrayList();
		// 查询到此用户没有的部门
		listAll = daoSupportTemplate.getMybatisTemplate().query4list(
				"sra.urm.queryUserNoDepts", map);
		// 查询到此用户对应的部门
		list = daoSupportTemplate.getMybatisTemplate().query4list(
				"sra.urm.queryUserAndDepts", map);
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			Dept dept = (Dept) iterator.next();
			dept.setChecked(true);
			listAll.add(dept);
		}
		List buileTree = new ArrayList();
		Iterator iterator2 = listAll.iterator();
		while (iterator2.hasNext()) {
			Dept dept = (Dept) iterator2.next();
			if (dept.getDeptId().equals(dept.getParentDept())) {
				buileTree.add(bulidTree(dept, listAll));
			}
		}
		return buileTree;
	}

	private Dept bulidTree(Dept dept, List list) {
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			Dept deptChild = (Dept) iterator.next();
			if (deptChild.getParentDept().equals(dept.getDeptId())
					&& !dept.getDeptId().equals(deptChild.getDeptId())) {
				dept.getChildren().add(deptChild);
				bulidTree(deptChild, list);
			}
		}
		return dept;
	}

	/**
	 * 删除用户部门关联信息
	 * 
	 * @param userId
	 */
	
	public void deleteDeptOfUser(String deptId, String[] userIds) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("deptId", deptId);
		map.put("userIds", userIds);
		daoSupportTemplate.getMybatisTemplate().delete(
				"sra.urm.deleteUserOfDept", map);
	}

	/**
	 * 删除用户和用户部门关联信息
	 * 
	 * @param userId
	 */
	
	public void deleteDeptAndUser(String deptId, String[] userIds) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("deptId", deptId);
		map.put("userIds", userIds);
		daoSupportTemplate.getMybatisTemplate().delete("sra.urm.deleteUsers",
				map);
		daoSupportTemplate.getMybatisTemplate().delete(
				"sra.urm.deleteRoleOfUser", map);
		daoSupportTemplate.getMybatisTemplate().delete(
				"sra.urm.deleteUserOfDept", map);
	}

	/**
	 * 更新用户部门信息
	 * 
	 * @param userIds
	 * @param deptId
	 */
	
	public void updateDeptsOfUser(List userIds, String deptId) {
		Map map = new HashMap();
		map.put("userIds", userIds);
		// 删除此用户对应的所有部门信息
		daoSupportTemplate.getMybatisTemplate().delete(
				"sra.urm.deleteDeptOfUser", map);
		// 保存此用户选择的所有部门信息
		Iterator iterator = userIds.iterator();
		while (iterator.hasNext()) {
			// 获取部门编号
			String userId = (String) iterator.next();
			// 新建用户部门对象
			DeptUser deptUserVO = new DeptUser();
			// 根据部门编号获取部门对象
			DeptService deptService = new DeptServiceImpl();
			if (deptId != null && !"".equals(deptId) && !"部门编号".equals(deptId)) {
				deptUserVO.setUserId(userId);
				deptUserVO.setDeptId(deptId);
				deptUserVO.setIsManager("N");
				daoSupportTemplate.getMybatisTemplate().insert(
						"sra.urm.insertDeptUser", deptUserVO);
			}
		}
	}

	/**
	 * 判断用户是否已经属于部门并添加用户到 指定部门
	 */
	public String addDeptsOfUser(String deptId, List userIds, String status) {
		String str = "";
		Iterator iterator = userIds.iterator();
		Map map = new HashMap();
		map.put("userIds", userIds);
		if (!status.equals("Y")) {
			// 获取部门编号
			List list = (List) daoSupportTemplate.getMybatisTemplate()
					.query4list("sra.urm.queryDeptIdByUserIds", map);
			if (list.size() > 0) {
				str = "Y";
			}
		}
		if (str.equals("")) {
			daoSupportTemplate.getMybatisTemplate().insert(
					"sra.urm.deleteDeptOfUser", map);
			while (iterator.hasNext()) {
				String userId = (String) iterator.next();
				map.put("userId", userId);
				if (deptId != null && !"".equals(deptId)) {
					map.put("deptId", deptId);
					map.put("isManager", "N");
					daoSupportTemplate.getMybatisTemplate().insert(
							"sra.urm.insertDeptUser", map);
				}
			}
			str = "N";
		}
		return str;
	}

	/**
	 * 新增用户和部门关系信息
	 * 
	 * @param userIds
	 * @param deptId
	 */
	
	public void addDeptsAndUser(Map<String, String> map) {
		String userId = map.get("userId");
		String deptId = map.get("deptId");
		User user = new User();
		user.setUserId(userId);
		user.setUserName(map.get("userName"));
		user.setUserOrg(map.get("userOrg"));
		user.setUserPwd("123456");
		user.setTel(map.get("tel"));
		// 新建用户部门对象
		DeptUser deptUserVO = new DeptUser();
		// 根据部门编号获取部门对象
		if (deptId != null && !"".equals(deptId) && userId != null
				&& !"".equals(userId)) {
			deptUserVO.setUserId(userId);
			deptUserVO.setDeptId(deptId);
			deptUserVO.setIsManager("N");
			daoSupportTemplate.getMybatisTemplate().insert("sra.urm.addUser",
					user);
			daoSupportTemplate.getMybatisTemplate().insert(
					"sra.urm.insertDeptUser", deptUserVO);
		}
	}

	/**
	 * 查询当前用户对应的部门的下级部门（不包含本部门）
	 * 
	 * @param deptId
	 *            部门编号
	 * @param userId
	 *            用户编号
	 * @return list
	 */
	
	public List<Dept> queryUnderDepts(String deptId, String userId) {
		// 此部门的子部门
		List listDepts = new ArrayList();
		// 此用户对应的所有部门
		List list = new ArrayList();
		// 对此用户对应部门的子部门处理后的结果
		List listSelectDepts = new ArrayList();
		if (deptId != null && !"".equals(deptId)) {
			Dept deptVO = (Dept) daoSupportTemplate.getMybatisTemplate().get(
					"sra.urm.getDept", deptId);
			Map map = new HashMap();
			map.put("parentDept", deptVO.getParentDept());
			listDepts = daoSupportTemplate.getMybatisTemplate().query4list(
					"sra.urm.queryDepts", map);
			list = daoSupportTemplate.getMybatisTemplate().query4list(
					"sra.urm.queryUserAndDepts", map);
			Iterator iterator = listDepts.iterator();
			Iterator iteratorAll = list.iterator();
			// 遍历子部门，如在此用户下增加select字段
			while (iterator.hasNext()) {
				Map<String, String> map1 = new HashMap<String, String>();
				map1 = (Map<String, String>) iterator.next();
				while (iteratorAll.hasNext()) {
					Map<String, String> map2 = new HashMap<String, String>();
					map2 = (Map<String, String>) iteratorAll.next();
					if (!map2.isEmpty() && !map1.isEmpty()
							&& map1.get("deptId").equals(map2.get("deptId"))) {
						map1.put("checked", "true");
						break;
					}
				}
				listSelectDepts.add(map1);
			}
		}
		return listSelectDepts;
	}
	/**
	 *查询当前用户所在部门
	 * 
	 * @param userId
	 *            用户编号
	 * @param deptid
	 *           查询部门id
	 * @return str
	 */
	
	public String queryDeptsl(List userIds) {
		String str = "";
		Map map = new HashMap();
		map.put("userIds", userIds);
		List list = daoSupportTemplate.getMybatisTemplate().query4list(
				"sra.urm.queryDeptsl", map);
		if (list.size() > 0) {
			str = "Y";
		}
		return str;
		// 此部门的子部门
	}

	/**
	 *查询当前用户所在部门
	 * 
	 * @param userId
	 *            用户编号
	 * @param isManager
	 *            是否部门管理员
	 * @return list
	 */
	
	public List<Dept> queryUserDepts(String userId, String isManager) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("isManager", isManager);
		List list = daoSupportTemplate.getMybatisTemplate().query4list(
				"sra.urm.queryUserDepts", map);
		return list;
	}

	/**
	 * 用户查询列表
	 * 
	 * @param map
	 * @param pageNo
	 * @param pageSize
	 * @return page
	 */
	
	public Page queryUsersOfDept(Map<String, String> map, int pageNo,
			int pageSize) {
		return daoSupportTemplate.getMybatisTemplate().query4Page(
				"sra.urm.queryDeptOfUsers", "sra.urm.queryDeptOfUsers4Count",
				map, pageNo, pageSize);
	}

	/**
	 * 查询当前用户下可选择的角色
	 * 
	 * @param userId
	 * 
	 */
	
	public List<Role> queryUserRoles(String userId) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		return daoSupportTemplate.getMybatisTemplate().query4list(
				"sra.urm.queryUserRoles", map);
	}

	/**
	 * 部门管理员维护部门用户的角色
	 * 
	 * @param userId
	 * @param roleCodes
	 */
	
	public void updateDeptUserRoles(String userId, List roleCodes) {
		Map map = new HashMap();
		map.put("userId", userId);
		map.put("roleCodes", roleCodes.toArray());
		daoSupportTemplate.getMybatisTemplate().delete(
				"sra.urm.deleteRolesOfUser", map);
		Iterator iterator = roleCodes.iterator();
		while (iterator.hasNext()) {
			UserRole userRoleVO = new UserRole();
			userRoleVO.setUserId(userId);
			userRoleVO.setRoleCode(iterator.next().toString());
			daoSupportTemplate.getMybatisTemplate().insert(
					"sra.urm.addRoleOfUser", userRoleVO);
		}
	}
	// public List queryAllUserAndDepts(String[] userIds) {
	// String userId;
	// for (int i = 0; i < userIds.length; i++) {
	// userId = userIds[i];
	// }
	// return null;
	// }
	//	

}
