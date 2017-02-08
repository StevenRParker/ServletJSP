package casestudy1;

import java.util.*;

public class StudentArray {

	public static void main(String[] args){
		Student S0 = new Student("0", "Stevie", "Math", 100);
		Student S1 = new Student("1", "Lauren", "History", 100);
		Student S2 = new Student("2", "Blair", "Physics", 100);
		
		ArrayList<Student> A= new ArrayList<Student>();
		A.add(S0);
		A.add(S1);
		A.add(S2);
		
		for (Student S: A){
			System.out.println("Student"+S.id+":");
			System.out.println("Name: "+S.name);
			System.out.println("Subject: "+S.subject);
			System.out.println("Score: " + S.score);
			System.out.println("");
			
		}
		
		
		
	}
	
	
}
