package sra.urm.web;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmbc.edw.web.cmd.impl.DispatchCommand;

/**
 * 附件管理
 * 
 * @author dunkee
 */
public class UrmMCommand extends DispatchCommand {

  // private IAttachmentService bs;

  public void init(HttpServletRequest request, HttpServletResponse response, ServletConfig servletConfig)
      throws Exception {
    super.init(request, response, servletConfig);
    // bs = (IAttachmentService)
    // SpringBeansGetter.getBean(IAttachmentService.BEAN_ID);
    // log.debug("init:" + bs);
  }

  public String org() {
    return "/sys/urm/rptOrg.jsp";
  }

  public String dept() {
    return "/sys/urm/dept.jsp";
  }

  public String user() {
    return "/sys/urm/user.jsp";
  }

  public String role() {
    return "/sys/urm/role.jsp";
  }

  public String menu() {
    return "/sys/urm/menu.jsp";
  }
  
  public String deptUser() {
	    return "/sys/urm/deptUser.jsp";
	  }
}
