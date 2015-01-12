package sra.param.service.impl;

/**
 * 产品定义
 */
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sra.param.service.ProdService;
import sra.param.vo.Prod;
import com.cmbc.edw.bs.AbstractBizService;
import com.cmbc.edw.dao.IIntegratedDAO;
import com.cmbc.edw.model.Page;
    /**
     * 自动生成  
     * 
     **/
    public class ProdServiceImpl extends AbstractBizService implements ProdService {


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
    public  Page queryProds(Map<String, String> map, int pageNo, int pageSize){
    	if(map.get("prodName")!=null&&!"".equals(map.get("prodName"))){
			map.put("prodName", "%"+map.get("prodName")+"%");
		}
	      return daoSupportTemplate.getMybatisTemplate().query4Page("sra.param.queryProds",
	      		"sra.param.queryProdTotal",map, pageNo, pageSize);
    }


    /**
     * 新增  
     * 
     **/
    public void addProd(Prod prod){
	      daoSupportTemplate.getMybatisTemplate().insert("sra.param.insertProd", prod);
    }


    /**
     * 修改  
     * 
     **/
    public void updateProd(Prod prod){
	      daoSupportTemplate.getMybatisTemplate().update("sra.param.updateProd", prod);
    }


    /**
     * 删除 
     * 
     **/
    public void deleteProd(String[] prodIds){
        Map<String, String[]> map = new HashMap<String, String[]>();
        map.put("prodIds", prodIds);
        daoSupportTemplate.getMybatisTemplate().delete("sra.param.deleteProds", map);
    }


    /**
     * load单条数据 
     * 
     **/
    public  Prod loadProd(String prodId){
	      return (Prod)daoSupportTemplate.getMybatisTemplate().get("sra.param.loadProd", prodId);
    }
}