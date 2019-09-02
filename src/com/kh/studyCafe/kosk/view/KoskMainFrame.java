package com.kh.studyCafe.kosk.view;

import javax.swing.JFrame;

public class KoskMainFrame extends JFrame{
	
	public KoskMainFrame() {
		this.setBounds(500, 0, 360, 640);
		this.setLayout(null);
		
    new Login(this);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}

// public class KoskMainFrame extends JFrame{
// 	public KoskMainFrame() {
// 		this.setSize(360,640);
		
// 		new Login(this);
		
// 		this.setVisible(true);
// 		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// 	}
	
// }
