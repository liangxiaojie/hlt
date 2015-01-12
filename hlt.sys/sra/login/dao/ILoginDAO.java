package sra.login.dao;

import sra.login.vo.OnlineRecBO;

import com.cmbc.edw.dao.IIntegratedDAO;

public interface ILoginDAO extends IIntegratedDAO {

  public void onlineRec(OnlineRecBO bo);

}
