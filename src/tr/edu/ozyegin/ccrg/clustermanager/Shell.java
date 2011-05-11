package tr.edu.ozyegin.ccrg.clustermanager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Shell {
  private Shell(){}
  private final String version = "CCRG shell version 0.1";
  private static Shell _instance = null;
  private static String shellString = "Cluster Manager Shell >>";
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
        return 1;
      }
      else if(tokens[0].equals("Show") || tokens[0].equals("show")){
        return 2;
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
