package sra.param.service.impl;

/**
 * 数据维度定义
 */
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sra.param.service.DimeDefService;
import sra.param.vo.DimeDef;
import com.cmbc.edw.bs.AbstractBizService;
import com.cmbc.edw.dao.IIntegratedDAO;
import com.cmbc.edw.model.Page;
    /**
     * 自动生成  
     * 
     **/
    public class DimeDefServiceImpl extends AbstractBizService implements DimeDefService {


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
    public  Page queryDimeDefs(Map<String, String> map, int pageNo, int pageSize){
	      return daoSupportTemplate.getMybatisTemplate().query4Page("sra.param.queryDimeDefs",
	      		"sra.param.queryDimeDefTotal",map, pageNo, pageSize);
    }


    /**
     * 新增  
     * 
     **/
    public void addDimeDef(DimeDef dimeDef){
	      daoSupportTemplate.getMybatisTemplate().insert("sra.param.insertDimeDef", dimeDef);
    }


    /**
     * 修改  
     * 
     **/
    public void updateDimeDef(DimeDef dimeDef){
	      daoSupportTemplate.getMybatisTemplate().update("sra.param.updateDimeDef", dimeDef);
    }


    /**
     * 删除 
     * 
     **/
    public void deleteDimeDef(String[] dimeDefIds){
        Map<String, String[]> map = new HashMap<String, String[]>();
        map.put("dimeDefIds", dimeDefIds);
        daoSupportTemplate.getMybatisTemplate().delete("sra.param.deleteDimeDefs", map);
    }


    /**
     * load单条数据 
     * 
     **/
    public  DimeDef loadDimeDef(String dimeDefId){
	      return (DimeDef)daoSupportTemplate.getMybatisTemplate().get("sra.param.loadDimeDef", dimeDefId);
    }
    
    
	/**
     * 查询值定义集合 
     * 
     **/
	public List queryDimeList() {
    	return (List)daoSupportTemplate.getMybatisTemplate().query4list("sra.param.queryDimeDefs");
	}
}