package Model;

/**
 * This class holds info for the contestants.
 *
 */
public class Contestant {
	
	/** The contestants first name. */
	private String myFirstName;
	
	/** The contestants last name. */
	private String myLastName;

	/** THe contestants address. */
	private String myAddress;
	
	/** The contestants city. */
	private String myCity;
	
	/** The contestants state. */
	private String myState;
	
	/** The contestants zip code. */
	private String myZip;
	
	/** The contestants email. */
	private String myEmail;
	
	/** The contestants age. */
	private String myAge;
	
	/** The contestants entry. */
	private String myEntry;

	/** The score from judge a. */
	private String myScoreA;
	
	/** The score from judge b. */
	private String myScoreB;
	
	/** The score from judge c. */
	private String myScoreC;
	
	/** The average score. */
	private String myAverageScore;
	
	/** An array of the contestants attributes. */
	private String[] myValues;

	/**
	 * Creates a new contestant.
	 * @param theFirstName
	 * @param theLastName
	 * @param theAddress
	 * @param theCity
	 * @param theState
	 * @param theZip
	 * @param theEmail
	 * @param theAge
	 * @param theEntry
	 */
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
	
	/** 
	 * Creates a new contestant.
	 */
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
	
	/**
	 * Adds attributes to myValues.
	 * @param theValues
	 */
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
	
	/**
	 * Gets score from judge a.
	 * @return Score from judge a
	 */
	public String getMyScoreA() {
		return myScoreA;
	}

	/**
	 * Sets score from judge a.
	 * @param myScoreA
	 */
	public void setMyScoreA(String myScoreA) {
		this.myScoreA = myScoreA;
		setAverage();
	}

	/**
	 * Gets score from judge b.
	 * @return Score from judgeb
	 */
	public String getMyScoreB() {
		return myScoreB;
	}

	/**
	 * Sets score from judge b
	 * @param myScoreB
	 */
	public void setMyScoreB(String myScoreB) {
		this.myScoreB = myScoreB;
		setAverage();
	}

	/**
	 * Gets score from judge c.
	 * @return Score from judge c
	 */
	public String getMyScoreC() {
		return myScoreC;
	}

	/**
	 * Sets score from judge c.
	 * @param myScoreC
	 */
	public void setMyScoreC(String myScoreC) {
		this.myScoreC = myScoreC;
		setAverage();
	}

	/**
	 * Gets the average score.
	 * @return The average score
	 */
	public String getMyAverageScore() {
		return myAverageScore;
	}

	/**
	 * Sets the average score.
	 * @param myAverageScore
	 */
	public void setMyAverageScore(String myAverageScore) {
		this.myAverageScore = myAverageScore;
	}

	/**
	 * Sets first name.
	 * @param myFirstName
	 */
	public void setMyFirstName(String myFirstName) {
		this.myFirstName = myFirstName;
	}

	/**
	 * Sets the file path of the entry.
	 * @param myEntry
	 */
	public void setMyEntry(String myEntry) {
		this.myEntry = myEntry;
	}

	/**
	 * Sets the attributes of the contestant.
	 * @param myValues
	 */
	public void setMyValues(String[] myValues) {
		this.myValues = myValues;
	}
	
	/** 
	 * Gets the attributes of the contestant.
	 * @return Attributes of the contestant.
	 */
	public String[] getMyValues() {
		return myValues;
	}
	
	/**
	 * Gets first name.
	 * @return First name
	 */
	public String getMyFirstName() {
		return myFirstName;
	}
	
	/**
	 * Gets last name.
	 * @return Last name
	 */
	public String getMyLastName() {
		return myLastName;
	}

	/**
	 * Sets last name.
	 * @param theLastName
	 */
	public void setMyLastName(String theLastName) {
		this.myLastName = theLastName;
	}

	/**
	 * Gets the address.
	 * @return The address.
	 */
	public String getMyAddress() {
		return myAddress;
	}

	/**
	 * Sets the address.
	 * @param myAddress
	 */
	public void setMyAddress(String myAddress) {
		this.myAddress = myAddress;
	}

	/**
	 * Gets the city.
	 * @return The city
	 */
	public String getMyCity() {
		return myCity;
	}

	/**
	 * Sets the city
	 * @param myCity
	 */
	public void setMyCity(String myCity) {
		this.myCity = myCity;
	}

	/**
	 * Gets the state.
	 * @return The state
	 */
	public String getMyState() {
		return myState;
	}

	/**
	 * Sets the state.
	 * @param myState
	 */
	public void setMyState(String myState) {
		this.myState = myState;
	}

	/**
	 * Gets the zip code.
	 * @return The zip code
	 */
	public String getMyZip() {
		return myZip;
	}

	/**
	 * Sets zip code.
	 * @param myZip
	 */
	public void setMyZip(String myZip) {
		this.myZip = myZip;
	}

	/**
	 * Gets email
	 * @return The email
	 */
	public String getMyEmail() {
		return myEmail;
	}

	/**
	 * Sets the email
	 * @param myEmail
	 */
	public void setMyEmail(String myEmail) {
		this.myEmail = myEmail;
	}
	
	/**
	 * Gets the age
	 * @return The age
	 */
	public String getMyAge() {
		return myAge;
	}
	
	/** 
	 * Sets the age.
	 * @param theAge
	 */
	public void setMyAge(String theAge) {
		myAge = theAge;
	}
	
	/**
	 * File path to the entry.
	 * @return File path to the entry
	 */
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
	
	// Sets the average score.
	private void setAverage() {
		float voted = 0;
		if (Integer.parseInt(myScoreA) > 0) voted++;
		if (Integer.parseInt(myScoreB) > 0) voted++;
		if (Integer.parseInt(myScoreC) > 0) voted++;
		myAverageScore = "" + (Integer.parseInt(myScoreA)+Integer.parseInt(myScoreB)+Integer.parseInt(myScoreC))/voted;
	}
}
