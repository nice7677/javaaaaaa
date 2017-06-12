package edu.kmi.primejavaC.JWC.View;

import java.awt.EventQueue;

import edu.kmi.primejavaC.JWC.Controller.FrontController;
import edu.kmi.primejavaC.JWC.View.Form.Insert_Profile_Form;
import edu.kmi.primejavaC.JWC.View.Form.Intro_Form;

public class Running {
	public static void main(String[] args) {
		FrontController control = new FrontController();
		Intro_Form run = new Intro_Form(control);
	}
}
