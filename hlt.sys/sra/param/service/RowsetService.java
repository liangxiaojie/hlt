package sra.param.service;
import java.util.List;
import java.util.Map;
import com.cmbc.edw.model.Page;
import com.cmbc.edw.model.Page;
import sra.param.vo.Rowset;


public interface RowsetService{
    public final static String SPRINT_ID = "RowsetService";
    /**
     * 查询列表  
     * 
     * @param map
     * @param pageNo
     * @param pageSize
     * @return page
     **/
    public  Page queryRowsets(Map<String, String> map, int pageNo, int pageSize);


    /**
     * 新增  
     * 
     **/
    public void addRowset(Rowset rowset);


    /**
     * 修改  
     * 
     **/
    public void updateRowset(Rowset rowset);


    /**
     * 删除 
     * 
     **/
    public void deleteRowset(String[] rowsetIds);


    /**
     * load单条数据 
     * 
     **/
    public Rowset loadRowset(String rowsetId);
}		