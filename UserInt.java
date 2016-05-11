
public class UserInt {
	
	private String username,
					password,
					name,
					lastname,
					datebirth;
	
	public UserInt() {
		
	}
	
	public UserInt(String username, String password, String name, String lastname, String datebirth) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.lastname = lastname;
		this.datebirth = datebirth;
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
}
