package tr.edu.ozyegin.ccrg.clustermanager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import tr.edu.ozyegin.ccrg.clustermanager.cluster.Cluster;
import tr.edu.ozyegin.ccrg.clustermanager.states.ClusterStatus;

public class Shell {
  private Shell(){  }
  private final String version = "CCRG shell version 0.1";
  private static Shell _instance = null;
  private static String shellString = "Cluster Manager Shell >>";
  private ClusterInterface clusterInterface = new ClusterInterface();
  public static Shell getInstance(){
    if(Shell._instance == null) Shell._instance = new Shell();
    return Shell._instance;
  }
  public void getCursor(){
    System.out.println();
    InputStreamReader converter = new InputStreamReader(System.in);
    BufferedReader in = new BufferedReader(converter);
    int result = 0;
    for(;;){
      System.out.print(Shell.shellString);
      try {
        String line = in.readLine();
        result = this.clusterInterface.protocolExecuter(line);
        if(result == -1)break;
      } catch (IOException e) {
        // TODO Auto-generated catch block
        System.out.println("Error reading stream");
      }
    }
  }
  
}
