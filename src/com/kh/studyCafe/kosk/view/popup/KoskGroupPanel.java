package com.kh.studyCafe.kosk.view.popup;

import java.awt.Color;
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
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.kh.studyCafe.client.ClientBack;
import com.kh.studyCafe.kosk.model.dao.KoskDao;
import com.kh.studyCafe.kosk.view.ChangePanel;
import com.kh.studyCafe.kosk.view.KoskMainFrame;
import com.kh.studyCafe.kosk.view.KoskPayment;
import com.kh.studyCafe.kosk.view.KoskSeatTable2;
import com.kh.studyCafe.model.vo.User;


public class KoskGroupPanel extends JPanel implements MouseListener{
   
   private JTextField Rttime;
   private JTextField ettime;
   private JTextField time;
   private JTextField psn;
   private JButton plus;
   private JButton plus2;
   private JButton minus;
   private JButton minus2;
   private JButton cancel; 
   private JButton confirm; 
   private int personNum;    //결제시 출력되는 인원수
   private int hour = 0;    //결제시 출력되는 시간
   private int timeHour = 02;    //잔여시간,연장시간에 출력되는 시간(String 변환전)
   private int timeMinute = 30;    //잔여시간, 연장시간에 출력되는 분(String 변환전)
   
   public long seattime = 0;
   private KoskMainFrame mf;
   private JPanel panel;
   private ArrayList<User> uList;
   private ClientBack client;
   private String seatnum;
   private String phnum;
   private int tableOrManage;
   private String seatName = null;
   
   public KoskGroupPanel(KoskMainFrame mf,ArrayList<User> uList,String phnum, ClientBack client, JPanel panel,String seatnum,
		   int tableOrManage) {
   
	   this.mf = mf;
	   this.panel = panel;
	   this.uList = uList;
	   this.client = client;
	   this.seatnum = seatnum;
	   this.phnum = phnum;
	   this.tableOrManage = tableOrManage;
      
	  TitledBorder oneTb = new TitledBorder(new LineBorder(Color.black));

      KoskDao kd = new KoskDao();
      String seatNum = seatnum.substring(0,1);
      System.out.println(seatNum+"그룹 시트 넘버");
      if(seatNum.contains("4")) {
         seatName = "4";
      }else if(seatNum.contains("6")) {
         seatName = "6";
      }else if(seatNum.contains("8")) {
         seatName = "8";
      }
      
      Color wallPapers = new Color(239,234,222);
      Color textColor = new Color(127,118,104);
      
   
      Font siguptext = new Font("맑은 고딕",Font.BOLD,30);
      Font inputtext = new Font("맑은 고딕",Font.BOLD,25);
      Font checktext = new Font("맑은 고딕",Font.BOLD,14);
         
      this.setSize(300,400);
      this.setLocation(30, 120);
      this.setLayout(null);
      this.setBackground(wallPapers);
      
   
      JLabel logo = new JLabel("1일권");
      logo.setBounds(100,30,200,30);
      logo.setFont(inputtext);
      logo.setForeground(textColor);
      
      JLabel Rt = new JLabel("결제 시간");// 잔여시간
      Rt.setBounds(40, 78, 100, 30);
      Rt.setFont(checktext);
      Rt.setForeground(textColor);
      
      JLabel et = new JLabel("사용 가능 인원"); // 연장 후 시간
      et.setBounds(40, 100, 100, 30);
      et.setFont(checktext);
      et.setForeground(textColor);

      /*
      String th1 = Integer.valueOf(timeHour).toString();    
      String tm1 = Integer.valueOf(timeMinute).toString();   
      
      Rttime = new JTextField(th1 + ":" + tm1) {
           @Override
            public void setBorder(Border border) {
               
            }
      };
      Rttime.setBounds(180, 78, 100, 30);
      Rttime.setFont(checktext);
      Rttime.setForeground(textColor);
      Rttime.setBackground(wallPapers);
            */

      hour++;
      time = new JTextField("0" + hour + ": 00");
      time.setBounds(25,175,110,40);
      time.setFont(checktext);
      time.setForeground(textColor);
      time.setHorizontalAlignment(JTextField.CENTER);
      time.setEditable(false);
      
      time.addMouseListener(this);

      /*
      timeHour = timeHour + hour;
      String th2 = Integer.valueOf(timeHour).toString();    
      String tm2 = Integer.valueOf(timeMinute).toString();   
      
      ettime = new JTextField(th2 + ":" + tm2) {
         @Override
         public void setBorder(Border border) {
            
         }
      };*/
      Rttime = new JTextField("0" + hour + ": 00");
      Rttime.setBounds(150, 75, 100, 30);
      Rttime.setFont(checktext);
      Rttime.setForeground(textColor);
      Rttime.setBackground(wallPapers);
      
//      ettime.setBounds(180, 100, 100, 30);


      
      Rttime = new JTextField("0" + hour + ": 00");
      Rttime.setBounds(150, 75, 100, 30);
      Rttime.setFont(checktext);
      Rttime.setForeground(textColor);
      Rttime.setBackground(wallPapers);
            
      

      timeHour = timeHour + hour;
      if(seatName.equals("4")) {
    	  ettime = new JTextField((Integer.parseInt(seatName) - 2) + "명  ~ " + seatName + "명");
      }else if(seatName.equals("6")) {
    	  ettime = new JTextField((Integer.parseInt(seatName) - 2) + "명  ~ " + seatName + "명");
      }else if(seatName.equals("8")) {
    	  ettime = new JTextField((Integer.parseInt(seatName) - 2) + "명  ~ " + seatName + "명");
      }
      ettime.setBounds(150, 100, 100, 30);

      ettime.setBackground(wallPapers);
      ettime.setFont(checktext);
      ettime.setForeground(textColor);
      ettime.setEditable(false);
      
      personNum = (Integer.parseInt(seatName) - 2);
      psn = new JTextField(personNum + "명");
      psn.setBounds(144,175,110,40);
      psn.setFont(checktext);
      psn.setForeground(textColor);
      psn.setHorizontalAlignment(JTextField.CENTER);
      psn.setEditable(false);
      
      psn.addMouseListener(this);
      
      Image plusimg = new ImageIcon("img/plusbtnimg.png").getImage().getScaledInstance(120, 40, 0);
      plus = new JButton(new ImageIcon(plusimg));
      plus.setBounds(25, 130, 110, 40);
      
      plus.addMouseListener(this);
      
      plus2 = new JButton(new ImageIcon(plusimg));
      plus2.setBounds(144, 130, 110, 40);
      
      plus2.addMouseListener(this);
      
      Image minusimg = new ImageIcon("img/minusbtnimg.png").getImage().getScaledInstance(120, 40, 0);
      minus = new JButton(new ImageIcon(minusimg));
      minus.setBounds(25, 220, 110, 40);
      
      minus.addMouseListener(this);
      
      
      minus2 = new JButton(new ImageIcon(minusimg));
      minus2.setBounds(144, 220, 110, 40);
      
      minus2.addMouseListener(this);
      
      
      Image cancelimg = new ImageIcon("img/Cancelbtnimg.png").getImage().getScaledInstance(117, 50, 0);
      cancel = new JButton(new ImageIcon(cancelimg));
      cancel.setBounds(20, 280, 117, 50);
      
      cancel.addMouseListener(this);
      
      
      Image confirmimg = new ImageIcon("img/confirmbtnimg.png").getImage().getScaledInstance(117, 50, 0);
      confirm = new JButton(new ImageIcon(confirmimg));
      confirm.setBounds(139, 280, 117, 50);
      
      confirm.addMouseListener(this);
            
      this.setBorder(oneTb);
      this.add(logo);
      this.add(Rt);
      this.add(et);
      this.add(Rttime);
      this.add(ettime);
      this.add(plus);
      this.add(plus2);
      this.add(time);
      this.add(psn);
      this.add(minus);
      this.add(minus2);
      this.add(cancel);
      this.add(confirm);
      mf.repaint();
      
   }
   User user = new User();
   
   KoskDao kd = new KoskDao();
   @Override
   public void mouseClicked(MouseEvent e) {
      if(e.getSource() == plus) {
         if(hour >= 1 && hour < 9) {
            hour++;
            time.setText("0" + hour + ": 00");
            timeHour += 1;
            String th = Integer.valueOf(timeHour).toString();    
            String tm = Integer.valueOf(timeMinute).toString();  
            ettime.setText(th + ":" + tm);
         }else if(hour >= 9 && hour < 23) {
            hour++;
            time.setText(hour + " : 00");
            timeHour += 1;
            String th = Integer.valueOf(timeHour).toString();    
            String tm = Integer.valueOf(timeMinute).toString();  
            ettime.setText(th + ":" + tm);
         }
         seattime = hour;
         System.out.println(seattime);
         
      }
      if(e.getSource() == minus) {
         if(hour > 1 && hour < 9) {
            hour--;
            time.setText("0" + hour + ": 00");
            timeHour -= 1;
            String th = Integer.valueOf(timeHour).toString();    
            String tm = Integer.valueOf(timeMinute).toString();   
            ettime.setText(th + ":" + tm);
         }else if(hour >= 9 && hour <= 24) {
            hour--;
            time.setText(hour + ": 00");
            timeHour -= 1;
            String th = Integer.valueOf(timeHour).toString();   
            String tm = Integer.valueOf(timeMinute).toString();  
            ettime.setText(th + ":" + tm);
         }
         seattime = hour;
         System.out.println(seattime);
      }
      if(e.getSource() == plus2) {
         if(personNum >=  (Integer.parseInt(seatName) - 2) && personNum < Integer.parseInt(seatName)) {
            personNum++;
            psn.setText(personNum + "명");
            
         }
      }
      if(e.getSource() == minus2) {
         if(personNum > (Integer.parseInt(seatName) - 2) && personNum <= Integer.parseInt(seatName)) {
            personNum--;
            psn.setText(personNum + "명");
         }
      }
      
      if(e.getSource() == cancel) {
         ChangePanel.changePanel(mf, this, new KoskSeatTable2(mf, uList, client, phnum));
      }
      if(e.getSource() == confirm) {
         //좌석표 패널에서 결제 선택 패널로 전환 추가
    	  tableOrManage = 1;
    	  if(seattime == 0) {
    		  seattime = 1;
    	  }
         ChangePanel.changePanel(mf, this, new KoskPayment(mf,uList,phnum,client,panel,seatnum,seattime,1,tableOrManage,personNum));
         
      }
      
   }
   public long grouptime() {
      System.out.println(user.getSeatType()+"그룹패널");
      return user.getSeatType();
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
}