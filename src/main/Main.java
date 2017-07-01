package main;

import javax.swing.JFrame;

import buttons.Buttons;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		Buttons window = new Buttons("Окошечко");
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(860, 750);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		
	
		
	}

}
