package ModelLayer;

public class Person {
	private String name;
	private String surname;
	private String telephoneNo;
	private String email;
	public Person(String name, String telephoneNo, String email) {
		super();
		this.name = name;
		this.telephoneNo = telephoneNo;
		this.email = email;
	}
	
	
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelephoneNo() {
		return telephoneNo;
	}
	public void setTelephoneNo(String telephoneNo) {
		this.telephoneNo = telephoneNo;
	}
	public String getEmail() {
		return email;
	}
	
}
