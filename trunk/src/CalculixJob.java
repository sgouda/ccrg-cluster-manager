import java.io.File;
import java.util.Comparator;
import java.util.UUID;

public class CalculixJob extends Job {

	String filename;
	int nonZero;
	int threadCount;
	UUID uuid;

	public CalculixJob(Scheduler scheduler, String f_name, int n) {
		super(scheduler);
		// TODO Auto-generated constructor stub
		 filename = f_name;
		uuid = UUID.randomUUID();
		 nonZero = n;
		if (nonZero <= 1000000) {
			threadCount = 1;
		} else if (nonZero > 1000000 && nonZero <= 10000000) {
			threadCount = 2;
		} else if (nonZero > 10000000 && nonZero <= 100000000) {
			threadCount = 4;
		} else if (nonZero > 100000000) {
			threadCount = 8;
		}
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

class JobComparator implements Comparator<CalculixJob> {

	// Overriding the compare method to sort according the non-zero elements
	public int compare(CalculixJob j1, CalculixJob j2) {

		int j1NZ = j1.getNonZeroElementCount();
		int j2NZ = j2.getNonZeroElementCount();

		if (j1NZ < j2NZ) {
			return -1;
		} else if (j1NZ > j2NZ) {
			return 1;
		} else
			return 0;
	}

}
