package Model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Entry {

	private List<File> myEntries;
	
	private List<Integer> myScores;
	
	public Entry() {
		myEntries = new ArrayList<File>();
		myScores = new ArrayList<Integer>();
	}
}
