package sra.param.service.impl;
/**
 * 定制数据项定义
 */
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sra.param.service.ItemService;
import sra.param.vo.Item;
import com.cmbc.edw.bs.AbstractBizService;
import com.cmbc.edw.dao.IIntegratedDAO;
import com.cmbc.edw.model.Page;
    /**
     * 自动生成  
     * 
     **/
    public class ItemServiceImpl extends AbstractBizService implements ItemService {


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
    public  Page queryItems(Map<String, String> map, int pageNo, int pageSize){
    	if(map.get("itemName")!=null&&!"".equals(map.get("itemName"))){
			map.put("itemName", "%"+map.get("itemName")+"%");
		}
	      return daoSupportTemplate.getMybatisTemplate().query4Page("sra.param.queryItems",
	      		"sra.param.queryItemTotal",map, pageNo, pageSize);
    }


    /**
     * 新增  
     * 
     **/
    public void addItem(Item item){
	      daoSupportTemplate.getMybatisTemplate().insert("sra.param.insertItem", item);
    }


    /**
     * 修改  
     * 
     **/
    public void updateItem(Item item){
	      daoSupportTemplate.getMybatisTemplate().update("sra.param.updateItem", item);
    }


    /**
     * 删除 
     * 
     **/
    public void deleteItem(String[] itemIds){
        Map<String, String[]> map = new HashMap<String, String[]>();
        map.put("itemIds", itemIds);
        daoSupportTemplate.getMybatisTemplate().delete("sra.param.deleteItems", map);
    }


    /**
     * load单条数据 
     * 
     **/
    public  Item loadItem(String itemId){
	      return (Item)daoSupportTemplate.getMybatisTemplate().get("sra.param.loadItem", itemId);
    }
}