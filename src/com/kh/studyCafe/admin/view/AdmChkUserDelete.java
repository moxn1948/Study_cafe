package com.kh.studyCafe.admin.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AdmChkUserDelete extends JPanel implements ActionListener{
	
	public AdmChkUserDelete() {
		// 패널 설정
		int w = 410;
		int h = 192;
		int x = popPosition(w, h)[0];
		int y = popPosition(w, h)[1];
		

		this.setBounds(x, y, w, h); 
		this.setBackground(new Color(239, 234, 222));
		this.setBorder(BorderFactory.createLineBorder(new Color(189, 177, 157)));
		
		// 안내 문구 텍스트 설정
		JLabel notice = new JLabel("삭제하시겠습니까?");

		notice.setLocation(106, 52);
		notice.setForeground(new Color(127, 118, 104));
		notice.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		notice.setSize(notice.getPreferredSize());
		
		// 버튼 설정
		JButton cancelBtn = new JButton("Cancel");
		JButton confirmBtn = new JButton("Confirm");
		
		cancelBtn.setBounds(16, 128, 184, 50);
		confirmBtn.setBounds(210, 128, 184, 50);
		cancelBtn.setBackground(new Color(189, 177, 157));
		confirmBtn.setBackground(new Color(163, 152, 134));
		cancelBtn.setForeground(Color.WHITE);
		cancelBtn.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		confirmBtn.setForeground(Color.WHITE);
		confirmBtn.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		cancelBtn.setBorder(BorderFactory.createLineBorder(new Color(189, 177, 157)));
		confirmBtn.setBorder(BorderFactory.createLineBorder(new Color(163, 152, 134)));
		
		// 패널에 올리기
		this.add(notice);
		this.add(cancelBtn);
		this.add(confirmBtn);
		
	}

	public int[] popPosition(int w, int h) {
		int[] position = new int[2];
		
		position[0] = (962 - w) / 2;
		position[1] = (662 - h) / 2;
		
		return position;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
}
