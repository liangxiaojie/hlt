package sra.param.vo ;
import com.cmbc.edw.model.AbstractVO;
import java.util.Date;

public class ValueDef extends AbstractVO{

  private String valueCd;//VALUE_CD
  public  void setValueCd(String valueCd){this.valueCd = valueCd;}
  public  String getValueCd(){return valueCd ;}
  private String valueName;//VALUE_NAME
  public  void setValueName(String valueName){this.valueName = valueName;}
  public  String getValueName(){return valueName ;}
  private String dataType;//DATA_TYPE
  public  void setDataType(String dataType){this.dataType = dataType;}
  public  String getDataType(){return dataType ;}
  private String valueDesc;//VALUE_DESC
  public  void setValueDesc(String valueDesc){this.valueDesc = valueDesc;}
  public  String getValueDesc(){return valueDesc ;}

}