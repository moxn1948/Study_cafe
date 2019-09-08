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
			String seatNum = table.getValueAt(row, 3) + "";
			String inTime = table.getValueAt(row, 4)+ "";
			System.out.println(seatNum);
			System.out.println(inTime);
			// 회원에 따라 이동 버튼 연결 구분
			//if 만약 셀렉트 로우 좌석번호 0이아니고 입실시간 0이면 새로운 입실확인창으로 가 정보가지고
			// 만약 좌석번호도 0이고 입실시간도 0이면 좌서ㅏㄱ표 로 감 이해?
			if(seatNum.equals("-") && inTime.equals("-")) {
				new ControlPanel().addPanel(mf, op, new AdmSeatTable(mf, op, client, tablePhone, utList));				
			} else/* if(!(seatNum.equals("0")) && inTime.equals("0")) */{
				new ControlPanel().addPanel(mf, op, new AdmEnterTimeWeek(mf, op, client, tablePhone));				
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