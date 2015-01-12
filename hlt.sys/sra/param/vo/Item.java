package sra.param.vo ;
import com.cmbc.edw.model.AbstractVO;
import java.util.Date;

public class Item extends AbstractVO{

  private String itemCd;//ITEM_CD
  public  void setItemCd(String itemCd){this.itemCd = itemCd;}
  public  String getItemCd(){return itemCd ;}
  private String itemName;//ITEM_NAME
  public  void setItemName(String itemName){this.itemName = itemName;}
  public  String getItemName(){return itemName ;}
  private Date startDt;//START_DT
  public  void setStartDt(Date startDt){this.startDt = startDt;}
  public  Date getStartDt(){return startDt ;}
  private String itemDesc;//ITEM_DESC
  public  void setItemDesc(String itemDesc){this.itemDesc = itemDesc;}
  public  String getItemDesc(){return itemDesc ;}

}