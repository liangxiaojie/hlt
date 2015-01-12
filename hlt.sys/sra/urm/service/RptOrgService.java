package sra.urm.service;

import java.util.List;
import java.util.Map;

import sra.urm.vo.RptOrg;

import com.cmbc.edw.model.Page;

/**
 * 机构管理
 * @author zhaoshuli
 *
 */
public interface RptOrgService {
	
	public final static String SPRINT_ID = "RptOrgService";

	/**
	 * 机构查询列表
	 * 
	 * @param map
	 * @param pageNo
	 * @param pageSize
	 * @return page
	 */
	public List<RptOrg> queryRptOrgs(Map<String, String> map);
	
	/**
	 * 机构树列表
	 * @return
	 */
	public List getRptOrgTree();
	
	
	
	/**
	 * 机构新增
	 * 
	 * @param rptOrg
	 */
	public void addRptOrg(RptOrg rptOrg);

	/**
	 * 机构修改
	 * 
	 * @param rptOrg
	 */
	public void updateRptOrg(RptOrg rptOrg);

	/**
	 * 机构删除
	 * 
	 * @param rptOrgCodes
	 */
	public void deleteRptOrg(String[] rptOrgCodes);

	/**
	 * 查询单个机构
	 * 
	 * @param rptOrgCode
	 * @return
	 */
	public RptOrg loadRptOrg(String rptOrgCode);

	/**
     * 查询多个机构
     * 
     * @param
     * @return List
     * 
     */
	public List<RptOrg> queryRptOrgs4Combo();
 
}
