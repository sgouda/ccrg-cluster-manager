package tr.edu.ozyegin.ccrg.clustermanager;

public class WekaJob extends Job {

	private WekaJobSubmissionTransaction wJst = null;

	public WekaJobSubmissionTransaction getwJst() {
		return wJst;
	}

	public void setwJst(WekaJobSubmissionTransaction wJst) {
		this.wJst = wJst;
	}

	public WekaJob(Scheduler scheduler,WekaJobSubmissionTransaction Wjst) {
		super(scheduler,Wjst.getPriority());
		this.wJst = Wjst;
	}

}

