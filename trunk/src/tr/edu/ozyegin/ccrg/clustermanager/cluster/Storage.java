package tr.edu.ozyegin.ccrg.clustermanager.cluster;

public class Storage extends Component {

	public Storage(String ipAddress) {
    super(ipAddress);
    // TODO Auto-generated constructor stub
  }

  @Override
	public State getState() {
		// TODO Auto-generated method stub
		state = new State();
		 
		return state;
	}

}
