package com.kh.studyCafe.kosk.view;

import javax.swing.JPanel;


public class ChangePanel{
 
	public static void changePanel(JPanel op, JPanel np) {
		op.removeAll();
		op.add(np);
		op.repaint();
	}

}
