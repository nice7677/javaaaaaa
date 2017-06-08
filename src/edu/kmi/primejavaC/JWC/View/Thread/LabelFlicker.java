package edu.kmi.primejavaC.JWC.View.Thread;

import javax.swing.JLabel;

public class LabelFlicker implements Runnable {
	JLabel lbl;
	public LabelFlicker(JLabel lbl){
		this.lbl = lbl;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			while(true){
				if(lbl.isVisible())
					lbl.setVisible(false);
				else
					lbl.setVisible(true);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Flicker 종료.");
		}
	}

}
