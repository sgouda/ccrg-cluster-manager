package tr.edu.ozyegin.ccrg.clustermanager;
class JobCreator {
	public static Job createJob(JobSubmissionTransaction jst) {
    if (jst.getType().equals("C")){
			return new CalculixJob(CalculixScheduler.getScheduler(),(CalculixJobSubmissionTransaction)jst);
    }
		else if (jst.getType().equals("H")){
		  return new HadoopJob(HadoopScheduler.getScheduler(),(HadoopJobSubmissionTransaction)jst);
		}
		else if (jst.getType().equals("W"))
			{
		    return new WekaJob(WekaScheduler.getScheduler(),(WekaJobSubmissionTransaction)jst);
			}
		else
			return null;
	}
}
