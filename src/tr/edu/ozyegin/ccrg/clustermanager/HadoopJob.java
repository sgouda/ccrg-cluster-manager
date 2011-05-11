package tr.edu.ozyegin.ccrg.clustermanager;
import java.io.File;
import java.util.Comparator;
import java.util.UUID;

public class HadoopJob extends Job {

	private HadoopJobSubmissionTransaction hJst = null;

	public HadoopJob(Scheduler scheduler,HadoopJobSubmissionTransaction Hjst) {
		super(scheduler,Hjst.getPriority());
		this.hJst = Hjst;
	}
	public String getJarDir(){
	  return this.hJst.getJarDir();
	}
	public String getDfsInputDir(){
	  return this.hJst.getDfsInputDir();
	}
	public String getDfsOutputDir(){
	  return this.hJst.getDfsOutputDir();
	}
	public int getMapperCount(){
	  return this.getMapperCount();
	}
	public int getReducerCount(){
	  return this.hJst.getReducercount();
	}
}

