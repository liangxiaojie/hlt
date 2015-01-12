package hlt.app.services;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmbc.edw.app.UserProfile;

public interface IAppUserWraper {
  public final static String SPRINT_ID = "ddsUserWraper";

  UserProfile wrap(UserProfile user, HttpServletRequest request, HttpServletResponse response, ServletConfig servletConfig);

}
