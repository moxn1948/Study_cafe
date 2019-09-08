package com.kh.studyCafe.admin.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

//좌석 퇴실을 할때 필요한 버튼을 만드는 클래스
public class AdmTableExitSeat extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
	private JButton jb;

	public AdmTableExitSeat(AdmMainFrame mf, JPanel op, JTable table, JScrollPane scrollpane) {
		jb = new JButton("퇴장");
		jb.setForeground(Color.WHITE);
		jb.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		jb.setBackground(new Color(127, 118, 104));

		jb.addActionListener(e -> {
			scrollpane.getHorizontalScrollBar().setEnabled(false);
			scrollpane.getVerticalScrollBar().setEnabled(false);
			scrollpane.getViewport().getView().setEnabled(false);

			int row = table.getSelectedRow();
			String seatTimeType = table.getValueAt(row, 6) + "";

			// 회원에 따라 퇴실 버튼 연결 구분
			if (seatTimeType.contains("일")) { // 기간권일 때
				new ControlPanel().addPanel(mf, op, new AdmExitTimeWeek(mf, op));
			} else { // 1일권일 떄
				new ControlPanel().addPanel(mf, op, new AdmExitTimeHour(mf, op));
			}

		});
	}

	@Override
	public Object getCellEditorValue() {
		return null;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		return jb;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		return jb;
	}

}
