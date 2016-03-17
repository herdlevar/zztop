package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * This Panel is the landing page for the site. From here users can register and download pictures.
 *
 * @author Zach Martinez, Jared Herdlevar, Jake Nasanov
 * @date March 17, 2016
 */
public class EnterLoginPanel extends JPanel {
	
	/** The JFrame this panel is in. */
	private ContestGUI myJFrame;
	
	/** Constructor for this Panel.
	 * 
	 * @param theJFrame
	 * @throws IOException
	 */
	public EnterLoginPanel(ContestGUI theJFrame) throws IOException {
		super();
		myJFrame = theJFrame;
		setupPanel();
	}
	
	/**
	 * Sets up the panel.
	 */
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
	
	/**
	 * Sets up and returns the button to enter the contest.
	 * @return The enter contest button.
	 */
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
	
	/**
	 * Sets up and returns the button to download pictures.
	 * @return The button to download pictures.
	 */
	private JButton DownloadPicButton() {
		JButton button = new JButton("Download Pictures");
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				URL url = null;
				try {
					url = new URL("http://www.sapphirestudios.net/kids/printablecoloringpages.PDF");
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JFileChooser chooser = new JFileChooser();
				int userSelection = chooser.showSaveDialog(null);
				if (userSelection == JFileChooser.APPROVE_OPTION) { 
					chooser.setSelectedFile(new File(chooser.getSelectedFile().toString() + ".pdf"));
					try {
						org.apache.commons.io.FileUtils.copyURLToFile(url, chooser.getSelectedFile());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			
		});
		return button;
	}
}
