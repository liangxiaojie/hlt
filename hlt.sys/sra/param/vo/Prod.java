package sra.param.vo ;
import com.cmbc.edw.model.AbstractVO;
import java.util.Date;

public class Prod extends AbstractVO{

  private String prodCd;//PROD_CD
  public  void setProdCd(String prodCd){this.prodCd = prodCd;}
  public  String getProdCd(){return prodCd ;}
  private String prodName;//PROD_NAME
  public  void setProdName(String prodName){this.prodName = prodName;}
  public  String getProdName(){return prodName ;}
  private String fromApp;//FROM_APP
  public  void setFromApp(String fromApp){this.fromApp = fromApp;}
  public  String getFromApp(){return fromApp ;}
  private Date startDt;//START_DT
  public  void setStartDt(Date startDt){this.startDt = startDt;}
  public  Date getStartDt(){return startDt ;}

}