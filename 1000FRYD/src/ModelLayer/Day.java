package ModelLayer;

import java.util.ArrayList;

public class Day {
	private int day;
	private int month;
	private int year;
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
		year = Integer.parseInt(date.substring(0, 3));
		month = Integer.parseInt(date.substring(5, 6));
		day = Integer.parseInt(date.substring(8, 9));
	}
	public Day() {
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
		year = Integer.parseInt(date.substring(0, 3));
		month = Integer.parseInt(date.substring(5, 6));
		day = Integer.parseInt(date.substring(8, 9));
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
	public int getDay() {
		return day;
	}
	public int getMonth() {
		return month;
	}
	public int getYear() {
		return year;
	}
	

}
