package sra.param.service;
import java.util.List;
import java.util.Map;
import com.cmbc.edw.model.Page;
import sra.param.vo.ValueDef;


public interface ValueDefService{
    public final static String SPRINT_ID = "ValueDefService";
    /**
     * 查询列表  
     * 
     * @param map
     * @param pageNo
     * @param pageSize
     * @return page
     **/
    public  Page queryValueDefs(Map<String, String> map, int pageNo, int pageSize);


    /**
     * 新增  
     * 
     **/
    public void addValueDef(ValueDef valueDef);


    /**
     * 修改  
     * 
     **/
    public void updateValueDef(ValueDef valueDef);


    /**
     * 删除 
     * 
     **/
    public void deleteValueDef(String[] valueDefIds);


    /**
     * load单条数据 
     * 
     **/
    public ValueDef loadValueDef(String valueDefId);
    /**
     * 查询值定义集合
     * 
     **/
    public List queryValueList();
}		