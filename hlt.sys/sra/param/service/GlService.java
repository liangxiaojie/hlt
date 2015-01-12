package sra.param.service;
import java.util.List;
import java.util.Map;
import com.cmbc.edw.model.Page;
import com.cmbc.edw.model.Page;
import sra.param.vo.Gl;


public interface GlService{
    public final static String SPRINT_ID = "GlService";
    /**
     * 查询列表  
     * 
     * @param map
     * @param pageNo
     * @param pageSize
     * @return page
     **/
    public  Page queryGls(Map<String, String> map, int pageNo, int pageSize);


    /**
     * 新增  
     * 
     **/
    public void addGl(Gl gl);


    /**
     * 修改  
     * 
     **/
    public void updateGl(Gl gl);


    /**
     * 删除 
     * 
     **/
    public void deleteGl(String[] glIds);


    /**
     * load单条数据 
     * 
     **/
    public Gl loadGl(String glId);
}		