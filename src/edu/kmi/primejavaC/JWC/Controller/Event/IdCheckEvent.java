package edu.kmi.primejavaC.JWC.Controller.Event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class IdCheckEvent implements ActionListener {
	String id;
	JFrame frame;
	
	public IdCheckEvent(JFrame frame){
		this.frame = frame;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
