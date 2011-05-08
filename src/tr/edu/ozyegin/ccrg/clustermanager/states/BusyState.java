package tr.edu.ozyegin.ccrg.clustermanager.states;

public class BusyState implements ClusterState {

	
    private static BusyState busyStateInstance = new BusyState();// no need for lazy initialization this is mission critical, memory is not important therefore.

    public static synchronized BusyState getSingletonedBusyState(){
    	return busyStateInstance;
    }
	
    @Override  
	public Object clone() throws CloneNotSupportedException{  
		throw new CloneNotSupportedException();  
	}
    
	private BusyState(){}//constructor

	@Override
	public void changeState() {
		
		IdleState.getSingletonedIdleState();
		
	}
	
	
}
