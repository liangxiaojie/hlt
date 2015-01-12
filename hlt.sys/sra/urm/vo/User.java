package sra.urm.vo ;
import com.cmbc.edw.model.AbstractVO;

public class User extends AbstractVO{

  private String userId;//USER_ID
  public  void setUserId(String userId){this.userId = userId;}
  public  String getUserId(){return userId ;}
  private String userPwd;//USER_PWD
  public  void setUserPwd(String userPwd){this.userPwd = userPwd;}
  public  String getUserPwd(){return userPwd ;}
  private String userName;//USER_NAME
  public  void setUserName(String userName){this.userName = userName;}
  public  String getUserName(){return userName ;}
  private String userOrg;//USER_ORG
  public  void setUserOrg(String userOrg){this.userOrg = userOrg;}
  public  String getUserOrg(){return userOrg ;}
  public String tel;
  public String getTel() {return tel;}
  public void setTel(String tel) {this.tel = tel;}
  public String deptId;
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
  public String deptName;
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
}