package module;

public class User {

	private String userName;
	private String userPassword;
	private String userRole;
	
	public User()
	{
		
	}
	
	
	public User(String userName, String userPassword, String userRole) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.userRole = userRole;
	}


	public String getUserName() {
		return userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public String getUserRole() {
		return userRole;
	}

	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
