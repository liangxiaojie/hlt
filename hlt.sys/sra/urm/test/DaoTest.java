package sra.urm.test;


import sra.urm.vo.Menu;
import sra.urm.vo.Mtable;

import com.cmbc.edw.dao.IIntegratedDAO;
import com.cmbc.edw.spring.AbstractSpringTestCase;
import com.cmbc.edw.spring.SpringBeansGetter;
import com.sdicons.json.mapper.MapperException;

public class DaoTest extends AbstractSpringTestCase {

  private IIntegratedDAO dao;

  protected void setUp() throws Exception {
    dao = (IIntegratedDAO) SpringBeansGetter.getBean(IIntegratedDAO.SPRING_ID);
  }

  public void testDao() throws MapperException {

    Mtable mtable = new Mtable();
    
//    mtable.setPk1(1);
//    mtable.setPk2(MtableKey.getInstance().getNextValue());
//    mtable.setFtDec(123.45);
//    mtable.setFtDate(new Date());
//    mtable.setFtInt(3);
//    dao.update("sra.urm.insertMtable", mtable);
//    
//    mtable.setPk2(MtableKey.getInstance().getNextValue());
//    dao.update("sra.urm.insertMtable", mtable);
    

//    mtable.setPk1(1);
//    mtable.setPk2("KK0005");
//    mtable.setFtInt(30);
//    dao.update("sra.urm.updateMtable", mtable);
    
//    mtable.setPk1(1);
//    mtable.setPk2("KK0004");
//    dao.update("sra.urm.deleteMtable", mtable);
    
    
    //查
//    Pagination pag = new Pagination();
//    pag.addQueryParameter("parentCode", "MA");
//    pag.setPageSize(2);
//    pag.setCurrentPage(2);
//    System.out.println(dao.query(pag,"Menu","queryMenu",Menu.class).getQueryResult());
    
    Menu param = new Menu();
    param.setMenuCode("MA");
    System.out.println(dao.getMybatisTemplate().selectOne("sra.urm.loadMenu", param)) ;
   //load 
//  Pagination pag = new Pagination();
//  pag.addQueryParameter("menuCode", "MA");
//  System.out.println(dao.load(pag,"Menu","queryMenu",Menu.class));
    
    
  }
}
