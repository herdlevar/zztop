package Model;

import java.util.HashMap;
import java.util.Map;

/**
 * This class contains infor for the judges.
 *
 */
public class Judge {

	/** A map of usernames and passwords. */
	private Map<String, String> myLoginInfo;
	
	/** Whether judge a has judged. */
	private boolean myJudgeA;
	
	/** Whether judge b has judged. */
	private boolean myJudgeB;
	
	/** Whether judge c has judged. */
	private boolean myJudgeC;	
	
	/**
	 * Creates a new judge.
	 * @param theJudge
	 * @param thePassword
	 */
	public Judge(String theJudge, String thePassword) {
		myLoginInfo = new HashMap<String, String>();
		myJudgeA = false;
		myJudgeB = false;
		myJudgeC= false;
		setupJudges();
		checkLogin(theJudge, thePassword);
	}
	
	/**
	 * Returns if judge a has judged.
	 * @return True if judge a has judged
	 */
	public boolean isMyJudgeA() {
		return myJudgeA;
	}

	/** 
	 * Sets if judge a has judged.
	 * @param myJudgeA
	 */
	public void setMyJudgeA(boolean myJudgeA) {
		this.myJudgeA = myJudgeA;
	}

	/**
	 * If judge b has judged.
	 * @return True if judge b has judged.
	 */
	public boolean isMyJudgeB() {
		return myJudgeB;
	}

	/**
	 * Sets if judge b has judged.
	 * @param myJudgeB
	 */
	public void setMyJudgeB(boolean myJudgeB) {
		this.myJudgeB = myJudgeB;
	}

	/**
	 * Whether judge c has judged.
	 * @return True if judge c has judged.
	 */
	public boolean isMyJudgeC() {
		return myJudgeC;
	}

	/**
	 * Sets if judge c has judged.
	 * @param myJudgeC
	 */
	public void setMyJudgeC(boolean myJudgeC) {
		this.myJudgeC = myJudgeC;
	}
	
	// Sets up the judges.
	private void setupJudges() {
		myLoginInfo.put("judgea", "password");
		myLoginInfo.put("judgeb", "password");
		myLoginInfo.put("judgec", "password");
	}
	
	// Checks login credentials.
	private void checkLogin(String theJudge, String thePassword) {
		if (myLoginInfo.containsKey(theJudge)) {
			if (theJudge.equalsIgnoreCase("judgea") && myLoginInfo.get(theJudge.toLowerCase()).equals(thePassword)) {
				myJudgeA = true;
			} else if (theJudge.equalsIgnoreCase("judgeb") && myLoginInfo.get(theJudge.toLowerCase()).equals(thePassword)) {
				myJudgeB = true;
			} else if (theJudge.equalsIgnoreCase("judgec") && myLoginInfo.get(theJudge.toLowerCase()).equals(thePassword)) {
				myJudgeC = true;
			} 
		}
	}
	
	/**
	 * Whether logged in or not
	 * @return True if one of the judges is logged in
	 */
	public boolean loggedIn() {
		if (myJudgeA || myJudgeB || myJudgeC) return true;
		return false;
	}
}
