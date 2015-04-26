package ModelLayer;

public class Reservation {
	private Event event;
	private Person person;
	
	public Reservation(Event event, Person person) {
		super();
		this.event = event;
		this.person = person;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	
}
