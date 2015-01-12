package sra.urm.vo ;
import com.cmbc.edw.model.AbstractVO;
import java.util.Date;

public class UserRole extends AbstractVO{

  private String roleCode;//ROLE_CODE
  public  void setRoleCode(String roleCode){this.roleCode = roleCode;}
  public  String getRoleCode(){return roleCode ;}
  private String userId;//USER_ID
  public  void setUserId(String userId){this.userId = userId;}
  public  String getUserId(){return userId ;}

}