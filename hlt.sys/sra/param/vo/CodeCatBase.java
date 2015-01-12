package sra.param.vo ;
import com.cmbc.edw.model.AbstractVO;
import java.util.Date;

public class CodeCatBase extends AbstractVO{

  private String catCode;//CAT_CODE
  public  void setCatCode(String catCode){this.catCode = catCode;}
  public  String getCatCode(){return catCode ;}
  private String catName;//CAT_NAME
  public  void setCatName(String catName){this.catName = catName;}
  public  String getCatName(){return catName ;}
  private String catMemo;//CAT_MEMO
  public  void setCatMemo(String catMemo){this.catMemo = catMemo;}
  public  String getCatMemo(){return catMemo ;}

}