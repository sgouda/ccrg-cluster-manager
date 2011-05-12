package tr.edu.ozyegin.ccrg.clustermanager;
class Job implements Comparable{

	private Scheduler scheduler;
  private int jobID = 0;
  private static int IDCounter = 0;
  private int priority = 0;
  public int getPriority(){
    return this.priority;
  }
  public int getJobID(){
    return this.jobID;
  }
	// Constructor
	public Job(Scheduler scheduler,int priority) {
		this.scheduler = scheduler;
		this.jobID = ++Job.IDCounter; 
		this.priority = priority;
	}

	public void scheduleJob() {
		scheduler.ScheduleAlgorithm(this);
	}
  @Override
  public int compareTo(Object arg0) {
    Job tmp = (Job)arg0;
    if(this.priority < tmp.priority) return -1;
    if(this.priority == tmp.priority) return 0;
    return 1;
  }
  @Override
  public String toString(){
    return "Job with ID " + this.jobID+" and priority "+this.priority;
  }
}
