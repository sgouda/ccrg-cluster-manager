package tr.edu.ozyegin.ccrg.clustermanager;
import java.util.Observable;
import java.util.Observer;

import tr.edu.ozyegin.ccrg.clustermanager.cluster.Cluster;
import tr.edu.ozyegin.ccrg.clustermanager.states.ClusterStatus;
public class Scheduler implements Observer{
	Cluster cluster = new Cluster();
	ClusterStatus status = new ClusterStatus();
	public Scheduler(){
	  this.status.addObserver(this);
	}
	void ScheduleAlgorithm(Job j) {
  }

  @Override
  public void update(Observable o, Object arg) {
    // TODO Auto-generated method stub
    
  }
	
}
