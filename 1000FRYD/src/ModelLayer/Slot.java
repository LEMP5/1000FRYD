package ModelLayer;

public class Slot {
	private Group group;
	private Person person;
	
	public Slot(Group group, Person person) {
		super();
		this.group = group;
		this.person = person;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
}
