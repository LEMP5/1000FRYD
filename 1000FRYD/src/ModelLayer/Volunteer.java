package ModelLayer;

import java.util.ArrayList;

public class Volunteer extends Person{
	private int bartokens;
	
	private ArrayList<Experience> experienceList;

	public ArrayList<Experience> getExperience() {
		return experienceList;
	}

	public void addExperience(Experience xp) {
		experienceList.add(xp);
	}
	
	public void removeExperience(Experience xp) {
		experienceList.remove(xp);
	}


	public Volunteer(String name, String telephoneNo, String email) {
		super(name, telephoneNo, email);
		// TODO Auto-generated constructor stub
		bartokens = 0;
	}

	public int getBartokens() {
		return bartokens;
	}

	public void setBartokens(int bartokens) {
		this.bartokens = bartokens;
	}
	
}
