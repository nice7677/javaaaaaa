package edu.kmi.primejavaC.JWC.View.Form;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import edu.kmi.primejavaC.JWC.Controller.FrontController;
import edu.kmi.primejavaC.JWC.View.Thread.LabelFlicker;

public class Intro_Form extends Parent_Form{
	/**
	 * Launch the application.
	 */
	Runnable Flicker;

	/**
	 * Create the application.
	 */
	public Intro_Form(FrontController control) {
		super(1024, 768, control);
		setTitle("My_Ideal_Type");
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//------------인트로 타이틀-------------------
		JLabel lblTitle = new JLabel("나의 이상형 찾기");
		lblTitle.setBounds(0, 61, 1006, 244);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("궁서체", Font.BOLD, 40));
		getContentPane().add(lblTitle);
		//----------------------------------------
		
		//--------깜빡거리는 레이블 구현------------------
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
		lblCreator.setFont(new Font("굴림", Font.BOLD, 20));
		lblCreator.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCreator.setBounds(683, 659, 309, 50);
		getContentPane().add(lblCreator);
		
		
		//----------키 이벤트 구현 부분 (아무 키나 입력받으면 Login_Form 으로 넘어감)-------
		this.requestFocus();
		this.addKeyListener(new AnyKeyListener(RunFlick));		//내부 이벤트 클래스로 작성
	}
	
	class AnyKeyListener implements KeyListener{
		Thread thd;
		public AnyKeyListener(Thread thd){
			this.thd = thd;
		}
		@Override
		public void keyPressed(java.awt.event.KeyEvent e) {
			// TODO Auto-generated method stub
			thd.interrupt();
			dispose();
			Login_Form Login = new Login_Form(getControl());
		}

		@Override
		public void keyReleased(java.awt.event.KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(java.awt.event.KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
}
