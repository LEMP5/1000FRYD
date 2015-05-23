package ModelLayer;

public class Member extends People{
	private String signUpDate;
	private String roomReserved;
	private String periodReserved;
	
	public Member(String telephoneNo, String name, String surname,
			String language, String password, boolean privilege, String email,
			String signUpDate, String roomReserved, String periodReserved) {
		super(telephoneNo, name, surname, language, password, privilege, email);
		this.signUpDate = signUpDate;
		this.roomReserved = roomReserved;
		this.periodReserved = periodReserved;
	}

	public String getSignUpDate() {
		return signUpDate;
	}

	public void setSignUpDate(String signUpDate) {
		this.signUpDate = signUpDate;
	}

	public String getRoomReserved() {
		return roomReserved;
	}

	public void setRoomReserved(String roomReserved) {
		this.roomReserved = roomReserved;
	}

	public String getPeriodReserved() {
		return periodReserved;
	}

	public void setPeriodReserved(String periodReserved) {
		this.periodReserved = periodReserved;
	}
	
}