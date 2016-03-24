package model.POJO;

public class User {
	private int id;
	private String username;
	private String passwordHash;
	private int age;
	private boolean genderIsMale;
	private String avatarName;
	private String email;
	private boolean wantsMale;
	private boolean wantsFemale;
	private double latitude;
	private double longitude;

	public User(int id, String username, String passwordHash, int age, boolean genderIsMale, String avatarName,
			String email, boolean wantsMale, boolean wantsFemale, double latitude, double longitude) {
		super();
		this.id = id;
		this.username = username;
		this.passwordHash = passwordHash;
		this.age = age;
		this.genderIsMale = genderIsMale;
		this.avatarName = avatarName;
		this.email = email;
		this.wantsMale = wantsMale;
		this.wantsFemale = wantsFemale;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getAvatarName() {
		return avatarName;
	}

	public void setAvatarName(String avatarName) {
		this.avatarName = avatarName;
	}

	public boolean isWantsMale() {
		return wantsMale;
	}

	public void setWantsMale(boolean wantsMale) {
		this.wantsMale = wantsMale;
	}

	public boolean isWantsFemale() {
		return wantsFemale;
	}

	public void setWantsFemale(boolean wantsFemale) {
		this.wantsFemale = wantsFemale;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public int getAge() {
		return age;
	}

	public boolean isGenderIsMale() {
		return genderIsMale;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", passwordHash=" + passwordHash + ", age=" + age
				+ ", genderIsMale=" + genderIsMale + ", avatarName=" + avatarName + ", email=" + email + ", wantsMale="
				+ wantsMale + ", wantsFemale=" + wantsFemale + ", latitude=" + latitude + ", longitude=" + longitude
				+ "]";
	}

}