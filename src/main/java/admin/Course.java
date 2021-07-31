package admin;

public class Course {
	private String courseid;
	private String coursename;
	private int credits;
	private int dept;
	private int sem;
	
	Course(){
		courseid = "";
		coursename = "";
		credits = 0;
		dept = 0;
		sem = 0;
	}
	Course(String courseid, String coursename, int credits, int dept, int sem){
		this.courseid = courseid;
		this.coursename = coursename;
		this.credits = credits;
		this.dept = dept;
		this.sem = sem;
	}
	
	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}
	public String getCourseid() {
		return this.courseid;
	}
	
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public String getCoursename() {
		return this.coursename;
	}
	
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public int getCredits() {
		return this.credits;
	}
	
	public void setDept(int dept) {
		this.dept = dept;
	}
	public int getDept() {
		return this.dept;
	}
	
	public void setSem(int sem) {
		this.sem = sem;
	}
	public int getSem() {
		return this.sem;
	}
}
