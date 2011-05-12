package tr.edu.ozyegin.ccrg.clustermanager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;

import tr.edu.ozyegin.ccrg.clustermanager.cluster.Cluster;
import tr.edu.ozyegin.ccrg.clustermanager.states.IdleState;

public class WekaScheduler extends Scheduler {
  private static WekaScheduler scheduler = null;
  private WekaScheduler(){
  }
  protected static ArrayList<Job> jobsToSchedule = new ArrayList<Job>();
  public static String getQueueString(){
    String result = "";
    int a = 0;
    while( a < jobsToSchedule.size()){
      result +=jobsToSchedule.toString() + "\n";
      a++;
    }
    if(a == 0)return "There is no job in the queue";
    return result;
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
        Cluster.setRunningString("Weka job with ID " + j.getJobID());
        //System.out.println("The weka job submitted with job ID " + j.getJobID() + " with priority " + j.getPriority()+"\n");
      }
      catch(Exception e){
        Cluster.setRunningString("");
        //System.out.println("There is no job to schedule on weka \n");
      }
    }
	}
}
