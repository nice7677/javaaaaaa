package edu.kmi.primejavaC.JWC.Controller.Event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import edu.kmi.primejavaC.JWC.View.Form.SignUp_Form;

public class SignUpEvent implements ActionListener {
	SignUp_Form frame;
	
	public SignUpEvent(SignUp_Form frame){
		this.frame = frame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String [] info = frame.join();		//[0] 은 id, [1]은 pw 값
		frame.getControl().open();
		int state = frame.getControl().dataInsert(info[0], info[1]);
		
		if(state == 1){
			JOptionPane.showMessageDialog(null, "Complete account registration");
			frame.dispose();
		}
		else{
			JOptionPane.showMessageDialog(null, "Failed to Register Account");
		}
		
		frame.getControl().close();
	}

}
