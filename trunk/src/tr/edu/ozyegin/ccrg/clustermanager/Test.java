package tr.edu.ozyegin.ccrg.clustermanager;
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JobSubmissionTransaction jstC = new CalculixJobSubmissionTransaction("C", "/usr/local", 7,5);
		JobSubmissionTransaction jstH = new HadoopJobSubmissionTransaction("H","/usr/local/hadoop/Try1.jar","In","Out",10,10,4);
		
		JobSubmissionTransaction jstW = new WekaJobSubmissionTransaction("W",6);
		
		JobSubmissionTransaction jstC2 = new CalculixJobSubmissionTransaction("C", "/usr/local", 7,3);
    JobSubmissionTransaction jstH2 = new HadoopJobSubmissionTransaction("H","/usr/local/hadoop/Try1.jar","In","Out",10,10,1);
    
    JobSubmissionTransaction jstW2 = new WekaJobSubmissionTransaction("W",5);
    
    JobSubmissionTransaction jstC3 = new CalculixJobSubmissionTransaction("C", "/usr/local", 7,10);
    JobSubmissionTransaction jstH3 = new HadoopJobSubmissionTransaction("H","/usr/local/hadoop/Try1.jar","In","Out",10,10,2);
    
    JobSubmissionTransaction jstW3 = new WekaJobSubmissionTransaction("W",1);

		JobCreator jobcreator = new JobCreator();
		
		Job j = jobcreator.createJob(jstC);
		j.scheduleJob();
		
		j = jobcreator.createJob(jstW);
		j.scheduleJob();
		
		Job j1 = jobcreator.createJob(jstH);
		j1.scheduleJob();
		
		Job j2 = jobcreator.createJob(jstW);
		j2.scheduleJob();
		j = jobcreator.createJob(jstC2);
    j.scheduleJob();
    
    j = jobcreator.createJob(jstW2);
    j.scheduleJob();
    
    j1 = jobcreator.createJob(jstH2);
    j1.scheduleJob();
    
    j2 = jobcreator.createJob(jstW2);
    j2.scheduleJob();
    
    j = jobcreator.createJob(jstC3);
    j.scheduleJob();
    
    j = jobcreator.createJob(jstW3);
    j.scheduleJob();
    
    j1 = jobcreator.createJob(jstH3);
    j1.scheduleJob();
    
    j2 = jobcreator.createJob(jstW3);
    j2.scheduleJob();
    Shell shell = Shell.getInstance();
    shell.getCursor();
		System.exit(0);
	}

}
