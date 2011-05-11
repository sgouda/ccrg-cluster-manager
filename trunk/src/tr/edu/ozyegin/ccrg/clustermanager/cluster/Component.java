package tr.edu.ozyegin.ccrg.clustermanager.cluster;

public abstract class Component {

	HypericStateQuery hypericStateQuery = HypericStateQuery.getSingletonedHypericStateQuery(); 

	State state = null;
	String IPAddress = "";
	
	public Component(String ipAddress){
		this.IPAddress = ipAddress;
		
	}  // end of default constructor 
	
	public abstract State getState();
	
}
