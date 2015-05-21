package ModelLayer;

import java.util.ArrayList;

public class Day {
	private String date;
	private String dayOfWeek;
	private ArrayList<Shift> shiftList;
	private ArrayList<Event> eventList;
	
	public Day(String date, String dayOfWeek) {
		super();
		this.date = date;
		this.dayOfWeek = dayOfWeek;
		this.shiftList = new ArrayList<Shift>();
		this.eventList = new ArrayList<Event>();
	}
	public Day() {
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	public ArrayList<Shift> getShiftList() {
		return shiftList;
	}
	public void setShiftList(ArrayList<Shift> shiftList) {
		this.shiftList = shiftList;
	}
	public ArrayList<Event> getEventList() {
		return eventList;
	}
	public void setEventList(ArrayList<Event> eventList) {
		this.eventList = eventList;
	}
	

}
