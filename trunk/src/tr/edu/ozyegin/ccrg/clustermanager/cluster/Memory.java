package tr.edu.ozyegin.ccrg.clustermanager.cluster;

public class Memory extends Component {


	
	public Memory(String _iPAddress) {
		// TODO Auto-generated constructor stub
		super(_iPAddress);
	}

	@Override
	public State getState() {
		// TODO Auto-generated method stub
 
		 state = new State ();
		 
		 //state.setStateValue(hypericStateQuery.memoryStatus(this.IPAddress));
		 state.setStateValue(Math.random());
		return state;
	}
	
	

}
