/**
 * 
 */
package tr.edu.ozyegin.ccrg.clustermanager.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import tr.edu.ozyegin.ccrg.clustermanager.cluster.Cluster;
import tr.edu.ozyegin.ccrg.clustermanager.cluster.Node;
import tr.edu.ozyegin.ccrg.clustermanager.cluster.State;

/**
 * @author im1076
 *
 */
public class ClusterTest {

 	
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
 	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
       
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		
		Cluster cluster = null;
	}

	/**
	 * Test method for {@link tr.edu.ozyegin.ccrg.clustermanager.cluster.Cluster#Cluster()}.
	 */
	@Test
	public void testCluster() {
		
		Cluster cluster = Cluster.getSingletonCluster();
		
		assertTrue(cluster != null );
		
		cluster = null;
		
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link tr.edu.ozyegin.ccrg.clustermanager.cluster.Cluster#addNode(tr.edu.ozyegin.ccrg.clustermanager.cluster.Node)}.
	 */
	@Test
	public void testAddNode() {
		
		Cluster cluster = Cluster.getSingletonCluster();

		Node node1 = new Node("10.10.40.101");
 		
		cluster.addNode(node1);
		
		cluster.getNode(0).getComponents().get(0).getState().getStateValue();
		
		assertTrue( cluster.getNode(0).getComponents().get(0).getState().getStateValue() instanceof Double  );
		
	}

	/**
	 * Test method for {@link tr.edu.ozyegin.ccrg.clustermanager.cluster.Cluster#removeNode(tr.edu.ozyegin.ccrg.clustermanager.cluster.Node)}.
	 */
	@Test
	public void testRemoveNode() {
		
		Cluster cluster = Cluster.getSingletonCluster();;

		Node node1 = new Node("10.10.40.101");
 		
		cluster.addNode(node1);
		
		cluster.removeNode(node1);
		
	 
		
		assertTrue( cluster.removeNode(node1) == true  );
		
	}

	/**
	 * Test method for {@link tr.edu.ozyegin.ccrg.clustermanager.cluster.Cluster#getState()}.
	 */
	@Test
	public void testGetState() {
		
		
		Cluster cluster = Cluster.getSingletonCluster();

		Node node1 = new Node("10.10.40.101");
 		
		cluster.addNode(node1);
		
		assertTrue( cluster.getNode(0).getComponents().get(0).getState() instanceof State );
	}

}
