package casestudy2;

import java.sql.SQLException;
import java.util.ArrayList;

import casestudy1.Student;

public class Test {
	public static void main(String[] args){
		StudentDAO student = new StudentDAO();
		try {
			ArrayList<Student> list= student.getStudents();
			System.out.println("Here is a list of Students in STUDENT_DETAIL:"+ '\n');
			for (Student s: list){
					System.out.println(s.id+":");
					System.out.println("Name: "+s.name);
					System.out.println("Subject: "+s.subject);
					System.out.println("Score: " + s.score);
					System.out.println("");
					
				}//end for
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
   
		String user = "user1";
		String pwd = "pass1";
		UserDAO u = new UserDAO();
		try {
			System.out.println("My user and password combo is in USER_DETAIL: "+u.checkValidUser(user, pwd));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
