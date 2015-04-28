package ModelLayer;

public class Member extends People{
	private String signUpDate;
	private String roomReserved;
	private int daysReserved;


	public Member(String name, String surname, String telephoneNo, String email,
			String signUpDate, String roomReserved, int daysReserved) {
		super(name, surname, telephoneNo, email);
		this.signUpDate = signUpDate;
		this.roomReserved = roomReserved;
		this.daysReserved = daysReserved;
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

	public int getDaysReserved() {
		return daysReserved;
	}

	public void setDaysReserved(int daysReserved) {
		this.daysReserved = daysReserved;
	}

	
}
