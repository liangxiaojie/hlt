package sra.urm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sra.urm.service.DeptManagerService;
import sra.urm.vo.DeptUser;
import com.cmbc.edw.bs.AbstractBizService;
import com.cmbc.edw.dao.IIntegratedDAO;
/**
 *  用户关联部门管理接口
 * @author xie_guanjie
 * 
 * @version 2013-5-23
 */
public class DeptManagerServiceImpl extends AbstractBizService implements
		DeptManagerService {

	private IIntegratedDAO daoSupportTemplate;

	public void setDaoSupportTemplate(IIntegratedDAO daoSupportTemplate) {
		this.daoSupportTemplate = daoSupportTemplate;
	}
	/**
	 * 部门关联部门管理员查询列表
	 * 
	 * @param deptId
	 * @return List
	 */

	public List queryDeptUsers(String deptId) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("deptId", deptId);
		List<Map<String, String>> listAll = new ArrayList<Map<String, String>>();
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		// 查询到此部门下没有的用户
		listAll = daoSupportTemplate.getMybatisTemplate().query4list("sra.urm.queryDeptNoUsers", map);
		// 查询到此部门拥有的用户
		list = daoSupportTemplate.getMybatisTemplate().query4list("sra.urm.queryDeptAndUsers", map);
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			Map<String,String> mapL = new HashMap<String,String>();
			mapL = (Map<String, String>) iterator.next();
			mapL.put("select", "true");
			listAll.add(mapL);
		}
		return listAll;
	}

	public List queryDeptNoUsers(String deptId){
		Map<String, String> map = new HashMap<String, String>();
		map.put("deptId", deptId);
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		// 查询到此部门下没有的用户
		list = daoSupportTemplate.getMybatisTemplate().query4list("sra.urm.queryDeptNoUsers", map);
		return list;
	}
	
	/**
	 * 部门删除 时，删除部门和部门管理员关联表内部门对应的管理员信息
	 * 
	 * @param deptId
	 */

	public void deleteDeptUsers(String[] deptId) {
		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("deptIds", deptId);
		daoSupportTemplate.getMybatisTemplate().delete("sra.urm.deleteDeptUsers", map);
	}

	/**
	 * 更新用户部门信息
	 * 
	 * @param deptId
	 * @param userIds
	 */

	public void updateDeptUsers(String deptId, List userIds) {
//		Map<String, String[]> map = new HashMap<String, String[]>();
//		String []deptIds = {deptId};
//		map.put("deptIds",deptIds);
		// 删除此部门下关联的所有管理员数据
//		daoSupportTemplate.getMybatisTemplate().delete("sra.urm.deleteDeptUsers", map);
		Map map = new HashMap();
		map.put("deptId", deptId);
		//将此部门下面所有管理员清空
		daoSupportTemplate.getMybatisTemplate().update("sra.urm.updateAllInN", map);
		// 保存此部门对应的管理员数据---前台选中的人员
		Iterator iterator = userIds.iterator();
		while (iterator.hasNext()) {
			String userId = iterator.next().toString();
			map.put("userId", userId);
//			DeptUser user = new DeptUser();
//			user.setDeptId(deptId);
//			user.setUserId(iterator.next().toString());
//			user.setIsManager("Y");
			daoSupportTemplate.getMybatisTemplate().insert("sra.urm.updateAllInY",map);
		}
	}
	/**
	 * 查询所选部门下的 人员
	 * @param deptId
	 * @return
	 */
	public List queryDeptUsersByDeptId(String deptId) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("deptId", deptId);
		//所有人员的集合
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		//已经选定的人员
		List<Map<String, String>> listChecnked = new ArrayList<Map<String, String>>();
		// 查询到此部门拥有的用户
		list = daoSupportTemplate.getMybatisTemplate().query4list("sra.urm.queryDeptUsersByDeptId", map);
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			Map<String,String> mapL = new HashMap<String,String>();
			mapL = (Map<String, String>) iterator.next();
			String isManager = mapL.get("isManager");
			if("Y".equals(isManager)){
				mapL.put("select", "true");
			}
			listChecnked.add(mapL);
		}
		return listChecnked;
	}
}
