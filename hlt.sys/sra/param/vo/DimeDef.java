package sra.param.vo ;
import com.cmbc.edw.model.AbstractVO;
import java.util.Date;

public class DimeDef extends AbstractVO{

  private String dimeCd;//DIME_CD
  public  void setDimeCd(String dimeCd){this.dimeCd = dimeCd;}
  public  String getDimeCd(){return dimeCd ;}
  private String dimeName;//DIME_NAME
  public  void setDimeName(String dimeName){this.dimeName = dimeName;}
  public  String getDimeName(){return dimeName ;}
  private String dataType;//DATA_TYPE
  public  void setDataType(String dataType){this.dataType = dataType;}
  public  String getDataType(){return dataType ;}
  private String codeString;//CODE_STRING
  public  void setCodeString(String codeString){this.codeString = codeString;}
  public  String getCodeString(){return codeString ;}
  private String dimeDesc;//DIME_DESC
  public  void setDimeDesc(String dimeDesc){this.dimeDesc = dimeDesc;}
  public  String getDimeDesc(){return dimeDesc ;}

}