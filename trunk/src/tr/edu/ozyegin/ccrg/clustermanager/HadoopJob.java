package tr.edu.ozyegin.ccrg.clustermanager;
import java.io.File;
import java.util.Comparator;
import java.util.UUID;

public class HadoopJob extends Job {

	String filename;
	int nonZero;
	int threadCount;
	UUID uuid;

	public HadoopJob(Scheduler scheduler,HadoopJobSubmissionTransaction Hjst) {
		super(scheduler);
		
	}

	public int getNonZeroElementCount() {
		return nonZero;
	}

	public int getThreadCount() {
		return threadCount;
	}

	public void printNonZeroElements() {
		// System.out.println(nonZero + " from Job Class");
	}

	double getMemoryNeed() {
		// is 0.15 good??? 0.13 seems better
		// System.out.println("The Memory Need in KBs is "+0.13*this.nonZero);
		return 0.13 * this.nonZero;
	}

}

