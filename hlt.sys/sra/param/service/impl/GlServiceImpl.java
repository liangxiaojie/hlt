package sra.param.service.impl;

/**
 * 科目定义
 */
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sra.param.service.GlService;
import sra.param.vo.Gl;
import com.cmbc.edw.bs.AbstractBizService;
import com.cmbc.edw.dao.IIntegratedDAO;
import com.cmbc.edw.model.Page;
    /**
     * 自动生成  
     * 
     **/
    public class GlServiceImpl extends AbstractBizService implements GlService {


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
    public  Page queryGls(Map<String, String> map, int pageNo, int pageSize){
    	if(map.get("glName")!=null&&!"".equals(map.get("glName"))){
			map.put("glName", "%"+map.get("glName")+"%");
		}
	      return daoSupportTemplate.getMybatisTemplate().query4Page("sra.param.queryGls",
	      		"sra.param.queryGlTotal",map, pageNo, pageSize);
    }


    /**
     * 新增  
     * 
     **/
    public void addGl(Gl gl){
	      daoSupportTemplate.getMybatisTemplate().insert("sra.param.insertGl", gl);
    }


    /**
     * 修改  
     * 
     **/
    public void updateGl(Gl gl){
	      daoSupportTemplate.getMybatisTemplate().update("sra.param.updateGl", gl);
    }


    /**
     * 删除 
     * 
     **/
    public void deleteGl(String[] glIds){
        Map<String, String[]> map = new HashMap<String, String[]>();
        map.put("glIds", glIds);
        daoSupportTemplate.getMybatisTemplate().delete("sra.param.deleteGls", map);
    }


    /**
     * load单条数据 
     * 
     **/
    public  Gl loadGl(String glId){
	      return (Gl)daoSupportTemplate.getMybatisTemplate().get("sra.param.loadGl", glId);
    }
}