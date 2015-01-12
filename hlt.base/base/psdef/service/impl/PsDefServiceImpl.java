package base.psdef.service.impl;

import java.util.Map;

import com.cmbc.edw.bs.AbstractBizService;
import com.cmbc.edw.model.Page;

import base.psdef.service.PsDefService;

public class PsDefServiceImpl extends AbstractBizService  implements PsDefService{

	public Page queryPsDef(Map map,int pageNo,int pageSize) {
		return mybatis().query4Page("hlt.base.psdef.queryPsDef","hlt.base.psdef.queryPsDefTotal",map, pageNo, pageSize);
	}

	public String addPsDef(Map row){
		mybatis().insert("hlt.base.psdef.addPsDef",row);
		return "新增成功";
	}
	
}
