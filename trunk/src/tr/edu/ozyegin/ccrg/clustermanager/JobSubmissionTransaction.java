package tr.edu.ozyegin.ccrg.clustermanager;

public class JobSubmissionTransaction {

	String type;
	
	public JobSubmissionTransaction(String string) {
		this.type = string;
	}

	String getType() {
		return this.type;
	}

}
