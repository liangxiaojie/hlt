package sra.param.service.impl;


/**
 * 多维数据集定义
 */
import java.util.HashMap;
import java.util.Map;
import sra.param.service.RowsetService;
import sra.param.vo.Rowset;
import com.cmbc.edw.bs.AbstractBizService;
import com.cmbc.edw.dao.IIntegratedDAO;
import com.cmbc.edw.model.Page;
    /**
     * 自动生成  
     * 
     **/
    public class RowsetServiceImpl extends AbstractBizService implements RowsetService {


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
    public  Page queryRowsets(Map<String, String> map, int pageNo, int pageSize){
	      return daoSupportTemplate.getMybatisTemplate().query4Page("sra.param.queryRowsets",
	      		"sra.param.queryRowsetTotal",map, pageNo, pageSize);
    }


    /**
     * 新增  
     * 
     **/
    public void addRowset(Rowset rowset){
    	System.out.println(rowset.getVcd01()+"--???--"+rowset.getDcd01());
	      daoSupportTemplate.getMybatisTemplate().insert("sra.param.insertRowset", rowset);
    }


    /**
     * 修改  
     * 
     **/
    public void updateRowset(Rowset rowset){
	      daoSupportTemplate.getMybatisTemplate().update("sra.param.updateRowset", rowset);
    }


    /**
     * 删除 
     * 
     **/
    public void deleteRowset(String[] rowsetIds){
        Map<String, String[]> map = new HashMap<String, String[]>();
        map.put("rowsetIds", rowsetIds);
        daoSupportTemplate.getMybatisTemplate().delete("sra.param.deleteRowsets", map);
    }


    /**
     * load单条数据 
     * 
     **/
    public  Rowset loadRowset(String rowsetId){
	      return (Rowset)daoSupportTemplate.getMybatisTemplate().get("sra.param.loadRowset", rowsetId);
    }
}