package casestudy2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;


public class UserDAO {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://us-cdbr-iron-east-04.cleardb.net/ad_05c37232add5cca";
	
	static final String USER = "b077599f12415c";
	static final String PASS = "3058f590";
	
	static Connection conn=null;
	static Statement stmt=null;
	
	UserDAO(){
		try{
			// register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//Open a connection
			//System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			System.out.println("UserDAO connected to database..."+'\n');
			stmt = conn.createStatement();
			
		}// end try
		catch (ClassNotFoundException | SQLException e){
			System.out.println(e.getClass().getName());
			System.out.println(e.getLocalizedMessage());
			e.printStackTrace();
		}//end catch
	}// end constructor
	
	
	boolean checkValidUser(String user,String pwd) throws SQLException{
		//System.out.println(userPass.get(user));
		String sql = "SELECT USER_ID, PASSWD FROM USER_DETAIL";
	    ResultSet rs = stmt.executeQuery(sql);
	    //HashMap<String, String> userPass = new HashMap<String, String>();
	    boolean isInTable = false;
	    while(rs.next()){
	         if (user.equals(rs.getString("USER_ID"))){
	        	 if (pwd.equals(rs.getString("PASSWD"))){
	        		 return true;
	        	 }
	         }
	    }//end while
	    conn.close();
		
		
		return isInTable;
	}
	

}
