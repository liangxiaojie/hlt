package sra.urm.vo;

import java.text.DecimalFormat;

import com.cmbc.edw.dao.AbstractPrimaryKey;

public class DeptUserKey extends AbstractPrimaryKey {

  private static String table = "T_URM_DEPT_USER";
  private static String pk = "DEPT_ID";
  private static String format = "0000000000";
  private static int offset = 0;

  private static DeptUserKey instance = null;

  public static DeptUserKey getInstance() {
    if (instance == null) {
      instance = new DeptUserKey();
      instance.setWithoutKey(true);
    }
    return instance;
  }

  protected String buildMaxSql() {
    return "select max(" + pk + ") as CURRENT_VALUE FROM " + table;
  }

  protected String firstValue(String key) {
    return format;
  }

  protected void valueAdd(String org) {
    currentValue = new DecimalFormat(format).format(Integer.parseInt(currentValue.substring(offset)) + 1);
  }

}