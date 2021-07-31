package admin;

public class Faculty {
	private String facultyid;
	private String firstname;
	private String lastname;
	private int dept;
	
	Faculty(){
		facultyid = "";
		firstname = "";
		lastname = "";
		dept = 0;
	}
	Faculty(String facultyid, String firstname, String lastname, int dept){
		this.facultyid = facultyid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.dept = dept;
	}
	
	public void setFacultyid(String facultyid) {
		this.facultyid = facultyid;
	}
	public String getFacultyid() {
		return this.facultyid;
	}
	
	public void setfirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getfirstname() {
		return this.firstname;
	}
	
	public void setlastname(String lastname) {
		this.lastname = lastname;
	}
	public String getlastname() {
		return this.lastname;
	}
	
	public void setDept(int dept) {
		this.dept = dept;
	}
	public int getDept() {
		return this.dept;
	}
}
