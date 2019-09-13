package com.kh.studyCafe.kosk.view;

import java.awt.Component;

import javax.swing.JPanel;

public class ChangePanel{
	
	public static void changePanel(KoskMainFrame mf, JPanel op, JPanel np) {
		mf.remove(op);
		mf.add(np,0);
		mf.repaint();
	}
	
	public static void addPanel(KoskMainFrame mf, JPanel op, JPanel np) { // 있던 패널 유지하고 새 패널 올리긴
		for (Component cp : op.getComponents()){
	           cp.setEnabled(false);
	      }
		mf.add(np, 1, 0);
		mf.repaint();
	}
	
	public static void popchangePanel(KoskMainFrame mf, JPanel op, JPanel np) {
		for (Component cp : np.getComponents()){
	           cp.setEnabled(true);
	      }
		mf.remove(op);
		mf.add(np,0);
		mf.repaint();
	}
	
	public static void changePanel(KoskMainFrame mf, JPanel op, JPanel op2, JPanel np) { // 있던 패널 지우고 새 패널 올리기
		mf.remove(op);
		mf.remove(op2);
		mf.add(np);
		mf.revalidate();
		mf.repaint();
	}

}
