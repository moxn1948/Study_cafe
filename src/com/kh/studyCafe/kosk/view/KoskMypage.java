package com.kh.studyCafe.kosk.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.kh.studyCafe.client.ClientBack;
import com.kh.studyCafe.kosk.model.dao.KoskDao;
import com.kh.studyCafe.model.vo.User;

public class KoskMypage extends JPanel implements ActionListener{
   private JPanel op;
   private KoskMainFrame mf;   
   private JTextField atime = new JTextField();
   private JTextField dtime = new JTextField();
   private JButton find;
   private ClientBack client;
   private ArrayList<User> uList;
   private String phoneNum;
   public KoskMypage(KoskMainFrame mf, JPanel op, ArrayList<User> uList, String phoneNum, ClientBack client) {
      this.mf = mf;
      this.op = op;
      this.uList = uList;
      this.client = client;
      this.phoneNum = phoneNum;
      
      //===== 색상 설정 =====
      KoskDao kd = new KoskDao();

      String[] tempData = kd.myPage(phoneNum).split(",");

      Color wallPapers = new Color(247,244,240);
      Color textColor = new Color(127,118,104);

      //===============

      //===== JPanel 설정 =======
      this.setSize(360,640);
      this.setLayout(null);
      this.setBackground(wallPapers);
      //=======================

      //============ font 설정 ==========
      Font siguptext = new Font("맑은 고딕",Font.BOLD,30);
      Font inputtext = new Font("맑은 고딕",Font.BOLD,15);
      //===============================

      //==== 마이페이지 제목  ===============
		Image imgicon = new ImageIcon("img/imgicon.png").getImage().getScaledInstance(26, 30, 0);
		JLabel icon = new JLabel("", (new ImageIcon(imgicon)), SwingUtilities.CENTER);
		icon.setBounds(150, 0, 50, 50);

      JLabel ib = new JLabel("마이 페이지");
	  ib.setBounds(90,90,300,50);
      ib.setForeground(textColor);
      ib.setFont(siguptext);
      ib.setSize(ib.getPreferredSize());
      //===============================

      //==== 라벨 설정 ====================

      JLabel name = new JLabel("이름");
      name.setBounds(30, 195, 40, 30);
      name.setFont(inputtext);
      name.setForeground(textColor);

      JLabel phnumber = new JLabel("휴대폰");
      JLabel phnumber2 = new JLabel("번호");
      phnumber.setBounds(30,243,60,30);
      phnumber2.setBounds(30,263,60,30);
      phnumber.setFont(inputtext);
      phnumber2.setFont(inputtext);
      phnumber.setForeground(textColor);
      phnumber2.setForeground(textColor);
		
		

      JLabel hou1 = new JLabel("이용가능");
      JLabel hou2 = new JLabel("시간");
      hou1.setBounds(30,295,80,30);
      hou2.setBounds(30,311,80,30);
      hou1.setForeground(textColor);
      hou1.setFont(inputtext);
      hou2.setForeground(textColor);
      hou2.setFont(inputtext);

      JLabel atime1 = new JLabel("입실시간");
      atime1.setBounds(30,349,80,30);
      atime1.setForeground(textColor);
      atime1.setFont(inputtext);

      JLabel dtime1 = new JLabel("퇴실시간");
      dtime1.setBounds(30,399,80,30);
      dtime1.setForeground(textColor);
      dtime1.setFont(inputtext);

      JLabel rating1 = new JLabel("등급");
      rating1.setBounds(30,449,80,30);
      rating1.setForeground(textColor);
      rating1.setFont(inputtext);

      JTextField nametf = new JTextField(tempData[0]);
      nametf.setBounds(120,195,200,40);
      nametf.setBackground(Color.WHITE);
      nametf.setFont(inputtext);
      nametf.setForeground(textColor);
      nametf.setBorder(BorderFactory.createLineBorder(new Color(189, 177, 157)));
      nametf.setEditable(false);
      

      JTextField phtf = new JTextField(tempData[1]);
      phtf.setBounds(120,245,200,40);
      phtf.setBackground(Color.WHITE);
      phtf.setFont(inputtext);
      phtf.setForeground(textColor);
      phtf.setBorder(BorderFactory.createLineBorder(new Color(189, 177, 157)));
      phtf.setEditable(false);
      
      JTextField hou;
      int t = (int)uList.get(kd.userindex(phoneNum)).getRemainTime();
      
      int d = t / 3600000 / 24;
      int h = (t % (3600000 * 24))/3600000;
       int m = ((t % (3600000 * 24))% 3600000) / 60000;
       
      if(d > 0) {
         hou = new JTextField(d + "일");
      } else {
         if(h >= 0 && h < 10) {
            if(m >= 0 && m < 10) {
               hou = new JTextField("0" + h + ":0" + m);
            }else {
               hou = new JTextField("0" + h + ":" + m);
            }
         }else {
            if(m >= 0 && m < 10) {
               hou = new JTextField(h + ":0" + m);
            }else {
               hou = new JTextField(h + ":" + m);
            }
         }
      }

      hou.setBounds(120,295,200,40);
      hou.setBackground(Color.WHITE);
      hou.setFont(inputtext);
      hou.setForeground(textColor);
      hou.setBorder(BorderFactory.createLineBorder(new Color(189, 177, 157)));
      hou.setEditable(false);
      
      if(!kd.toEnterInfo(phoneNum).equals("0")) {
            if(kd.myPage1(phoneNum) == 1 || kd.myPage1(phoneNum) == 2) {
               Calendar cal = Calendar.getInstance();
               int hour = cal.get(Calendar.HOUR_OF_DAY);
               int minutes = cal.get(Calendar.MINUTE);

               if(hour >= 12) {
                  atime = new JTextField("PM " + (hour - 12) + " : " + minutes);
               } else {
                  atime = new JTextField("AM " + hour + " : " + minutes);
               }

               hour += h;
               if(d <= 0) {
            	   if(hour >= 24) {
            		   dtime = new JTextField("AM " + (hour - 24) + " : " + minutes);
            	   }else if(hour < 24 && hour >= 12) {
                     dtime = new JTextField("PM " + (hour - 12) + " : " + minutes);
                  }else {
                     dtime = new JTextField("AM " + hour + " : " + minutes);
                  }
            }
         } else {
            atime = new JTextField();
            dtime = new JTextField();
         }
      }
         atime.setBounds(120,345,200,40);
         atime.setBackground(Color.WHITE);
         atime.setFont(inputtext);
         atime.setForeground(textColor);
         atime.setBorder(BorderFactory.createLineBorder(new Color(189, 177, 157)));
         atime.setEditable(false);

      dtime.setBounds(120,395,200,40);
      dtime.setBackground(Color.WHITE);
      dtime.setFont(inputtext);
      dtime.setForeground(textColor);
      dtime.setBorder(BorderFactory.createLineBorder(new Color(189, 177, 157)));
      dtime.setEditable(false);
   
      JTextField rating = new JTextField(tempData[4]);
      rating.setBounds(120,445,200,40);
      rating.setBackground(Color.WHITE);
      rating.setFont(inputtext);
      rating.setForeground(textColor);
      rating.setBorder(BorderFactory.createLineBorder(new Color(189, 177, 157)));
      rating.setEditable(false);
      //======================================

      //=== 확인 버튼  ===========================

//      Image findimg = new ImageIcon("img/okbtnimg.png").getImage().getScaledInstance(100, 40, 0);

      find = new JButton("Confirm");
	  find.setBounds(25,510,300,54);
	  find.setBackground(new Color(163, 152, 134));
	  find.setForeground(Color.WHITE);
	  find.setFont(new Font("맑은 고딕", Font.BOLD, 18));
	  find.setBorderPainted(false);
	  find.addActionListener(this);

      this.add(icon);
      this.add(ib);
      this.add(name);
      this.add(nametf);
      this.add(phtf);
      this.add(hou);
      this.add(atime);
      this.add(dtime);
      this.add(rating);
      this.add(hou1);
      this.add(hou2);
      this.add(phnumber);
      this.add(phnumber2);
      this.add(atime1);
      this.add(rating1);
      this.add(dtime1);
      this.add(find);

      mf.repaint();
   }
   @Override
   public void actionPerformed(ActionEvent e) {
      if(e.getSource() == find) {
         ChangePanel.changePanel(mf, this,  op);
      }
   }
}