package tr.edu.ozyegin.ccrg.clustermanager;

public class JobSubmissionTransaction {

	String type;
	private int priority = 0;
	public JobSubmissionTransaction(String string, int priority) {
	  this.priority = priority;
		this.type = string;
		
	}
	public int getPriority(){
	  return this.priority;
	}
	String getType() {
		return this.type;
	}

}
