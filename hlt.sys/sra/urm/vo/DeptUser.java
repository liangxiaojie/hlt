package sra.urm.vo ;
import com.cmbc.edw.model.AbstractVO;
import java.util.Date;

public class DeptUser extends AbstractVO{

  private String deptId;//DEPT_ID
  public  void setDeptId(String deptId){this.deptId = deptId;}
  public  String getDeptId(){return deptId ;}
  private String userId;//USER_ID
  public  void setUserId(String userId){this.userId = userId;}
  public  String getUserId(){return userId ;}
  private String isManager;//IS_MANAGER
  public  void setIsManager(String isManager){this.isManager = isManager;}
  public  String getIsManager(){return isManager ;}

}