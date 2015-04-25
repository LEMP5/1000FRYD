package ModelLayer;

import java.util.ArrayList;

public class Event {
	private int id;
	private String name;
	private String description;
	private int startHour;
	private int endHour;
	private ArrayList<Event> eventList;
	
	public Event(int id, String name, String description, int startHour,
			int endHour) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.startHour = startHour;
		this.endHour = endHour;
		eventList = new ArrayList<Event>();
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getStartHour() {
		return startHour;
	}
	public void setStartHour(int startHour) {
		this.startHour = startHour;
	}
	public int getEndHour() {
		return endHour;
	}
	public void setEndHour(int endHour) {
		this.endHour = endHour;
	}
	
	
}
