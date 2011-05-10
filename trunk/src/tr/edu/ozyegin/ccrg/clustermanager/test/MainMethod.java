package tr.edu.ozyegin.ccrg.clustermanager.test;

import java.util.List;

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

	 
		
	  HypericStateQuery hypericStateQueryInstance = HypericStateQuery.getSingletonedHypericStateQuery();
		
     hypericStateQueryInstance.memoryStatus();
	  
		System.out.println(" +++++++++++ agentList "  );

		
		
	}

}
