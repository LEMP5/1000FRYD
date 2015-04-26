package ModelLayer;

import java.util.ArrayList;

public class Volunteer extends Person{
	private int bartokens;
	private boolean paid;
	private boolean available;
	
	private ArrayList<Experience> experienceList;

	public ArrayList<Experience> getExperience() {
		return experienceList;
	}
	
	private Experience hasExperience(String job)
	{
		for(Experience xp: experienceList)
		{
			if(xp.getJob().equals(job))
				return xp;
		}
		return null;
	}

	public void addExperience(String job) {
		Experience xp = hasExperience(job);
		if(xp!=null)
			xp.setShifts(xp.getShifts()+1);
		else
			experienceList.add(xp);
	}
	
	public void removeExperience(String job) {
		Experience xp = hasExperience(job);
		if(xp!=null)
			xp.setShifts(xp.getShifts()-1);
		else
			System.out.println("No shifts to remove");
	}


	public Volunteer(String name, String telephoneNo, String email) {
		super(name, telephoneNo, email);
		// TODO Auto-generated constructor stub
		bartokens = 0;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public int getBartokens() {
		return bartokens;
	}

	public void setBartokens(int bartokens) {
		this.bartokens = bartokens;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}
	
	
}
