package ModelLayer;

import java.util.ArrayList;

public class Group {
	private String name;
	private String job;
	private ArrayList<Person> personList;
	
	public Group(String name, String job) {
		super();
		this.name = name;
		this.job = job;
		this.personList = new ArrayList<Person>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public ArrayList<Person> getPersonList() {
		return personList;
	}

	public void addPerson(Person person) {
		personList.add(person);
	}
	
	public void removePerson(Person person) {
		personList.remove(person);
	}

}
