package sra.param.service;
import java.util.Map;
import com.cmbc.edw.model.Page;

public interface FileMappingService{
  public final static String SPRING_ID = "FileMappingService";

  public Page queryFileMapping(Map<String, String> map, int pageNo, int pageSize);
  public String updateFileMapping(Map row);
  public String addFileMapping(Map row);
  public String deleteFileMappings(Map[] rows);
  public Map loadFileMapping(Map para);

}   