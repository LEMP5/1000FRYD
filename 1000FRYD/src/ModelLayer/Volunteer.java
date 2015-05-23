package ModelLayer;

import java.util.ArrayList;

public class Volunteer extends People{
	private int bartokens;
	private boolean available;
	private boolean paid;
	private ArrayList<Experience> experienceList;
	
	public Volunteer(String telephoneNo, String name, String surname,
			String language, String password, boolean privilege, String email,
			int bartokens, boolean available, boolean paid) {
		super(telephoneNo, name, surname, language, password, privilege, email);
		this.bartokens = bartokens;
		this.available = available;
		this.paid = paid;
		experienceList = new ArrayList<Experience>();
	}
	

	public boolean isAvailable() {
		return available;
	}


	public void setAvailable(boolean available) {
		this.available = available;
	}


	public boolean isPaid() {
		return paid;
	}


	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	public ArrayList<Experience> getExperienceList() {
		return experienceList;
	}


	public void setExperienceList(ArrayList<Experience> experienceList) {
		this.experienceList = experienceList;
	}

	public void addExperience(Experience xp) {
		experienceList.add(xp);
	}
	
	public void removeExperience(Experience xp) {
		experienceList.remove(xp);
	}

	public int getBartokens() {
		return bartokens;
	}

	public void setBartokens(int bartokens) {
		this.bartokens = bartokens;
	}
}