package Model;

import java.awt.EventQueue;

public class ContestMain {
	
	private static ContestGUI myGUI;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
            	myGUI = new ContestGUI();
            	setup();
            }
		});
	}
	
	private static void setup() {
		myGUI.start();
	}

}
