package com.kh.studyCafe.kosk.view;

import javax.swing.JFrame;
 
public class KoskMainFrame extends JFrame{
	public KoskMainFrame() {
		this.setSize(360,640);
		

		this.add(new KoskLogin());
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	} 
	
}
