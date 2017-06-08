package edu.kmi.primejavaC.JWC.View;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Login_Form {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_Form window = new Login_Form();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Asdasd");
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login_Form() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
