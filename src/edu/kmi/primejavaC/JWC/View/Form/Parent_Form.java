package edu.kmi.primejavaC.JWC.View.Form;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import edu.kmi.primejavaC.JWC.Controller.FrontController;
import edu.kmi.primejavaC.JWC.Model.Member;

public class Parent_Form extends JFrame{
	private FrontController control;
	private Member info;
	
	//이 프레임을 상속받는 모든 폼은 너비와 높이를 파라미터로 받음
	public Parent_Form(int width, int height, FrontController control){
		initialize(width, height);
		setControl(control);
	}
	
	//파라미터로 받은 너비와 높이로 폼의 크기를 정하고, 위치가 항상 화면의 중앙에 오도록 함.
	private void initialize(int width, int height) {
		Dimension screen =Toolkit.getDefaultToolkit().getScreenSize();	//현재 모니터의 크기를 구하는 객체
		
		setSize(width, height);
		Dimension frameSize = super.getSize();	//현재 프레임의 크기를 구함
		
		//모니터의 크기에 상관없이 프레임이 항상 화면의 중앙에 오도록 함
		setLocation((screen.width - frameSize.width) / 2, (screen.height - frameSize.height) / 2);
		
		setVisible(true);
	}
	
	public FrontController getControl() {
		return control;
	}

	public void setControl(FrontController control) {
		this.control = control;
	}

	public Member getInfo() {
		return info;
	}

	public void setInfo(Member info) {
		this.info = info;
	}
	
}
