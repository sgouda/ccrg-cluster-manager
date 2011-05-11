package tr.edu.ozyegin.ccrg.clustermanager;

import java.util.Collections;
import java.util.Observable;

public class CalculixScheduler extends Scheduler {
  private static CalculixScheduler scheduler = null;
  private CalculixScheduler(){
  }
  public static CalculixScheduler getScheduler(){
    if(CalculixScheduler.scheduler == null)CalculixScheduler.scheduler = new CalculixScheduler();
    return CalculixScheduler.scheduler;
  }
	@Override
	public void ScheduleAlgorithm(Job j) {
		// TODO Auto-generated method stub
	  this.jobsToSchedule.add(j);
    Collections.sort(this.jobsToSchedule);
    System.out.println("Calculix Job submitted with ID "+j.getJobID());
	}

	@Override
	public void update(Observable o, Object arg) {
		if(this.isMyTurn()){
		  Job j = null;
		  try{
		    j= this.jobsToSchedule.remove(0);
	      //System.out.println("The calculix job submitted with job ID " + j.getJobID() + " with priority " + j.getPriority()+"\n");
		  }
		  catch(Exception e){
		    //System.out.println("There is no job to schedule on calculix\n");
		  }
		}
	}

}
