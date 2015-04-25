package ModelLayer;

public class Experience {
	private String job;
	private int shifts;
	public Experience(String job, int shifts) {
		super();
		this.job = job;
		this.shifts = shifts;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getShifts() {
		return shifts;
	}
	public void setShifts(int shifts) {
		this.shifts = shifts;
	}

}
