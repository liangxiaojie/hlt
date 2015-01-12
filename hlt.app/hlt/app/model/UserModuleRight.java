package hlt.app.model;

import com.cmbc.edw.model.AbstractVO;

public class UserModuleRight extends AbstractVO {

  private String userId;//USER_ID
  public  void setUserId(String userId){this.userId = userId;}
  public  String getUserId(){return userId ;}
  private String moduleNum;//MODULE_NUM
  public  void setModuleNum(String moduleNum){this.moduleNum = moduleNum;}
  public  String getModuleNum(){return moduleNum ;}
  private String rightCode = "";//RIGHT_CODE 
  public String getRightCode() {
    return rightCode;
  }
  public void setRightCode(String rightCode) {
    this.rightCode = rightCode;
  }
  private String dsOrg ;//机构  
  public String getDsOrg() {
    return dsOrg;
  }
  public void setDsOrg(String dsOrg) {
    this.dsOrg = dsOrg;
  }
  

}