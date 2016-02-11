package Model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Entry {

	private List<File> myEntries;
	
	private List<Integer> myScores;
	
	private List<List> myJudged;
	
	public Entry() {
		myEntries = new ArrayList<File>();
		myScores = new ArrayList<Integer>();
		myJudged = new ArrayList<List>();
	}
}
