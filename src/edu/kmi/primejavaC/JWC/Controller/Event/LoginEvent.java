package edu.kmi.primejavaC.JWC.Controller.Event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import edu.kmi.primejavaC.JWC.Controller.FrontController;
import edu.kmi.primejavaC.JWC.View.Form.Login_Form;

public class LoginEvent implements ActionListener {
	String id;
	String pw;
	Login_Form frame;
	public LoginEvent(Login_Form control, String id, char[] pw){
		this.id = id;
		this.pw = new String(pw, 0, pw.length);
		this.frame = control;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
