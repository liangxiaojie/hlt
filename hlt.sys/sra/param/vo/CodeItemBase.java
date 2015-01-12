package sra.param.vo ;
import com.cmbc.edw.model.AbstractVO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CodeItemBase extends AbstractVO{

  private String catCode;//CAT_CODE
  public  void setCatCode(String catCode){this.catCode = catCode;}
  public  String getCatCode(){return catCode ;}
  private String itemCode;//ITEM_CODE
  public  void setItemCode(String itemCode){this.itemCode = itemCode;}
  public  String getItemCode(){return itemCode ;}
  private String itemName;//ITEM_NAME
  public  void setItemName(String itemName){this.itemName = itemName;}
  public  String getItemName(){return itemName ;}
  private int itemSeq;//ITEM_SEQ
  public  void setItemSeq(int itemSeq){this.itemSeq = itemSeq;}
  public  int getItemSeq(){return itemSeq ;}
  private String upperCode;//UPPER_CODE
  public  void setUpperCode(String upperCode){this.upperCode = upperCode;}
  public  String getUpperCode(){return upperCode ;}
  private String itemMemo;//ITEM_MEMO
  public  void setItemMemo(String itemMemo){this.itemMemo = itemMemo;}
  public  String getItemMemo(){return itemMemo ;}
  List <CodeItemBase>children = new ArrayList<CodeItemBase>();
  public List<CodeItemBase> getChildren() {return children;}
  public void setChildren(List<CodeItemBase> children) {this.children = children;}

}