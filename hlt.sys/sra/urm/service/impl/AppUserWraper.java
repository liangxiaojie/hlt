﻿package sra.urm.service.impl;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmbc.edw.app.UserProfile;
import com.cmbc.edw.bs.AbstractBizService;
import sra.urm.service.IAppUserWraper;

public class AppUserWraper extends AbstractBizService implements IAppUserWraper {
  public UserProfile wrap(UserProfile user, HttpServletRequest request, HttpServletResponse response,
      ServletConfig servletConfig) {
    return user;
  }

}
