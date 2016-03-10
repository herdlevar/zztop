package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EnterLoginPanel extends JPanel {
	
	private ContestGUI myJFrame;
	
	public EnterLoginPanel(ContestGUI theJFrame) throws IOException {
		super();
		myJFrame = theJFrame;
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
            	myJFrame.remove(EnterLoginPanel.this);
            	RegisterPanel panel = new RegisterPanel(myJFrame);
            	myJFrame.setMyCenterPanel(panel);
                myJFrame.add(panel, BorderLayout.CENTER); 
                myJFrame.validate();
                myJFrame.repaint();
            }
        });  
		return button;
	}
	
	private JButton DownloadPicButton() {
		JButton button = new JButton("Download Pictures");
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
//				URL input = getClass().getClassLoader().getResource("Resources/pics.zip");
//				System.out.println(input.toString());
//				JFileChooser chooser = new JFileChooser();
//				chooser.showSaveDialog(null);
//				File file = chooser.getSelectedFile();
//				file.
//				FileUtils util = new FileUtils();
//				FileUtils.copyURLToFile(input, file);
			}
			
		});
		return button;
	}
}
