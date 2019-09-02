package com.kh.studyCafe.kosk.view;

import javax.swing.JPanel;


public class ChangePanel{

	public static void changePanel(KoskMainFrame mf, JPanel op, JPanel np) {
		mf.remove(op);
		mf.add(np);
		mf.repaint();
	}
}
