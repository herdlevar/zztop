package Model;

import View.ContestGUI; 

import com.opencsv.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvFileWriter {
	
	/** Delimiter for CSV. */
	private static final char COMMA_DELIMITER = ',';
	
	/** New line for CSV. */
	private static final String NEW_LINE = "\n";
	
	/** Header for CSV file. */
	private static final String[] FILE_HEADER = {"firstname","lastname","address","city","state","zip","email","age","filepath", "judgeA", "judgeB", "judgeC", "average"};
	
	/** FileWriter to write CSV file. */
	private FileWriter myFileWriter;
	
	/** The file to write to. */
	private String myFile;
	
	private ContestGUI myJFrame;
	
	/** Constructor. 
	 * @throws IOException */
	public CsvFileWriter(String theFile, ContestGUI theJFrame, boolean exists) throws IOException {
		myFile = theFile;
		myJFrame = theJFrame;
		if(exists) loadContestants();
	}
	
	public void loadContestants() throws IOException {
		CSVReader reader = new CSVReader(new FileReader(myFile));
		reader.readNext();
		String[] nextLine;
		while((nextLine = reader.readNext()) != null) {
			Contestant contestant = new Contestant();
			contestant.addValues(nextLine);
			myJFrame.getMyContestants().add(contestant);
		}
		myJFrame.findWinners();
		reader.close();
	}
	
	/** Adds a new contestant to the csv file. 
	 * @throws IOException */
	public void addContestant(Contestant theContestant) throws IOException {
		CSVWriter writer = new CSVWriter(new FileWriter(myFile, true));
		writer.writeNext(theContestant.getMyValues());
		writer.flush();
		writer.close();
		myJFrame.findWinners();
	}
	
	/** Writes the header to csv file. 
	 * @throws IOException */
	public void writeHeader() throws IOException {
		CSVWriter writer = new CSVWriter(new FileWriter(myFile), COMMA_DELIMITER, ' ');
		writer.writeNext(FILE_HEADER);
		writer.flush();
		writer.close();	
	}
	
	/** Adds a judges score to an entry. */
	public void addScore(int theIndex, String theScore, int theJudge) throws IOException {
		CSVReader reader = new CSVReader(new FileReader(myFile));
		List<String[]> csvBody = reader.readAll();
		csvBody.get(theIndex+1)[theJudge] = theScore;
		csvBody.get(theIndex+1)[12] = myJFrame.getMyContestants().get(theIndex).getMyAverageScore();
		reader.close(); 
		
		CSVWriter writer = new CSVWriter(new FileWriter(myFile), COMMA_DELIMITER);
		writer.writeAll(csvBody);
		writer.flush();
		writer.close();
		
	}
	
	public String addSlash(String theString) {
		StringBuilder string = new StringBuilder(theString);
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == '@') {
				string.delete(i, i+1);
				string.insert(i,'\\');
			}
		}
		return string.toString();
	}
}
