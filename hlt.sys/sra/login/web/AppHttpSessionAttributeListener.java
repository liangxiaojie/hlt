package sra.login.web;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.apache.log4j.Logger;

import sra.login.service.ILoginService;

import com.cmbc.edw.app.UserProfile;
import com.cmbc.edw.spring.SpringBeansGetter;
import com.cmbc.edw.web.cmd.AbstractCommand;

/**
 * 监控用户上线下线情况
 * @author dunkee
 */
public class AppHttpSessionAttributeListener implements HttpSessionAttributeListener {

  private Logger log = Logger.getLogger(this.getClass());
  private static ILoginService bs = null;

  public ILoginService getBs() {
    if (bs != null) return bs;
    bs = (ILoginService) SpringBeansGetter.getBean(ILoginService.BEAN_ID);
    return bs;
  }

  public void attributeAdded(HttpSessionBindingEvent event) {
    log.info("attributeAdded:" + event.getName() + "=" + event.getValue());
    if (AbstractCommand.USER_SESSION_KEY.equals(event.getName())) {
      getBs().online(((UserProfile) event.getValue()));
    }
  }

  public void attributeRemoved(HttpSessionBindingEvent event) {
    log.info("attributeRemoved:" + event.getName() + "=" + event.getValue());
    if (AbstractCommand.USER_SESSION_KEY.equals(event.getName())) {
      getBs().offline(((UserProfile) event.getValue()));
    }
  }

  public void attributeReplaced(HttpSessionBindingEvent arg0) {

  }

}