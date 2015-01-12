package sra.param.service.impl;

import java.util.HashMap;
import java.util.Map;

import sra.param.service.CmbcOrgService;
import sra.param.vo.CmbcOrg;

import com.cmbc.edw.bs.AbstractBizService;
import com.cmbc.edw.dao.IIntegratedDAO;
import com.cmbc.edw.model.Page;
    /**
     * 自动生成  
     * 
     **/
    public class CmbcOrgServiceImpl extends AbstractBizService implements CmbcOrgService {


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
    public  Page queryCmbcOrgs(Map<String, String> map, int pageNo, int pageSize){
	      return daoSupportTemplate.getMybatisTemplate().query4Page("sra.param.queryCmbcOrgs",
	      		"sra.param.queryCmbcOrgTotal",map, pageNo, pageSize);
    }


    /**
     * 新增  
     * 
     **/
    public void addCmbcOrg(CmbcOrg cmbcOrg){
	      daoSupportTemplate.getMybatisTemplate().insert("sra.param.insertCmbcOrg", cmbcOrg);
    }


    /**
     * 修改  
     * 
     **/
    public void updateCmbcOrg(CmbcOrg cmbcOrg){
	      daoSupportTemplate.getMybatisTemplate().update("sra.param.updateCmbcOrg", cmbcOrg);
    }


    /**
     * 删除 
     * 
     **/
    public void deleteCmbcOrg(String[] cmbcOrgIds){
        Map<String, String[]> map = new HashMap<String, String[]>();
        map.put("cmbcOrgIds", cmbcOrgIds);
        daoSupportTemplate.getMybatisTemplate().delete("sra.param.deleteCmbcOrgs", map);
    }


    /**
     * load单条数据 
     * 
     **/
    public  CmbcOrg loadCmbcOrg(String cmbcOrgId){
	      return (CmbcOrg)daoSupportTemplate.getMybatisTemplate().get("sra.param.loadCmbcOrg", cmbcOrgId);
    }
}