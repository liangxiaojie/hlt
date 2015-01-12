package base.psdef.service;

import java.util.Map;

import com.cmbc.edw.model.Page;

public interface PsDefService {

	public final static String SPRING_ID = "base.psdef.service.PsDefService";
	
	public Page queryPsDef(Map map,int pageNo,int pageSize);
	public String addPsDef(Map map);
	
	
}
