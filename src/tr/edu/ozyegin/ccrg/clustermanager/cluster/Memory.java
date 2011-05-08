package tr.edu.ozyegin.ccrg.clustermanager.cluster;

public class Memory extends Component {

	String iPAddress="";
	public Memory(String _iPAddress) {
		// TODO Auto-generated constructor stub
		iPAddress=_iPAddress;
	}

	@Override
	public State getState() {
		// TODO Auto-generated method stub
 
		 state = new State ();
		 
		 state.setStateValue(hypericStateQuery.memoryStatus(iPAddress));
		 
		return state;
	}
	
	

}
