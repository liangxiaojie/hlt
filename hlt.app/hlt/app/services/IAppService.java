package hlt.app.services;

import java.util.List;

public interface IAppService {
  public final static String SPRINT_ID = "X104AppService";
  public List buidCatTree(String code, String sc, int ol, int ts);
}
