package com.kh.studyCafe.admin.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.studyCafe.admin.model.vo.AdmUserTable;
import com.kh.studyCafe.client.ClientBack;
import com.kh.studyCafe.model.vo.User;

public class AdmUnSelectSeat extends JPanel implements ActionListener{
//좌석을 선택해주세요 팝업1번 
         
   private JButton closeBtn;
   private AdmMainFrame mf;
   private JPanel op;
   private JPanel op2;
   private ClientBack client;
   private String phoneNum;
   private ArrayList<AdmUserTable> utList;
   private String seatNum;
   private ArrayList<User> u;
   
   public AdmUnSelectSeat(AdmMainFrame mf, JPanel op, JPanel op2, ClientBack client, String phoneNum, ArrayList<AdmUserTable> utList,String seatNum, ArrayList<User> u) {
      this.mf = mf;
      this.op = op; // 테이블
      this.op2 = op2; // 시트 테이블
      this.client = client;
      this.phoneNum = phoneNum;
      this.utList = utList;
      this.seatNum = seatNum;
      this.u = u;
      
      
      this.setBounds(270,203,410,193);
      this.setBackground(new Color(239,234,222));
      this.setBorder(BorderFactory.createLineBorder(new Color(189,177,157)));
      
      
      
      //title 텍스트 설정
      
      JLabel title = new JLabel("이동하실 좌석을 선택해 주세요.");
      
      title.setLocation(35, 43);
      title.setForeground(new Color(127,118,104));
      title.setFont(new Font("맑은 고딕",Font.BOLD,24));
      title.setSize(title.getPreferredSize());
      
      
      //버튼설정
      closeBtn = new JButton("Close");
      
      closeBtn.setBounds(45,120,326,50);
      closeBtn.setBackground(new Color(189, 177, 157));
      closeBtn.setFont(new Font("맑은 고딕",Font.BOLD,18));
      closeBtn.setForeground(Color.WHITE);
      closeBtn.setBorderPainted(false);
      closeBtn.addActionListener(this);
      
      //패널에 올리기
      this.add(title);
      this.add(closeBtn);
   }

   
   @Override
   public void actionPerformed(ActionEvent e) {
      ControlPanel cp = new ControlPanel();
      if(e.getSource() == closeBtn) {
    	  cp.reSeatPanel(mf, this, op2, new AdmSeatTable(mf, this, client, phoneNum, utList, seatNum, u));
      }
      
   }

}