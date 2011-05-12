package tr.edu.ozyegin.ccrg.clustermanager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import tr.edu.ozyegin.ccrg.clustermanager.cluster.Cluster;
import tr.edu.ozyegin.ccrg.clustermanager.states.ClusterStatus;

public class Shell {
  private Shell(){
    Shell.jobcreator = new JobCreator();
  }
  private final String version = "CCRG shell version 0.1";
  private static Shell _instance = null;
  private static String shellString = "Cluster Manager Shell >>";
  private static JobCreator jobcreator = null;
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
        result = this.protocolParser(line);
        if(result == -1)break;
      } catch (IOException e) {
        // TODO Auto-generated catch block
        System.out.println("Error reading stream");
      }
    }
  }
  private int protocolParser(String line){
    String [] tokens = line.split(" ");
    try{
      if(tokens[0].equals("Create") || tokens[0].equals("create")){
        if(tokens[1].equals("Hadoop") || tokens[1].equals("hadoop")){
          if(tokens.length - 2 < 6){
            System.out.println("Invalid Hadoop Job\nUsage: Create Hadoop <path to jar> <input dir> <output dir> <mapper count> <reducer count> <priority>");
            return 1;
          }
          try{
            int mapperCount = Integer.parseInt(tokens[5]);
            int reducerCount =Integer.parseInt(tokens[6]);
            int priority = Integer.parseInt(tokens[7]);
            JobSubmissionTransaction jstH = new HadoopJobSubmissionTransaction("H",tokens[2],tokens[3],tokens[4],mapperCount,reducerCount,priority);
            
            Job j = Shell.jobcreator.createJob(jstH);
            j.scheduleJob();
          }
          catch(Exception e){
            System.out.println("Error: Invalid arguments");
          }
          
        }
        else if(tokens[1].equals("Weka") || tokens[1].equals("weka")){
          if(tokens.length - 2 < 3){
            System.out.println("Invalid Weka Job\nUsage: Create Weka <algorithm> <data file> <priority>");
            return 1;
          }
          try{
            int priority = Integer.parseInt(tokens[4]);
            JobSubmissionTransaction jstW = new WekaJobSubmissionTransaction("W",tokens[2],tokens[3],priority);
            
            Job j = Shell.jobcreator.createJob(jstW);
            j.scheduleJob();
          }
          catch(Exception e){
            System.out.println("Error: Invalid arguments ");
          }
          
        }
        else if(tokens[1].equals("Calculix") || tokens[1].equals("calculix")){
          if(tokens.length - 2 < 3){
            System.out.println("Invalid Calculix Job\nUsage: Create Calculix <data file> <nonzero elements> <priority>");
            return 1;
          }
          try{
            int priority = Integer.parseInt(tokens[4]);
            int nonzero = Integer.parseInt(tokens[3]);
            JobSubmissionTransaction jstC = new CalculixJobSubmissionTransaction("C",tokens[2],nonzero,priority);
            
            Job j = Shell.jobcreator.createJob(jstC);
            j.scheduleJob();
          }
          catch(Exception e){
            System.out.println("Error: Invalid arguments ");
          }
        }
        return 1;
      }
      else if(tokens[0].equals("Show") || tokens[0].equals("show")){
        if(tokens.length<2){
          System.out.println("Invalid Show command\nUsage: Show <Running | Status | Weka | Calculix | Hadoop>");
          return 2;
        }
        if(tokens[1].equals("Status") || tokens[1].equals("status")){
          System.out.println("Cluster is in "+ClusterStatus.getStateString()+" state");
          
        }
        else if(tokens[1].equals("Hadoop") || tokens[1].equals("hadoop"))System.out.println(HadoopScheduler.getQueueString());
        else if(tokens[1].equals("Calculix") || tokens[1].equals("calculix"))System.out.println(CalculixScheduler.getQueueString());
        else if(tokens[1].equals("Weka") || tokens[1].equals("weka"))System.out.println(WekaScheduler.getQueueString());
        else if(tokens[1].equals("Running") || tokens[1].equals("running")){
          String current = Cluster.getRunningString();
          if(current.length() == "Currently  running : ".length())System.out.println("Currently no job is running");
          else System.out.println(current);
        }
        else{
          System.out.println("Invalid Show command\nUsage: Show <Running | Status | Weka | Calculix | Hadoop>");
        }
       
        return 2;
      }
      else if (tokens[0].equals("Help") || tokens[0].equals("help")){
        System.out.println("\"Create <Job Type> [arguments] <priority>\"\nEx: Create Hadoop /usr/local/test.jar In Out 10 10 1");
        System.out.println("\"Show <PoI>\"\nEx: Show memory");
        System.out.println("\"Exit\" to exit from the application");
        System.out.println("\"Help\" to show list of commands");
        
        return 3;
      }
      else if(tokens[0].equals("Exit") || tokens[0].equals("exit"))return -1;
      else{
        System.out.println("Unknown command \""+tokens[0]+"\" !...");
        return 0;
      }
    }
    catch(NullPointerException e){
      System.out.println("Unknown command!...");
      return 0;
    }
  }
}
