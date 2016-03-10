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
		List<Contestant> contestants = myJFrame.getMyContestants();
		while((nextLine = reader.readNext()) != null) {
			Contestant contestant = new Contestant();
			contestant.addValues(nextLine);
			contestants.add(contestant);
		}
		myJFrame.findWinners();
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
		CSVWriter writer = new CSVWriter(new FileWriter(myFile, true), COMMA_DELIMITER, ' ');
		writer.writeNext(FILE_HEADER);
		writer.flush();
		writer.close();	
	}
	
	/** Adds a judges score to an entry. */
	public void addScore(Integer theScore, Judge theJudge, File theDrawing) throws IOException {
		CSVReader reader = new CSVReader(new FileReader(myFile));
		CSVWriter writer = new CSVWriter(new FileWriter(myFile, true), COMMA_DELIMITER, ' ');
		List<String[]> csvBody = reader.readAll();
		for(String[] string : csvBody) {
			if (string[8].compareToIgnoreCase(theDrawing.getAbsolutePath()) == 0) {
				if (theJudge.toString().compareTo("A") == 0) {
					string[9] = theScore.toString();
				} else if (theJudge.toString().compareTo("B") == 0) {
					string[10] = theScore.toString();
				} else {
					string[11] = theScore.toString();
				}
				string[12] = "" + (Integer.parseInt(string[9]) + Integer.parseInt(string[10]) + Integer.parseInt(string[11]))/3;
				break;
			}
		}
		writer.writeAll(csvBody);
		writer.flush();
		writer.close();
		reader.close();
	}
}
