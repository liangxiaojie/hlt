package sra.param.service.impl;

import java.util.Map;

import sra.param.service.EtlFileService;


import com.cmbc.edw.bs.AbstractBizService;
import com.cmbc.edw.dao.IIntegratedDAO;
import com.cmbc.edw.model.Page;

public class EtlFileServiceImpl extends AbstractBizService implements EtlFileService {

    private IIntegratedDAO daoSupportTemplate;
    public void setDaoSupportTemplate(IIntegratedDAO daoSupportTemplate) {
        this.daoSupportTemplate = daoSupportTemplate;
	  }
    
 public  Page queryFile(Map map, int pageNo, int pageSize){
    return mybatis().query4Page("sra.param.queryFile","sra.param.queryFileTotal",map, pageNo, pageSize);
  }

  public String addFile(Map row){
      mybatis().insert("sra.param.insertFile", row);
      return  "新增成功";
  }

  public String updateFile(Map row){
      mybatis().update("sra.param.updateFile", row);
      return  "更新成功";
  }

  public String deleteFiles(Map[] rows){
      for (int i = 0; i < rows.length; i++) {
        mybatis().delete("sra.param.deleteFile", rows[i]);
      }
      return "共删除 " + rows.length + " 条记录。";
  }

  public  Map loadFile(Map para){
      return (Map)mybatis().get("sra.param.loadFile", para);
  }

}