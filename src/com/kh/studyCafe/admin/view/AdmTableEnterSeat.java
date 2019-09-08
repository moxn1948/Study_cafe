package com.kh.studyCafe.admin.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import com.kh.studyCafe.admin.model.vo.AdmUserTable;
import com.kh.studyCafe.client.ClientBack;

//입실 버튼을 만들때 필요한 클래스
public class AdmTableEnterSeat extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
	private JButton jb;

	public AdmTableEnterSeat(AdmMainFrame mf, JPanel op, JTable table,ClientBack client ,JScrollPane scrollpane, ArrayList<AdmUserTable> utList) {

		jb = new JButton("입실");
		jb.setForeground(Color.WHITE);
		jb.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		jb.setBackground(new Color(127, 118, 104));

		jb.addActionListener(e -> {
			scrollpane.getHorizontalScrollBar().setEnabled(false);
			scrollpane.getVerticalScrollBar().setEnabled(false);
			scrollpane.getViewport().getView().setEnabled(false);

			int row = table.getSelectedRow();
			String tablePhone = table.getValueAt(row, 2) + "";
			
			// 회원에 따라 이동 버튼 연결 구분
			new ControlPanel().addPanel(mf, op, new AdmSeatTable(mf, op, client, tablePhone, utList));

			
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