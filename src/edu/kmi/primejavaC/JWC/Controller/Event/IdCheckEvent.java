package edu.kmi.primejavaC.JWC.Controller.Event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import edu.kmi.primejavaC.JWC.View.Form.SignUp_Form;

public class IdCheckEvent implements ActionListener {
	String id;
	SignUp_Form frame;
	
	public IdCheckEvent(SignUp_Form frame){
		this.frame = frame;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			frame.getControl().open();
			
			if(frame.getControl().idCheck(id)){
				JOptionPane.showMessageDialog(null, "Available ID");
				frame.setId_chk(true);
			}
			else{
				JOptionPane.showMessageDialog(null, "Unable to use ID");
				frame.setId_chk(false);
			}
			
			frame.getControl().close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
