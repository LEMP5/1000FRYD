package ModelLayer;

import java.util.ArrayList;

public class Group {
	private String name;
	private String type;
	private ArrayList<People> personList;
	
	public Group(String name, String job) {
		super();
		this.name = name;
		this.type = job;
		this.personList = new ArrayList<People>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ArrayList<People> getPersonList() {
		return personList;
	}

	public void addPerson(People people) {
		personList.add(people);
	}
	
	public void removePerson(People people) {
		personList.remove(people);
	}

}
