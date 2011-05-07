public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JobSubmissionTransaction jstC = new CalculixJobSubmissionTransaction("C", "/usr/local", 7);
		JobSubmissionTransaction jstH = new JobSubmissionTransaction("H");
		JobSubmissionTransaction jstW = new JobSubmissionTransaction("W");

		JobCreator jobcreator = new JobCreator();
		
		Job j = jobcreator.createJob(jstC);
		j.scheduleJob();
		
		j = jobcreator.createJob(jstW);
		j.scheduleJob();
		
		Job j1 = jobcreator.createJob(jstH);
		j1.scheduleJob();
		
		Job j2 = jobcreator.createJob(jstW);
		j2.scheduleJob();
		
	}

}
