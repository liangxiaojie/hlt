package hlt.app.web;

import com.cmbc.edw.app.UserProfile;
import com.cmbc.edw.spring.SpringBeansGetter;
import com.cmbc.edw.util.HttpRequestUtil;
import com.cmbc.edw.util.StringUtils;
import com.cmbc.edw.web.cmd.impl.DispatchCommand;

import hlt.app.services.IAppUserWraper;

/**
 * HLT用户登录
 */
public class LoginCommand extends DispatchCommand {

  public void fromSra(){
    session.removeAttribute(USER_SESSION_KEY);
    
/*    //只认 本机来的登录
    if(!request.getLocalAddr().equals(request.getParameter("sraOn"))){
      super.responseUtf8("where are you from?");
      return ;
    }*/

    UserProfile user = new UserProfile();
    String userId = request.getParameter("userId");
    String password = request.getParameter("password");
    
    //if("null".equalsIgnoreCase(userId) || !StringUtils.hasLength(userId)) userId = HttpRequestUtil.getCookie(request, "edw_ws_useroperid");
    
    user.setUserId(userId);
    user.setUserPwd(password);
    user.setFromIpAddr(request.getRemoteAddr());

    ((IAppUserWraper)SpringBeansGetter.getBean(IAppUserWraper.SPRINT_ID)).wrap(user, request, response, servletConfig);
    //user.setUserOrg("9999"); //FIXME:dds的机构不用户上的机构，用补录机构表里的机构
    log.info(user);
    session.setAttribute(USER_SESSION_KEY, user);

    log.info("login as:" + session.getAttribute(USER_SESSION_KEY));
    response.setContentType("text/html");
    super.responseUtf8("OK.");
  }
  
  public UserProfile getCurrentUser() {
    return (UserProfile) session.getAttribute(USER_SESSION_KEY);
  }

}
