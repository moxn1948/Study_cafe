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

      Color wallPapers = new Color(239,234,222);
      Color textColor = new Color(127,118,104);

      //===============

      //===== JPanel 설정 =======
      this.setSize(360,640);
      this.setLayout(null);
      this.setBackground(wallPapers);
      //=======================

      //============ font 설정 ==========
      Font siguptext = new Font("Noto Sans KR",Font.BOLD,30);
      Font inputtext = new Font("Noto Sans KR",Font.BOLD,17);
      Font checktext = new Font("Noto Sans KR",Font.BOLD,14);
      //===============================

      //==== 마이페이지 제목  ===============
      Image imgicon = new ImageIcon("img/imgicon.png").getImage().getScaledInstance(60, 80, 0);
      JLabel ib = new JLabel("  마이 페이지",(new ImageIcon(imgicon)),SwingUtilities.CENTER);
      ib.setBounds(10,0,250,80);
      ib.setForeground(textColor);
      ib.setFont(siguptext);
      //===============================

      //==== 라벨 설정 ====================

      JLabel name = new JLabel("이름"); //�̸� ��
      name.setBounds(30, 100, 40, 30);
      name.setFont(inputtext);
      name.setForeground(textColor);

      JLabel phnumber = new JLabel("휴대폰");
      JLabel phnumber2 = new JLabel("번호");
      phnumber.setBounds(30,160,60,30);
      phnumber2.setBounds(30,180,60,30);
      phnumber.setFont(inputtext);
      phnumber2.setFont(inputtext);
      phnumber.setForeground(textColor);
      phnumber2.setForeground(textColor);

      JLabel hou1 = new JLabel("이용가능");
      JLabel hou2 = new JLabel("시간");
      hou1.setBounds(30,220,80,30);
      hou2.setBounds(30,240,80,30);
      hou1.setForeground(textColor);
      hou1.setFont(inputtext);
      hou2.setForeground(textColor);
      hou2.setFont(inputtext);

      JLabel atime1 = new JLabel("입실시간");
      atime1.setBounds(30,280,80,30);
      atime1.setForeground(textColor);
      atime1.setFont(inputtext);

      JLabel dtime1 = new JLabel("퇴실시간");
      dtime1.setBounds(30,340,80,30);
      dtime1.setForeground(textColor);
      dtime1.setFont(inputtext);

      JLabel rating1 = new JLabel("등급");
      rating1.setBounds(30,400,80,30);
      rating1.setForeground(textColor);
      rating1.setFont(inputtext);

      JTextField nametf = new JTextField(tempData[0]);
      nametf.setBackground(wallPapers);
      nametf.setFont(inputtext);
      nametf.setBounds(120,100,200,40);
      nametf.setForeground(textColor);

      JTextField phtf = new JTextField(tempData[1]);
      phtf.setBounds(120,160,200,40);
      phtf.setBackground(wallPapers);
      phtf.setFont(inputtext);
      phtf.setForeground(textColor);
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

      hou.setBounds(120,220,200,40);
      hou.setBackground(wallPapers);
      hou.setFont(inputtext);
      hou.setForeground(textColor);
      
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
                  if(hour > 12) {
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
         atime.setBounds(120,280,200,40);
         atime.setBackground(wallPapers);
         atime.setFont(inputtext);
         atime.setForeground(textColor);

      dtime.setBounds(120,340,200,40);
      dtime.setBackground(wallPapers);
      dtime.setFont(inputtext);
      dtime.setForeground(textColor);
   
      JTextField rating = new JTextField(tempData[4]);
      rating.setBounds(120,400,200,40);
      rating.setBackground(wallPapers);
      rating.setFont(inputtext);
      rating1.setForeground(textColor);
      //======================================

      //=== 확인 버튼  ===========================

      Image findimg = new ImageIcon("img/okbtnimg.png").getImage().getScaledInstance(100, 40, 0);

      find = new JButton(new ImageIcon(findimg));
      find.setBounds(220,530,100,40);
      find.addActionListener(this);

      this.add(ib);
      this.add(name);
      this.add(nametf);
      this.add(phtf);
      this.add(hou);
      this.add(atime);
      this.add(dtime);
      this.add(rating);
      this.add(hou1);
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