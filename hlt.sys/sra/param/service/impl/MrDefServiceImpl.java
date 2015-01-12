package sra.param.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sra.param.service.MrDefService;


import com.cmbc.edw.bs.AbstractBizService;
import com.cmbc.edw.model.Page;
import com.cmbc.edw.util.MapUtils;

public class MrDefServiceImpl extends AbstractBizService implements MrDefService {

  public  Page queryMrDef(Map map, int pageNo, int pageSize){
    return mybatis().query4Page("sra.param.queryMrDef","sra.param.queryMrDefTotal",map, pageNo, pageSize);
  }

  public String addMrDef(Map row){
      mybatis().insert("sra.param.insertMrDef", row);
      return  "新增成功";
  }

  public String updateMrDef(Map row){
      mybatis().update("sra.param.updateMrDef", row);
      return  "更新成功";
  }

  public String deleteMrDefs(Map[] rows){
      for (int i = 0; i < rows.length; i++) {
        mybatis().delete("sra.param.deleteMrDef", rows[i]);
      }
      return "共删除 " + rows.length + " 条记录。";
  }

  public  Map loadMrDef(Map para){
      return (Map)mybatis().get("sra.param.loadMrDef", para);
  }


public List queryModule4List() {
	return mybatis().query4list("sra.param.queryModuleNum4List");
}

public List queryModuleRight(Map map){
	return mybatis().query4list("sra.param.queryModuleRight4List",map);
}
public List queryModuleOrg(Map map){
	return mybatis().query4list("sra.param.queryModuleOrg4List",map);
}
public void addMrorg(Map map){
	String sql="insert into T_URM_MR_ORG select '"+MapUtils.get(map, "userId")+"','"+MapUtils.get(map, "moduleNum")+"',"+"'"+MapUtils.get(map, "mrOrg")+"'";
	dao.execute(sql);
}
public void deleteMrorg(Map[] maps){
	String sql="delete from T_URM_MR_ORG where user_id=? and mr_org=? and module_num=?";
	for(int i=0;i<maps.length;i++){
		Map map=maps[i];
	dao.execute(sql,new Object[]{MapUtils.get(map, "userId"),MapUtils.get(map, "mrOrg"),MapUtils.get(map, "moduleNum")});
	}
}
public void updateMrRight(Map[] maps,String userId,String moduleNum){
	String sql="delete from T_URM_MR_RIGHT where user_id=?  and module_num=?";
	dao.execute(sql, new Object[]{userId,moduleNum});
	for(int i=0;i<maps.length;i++){
		Map map=maps[i];
		sql="insert into T_URM_MR_RIGHT select '"+userId+"','"+moduleNum+"',"+"'"+MapUtils.get(map, "rightCode")+"'";
		dao.execute(sql);
	}
}


}