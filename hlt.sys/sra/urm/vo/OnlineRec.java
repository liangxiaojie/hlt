package sra.urm.vo ;
import com.cmbc.edw.model.AbstractVO;
import java.util.Date;

public class OnlineRec extends AbstractVO{

  private String userId;//USER_ID
  public  void setUserId(String userId){this.userId = userId;}
  public  String getUserId(){return userId ;}
  private String isOnline;//IS_ONLINE
  public  void setIsOnline(String isOnline){this.isOnline = isOnline;}
  public  String getIsOnline(){return isOnline ;}
  private Date onlineTime;//ONLINE_TIME
  public  void setOnlineTime(Date onlineTime){this.onlineTime = onlineTime;}
  public  Date getOnlineTime(){return onlineTime ;}
  private Date offlineTime;//OFFLINE_TIME
  public  void setOfflineTime(Date offlineTime){this.offlineTime = offlineTime;}
  public  Date getOfflineTime(){return offlineTime ;}

}