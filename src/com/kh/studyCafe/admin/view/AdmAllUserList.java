package com.kh.studyCafe.admin.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.TextAttribute;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import com.kh.studyCafe.admin.controller.AdmManager;
import com.kh.studyCafe.admin.model.dao.AdmDao;
import com.kh.studyCafe.admin.model.service.AdmUserInfoChk;
import com.kh.studyCafe.admin.model.vo.AdmUserTable;
import com.kh.studyCafe.client.ClientBack;
import com.kh.studyCafe.client.MinTimeThread;
import com.kh.studyCafe.model.vo.User;

public class AdmAllUserList extends JPanel implements ActionListener, KeyListener, MouseListener {
   private AdmMainFrame mf;
   private ClientBack client;
   private JScrollPane scrollpane = null;
   private ArrayList<AdmUserTable> utList;
   private ArrayList<AdmUserTable> allUserList;
   private ArrayList<User> u;
   private JButton allUserInfoButton;
   private JTextField searchForm;
   private JTable table;
   private DefaultTableModel model;
   private JLabel srchChk;
   private JScrollBar vertical;
   private String seatNum;
   public AdmAllUserList(AdmMainFrame mf, ArrayList<AdmUserTable> utList, ArrayList<User> u, ClientBack client) {
      this.mf = mf;
      this.client = client;
      allUserList = new AdmUserInfoChk().AllUserInfo(u);
      int allListNum = utList.size() + allUserList.size();
      this.utList = utList;
      this.u = u;
      AdmMainFrame.watchPanel = this;

      // 테이블 헤더 목록
      String[] columnNames = { "No", "회원명", "전화번호", "좌석번호", "입실시간", "퇴실예정시간", "잔여시간", "개인/단체", "좌석연장", "좌석이동", "좌석퇴실",
            "좌석입실" };

      // 테이블 내용 부분 크기
      Object[][] data = new Object[allListNum][columnNames.length];

      // 테이블 내용 뿌리기 Start

      // 이용 중인 회원
      int grpCount = 0;
      int indvCount = 0;
      for (int i = 0; i < utList.size(); i++) {
         // 개인석, 단체석 개수 표시
         if (utList.get(i).getSeatNum().contains("-")) { // 그룹일 때
            grpCount++;
         } else {
            indvCount++;
         }
      }

      // 받아온 회원 데이터를 테이블에 맞게 수정하고 테이블에 뿌림
      for (int i = 0; i < utList.size(); i++) {
         String timeEdit[] = new String[2];
         
         Date dateEdit[] = new Date[2];
         dateEdit[0] = new Date(utList.get(i).getInTime());
         dateEdit[1] = new Date(utList.get(i).getOutTime());

         // 밀리세컨드로 받아온 시간 데이터 형식 지정
         SimpleDateFormat sdf = new SimpleDateFormat("dd일 hh : mmaa");
         for (int j = 0; j < timeEdit.length; j++) {
            timeEdit[j] = sdf.format(dateEdit[j]);

         }
         data[i][8] = "연장";
         data[i][9] = "이동";
         data[i][10] = "퇴실";
         data[i][11] = "-";
         

         // 입실 시간 뿌리기
         if (timeEdit[0].split("일 ")[1].substring(7).equals("오전")) {
            data[i][4] = timeEdit[0].split("일 ")[1].substring(0, 7) + " AM";
         } else {
            data[i][4] = timeEdit[0].split("일 ")[1].substring(0, 7) + " PM";
         }
         

         // 퇴실 예정 시간 뿌리기
         if (utList.get(i).getSeatType() == User.WEEKSEAT) {
            data[i][5] = "-";
            
         }else if(utList.get(i).getSeatType() == User.HOURSEAT){
            if (timeEdit[1].split("일 ")[1].substring(7).equals("오전")) {
               data[i][5] = timeEdit[1].split("일 ")[1].substring(0, 7) + " AM";
            } else {
               data[i][5] = timeEdit[1].split("일 ")[1].substring(0, 7) + " PM";
            }

         }
         


 		// 잔여시간 형식 수정해서 테이블에 뿌리기
 		if (utList.get(i).getSeatType() == 2) { // 기간권일 때
 			data[i][6] = utList.get(i).getRemainTime() / 86400000 + 1 + "일";
 		} else if (utList.get(i).getSeatType() == 1) { // 1일권일 때
 			// 밀리세컨드를 시간 분으로 표시하기 위해 변
 			String timeResult = "";

// 				timeResult += utList.get(i).getRemainTime() % 3600000 / 60000 + 1 + "분";
 			if(utList.get(i).getRemainTime() % 3600000 / 60000 + 1 == 60) { // 60분일때 0분 처리해주는 코드
 				timeResult += utList.get(i).getRemainTime() / 3600000 + 1 + "시간 ";
 				timeResult += "0분";
             }else {
             	timeResult += utList.get(i).getRemainTime() / 3600000 + "시간 ";
             	timeResult += utList.get(i).getRemainTime() % 3600000 / 60000 + 1 + "분";
             }
 			
 			
 			data[i][6] = timeResult;
 		}


         // 개인&그룹 구분해서 테이블에 뿌리기
         if (utList.get(i).getSeatNum().contains("-")) { // 그룹일 때
            data[i][7] = "그룹";
         } else { // 개인일 때
            data[i][7] = "개인";
         }

         data[i][0] = i + 1 + "";
         data[i][1] = utList.get(i).getName();
         data[i][2] = utList.get(i).getPhoneNum();
         data[i][3] = utList.get(i).getSeatNum();

      }

      System.out.println(utList.size());
      // 스터디카페에 없는 회원
      for (int i = 0; i < allUserList.size(); i++) {
         data[i + utList.size()][8] = "-";
         data[i + utList.size()][9] = "-";
         data[i + utList.size()][10] = "-";
         data[i + utList.size()][11] = "입실";

         data[i + utList.size()][0] = i + utList.size() + 1 + "";
         data[i + utList.size()][1] = allUserList.get(i).getName();
         data[i + utList.size()][2] = allUserList.get(i).getPhoneNum();
         data[i + utList.size()][4] = "-";
         data[i + utList.size()][5] = "-";

         if (!allUserList.get(i).getSeatNum().equals("0")) { // 기간권 이용 중일 때
            data[i + utList.size()][3] = allUserList.get(i).getSeatNum();
            data[i + utList.size()][7] = "개인";
         } else { // 기간권 이용 중이지 않을 때
            data[i + utList.size()][3] = "-";
            data[i + utList.size()][7] = "-";
         }

         if (data[i + utList.size()][3].equals("-")) {
            data[i + utList.size()][6] = "-";
         } else {
            data[i + utList.size()][6] = allUserList.get(i).getRemainTime() / 86400000 + 1 +  "일";
         }

      }
      
      

      // 테이블 내용 뿌리기 End

      // this.은 panel 설정
      this.setBounds(0, 0, 978, 700);

      // 테이블 모델만들기
      // 버튼부분빼고 셀의 내용 수정불가하도록 설정
      model = new DefaultTableModel(data, columnNames) {
         public boolean isCellEditable(int row, int column) {
//            if (column >= 8) { // 버튼 쪽 부분
//               if (row > utList.size() - 1 && column != columnNames.length - 1) { // 스터디카페에 없는 회원의 이동, 연장, 퇴실
//                  return false;
//               } else if (row < utList.size() && column == columnNames.length - 1) { // 이용중인 회원의 입실
//                  return false;
//               } else {
//                  return true;
//               }
//            } else { // 버튼 아닌 부분
//               return false;
//            }
            return false;
         }
      };

      this.setLayout(null);
      this.setBackground(Color.WHITE);
      
      
      // 테이블 생성
      // 이용중인 회원일 경우 셀의 색을 바꾸어서 표시함
      // 버튼 부분은 백그라운드 색으로 흰색으로 칠하여 없는것처럼 보이게 해놓았으나 수정이필요함
      table = new JTable(model) {
         @Override
         public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
            if (row < utList.size()) { // 이용 중인 회원 셀 색 바꾸기
               JComponent component = (JComponent) super.prepareRenderer(renderer, row, column);
               component.setBackground(new Color(239, 234, 222));
               component.setForeground(new Color(127, 118, 104));
               if (column > columnNames.length - 5 && column != columnNames.length - 1) {
                  component.setBackground(new Color(158, 149, 135));
                  component.setForeground(Color.WHITE);
                  component.setFont(new Font("맑은 고딕", Font.BOLD, 14));
               }
               
               return component;
            } else {
               JComponent component = (JComponent) super.prepareRenderer(renderer, row, column);
               if (column == columnNames.length - 1) {
                  component.setBackground(new Color(158, 149, 135));
                  component.setForeground(Color.WHITE);
                  component.setFont(new Font("맑은 고딕", Font.BOLD, 14));
               } else {
                  component.setBorder(BorderFactory.createLineBorder(Color.WHITE));
                  component.setBackground(Color.WHITE);
                  component.setForeground(new Color(127, 118, 104));
               }
               return component;
            }

         }
      };

      // 이미지 파일 불러오기
      Image icon = new ImageIcon("img/logo.png").getImage().getScaledInstance(41, 54, 0);
      JLabel logoLabel = new JLabel(new ImageIcon(icon));
      logoLabel.setLocation(470, 35);
      logoLabel.setSize(41, 54);
      JTableHeader header = table.getTableHeader();

      // 테이블 헤더 크기설정
      header.setPreferredSize(new Dimension(10, 50));

      // 테이블 행 높이 설정
      table.setRowHeight(40);

      table.getColumnModel().getColumn(0).setPreferredWidth(30);
      table.getColumnModel().getColumn(1).setPreferredWidth(60);
      table.getColumnModel().getColumn(2).setPreferredWidth(110);
      table.getColumnModel().getColumn(3).setPreferredWidth(66);
      table.getColumnModel().getColumn(4).setPreferredWidth(78);
      table.getColumnModel().getColumn(5).setPreferredWidth(90);
      table.getColumnModel().getColumn(6).setPreferredWidth(80);
      table.getColumnModel().getColumn(7).setPreferredWidth(74);
      table.getColumnModel().getColumn(8).setPreferredWidth(66);
      table.getColumnModel().getColumn(9).setPreferredWidth(66);
      table.getColumnModel().getColumn(10).setPreferredWidth(66);
      table.getColumnModel().getColumn(11).setPreferredWidth(66);
      

      // 테이블 스크롤 기능 추가해서 넣기
      scrollpane = new JScrollPane(table);

      // 전체 테이블 크기설정
//       scrollpane.setPreferredSize(new Dimension(920, 504));
      // 테이블 모양 설정
      scrollpane.setBounds(21, 118, 920, 504);
      scrollpane.getViewport().setBackground(Color.WHITE);
      scrollpane.setBackground(Color.WHITE);
      scrollpane.setBorder(BorderFactory.createLineBorder(Color.WHITE));
      table.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createCompoundBorder(), BorderFactory.createMatteBorder(0, 1, 1, 1, new Color(127, 118, 104))));
      table.setGridColor(new Color(127, 118, 104));
      table.setForeground(new Color(127, 118, 104));
      table.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
      // 테이블 헤더 설정
      header.setBorder(BorderFactory.createLineBorder(new Color(127, 118, 104)));
      header.setForeground(new Color(127, 118, 104));
      header.setFont(new Font("맑은 고딕", Font.BOLD, 14));
      header.setBackground(Color.WHITE);

      // DefaultTableCellHeaderRenderer 생성 (가운데 정렬을 위한)
      DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();
      // DefaultTableCellHeaderRenderer의 정렬을 가운데 정렬로 지정
      tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
      // 정렬할 테이블의 ColumnModel을 가져옴
      TableColumnModel tcmSchedule = table.getColumnModel();
      // 반복문을 이용하여 테이블을 가운데 정렬로 지정
      for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
         tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
      }

      // 이용중인 회원보기 버튼생성
      allUserInfoButton = new JButton("이용 중인 회원 보기");
      allUserInfoButton.setBounds(780, 70, 160, 42);
      allUserInfoButton.setBackground(new Color(189, 177, 157));
      allUserInfoButton.setForeground(Color.WHITE);
      allUserInfoButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
      allUserInfoButton.setBorder(BorderFactory.createLineBorder(new Color(189, 177, 157)));
      allUserInfoButton.addActionListener(this);

      // 테이블의 크기를 조절하지 못하도록 함
      table.getTableHeader().setReorderingAllowed(false);
      table.getTableHeader().setResizingAllowed(false);

      // 테이블 연장 / 이동 / 퇴실 열에 버튼을 생성함
//      table.getColumnModel().getColumn(8).setCellRenderer(new AdmTableAddTime(mf, this, table, client, scrollpane));
//      table.getColumnModel().getColumn(8).setCellEditor(new AdmTableAddTime(mf, this, table, client, scrollpane));
//
//      table.getColumnModel().getColumn(9).setCellRenderer(new AdmTableSeatMove(mf, this, table, client, scrollpane, utList));
//      table.getColumnModel().getColumn(9).setCellEditor(new AdmTableSeatMove(mf, this, table, client, scrollpane, utList));
//
//      table.getColumnModel().getColumn(10).setCellRenderer(new AdmTableExitSeat(mf, this, table, scrollpane, client));
//      table.getColumnModel().getColumn(10).setCellEditor(new AdmTableExitSeat(mf, this, table, scrollpane, client));
//
//      table.getColumnModel().getColumn(11).setCellRenderer(new AdmTableEnterSeat(mf, this, table, client, scrollpane, utList));
//      table.getColumnModel().getColumn(11).setCellEditor(new AdmTableEnterSeat(mf, this, table, client, scrollpane, utList));

      // 회원검색용 텍스트 필드 생성
      searchForm = new JTextField();
      searchForm.setBounds(59, 74, 178, 40);
      searchForm.setBorder(BorderFactory.createLineBorder(new Color(127, 118, 104)));
      searchForm.addKeyListener(this);

      // 회원검색용 이미지 파일 불러오기
      Image icon2 = new ImageIcon("img/search.PNG").getImage().getScaledInstance(32, 39, 0);
      JLabel searchLabel = new JLabel(new ImageIcon(icon2));
      searchLabel.setLocation(23, 75);
      searchLabel.setSize(32, 39);


      srchChk = new JLabel();
      srchChk.setBounds(22, 168, 620, 41);
      srchChk.setBackground(Color.RED);
      srchChk.setBorder(BorderFactory.createEmptyBorder());
      vertical = scrollpane.getVerticalScrollBar();
      
      table.addMouseListener(this);
      
      this.add(srchChk, new Integer(10));
      // 패널에 추가하기
      this.add(searchForm);
      this.add(searchLabel);
      this.add(logoLabel);
      this.add(allUserInfoButton);
      this.add(scrollpane);
      
//      System.out.println(vertical.getSize());
//      
//		MinTimeThread timeThread = new MinTimeThread(client);
//		timeThread.execute();

   }

   @Override
   public void actionPerformed(ActionEvent e) {

      // 이용중인 회원 버튼 클릭 시 패널 변경
      if (e.getSource() == allUserInfoButton) {
         ControlPanel cp = new ControlPanel();

         cp.changeTablePanel(mf, this,
               new AdmUsingUserList(mf, new AdmManager().usingUserManager(), new AdmDao().admRead(), client));

      }

   }

   @Override
   public void keyPressed(KeyEvent e) {
      if (e.getKeyCode() == KeyEvent.VK_ENTER) { // 검색 기능
         srchChk.setBorder(BorderFactory.createEmptyBorder());
         
         for (int i = 0; i < utList.size(); i++) { // 이용 중인 회원 이름 검색 시
            if (utList.get(i).getName().contains(searchForm.getText().trim())) {
               if(i>10) {
//                  System.out.println("a지역");
                  vertical.setValue((i-10)*40-12);
                  srchChk.setLocation(22, (181+ 10*40));
               }else {
//                  System.out.println("c지역");
                  vertical.setValue(0);
                  srchChk.setLocation(22, (168+ i*40));
               }
               srchChk.setBorder(BorderFactory.createLineBorder(new Color(255,203,0), 4));
               break;
            }
         }
         for (int i = 0; i < allUserList.size(); i++) { // 전체 회원 이름 검색 시
            if (allUserList.get(i).getName().contains(searchForm.getText().trim())) {
               int num = i + utList.size();
               if(num>10) {
//                  System.out.println("1a지역");
                  vertical.setValue((num-10)*40 - 12);
                  srchChk.setLocation(22, (181+ 10*40));
               }else {
//                  System.out.println("1c지역");
                  vertical.setValue(0);
                  srchChk.setLocation(22, (168+ num*40));
               }
               
               srchChk.setBorder(BorderFactory.createLineBorder(new Color(255,203,0), 4));
               break;
            }
         }
         for (int i = 0; i < utList.size(); i++) { // 이용 중인 회원 전화번호 검색 시
            if (utList.get(i).getPhoneNum().contains(searchForm.getText().trim())) {
            	System.out.println("이용중인 회원 전화번호");
            	System.out.println(utList.get(i).getPhoneNum());
            	System.out.println(searchForm.getText().trim());
               if(i>10) {
//                  System.out.println("a지역");
                  vertical.setValue((i-10)*40-12);
                  srchChk.setLocation(22, (181+ 10*40));
               }else {
//                  System.out.println("c지역");
                  vertical.setValue(0);
                  srchChk.setLocation(22, (168+ i*40));
               }
               srchChk.setBorder(BorderFactory.createLineBorder(new Color(255,203,0), 4));
               break;
            }
         }
         for (int i = 0; i < allUserList.size(); i++) { // 전체 회원 전화번호 이름 검색 시
            if (allUserList.get(i).getPhoneNum().contains(searchForm.getText().trim())) {
             	System.out.println("전체 회원 전화번호");
             	System.out.println(allUserList.get(i).getPhoneNum());
             	System.out.println(searchForm.getText().trim());
                int num = i + utList.size();
               if(num>10) {
            	  vertical.setValue((num-10)*40 - 12);
                  srchChk.setLocation(22, (181+ 10*40));
               }else {
                  vertical.setValue(0);
                  srchChk.setLocation(22, (168+ num*40));
               }
               srchChk.setBorder(BorderFactory.createLineBorder(new Color(255,203,0), 4));
               break;
            }
         }
      } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) { // 검색 취소 기능
         srchChk.setBorder(BorderFactory.createEmptyBorder());
         searchForm.setText("");
      }
   }

   @Override
   public void keyReleased(KeyEvent e) {
      // TODO Auto-generated method stub

   }

   @Override
   public void keyTyped(KeyEvent e) {

   }

   @Override
   public void mouseClicked(MouseEvent e) {
      System.out.println(table.getSelectedRow());
      String tablePhone = table.getValueAt(table.getSelectedRow(), 2) + "";
      AdmDao ad = new AdmDao();
      ControlPanel cp = new ControlPanel();
      if(table.getSelectedColumn() == 1) {
         cp.addPanel(mf, this, new AdmUserInfo(mf, ad.toUserInfo(tablePhone),this, client));         
      }
      if(table.getSelectedColumn() == 8) {//연장
         scrollpane.getHorizontalScrollBar().setEnabled(false);
         scrollpane.getVerticalScrollBar().setEnabled(false);
         scrollpane.getViewport().getView().setEnabled(false);

         int row = table.getSelectedRow();
         tablePhone = table.getValueAt(row, 2) + "";
//         String seatTimeType = table.getValueAt(row, 6) + "";
         String remainTimeChk = table.getValueAt(row, 6) + "";
//         remainTimeChk = remainTimeChk.split("시간 ")[0];
//         System.out.println();
      
         // 회원에 따라 연장 버튼 연결 구분
         if (table.getValueAt(row, 7).equals("개인")) { // 개인일 때
            if(remainTimeChk.contains("일")) { // 기간권일때
               cp.addPanel(mf, this, new AdmAddTimeWeek(mf, this, tablePhone, client));
            }else {
//               System.out.println(remainTimeChk.split("시간 ")[0]);
//               sysout
               if(Integer.parseInt(remainTimeChk.split("시간 ")[0]) == 0 && Integer.parseInt(remainTimeChk.split("시간 ")[1].split("분")[0]) < 30) { // 잔여시간이 30분 미만일 때
                  cp.addPanel(mf, this, new AdmAddTimeHour(mf, this, tablePhone, client));
               }else {
                  cp.addPanel(mf, this, new AdmAddNotice(mf, this, client));
               }   
            }
         } else { // 그룹일 때
            cp.addPanel(mf, this, new AdmAddTimeHour(mf, this, tablePhone, client));
         }

      }
      
      if(table.getSelectedColumn() == 9) {//이동
         scrollpane.getHorizontalScrollBar().setEnabled(false);
         scrollpane.getVerticalScrollBar().setEnabled(false);
         scrollpane.getViewport().getView().setEnabled(false);

         int row = table.getSelectedRow();
         tablePhone = table.getValueAt(row, 2) + "";
         seatNum = table.getValueAt(row, 3) + "";
         

         // 회원에 따라 이동 버튼 연결 구분
         if (table.getValueAt(row, 7).equals("개인")) { // 개인일 때
            cp.addPanel(mf, this, new AdmSeatTable(mf, this, client, tablePhone, utList, seatNum, u));
         } else { // 그룹일 때
            cp.addPanel(mf, this, new AdmMoveGrp(mf, this, client));
         }
      }
      if(table.getSelectedColumn() == 10) {//퇴실
         scrollpane.getHorizontalScrollBar().setEnabled(false);
         scrollpane.getVerticalScrollBar().setEnabled(false);
         scrollpane.getViewport().getView().setEnabled(false);

         int row = table.getSelectedRow();
         String seatTimeType = table.getValueAt(row, 6) + "";
         String phoneNum = table.getValueAt(row, 2) + "";

         // 회원에 따라 퇴실 버튼 연결 구분
         if (seatTimeType.contains("일")) { // 기간권일 때
            cp.addPanel(mf, this, new AdmExitTimeWeek(mf, this, client, phoneNum));
         } else { // 1일권일 떄
            cp.addPanel(mf, this, new AdmExitTimeHour(mf, this, client, phoneNum));
         }
      }
      if(table.getSelectedColumn() == 11) { //입실
         scrollpane.getHorizontalScrollBar().setEnabled(false);
         scrollpane.getVerticalScrollBar().setEnabled(false);
         scrollpane.getViewport().getView().setEnabled(false);
         

         int row = table.getSelectedRow();
         tablePhone = table.getValueAt(row, 2) + "";
         seatNum = table.getValueAt(row, 3) + "";
         String inTime = table.getValueAt(row, 4)+ "";
         System.out.println(seatNum);
         System.out.println(inTime);
         // 회원에 따라 이동 버튼 연결 구분
         //만약 입실하지 않은 기간권 사용자가 입실할 경우 좌석번호는 가지고 있고 입실시간은 가지고 있지 않다.
         //기간권이 없는 회원이 입실할 경우 좌석번호 없고, 입실시간도 없다.
         if(seatNum.equals("-") && inTime.equals("-")) {
            cp.addPanel(mf, this, new AdmSeatTable(mf, this, client, tablePhone, utList, seatNum, u));            
         } else if(inTime.equals("-")) {
            cp.addPanel(mf, this, new AdmEnterTimeWeek(mf, this, client, tablePhone));            
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

}