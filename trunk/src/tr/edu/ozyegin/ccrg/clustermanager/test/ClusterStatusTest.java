/**
 * 
 */
package tr.edu.ozyegin.ccrg.clustermanager.test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import tr.edu.ozyegin.ccrg.clustermanager.states.BusyState;
import tr.edu.ozyegin.ccrg.clustermanager.states.ClusterState;
import tr.edu.ozyegin.ccrg.clustermanager.states.ClusterStatus;
import tr.edu.ozyegin.ccrg.clustermanager.states.IdleState;

/**
 * @author ilke
 * @version 0.1
 *
 */
public class ClusterStatusTest {

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
	}

	/**
	 * Test method for {@link tr.edu.ozyegin.ccrg.clustermanager.states.ClusterStatus#ClusterStatus()}.
	 */
	@Test
	public void testClusterStatus() {
		
		ClusterStatus clusterStatus = new ClusterStatus();
		
		assertTrue(clusterStatus != null );

		
		
	}

	/**
	 * Test method for {@link tr.edu.ozyegin.ccrg.clustermanager.states.ClusterStatus#setState(tr.edu.ozyegin.ccrg.clustermanager.states.ClusterState)}.
	 */
	@Test
	public void testSetState() {
		
		ClusterStatus clusterStatus = new ClusterStatus();
		
		
		
		clusterStatus.setState(IdleState.getSingletonedIdleState());
		assertTrue(clusterStatus != null );
	}

	/**
	 * Test method for {@link tr.edu.ozyegin.ccrg.clustermanager.states.ClusterStatus#getState()}.
	 */
	@Test
	public void testGetState() {
		
		ClusterStatus clusterStatus = new ClusterStatus();
		
		
		
		clusterStatus.setState(IdleState.getSingletonedIdleState());
		ClusterState clusterState = clusterStatus.getState();
		assertTrue(clusterState instanceof IdleState );
		
	}

	/**
	 * Test method for {@link tr.edu.ozyegin.ccrg.clustermanager.states.ClusterStatus#changeState()}.
	 */
	@Test
	public void testChangeState() {
		
		
    	ClusterStatus clusterStatus = new ClusterStatus();
 
		clusterStatus.changeState();

		assertTrue(clusterStatus.getState() instanceof BusyState );
	}

}
