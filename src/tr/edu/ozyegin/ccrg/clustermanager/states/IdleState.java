package tr.edu.ozyegin.ccrg.clustermanager.states;

 

public class IdleState implements ClusterState {

	
    private static IdleState idleStateInstance = new IdleState();// no need for lazy initialization this is mission critical, memory is not important therefore.

    public static synchronized IdleState getSingletonedIdleState(){
    	return idleStateInstance;
    }
	
    @Override  
	public Object clone() throws CloneNotSupportedException{  
		throw new CloneNotSupportedException();  
	}
    
	private IdleState(){}//constructor

	@Override
	public void changeState() {
		// TODO Auto-generated method stub
		
		BusyState.getSingletonedBusyState();
		
	}
}
