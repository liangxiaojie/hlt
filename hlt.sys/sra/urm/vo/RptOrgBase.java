package sra.urm.vo;

import java.util.ArrayList;
import java.util.List;

import com.cmbc.edw.model.AbstractVO;

public class RptOrgBase extends AbstractVO implements RptOrgInterface{
	private String orgNum;//ORG_NUM
	  public  void setOrgNum(String orgNum){this.orgNum = orgNum;}
	  public  String getOrgNum(){return orgNum ;}
	  private String parentOrg;//PARENT_ORG
	  public  void setParentOrg(String parentOrg){this.parentOrg = parentOrg;}
	  public  String getParentOrg(){return parentOrg ;}
	  private String orgName;//ORG_NAME
	  public  void setOrgName(String orgName){this.orgName = orgName;}
	  public  String getOrgName(){return orgName ;}
	  private String areaCode;//AREA_CODE
	  public  void setAreaCode(String areaCode){this.areaCode = areaCode;}
	  public  String getAreaCode(){return areaCode ;}
	  private String orgType;//ORG_TYPE
	  public  void setOrgType(String orgType){this.orgType = orgType;}
	  public  String getOrgType(){return orgType ;}
	  private String upperOrgs;//UPPER_ORGS
	  public  void setUpperOrgs(String upperOrgs){this.upperOrgs = upperOrgs;}
	  public  String getUpperOrgs(){return upperOrgs ;}
	  List<RptOrgInterface> children = new ArrayList<RptOrgInterface>();
	  public List<RptOrgInterface> getChildren() {return children;}
	  public void setChildren(List<RptOrgInterface> children) {this.children = children;}
}
