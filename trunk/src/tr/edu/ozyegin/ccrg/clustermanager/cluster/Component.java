package tr.edu.ozyegin.ccrg.clustermanager.cluster;

public abstract class Component {

	HypericStateQuery hypericStateQuery = HypericStateQuery.getSingletonedHypericStateQuery(); 

	State state = null;
	
	
	public Component(){
		
		
	}  // end of default constructor 
	
	public abstract State getState();
	
}
