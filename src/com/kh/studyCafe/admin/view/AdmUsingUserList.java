package com.kh.studyCafe.admin.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.AbstractCellEditor;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import com.kh.studyCafe.admin.controller.AdmManager;
import com.kh.studyCafe.admin.model.dao.AdmDao;
import com.kh.studyCafe.admin.model.vo.AdmUserTable;
import com.kh.studyCafe.client.ClientBack;
import com.kh.studyCafe.model.vo.User;

public class AdmUsingUserList extends JPanel implements ActionListener {
	private JButton allUserInfoButton = null;
	private AdmMainFrame mf;
	private ClientBack client;
	
	public AdmUsingUserList(AdmMainFrame mf, ArrayList<AdmUserTable> utList, ArrayList<User> u, ClientBack client) {
		this.mf = mf;
		this.client = client;
		AdmMainFrame.watchPanel = this;
		
		//테이블 헤더 목록
		String[] columnNames = {"No", "회원명", "전화번호", "좌석번호", "입실시간", "퇴실예정시간", "잔여시간", "개인/단체", "좌석연장", "좌석이동", "좌석퇴장"};
		
		//테이블 내용 부분 크기
		Object[][] data = new Object[utList.size()][columnNames.length];
		
		// 개인석, 단체석 개수 변수
		int grpCount = 0;
		int indvCount= 0;
		for (int i = 0; i < u.size(); i++) {
			// 개인석, 단체석 개수 표시
			if(!u.get(i).getSeatNum().equals("0")) {
				if(u.get(i).getSeatNum().contains("-")) { // 그룹일 때
					grpCount++;
				}else {
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
			
			// 입실시간, 퇴실시간 테이블에 뿌리기
			data[i][4] = timeEdit[0].split("일 ")[1];
			data[i][5] = timeEdit[1].split("일 ")[1];
			
			// 잔여시간 형식 수정해서 테이블에 뿌리기
			if(utList.get(i).getSeatType() == 2) { // 기간권일 때
				data[i][6] = utList.get(i).getRemainTime() / 86400000 + "일"; 
			}else if(utList.get(i).getSeatType() == 1){ // 1일권일 때
				// 밀리세컨드를 시간 분으로 표시하기 위해 변 
				String timeResult = "";
				
				timeResult += utList.get(i).getRemainTime() / 3600000 + "시간 ";
				timeResult += utList.get(i).getRemainTime() % 3600000 / 60000 + "분";
						
				data[i][6] = timeResult;
			}
			
			// 오전, 오후를 AM, PM으로 변경
			for (int j = 0; j < 2; j++) {
				if(timeEdit[j].split("일 ")[1].substring(7).equals("오전")) {
					
					data[i][4+j] = timeEdit[j].split("일 ")[1].substring(0, 7) + " AM";
				}else {					
					data[i][4+j] = timeEdit[j].split("일 ")[1].substring(0, 7) + " PM";
				}
					
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
		
		
			
		//this.은 panel 설정
		this.setBounds(0, 0, 978, 700);
		
		//테이블 모델만들기
		DefaultTableModel model = new DefaultTableModel(data,columnNames) {
			public boolean isCellEditable(int row, int column){
				if(column >= 8) {
					return true;
				}
			    return false;
			 }
		};
		this.setLayout(null);
		this.setBackground(Color.WHITE);
		//테이블 생성
		JTable table = new JTable(model);
		
		//이미지 파일 불러오기
		Image icon = new ImageIcon("img/logo.png").getImage().getScaledInstance(41, 54, 0);
		JLabel logoLabel = new JLabel(new ImageIcon(icon));
		logoLabel.setLocation(470, 35);
		logoLabel.setSize(41, 54);
		JTableHeader header = table.getTableHeader();

		//테이블 헤더 크기설정		
		header.setPreferredSize(new Dimension(10, 50));
		
		//테이블 행 높이 설정
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
		
		//테이블 스크롤 기능 추가해서 넣기
		JScrollPane scrollpane = new JScrollPane(table);
		
		//전체 테이블 크기설정
		scrollpane.setPreferredSize(new Dimension(920, 504));
		//테이블 모양 설정
		scrollpane.setBounds(21, 118, 920, 504);
		scrollpane.getViewport().setBackground(Color.WHITE); 
		scrollpane.setBackground(Color.WHITE);
		scrollpane.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		table.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createCompoundBorder(), BorderFactory.createMatteBorder(0,1,1,1,new Color(127,118,104))));
		table.setGridColor(new Color(127,118,104));
		table.setForeground(new Color(127, 118, 104)); 		
		table.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		//테이블 헤더 설정
		header.setBorder(BorderFactory.createLineBorder(new Color(127,118,104)));
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
		
		//매장정보보기 버튼 생성
		JButton cafeInfo = new JButton("매장 정보 보기");
		cafeInfo.setBounds(801, 603, 140, 42);
		cafeInfo.setBackground(new Color(189,177,157));
		cafeInfo.setForeground(Color.WHITE);
		cafeInfo.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		cafeInfo.setBorder(BorderFactory.createLineBorder(new Color(189,177,157)));
		
		//전체 회원보기 버튼생성
		allUserInfoButton = new JButton("전체 회원 보기");
		allUserInfoButton.setBounds(801, 70, 140, 42);
		allUserInfoButton.setBackground(Color.WHITE);
		allUserInfoButton.setForeground(new Color(189,177,157));
		allUserInfoButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		allUserInfoButton.setBorder(BorderFactory.createLineBorder(new Color(189,177,157)));
		allUserInfoButton.addActionListener(this);
		
		//사용중인 단체석보는 라벨생성
		JLabel usingSeatGrp = new JLabel("단체석    / 5");
		usingSeatGrp.setLocation(23, 83);
		usingSeatGrp.setForeground(new Color(127, 118, 104));
		usingSeatGrp.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		usingSeatGrp.setSize(usingSeatGrp.getPreferredSize());
		
		//사용중인 개인석보는 라벨 생성
		JLabel usingSeat = new JLabel("개인석    / 25");
		usingSeat.setLocation(23, 98);
		usingSeat.setForeground(new Color(127, 118, 104));
		usingSeat.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		usingSeat.setSize(usingSeat.getPreferredSize());
		
		//사용중인 단체석 표시할 라벨(수정해야함)
		JLabel usingInfoGrp = new JLabel(grpCount + "");
		usingInfoGrp.setLocation(63, 83);
		usingInfoGrp.setForeground(new Color(127, 118, 104));
		usingInfoGrp.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		usingInfoGrp.setSize(usingInfoGrp.getPreferredSize());
		
		//사용중인 개인석 표시할 라벨(수정해야함)
		JLabel usingInfo = new JLabel(indvCount + "");
		usingInfo.setLocation(63, 98);
		usingInfo.setForeground(new Color(127, 118, 104));
		usingInfo.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		usingInfo.setSize(usingInfo.getPreferredSize());
		
		//테이블 내용 수정못하도록 바꿈
		//table.setEnabled(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		
		table.getColumnModel().getColumn(8).setCellRenderer(new AddTime(mf,this,table, client));
        table.getColumnModel().getColumn(8).setCellEditor(new AddTime(mf,this,table, client));
     
        
        table.getColumnModel().getColumn(9).setCellRenderer(new SeatMove(mf,this,table));
        table.getColumnModel().getColumn(9).setCellEditor(new SeatMove(mf,this,table));
		
        table.getColumnModel().getColumn(10).setCellRenderer(new ExitSeat(mf,this,table));
        table.getColumnModel().getColumn(10).setCellEditor(new ExitSeat(mf,this,table));
		
        
		
		//패널에 추가하기
		this.add(logoLabel);
		this.add(usingInfo);
		this.add(usingInfoGrp);
		this.add(usingSeat);
		this.add(usingSeatGrp);
		this.add(allUserInfoButton);
		this.add(cafeInfo);
		this.add(scrollpane);
		
	}
	
	public void watchPaint() {
		new AdmUsingUserList(mf, new AdmManager().usingUserManager(), new AdmDao().admRead(), client);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// 전체회원보기 버튼 클릭 시 패널 변경
		if(e.getSource() == allUserInfoButton) {
			ControlPanel cp = new ControlPanel();
			
			cp.changeTablePanel(mf, this, new AdmAllUserList(mf, client));
			
		}
		
	}
	
}
//연장 버튼을 만들때 필요한 클래스
class AddTime extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
    private JButton jb;
    
    public AddTime(AdmMainFrame mf,JPanel op,JTable table, ClientBack client) {
        jb = new JButton("연장");
        jb.setForeground(Color.WHITE);
		jb.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        jb.setBackground(new Color(127, 118, 104));
        
        //클릭시 팝업 
        jb.addActionListener(e -> {
        	jb.setBackground(Color.WHITE);
        	jb.setForeground(new Color(127, 118, 104));
        	int row = table.getSelectedRow();
        	String tablePhone = table.getValueAt(row, 2) + "";
        	String seatTimeType = table.getValueAt(row, 6) + "";
        	
        	// 회원에 따라 연장 버튼 연결 구분
        	if(table.getValueAt(row, 7).equals("개인")) { // 개인일 때
        		if(seatTimeType.contains("일")) { // 기간권일 때
            		new ControlPanel().addPanel(mf, op, new AdmAddTimeWeek(mf, op, tablePhone, client));
        		}else { // 1일권일 떄
            		new ControlPanel().addPanel(mf, op, new AdmAddTimeHour(mf, op, tablePhone, client));
        		}
        		
        	}else { // 그룹일 때
        		new ControlPanel().addPanel(mf, op, new AdmAddTimeHour(mf, op, tablePhone, client));
        	}
        	
        });
    }
    
    @Override
    public Object getCellEditorValue() {
        return null;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {
        return jb;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
            int column) {
        return jb;
    }
}
//자리이동을 할때 필요한 버튼을 만드는 클래스
class SeatMove extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
    private JButton jb;

    public SeatMove(AdmMainFrame mf,JPanel op,JTable table) {
        jb = new JButton("이동");
        jb.setForeground(Color.WHITE);
		jb.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        jb.setBackground(new Color(127, 118, 104));
        
        jb.addActionListener(e -> {
        	jb.setBackground(Color.WHITE);
        	jb.setForeground(new Color(127, 118, 104));
        	

        	int row = table.getSelectedRow();
        	
        	// 회원에 따라 이동 버튼 연결 구분
        	if(table.getValueAt(row, 7).equals("개인")) { // 개인일 때
        		new ControlPanel().addPanel(mf, op, new AdmSeatTable(mf, op));
        	}else { // 그룹일 때
        		new ControlPanel().addPanel(mf, op, new AdmMoveGrp(mf, op));
        	}
        	
        });
    }

    @Override
    public Object getCellEditorValue() {
        return null;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {
        return jb;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
            int column) {
        return jb;
    }
} 

//퇴실을 할때 필요한 버튼을 만드는 클래스
class ExitSeat extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
    private JButton jb;

    public ExitSeat(AdmMainFrame mf,JPanel op,JTable table) {
        jb = new JButton("퇴장");
        jb.setForeground(Color.WHITE);
		jb.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        jb.setBackground(new Color(127, 118, 104));
        
        jb.addActionListener(e -> {
        	jb.setBackground(Color.WHITE);
        	jb.setForeground(new Color(127, 118, 104));
        	

        	int row = table.getSelectedRow();
        	String seatTimeType = table.getValueAt(row, 6) + "";
        	
        	// 회원에 따라 퇴실 버튼 연결 구분
    		if(seatTimeType.contains("일")) { // 기간권일 때
        		new ControlPanel().addPanel(mf, op, new AdmExitTimeWeek(mf, op));
    		}else { // 1일권일 떄
        		new ControlPanel().addPanel(mf, op, new AdmExitTimeHour(mf, op));
    		}
        		
        	
        });
    }

    @Override
    public Object getCellEditorValue() {
        return null;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {
        return jb;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
            int column) {
        return jb;
    }
    
    
} 




