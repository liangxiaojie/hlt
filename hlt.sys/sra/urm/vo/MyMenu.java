package sra.urm.vo ;
import com.cmbc.edw.model.AbstractVO;
import java.util.Date;

public class MyMenu extends AbstractVO{

  private String userId;//USER_ID
  public  void setUserId(String userId){this.userId = userId;}
  public  String getUserId(){return userId ;}
  private String menuCode;//MENU_CODE
  public  void setMenuCode(String menuCode){this.menuCode = menuCode;}
  public  String getMenuCode(){return menuCode ;}
  private int menuOrder;//MENU_ORDER
  public  void setMenuOrder(int menuOrder){this.menuOrder = menuOrder;}
  public  int getMenuOrder(){return menuOrder ;}

}