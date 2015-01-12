package sra.param.service;
import java.util.Map;

import sra.param.vo.CmbcOrg;

import com.cmbc.edw.model.Page;


public interface CmbcOrgService{
    public final static String SPRINT_ID = "CmbcOrgService";
    /**
     * 查询列表  
     * 
     * @param map
     * @param pageNo
     * @param pageSize
     * @return page
     **/
    public  Page queryCmbcOrgs(Map<String, String> map, int pageNo, int pageSize);


    /**
     * 新增  
     * 
     **/
    public void addCmbcOrg(CmbcOrg cmbcOrg);


    /**
     * 修改  
     * 
     **/
    public void updateCmbcOrg(CmbcOrg cmbcOrg);


    /**
     * 删除 
     * 
     **/
    public void deleteCmbcOrg(String[] cmbcOrgIds);


    /**
     * load单条数据 
     * 
     **/
    public CmbcOrg loadCmbcOrg(String cmbcOrgId);
}		