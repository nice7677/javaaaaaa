package edu.kmi.primejavaC.JWC.View.Form;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.kmi.primejavaC.JWC.Controller.FrontController;
import edu.kmi.primejavaC.JWC.Model.Member;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Main_Form extends Parent_Form {
	/**
	 * Create the frame.
	 */
	public Main_Form(FrontController control, Member info) {
		super(1024, 768, control);
		setInfo(info);
		
		setTitle("Find your ideal-type!!");
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAccount = new JMenu("Account");
		menuBar.add(mnAccount);
		
		JMenuItem miSignout = new JMenuItem("SignOut");
		mnAccount.add(miSignout);
	}
}
