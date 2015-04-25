package ModelLayer;

public class Member extends Person{
	private int invested;

	public Member(String name, String telephoneNo, String email, int invested) {
		super(name, telephoneNo, email);
		this.invested = invested;
	}

	public int getInvested() {
		return invested;
	}

	public void setInvested(int invested) {
		this.invested = invested;
	}

}
