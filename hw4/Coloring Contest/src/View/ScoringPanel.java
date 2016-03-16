package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.Contestant;
import Model.Judge;

/**
 * This panel allows the judges to score the entries.
 *
 */
public class ScoringPanel extends JPanel {
	
	/** The JFrame of the program. */
	private ContestGUI myJFrame;
	
	/** The judge who is logged in. */
	private Judge myJudge;
	
	/** The panel where judges score. */
	private JPanel myScorePanel;
	
	/** The image to score. */
	private JLabel myImage;
	
	/** The button to submit scores. */
	private JButton mySubmitButton;
	
	/** The ComboBox with allowable scores. */
	private JComboBox myComboBox;
	
	/** The list of contestants. */
	private List<Contestant> myContestants;
	
	/** Index for iterating through contestants. */
	private int myIndex;
	
	/** Label for instructions. */
	private JLabel myInstructions;
	
	/**
	 * Creates a new scoring panel.
	 * @param theJFrame
	 * @param theJudge
	 */
	public ScoringPanel(ContestGUI theJFrame, Judge theJudge) {
		super();
		myJFrame = theJFrame;
		myJudge = theJudge;
		myScorePanel = new JPanel();
		myImage = new JLabel();
		myContestants = theJFrame.getMyContestants();
		myIndex = -1;
		mySubmitButton = new JButton("Submit");
		String[] ints = {"1","2","3","4","5","6","7","8","9","10"};
		myComboBox = new JComboBox(ints);
		myInstructions = new JLabel("Click submit to begin judging");
		setup();
	}
	
	/**
	 * Sets up the scoring panel.
	 */
	private void setup() {
		this.setBackground(Color.WHITE);
		myScorePanel.setBackground(Color.WHITE);
		this.add(myScorePanel, BorderLayout.CENTER);
		myScorePanel.setLayout(new BoxLayout(myScorePanel, BoxLayout.PAGE_AXIS));
		//setImage();
		myScorePanel.add(myInstructions);
		myScorePanel.add(myImage);
		myComboBox.setSelectedIndex(0);
		myScorePanel.add(myComboBox);		
		myScorePanel.add(mySubmitButton);
		addListener();
	}
	
	// Checks to see if the logged in judge already voted,
	private void voted() {
		if (myIndex >= myContestants.size()) return;
		for (Contestant cont : myContestants) {
			if(myJudge.isMyJudgeA()) {
				if (Integer.parseInt(myContestants.get(myIndex).getMyScoreA()) > 0) {
					myIndex++;
				} else {
					return;
				}
			} else if(myJudge.isMyJudgeB()) {
				if (Integer.parseInt(myContestants.get(myIndex).getMyScoreB()) > 0) {
					myIndex++;
				} else {
					return;
				}
			} else if(myJudge.isMyJudgeC()) {
				if (Integer.parseInt(myContestants.get(myIndex).getMyScoreC()) > 0) {
					myIndex++;
				} else {
					return;
				}
			}
		}
	}
	
	// Adds listener to the submit button.
	private void addListener() {
		mySubmitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (myIndex == -1) {
					myIndex++;
					myScorePanel.remove(myInstructions);
					setImage();
					return;
				}
				int judgeOffset = -1;
				if (myIndex < myContestants.size()) {
					if(myJudge.isMyJudgeA()) {
						myContestants.get(myIndex).setMyScoreA((String) myComboBox.getSelectedItem());
						judgeOffset = 9;
					} else if(myJudge.isMyJudgeB()) {
						myContestants.get(myIndex).setMyScoreB((String) myComboBox.getSelectedItem());
						judgeOffset = 10;
					} else if(myJudge.isMyJudgeC()) {
						myContestants.get(myIndex).setMyScoreC((String) myComboBox.getSelectedItem());
						judgeOffset = 11;
					}
				}				
				try {
					if (myIndex != myContestants.size()) {
						myJFrame.getMyCsvWriter().addScore(myIndex, (String) myComboBox.getSelectedItem(), judgeOffset);
						myIndex++;
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setImage();
				myJFrame.validate();
				myJFrame.repaint();
			}
			
		});
	}
	
	// Sets the image to be scored.
	private void setImage() {
		voted();
		if (myContestants.isEmpty() || myIndex >= myContestants.size()) {
			myImage = new JLabel("No more entries");
			myScorePanel.add(myImage);
			myJFrame.findWinners();
			showWinners();
			mySubmitButton.setEnabled(false);;
			myScorePanel.validate();
			myScorePanel.repaint();
			return;
		}
		Image image = new ImageIcon(myContestants.get(myIndex).getMyEntry()).getImage().getScaledInstance(800, 600, java.awt.Image.SCALE_SMOOTH);
		myImage.setIcon(new ImageIcon(image));// = new JLabel(new ImageIcon(image));
		myImage.setSize(800, 600);
		myJFrame.validate();
		myJFrame.repaint();
	}
	
	// Displays winners after going though all the contestants.
	private void showWinners() {
		JLabel header = new JLabel("Current Winners");
		myScorePanel.add(header);
		JLabel five = new JLabel("Ages 0-5");
		JLabel fiveWinner;
		if (myJFrame.getWinner5() != null) {;
			fiveWinner = new JLabel("Name: " + myJFrame.getWinner5().getMyFirstName() + " " + myJFrame.getWinner5().getMyLastName() + " Email: " + myJFrame.getWinner5().getMyEmail());
		} else {
			fiveWinner = new JLabel("No entry");
		}
		myScorePanel.add(five);
		myScorePanel.add(fiveWinner);
		JLabel ten = new JLabel("Ages 6-10");
		JLabel tenWinner;
		if (myJFrame.getWinner10() != null) {
			tenWinner = new JLabel("Name: " + myJFrame.getWinner10().getMyFirstName() + " " + myJFrame.getWinner10().getMyLastName() + " Email: " + myJFrame.getWinner10().getMyEmail());
		} else {
			tenWinner = new JLabel("No entry");
		}
		myScorePanel.add(ten);
		myScorePanel.add(tenWinner);
		JLabel fifteen = new JLabel("Ages 11-15");
		JLabel fifteenWinner;
		if (myJFrame.getWinner15() != null) {
			fifteenWinner = new JLabel("Name: " + myJFrame.getWinner15().getMyFirstName() + " " + myJFrame.getWinner15().getMyLastName() + " Email: " + myJFrame.getWinner15().getMyEmail());
		} else {
			fifteenWinner = new JLabel("No entry");
		}
		myScorePanel.add(fifteen);
		myScorePanel.add(fifteenWinner);
		JLabel eightteen = new JLabel("Ages 16-18");
		JLabel eightteenWinner;
		if (myJFrame.getWinner18() != null) {
			eightteenWinner = new JLabel("Name: " + myJFrame.getWinner18().getMyFirstName() + " " + myJFrame.getWinner18().getMyLastName() + " Email: " + myJFrame.getWinner18().getMyEmail());
		} else {
			eightteenWinner = new JLabel("No entry");
		}
		myScorePanel.add(eightteen);
		myScorePanel.add(eightteenWinner);
		JLabel nineteen = new JLabel("Ages 19+");
		JLabel nineteenWinner;
		if (myJFrame.getWinner19() != null) {
			nineteenWinner = new JLabel("Name: " + myJFrame.getWinner19().getMyFirstName() + " " + myJFrame.getWinner19().getMyLastName() + " Email: " + myJFrame.getWinner19().getMyEmail());
		} else {
			nineteenWinner = new JLabel("No entry");
		}		
		myScorePanel.add(nineteen);
		myScorePanel.add(nineteenWinner);
	}

}
