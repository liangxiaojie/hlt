package sra.param.service;
import java.util.List;
import java.util.Map;
import com.cmbc.edw.model.Page;
import com.cmbc.edw.model.Page;
import sra.param.vo.Item;


public interface ItemService{
    public final static String SPRINT_ID = "ItemService";
    /**
     * 查询列表  
     * 
     * @param map
     * @param pageNo
     * @param pageSize
     * @return page
     **/
    public  Page queryItems(Map<String, String> map, int pageNo, int pageSize);


    /**
     * 新增  
     * 
     **/
    public void addItem(Item item);


    /**
     * 修改  
     * 
     **/
    public void updateItem(Item item);


    /**
     * 删除 
     * 
     **/
    public void deleteItem(String[] itemIds);


    /**
     * load单条数据 
     * 
     **/
    public Item loadItem(String itemId);
}		