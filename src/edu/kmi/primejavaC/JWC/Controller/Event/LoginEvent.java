package edu.kmi.primejavaC.JWC.Controller.Event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import edu.kmi.primejavaC.JWC.Controller.FrontController;

public class LoginEvent implements ActionListener {
	String id;
	String pw;
	public LoginEvent(String id, char[] pw){
		this.id = id;
		this.pw = new String(pw, 0, pw.length);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
