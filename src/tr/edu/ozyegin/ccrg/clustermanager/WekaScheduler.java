package tr.edu.ozyegin.ccrg.clustermanager;

import java.util.Collections;
import java.util.Observable;

import tr.edu.ozyegin.ccrg.clustermanager.states.IdleState;

public class WekaScheduler extends Scheduler {
  private static WekaScheduler scheduler = null;
  private WekaScheduler(){
  }
  public static WekaScheduler getScheduler(){
    if(WekaScheduler.scheduler == null)WekaScheduler.scheduler = new WekaScheduler();
    return WekaScheduler.scheduler;
  }
	@Override
	public void ScheduleAlgorithm(Job j) {
		// TODO Auto-generated method stub
	  this.jobsToSchedule.add(j);
    Collections.sort(this.jobsToSchedule);
    System.out.println("Weka Job submitted with ID "+j.getJobID());
	}

	@Override
	public void update(Observable o, Object arg) {
	  if(this.isMyTurn()){
      Job j = null;
      try{
        j= this.jobsToSchedule.remove(0);
        //System.out.println("The weka job submitted with job ID " + j.getJobID() + " with priority " + j.getPriority()+"\n");
      }
      catch(Exception e){
        //System.out.println("There is no job to schedule on weka \n");
      }
    }
	}
}
