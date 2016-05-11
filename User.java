
public class User {
	
	private String username,
					password,
					name,
					lastname,
					datebirth;
	
	private int interests;
	
	public User() {
		
	}
	
	public User(String username, String password, String name, String lastname, String datebirth, int interests) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.lastname = lastname;
		this.datebirth = datebirth;
		this.interests = interests;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassw(String passw) {
		this.password = passw;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public void setDate(String date) {
		this.datebirth = date;
	}
	
	public int getInterests(){
		return this.interests;
	}
	
	public String getPass(){
		return this.password;
	}
	
	public String getFullName() {
		return this.name + " " + this.lastname;
	}
	
	public String toString() {
		String user = "Username: " + this.username + "\nName: " + this.getFullName() + "\nDate Birth: " + this.datebirth;
		return user;
	}
}
