package com.kh.studyCafe.admin.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

//입실 버튼을 만들때 필요한 클래스
public class AdmTableEnterSeat extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
	private JButton jb;

	public AdmTableEnterSeat(JScrollPane scrollpane) {

		jb = new JButton("입실");
		jb.setForeground(Color.WHITE);
		jb.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		jb.setBackground(new Color(127, 118, 104));

		jb.addActionListener(e -> {
			scrollpane.getHorizontalScrollBar().setEnabled(false);
			scrollpane.getVerticalScrollBar().setEnabled(false);
			scrollpane.getViewport().getView().setEnabled(false);

			jb.setBackground(Color.WHITE);
			jb.setForeground(new Color(127, 118, 104));
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