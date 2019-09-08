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

import com.kh.studyCafe.client.ClientBack;

//연장 버튼을 만들때 필요한 클래스
class AdmTableAddTime extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
	private JButton jb;

	public AdmTableAddTime(AdmMainFrame mf, JPanel op, JTable table, ClientBack client, JScrollPane scrollpane) {
		jb = new JButton("연장");
		jb.setForeground(Color.WHITE);
		jb.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		jb.setBackground(new Color(127, 118, 104));

		// 클릭시 팝업
		jb.addActionListener(e -> {
			scrollpane.getHorizontalScrollBar().setEnabled(false);
			scrollpane.getVerticalScrollBar().setEnabled(false);
			scrollpane.getViewport().getView().setEnabled(false);

			int row = table.getSelectedRow();
			String tablePhone = table.getValueAt(row, 2) + "";
			String seatTimeType = table.getValueAt(row, 6) + "";

			// 회원에 따라 연장 버튼 연결 구분
			if (table.getValueAt(row, 7).equals("개인")) { // 개인일 때
				if (seatTimeType.contains("일")) { // 기간권일 때
					new ControlPanel().addPanel(mf, op, new AdmAddTimeWeek(mf, op, tablePhone, client));
				} else { // 1일권일 떄
					new ControlPanel().addPanel(mf, op, new AdmAddTimeHour(mf, op, tablePhone, client));
				}

			} else { // 그룹일 때
				new ControlPanel().addPanel(mf, op, new AdmAddTimeHour(mf, op, tablePhone, client));
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
