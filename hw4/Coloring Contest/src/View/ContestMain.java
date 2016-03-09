package View;

import java.awt.EventQueue;
import java.io.IOException;

public class ContestMain {
	
	private static ContestGUI myGUI;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
				try {
					myGUI = new ContestGUI();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	setup();
            }
		});
	}
	
	private static void setup() {
		myGUI.start();
	}

}
