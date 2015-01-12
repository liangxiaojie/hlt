package sra.param.vo ;
import com.cmbc.edw.model.AbstractVO;
import java.util.Date;

public class Gl extends AbstractVO{

  private String glCd;//GL_CD
  public  void setGlCd(String glCd){this.glCd = glCd;}
  public  String getGlCd(){return glCd ;}
  private int glLevel;//GL_LEVEL
  public  void setGlLevel(int glLevel){this.glLevel = glLevel;}
  public  int getGlLevel(){return glLevel ;}
  private String superCd;//SUPER_CD
  public  void setSuperCd(String superCd){this.superCd = superCd;}
  public  String getSuperCd(){return superCd ;}
  private String glName;//GL_NAME
  public  void setGlName(String glName){this.glName = glName;}
  public  String getGlName(){return glName ;}
  private String balDir;//BAL_DIR
  public  void setBalDir(String balDir){this.balDir = balDir;}
  public  String getBalDir(){return balDir ;}
  private Date startDt;//START_DT
  public  void setStartDt(Date startDt){this.startDt = startDt;}
  public  Date getStartDt(){return startDt ;}

}