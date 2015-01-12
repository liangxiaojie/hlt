package sra.login.test;

import sra.login.service.ILoginService;

import com.cmbc.edw.spring.AbstractSpringTestCase;

public class UserServiceTest extends AbstractSpringTestCase {
  private ILoginService service;

  protected void setUp() throws Exception {
    service = (ILoginService) ctx.getBean(ILoginService.BEAN_ID);
    service.toString() ;
  }


}
