package sra.urm.service;

import java.util.List;
import java.util.Map;

import sra.urm.vo.Dept;
import sra.urm.vo.User;

/**
 * 部门管理
 * 
 * @author xie_guanjie
 * 
 */
public interface DeptService {

  public final static String SPRINT_ID = "DeptService";

  /**
   * 部门查询列表
   * 
   * @param map
   * @param pageNo
   * @param pageSize
   * @return page
   */
  public List<Dept> queryDepts(Map<String, String> map);

  /**
   * 部门树列表
   * 
   * @return
   */
  public List getDeptTree();

  public List LoadDeptNodes(String parentNodeId);

  public List<User> queryDeptUsers(Map paraMap);

  /**
   * 部门新增
   * 
   * @param dept
   */
  public void addDept(Dept dept);

  /**
   * 部门修改
   * 
   * @param dept
   */
  public void updateDept(Dept dept);

  /**
   * 部门删除
   * 
   * @param deptIds
   */
  public void deleteDept(String[] deptIds);

  /**
   * 查询单个部门
   * 
   * @param deptId
   * @return
   */
  public Dept loadDept(String deptId);

  /**
   * 查询多个部门
   * 
   * @param
   * @return List
   * 
   */
  public List<Dept> queryDepts4Combo();

}
