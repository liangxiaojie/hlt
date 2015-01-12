package sra.param.service.impl;

import java.util.Map;

import sra.param.service.FileMappingService;


import com.cmbc.edw.bs.AbstractBizService;
import com.cmbc.edw.dao.IIntegratedDAO;
import com.cmbc.edw.model.Page;

public class FileMappingServiceImpl extends AbstractBizService implements FileMappingService {

    private IIntegratedDAO daoSupportTemplate;
    public void setDaoSupportTemplate(IIntegratedDAO daoSupportTemplate) {
        this.daoSupportTemplate = daoSupportTemplate;
	  }
    
  public  Page queryFileMapping(Map map, int pageNo, int pageSize){
    return mybatis().query4Page("sra.param.queryFileMapping","sra.param.queryFileMappingTotal",map, pageNo, pageSize);
  }

  public String addFileMapping(Map row){
      mybatis().insert("sra.param.insertFileMapping", row);
      return  "新增成功";
  }

  public String updateFileMapping(Map row){
      mybatis().update("sra.param.updateFileMapping", row);
      return  "更新成功";
  }

  public String deleteFileMappings(Map[] rows){
      for (int i = 0; i < rows.length; i++) {
        mybatis().delete("sra.param.deleteFileMapping", rows[i]);
      }
      return "共删除 " + rows.length + " 条记录。";
  }

  public  Map loadFileMapping(Map para){
      return (Map)mybatis().get("sra.param.loadFileMapping", para);
  }

}