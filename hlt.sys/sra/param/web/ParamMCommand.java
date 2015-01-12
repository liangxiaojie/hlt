package sra.param.web;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmbc.edw.web.cmd.impl.DispatchCommand;

/**
 * 附件管理
 * 
 * @author dunkee
 */
public class ParamMCommand extends DispatchCommand {

  // private IAttachmentService bs;

  public void init(HttpServletRequest request, HttpServletResponse response, ServletConfig servletConfig)
      throws Exception {
    super.init(request, response, servletConfig);
    // bs = (IAttachmentService)
    // SpringBeansGetter.getBean(IAttachmentService.BEAN_ID);
    // log.debug("init:" + bs);
  }

  public String codeCat() {
    return "/sys/urm/codeCat.jsp";
  }
  public  String GL() {
	  return "/sys/param/gl.jsp";//科目定义
}
  public String indexDef()
  {
	  return "/sys/param/indexDef.jsp";//指标定义
  }
  
  public String prod()
  {
	  return "/sys/param/prod.jsp";//产品定义
  }
   public String item()
   {
	   return "/sys/param/item.jsp";//定制数据项定义
   }
   public String rowSet()
   {
	   return "/sys/param/rowSet.jsp";//多维数据项定义
   }
   public String valuesDef()
   {
	   return "/sys/param/valuesDef.jsp";//数据值定义
   }
   public String dimeDef()
   {
	   return "/sys/param/dimeDef.jsp";//数据维度定义
   }
   public String codestring(){
	   return "/sys/urm/codeCat.jsp";//系统字典管理   
   }
   
   public String cmbcOrg(){
	   return "/sys/param/cmbcOrg.jsp"; //账务机构
   }
   public String publicindexDef(){
		  return "/sys/param/publicIndexDef.jsp";//公共指标定义
   }
   
   public String fileMapping() {
		    return "/sys/param/FileMapping.jsp";//文件加载程序定义
		  }
   public String etlFile() {
		    return "/sys/param/EtlFile.jsp";//etl任务定义
		  }
   public String MrDef(){
		  return "/sys/param/MrDef.jsp";
	  }
}
