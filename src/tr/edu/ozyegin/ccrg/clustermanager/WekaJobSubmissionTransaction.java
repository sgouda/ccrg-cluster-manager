package tr.edu.ozyegin.ccrg.clustermanager;
public class WekaJobSubmissionTransaction extends JobSubmissionTransaction {


	private String algorithm="";
	private String dataFile="";
	
	public WekaJobSubmissionTransaction(final String string, String _algorithm , String _dataFile , final int priority) {
		super(string,priority);
		this.setAlgorithm(_algorithm);
		this.setDataFile(_dataFile);
	}

	/**
	 * @param algorithm the algorithm to set
	 */
	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}

	/**
	 * @return the algorithm
	 */
	public String getAlgorithm() {
		return algorithm;
	}

	/**
	 * @param dataFile the dataFile to set
	 */
	public void setDataFile(String dataFile) {
		this.dataFile = dataFile;
	}

	/**
	 * @return the dataFile
	 */
	public String getDataFile() {
		return dataFile;
	}
}
