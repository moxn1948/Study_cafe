package com.kh.studyCafe.admin.view;

import javax.swing.JPanel;

public class ControlPanel{
	
	public void changePanel(AdmMainFrame mf, JPanel op, JPanel np) { // 있던 패널 지우고 새 패널 올리기
		mf.remove(op);
		mf.add(np);
		mf.repaint();

	}
	
	public void addPanel(AdmMainFrame mf, JPanel op, JPanel np) { // 있던 패널 유지하고 새 패널 올리긴
		mf.add(np, 1, 0);
		mf.repaint();
	}

	public void changeTablePanel(AdmMainFrame mf, JPanel op, JPanel np) { // 있던 패널 지우고 새 패널 올리기
		mf.remove(op);
		mf.add(np);
		mf.revalidate();
		mf.repaint();
	}

/*	public void addPanel(AdmMainFrame mf, JPanel op, JPanel op1, JPanel np) { // table용 - 있던 패널 유지하고 새 패널 올리긴
		mf.add(np, 1, 0);
		mf.repaint();
	}*/
	
	public void changeTablePanel2(AdmMainFrame mf, JPanel op1, JPanel op2, JPanel np) { // 있던 패널 지우고 새 패널 올리기
		mf.remove(op1);
		mf.remove(op2);
		mf.add(np);
		np.revalidate();
		np.repaint();
	}
	
}
