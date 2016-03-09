package View;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BottomPanel extends JPanel {

	public BottomPanel() {
		super();
		setBackground(Color.WHITE);
		add(RulesButton());
		add(PrivacyButton());
		add(JudgeLoginButton());
	}
	
	private JButton RulesButton() {
		return new JButton("Contest Rules");		
	}
	
	private JButton PrivacyButton() {
		return new JButton("Privacy Policy");		
	}
	
	private JButton JudgeLoginButton() {
		JButton button = new JButton("Judge Login");
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		return button;
	}
}

