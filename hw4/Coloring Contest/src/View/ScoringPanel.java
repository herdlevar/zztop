package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
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

public class ScoringPanel extends JPanel {
	
	private ContestGUI myJFrame;
	
	private Judge myJudge;
	
	private JPanel myLogoutPanel;
	
	private JPanel myScorePanel;
	
	private JLabel myImage;
	
	private JButton mySubmitButton;
	
	private JComboBox myComboBox;
	
	private List<Contestant> myContestants;
	
	private int myIndex;
	
	private JLabel myInstructions;
	
	public ScoringPanel(ContestGUI theJFrame, Judge theJudge) {
		super();
		myJFrame = theJFrame;
		myJudge = theJudge;
		myLogoutPanel = new JPanel();
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
	
	private void setup() {
		this.setBackground(Color.WHITE);
		myLogoutPanel.setBackground(Color.WHITE);
		myScorePanel.setBackground(Color.WHITE);
		this.add(myScorePanel, BorderLayout.CENTER);
		this.add(myLogoutPanel, BorderLayout.CENTER);
		myScorePanel.setLayout(new BoxLayout(myScorePanel, BoxLayout.PAGE_AXIS));
		//setImage();
		myScorePanel.add(myInstructions);
		myScorePanel.add(myImage);
		myComboBox.setSelectedIndex(0);
		myScorePanel.add(myComboBox);		
		myScorePanel.add(mySubmitButton);
		addListener();
	}
	
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
	
	private void setImage() {
		voted();
		if (myContestants.isEmpty() || myIndex >= myContestants.size()) {
			myImage = new JLabel("No more entries");
			myScorePanel.add(myImage);
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

}
