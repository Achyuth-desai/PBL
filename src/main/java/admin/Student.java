package admin;

public class Student {
	private String usn;
	private String firstname;
	private String lastname;
	private char gender;
	private String dob;
	private int dept;
	private int sem;
	
	Student(){
		usn = "";
		firstname = "";
		lastname = "";
		gender = '\0';
		dob="";
		dept=0;
		sem=0;
	}
	Student(String usn, String firstname, String lastname, char gender, String dob, int dept, int sem){
		this.usn = usn;
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.dob = dob;
		this.dept = dept;
		this.sem = sem;
	}
	
	public void setUsn(String usn) {
		this.usn = usn;
	}
	public String getUsn() {
		return this.usn;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getFirstname() {
		return this.firstname;	
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getLastname() {
		return this.lastname;	
	}
	
	public void setGender(char gender) {
		this.gender = gender;
	}
	public char getGender() {
		return this.gender;
	}
	
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getDob() {
		return this.dob;
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
