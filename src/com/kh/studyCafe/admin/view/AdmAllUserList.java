package com.kh.studyCafe.admin.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractCellEditor;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class AdmAllUserList extends JPanel implements ActionListener {


	public AdmAllUserList(AdmMainFrame mf) {

		//테이블 헤더 목록
		String[] columnNames = {"No", "회원명", "전화번호", "좌석번호", "입실시간", "퇴실예정시간", "잔여시간", "개인/단체", "좌석관리","좌석관리","좌석관리","좌석관리" };

		//테이블 내용
		Object[][] data = {
				{1, "서범수", "010-9876-6543", "12번", "02:30AM", "-", "25일", "개인", "연장","이동","퇴실","입실"},
				{2, "조문정", "010-2222-3333", "4-B룸", "09:30AM", "11:30AM", "02:00", "단체", "연장","이동","퇴실","입실"},
				{3, "허현주", "010-4321-1234", "23번", "08:10AM", "12:10PM", "03:00", "개인", "연장","이동","퇴실","입실"},
				{4, "김진호", "010-5050-5858", "14번", "-", "-", "10일", "개인", "연장","이동","퇴실","입실"},
				{1, "문호승", "010-7895-5555", "-", "-", "-", "-", "-", "연장","이동","퇴실","입실"},
				{2, "안동환", "010-1111-1111", "-", "-", "-", "-", "-", "연장","이동","퇴실","입실"},
				{3, "이범희", "010-5656-4545", "-", "-", "-", "-", "-", "연장","이동","퇴실","입실"}
		};

		//this.은 panel 설정
		this.setBounds(0, 0, 978, 700);

		//테이블 모델만들기
		//버튼부분빼고 셀의 내용 수정불가하도록 설정
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
		//이용중인 회원일 경우 셀의 색을 바꾸어서 표시함
		//버튼 부분은 백그라운드 색으로 흰색으로 칠하여 없는것처럼 보이게 해놓았으나 수정이필요함
		JTable table = new JTable(model) {
			@Override
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				if(row <= 2) {
					JComponent component = (JComponent) super.prepareRenderer(renderer, row, column);
					component.setBackground(new Color(239, 234, 222));
					if(column >= 8) {
						component.setBackground(new Color(127, 118, 104));
					}
					return component;
				}else {
					JComponent component = (JComponent) super.prepareRenderer(renderer, row, column);
					component.setBackground(Color.WHITE);
					if(column == 11) {
						component.setBackground(new Color(127, 118, 104));
					}
					return component;
				}
				
			}
		};

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

		table.getColumnModel().getColumn(0).setPreferredWidth(36);
		table.getColumnModel().getColumn(1).setPreferredWidth(63);
		table.getColumnModel().getColumn(2).setPreferredWidth(110);
		table.getColumnModel().getColumn(3).setPreferredWidth(74);
		table.getColumnModel().getColumn(4).setPreferredWidth(82);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		table.getColumnModel().getColumn(6).setPreferredWidth(73);
		table.getColumnModel().getColumn(7).setPreferredWidth(83);
		table.getColumnModel().getColumn(8).setPreferredWidth(68);
		table.getColumnModel().getColumn(9).setPreferredWidth(68);
		table.getColumnModel().getColumn(10).setPreferredWidth(68);
		table.getColumnModel().getColumn(11).setPreferredWidth(68);

		//테이블 스크롤 기능 추가해서 넣기
		JScrollPane scrollpane = new JScrollPane(table);

		//전체 테이블 크기설정
		scrollpane.setPreferredSize(new Dimension(920, 504));
		//테이블 모양 설정rgb(239, 234, 222)
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


		//전체 회원보기 버튼생성
		JButton allUserInfoButton = new JButton("이용 중인 회원 보기");
		allUserInfoButton.setBounds(780, 70, 160, 42);
		allUserInfoButton.setBackground(new Color(189,177,157));
		allUserInfoButton.setForeground(Color.WHITE);
		allUserInfoButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		allUserInfoButton.setBorder(BorderFactory.createLineBorder(new Color(189,177,157)));
		
		
		//테이블의 크기를 조절하지 못하도록 함
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		
		//테이블 연장 / 이동 / 퇴실 열에 버튼을 생성함
		table.getColumnModel().getColumn(8).setCellRenderer(new AddTime(mf,this,table));
		table.getColumnModel().getColumn(8).setCellEditor(new AddTime(mf,this,table));

		table.getColumnModel().getColumn(9).setCellRenderer(new SeatMove());
		table.getColumnModel().getColumn(9).setCellEditor(new SeatMove());

		table.getColumnModel().getColumn(10).setCellRenderer(new ExitSeat());
		table.getColumnModel().getColumn(10).setCellEditor(new ExitSeat());

		table.getColumnModel().getColumn(11).setCellRenderer(new EnterSeat());
		table.getColumnModel().getColumn(11).setCellEditor(new EnterSeat());

		
		//회원검색용 텍스트 필드 생성
		JTextField searchForm = new JTextField();
		searchForm.setBounds(59, 74, 178, 40);
		searchForm.setBorder(BorderFactory.createLineBorder(new Color(127,118,104)));

		//회원검색용 이미지 파일 불러오기
		Image icon2 = new ImageIcon("img/search.PNG").getImage().getScaledInstance(32, 39, 0);
		JLabel searchLabel = new JLabel(new ImageIcon(icon2));
		searchLabel.setLocation(23, 75);
		searchLabel.setSize(32, 39);

		//패널에 추가하기
		this.add(searchForm);
		this.add(searchLabel);
		this.add(logoLabel);
		this.add(allUserInfoButton);
		this.add(scrollpane);
	}



	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}

//입실 버튼을 만들때 필요한 클래스
class EnterSeat extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
	JButton jb;

	public EnterSeat() {

		jb = new JButton("입실");
		jb.setForeground(Color.WHITE);
		jb.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		jb.setBackground(new Color(127, 118, 104));

		jb.addActionListener(e -> {
			jb.setBackground(Color.WHITE);
			jb.setForeground(new Color(127, 118, 104));
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