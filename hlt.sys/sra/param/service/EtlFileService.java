package sra.param.service;
import java.util.Map;
import com.cmbc.edw.model.Page;

public interface EtlFileService{
  public final static String SPRING_ID = "EtlFileService";

  public Page queryFile(Map<String, String> map, int pageNo, int pageSize);
  public String updateFile(Map row);
  public String addFile(Map row);
  public String deleteFiles(Map[] rows);
  public Map loadFile(Map para);

}   