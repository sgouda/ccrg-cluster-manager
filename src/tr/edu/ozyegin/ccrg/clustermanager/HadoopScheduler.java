package tr.edu.ozyegin.ccrg.clustermanager;

import java.util.Collections;
import java.util.Observable;

public class HadoopScheduler extends Scheduler {
  private static HadoopScheduler scheduler = null;
  private HadoopScheduler(){
  }
  public static HadoopScheduler getScheduler(){
    if(HadoopScheduler.scheduler == null)HadoopScheduler.scheduler = new HadoopScheduler();
    return HadoopScheduler.scheduler;
  }
	@Override
	public void ScheduleAlgorithm(Job j) {
		// TODO Auto-generated method stub
	  this.jobsToSchedule.add(j);
	  Collections.sort(this.jobsToSchedule);
		System.out.println("Hadoop Job submitted with ID "+j.getJobID());
	}

	@Override
	public void update(Observable o, Object arg) {
	  if(this.isMyTurn()){
      Job j = null;
      try{
        j= this.jobsToSchedule.remove(0);
        System.out.println("The hadoop job submitted with job ID " + j.getJobID() + " with priority " + j.getPriority() + "\n");
      }
      catch(Exception e){
        System.out.println("There is no job to schedule on hadoop \n");
      }
    }
	}

}
