package edu.kmi.primejavaC.JWC.Controller.Event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import edu.kmi.primejavaC.JWC.Model.Member;
import edu.kmi.primejavaC.JWC.View.Form.Insert_Profile_Form;
import edu.kmi.primejavaC.JWC.View.Form.Main_Form;

public class ProfileInsertEvent implements ActionListener {
	Insert_Profile_Form frame;
	Member info;
	
	public ProfileInsertEvent(Insert_Profile_Form frame){
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(frame.insert_Check()){
			info = frame.insert_Profile();
			
			frame.getControl().open();
			frame.getControl().dataProfile(info.getId(), info.getName(), info.getAge(), info.getGender(),
					info.getRegion(), info.getPhone(), info.getIntro(), info.getBloodT(),
					info.getMyType(), info.getMyTypeB());
			frame.getControl().close();
			
			frame.dispose();
			Main_Form main_frame = new Main_Form(frame.getControl(), info);
		}
		else
			JOptionPane.showMessageDialog(null, "Please enter all profiles");
	}

}
