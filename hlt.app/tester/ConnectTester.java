package tester;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cmbc.edw.bs.AbstractBizService;


public class ConnectTester extends AbstractBizService {


	  public static Connection getMysqlConn() {
	    String url = "jdbc:mysql://localhost:3306/hlt";
	    String uid = "root";
	    String pwd = "123";
	    Connection conn = null;
	    try {
	      Class.forName("org.gjt.mm.mysql.Driver").newInstance();
	      conn = DriverManager.getConnection(url, uid, pwd);
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    return conn;
	  }
	
	  public static void testQuery () throws SQLException{
			Connection mysqlConn = getMysqlConn();
			Statement st = mysqlConn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM t_urm_user");
			rs.next();
			System.out.println(rs.getString(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getString(4));
			System.out.println(rs.getString(5));		  
	  }
	  
	public static void main(String[] args) throws SQLException {
		testQuery();
		
		
	}
	
	
}
