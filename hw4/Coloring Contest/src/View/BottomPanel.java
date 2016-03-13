package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BottomPanel extends JPanel {
	
	private ContestGUI myJFrame;

	public BottomPanel(ContestGUI theJFrame) {
		super();
		myJFrame = theJFrame;
		setBackground(Color.WHITE);
		add(RulesButton());
		add(PrivacyButton());
		add(JudgeLoginButton());
		add(HomeButton());
	}
	
	private JButton RulesButton() {
		JButton button = new JButton("Contest Rules");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "The contest is open to all ages\n\n"
						+ "Age Brackets are 0-5, 6-10, 11-15, 16-18, 19+\n\n"
						+ "The winner is awarded free book checkouts for life from the library!\n\n"
						+ "The contest ends March 30th and winner will be notified April 4th");
			}
		});
		return button;
	}
	
	private JButton PrivacyButton() {
		JButton button = new JButton("Privacy Policy");
		button.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
            	JOptionPane.showMessageDialog(null, "Here is where the privacy policy would be displayed.");
            }
        });  
		return button;		
	}
	
	private JButton JudgeLoginButton() {
		JButton button = new JButton("Judge Login");
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		button.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
            	myJFrame.remove(myJFrame.getMyCenterPanel());
            	JudgeLoginPanel judge = new JudgeLoginPanel(myJFrame);
            	myJFrame.setMyCenterPanel(judge);
                myJFrame.add(judge, BorderLayout.CENTER); 
                myJFrame.validate();
                myJFrame.repaint();
            }
        });
		return button;
	}
	
	private JButton HomeButton() {
		JButton button = new JButton("Home");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myJFrame.remove(myJFrame.getMyCenterPanel());
            	EnterLoginPanel panel = null;
				try {
					panel = new EnterLoginPanel(myJFrame);
					myJFrame.setMyCenterPanel(panel);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	myJFrame.setMyCenterPanel(panel);
                myJFrame.add(panel, BorderLayout.CENTER); 
                myJFrame.validate();
                myJFrame.repaint();
			}
		});
		return button;
	}
}

