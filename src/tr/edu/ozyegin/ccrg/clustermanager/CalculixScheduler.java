package tr.edu.ozyegin.ccrg.clustermanager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;

import tr.edu.ozyegin.ccrg.clustermanager.cluster.Cluster;

public class CalculixScheduler extends Scheduler {
  private static CalculixScheduler scheduler = null;
  private CalculixScheduler(){
  }
  public static CalculixScheduler getScheduler(){
    if(CalculixScheduler.scheduler == null)CalculixScheduler.scheduler = new CalculixScheduler();
    return CalculixScheduler.scheduler;
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
		    Cluster.setRunningString("Calculix job with ID " + j.getJobID());
	      //System.out.println("The calculix job submitted with job ID " + j.getJobID() + " with priority " + j.getPriority()+"\n");
		  }
		  catch(Exception e){
		    Cluster.setRunningString("");
		    //System.out.println("There is no job to schedule on calculix\n");
		  }
		}
	}

}
