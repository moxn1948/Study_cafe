package com.kh.studyCafe.admin.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import com.kh.studyCafe.admin.model.dao.AdmDao;
import com.kh.studyCafe.admin.model.vo.AdmUserTable;
import com.kh.studyCafe.client.ClientBack;
import com.kh.studyCafe.client.MinTimeThread;
//import com.kh.studyCafe.client.MinTimeThread;
import com.kh.studyCafe.model.vo.User;

public class AdmUsingUserList extends JPanel implements ActionListener, MouseListener {
	private JButton allUserInfoButton = null;
	private AdmMainFrame mf;
	private ClientBack client;
	private ArrayList<AdmUserTable> utList;
	private ArrayList<User> u;
	private JScrollPane scrollpane = null;
	private JButton cafeInfo = null;
	private static boolean threadControl;
	private JTable table;

	public AdmUsingUserList(AdmMainFrame mf, ArrayList<AdmUserTable> utList, ArrayList<User> u, ClientBack client) {
		this.mf = mf;
		this.client = client;
		this.utList = utList;
		this.u = u;
		AdmMainFrame.watchPanel = this;
		
		// 테이블 헤더 목록
		String[] columnNames = { "No", "회원명", "전화번호", "좌석번호", "입실시간", "퇴실예정시간", "잔여시간", "개인/단체", "좌석연장", "좌석이동",
				"좌석퇴실" };

		// 테이블 내용 부분 크기
		Object[][] data = new Object[utList.size()][columnNames.length];

		// 개인석, 단체석 개수 변수
		int grpCount = 0;
		int indvCount = 0;
		for (int i = 0; i < utList.size(); i++) {
			// 개인석, 단체석 개수 표시
			if (!utList.get(i).getSeatNum().equals("0")) {
				if (utList.get(i).getSeatNum().contains("-")) { // 그룹일 때
					grpCount++;
				} else {
					indvCount++;
				}
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

//				timeResult += utList.get(i).getRemainTime() % 3600000 / 60000 + 1 + "분";
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
			data[i][8] = "연장";
			data[i][9] = "이동";
			data[i][10] = "퇴실";

		}

		// this.은 panel 설정
		this.setBounds(0, 0, 978, 700);

		// 테이블 모델만들기
		DefaultTableModel model = new DefaultTableModel(data, columnNames) {
			public boolean isCellEditable(int row, int column) {
				if (column >= 8) {
					return true;
				}
				return false;
			}
		};
		this.setLayout(null);
		this.setBackground(Color.WHITE);
		// 테이블 생성
		  table = new JTable(model) {
			@Override
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				if (column > columnNames.length - 4) { // 이용 중인 회원 셀 색 바꾸기
					JComponent component = (JComponent) super.prepareRenderer(renderer, row, column);
					component.setBackground(new Color(158, 149, 135));
					component.setForeground(Color.WHITE);
					component.setFont(new Font("맑은 고딕", Font.BOLD, 14));
					

					return component;
				} else {
					JComponent component = (JComponent) super.prepareRenderer(renderer, row, column);
					// if (column == columnNames.length - 1) {
					// component.setBackground(new Color(158, 149, 135));
					component.setBackground(Color.WHITE);
					component.setForeground(new Color(127, 118, 104));
					component.setFont(new Font("맑은 고딕", Font.PLAIN, 14));

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

		table.getColumnModel().getColumn(0).setPreferredWidth(32);
		table.getColumnModel().getColumn(1).setPreferredWidth(70);
		table.getColumnModel().getColumn(2).setPreferredWidth(104);
		table.getColumnModel().getColumn(3).setPreferredWidth(60);
		table.getColumnModel().getColumn(4).setPreferredWidth(84);
		table.getColumnModel().getColumn(5).setPreferredWidth(84);
		table.getColumnModel().getColumn(6).setPreferredWidth(84);
		table.getColumnModel().getColumn(7).setPreferredWidth(76);
		table.getColumnModel().getColumn(8).setPreferredWidth(66);
		table.getColumnModel().getColumn(9).setPreferredWidth(66);
		table.getColumnModel().getColumn(10).setPreferredWidth(66);

		// 테이블 스크롤 기능 추가해서 넣기
		scrollpane = new JScrollPane(table);

		// 전체 테이블 크기설정
		// scrollpane.setPreferredSize(new Dimension(920, 504));
		// 테이블 모양 설정
		scrollpane.setBounds(21, 118, 920, 478);
		scrollpane.getViewport().setBackground(Color.WHITE);
		scrollpane.setBackground(Color.WHITE);
		scrollpane.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		table.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createCompoundBorder(),
				BorderFactory.createMatteBorder(0, 1, 1, 1, new Color(127, 118, 104))));
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

		// 매장정보보기 버튼 생성
		cafeInfo = new JButton("매장 정보 보기");
		cafeInfo.setBounds(801, 603, 140, 42);
		cafeInfo.setBackground(new Color(189, 177, 157));
		cafeInfo.setForeground(Color.WHITE);
		cafeInfo.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		cafeInfo.setBorder(BorderFactory.createLineBorder(new Color(189, 177, 157)));

		// 전체 회원보기 버튼생성
		allUserInfoButton = new JButton("전체 회원 보기");
		allUserInfoButton.setBounds(801, 70, 140, 42);
		allUserInfoButton.setBackground(Color.WHITE);
		allUserInfoButton.setForeground(new Color(189, 177, 157));
		allUserInfoButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		allUserInfoButton.setBorder(BorderFactory.createLineBorder(new Color(189, 177, 157)));
		allUserInfoButton.addActionListener(this);

		// 사용중인 개인석보는 라벨 생성
		JLabel usingSeat = new JLabel("개인석    / 25");
		usingSeat.setLocation(23, 78);
		usingSeat.setForeground(new Color(127, 118, 104));
		usingSeat.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		usingSeat.setSize(usingSeat.getPreferredSize());

		// 사용중인 단체석보는 라벨생성
		JLabel usingSeatGrp = new JLabel("단체석    / 5");
		usingSeatGrp.setLocation(23, 95);
		usingSeatGrp.setForeground(new Color(127, 118, 104));
		usingSeatGrp.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		usingSeatGrp.setSize(usingSeatGrp.getPreferredSize());

		// 사용중인 개인석 표시할 라벨(수정해야함)
		JLabel usingInfo = new JLabel(indvCount + "");
		usingInfo.setLocation(67, 78);
		usingInfo.setForeground(new Color(127, 118, 104));
		usingInfo.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		usingInfo.setSize(usingInfo.getPreferredSize());

		// 사용중인 단체석 표시할 라벨(수정해야함)
		JLabel usingInfoGrp = new JLabel(grpCount + "");
		usingInfoGrp.setLocation(67, 95);
		usingInfoGrp.setForeground(new Color(127, 118, 104));
		usingInfoGrp.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		usingInfoGrp.setSize(usingInfoGrp.getPreferredSize());

		// 테이블 내용 수정못하도록 바꿈
		// table.setEnabled(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		
		
//		table.getColumnModel().getColumn(8).setCellRenderer(new AdmTableAddTime(mf, this, table, client, scrollpane));
//		table.getColumnModel().getColumn(8).setCellEditor(new AdmTableAddTime(mf, this, table, client, scrollpane));
//		
//		table.getColumnModel().getColumn(9).setCellRenderer(new AdmTableSeatMove(mf, this, table, client, scrollpane, utList));
//		table.getColumnModel().getColumn(9).setCellEditor(new AdmTableSeatMove(mf, this, table, client, scrollpane, utList));
//
//		table.getColumnModel().getColumn(10).setCellRenderer(new AdmTableExitSeat(mf, this, table, scrollpane, client));
//		table.getColumnModel().getColumn(10).setCellEditor(new AdmTableExitSeat(mf, this, table, scrollpane, client));

		table.addMouseListener(this);
		
		// 패널에 추가하기
		this.add(logoLabel);
		this.add(usingInfo);
		this.add(usingInfoGrp);
		this.add(usingSeat);
		this.add(usingSeatGrp);
		this.add(allUserInfoButton);
		this.add(cafeInfo);
		this.add(scrollpane);
		
		
		if(!threadControl) {
			// 시계스레드 start
			MinTimeThread timeThread = new MinTimeThread(client);
			timeThread.setDaemon(true);
			timeThread.start();
			
			threadControl = true;
		}
		
//		while(true) {
//			MinTimeThread timeThread = new MinTimeThread(client);
//			timeThread.execute();
			
//		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ControlPanel cp = new ControlPanel();

		// 전체회원보기 버튼 클릭 시 패널 변경
		if (e.getSource() == allUserInfoButton) {

			cp.changeTablePanel(mf, this, new AdmAllUserList(mf, utList, u, client));

		}

		// 매장정보보기 버튼 클릭 시 패널 변경
		if (e.getSource() == cafeInfo) {

			cp.addPanel(mf, this, new AdmCafeInfo(mf));

			scrollpane.getHorizontalScrollBar().setEnabled(false);
			scrollpane.getVerticalScrollBar().setEnabled(false);
			scrollpane.getViewport().getView().setEnabled(false);

		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(table.getSelectedRow());
		String tablePhone = table.getValueAt(table.getSelectedRow(), 2) + "";
		AdmDao ad = new AdmDao();
		ControlPanel cp = new ControlPanel();
		if(table.getSelectedColumn() == 1) {
			scrollpane.getHorizontalScrollBar().setEnabled(false);
			scrollpane.getVerticalScrollBar().setEnabled(false);
			scrollpane.getViewport().getView().setEnabled(false);
			
			cp.addPanel(mf, this, new AdmUserInfo(mf, ad.toUserInfo(tablePhone),this,client));			
		}
		if(table.getSelectedColumn() == 8) {//연장
			scrollpane.getHorizontalScrollBar().setEnabled(false);
			scrollpane.getVerticalScrollBar().setEnabled(false);
			scrollpane.getViewport().getView().setEnabled(false);

			int row = table.getSelectedRow();
			tablePhone = table.getValueAt(row, 2) + "";
			String remainTimeChk = table.getValueAt(row, 6) + "";
		
			// 회원에 따라 연장 버튼 연결 구분
			if (table.getValueAt(row, 7).equals("개인")) { // 개인일 때
				if(remainTimeChk.contains("일")) { // 기간권일때
					cp.addPanel(mf, this, new AdmAddTimeWeek(mf, this, tablePhone, client));
				}else {
					if(Integer.parseInt(remainTimeChk.split("시간 ")[0]) == 0 && Integer.parseInt(remainTimeChk.split("시간 ")[1].split("분")[0]) < 30) { // 잔여시간이 30분 미만일 때
						cp.addPanel(mf, this, new AdmAddTimeHour(mf, this, tablePhone, client));
					}else {
						cp.addPanel(mf, this, new AdmAddNotice(mf, this, client));
					}	
				}
			} else { // 그룹일 때
				if(Integer.parseInt(remainTimeChk.split("시간 ")[0]) == 0 && Integer.parseInt(remainTimeChk.split("시간 ")[1].split("분")[0]) < 30) {
					cp.addPanel(mf, this, new AdmAddTimeHour(mf, this, tablePhone, client));
				}else {
					cp.addPanel(mf, this, new AdmAddNotice(mf, this, client));
				}
			}

		}
		
		if(table.getSelectedColumn() == 9) {//이동
			scrollpane.getHorizontalScrollBar().setEnabled(false);
			scrollpane.getVerticalScrollBar().setEnabled(false);
			scrollpane.getViewport().getView().setEnabled(false);

			int row = table.getSelectedRow();
			tablePhone = table.getValueAt(row, 2) + "";
			String seatNum = table.getValueAt(row, 3) + "";
			

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
