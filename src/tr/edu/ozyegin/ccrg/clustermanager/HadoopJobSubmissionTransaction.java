package tr.edu.ozyegin.ccrg.clustermanager;
public class HadoopJobSubmissionTransaction extends JobSubmissionTransaction {

	private String jarDir = "";
	private int mapperCount = 0;
	private int reducerCount = 0;
	private String dfsInputDir = "";
	private String dfsOutputDir = "";

	public HadoopJobSubmissionTransaction(final String string, final String jarDir, final String dfsInputDir, final String dfsOutputDir, final int mapperCount, final int reducerCount ,final int priority) {
		super(string,priority);
		this.jarDir = jarDir;
		this.dfsInputDir = dfsInputDir;
		this.dfsOutputDir = dfsOutputDir;
		this.mapperCount = mapperCount;
		this.reducerCount = reducerCount;
	}

	
	public String getJarDir() {
		return this.jarDir;
	}
	public int getMapperCount() {
		return this.mapperCount;
	}
	public int getReducercount(){
	  return this.reducerCount;
	}
	public String getDfsInputDir(){
	  return this.dfsInputDir;
	}
	public String getDfsOutputDir(){
	  return this.dfsOutputDir;
	}
}
