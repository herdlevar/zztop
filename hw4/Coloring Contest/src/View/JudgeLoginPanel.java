package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Model.Judge;

/**
 * The judges login panel.
 * 
 * @author Zach Martinez, Nick Dantche, Jake Nasanov
 * @date March 17, 2016
 *
 */
public class JudgeLoginPanel extends JPanel {

	/** The frame this panel sits in. */
	private ContestGUI myJFrame;
	
	/** Test field for judge user name. */
	private JTextField myJudgeField;
	
	/** Test field for password. */
	private JPasswordField myPasswordField;
	
	/** Button to login. */
	private JButton myLoginButton;
	
	/** 
	 * Creates a new panel.
	 * @param theJFrame
	 */
	public JudgeLoginPanel(ContestGUI theJFrame) {
		super();
		myJFrame = theJFrame;
		myJudgeField = new JTextField();
		myPasswordField = new JPasswordField();
		myLoginButton = new JButton("Login");
		setup();
	}
	
	// Sets up the panel.
	private void setup() {
		GridLayout grid = new GridLayout(3,2);
		this.setBackground(Color.WHITE);
		this.setLayout(grid);
		add(new JLabel("Judge", SwingConstants.RIGHT), grid);
		myJudgeField.setPreferredSize(new Dimension(1, 12));
		add(myJudgeField, grid);
		add(new JLabel("Password", SwingConstants.RIGHT), grid);
		add(myPasswordField, grid);
		addListener();
		add(myLoginButton, grid);
	}
	
	// Adds listener to login button.
	private void addListener() {
		myLoginButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (myJudgeField.getText().isEmpty() || myPasswordField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please enter all fields");
				} else {
					Judge judge = new Judge(myJudgeField.getText(), myPasswordField.getText());
					if (judge.loggedIn()) {
						myJFrame.remove(JudgeLoginPanel.this);
						ScoringPanel score = new ScoringPanel(myJFrame, judge);
						myJFrame.add(score);
						myJFrame.setMyCenterPanel(score);
						myJFrame.validate();
						myJFrame.repaint();
						myJFrame.getMyBottomPanel().getMyHomeButton().setText("Logout");
					} else {
						JOptionPane.showMessageDialog(null, "Incorrect Login");
					}
				}
				
			}
			
		});
	}
}
