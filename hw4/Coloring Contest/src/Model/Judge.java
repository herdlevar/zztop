package Model;

import java.util.HashMap;
import java.util.Map;

public class Judge {

	private Map<String, String> myLoginInfo;
	
	private boolean myJudgeA;
	
	public Map<String, String> getMyLoginInfo() {
		return myLoginInfo;
	}

	public void setMyLoginInfo(Map<String, String> myLoginInfo) {
		this.myLoginInfo = myLoginInfo;
	}

	public boolean isMyJudgeA() {
		return myJudgeA;
	}

	public void setMyJudgeA(boolean myJudgeA) {
		this.myJudgeA = myJudgeA;
	}

	public boolean isMyJudgeB() {
		return myJudgeB;
	}

	public void setMyJudgeB(boolean myJudgeB) {
		this.myJudgeB = myJudgeB;
	}

	public boolean isMyJudgeC() {
		return myJudgeC;
	}

	public void setMyJudgeC(boolean myJudgeC) {
		this.myJudgeC = myJudgeC;
	}

	private boolean myJudgeB;
	
	private boolean myJudgeC;
	
	public Judge(String theJudge, String thePassword) {
		myLoginInfo = new HashMap<String, String>();
		myJudgeA = false;
		myJudgeB = false;
		myJudgeC= false;
		setupJudges();
		checkLogin(theJudge, thePassword);
	}
	
	private void setupJudges() {
		myLoginInfo.put("judgea", "password");
		myLoginInfo.put("judgeb", "password");
		myLoginInfo.put("judgec", "password");
	}
	
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
	
	public boolean loggedIn() {
		if (myJudgeA || myJudgeB || myJudgeC) return true;
		return false;
	}
}
