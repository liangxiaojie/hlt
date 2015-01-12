package sra.param.service;
import java.util.List;
import java.util.Map;
import com.cmbc.edw.model.Page;
import sra.param.vo.DimeDef;


public interface DimeDefService{
    public final static String SPRINT_ID = "DimeDefService";
    /**
     * 查询列表  
     * 
     * @param map
     * @param pageNo
     * @param pageSize
     * @return page
     **/
    public  Page queryDimeDefs(Map<String, String> map, int pageNo, int pageSize);


    /**
     * 新增  
     * 
     **/
    public void addDimeDef(DimeDef dimeDef);


    /**
     * 修改  
     * 
     **/
    public void updateDimeDef(DimeDef dimeDef);


    /**
     * 删除 
     * 
     **/
    public void deleteDimeDef(String[] dimeDefIds);


    /**
     * load单条数据 
     * 
     **/
    public DimeDef loadDimeDef(String dimeDefId);
    /**
     * 维度定义集合
     * 
     **/
    public List queryDimeList();
}		