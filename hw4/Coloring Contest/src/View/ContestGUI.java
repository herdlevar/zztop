package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ContestGUI extends JFrame implements Observer, PropertyChangeListener{
	
	// Constants
	
	/** Frame size when removed from full screen. */
	private static final Dimension FRAME_SIZE = new Dimension(800, 600);
	
	// Fields
	
	/** Welcome screen panel. */
	private final WelcomePanel myWelcomePanel;
	
	/** Panel to enter, download, or judge login. */
	private final EnterLoginPanel myEnterLoginPanel;
	
	/** Panel to view privacy policy and contest rules. */
	private final BottomPanel myBottomPanel;
	

	/** The menu bar for the GUI. */
	private static JMenuBar myMenuBar;
	
	/**
	 * Constructs the coloring contest GUI
	 * @throws IOException 
	 */
	public ContestGUI() throws IOException {
		// empty constructor
		super("Coloring Contest");
		myMenuBar = new JMenuBar();
		myMenuBar.add(new JMenu("Test"));
		this.setJMenuBar(myMenuBar);
		
		myWelcomePanel = new WelcomePanel();
		myEnterLoginPanel = new EnterLoginPanel();
		myBottomPanel = new BottomPanel();
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

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
}
