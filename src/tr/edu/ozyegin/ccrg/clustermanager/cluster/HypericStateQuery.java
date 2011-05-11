package tr.edu.ozyegin.ccrg.clustermanager.cluster;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hyperic.hq.hqapi1.AgentApi;
import org.hyperic.hq.hqapi1.HQApi;
import org.hyperic.hq.hqapi1.MetricApi;
import org.hyperic.hq.hqapi1.ResourceApi;
import org.hyperic.hq.hqapi1.types.Agent;
import org.hyperic.hq.hqapi1.types.AgentResponse;
import org.hyperic.hq.hqapi1.types.AgentsResponse;
import org.hyperic.hq.hqapi1.types.MetricDataResponse;
import org.hyperic.hq.hqapi1.types.MetricsResponse;
import org.hyperic.hq.hqapi1.types.Resource;
import org.hyperic.hq.hqapi1.types.ResourcesResponse;



/**
 * 
 * @author ilke
 * @version 0.1
 * 
 *
 */

//Singleton pattern is used
public final class HypericStateQuery {

	/**
	 * @param args
	 * @throws IOException
	 */

	private HQApi hqApi;
	
	private static HypericStateQuery hypericStateQueryInstance = new HypericStateQuery(); 
	
	private HypericStateQuery (){

 		
		//TODO
		//these parameters must be read from the client.properties file
		// check java almanac http://www.exampledepot.com/egs/java.util/Props.html
		  hqApi = new HQApi("10.10.40.200", 7080, false, "hqadmin", "hqadmin");

		
 	}
	
	public static synchronized HypericStateQuery getSingletonedHypericStateQuery(){
		
		if ( hypericStateQueryInstance == null){ 
		    	hypericStateQueryInstance = new HypericStateQuery();
		}
		
			return hypericStateQueryInstance;
		
	} // end of method
	
	 @Override  
		public Object clone() throws CloneNotSupportedException{  
			throw new CloneNotSupportedException();  
		}
	
	
//	public static void main(String[] args) throws IOException {
//		// TODO Auto-generated method stub
//
//		System.out.println("before connection");
//
//		HQApi hqApi = new HQApi("10.10.40.200", 7080, false, "hqadmin",
//				"hqadmin");
//
//		System.out.println("after connection");
//
//		//agentApi(hqApi);
//
//		memoryStatus(hqApi);
//
//	}

	 public double memoryStatus ()  {

		double freeMemory = 0.0;
		
		
 
		ResourceApi resApi = hqApi.getResourceApi();

		AgentApi agApi = hqApi.getAgentApi();

		MetricApi metricApi = hqApi.getMetricApi();


		//pass the IP of machine to be monitored as an argument

		AgentResponse agResponse;
		
		try {
			
			
			agResponse = agApi.getAgent("10.10.40.200", 2144);
	

		Agent agent = agResponse.getAgent();

		if (resApi!=null){

		
		  
		  
		  ResourcesResponse resp=resApi.getResources(agent, false, false);
		
		
		

		List <Resource> resourceList = resp.getResource();

		for(Resource resource : resourceList){

		MetricsResponse metrics=metricApi.getMetrics(resource, true); //getEnabledMetrics(resource);
		
		
		

		for (org.hyperic.hq.hqapi1.types.Metric m : metrics.getMetric()) {

			
				System.out.println("m.getName()" + m.getName() );
				
			
		// check against the CPU USAGE

		if("Load Average 5 Minutes".equalsIgnoreCase(m.getName())){
			
			System.out.println("--Free Memory :" + m.getName());
			System.out.println("--m.getId() :" + m.getId() );

				
		//long end = System.currentTimeMillis();  //metricTimeStamp 
		//long start = end - (1 * 60 * 60 * 1000);
			 Date end = new Date();
			 Date start = new Date(end.getTime()-200000000);
		
			MetricDataResponse dataResponse = metricApi.getMetricData(m.getId() , start.getTime(), end.getTime());
				
			System.out.println("--dataResponse size  :" + dataResponse.getMetricData().getDataPoint().size() );

			
			if(dataResponse.getMetricData().getDataPoint().size()>0){
	
	
			// value at 0th index gives the latest value
	
			   freeMemory = dataResponse.getMetricData().getDataPoint().get(0).getValue();
			 System.out.println("--dataResponse freeMemory  :" + freeMemory  + " " + m.getMetricTemplate().getUnits());

			
			long timestamp= dataResponse.getMetricData().getDataPoint().get(0).getTimestamp();
	
			}

		} // end of if
		
		 

		} 

		break;

		}

		}
		
		return freeMemory;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
			// return - value
			return -1.0;
		} 
		
	} // end of method

	
	 public double memoryStatus (String agentAddress)  {

			double freeMemory = 0.0;
			
			
	 
			ResourceApi resApi = hqApi.getResourceApi();

			AgentApi agApi = hqApi.getAgentApi();

			MetricApi metricApi = hqApi.getMetricApi();


			//pass the IP of machine to be monitored as an argument

			AgentResponse agResponse;
			
			try {
				
				
				agResponse = agApi.getAgent(agentAddress, 2144);
		

			Agent agent = agResponse.getAgent();

			if (resApi!=null){

			ResourcesResponse resp=resApi.getResources(agent, false, false);

			List <Resource> resourceList = resp.getResource();

			for(Resource resource : resourceList){

			MetricsResponse metrics=metricApi.getMetrics(resource, true); //getEnabledMetrics(resource);
			
			
			

			for (org.hyperic.hq.hqapi1.types.Metric m : metrics.getMetric()) {

				
					System.out.println("m.getName()" + m.getName() );
					
				
			// check against the CPU USAGE

			if("Load Average 5 Minutes".equalsIgnoreCase(m.getName())){
				
				System.out.println("--Free Memory :" + m.getName());
				System.out.println("--m.getId() :" + m.getId() );

					
			//long end = System.currentTimeMillis();  //metricTimeStamp 
			//long start = end - (1 * 60 * 60 * 1000);
				 Date end = new Date();
				 Date start = new Date(end.getTime()-200000000);
			
				MetricDataResponse dataResponse = metricApi.getMetricData(m.getId() , start.getTime(), end.getTime());
					
				System.out.println("--dataResponse size  :" + dataResponse.getMetricData().getDataPoint().size() );

				
				if(dataResponse.getMetricData().getDataPoint().size()>0){
		
		
				// value at 0th index gives the latest value
		
				   freeMemory = dataResponse.getMetricData().getDataPoint().get(0).getValue();
				 System.out.println("--dataResponse freeMemory  :" + freeMemory  + " " + m.getMetricTemplate().getUnits());

				
				long timestamp= dataResponse.getMetricData().getDataPoint().get(0).getTimestamp();
		
				}

			} // end of if
			
			 

			} 

			break;

			}

			}
			
			return freeMemory;

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				
				// return - value
				return -1.0;
			} 
			
		} // end of method
	 
	 
	
	
	public List <String> agentApi( )  {
		List <String> agentAddresses = new ArrayList<String>();
		
		try {
		AgentApi agentApi = hqApi.getAgentApi();

		AgentsResponse agentsResponse;
		
			agentsResponse = agentApi.getAgents();
	

		List<Agent> agentList = agentsResponse.getAgent();

		
		
		for (Agent agent : agentList) {

			agentAddresses.add(agent.getAddress());
 

		}
		
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return agentAddresses;
	}

	
	
}