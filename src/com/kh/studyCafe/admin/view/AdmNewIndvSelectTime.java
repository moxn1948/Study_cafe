package com.kh.studyCafe.admin.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.kh.studyCafe.admin.controller.AdmManager;
import com.kh.studyCafe.admin.model.dao.AdmDao;
import com.kh.studyCafe.admin.model.vo.AdmUserTable;
import com.kh.studyCafe.client.ClientBack;
import com.kh.studyCafe.model.vo.User;

public class AdmNewIndvSelectTime extends JPanel implements ActionListener, ItemListener{
	private AdmMainFrame mf = null;
	private JPanel op = null;
	private ClientBack client = null;
	private String phoneNum = null;
	private JButton cancelBtn = null;
	private JButton confirmBtn = null;
	private int term = 1;
	private JButton countUpBtn = null;
	private JButton countDownBtn = null;
	private ArrayList<AdmUserTable> utList;
	private ArrayList<User> u;
	private JPanel op2;
	private JLabel totalHourCountNum;
	private JLabel boxHourDisplay;
	private JLabel totalweekCountNum;
	private JButton timeUpBtn;
	private JButton timeDownBtn;
	private int weekTerm = 7;
	private JTextField boxWeekDisplay;
	private ButtonGroup timeRadio;
	private String selectedKind = "1일권";
	private String seatNum;

	public AdmNewIndvSelectTime(AdmMainFrame mf, JPanel op,JPanel op2, ClientBack client, String phoneNum, ArrayList<AdmUserTable> utList, ArrayList<User> u, String seatNum) {
		this.mf = mf;
		this.op = op;
		this.op2 = op2;
		this.client = client;
		this.phoneNum = phoneNum;
		this.utList = utList;
		this.u = u;
		this.seatNum = seatNum;
//
//		AdmMainFrame.livePanel = this;
		// 패널 설정
		int w = 731;
		int h = 474;
		int x = popPosition(w, h)[0];
		int y = popPosition(w, h)[1];


		this.setLayout(null);
		this.setBounds(x, y, w, h); 
		this.setBackground(new Color(239, 234, 222));
		this.setBorder(BorderFactory.createLineBorder(new Color(163, 152, 134)));


		JLayeredPane hourLayer = new JLayeredPane();
		hourLayer.setBounds(30,28,334,349);
		hourLayer.setBorder(BorderFactory.createLineBorder(new Color(127, 118, 104)));

		// 1일권 설정
		JRadioButton hourCount = new JRadioButton("1일권");

		hourCount.setBackground(new Color(239, 234, 222));
		hourCount.setLocation(124, 34);
		hourCount.setForeground(new Color(127, 118, 104));
		hourCount.setFont(new Font("맑은 고딕", Font.BOLD, 28));
		hourCount.setSize(hourCount.getPreferredSize());
		hourCount.setSelected(true);
		
		// 1일권 총 시간 타이틀
		JLabel totalHourCount = new JLabel("이용하실 시간");

		totalHourCount.setLocation(76, 102);
		totalHourCount.setForeground(new Color(127, 118, 104));
		totalHourCount.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		totalHourCount.setSize(totalHourCount.getPreferredSize());

		// 1일권 총 시간 데이터 부분
		totalHourCountNum = new JLabel("01:00"); // 시간 변경 부분

		totalHourCountNum.setLocation(210, 102);
		totalHourCountNum.setForeground(new Color(127, 118, 104));
		totalHourCountNum.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		totalHourCountNum.setSize(totalHourCountNum.getPreferredSize());

		// +, - 버튼 설정
		countUpBtn = new JButton("+");
		countDownBtn = new JButton("-");

		countUpBtn.setBounds(66, 166, 200, 44);
		countDownBtn.setBounds(66, 262, 200, 44);
		countUpBtn.setBackground(new Color(127, 118, 104));
		countDownBtn.setBackground(new Color(127, 118, 104));
		countUpBtn.setForeground(Color.WHITE);
		countUpBtn.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		countDownBtn.setForeground(Color.WHITE);
		countDownBtn.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		countUpBtn.setBorder(BorderFactory.createLineBorder(new Color(189, 177, 157)));
		countDownBtn.setBorder(BorderFactory.createLineBorder(new Color(163, 152, 134)));
		countUpBtn.addActionListener(this);
		countDownBtn.addActionListener(this);


		// 인원 표시
		boxHourDisplay = new JLabel("01:00"); // 박스 안 시간 변경 부분
		boxHourDisplay.setBounds(66, 216, 200, 40);
		boxHourDisplay.setBackground(Color.WHITE);
		boxHourDisplay.setForeground(new Color(127, 118, 104));
		boxHourDisplay.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		boxHourDisplay.setBorder(BorderFactory.createEmptyBorder());
		boxHourDisplay.setHorizontalAlignment(JLabel.CENTER);


		hourLayer.add(hourCount);
		hourLayer.add(totalHourCount); 
		hourLayer.add(totalHourCountNum);
		hourLayer.add(countUpBtn);
		hourLayer.add(countDownBtn);
		hourLayer.add(boxHourDisplay);


		JLayeredPane weekLayer = new JLayeredPane();
		weekLayer.setBounds(368,28,334,349);
		weekLayer.setBorder(BorderFactory.createLineBorder(new Color(127, 118, 104)));

		// 시간 텍스트 설정
		JRadioButton weekCount = new JRadioButton("기간권");

		weekCount.setBackground(new Color(239, 234, 222));

		weekCount.setLocation(125, 36);
		weekCount.setForeground(new Color(127, 118, 104));
		weekCount.setFont(new Font("맑은 고딕", Font.BOLD, 28));
		weekCount.setSize(weekCount.getPreferredSize());


		// 총 시간 표시
		JLabel totalweekCount = new JLabel("이용하실 기간");

		totalweekCount.setLocation(74, 102);
		totalweekCount.setForeground(new Color(127, 118, 104));
		totalweekCount.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		totalweekCount.setSize(totalweekCount.getPreferredSize());

		// 총 시간 - 시간 표시
		totalweekCountNum = new JLabel("7일");

		totalweekCountNum.setLocation(214, 102);
		totalweekCountNum.setForeground(new Color(127, 118, 104));
		totalweekCountNum.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		totalweekCountNum.setSize(totalweekCountNum.getPreferredSize());

		// +, - 버튼 설정
		timeUpBtn = new JButton("+");
		timeDownBtn = new JButton("-");

		timeUpBtn.setBounds(66, 166, 200, 44);
		timeDownBtn.setBounds(66, 262, 200, 44);
		timeUpBtn.setBackground(new Color(127, 118, 104));
		timeDownBtn.setBackground(new Color(127, 118, 104));
		timeUpBtn.setForeground(Color.WHITE);
		timeUpBtn.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		timeDownBtn.setForeground(Color.WHITE);
		timeDownBtn.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		timeUpBtn.setBorder(BorderFactory.createLineBorder(new Color(189, 177, 157)));
		timeDownBtn.setBorder(BorderFactory.createLineBorder(new Color(163, 152, 134)));
		timeUpBtn.addActionListener(this);
		timeDownBtn.addActionListener(this);

		// 기간 표시
		boxWeekDisplay = new JTextField("7일"); // 박스 안 기간 변경 부분

		boxWeekDisplay.setBounds(66, 216, 200, 40);
		boxWeekDisplay.setBackground(Color.WHITE);
		boxWeekDisplay.setForeground(new Color(127, 118, 104));
		boxWeekDisplay.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		boxWeekDisplay.setBorder(BorderFactory.createEmptyBorder());
		boxWeekDisplay.setHorizontalAlignment(JTextField.CENTER);

		weekLayer.add(weekCount);
		weekLayer.add(totalweekCount);
		weekLayer.add(totalweekCountNum);
		weekLayer.add(timeUpBtn);
		weekLayer.add(timeDownBtn);
		weekLayer.add(boxWeekDisplay);   

		// 버튼 설정
		cancelBtn = new JButton("Cancel");
		confirmBtn = new JButton("Confirm");

		cancelBtn.setBounds(30, 390, 334, 50);
		confirmBtn.setBounds(368,390, 334, 50);
		cancelBtn.setBackground(new Color(189, 177, 157));
		confirmBtn.setBackground(new Color(163, 152, 134));
		cancelBtn.setForeground(Color.WHITE);
		cancelBtn.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		confirmBtn.setForeground(Color.WHITE);
		confirmBtn.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		cancelBtn.setBorder(BorderFactory.createLineBorder(new Color(189, 177, 157)));
		confirmBtn.setBorder(BorderFactory.createLineBorder(new Color(163, 152, 134)));
		cancelBtn.addActionListener(this);
		confirmBtn.addActionListener(this);

		timeRadio = new ButtonGroup();
		timeRadio.add(hourCount);
		timeRadio.add(weekCount);
		
//		Enumeration<AbstractButton> radioChk = timeRadio.getElements();
//		
//		while(radioChk.hasMoreElements()) {
//			AbstractButton ab = radioChk.nextElement();
//			JRadioButton jb = (JRadioButton) ab;
//			
//			if(jb.isSelected()) {
//				selectedKind = jb.getText();
//				System.out.println(selectedKind);
//			}
//		}
		
		hourCount.addItemListener(this);
		weekCount.addItemListener(this);
		

		this.add(hourLayer);
		this.add(weekLayer);

		this.add(cancelBtn);
		this.add(confirmBtn);

	}

	public int[] popPosition(int w, int h) {
		int[] position = new int[2];

		position[0] = (962 - w) / 2;
		position[1] = (662 - h) / 2 + 34;

		return position;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ControlPanel cp = new ControlPanel();
		// 시간권 시간값 변경 엑션
		if(e.getSource() == countUpBtn) {
			if (term < 9 && term > 0) {

				++term;

				System.out.println("a  : " + term);
				totalHourCountNum.setText("0" + term + " : 00");
				totalHourCountNum.setSize(totalHourCountNum.getPreferredSize());
				boxHourDisplay.setText("0" + term + " : 00");
				boxHourDisplay.setHorizontalAlignment(JLabel.CENTER);
			} else if (term < 23 && term > 8) {
				++term;
				System.out.println("b  : " + term);
				totalHourCountNum.setText(term + " : 00");
				totalHourCountNum.setSize(totalHourCountNum.getPreferredSize());
				boxHourDisplay.setText(term + " : 00");
				boxHourDisplay.setHorizontalAlignment(JLabel.CENTER);
			}
		}
		if(e.getSource() == countDownBtn) {
			if (term < 9 && term > 1) {

				--term;
				System.out.println("c  : " + term);
				totalHourCountNum.setText("0" + term + " : 00");
				totalHourCountNum.setSize(totalHourCountNum.getPreferredSize());
				boxHourDisplay.setText("0" + term + " : 00");
				boxHourDisplay.setHorizontalAlignment(JLabel.CENTER);
			} else if (term < 24 && term > 8) {

				--term;
				System.out.println("d  : " + term);
				totalHourCountNum.setText(term + " : 00");
				totalHourCountNum.setSize(totalHourCountNum.getPreferredSize());
				boxHourDisplay.setText(term + " : 00");
				boxHourDisplay.setHorizontalAlignment(JLabel.CENTER);
			}
		}

		//기간권값 변경 엑션
		if(e.getSource() == timeUpBtn) {
			if (weekTerm < 28) {

				weekTerm += 7;
				System.out.println(weekTerm);
				totalweekCountNum.setText(weekTerm + "일");
				totalweekCountNum.setSize(totalHourCountNum.getPreferredSize());
				boxWeekDisplay.setText(weekTerm + "일");	
				boxWeekDisplay.setHorizontalAlignment(JLabel.CENTER);

			} 
		}
		if(e.getSource() == timeDownBtn) {
			if (weekTerm > 7) {

				weekTerm -= 7;
				System.out.println(weekTerm);
				totalweekCountNum.setText(weekTerm + "일");
				totalweekCountNum.setSize(totalHourCountNum.getPreferredSize());
				boxWeekDisplay.setText(weekTerm + "일");	
				boxWeekDisplay.setHorizontalAlignment(JLabel.CENTER);

			} 
		}

		//취소버튼
		if(e.getSource() == cancelBtn) {
//			cp.removePanel2(mf, this, op2);
			
			cp.reSeatPanel(mf, this, op2, new AdmSeatTable(mf, this, client, phoneNum, utList, "-", u));
		}

		//확인버튼
		if(e.getSource() == confirmBtn) {
			AdmManager ad = new AdmManager();
			//시간권과 기간권을 구분하여 confirm하기 
//			cp.changeTablePanel3(mf, this, op, op2, new AdmAllUserList(mf, new AdmManager().usingUserManager(), new AdmDao().admRead(), client));
			
			if(selectedKind.equals("1일권")) {
				client.sendUser(ad.enterSeatIndvTime(phoneNum, term, seatNum));
			}else if(selectedKind.equals("기간권")) {
				client.sendUser(ad.enterSeatIndvWeek(phoneNum, weekTerm, seatNum));
			}
			
			mf.remove(this);
			mf.remove(op2);
			
//			mf.remove(this);
			// 메인프레임, 현재 팝업 패널, 테이블 패널, 뒤에 깔린 팝업패널, 새로 생성할 테이블 패널

		}

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		AbstractButton ab = (AbstractButton)e.getItemSelectable();
		
		if(e.getStateChange() == ItemEvent.SELECTED) {
			if(ab.getText().equals("1일권")) {
				selectedKind = "1일권";
			}
			if(ab.getText().equals("기간권")) {
				selectedKind = "기간권";
			}
		}
		
	}

}