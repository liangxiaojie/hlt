package sra.param.service.impl;

/**
 * 数据值定义
 */
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sra.param.service.ValueDefService;
import sra.param.vo.ValueDef;
import com.cmbc.edw.bs.AbstractBizService;
import com.cmbc.edw.dao.IIntegratedDAO;
import com.cmbc.edw.model.Page;
    /**
     * 自动生成  
     * 
     **/
    public class ValueDefServiceImpl extends AbstractBizService implements ValueDefService {


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
    public  Page queryValueDefs(Map<String, String> map, int pageNo, int pageSize){
	      return daoSupportTemplate.getMybatisTemplate().query4Page("sra.param.queryValueDefs",
	      		"sra.param.queryValueDefTotal",map, pageNo, pageSize);
    }


    /**
     * 新增  
     * 
     **/
    public void addValueDef(ValueDef valueDef){
	      daoSupportTemplate.getMybatisTemplate().insert("sra.param.insertValueDef", valueDef);
    }


    /**
     * 修改  
     * 
     **/
    public void updateValueDef(ValueDef valueDef){
	      daoSupportTemplate.getMybatisTemplate().update("sra.param.updateValueDef", valueDef);
    }


    /**
     * 删除 
     * 
     **/
    public void deleteValueDef(String[] valueDefIds){
        Map<String, String[]> map = new HashMap<String, String[]>();
        map.put("valueDefIds", valueDefIds);
        daoSupportTemplate.getMybatisTemplate().delete("sra.param.deleteValueDefs", map);
    }


    /**
     * load单条数据 
     * 
     **/
    public  ValueDef loadValueDef(String valueDefId){
	      return (ValueDef)daoSupportTemplate.getMybatisTemplate().get("sra.param.loadValueDef", valueDefId);
    }
    

	/**
     * 查询值定义集合 
     * 
     **/
	public List queryValueList() {
    	return (List)daoSupportTemplate.getMybatisTemplate().query4list("sra.param.queryValueDefs");
	}
}