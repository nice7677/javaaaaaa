package edu.kmi.primejavaC.JWC.View;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import edu.kmi.primejavaC.JWC.View.Thread.LabelFlicker;

public class Intro_Form extends JFrame{
	/**
	 * Launch the application.
	 */
	Runnable Flicker;

	/**
	 * Create the application.
	 */
	public Intro_Form() {
		setTitle("My_Ideal_Type");
		getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("나의 이상형 찾기");
		lblTitle.setBounds(0, 61, 1006, 244);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("궁서체", Font.BOLD, 40));
		getContentPane().add(lblTitle);
		
		//--------깜빡거리는 레이블 구현
		JLabel lblKey = new JLabel("Press any key!!");
		Flicker = new LabelFlicker(lblKey);
		Thread RunFlick = new Thread(Flicker);
		RunFlick.start();
		lblKey.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 23));
		lblKey.setHorizontalAlignment(SwingConstants.CENTER);
		lblKey.setBounds(254, 441, 476, 115);
		
		getContentPane().add(lblKey);
		//------------------------------------------
		
		
		JLabel lblCreator = new JLabel("Created By 이진우, 윤 철");
		lblCreator.setFont(new Font("굴림", Font.PLAIN, 20));
		lblCreator.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCreator.setBounds(683, 659, 309, 50);
		getContentPane().add(lblCreator);
		
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
