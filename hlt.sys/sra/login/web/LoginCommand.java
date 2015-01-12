package sra.login.web;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sra.login.service.ILoginService;

import com.cmbc.edw.app.UserProfile;
import com.cmbc.edw.codestring.ex.CodeStringExMenu;
import com.cmbc.edw.codestring.ex.CodeStringExMenuItem;
import com.cmbc.edw.ex.CmdException;
import com.cmbc.edw.spring.SpringBeansGetter;
import com.cmbc.edw.util.HttpRequestUtil;
import com.cmbc.edw.util.JSONUtils;
import com.cmbc.edw.util.MapUtils;
import com.cmbc.edw.util.ObjectUtils;
import com.cmbc.edw.util.StringUtils;
import com.cmbc.edw.web.cmd.impl.DispatchCommand;

/**
 * 登陆
 * 
 * @author dunkee
 */
public class LoginCommand extends DispatchCommand {

  private ILoginService bs;

  public void init(HttpServletRequest request, HttpServletResponse response, ServletConfig servletConfig) throws Exception {
    super.init(request, response, servletConfig);
    bs = (ILoginService) SpringBeansGetter.getBean(ILoginService.BEAN_ID);
    log.debug("init:" + bs);
  }

  /**
   * 重写
   */
  public String login() {
    session.removeAttribute(USER_SESSION_KEY);

    UserProfile user = new UserProfile();
    String userId = request.getParameter("userId");
    String password = request.getParameter("password");
    user.setUserId(userId);
    user.setUserPwd(password);
    user.setFromIpAddr(request.getRemoteAddr());

    if (!StringUtils.hasText(userId) || !StringUtils.hasText(password)) { throw new CmdException("用户名和密码不能为空:userId=" + userId + ",password=" + password); }

    bs.login(user);
    bs.setUserMenu(user, "");

    session.setAttribute(USER_SESSION_KEY, user);
    log.info("login as:" + session.getAttribute(USER_SESSION_KEY));
    // 默认密码必须更改
    if ("888888".equals(password)) return "/urm.do?invoke=changePassword&self=Y&fisrtChangePassword=Y";

    return "/index.jsp";
  }

  public Object loginExt() {
    session.removeAttribute(USER_SESSION_KEY);

    UserProfile user = new UserProfile();
    String userId = request.getParameter("userId");
    String password = request.getParameter("password");
    user.setUserId(userId);
    user.setUserPwd(password);
    user.setFromIpAddr(request.getRemoteAddr());

    if (!StringUtils.hasText(userId) || !StringUtils.hasText(password)) { return "用户名和密码不能为空:userId=" + userId + ",password=" + password; }

    // try {
    String re = bs.login(user);
    if (!re.equals("")) { return re; }
    // }// catch (BizException e) {
    // System.out.println(e.getClientMessage()+e.getMessage());
    // return e.getMessage();
    // }

    bs.setUserMenu(user, "");

    session.setAttribute(USER_SESSION_KEY, user);
    log.info("login as:" + session.getAttribute(USER_SESSION_KEY));

    return "Y";
  }

  // 通过webservice获得用户ID登录
  public String loginFromPortal() {
    String userId = HttpRequestUtil.getCookie(request, "edw_ws_useroperid");
    String sessid = HttpRequestUtil.getCookie(request, "edw_ws_sessionid");

    // 如果当前用户和回话用户一致则无须继续
    if (getCurrentUser() != null && userId.equals(getCurrentUser().getUserId())) return "/index.jsp";

    String url = "http://edw.cmbc.com.cn:81/s.do?operate=isLoginStatus&userOperId=" + userId + "&sessionId=" + sessid;
    log.info("url: " + url);
    String txt = HttpRequestUtil.getAjaxResponse(url);
    log.info("json: " + txt);

    // {"isSuperAdmin":false,"data":{"dispatch":"false","freeze":"false","superOrg":"9999","superOrgName":"总行","userGroupId":"","userGroupName":"总行信息管理中心信息支持处应用管理岗","userId":"0000034903","userName":"唐天余","userOperId":"tangtianyu","userOrgName":"总行","userOrgNo":"9999"},"code":"S001","msg":"已登录","success":true}
    Map json = (Map) JSONUtils.toJava(txt, Map.class);
    log.info(json);
    // "code":"S001"
    if (!"S001".equals(MapUtils.get(json, "code"))) {
      request.setAttribute(CMD_MESSAGE, "请确保正常登录!");
      return "/login.jsp";
    }

    Map attr = (Map) json.get("data");
    log.info(attr);
    session.removeAttribute(USER_SESSION_KEY);

    UserProfile user = new UserProfile();
    user.setFromIpAddr(request.getRemoteAddr());
    user.setUserId(userId);
    user.setUserName(MapUtils.get(attr, "userName"));
    user.setUserOrg(MapUtils.get(attr, "userOrgNo"));
    user.setEmployeeId(MapUtils.get(attr, "userId"));

    bs.setUserMenu(user, "");

    session.setAttribute(USER_SESSION_KEY, user);
    log.info("login as:" + session.getAttribute(USER_SESSION_KEY));

    return "/index.jsp";
  }

  /**
   * 模块导航
   */
  public void mySubMenu() throws Exception {
    response.setContentType("text/json; charset=UTF-8");
    String subMenuRoot = ObjectUtils.toString(request.getParameter("root"));
    CodeStringExMenu cMenu = new CodeStringExMenu();
    try {
      CodeStringExMenu menus = (CodeStringExMenu) (getCurrentUser().getMenus());
      log.debug(menus.getItems());
      cMenu = (CodeStringExMenu) menus.getSubCodeString(subMenuRoot);
      log.debug(cMenu.getItems());
    } catch (Exception e) {
      log.warn(e.getMessage());
      cMenu = new CodeStringExMenu();
    }

    log.debug(cMenu.getItems());
    String json = cMenu.buildJson(false);
    log.info(json);
    // response.getOutputStream().write(json.getBytes());
    responseUtf8(json);
  }

  /**
   * 首页导航
   */
  public void myNavMenu() throws Exception {
    response.setContentType("text/json; charset=UTF-8");
    String subMenuRoot = ObjectUtils.toString(request.getParameter("root"));
    CodeStringExMenu cMenu = new CodeStringExMenu();
    try {
      CodeStringExMenu menus = (CodeStringExMenu) (getCurrentUser().getMenus());
      log.info(menus.getItems());
      log.info("subMenuRoot=" + subMenuRoot);
      cMenu = (CodeStringExMenu) menus.getSubCodeString(subMenuRoot);
      log.debug(cMenu.getItems());
    } catch (Exception e) {
      log.warn(e.getMessage());
      cMenu = new CodeStringExMenu();
    }

    log.debug(cMenu.getItems());
    String json = cMenu.buildJson(false);
    log.info(json);
    responseUtf8(json);
  }

  /**
   * 最近访问的菜单
   */
  public void myFavMenu() {
    response.setContentType("text/json; charset=UTF-8");
    CodeStringExMenu cMenu = new CodeStringExMenu();
    List menus = getCurrentUser().getFavMenus();
    log.debug(menus);
    for (Iterator iterator = menus.iterator(); iterator.hasNext();) {
      CodeStringExMenuItem menu = (CodeStringExMenuItem) iterator.next();
      menu.setCodeString(cMenu);
      cMenu.addItem(menu);
    }
    String json = cMenu.buildJson(true);
    log.debug(json);
    responseUtf8(json);
  }

  /**
   * 退出
   * 
   * @return
   */
  public String logout() {
    session.removeAttribute(USER_SESSION_KEY);
    return "/login.jsp";
  }

  public void currentUser() {
    String userId = "X";
    try {
      userId = getCurrentUser().getUserId();
    } catch (Exception e) {
      log.warn("异常请求.");
    }
    responseUtf8(userId);
  }

}
