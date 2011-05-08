package tr.edu.ozyegin.ccrg.clustermanager.cluster;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;


//Observable pattern is applied via java.util.Observable 
public class Cluster extends Observable {

	private List<Node> nodes = null; // the relation is one to many and
										// aggregation
	State state = null;

	public Cluster() {
		
		nodes = new ArrayList<Node>();
		
		HypericStateQuery hypericStateQuery = HypericStateQuery.getSingletonedHypericStateQuery();
		
		List<String> agentAddressList = hypericStateQuery.agentApi();
		
		 for (String agentAddress : agentAddressList) {
		   nodes.add(new Node(agentAddress ));
		}
		

 
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

} // end of class Cluster