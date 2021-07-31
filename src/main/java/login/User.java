package login;

public class User {
	private int user;
	private String email;
	private String password;
	
	User(){
		email = "";
		password = "";
		user=0;
	}
	public User(String email, String password, int user) {
		this.email = email;
		this.password = password;
		this.user = user;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return this.email;
	} 
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return this.password;
	}
	public void setUser(int user) {
		this.user = user;
	}
	public int getUser() {
		return this.user;
	}
	
}
