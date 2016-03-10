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
import javax.swing.filechooser.FileNameExtensionFilter;

import Model.Contestant;

public class RegisterPanel extends JPanel {
	
	private ContestGUI myJFrame;

	private JTextField myFirstNameField;
	
	private JTextField myLastNameField;
	
	private JTextField myAddressField;
	
	private JTextField myCityField;
	
	private JTextField myStateField;
	
	private JTextField myZipField;
	
	private JTextField myEmailField;
	
	private JTextField myAgeField;
	
	private JTextField myEntryField;
	
	private JButton myBrowseButton;
	
	private JButton myEnterButton;

	public RegisterPanel(ContestGUI theJFrame) {
		super();
		myJFrame = theJFrame;
		setBackground(Color.WHITE);
		setup();
		this.repaint();
	}
	
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
		add(myEntryField, grid);
		myBrowseButton = new JButton("Browse");
		browseListener();
		add(myBrowseButton, grid);
		myEnterButton = new JButton("Enter");
		add(myEnterButton);
		enterListener();
	}
	
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
						myJFrame.add(new EnterLoginPanel(RegisterPanel.this.myJFrame));
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
	
	public JFrame getMyJFrame() {
		return myJFrame;
	}

	public void setMyJFrame(ContestGUI myJFrame) {
		this.myJFrame = myJFrame;
	}

	public JTextField getMyFirstNameField() {
		return myFirstNameField;
	}

	public void setMyFirstNameField(JTextField myFirstNameField) {
		this.myFirstNameField = myFirstNameField;
	}

	public JTextField getMyLastNameField() {
		return myLastNameField;
	}

	public void setMyLastNameField(JTextField myLastNameField) {
		this.myLastNameField = myLastNameField;
	}

	public JTextField getMyAddressField() {
		return myAddressField;
	}

	public void setMyAddressField(JTextField myAddressField) {
		this.myAddressField = myAddressField;
	}

	public JTextField getMyCityField() {
		return myCityField;
	}

	public void setMyCityField(JTextField myCityField) {
		this.myCityField = myCityField;
	}

	public JTextField getMyStateField() {
		return myStateField;
	}

	public void setMyStateField(JTextField myStateField) {
		this.myStateField = myStateField;
	}

	public JTextField getMyZipField() {
		return myZipField;
	}

	public void setMyZipField(JTextField myZipField) {
		this.myZipField = myZipField;
	}

	public JTextField getMyEntryField() {
		return myEntryField;
	}

	public void setMyEntryField(JTextField myEntryField) {
		this.myEntryField = myEntryField;
	}
}
