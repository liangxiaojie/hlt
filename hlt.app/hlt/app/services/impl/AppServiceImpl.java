package hlt.app.services.impl;

import java.util.List;


import com.cmbc.edw.bs.AbstractBizService;
import com.cmbc.edw.codestring.CodeStringManager;

import hlt.app.services.IAppService;

public class AppServiceImpl extends AbstractBizService implements IAppService {
  
  public List buidCatTree(String code, String sc, int ol, int ts) {
    return CodeStringManager.buidCatTree(code, sc, ol, ts);
  }

}
