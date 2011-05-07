package tr.edu.ozyegin.ccrg.clustermanager;
public class CalculixJobSubmissionTransaction extends JobSubmissionTransaction {

	String filename;
	int nonzero;

	public CalculixJobSubmissionTransaction(String string, String s, int i) {
		super(string);
		filename = s;
		nonzero = i;
		// TODO Auto-generated constructor stub
	}

	public String getFileName() {
		return this.filename;
	}

	public int getNonZeroElements() {
		return this.nonzero;
	}
}
