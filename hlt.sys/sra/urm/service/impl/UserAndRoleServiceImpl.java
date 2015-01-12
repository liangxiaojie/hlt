package sra.urm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import sra.urm.service.UserAndRoleService;
import sra.urm.vo.UserRole;

import com.cmbc.edw.bs.AbstractBizService;
import com.cmbc.edw.dao.IIntegratedDAO;

/**
 * 
 * 用户和角色关系
 * 
 * @author xie_guanjie
 * 
 * @version 2013-4-24
 * 
 * */
public class UserAndRoleServiceImpl extends AbstractBizService implements
		UserAndRoleService {

	private IIntegratedDAO daoSupportTemplate;

	public void setDaoSupportTemplate(IIntegratedDAO daoSupportTemplate) {
		this.daoSupportTemplate = daoSupportTemplate;
	}

	/**
	 * 用户关联角色查询列表
	 * 
	 * @param userId
	 * @return List
	 */
	
	public List queryUserAndRoles(String userId) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		List<Map<String, String>> listAll = new ArrayList<Map<String, String>>();
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		// 查询到此用户没有的角色
		listAll = daoSupportTemplate.getMybatisTemplate().query4list("sra.urm.queryUserNoRoles", map);
		// 查询到此用户对应的角色
		list = daoSupportTemplate.getMybatisTemplate().query4list("sra.urm.queryUserAndRoles", map);
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			Map<String,String> mapL = new HashMap<String,String>();
			mapL = (Map<String, String>) iterator.next();
			mapL.put("select", "true");
			listAll.add(mapL);
		}
		return listAll;
	}

	
	public List queryMoreUserAndRoles(String userIds,String userNames) {
		List<Map> list = new ArrayList<Map>();
		String[] users = userIds.substring(1).split("[,]+");
		String[] names = userNames.substring(1).split("[,]+");
		// 查询全部角色
		List<Map> allRoles = daoSupportTemplate.getMybatisTemplate().query4list("sra.urm.queryAllRoles");
		Map map = new HashMap();
		int num = 0;
		for(int i=0;i<users.length;i++){
			String userId = users[i];
			String userName = names[i];
			map.put("userId", userId);
			// 用户擁有的角色
			List<Map> myRoles = daoSupportTemplate.getMybatisTemplate().query4list("sra.urm.queryUserAndRoles", map);
			Map getObj = null;
			for (Map mapObj:allRoles) {
				getObj = mapObj;
				String code_obj = (String) mapObj.get("roleCode");
				String bp = "false";
				for (Map mapUser:myRoles) {
					String code_User = (String) mapUser.get("roleCode");
					if(code_obj.equals(code_User)){
						bp = "true";
						break;
					}
				}
				getObj = new HashMap();
				getObj.put("roleCode", code_obj);
				getObj.put("roleName",  (String) mapObj.get("roleName"));
				getObj.put("roleCat", (String) mapObj.get("roleCat"));
				getObj.put("roleDesc", (String) mapObj.get("roleDesc"));
				getObj.put("select", bp);
				getObj.put("userId",userId);
				getObj.put("userName",userId+"："+userName);
				getObj.put("num",String.valueOf(num++));
				list.add(getObj);
			}
		}
		return list;
	}
	/**
	 * 用户删除 时，删除用户和角色关联表内用户对应的角色信息
	 * 
	 * @param userId
	 */
	
	public void deleteRoleOfUser(String[] userId) {
		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("userIds", userId);
		daoSupportTemplate.getMybatisTemplate().delete("sra.urm.deleteRoleOfUser", map);
	}

	/**
	 * 更新用户角色信息
	 * 
	 * @param userId
	 * @param roleCodes
	 */
	
	public void updateRolesOfUser(String userId,List roleCodes) {
		Map<String, String[]> map = new HashMap<String, String[]>();
		String []userIds = {userId};
		map.put("userIds",userIds);
		// 删除此用户对应的所有角色信息
		daoSupportTemplate.getMybatisTemplate().delete("sra.urm.deleteRoleOfUser", map);
		// 保存此用户选择的所有角色信息
		Iterator iterator = roleCodes.iterator();
		while (iterator.hasNext()) {
			UserRole userRoleVO = new UserRole();
			userRoleVO.setUserId(userId);
			userRoleVO.setRoleCode(iterator.next().toString());
			daoSupportTemplate.getMybatisTemplate().insert("sra.urm.addRoleOfUser",userRoleVO);
		}
	}
	
	public void updateRolesOfMoreUser(List users,List roleCodes) {
		String []userIds = new String[users.size()];
		String []userRoles = new String[users.size()];
		for(int i=0;i<users.size();i++){
			String userId = (String) users.get(i);
			String sql = "insert into T_URM_USER_ROLE (ROLE_CODE,USER_ID) values ('"+roleCodes.get(i)+"','"+userId+"')";
			userRoles[i] = sql;
			userIds[i] = userId;
			System.out.println(users.get(i)+"-----你看看吧-----"+roleCodes.get(i));
		}
		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("userIds",userIds);
		// 删除此用户对应的所有角色信息
		daoSupportTemplate.getMybatisTemplate().delete("sra.urm.deleteRoleOfUser", map);
		// 保存此用户选择的所有角色信息
		daoSupportTemplate.batchUpdate(userRoles);
	}
}


