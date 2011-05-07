package tr.edu.ozyegin.ccrg.clustermanager;
class Job {

	private Scheduler scheduler;

	// Constructor
	public Job(Scheduler scheduler) {
		this.scheduler = scheduler;
	}

	public void scheduleJob() {
		scheduler.ScheduleAlgorithm(this);
	}
}
