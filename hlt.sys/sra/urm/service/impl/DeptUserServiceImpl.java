package sra.urm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sra.urm.service.DeptUserService;
import sra.urm.vo.DeptUser;
import sra.urm.vo.User;

import com.cmbc.edw.bs.AbstractBizService;
import com.cmbc.edw.dao.IIntegratedDAO;
import com.cmbc.edw.model.Page;
    /**
     * 自动生成  
     * 
     **/
    public class DeptUserServiceImpl extends AbstractBizService implements DeptUserService {


    private IIntegratedDAO daoSupportTemplate;
    public void setDaoSupportTemplate(IIntegratedDAO daoSupportTemplate) {
        this.daoSupportTemplate = daoSupportTemplate;
	  }


    /**
     * 查询列表  
     * 
     * @param map
     * @param pageNo
     * @param pageSize
     * @return page
     **/
    public  Page queryDeptUsers(Map<String, String> map, int pageNo, int pageSize){
	      return daoSupportTemplate.getMybatisTemplate().query4Page("sra.urm.queryDeptUsers",
	      		"sra.urm.queryDeptUserTotal",map, pageNo, pageSize);
    }


    /**
     * 新增  
     * 
     **/
    public void addDeptUser(DeptUser deptUser){
	      daoSupportTemplate.getMybatisTemplate().insert("sra.urm.insertDeptUser", deptUser);
    }


    /**
     * 修改  
     * 
     **/
    public void updateDeptUser(DeptUser deptUser){
	      daoSupportTemplate.getMybatisTemplate().update("sra.urm.updateDeptUser", deptUser);
    }


    /**
     * 删除 
     * 
     **/
    public void deleteDeptUser(String[] deptUserIds){
        Map<String, String[]> map = new HashMap<String, String[]>();
        map.put("deptUserIds", deptUserIds);
        daoSupportTemplate.getMybatisTemplate().delete("sra.urm.deleteDeptUsers", map);
    }


    /**
     * load单条数据 
     * 
     **/
    public  DeptUser loadDeptUser(String deptUserId){
	      return (DeptUser)daoSupportTemplate.getMybatisTemplate().get("sra.urm.loadDeptUser", deptUserId);
    }
    
    
    /**
     * 通过所选体系代码setCode和当前用户代码userId 确定当前部门
     * @param deptUser
     * @return
     */
    public List<Map> queryDeptIdBySetCodeAndUserId(Map map){
    	List list =  daoSupportTemplate.getMybatisTemplate().query4list("sra.urm.queryDeptIdBySetCodeAndUserId", map);
    	return list;
    }
    
    /**
     * 获取部门下的所有员工
     * @param deptIds
     * @param setCode
     * @param userRole
     * @return
     */
    public List<User> queryUsersByDepts(String[] deptIds,String setCode,String userRole){
    	if(deptIds.length==0){
    		return null;
    	}else{
	    	Map<String, Object> map = new HashMap<String, Object>();
	        map.put("deptIds", deptIds);
	        map.put("setCode", setCode);
	        map.put("userRole", userRole);
	    	List list =  daoSupportTemplate.getMybatisTemplate().query4list("sra.urm.queryUsersByDepts", map);
	    	return list;
    	}
    }
    /**
     * 根据用户ID查询部门ID
     * @param userId
     * @return
     */
	public List getdeptId(String userId) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("userId", userId);
		List list = new ArrayList();
		list = (List) daoSupportTemplate.getMybatisTemplate().query4list("sra.urm.getdeptId", map);
		return list;
	}
}