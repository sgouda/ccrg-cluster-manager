package tr.edu.ozyegin.ccrg.clustermanager;

import java.util.Observable;

public class CalculixScheduler extends Scheduler {

	@Override
	public void ScheduleAlgorithm(Job j) {
		// TODO Auto-generated method stub
		System.out.println("Implement Calculix Algorithm");

	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
	  System.out.println("Hadoop update trigerred");
	}

}
