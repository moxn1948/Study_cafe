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
import com.kh.studyCafe.kosk.view.KoskSeatManagement;
import com.kh.studyCafe.kosk.view.KoskSeatTable2;
import com.kh.studyCafe.model.vo.User;

public class KoskIndividualPanel extends JPanel implements  MouseListener{
   
   private JButton plus;
   private JButton   minus;
   private JButton cancel;
   public JButton confirm;
   private int h;
   private int m;
   
   private JTextField time;
   private JTextField Rttime;
   private JTextField ettime;
   private int hour = 0;    //결제시 출력되는 시간
   private int timeHour = 02;    //잔여시간,연장시간에 출력되는 시간(String 변환전)
   private int timeMinute = 30;    //잔여시간, 연장시간에 출력되는 분(String 변환전)
   public boolean a = true;
   
   private JPanel panel;
   private KoskMainFrame mf; 
   private ArrayList<User> uList;
   private ClientBack client;
   private String seatnum;
   private String phnum;
   private int hOfw;
   private int tableOrManage;
   KoskDao kd = new KoskDao();
   
   public  KoskIndividualPanel(KoskMainFrame mf,ArrayList<User> uList,String phnum, ClientBack client, JPanel panel,String seatnum, int hOfw, 
         int tableOrManage){
   
      this.mf = mf;
      this.panel = panel;
      this.uList = uList;
      this.client = client;
      this.seatnum = seatnum;
      this.phnum = phnum;
      this.hOfw = hOfw;
      this.tableOrManage = tableOrManage;
   //===== 컬러 =====

   Color wallPapers = new Color(239,234,222);
   Color textColor = new Color(127,118,104);
               
   Font siguptext = new Font("맑은 고딕",Font.BOLD,30); 
   Font inputtext = new Font("맑은 고딕",Font.BOLD,25); 
   Font checktext = new Font("맑은 고딕",Font.BOLD,14);
      
   TitledBorder oneTb = new TitledBorder(new LineBorder(Color.black));
   this.setBorder(oneTb);
   
   //===== 패널 =======
   
   this.setSize(300,400);
   this.setLocation(30, 120);
   this.setLayout(null);
   this.setBackground(wallPapers);
   
   //===== 라벨 =========
   JLabel logo = new JLabel("1일권");
   logo.setBounds(110,30,200,30);
   logo.setFont(inputtext);
   logo.setForeground(textColor);
   
   JLabel Rt = new JLabel("잔여 시간");// 잔여시간
   Rt.setBounds(75, 78, 100, 30);
   Rt.setFont(checktext);
   Rt.setForeground(textColor);
   
   JLabel et = new JLabel("연장 후 시간"); // 연장 후 시간
   et.setBounds(75, 100, 100, 30);
   et.setFont(checktext);
   et.setForeground(textColor);
   //===================
   int t = (int)uList.get(kd.userindex(phnum)).getRemainTime();
   System.out.println(t+"남은시간");

      int d = t / 3600000 / 24;
      h = (t % (3600000 * 24))/3600000;
      m = ((t % (3600000 * 24))% 3600000) / 60000;
      
      if(m >= 0 && m <  10) {
         Rttime = new JTextField(h+":0"+m) {
            @Override
            public void setBorder(Border border) {
            }
         };
      } else {
         Rttime = new JTextField(h+":"+m) {
            @Override
            public void setBorder(Border border) {
            }
         };
      }

   Rttime.setBounds(170, 78, 100, 30);
   Rttime.setFont(checktext);
   Rttime.setForeground(textColor);
   Rttime.setBackground(wallPapers);
   
   hour++;
   time = new JTextField("0" + hour + ": 00");
   time.setBounds(85,175,110,40);
   time.setFont(checktext);
   time.setForeground(textColor);
   time.setHorizontalAlignment(JTextField.CENTER);
   time.setEditable(false);
   
   h += hour;
   if(m >= 0 && m <  10) {
      ettime = new JTextField(h+":0"+m) {
            @Override
            public void setBorder(Border border) {
            }
         };
      
   }else {
      ettime = new JTextField(h +  ":" + m) {
         @Override
         public void setBorder(Border border) {
         
         }
      };
   }
   ettime.setBounds(170, 100, 100, 30);
   ettime.setBackground(wallPapers);
   ettime.setFont(checktext);
   ettime.setForeground(textColor);
   ettime.setEditable(false);
   
   //================================
   
   //==== 버튼 ========
   Image plusimg = new ImageIcon("img/plusbtnimg.png").getImage().getScaledInstance(120, 40, 0);
   plus = new JButton(new ImageIcon(plusimg));
   plus.setBounds(85, 130, 110, 40);
   
   plus.addMouseListener(this);
   
   
   Image minusimg = new ImageIcon("img/minusbtnimg.png").getImage().getScaledInstance(120, 40, 0);
   minus = new JButton(new ImageIcon(minusimg));
   minus.setBounds(85, 220, 110, 40);
   
   minus.addMouseListener(this);

   cancel = new JButton("Cancel");
   cancel.setBounds(17, 332, 130, 50);
   cancel.setBackground(new Color(189, 177, 157));
   cancel.setForeground(Color.WHITE);
   cancel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
   cancel.setBorderPainted(false);
   
   cancel.addMouseListener(this);
   
   confirm = new JButton("Confirm");
   confirm.setBounds(156, 332, 130, 50);
   confirm.setBackground(new Color(163, 152, 134));
   confirm.setForeground(Color.WHITE);
   confirm.setFont(new Font("맑은 고딕", Font.BOLD, 18));
   confirm.setBorderPainted(false);
   
   confirm.addMouseListener(this);
   
   //============
   
   this.add(logo);
   this.add(Rt);
   this.add(et);
   this.add(Rttime);
   this.add(ettime);
   this.add(plus);
   this.add(time);
   this.add(minus);
   this.add(confirm);
   this.add(cancel);
   
   mf.add(this,0);
   mf.repaint();
   
}
   public int hourtie = 0;
   User user = new User();
   long seattime = 0;
   @Override
   public void mouseClicked(MouseEvent e) {
      /*timeHour = 0;*/
      if(e.getSource() == plus) {
         if(hour >= 1 && hour < 9) {
            hour++;
            h += 1;
            time.setText("0" + hour + ": 00");
             if(m >= 0 && m <  10) {
                ettime.setText(h + ":0" + m);
               } else {
                ettime.setText(h+":"+m) ;
               }
         } else if(hour >= 9 && hour < 23) {
            hour++;
            h += 1;
            time.setText(hour + ": 00");
             if(m >= 0 && m <  10) {
                ettime.setText(h + ":0" + m);
               } else {
                ettime.setText(h+":"+m) ;
               }
         }
         System.out.println(hour);
         seattime = hour;
      }
      
      if(e.getSource() == minus) {
          if(hour >= 1 && hour < 9) {
             hour--;
             h -= 1;
             time.setText("0" + hour + ": 00");
              if(m >= 0 && m <  10) {
                 ettime.setText(h + ":0" + m);
                } else {
                 ettime.setText(h+":"+m) ;
                }
          } else if(hour >= 9 && hour < 23) {
             hour--;
             h -= 1;
             time.setText(hour + ": 00");
              if(m >= 0 && m <  10) {
                 ettime.setText(h + ":0" + m);
                } else {
                 ettime.setText(h+":"+m) ;
                }
          }
          System.out.println(hour);
          seattime = hour;
       }
      if(e.getSource() == confirm) {
         if(seattime == 0) {
            seattime = 1;
         }
         ChangePanel.changePanel(mf, this, new KoskPayment(mf,uList,phnum,client,panel,seatnum,seattime,hOfw, tableOrManage,1));
      }
      if(e.getSource() == cancel) {
         if(tableOrManage == 1) {
            ChangePanel.changePanel(mf, this, new KoskSeatTable2(mf, uList, client, phnum));
         } else {
            ChangePanel.changePanel(mf, this, new KoskSeatManagement(mf, uList, phnum, client, panel, seatnum, seattime));
         }
      }
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
   
   public long indi() {
      
      return seattime;
   }
}