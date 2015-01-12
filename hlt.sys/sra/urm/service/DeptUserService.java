package sra.urm.service;
import java.util.List;
import java.util.Map;

import sra.urm.vo.DeptUser;
import sra.urm.vo.User;

import com.cmbc.edw.model.Page;


public interface DeptUserService{
    public final static String SPRINT_ID = "DeptUserService";
    /**
     * 查询列表  
     * 
     * @param map
     * @param pageNo
     * @param pageSize
     * @return page
     **/
    public  Page queryDeptUsers(Map<String, String> map, int pageNo, int pageSize);


    /**
     * 新增  
     * 
     **/
    public void addDeptUser(DeptUser deptUser);


    /**
     * 修改  
     * 
     **/
    public void updateDeptUser(DeptUser deptUser);


    /**
     * 删除 
     * 
     **/
    public void deleteDeptUser(String[] deptUserIds);


    /**
     * load单条数据 
     * 
     **/
    public DeptUser loadDeptUser(String deptUserId);
    
    /**
     * 通过所选体系代码setCode和当前用户代码userId 确定当前部门
     * @param deptUser
     * @return
     */
    public List<Map> queryDeptIdBySetCodeAndUserId(Map map);
    
    /**
     * 获取部门下的所有员工
     * @param deptIds
     * @param setCode
     * @param userRole
     * @return
     */
    public List<User> queryUsersByDepts(String[] deptIds,String setCode,String userRole);
    
    /**
     * 根据用户ID查询部门ID
     * @param userId
     * @return
     */
    public List getdeptId(String userId);
}		