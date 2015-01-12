package hlt.app.services;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.apache.log4j.Logger;

import hlt.app.model.UserModuleRight;

import com.cmbc.edw.app.ParameterManager;
import com.cmbc.edw.dao.IIntegratedDAO;
import com.cmbc.edw.ex.CmdException;
import com.cmbc.edw.spring.SpringBeansGetter;
import com.cmbc.edw.util.BeanUtils;
import com.cmbc.edw.util.StringUtils;

/**
 * 用户模块角色管理
 * 
 */
public class UserModuleRightManager {

  private static Logger log = Logger.getLogger(UserModuleRightManager.class);

  private List<UserModuleRight> userModelRights = new Vector();// 用户模块角色清单
  private List<UserModuleRight> userModelOrgs = new Vector();// 用户模块角色清单
  // 单例
  private static UserModuleRightManager csm = null;

  public static UserModuleRightManager getInstance() {
    if (csm == null || !ParameterManager.CACHE) {// cache
      csm = new UserModuleRightManager();
    }
    return csm;
  }

  /**
   * 供需要时刷新缓存代码
   * 
   * @return
   */
  public static UserModuleRightManager flushInstance() {
    csm = null;
    return getInstance();
  }

  private UserModuleRightManager() {
    try {
      IIntegratedDAO dao = (IIntegratedDAO) SpringBeansGetter.getBean(IIntegratedDAO.SPRING_ID);
      String sql = "select a.USER_ID as userId, a.MODULE_NUM as moduleNum,a.RIGHT_CODE as rightCode from T_URM_MR_RIGHT a";
      userModelRights = BeanUtils.jdbcMap2pojo(dao.query(sql), UserModuleRight.class);
      log.info(userModelRights);
    } catch (Exception ex) {
      ex.printStackTrace();
      log.error("用户模块角色初始化出错." + ex);
      throw new CmdException("用户模块角色初始化出错: " + ex);
    }
  }

  // =====================================================
  public static String getUmrsAsString(String userId, String moduleNum) {
    String re = "";
    for (Iterator iterator = getUmrs(userId, moduleNum).iterator(); iterator.hasNext();) {
      UserModuleRight umr = (UserModuleRight) iterator.next();
      re += umr.getRightCode();
      if (iterator.hasNext()) re += ",";
    }
    return re;
  }

  public static List getUmrs(String userId, String moduleNum) {
    //log.info(userId+":"+moduleNum);
    List re = new Vector();
    if (!StringUtils.hasText(userId) || !StringUtils.hasText(moduleNum)) return re;

    for (Iterator iterator = getInstance().userModelRights.iterator(); iterator.hasNext();) {
      UserModuleRight umr = (UserModuleRight) iterator.next();
      //log.info(umr.getUserId()+":"+umr.getModuleNum());
      if (userId.equals(umr.getUserId()) && moduleNum.equals(umr.getModuleNum())) re.add(umr);
    }
    return re;
  }

  public static boolean noRight(String userId,String moduleNum){
    return getUmrs(userId,moduleNum).isEmpty() ;
  }
  public static boolean hasRight(String userId, String moduleNum, String rightCode) {
    if (!StringUtils.hasText(rightCode)) return false;
    for (Iterator iterator = getUmrs(userId, moduleNum).iterator(); iterator.hasNext();) {
      UserModuleRight umr = (UserModuleRight) iterator.next();
      if (rightCode.equals(umr.getRightCode())) return true;
    }
    return false;
  }

//=====================================================
 //是否有总行权限
 public static boolean isHqOrg(String userId, String moduleNum) {
   return ("," + getUmosAsString(userId, moduleNum) + ",").indexOf(",9999,") != -1;
 }
 public static String getUmosAsString(String userId, String moduleNum) {
	    String re = "";
	    for (Iterator iterator = getUmos(userId, moduleNum).iterator(); iterator.hasNext();) {
	      UserModuleRight umr = (UserModuleRight) iterator.next();
	      re += umr.getDsOrg();
	      if (iterator.hasNext()) re += ",";
	    }
	    return re;
	  }
 public static List getUmos(String userId, String moduleNum) {
	    // log.info(userId+":"+moduleNum);
	    List re = new Vector();
	    if (!StringUtils.hasText(userId) || !StringUtils.hasText(moduleNum)) return re;

	    for (Iterator iterator = getInstance().userModelOrgs.iterator(); iterator.hasNext();) {
	      UserModuleRight umr = (UserModuleRight) iterator.next();
	      // log.info(umr.getUserId()+":"+umr.getModuleNum());
	      if (userId.equals(umr.getUserId()) && moduleNum.equals(umr.getModuleNum())) re.add(umr);
	    }
	    return re;
	  }
  
  
  

}
