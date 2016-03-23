package model.POJO;

public class User {
	private int id;
	private String username;
	private String password_hash;
	private int age;
	private boolean gender_is_male;
	private String avatar_name;
	private int location_id;
	private String email;
	
	public User(int id, String username, String password_hash, int age, boolean gender_is_male,
			String avatar_name, int location_id, String email) {
		super();
		this.id = id;
		this.username = username;
		this.password_hash = password_hash;
		this.age = age;
		this.gender_is_male = gender_is_male;
		this.avatar_name = avatar_name;
		this.location_id = location_id;
		this.email = email;
	}
	
	public int getId() {
		return id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword_hash() {
		return password_hash;
	}
	
	public int getAge() {
		return age;
	}
	
	public boolean isGender_is_male() {
		return gender_is_male;
	}
	
	public String getAvatar_name() {
		return avatar_name;
	}
	
	public int getLocation_id() {
		return location_id;
	}
	
	public String getEmail() {
		return email;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password_hash=" + password_hash + ", age=" + age
				+ ", gender_is_male=" + gender_is_male + ", avatar_name=" + avatar_name + ", location_id=" + location_id
				+ ", email=" + email + "]";
	}
}