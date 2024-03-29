package tr.edu.ozyegin.ccrg.clustermanager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;

import tr.edu.ozyegin.ccrg.clustermanager.cluster.Cluster;
import tr.edu.ozyegin.ccrg.clustermanager.states.IdleState;

import com.sun.corba.se.spi.orbutil.fsm.State;

public class HadoopScheduler extends Scheduler {
  private static HadoopScheduler scheduler = null;
  private HadoopScheduler(){
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
	      Cluster.setRunningString("Hadoop job with ID " + j.getJobID());
	      //System.out.println("The hadoop job submitted with job ID " + j.getJobID() + " with priority " + j.getPriority() + "\n");
	    }
	    catch(Exception e){
	      Cluster.setRunningString("");
	      //System.out.println("There is no job to schedule on hadoop \n");
	    }
	  }
	  
	}

}
