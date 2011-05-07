package tr.edu.ozyegin.ccrg.clustermanager;
class JobCreator {
	public static Job createJob(JobSubmissionTransaction jst) {
    if (jst.getType().equals("C")){
			return new CalculixJob(new CalculixScheduler(),(CalculixJobSubmissionTransaction)jst);
    }
		else if (jst.getType().equals("H")){
		  return new HadoopJob(new HadoopScheduler(),(HadoopJobSubmissionTransaction)jst);
		}
		else if (jst.getType().equals("W"))
			{
		    return new WekaJob(new WekaScheduler(),(WekaJobSubmissionTransaction)jst);
			}
		else
			return null;
	}
}
