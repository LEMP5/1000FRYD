package ModelLayer;

import java.util.ArrayList;

public class EventType {
	private String name;
	private ArrayList<Job> jobList;
	
	public EventType(String name) {
		super();
		this.name = name;
		this.jobList = new ArrayList<Job>();
	}
	
	public EventType() {
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Job> getJobList() {
		return jobList;
	}
	public void setJobList(ArrayList<Job> jobList) {
		this.jobList = jobList;
	}
	public void addShift(Job job){
		jobList.add(job);
	}
	public void removeShift(Job job){
		jobList.remove(job);
	}
}
