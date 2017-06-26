package notebook.model;

public class User {
	private int id;
	private String fullname;
	private String username;
	private String email;
	private String password;
	private String confirmPassword;

	public User() {
	}

	public User(UserBuilder builder) {
		this.id = builder.id;
		this.fullname = builder.fullname;
		this.username = builder.username;
		this.email = builder.email;
		this.password = builder.password;
		this.confirmPassword = builder.confirmPassword;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	@Override
	public String toString() {
		return "User: " + this.fullname;
	}

	public static class UserBuilder {
		private int id;
		private String fullname;
		private String username;
		private String email;
		private String password;
		private String confirmPassword;

		public UserBuilder() {
		}
		
		public UserBuilder(String email, String password){
			this.email = email;
			this.password = password;
		}
		
		public UserBuilder id(int id) {
			this.id = id;
			return this;
		}

		public UserBuilder fullname(String fullname) {
			this.fullname = fullname;
			return this;
		}

		public UserBuilder username(String username) {
			this.username = username;
			return this;
		}

		public UserBuilder email(String email) {
			this.email = email;
			return this;
		}

		public UserBuilder password(String password) {
			this.password = password;
			return this;
		}

		public UserBuilder confirmPassword(String confirmPassword) {
			this.confirmPassword = confirmPassword;
			return this;
		}

		public User build() {
			return new User(this);
		}
	}

}
