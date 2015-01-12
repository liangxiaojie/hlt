package sra.urm.vo ;
import com.cmbc.edw.model.AbstractVO;
import java.util.Date;

public class Role extends AbstractVO{

  private String roleCode;//ROLE_CODE
  public  void setRoleCode(String roleCode){this.roleCode = roleCode;}
  public  String getRoleCode(){return roleCode ;}
  private String roleName;//ROLE_NAME
  public  void setRoleName(String roleName){this.roleName = roleName;}
  public  String getRoleName(){return roleName ;}
  private String roleCat;//ROLE_CAT
  public  void setRoleCat(String roleCat){this.roleCat = roleCat;}
  public  String getRoleCat(){return roleCat ;}
  private String roleDesc;//ROLE_DESC
  public  void setRoleDesc(String roleDesc){this.roleDesc = roleDesc;}
  public  String getRoleDesc(){return roleDesc ;}

}