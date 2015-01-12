package sra.login.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import sra.login.dao.ILoginDAO;
import sra.login.dao.impl.LoginDAOImpl;
import sra.login.service.ILoginService;
import sra.login.vo.OnlineRecBO;

import com.cmbc.edw.app.UserProfile;
import com.cmbc.edw.bs.AbstractBizService;
import com.cmbc.edw.codestring.ex.CodeStringExMenu;
import com.cmbc.edw.codestring.ex.CodeStringExMenuItem;
import com.cmbc.edw.dao.Pagination;
import com.cmbc.edw.ex.BizException;
import com.cmbc.edw.model.Page;

public class LoginServiceImpl extends AbstractBizService implements ILoginService {

  private ILoginDAO loginDAO;

  public ILoginDAO getLoginDAO() {
    return loginDAO;
  }

  public void setLoginDAO(ILoginDAO loginDAO) {
    this.loginDAO = loginDAO;
  }

  public void online(UserProfile user) {
    OnlineRecBO bo = new OnlineRecBO();
    bo.setIsOnline("Y");
    bo.setUserId(user.getUserId());
    loginDAO.onlineRec(bo);
  }

  public void offline(UserProfile user) {
    OnlineRecBO bo = new OnlineRecBO();
    bo.setIsOnline("N");
    bo.setUserId(user.getUserId());
    loginDAO.onlineRec(bo);
  }

  public String login(UserProfile user) {
    Pagination pag = new Pagination();
    pag.setNeedpage(false);
    pag.addQueryParameter("userId", user.getUserId());
    List udbs = loginDAO.query(pag, LoginDAOImpl.QUERY_STRING, "queryUser", UserProfile.class).getQueryResult();
    if (udbs == null || udbs.isEmpty())
    	return "用户验证失败.用户不存在:" + user.getUserId();

    // copy 属性
    UserProfile udb = (UserProfile) udbs.get(0);
    user.setUserName(udb.getUserName());
    user.setUserOrg(udb.getUserOrg());
    user.setUcenterId(udb.getUcenterId());

    // 密码加密：StringUtils.encodeMd5()
    log.info(user.getUserPwd() + " != " + udb.getUserPwd());
    if (!user.getUserPwd().equals(udb.getUserPwd())) {
    	return "用户 " + user.getUserId() + " 密码错误，请重新输入！";
    }
    return "";

    // 角色
  }

  public void setUserMenu(UserProfile user, String setCode) {
    // User Menu
    Pagination pag = new Pagination();
    pag.setNeedpage(false);
    pag.addQueryParameter("userId", user.getUserId());
    //pag.addQueryParameter("setCode", setCode);
    pag = loginDAO.query(pag, LoginDAOImpl.QUERY_STRING, "queryMyMenu", CodeStringExMenuItem.class);
    List rows = pag.getQueryResult();
    log.debug(rows);
    CodeStringExMenu menus = new CodeStringExMenu();
    for (Iterator iterator = rows.iterator(); iterator.hasNext();) {
      CodeStringExMenuItem item = (CodeStringExMenuItem) iterator.next();
      menus.addItem(item);
      item.setCodeString(menus);
    }
    user.setMenus(menus);
    log.debug(menus);
    log.debug(menus.getItems());

    // 收藏菜单
    pag = new Pagination();
    pag.setNeedpage(false);
    pag.addQueryParameter("userId", user.getUserId());
    pag.addQueryParameter("setCode", setCode);
    pag = loginDAO.query(pag, LoginDAOImpl.QUERY_STRING, "queryMyFavMenu", CodeStringExMenuItem.class);
    rows = pag.getQueryResult();
    user.setFavMenus(rows);
    log.debug(rows);
  }

  public Page queryUser4Login(Map<String, String> map, int pageNo, int pageSize) {
    return getMybatisTemplate().query4Page("sra.urm.queryUser4Login", "sra.urm.queryUser4Login_Ct", map, pageNo,pageSize);
  }

}
