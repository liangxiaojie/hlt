package sra.urm.vo ;
import com.cmbc.edw.model.AbstractVO;
import java.util.ArrayList;
import java.util.List;

public class DeptBase extends AbstractVO{

  private String deptId;//DEPT_ID
  public  void setDeptId(String deptId){this.deptId = deptId;}
  public  String getDeptId(){return deptId ;}
  private String parentDept;//PARENT_DEPT
  public  void setParentDept(String parentDept){this.parentDept = parentDept;}
  public  String getParentDept(){return parentDept ;}
  private String deptName;//DEPT_NAME
  public  void setDeptName(String deptName){this.deptName = deptName;}
  public  String getDeptName(){return deptName ;}
  private String deptDesc;//DEPT_DESC
  public  void setDeptDesc(String deptDesc){this.deptDesc = deptDesc;}
  public  String getDeptDesc(){return deptDesc ;}
  public List<DeptBase> children = new ArrayList<DeptBase>();
  public List<DeptBase> getChildren() {return children;}
  public void setChildren(List<DeptBase> children) {this.children = children;}
  
  private String className;
  private String temp;
public String getTemp() {
	return temp;
}
public void setTemp(String temp) {
	this.temp = temp;
}
public String getClassName() {
	return className;
}
public void setClassName(String className) {
	this.className = className;
}
}