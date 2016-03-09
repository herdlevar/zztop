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
	
	private Integer myAge;
	
	private File myEntry;

	public Contestant(String theFirstName, String theLastName, String theAddress, String theCity, String theState, String theZip,
			String theEmail, Integer theAge, File theEntry) {
		myFirstName = theFirstName;
		myLastName = theLastName;
		myAddress = theAddress;
		myCity = theCity;
		myState = theState;
		myZip = theZip;
		myEmail = theEmail;
		myAge = theAge;
		myEntry = theEntry;
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
	
	public Integer getMyAge() {
		return myAge;
	}
	
	public void setMyAge(Integer theAge) {
		myAge = theAge;
	}
	
	public File getMyEntry() {
		return myEntry;
	}
}
