package sra.login.service;

import java.util.Map;

import com.cmbc.edw.app.UserProfile;
import com.cmbc.edw.bs.IBizService;
import com.cmbc.edw.model.Page;

public interface ILoginService extends IBizService{

    public final static String BEAN_ID = "LoginService";

    void online(UserProfile user);

    void offline(UserProfile user);

    String login(UserProfile user);

    void setUserMenu(UserProfile user,String setCode) ;
    
    Page queryUser4Login(Map<String, String> map, int pageNo, int pageSize) ;
    
}
