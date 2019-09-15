package com.kh.studyCafe.admin.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
//import org.jdesktop.swingx.prompt.PromptSupport;

import com.kh.studyCafe.admin.controller.AdmManager;
import com.kh.studyCafe.admin.model.dao.AdmDao;
import com.kh.studyCafe.client.ClientBack;

public class AdmLoginMain extends MouseAdapter implements ActionListener{ // MouseAdapter는 예시이고, 필요한 이벤트에다 ControlPanel 선언해주면 됩니다.
	private JPanel login = new JPanel();
	private AdmMainFrame mf;
	private JTextField loginTextField;
	private JPasswordField passwordField;
	private JButton loginBtn;
	private int resultId;
	private int resultPw;
	private ClientBack client;
	
	private ControlPanel cp = new ControlPanel();
	
	public AdmLoginMain(AdmMainFrame mf, ClientBack client) {
		this.mf = mf;
		this.client = client;
		AdmMainFrame.watchPanel = login;
		
		login.setLayout(null);
		login.setSize(978, 700);
		login.setBackground(Color.WHITE);
		
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 978, 700);
        layeredPane.setLayout(null);
        
		// 메인 로고 텍스트 영역
		JLabel logoTxt = new JLabel("<html><body><p>스터디카페 다니고<br>나의 성공시대<br>시작됐다</p></body></html>");
		
		logoTxt.setLocation(250, 130);
		logoTxt.setForeground(new Color(127, 118, 104));
		logoTxt.setFont(new Font("맑은 고딕", Font.BOLD, 53));
		logoTxt.setSize(logoTxt.getPreferredSize());
		
		// 버전 안내 텍스트 영역
		JLabel versionTxt = new JLabel("관리자용 version");
		versionTxt.setLocation(457, 358);
		versionTxt.setForeground(new Color(127, 118, 104));
		versionTxt.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		versionTxt.setSize(versionTxt.getPreferredSize());
		
		// ID 영역
		loginTextField = new JTextField(" ID");
		loginTextField.setBounds(340, 380, 207, 40);
		loginTextField.setBackground(Color.WHITE);
		loginTextField.setBorder(BorderFactory.createLineBorder(new Color(189, 177, 157)));
		loginTextField.setEnabled(false);
		loginTextField.addMouseListener(this); 
		
		// PassWord 영역
		passwordField = new JPasswordField(" PASSWORD");
		passwordField.setBounds(340, 425, 207, 40);
		passwordField.setBackground(Color.WHITE);
		passwordField.setBorder(BorderFactory.createLineBorder(new Color(189, 177, 157)));
		passwordField.setEnabled(false);
		passwordField.addMouseListener(this); 
		
		// Login button 영역
		loginBtn = new JButton("Login");
		loginBtn.setBounds(340, 475, 207, 40);
		loginBtn.setBackground(new Color(189, 177, 157));
		loginBtn.setForeground(Color.WHITE);
		loginBtn.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		loginBtn.setBorder(BorderFactory.createLineBorder(new Color(189, 177, 157)));
		loginBtn.addMouseListener(this); 
		
		layeredPane.add(loginTextField);
		layeredPane.add(passwordField);
		layeredPane.add(loginBtn);

		login.add(logoTxt);
		login.add(versionTxt);
		login.add(layeredPane);
		login.addMouseListener(this);
		
		mf.add(login);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		
		if(e.getSource() == loginBtn) {
			AdmManager am = new AdmManager();
			String id = loginTextField.getText().trim();
			char[]pwdArr =passwordField.getPassword();
			String pwd ="";
			
			for(int i=0;i<pwdArr.length;i++) {
				pwd+=pwdArr[i];
			}
			
			boolean result =am.logpass(id, pwd);
			if(result == true) { // 로그인 성공
				cp.changeTablePanel(mf, login, new AdmUsingUserList(mf, am.usingUserManager(), new AdmDao().admRead(), client));
			}else { // 로그인 실패
				cp.addPanel(mf, login, new AdmLoginFail(mf, login, client));
			}
		}
		
		if(e.getSource() == loginTextField) {
			if(resultId == 0) {
				loginTextField.setText("");
				loginTextField.setEnabled(true);
				loginTextField.requestFocus();
				
				resultId++;
			}
		}

		if(e.getSource() == passwordField) {
			if(resultPw == 0) {
				passwordField.setText("");
				passwordField.setEnabled(true);
				passwordField.requestFocus();
				
				resultPw++;
			}
		}
		
	}
	
}
