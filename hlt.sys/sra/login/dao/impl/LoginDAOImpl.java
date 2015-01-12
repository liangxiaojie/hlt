package sra.login.dao.impl;

import sra.login.dao.ILoginDAO;
import sra.login.vo.OnlineRecBO;

import com.cmbc.edw.dao.impl.IntegratedDAOImpl;

public class LoginDAOImpl extends IntegratedDAOImpl implements ILoginDAO {

    public static final String QUERY_STRING = "Login";

    public void onlineRec(OnlineRecBO bo) {
      String sql = "";
      sql = "select count(1) as UCT FROM T_URM_ONLINE_REC where USER_ID = ?";
      int c = getSpringTemplate().queryForInt(sql,new Object[]{bo.getUserId()});
      if(c>0){
        sql = "insert into T_URM_ONLINE_REC (user_id) values (?)";
        update(sql, new String[] {bo.getUserId()});
      }
      if("Y".equals(bo.getIsOnline())){
        sql = "update T_URM_ONLINE_REC set IS_ONLINE = 'Y',ONLINE_TIME=getdate(),OFFLINE_TIME=null where user_id = ?";
        update(sql, new String[] {bo.getUserId(),bo.getIsOnline()});
      }else{
        sql = "update T_URM_ONLINE_REC set IS_ONLINE = 'N',OFFLINE_TIME=getdate() where user_id = ?";
        update(sql, new String[] {bo.getUserId(),bo.getIsOnline()});
      }   
    }
    
}
