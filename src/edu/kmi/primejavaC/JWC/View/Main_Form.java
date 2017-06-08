package edu.kmi.primejavaC.JWC.View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Main_Form extends JFrame {
	/**
	 * Create the frame.
	 */
	public Main_Form() {
		setTitle("Find your ideal-type!!");
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAccount = new JMenu("Account");
		menuBar.add(mnAccount);
		
		JMenuItem miSignout = new JMenuItem("SignOut");
		mnAccount.add(miSignout);
		initialize();
	}
	
	private void initialize() {
		Dimension screen =Toolkit.getDefaultToolkit().getScreenSize();	//현재 모니터의 크기를 구하는 객체
		
		setSize(1024, 768);
		Dimension frameSize = super.getSize();	//현재 프레임의 크기를 구함
		
		//모니터의 크기에 상관없이 프레임이 항상 화면의 중앙에 오도록 함
		setLocation((screen.width - frameSize.width) / 2, (screen.height - frameSize.height) / 2);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		setVisible(true);
	}
}
