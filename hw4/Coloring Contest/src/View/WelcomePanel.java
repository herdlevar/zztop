package View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WelcomePanel extends JPanel {
	
	private JFrame myJFrame;

	/**
	 * Constructs the welcome screen panel
	 */
	public WelcomePanel(JFrame theJFrame) {
		super();
		myJFrame = theJFrame;
		setBackground(Color.white);
		add(WelcomeBanner());
	}
	
	private JLabel WelcomeBanner() {
		JLabel welcomeLabel = new JLabel("Library Coloring Contest");
		welcomeLabel.setFont(new Font("Stencil", 1, 20));
		return welcomeLabel;
	}
}
