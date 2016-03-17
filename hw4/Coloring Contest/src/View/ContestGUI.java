package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Model.Contestant;
import Model.CsvFileWriter;

/**
 * Is the JFrame for the gui.
 * 
 * @author Zach Martinez, Jared Herdlevar
 * @date March 17, 2016
 */
public class ContestGUI extends JFrame implements Observer, PropertyChangeListener{
	
	// Constants
	
	/** Frame size when removed from full screen. */
	private static final Dimension FRAME_SIZE = new Dimension(800, 600);
	
	// Fields
	
	/** The winner of the 0-5 age bracket. */
	private Contestant winner5;
	
	/** The winner of the 6-10 bracket. */
	private Contestant winner10;
	
	/** The winner of the 11-15 bracket. */
	private Contestant winner15;
	
	/** The winner of the 16-18 bracket. */
	private Contestant winner18;
	
	/** The winner of the 19+ bracket. */
	private Contestant winner19;
	
	/** Welcome screen panel. */
	private final WelcomePanel myWelcomePanel;
	
	/** Panel to enter, download, or judge login. */
	private EnterLoginPanel myEnterLoginPanel;
	
	/** Panel to view privacy policy and contest rules. */
	private final BottomPanel myBottomPanel;
	
	/** The center panel of the frame. */
	private JPanel myCenterPanel;	
	
	/** Home menu item. */
	private static JButton myHomeButton;
	
	/** The file path of the database of contestants. */
	private String myDatabase;
	
	/** The csv file writer to write to the database. */
	private CsvFileWriter myCsvWriter;
	
	/** The list of contestants. */
	private List<Contestant> myContestants;
	
	/**
	 * Constructs the coloring contest GUI
	 * @throws IOException 
	 * @throws URISyntaxException 
	 */
	public ContestGUI() throws IOException, URISyntaxException {
		// empty constructor
		super("Coloring Contest");
		myHomeButton = new JButton("Home");
		myContestants = new ArrayList<Contestant>();
		myDatabase = ContestGUI.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath() + "database.csv";
		File test = new File(myDatabase);
		if (!test.exists()) {
			myCsvWriter = new CsvFileWriter(myDatabase, this, false);
			myCsvWriter.writeHeader();
		} else {
			myCsvWriter = new CsvFileWriter(myDatabase, this, true);
		}
		myWelcomePanel = new WelcomePanel(this);
		myEnterLoginPanel = new EnterLoginPanel(this);
		myBottomPanel = new BottomPanel(this);
		myCenterPanel = myEnterLoginPanel;
		winner5 = null;
		winner10 = null;
		winner15 = null;
		winner18 = null;
		winner19 = null;
	}
	
	/**
	 * Displays the GUI
	 */
	public void start() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setSize(FRAME_SIZE);
		setLocationRelativeTo(null);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(myWelcomePanel, BorderLayout.NORTH);
		add(myEnterLoginPanel, BorderLayout.CENTER);
		add(myBottomPanel, BorderLayout.SOUTH);
		setVisible(true);
		//JOptionPane.showMessageDialog(this, "Hello there!\n\n"
			//	+ "Jared Herdlevar, Nick Dantche, Jeff Lytle, Jake Nasanov, and Zach Martinez");
	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * This method finds the winners of each age bracket.
	 */
	public void findWinners() {
		int age;
		for (Contestant contestant : myContestants) {
			try {

				age = Integer.parseInt(contestant.getMyAge());
			} catch (Exception e) {
				continue;
			}
			if (age < 6) {
				if (winner5 == null) {
					winner5 = contestant;
				} else if (Float.parseFloat(winner5.getMyAverageScore()) < Float.parseFloat(contestant.getMyAverageScore())) {
					winner5 = contestant;
				}
			} else if (age < 11) {
				if (winner10 == null) {
					winner10 = contestant;
				} else if (Float.parseFloat(winner10.getMyAverageScore()) < Float.parseFloat(contestant.getMyAverageScore())) {
					winner10 = contestant;
				}
			} else if (age < 16) {
				if (winner15 == null) {
					winner15 = contestant;
				} else if (Float.parseFloat(winner15.getMyAverageScore()) < Float.parseFloat(contestant.getMyAverageScore())) {
					winner15 = contestant;
				}
			} else if (age < 19) {
				if (winner18 == null) {
					winner18 = contestant;
				} else if (Float.parseFloat(winner18.getMyAverageScore()) < Float.parseFloat(contestant.getMyAverageScore())) {
					winner18 = contestant;
				}
			} else if (age > 18) {
				if (winner19 == null) {
					winner19 = contestant;
				} else if (Float.parseFloat(winner19.getMyAverageScore()) < Float.parseFloat(contestant.getMyAverageScore())) {
					winner19 = contestant;
				}
			}
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Gets the csv writer.
	 * @return The csv file writer
	 */
	public CsvFileWriter getMyCsvWriter() {
		return myCsvWriter;
	}
	
	/**
	 * Gets the list of contestants.
	 * @return The list of contestants. 
	 */
	public List<Contestant> getMyContestants() {
		return myContestants;
	}
	
	/**
	 * Gets the size of the jframe.
	 * @return The dimensions of the JFrame
	 */
	public static Dimension getFrameSize() {
		return FRAME_SIZE;
	}

	/**
	 * Gets the welcome panel.
	 * @return The WelcomePanel
	 */
	public WelcomePanel getMyWelcomePanel() {
		return myWelcomePanel;
	}

	/**
	 * Gets the enter login panel
	 * @return The EnterLoginPanel
	 */
	public EnterLoginPanel getMyEnterLoginPanel() {
		return myEnterLoginPanel;
	}

	/**
	 * Gets the bottom panel
	 * @return The BottomPanel
	 */
	public BottomPanel getMyBottomPanel() {
		return myBottomPanel;
	}

	/**
	 * Gets the panel in the center of the frame.
	 * @return The center panel.
	 */
	public JPanel getMyCenterPanel() {
		return myCenterPanel;
	}
	
	/**
	 * Sets the center panel.
	 * @param theCenterPanel
	 */
	public void setMyCenterPanel(JPanel theCenterPanel){
		myCenterPanel = theCenterPanel;
	}
	
	/**
	 * Gets the winner of the 0-5 bracket.
	 * @return The 0-5 winner
	 */
	public Contestant getWinner5() {
		return winner5;
	}
	
	/**
	 * Gets the winner of the 6-10 bracket.
	 * @return The 6-10 winner
	 */
	public Contestant getWinner10() {
		return winner10;
	}
	
	/**
	 * Gets the winner of the 11-15 bracket.
	 * @return The 11-15 winner
	 */
	public Contestant getWinner15() {
		return winner15;
	}
	
	/**
	 * Gets the winner of the 16-18 bracket.
	 * @return The 16-18 winner.
	 */
	public Contestant getWinner18() {
		return winner5;
	}
	
	/** 
	 * Gets the winner of the 19+ bracket.
	 * @return The 19+ winner
	 */
	public Contestant getWinner19() {
		return winner19;
	}
}
