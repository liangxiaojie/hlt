package sra.param.service;
import java.util.Map;
import com.cmbc.edw.model.Page;
import sra.param.vo.Prod;


public interface ProdService{
    public final static String SPRINT_ID = "ProdService";
    /**
     * 查询列表  
     * 
     * @param map
     * @param pageNo
     * @param pageSize
     * @return page
     **/
    public  Page queryProds(Map<String, String> map, int pageNo, int pageSize);


    /**
     * 新增  
     * 
     **/
    public void addProd(Prod prod);


    /**
     * 修改  
     * 
     **/
    public void updateProd(Prod prod);


    /**
     * 删除 
     * 
     **/
    public void deleteProd(String[] prodIds);


    /**
     * load单条数据 
     * 
     **/
    public Prod loadProd(String prodId);
}		