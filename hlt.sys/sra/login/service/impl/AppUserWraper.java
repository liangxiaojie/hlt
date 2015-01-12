package sra.login.service.impl;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sra.login.service.IAppUserWraper;

import com.cmbc.edw.app.UserProfile;
import com.cmbc.edw.bs.AbstractBizService;

public class AppUserWraper extends AbstractBizService implements IAppUserWraper {
  
  public UserProfile wrap(UserProfile user, HttpServletRequest request, HttpServletResponse response,
      ServletConfig servletConfig) {
    return user;
  }

}
