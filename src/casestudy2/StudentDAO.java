package casestudy2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import casestudy1.Student;

public class StudentDAO {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://us-cdbr-iron-east-04.cleardb.net/ad_05c37232add5cca";
	
	static final String USER = "b077599f12415c";
	static final String PASS = "3058f590";
	
	static Connection conn=null;
	static Statement stmt=null;
	
	public StudentDAO(){

		try{
			// register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//Open a connection
			
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			System.out.println("StudentDAO connected to database..."+'\n');
			stmt = conn.createStatement();
		
		}// end try
		catch (ClassNotFoundException | SQLException e){
			System.out.println(e.getClass().getName());
			System.out.println(e.getLocalizedMessage());
			e.printStackTrace();
		}//end catch
	}// end constructor
	
	public ArrayList<Student> getStudents() throws SQLException{
	      //Step 5:Extract data from result set
		
		String sql = "SELECT STUDENT_ID, NAME, SUBJECT, SCORE FROM STUDENT_DETAIL";
	      ResultSet rs = stmt.executeQuery(sql);
	      ArrayList<Student> list= new ArrayList<Student>();
	      
	      while(rs.next()){
	         //Retrieve by column name
	         String student_id  = rs.getString("STUDENT_ID");
	          String name = rs.getString("NAME");
	         String subject = rs.getString("SUBJECT");
	         int score = rs.getInt("SCORE");
	         Student s = new Student(student_id, name, subject, score);
	         list.add(s);
	      }//end while
	      rs.close();
	      conn.close();
	    
	     return list;
	}//end getStudents
	
	

}//end class
