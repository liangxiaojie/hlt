package sra.urm.vo ;
import java.util.ArrayList;
import java.util.List;

import com.cmbc.edw.model.AbstractVO;

public class MenuBase extends AbstractVO{

  private String menuCode;//MENU_CODE
  public  void setMenuCode(String menuCode){this.menuCode = menuCode;}
  public  String getMenuCode(){return menuCode ;}
  private String menuName;//MENU_NAME
  public  void setMenuName(String menuName){this.menuName = menuName;}
  public  String getMenuName(){return menuName ;}
  private String menuUrl;//MENU_URL
  public  void setMenuUrl(String menuUrl){this.menuUrl = menuUrl;}
  public  String getMenuUrl(){return menuUrl ;}
  private String parentCode;//PARENT_CODE
  public  void setParentCode(String parentCode){this.parentCode = parentCode;}
  public  String getParentCode(){return parentCode ;}
  private int menuOrder;//MENU_ORDER
  public  void setMenuOrder(int menuOrder){this.menuOrder = menuOrder;}
  public  int getMenuOrder(){return menuOrder ;}
  private String extConfig;//EXT_CONFIG
  public  void setExtConfig(String extConfig){this.extConfig = extConfig;}
  public  String getExtConfig(){return extConfig ;}
  private String menuDesc;//MENU_DESC
  public  void setMenuDesc(String menuDesc){this.menuDesc = menuDesc;}
  public  String getMenuDesc(){return menuDesc ;}
  List <MenuBase>children = new ArrayList<MenuBase>();
  public List<MenuBase> getChildren() {return children;}
  public void setChildren(List<MenuBase> children) {this.children = children;}
}