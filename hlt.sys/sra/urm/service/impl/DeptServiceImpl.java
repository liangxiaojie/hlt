package sra.urm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import sra.urm.service.DeptService;
import sra.urm.vo.Dept;
import sra.urm.vo.User;

import com.cmbc.edw.bs.AbstractBizService;
import com.cmbc.edw.dao.IIntegratedDAO;

public class DeptServiceImpl extends AbstractBizService implements DeptService {

	private IIntegratedDAO daoSupportTemplate;

	public void setDaoSupportTemplate(IIntegratedDAO daoSupportTemplate) {
		this.daoSupportTemplate = daoSupportTemplate;
	}
	

	public List<Dept> queryDepts(Map<String, String> map) {
		if(map.get("deptName")!=null&&!"".equals(map.get("deptName"))){
			map.put("deptName", "%"+map.get("deptName")+"%");
		}
		List<Dept> list = daoSupportTemplate.getMybatisTemplate().query4list("sra.urm.queryDepts", map);
		Iterator iterator = list.iterator();
		List<Dept> buileTree = new ArrayList<Dept>();
		if(map.isEmpty()){
			while(iterator.hasNext()){
				Dept dept = (Dept)iterator.next();
				if(dept.getDeptId().equals(dept.getParentDept())||"root".equals(dept.getParentDept()))
				buileTree.add(bulidTree(dept, list));
			}
		}else{
			buileTree=list;
		}
		return buileTree;
	}

	private Dept bulidTree(Dept dept,List list) {
		Iterator iterator = list.iterator();
			while(iterator.hasNext()){
				Dept deptChild = (Dept)iterator.next();
			if (deptChild.getParentDept().equals(dept.getDeptId())&&!dept.getDeptId().equals(deptChild.getDeptId())) {
				dept.getChildren().add(deptChild);
				bulidTree(deptChild,list);
			}
		}
		return dept;
	}
	

	public List getDeptTree() {
		List list = daoSupportTemplate.getMybatisTemplate().query4list("sra.urm.queryDepts");
		Iterator iterator = list.iterator();
		List<Dept> buileTree = new ArrayList<Dept>();
		while(iterator.hasNext()){
			Dept dept = (Dept)iterator.next();
			if(dept.getDeptId().equals(dept.getParentDept())||"root".equals(dept.getParentDept()))
			buileTree.add(bulidTree(dept, list));
		}
		return buileTree;
	}


	public void addDept(Dept dept) {
		daoSupportTemplate.getMybatisTemplate().insert("sra.urm.insertDept", dept);
	}

	
	public void updateDept(Dept dept) {
		daoSupportTemplate.getMybatisTemplate().update("sra.urm.updateDept", dept);
		
	}


	public void deleteDept(String[] deptIds) {
		Map<String,String[]> map = new HashMap<String,String[]>();
		map.put("deptIds", deptIds);
		daoSupportTemplate.getMybatisTemplate().delete("sra.urm.deleteDepts", map);
	}


	public Dept loadDept(String deptId) {
		Dept dept = new Dept();
		dept.setDeptId(deptId);
		return (Dept)daoSupportTemplate.getMybatisTemplate().get("sra.urm.loadDept",dept );
	}

	
	public List<Dept> queryDepts4Combo() {
		return null;
	}

	
	public List LoadDeptNodes(String parentNodeId) {
		Map m = new HashMap();
		String key = "";
		if(parentNodeId == null ) 
			throw new RuntimeException("无父节点加载不允许");
		if(parentNodeId.equals("root")){
			key =  "onelevel";
		}else{
			key = "deptId";
		}
		m.put(key, parentNodeId);
		return daoSupportTemplate.getMybatisTemplate().query4list("sra.tree.deptuser.getDeptNode",m);
	}

	
	public List<User> queryDeptUsers(Map paraMap) {
		if(paraMap == null || paraMap.size()==0){
			return new ArrayList<User>();
		}
		return daoSupportTemplate.getMybatisTemplate().query4list("sra.tree.deptuser.querydeptusers",paraMap);
	}

	
}
