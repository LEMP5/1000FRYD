package ModelLayer;

public class Shift {
	private String job;
	private int startHour;
	private int endHour;
	private Person worker;
	private int xpRequired;
	
	public Shift(String job, int startHour, int endHour, Person worker) {
		super();
		this.job = job;
		this.startHour = startHour;
		this.endHour = endHour;
		this.worker = worker;
	}
	
	
	public int getXpRequired() {
		return xpRequired;
	}
	public void setXpRequired(int xpRequired) {
		this.xpRequired = xpRequired;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
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
	public Person getWorker() {
		return worker;
	}
	public void setWorker(Person worker) {
		this.worker = worker;
	}
	

}
