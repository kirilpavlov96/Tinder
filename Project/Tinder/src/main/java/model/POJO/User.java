package model.POJO;

public class User {
	private int id;
	private String username;
	private String passwordHash;
	private int age;
	private boolean genderIsMale;
	private String avatarName;
	private int locationId;
	private String email;
	private boolean wantsMale;
	private boolean wantsFemale;
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", passwordHash=" + passwordHash + ", age=" + age
				+ ", genderIsMale=" + genderIsMale + ", avatarName=" + avatarName + ", locationId=" + locationId
				+ ", email=" + email + ", wantsMale=" + wantsMale + ", wantsFemale=" + wantsFemale + "]";
	}
	public User(int id, String username, String passwordHash, int age, boolean genderIsMale, String avatarName,
			int locationId, String email, boolean wantsMale, boolean wantsFemale) {
		super();
		this.id = id;
		this.username = username;
		this.passwordHash = passwordHash;
		this.age = age;
		this.genderIsMale = genderIsMale;
		this.avatarName = avatarName;
		this.locationId = locationId;
		this.email = email;
		this.wantsMale = wantsMale;
		this.wantsFemale = wantsFemale;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
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
	public String getAvatarName() {
		return avatarName;
	}
	public String getEmail() {
		return email;
	}
	
}