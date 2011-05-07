package tr.edu.ozyegin.ccrg.clustermanager;
class JobCreator {
	public static Job createJob(JobSubmissionTransaction jst) {
		if (jst.getType().equals("C"))
			return new Job(new CalculixScheduler());
		else if (jst.getType().equals("H"))
			return new Job(new HadoopScheduler());
		else if (jst.getType().equals("W"))
			return new Job(new WekaScheduler());
		else
			return null;
	}
}
