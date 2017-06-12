package edu.kmi.primejavaC.JWC.Controller.Event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import edu.kmi.primejavaC.JWC.Controller.DAO.MemberDao;

public class LoginEvent implements ActionListener {
	String id;
	String pw;
	MemberDao dao;
	public LoginEvent(String id, char[] pw){
		this.id = id;
		dao = new MemberDao();
		this.pw = new String(pw, 0, pw.length);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			dao.idCheck(id, pw);
		} catch (SQLException error) {
			// TODO Auto-generated catch block
			error.printStackTrace();
		}
	}

}
