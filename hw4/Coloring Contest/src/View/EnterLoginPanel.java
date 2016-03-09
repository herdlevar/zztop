package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class EnterLoginPanel extends JPanel {
	
	public EnterLoginPanel() throws IOException {
		super();
		setupPanel();
	}
	
	private void setupPanel() {
		JPanel north = new JPanel();
		north.setBackground(Color.WHITE);
		JPanel south = new JPanel();	
		south.setBackground(Color.WHITE);
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		north.add(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("Resources/Pic.png"))));
		south.add(EnterButton());
		south.add(DownloadPicButton());
		add(north, BorderLayout.NORTH);
		add(south, BorderLayout.CENTER);
	}
	
	private JButton EnterButton() {
		JButton button = new JButton("Enter Contest");
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		button.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
            	
            }
        });  
		return button;
	}
	
	private JButton DownloadPicButton() {
		JButton button = new JButton("Download Pictures");
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		return button;
	}
}
