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

public class ContestGUI extends JFrame implements Observer, PropertyChangeListener{
	
	// Constants
	
	/** Frame size when removed from full screen. */
	private static final Dimension FRAME_SIZE = new Dimension(800, 600);
	
	// Fields
	
	private Contestant winner5;
	
	private Contestant winner10;
	
	private Contestant winner15;
	
	private Contestant winner18;
	
	private Contestant winner19;
	
	/** Welcome screen panel. */
	private final WelcomePanel myWelcomePanel;
	

	/** Panel to enter, download, or judge login. */
	private EnterLoginPanel myEnterLoginPanel;
	
	/** Panel to view privacy policy and contest rules. */
	private final BottomPanel myBottomPanel;
	
	private JPanel myCenterPanel;	
	
	/** Home menu item. */
	private static JButton myHomeButton;
	
	private String myDatabase;
	
	private CsvFileWriter myCsvWriter;
	
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
				} else if (Integer.parseInt(winner5.getMyAge()) < Integer.parseInt(contestant.getMyAverageScore())) {
					winner5 = contestant;
				}
			} else if (age < 11) {
				if (winner10 == null) {
					winner10 = contestant;
				} else if (Integer.parseInt(winner10.getMyAge()) < Integer.parseInt(contestant.getMyAverageScore())) {
					winner10 = contestant;
				}
			} else if (age < 16) {
				if (winner15 == null) {
					winner15 = contestant;
				} else if (Integer.parseInt(winner15.getMyAge()) < Integer.parseInt(contestant.getMyAverageScore())) {
					winner15 = contestant;
				}
			} else if (age < 19) {
				if (winner18 == null) {
					winner18 = contestant;
				} else if (Integer.parseInt(winner18.getMyAge()) < Integer.parseInt(contestant.getMyAverageScore())) {
					winner18 = contestant;
				}
			} else if (age > 18) {
				if (winner19 == null) {
					winner19 = contestant;
				} else if (Integer.parseInt(winner19.getMyAge()) < Integer.parseInt(contestant.getMyAverageScore())) {
					winner19 = contestant;
				}
			}
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public CsvFileWriter getMyCsvWriter() {
		return myCsvWriter;
	}
	
	public List<Contestant> getMyContestants() {
		return myContestants;
	}
	
	public static Dimension getFrameSize() {
		return FRAME_SIZE;
	}

	public WelcomePanel getMyWelcomePanel() {
		return myWelcomePanel;
	}

	public EnterLoginPanel getMyEnterLoginPanel() {
		return myEnterLoginPanel;
	}

	public BottomPanel getMyBottomPanel() {
		return myBottomPanel;
	}

	public JPanel getMyCenterPanel() {
		return myCenterPanel;
	}
	
	public void setMyCenterPanel(JPanel theCenterPanel){
		myCenterPanel = theCenterPanel;
	}
}
