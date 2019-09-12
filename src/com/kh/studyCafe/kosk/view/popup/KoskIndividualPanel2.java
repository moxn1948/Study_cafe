package com.kh.studyCafe.kosk.view.popup;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.kh.studyCafe.client.ClientBack;
import com.kh.studyCafe.kosk.controller.KoskManager;
import com.kh.studyCafe.kosk.model.dao.KoskDao;
import com.kh.studyCafe.kosk.view.ChangePanel;
import com.kh.studyCafe.kosk.view.KoskMainFrame;
import com.kh.studyCafe.kosk.view.KoskPayment;
import com.kh.studyCafe.kosk.view.KoskSeatManagement;
import com.kh.studyCafe.kosk.view.KoskSeatTable2;
import com.kh.studyCafe.model.vo.User;

public class KoskIndividualPanel2 extends JPanel implements MouseListener{
   
   private JTextField time  = new JTextField("7일");
   private JButton plus;
   private JButton   minus;
   private JButton cancel;
   private JButton confirm;
   private int day = 7;
   private JLabel Rt;
   
   long daytime;
   private KoskMainFrame mf;
   private JPanel panel;
   private ArrayList<User> uList;
   private ClientBack client;
   private String seatnum;
   private String phnum;
   private int tableOrManage;
   private long seattime;
   
   public KoskIndividualPanel2(KoskMainFrame mf,ArrayList<User> uList,String phnum, ClientBack client, JPanel panel,String seatnum, int hOfw
		   ,int tableOrManage) {
	   this.mf = mf;
	   this.panel = panel;
	   this.uList = uList;
	   this.client = client;
	   this.seatnum = seatnum;
	   this.phnum = phnum;
	   this.tableOrManage = tableOrManage;
	   this.seattime = seattime;
   //===== 컬러 =====

   Color wallPapers = new Color(239,234,222);
   Color textColor = new Color(127,118,104);
               
     
     
   Font siguptext = new Font("맑은 고딕",Font.BOLD,30);
   Font inputtext = new Font("맑은 고딕",Font.BOLD,25);
   Font checktext = new Font("맑은 고딕",Font.BOLD,14);
      
   TitledBorder oneTb = new TitledBorder(new LineBorder(Color.black));
   
   
   //===== 패널 =======

   this.setSize(300,400);
   this.setLocation(30, 120);
   this.setLayout(null);
   this.setBackground(wallPapers);
   this.setBorder(oneTb);
   
   //===== 라벨 =========
   JLabel logo = new JLabel("기간권");
   logo.setBounds(100,30,200,30);
   logo.setFont(inputtext);
   logo.setForeground(textColor);
   
   //====== textField =======
   
   time = new JTextField(day + "일");
   time.setBounds(85,175,110,40);
   time.setFont(checktext);
   time.setForeground(textColor);
   time.setHorizontalAlignment(JTextField.CENTER);
   time.setEditable(false);    
   
   //================================
   
   Rt = new JLabel("이용하실 기간  " + day + "일");// 잔여시간
   Rt.setBounds(60,80, 150, 60);
   Rt.setFont(checktext);
   Rt.setForeground(textColor);
   Rt.setHorizontalAlignment(JLabel.CENTER);
   
   //===================
   
   
   
   //==== 버튼 ========
   Image plusimg = new ImageIcon("img/plusbtnimg.png").getImage().getScaledInstance(120, 40, 0);
   plus = new JButton(new ImageIcon(plusimg));
   plus.setBounds(85, 130, 110, 40);
   
   plus.addMouseListener(this);
      
   Image minusimg = new ImageIcon("img/minusbtnimg.png").getImage().getScaledInstance(120, 40, 0);
   minus = new JButton(new ImageIcon(minusimg));
   minus.setBounds(85, 220, 110, 40);
   
   minus.addMouseListener(this);

   Image cancelimg = new ImageIcon("img/Cancelbtnimg.png").getImage().getScaledInstance(117, 50, 0);
   cancel = new JButton(new ImageIcon(cancelimg));
   cancel.setBounds(20, 280, 117, 50);
   
   cancel.addMouseListener(this);
   
   Image confirmimg = new ImageIcon("img/confirmbtnimg.png").getImage().getScaledInstance(117, 50, 0);
   confirm = new JButton(new ImageIcon(confirmimg));
   confirm.setBounds(139, 280, 117, 50);
   
   confirm.addMouseListener(this);
   
   
   
   //============
   this.add(logo);
   this.add(Rt);
   this.add(plus);
   this.add(time);
   this.add(minus);
   this.add(cancel);
   this.add(confirm);
   
   mf.repaint();
      
}   
   KoskDao kd = new KoskDao();
   @Override
   public void mouseClicked(MouseEvent e) {
      if(e.getSource() == plus) {
         if(day >= 7 && day < 28) {
            day += 7;
            time.setText(day + "일");
            Rt.setText("이용하실 기간  " + day + "일");
         }
      }
      if(e.getSource() == minus) {
         if(day > 7 && day <= 28) {
            day -= 7;
            time.setText(day + "일");
            Rt.setText("이용하실 기간  " + day + "일");
         }
         System.out.println(day);
      }
      if(e.getSource() == cancel) {
    	  if(tableOrManage == 1) {
    		  ChangePanel.changePanel(mf, this, new KoskSeatTable2(mf, uList, phnum, client));
    	  } else {
    		  ChangePanel.changePanel(mf, this, new KoskSeatManagement(mf, uList, phnum, client, panel, seatnum, uList.get(kd.userindex(phnum)).getInTime()));
    	  }
    	 
      }
      if(e.getSource() == confirm) {
         ChangePanel.changePanel(mf, this, new KoskPayment(mf,uList,phnum,client,this,seatnum,day,1,tableOrManage));
         //confirm버튼 누를 시 좌석표 패널에서 결제 선택패널로 전환 추가
         
      }
         System.out.println(day+"기간권  에서 선택함");
   }

   @Override
   public void mouseEntered(MouseEvent e) {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void mouseExited(MouseEvent e) {
      // TODO Auto-generated method stub 
      
   }

   @Override
   public void mousePressed(MouseEvent e) {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void mouseReleased(MouseEvent e) {
      // TODO Auto-generated method stub
      
   }
   public long daytime() {
      
      return daytime;
   }
   
}