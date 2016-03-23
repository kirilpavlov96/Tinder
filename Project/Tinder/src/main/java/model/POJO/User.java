package model.POJO;

public class User {
	private int id;
	private String username;
	private String password_hash;
	private int age;
	private int gender_id;
	private int desired_gender_id;
	private String pictures_path;
	private String avatar_path;
	private int location_id;
	private String email;
	
	public User(int id, String username, String password_hash, int age, int gender_id, int desired_gender_id,
			String pictures_path, String avatar_path, int location_id, String email) {
		this.id = id;
		this.username = username;
		this.password_hash = password_hash;
		this.age = age;
		this.gender_id = gender_id;
		this.desired_gender_id = desired_gender_id;
		this.pictures_path = pictures_path;
		this.avatar_path = avatar_path;
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

	public int getGender_id() {
		return gender_id;
	}

	public int getDesired_gender_id() {
		return desired_gender_id;
	}

	public String getPictures_path() {
		return pictures_path;
	}

	public String getAvatar_path() {
		return avatar_path;
	}

	public int getLocation_id() {
		return location_id;
	}

	public String getEmail() {
		return email;
	}
	
	
}
