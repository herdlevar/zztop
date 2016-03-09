package Model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CsvFileWriter {
	
	/** Delimiter for CSV. */
	private static final String COMMA_DELIMITER = ",";
	
	/** New line for CSV. */
	private static final String NEW_LINE = "\n";
	
	/** Header for CSV file. */
	private static final String FILE_HEADER = "firstname,lastname,address,city,state,zip,email,age,filepath";
	
	/** FileWriter to write CSV file. */
	private FileWriter myFileWriter;
	
	/** The file to write to. */
	private File myFile;
	
	/** Constructor. */
	public CsvFileWriter(File theFile) {
		myFile = theFile;
		try {
			myFileWriter = new FileWriter(myFile);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				myFileWriter.flush();
				myFileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void addContestant(Contestant theContestant) {
			try {
				myFileWriter.append(theContestant.getMyFirstName());
				myFileWriter.append(COMMA_DELIMITER);
				myFileWriter.append(theContestant.getMyLastName());
				myFileWriter.append(COMMA_DELIMITER);
				myFileWriter.append(theContestant.getMyAddress());
				myFileWriter.append(COMMA_DELIMITER);
				myFileWriter.append(theContestant.getMyCity());
				myFileWriter.append(COMMA_DELIMITER);
				myFileWriter.append(theContestant.getMyState());
				myFileWriter.append(COMMA_DELIMITER);
				myFileWriter.append(theContestant.getMyZip());
				myFileWriter.append(COMMA_DELIMITER);
				myFileWriter.append(theContestant.getMyEmail());
				myFileWriter.append(COMMA_DELIMITER);
				myFileWriter.append(theContestant.getMyAge().toString());
				myFileWriter.append(COMMA_DELIMITER);
				myFileWriter.append(theContestant.getMyEntry().getAbsolutePath());
				myFileWriter.append(NEW_LINE);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					myFileWriter.flush();
					myFileWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	}
	
	public void writeHeader() {
		try {
			myFileWriter.append(FILE_HEADER);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				myFileWriter.flush();
				myFileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
