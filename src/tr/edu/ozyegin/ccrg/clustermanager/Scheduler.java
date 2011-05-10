package tr.edu.ozyegin.ccrg.clustermanager;
import tr.edu.ozyegin.ccrg.clustermanager.cluster.Cluster;
import tr.edu.ozyegin.ccrg.clustermanager.states.ClusterStatus;
public interface Scheduler {
	Cluster cluster = new Cluster();
	ClusterStatus status = new ClusterStatus();
	void ScheduleAlgorithm(Job j);
	
	void update();
	
}
