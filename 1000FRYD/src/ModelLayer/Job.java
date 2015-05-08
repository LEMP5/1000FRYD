package ModelLayer;

import java.util.ArrayList;

public class Job {
	private String name;
	private int bartokens;
	private String room;
	private int dateLastUsed;
	private ArrayList<Shift> shiftList;
	
	public Job(String name, int bartokens, String room, int dateLastUsed) {
		super();
		this.name = name;
		this.bartokens = bartokens;
		this.room = room;
		this.dateLastUsed = dateLastUsed;
		shiftList = new ArrayList<Shift>();
	}
	
	public void addShift(Shift shift){
		shiftList.add(shift);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBartokens() {
		return bartokens;
	}
	public void setBartokens(int bartokens) {
		this.bartokens = bartokens;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public int getDateLastUsed() {
		return dateLastUsed;
	}
	public void setDateLastUsed(int dateLastUsed) {
		this.dateLastUsed = dateLastUsed;
	}
	

}
