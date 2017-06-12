package edu.kmi.primejavaC.JWC.Controller.Event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import edu.kmi.primejavaC.JWC.Controller.FrontController;
import edu.kmi.primejavaC.JWC.Model.Member;
import edu.kmi.primejavaC.JWC.View.Form.Insert_Profile_Form;
import edu.kmi.primejavaC.JWC.View.Form.Login_Form;
import edu.kmi.primejavaC.JWC.View.Form.Main_Form;

public class LoginEvent implements ActionListener {
	String id;
	String pw;
	Login_Form frame;
	Member info;
	public LoginEvent(Login_Form frame){
		this.frame = frame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String[] account = frame.get_Account();
		this.id = account[0];
		this.pw = account[1];
		
		frame.getControl().open();
		try {
			info = frame.getControl().checkUser(id, pw);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("ssss??");
		}
		frame.getControl().close();
		
		if(!(info == null)){
			
			if(info.getProfilecheck() == 1){
				frame.dispose();
				Main_Form main_frame = new Main_Form(frame.getControl(), info);
			}
			else{
				Insert_Profile_Form insert_form = new Insert_Profile_Form(frame.getControl());
			}
		}
		else{
			JOptionPane.showMessageDialog(null, "ID or Password does not match");
		}
		/*if(member.getProfilecheck() == 1){
			frame.dispose();
			Main_Form main_frame = new Main_Form(frame.getControl(), info);
		}
		else{
			Insert_Profile_Form insert_form = new Insert_Profile_Form(frame.getControl());
		}*/
	}

}
