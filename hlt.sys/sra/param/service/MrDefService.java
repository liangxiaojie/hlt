package sra.param.service;
import java.util.List;
import java.util.Map;
import com.cmbc.edw.model.Page;

public interface MrDefService{
  public final static String SPRING_ID = "MrDefService";
  //def options
  public Page queryMrDef(Map<String, String> map, int pageNo, int pageSize);
  public String updateMrDef(Map row);
  public String addMrDef(Map row);
  public String deleteMrDefs(Map[] rows);
  public Map loadMrDef(Map para);
  //views
  public List queryModule4List();
  public List queryModuleRight(Map map);
  public List queryModuleOrg(Map map);
  //options
  public void addMrorg(Map map);
  public void deleteMrorg(Map[] maps);
  public void updateMrRight(Map[] mpas,String userId,String moduleNum);
}   