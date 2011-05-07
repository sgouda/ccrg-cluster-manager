package tr.edu.ozyegin.ccrg.clustermanager;
import java.io.File;
import java.util.Comparator;
import java.util.UUID;

public class WekaJob extends Job {

	private WekaJobSubmissionTransaction wJst = null;

	public WekaJob(Scheduler scheduler,WekaJobSubmissionTransaction Wjst) {
		super(scheduler);
		this.wJst = Wjst;
	}

}

