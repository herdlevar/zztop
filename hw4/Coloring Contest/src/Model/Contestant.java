package Model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Contestant {
	
	private String myName;

	private String myAddress;
	
	private String myCity;
	
	private String myState;
	
	private String myZip;
	
	private String myEmail;
	
	private int myAge;
	
	private List<File> myEntries;

	public Contestant(String theName, String theAddress, String theCity, String theState, String theZip,
			String theEmail, int theAge) {
		myName = theName;
		myAddress = theAddress;
		myCity = theCity;
		myState = theState;
		myZip = theZip;
		myEmail = theEmail;
		myAge = theAge;
		myEntries = new ArrayList<File>();
	}
	
	public String getMyName() {
		return myName;
	}

	public void setMyName(String myName) {
		this.myName = myName;
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
	
	public int getMyAge() {
		return myAge;
	}
	
	public void setMyAge(int theAge) {
		myAge = theAge;
	}

	public List<File> getMyEntries() {
		return myEntries;
	}
	
	public void addEntry(File theEntry) {
		myEntries.add(theEntry);
	}
	
	@Override
	public int hashCode() {
		Object[] fields = {myName, myAddress, myCity, myState, myEmail, myAge};
		return Objects.hashCode(fields);
	}
}
