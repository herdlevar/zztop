package View;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Model.Contestant;

/**
 * A panel to enter the contest.
 * 
 * @author Nick Martinez, Jared Herdlevar, Jake Nasanov
 * @date March 17, 2016
 *
 */
public class RegisterPanel extends JPanel {
	
	/** The frame this panel sits in. */
	private ContestGUI myJFrame;

	/** Test field for first name. */
	private JTextField myFirstNameField;
	
	/** Field for last name. */
	private JTextField myLastNameField;
	
	/** Field for address. */
	private JTextField myAddressField;
	
	/** Field for the city. */
	private JTextField myCityField;
	
	/** Field for the state. */
	private JTextField myStateField;
	
	/** Field for the zip. */
	private JTextField myZipField;
	
	/** Field for the email. */
	private JTextField myEmailField;
	
	/** Field for age. */
	private JTextField myAgeField;
	
	/** Field for the file. */
	private JTextField myEntryField;
	
	/** Button to browse files. */
	private JButton myBrowseButton;
	
	/** Button to submit. */
	private JButton myEnterButton;

	/**
	 * Creates new panel.
	 * @param theJFrame
	 */
	public RegisterPanel(ContestGUI theJFrame) {
		super();
		myJFrame = theJFrame;
		setBackground(Color.WHITE);
		setup();
		this.repaint();
	}
	
	// sets up the panel.
	private void setup() {
		GridLayout grid = new GridLayout(16, 2);
		this.setLayout(grid);
		this.add(new JLabel("First Name", SwingConstants.RIGHT), grid);
		myFirstNameField = new JTextField(1);
		add(myFirstNameField, grid);
		add(new JLabel("Last Name", SwingConstants.RIGHT), grid);
		myLastNameField = new JTextField();
		add(myLastNameField, grid);
		add(new JLabel("Address", SwingConstants.RIGHT), grid);
		myAddressField = new JTextField();
		add(myAddressField, grid);
		add(new JLabel("City", SwingConstants.RIGHT), grid);
		myCityField = new JTextField();
		add(myCityField, grid);
		add(new JLabel("State", SwingConstants.RIGHT), grid);
		myStateField = new JTextField();
		add(myStateField, grid);
		add(new JLabel("Zip", SwingConstants.RIGHT), grid);
		myZipField = new JTextField();
		add(myZipField, grid);
		add(new JLabel("Email", SwingConstants.RIGHT), grid);
		myEmailField = new JTextField();
		add(myEmailField, grid);
		add(new JLabel("Age", SwingConstants.RIGHT), grid);
		myAgeField = new JTextField();
		add(myAgeField, grid);
		add(new JLabel("Entry", SwingConstants.RIGHT), grid);
		myEntryField = new JTextField();
		myEntryField.setEditable(false);
		add(myEntryField, grid);
		myBrowseButton = new JButton("Browse");
		browseListener();
		add(myBrowseButton, grid);
		myEnterButton = new JButton("Enter");
		add(myEnterButton);
		enterListener();
	}
	
	// Adds listener to the browse button.
	private void browseListener() {
		myBrowseButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myEntryField.setText("");
				JFileChooser chooser = new JFileChooser();
				
				int result = chooser.showOpenDialog(null);
				
				if (result == JFileChooser.APPROVE_OPTION) {
					myEntryField.setText(chooser.getSelectedFile().getAbsolutePath());
				}
			}
		});
	}
	
	// Adds listener to the enter button.
	private void enterListener() {
		myEnterButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (myFirstNameField.getText().isEmpty() || myLastNameField.getText().isEmpty() || myAddressField.getText().isEmpty() || myCityField.getText().isEmpty() || myStateField.getText().isEmpty() || myZipField.getText().isEmpty() || myEmailField.getText().isEmpty() || myAgeField.getText().isEmpty() || myEntryField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please enter all fields");
				} else {
					Contestant contestant = new Contestant();
					String[] values = {myFirstNameField.getText(),myLastNameField.getText(),myAddressField.getText(),myCityField.getText(),myStateField.getText(),myZipField.getText(),myEmailField.getText(), myAgeField.getText(), myEntryField.getText(),"0","0","0","0"};
					contestant.addValues(values);
					myJFrame.getMyContestants().add(contestant);
					myJFrame.remove(RegisterPanel.this);
					try {
						EnterLoginPanel panel = new EnterLoginPanel(RegisterPanel.this.myJFrame);
						myJFrame.setMyCenterPanel(panel);
						myJFrame.add(panel);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					myJFrame.validate();
					myJFrame.repaint();
					try {
						myJFrame.getMyCsvWriter().addContestant(contestant);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "You have successfully entered the coloring contest!");
				}
			}
			
		});
	}
	
	/**
	 * Gets the JFrame.
	 * @return The JFrame
	 */
	public JFrame getMyJFrame() {
		return myJFrame;
	}

	/**
	 * Sets the jframe.
	 * @param myJFrame
	 */
	public void setMyJFrame(ContestGUI myJFrame) {
		this.myJFrame = myJFrame;
	}

	/**
	 * Gets the first name.
	 * @return First name
	 */
	public JTextField getMyFirstNameField() {
		return myFirstNameField;
	}

	/**
	 * Sets the first name.
	 * @param myFirstNameField
	 */
	public void setMyFirstNameField(JTextField myFirstNameField) {
		this.myFirstNameField = myFirstNameField;
	}

	/**
	 * Gets last name.
	 * @return Last name
	 */
	public JTextField getMyLastNameField() {
		return myLastNameField;
	}

	/**
	 * Sets the last name.
	 * @param myLastNameField
	 */
	public void setMyLastNameField(JTextField myLastNameField) {
		this.myLastNameField = myLastNameField;
	}

	/**
	 * Gets adress
	 * @return Address
	 */
	public JTextField getMyAddressField() {
		return myAddressField;
	}

	/**
	 * Sets the address.
	 * @param myAddressField
	 */
	public void setMyAddressField(JTextField myAddressField) {
		this.myAddressField = myAddressField;
	}

	/**
	 * Gets the city
	 * @return The city
	 */
	public JTextField getMyCityField() {
		return myCityField;
	}

	/**
	 * Sets the city.
	 * @param myCityField
	 */
	public void setMyCityField(JTextField myCityField) {
		this.myCityField = myCityField;
	}

	/**
	 * Gets the state.
	 * @return The state
	 */
	public JTextField getMyStateField() {
		return myStateField;
	}

	/**
	 * Sets the state.
	 * @param myStateField
	 */
	public void setMyStateField(JTextField myStateField) {
		this.myStateField = myStateField;
	}

	/**
	 * Gets the zip.
	 * @return The zip
	 */
	public JTextField getMyZipField() {
		return myZipField;
	}

	/**
	 * Sets the zip.
	 * @param myZipField
	 */
	public void setMyZipField(JTextField myZipField) {
		this.myZipField = myZipField;
	}

	/**
	 * Gets the entry path.
	 * @return
	 */
	public JTextField getMyEntryField() {
		return myEntryField;
	}

	/**
	 * Sets the entry path.
	 * @param myEntryField
	 */
	public void setMyEntryField(JTextField myEntryField) {
		this.myEntryField = myEntryField;
	}
}
