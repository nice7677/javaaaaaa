package edu.kmi.primejavaC.JWC.View;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Login_Form extends JFrame{

	/**
	 * Launch the application.
	 */
	

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
		Dimension screen =Toolkit.getDefaultToolkit().getScreenSize();	//현재 모니터의 크기를 구하는 객체
		
		setSize(1024, 768);
		Dimension frameSize = super.getSize();	//현재 프레임의 크기를 구함
		
		//모니터의 크기에 상관없이 프레임이 항상 화면의 중앙에 오도록 함
		setLocation((screen.width - frameSize.width) / 2, (screen.height - frameSize.height) / 2);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}
