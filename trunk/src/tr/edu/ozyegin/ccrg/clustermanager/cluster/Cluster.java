package tr.edu.ozyegin.ccrg.clustermanager.cluster;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;

import tr.edu.ozyegin.ccrg.clustermanager.states.ClusterState;
import tr.edu.ozyegin.ccrg.clustermanager.states.ClusterStatus;
import tr.edu.ozyegin.ccrg.clustermanager.states.IdleState;


//Observable pattern is applied via java.util.Observable 
public class Cluster extends Observable implements Runnable{

	private List<Node> nodes = null; // the relation is one to many and
										// aggregation
	private ClusterStatus status = new ClusterStatus();
  public ClusterStatus getStatus(){
    return this.status;
  }
  private static Cluster singeletonCluster = null;
  public static Cluster getSingletonCluster() {
    if(Cluster.singeletonCluster==null) Cluster.singeletonCluster =  new Cluster();
    return Cluster.singeletonCluster;
  }
  private Cluster() {
		
		nodes = new ArrayList<Node>();
		
		HypericStateQuery hypericStateQuery = HypericStateQuery.getSingletonedHypericStateQuery();
		
		List<String> agentAddressList = hypericStateQuery.agentApi();
		
		 for (String agentAddress : agentAddressList) {
		   nodes.add(new Node(agentAddress ));
		}
		this.status.setState(IdleState.getSingletonedIdleState());
		
		Thread th1 = new Thread(this,"deneme");
		th1.start();

 
	} // end of constructor
	public void addNode(Node _node) {
		getNodes().add(_node);
	}

	public boolean removeNode(Node _node) {
		getNodes().remove(_node);
		return true;
	}

	// components should have nodes, not the Clusters.
	public void getState() {
	  
	}

	public Node getNode(int _i){
		return nodes.get(_i);
	}
	
	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}

	public List<Node> getNodes() {
		return nodes;
	}
  @Override
  public void run() {
    // TODO Auto-generated method stub
    for(;;){
      try {
        Thread.sleep(1000);
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////do state decisions here /////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        this.status.changeState();
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }

} // end of class Cluster