package tr.edu.ozyegin.ccrg.clustermanager;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import tr.edu.ozyegin.ccrg.clustermanager.cluster.Cluster;
import tr.edu.ozyegin.ccrg.clustermanager.states.ClusterStatus;
public class Scheduler implements Observer{
	Cluster cluster = null;
	ClusterStatus status = null;
	protected ArrayList<Job> jobsToSchedule = new ArrayList<Job>();
	protected static int round = 0;
	protected static int noOfInstances = 0;
	protected int myInstanceID = Scheduler.noOfInstances;
	protected static short roundCounter = 0;

	public Scheduler(){
	  cluster = Cluster.getSingletonCluster();
	  status = cluster.getStatus();
	  this.status.addObserver(this);
	  Scheduler.noOfInstances++;
	}
	void ScheduleAlgorithm(Job j) {
  }
  protected boolean isMyTurn(){
    if(Scheduler.round == Integer.MAX_VALUE)Scheduler.round = Integer.MAX_VALUE % Scheduler.noOfInstances;
    
    boolean flag = false;
    if(Scheduler.roundCounter == Scheduler.noOfInstances){
      Scheduler.round++;
      Scheduler.roundCounter = 1;
    }
    else Scheduler.roundCounter++;
    
    boolean result = (Scheduler.round % Scheduler.noOfInstances == this.myInstanceID)?true:false;
    
    //System.out.println("round "+Scheduler.round + " Instance ID" + this.myInstanceID + " roundCounter "+Scheduler.roundCounter);
   return result;
  }
  @Override
  public void update(Observable o, Object arg) {
    // TODO Auto-generated method stub
    
  }
	
}
