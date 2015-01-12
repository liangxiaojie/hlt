package sra.urm.vo ;
import com.cmbc.edw.model.AbstractVO;
import java.util.Date;

public class RoleMenu extends AbstractVO{

  private String roleCode;//ROLE_CODE
  public  void setRoleCode(String roleCode){this.roleCode = roleCode;}
  public  String getRoleCode(){return roleCode ;}
  private String menuCode;//MENU_CODE
  public  void setMenuCode(String menuCode){this.menuCode = menuCode;}
  public  String getMenuCode(){return menuCode ;}

}