package ModelLayer;

import java.util.ArrayList;

public class Employee extends Person{
	private double salary;
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

	public Employee(String name, String telephoneNo, String email, int salary) {
		super(name, telephoneNo, email);
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
}
