package sra.urm.vo ;
import com.cmbc.edw.model.AbstractVO;
import java.util.Date;

public class Mtable extends AbstractVO{

  private int pk1;//PK1
  public  void setPk1(int pk1){this.pk1 = pk1;}
  public  int getPk1(){return pk1 ;}
  private String pk2;//PK2
  public  void setPk2(String pk2){this.pk2 = pk2;}
  public  String getPk2(){return pk2 ;}
  private String ftVarchar;//FT_VARCHAR
  public  void setFtVarchar(String ftVarchar){this.ftVarchar = ftVarchar;}
  public  String getFtVarchar(){return ftVarchar ;}
  private Date ftDate;//FT_DATE
  public  void setFtDate(Date ftDate){this.ftDate = ftDate;}
  public  Date getFtDate(){return ftDate ;}
  private double ftDec;//FT_DEC
  public  void setFtDec(double ftDec){this.ftDec = ftDec;}
  public  double getFtDec(){return ftDec ;}
  private int ftInt;//FT_INT
  public  void setFtInt(int ftInt){this.ftInt = ftInt;}
  public  int getFtInt(){return ftInt ;}
  private String ftCs;//FT_CS
  public  void setFtCs(String ftCs){this.ftCs = ftCs;}
  public  String getFtCs(){return ftCs ;}

}