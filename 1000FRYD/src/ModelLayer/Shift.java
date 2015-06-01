package ModelLayer;

public class Shift {
	private int id;
	private Job job;
	private int startHour;
	private int endHour;
	private People worker;
	private int xpRequired;
	
	public Shift(int id, Job job, int startHour, int endHour, People worker) {
		super();
		this.id = id;
		this.job = job;
		this.startHour = startHour;
		this.endHour = endHour;
		this.worker = worker;
	}
	
	public Shift() {
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getXpRequired() {
		return xpRequired;
	}
	public void setXpRequired(int xpRequired) {
		this.xpRequired = xpRequired;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
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
	public People getWorker() {
		return worker;
	}
	public void setWorker(People worker) {
		this.worker = worker;
	}
	

}
