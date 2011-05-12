/**
 * 
 */
package tr.edu.ozyegin.ccrg.clustermanager.states;

import java.util.Observable;
 

/**
 * @author ilke
 * @version 0.1
 */
public class ClusterStatus extends Observable {

	 private static ClusterState currentClusterState = IdleState.getSingletonedIdleState();
	 public static String getStateString(){
	   if(currentClusterState == IdleState.getSingletonedIdleState()){
	     return "Idle";
	   }
	   else{
	     return "Busy";
	   }
	 }
	 public ClusterStatus(){
		 // initialize the door to be at the closed state 
		 setState(IdleState.getSingletonedIdleState());
	 }// Constructor

	//the DoorState will call this function in order to reset the DoorContext
	 public void setState(ClusterState newClusterState) { 
		 this.currentClusterState = newClusterState;
		 if(this.currentClusterState == IdleState.getSingletonedIdleState()){
		   this.setChanged();
	     this.notifyObservers();
		 }
	 }// end of method setState
	 
	 
	 public ClusterState getState(){
		 return currentClusterState;
	 }
	  
	 public void changeState(){ // called through the DoorButton when pressed

		  if( currentClusterState instanceof IdleState )currentClusterState = BusyState.getSingletonedBusyState();   
		  else if( currentClusterState instanceof BusyState ){
		    currentClusterState = IdleState.getSingletonedIdleState();
		    this.setChanged();
	      this.notifyObservers();
		  }
	 }
	 
	 
 	
}
