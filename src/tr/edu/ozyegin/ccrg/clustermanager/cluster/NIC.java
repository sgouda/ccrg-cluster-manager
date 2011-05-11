package tr.edu.ozyegin.ccrg.clustermanager.cluster;

public class NIC extends Component {

	public NIC(String ipAddress) {
    super(ipAddress);
    // TODO Auto-generated constructor stub
  }

  @Override
	public State getState() {
		// TODO Auto-generated method stub
		
		state = new State();
		state.setStateValue(Math.random() * 0.75 + 0.25);
		return state;
	}

}
