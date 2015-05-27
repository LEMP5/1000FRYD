package ModelLayer;

import java.util.ArrayList;

public class Job {
	private String name;
	private int bartokens;
	private String room;
	private int duration;
	private ArrayList<Shift> shiftList;
	
	public Job(String name, int bartokens, String room, int duration) {
		super();
		this.name = name;
		this.bartokens = bartokens;
		this.room = room;
		this.duration = duration;
		shiftList = new ArrayList<Shift>();
	}
	
	public Job() {
		
	}
	
	public ArrayList<Shift> getShiftList(){
		return shiftList;
	}
	public void addShift(Shift shift){
		shiftList.add(shift);
	}
	public void removeShift(Shift shift){
		shiftList.remove(shift);
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public void setShiftList(ArrayList<Shift> shiftList) {
		this.shiftList = shiftList;
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
}
