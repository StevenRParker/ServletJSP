package casestudy1;

import java.io.Serializable;

public class Student implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public String id;

	public String name;

	public String subject;
	public int score;
	
	public Student(String id, String name, String subject, int score){
		this.id= id;
		this.name= name;
		this.subject= subject;
		this.score = score;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	

}
