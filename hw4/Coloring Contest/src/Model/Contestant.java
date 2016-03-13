package Model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Contestant {
	
	private String myFirstName;
	
	private String myLastName;

	private String myAddress;
	
	private String myCity;
	
	private String myState;
	
	private String myZip;
	
	private String myEmail;
	
	private String myAge;
	
	private String myEntry;

	private String myScoreA;
	
	private String myScoreB;
	
	private String myScoreC;
	
	private String myAverageScore;
	
	private String[] myValues;

	public Contestant(String theFirstName, String theLastName, String theAddress, String theCity, String theState, String theZip,
			String theEmail, String theAge, String theEntry) {
		myFirstName = theFirstName;
		myLastName = theLastName;
		myAddress = theAddress;
		myCity = theCity;
		myState = theState;
		myZip = theZip;
		myEmail = theEmail;
		myAge = theAge;
		myEntry = theEntry;
		myScoreA = null;
		myScoreB = null;
		myScoreC = null;
		myAverageScore = null;
		myValues = null;
	}
	
	public Contestant() {
		myScoreA = null;
		myScoreB = null;
		myScoreC = null;
		myAverageScore = null;
		myFirstName = null;
		myLastName = null;
		myAddress = null;
		myCity = null;
		myState = null;
		myZip = null;
		myEmail = null;
		myAge = null;
		myEntry = null;
		myValues = null;
	}
	
	public void addValues(String[] theValues) {
		myFirstName = theValues[0];
		myLastName = theValues[1];
		myAddress = theValues[2];
		myCity = theValues[3];
		myState = theValues[4];
		myZip = theValues[5];
		myEmail = theValues[6];
		myAge = theValues[7];
		StringBuilder string = new StringBuilder(theValues[8]);
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == '\\') {
				string.delete(i, i+1);
				string.insert(i, '@');
			}
		}
		myEntry = string.toString();
		myScoreA = theValues[9];
		myScoreB = theValues[10];
		myScoreC = theValues[11];
		myAverageScore = theValues[12];
		myValues = theValues;
		myValues[8] = myEntry;
	}
	
	public String getMyScoreA() {
		return myScoreA;
	}

	public void setMyScoreA(String myScoreA) {
		this.myScoreA = myScoreA;
		setAverage();
	}

	public String getMyScoreB() {
		return myScoreB;
	}

	public void setMyScoreB(String myScoreB) {
		this.myScoreB = myScoreB;
		setAverage();
	}

	public String getMyScoreC() {
		return myScoreC;
	}

	public void setMyScoreC(String myScoreC) {
		this.myScoreC = myScoreC;
		setAverage();
	}

	public String getMyAverageScore() {
		return myAverageScore;
	}

	public void setMyAverageScore(String myAverageScore) {
		this.myAverageScore = myAverageScore;
	}

	public void setMyFirstName(String myFirstName) {
		this.myFirstName = myFirstName;
	}

	public void setMyEntry(String myEntry) {
		this.myEntry = myEntry;
	}

	public void setMyValues(String[] myValues) {
		this.myValues = myValues;
	}
	
	public String[] getMyValues() {
		return myValues;
	}
	
	public String getMyFirstName() {
		return myFirstName;
	}

	public void setMyName(String theFirstName) {
		this.myFirstName = theFirstName;
	}
	
	public String getMyLastName() {
		return myLastName;
	}

	public void setMyLastName(String theLastName) {
		this.myLastName = theLastName;
	}

	public String getMyAddress() {
		return myAddress;
	}

	public void setMyAddress(String myAddress) {
		this.myAddress = myAddress;
	}

	public String getMyCity() {
		return myCity;
	}

	public void setMyCity(String myCity) {
		this.myCity = myCity;
	}

	public String getMyState() {
		return myState;
	}

	public void setMyState(String myState) {
		this.myState = myState;
	}

	public String getMyZip() {
		return myZip;
	}

	public void setMyZip(String myZip) {
		this.myZip = myZip;
	}

	public String getMyEmail() {
		return myEmail;
	}

	public void setMyEmail(String myEmail) {
		this.myEmail = myEmail;
	}
	
	public String getMyAge() {
		return myAge;
	}
	
	public void setMyAge(String theAge) {
		myAge = theAge;
	}
	
	public String getMyEntry() {
		StringBuilder string = new StringBuilder(myEntry);
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == '@') {
				string.delete(i, i+1);
				string.insert(i,'\\');
			}
		}
		return string.toString();
	}
	
	private void setAverage() {
		float voted = 0;
		if (Integer.parseInt(myScoreA) > 0) voted++;
		if (Integer.parseInt(myScoreB) > 0) voted++;
		if (Integer.parseInt(myScoreC) > 0) voted++;
		myAverageScore = "" + (Integer.parseInt(myScoreA)+Integer.parseInt(myScoreB)+Integer.parseInt(myScoreC))/voted;
	}
}
