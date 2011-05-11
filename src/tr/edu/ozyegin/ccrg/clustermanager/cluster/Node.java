package tr.edu.ozyegin.ccrg.clustermanager.cluster;

import java.util.ArrayList;
import java.util.List;

public class Node {
	
	//Components should have states
	//State state = null;
	
	 List <Component> components = new ArrayList<Component>(); 
	 
	 String IPAddress="";
	 
	public Node(String _IPAddress){
		
		IPAddress = _IPAddress;
		
	   Memory memory = new Memory(IPAddress);
	   CPU cpu = new CPU(IPAddress);
	   NIC nic = new NIC(IPAddress);
	   Storage storage = new Storage(IPAddress);
	   
	   components.add(memory);
	   components.add(cpu);
	   components.add(nic);
	   components.add(storage);
		
	} // end of constructor
	public double getState(){
	  double load = 0.0;
	  for(int a = 0; a < this.components.size() ; a++){
	    load += this.components.get(a).getState().getStateValue();
	  }
	  return load;
	}
	public List<Component> getComponents() {
		return components;
	}

	
//	public void setComponents(List<Component> components) {
//		this.components = components;
//	}

	 
	// there should be no state of the node, the components should have states
//	public State getState() {
//		return state ;
//	}
	
	
	
	
	//there is no setState method defined, because the state is queried from Hyperic
	
	
	
	
}
