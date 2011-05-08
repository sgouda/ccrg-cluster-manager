package tr.edu.ozyegin.ccrg.clustermanager.test;

import tr.edu.ozyegin.ccrg.clustermanager.cluster.Cluster;
import tr.edu.ozyegin.ccrg.clustermanager.cluster.HypericStateQuery;
import tr.edu.ozyegin.ccrg.clustermanager.cluster.Node;
import tr.edu.ozyegin.ccrg.clustermanager.states.ClusterStatus;

public class MainMethod {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	 
		
		Cluster cluster = new Cluster();

		Node node1 = new Node("10.10.40.101");
 		
		cluster.addNode(node1);
		
		cluster.removeNode(node1);
		
		cluster.getNodes().size();
		
		System.out.println(" +++++++++++ cluster.getNodes().size " + cluster.getNodes().size()  );

		
		
	}

}
