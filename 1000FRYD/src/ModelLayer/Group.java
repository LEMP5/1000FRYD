package ModelLayer;

import java.util.ArrayList;

public class Group {
	private String name;
	private String type;
	private ArrayList<People> peopleList;
	
	public Group(String name) {//peopleList = new ArrayList<People>();
		this.name = name;
	}

	public void setPeopleList(ArrayList<People> peopleList) {
		this.peopleList = peopleList;
	}

	public ArrayList<People> getPeopleList() {
		return peopleList;
	}

	public void addToPeopleList(People p) {
		peopleList.add(p);
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
}