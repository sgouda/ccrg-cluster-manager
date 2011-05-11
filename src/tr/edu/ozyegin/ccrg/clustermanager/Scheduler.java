package tr.edu.ozyegin.ccrg.clustermanager;
import java.util.Observable;
import java.util.Observer;

import tr.edu.ozyegin.ccrg.clustermanager.cluster.Cluster;
import tr.edu.ozyegin.ccrg.clustermanager.states.ClusterStatus;
public class Scheduler implements Observer{
	Cluster cluster = null;
	ClusterStatus status = null;
	public Scheduler(){
	  cluster = Cluster.getSingletonCluster();
	  status = cluster.getStatus();
	  this.status.addObserver(this);
	}
	void ScheduleAlgorithm(Job j) {
  }

  @Override
  public void update(Observable o, Object arg) {
    // TODO Auto-generated method stub
    
  }
	
}
