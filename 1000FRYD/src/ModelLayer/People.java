package ModelLayer;

public abstract class People {
	private String telephoneNo;
	private String name;
	private String surname;
	private String language;
	private String password;
	private boolean privilege;
	private String email;
	
	public People(String telephoneNo, String name, String surname, String language,
			String password, boolean privilege, String email) {
		this.telephoneNo = telephoneNo;
		this.name = name;
		this.surname = surname;
		this.language = language;
		this.password = password;
		this.privilege = privilege;
		this.email = email;
	}
	public String getTelephoneNo() {
		return telephoneNo;
	}
	public void setTelephoneNo(String telephoneNo) {
		this.telephoneNo = telephoneNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean getPrivilege() {
		return privilege;
	}
	public void setPrivilege(boolean privilage) {
		this.privilege = privilage;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
