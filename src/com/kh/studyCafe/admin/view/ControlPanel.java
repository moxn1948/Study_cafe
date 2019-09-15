package com.kh.studyCafe.admin.view;

import java.awt.Component;

import javax.swing.JPanel;

public class ControlPanel {

	public void changePanel(AdmMainFrame mf, JPanel op, JPanel np) { // 있던 패널 지우고 새 패널 올리기
		mf.remove(op);
		mf.add(np);
		mf.repaint();
		mf.revalidate();

	}

	public void addPanel(AdmMainFrame mf, JPanel op, JPanel np) { // 있던 패널 유지하고 새 패널 올리긴
		for (Component cp : op.getComponents()) {
			cp.setEnabled(false);
		}
		mf.add(np, 1, 0);
		mf.repaint();
	}

	public void reSeatPanel(AdmMainFrame mf, JPanel op1, JPanel op2, JPanel np) { // seatTable 용 메소드
		mf.remove(op1);
		mf.remove(op2);
		mf.add(np, 1, 0);
		mf.repaint();
	}
	
	public void addPanel2(AdmMainFrame mf, JPanel op, JPanel np) { // 있던 패널 유지하고 새 패널 올리긴
		for (Component cp : op.getComponents()) {
			cp.setEnabled(false);
		}
		mf.add(np, 2, 0);
		mf.repaint();
	}

	public void removePanel2(AdmMainFrame mf, JPanel op1, JPanel op2) { // 팝업위에 올라간 팝업 지우기
		mf.remove(op1);
		for (Component cp : op2.getComponents()) {
			cp.setEnabled(true);
		}
		mf.repaint();
	}

	public void changeTablePanel(AdmMainFrame mf, JPanel op, JPanel np) { // 있던 패널 지우고 새 패널 올리기
		mf.remove(op);
		mf.add(np);
		mf.revalidate();
		mf.repaint();
	}

	public void changeTablePanel2(AdmMainFrame mf, JPanel op1, JPanel op2, JPanel np) { // 있던 패널 지우고 새 패널 올리기
		mf.remove(op1);
		mf.remove(op2);
		mf.add(np);
		np.revalidate();
		np.repaint();
	}

	public void changeTablePanel3(AdmMainFrame mf, JPanel op1, JPanel op2, JPanel op3, JPanel np) { // 패널 3개 떴을 때 다 지우고
																									// table 다시 그리기
		mf.remove(op1);
		mf.remove(op2);
		mf.remove(op3);
		mf.add(np);
		np.revalidate();
		np.repaint();
	}

}
