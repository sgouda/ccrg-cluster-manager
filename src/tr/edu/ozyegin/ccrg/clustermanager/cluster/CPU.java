package tr.edu.ozyegin.ccrg.clustermanager.cluster;

public class CPU extends Component {

	public CPU(String ipAddress) {
    super(ipAddress);
    // TODO Auto-generated constructor stub
  }

  @Override
	public State getState() {
		// TODO Auto-generated method stub
		
		state = new State ();
		state.setStateValue(Math.random());
		return state;
	}

}
