package com.kh.studyCafe.kosk.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.studyCafe.kosk.controller.KoskManager;
import com.kh.studyCafe.kosk.model.dao.KoskDao;
import com.kh.studyCafe.kosk.view.popup.KoskGroupPanel;
import com.kh.studyCafe.kosk.view.popup.KoskIndividualPanel;
import com.kh.studyCafe.kosk.view.popup.KoskIndividualPanel2;
import com.kh.studyCafe.kosk.view.popup.KoskTimeHourWeek;
import com.kh.studyCafe.model.vo.User;

public class KoskSeatTable extends JPanel implements MouseListener{

	public JButton[] iuser = new JButton[25]; //개인 좌석 버튼
	public JButton[] dfuser = new JButton[2]; //
	public JButton[] dsuser = new JButton[2];
	public JButton[] deuser = new JButton[1];
	boolean[] inds = new boolean[25];
	boolean[] grfs = new boolean[2];
	boolean[] grss = new boolean[2];
	boolean[] gres = new boolean[1];
	private JPanel panel = new JPanel();
	private KoskMainFrame  mf;
	User user2 = new User();
	private int num ; // 좌석 번호 가져오기
	String seatnum = null;
	private int onum;
	private String phnum;
	public KoskSeatTable(KoskMainFrame mf, String phnum,int onum) {
		this.mf = mf;
		this.phnum = phnum;
		this.onum = onum;
		int x = 5;
		int y = 152;
 
		KoskDao koskdao = new KoskDao();
		ArrayList<User> user = new ArrayList<User>();

		KoskIndividualPanel kip = new KoskIndividualPanel();
		KoskIndividualPanel2 kip2 = new KoskIndividualPanel2();
		KoskGroupPanel kgp = new KoskGroupPanel();
		String name = null;

		//===========   컬러 설정 ================
		Color wallPapers = new Color(239,234,222);
		Color textColor = new Color(127,118,104);


		Font siguptext = new Font("맑은 고딕",Font.BOLD,30);
		Font inputtext = new Font("맑은 고딕",Font.BOLD,25);
		Font checktext = new Font("맑은 고딕",Font.BOLD,14);
		Color paper = new Color(163, 152, 134);
		Color paper1 = new Color(255,255,255);
		//==============================


		// ========= 패널 배경 색 설정, 패널 사이즈 설정 ============

		panel.setBackground(new Color(239, 234, 222));
		panel.setSize(360, 640);
		panel.setLayout(null);

		Font font1 = new Font("맑은 고딕", Font.BOLD, 32);
		JLabel label = new JLabel("좌석표");
		label.setForeground(new Color(127, 118, 104));
		label.setFont(font1);
		label.setLocation(131, 50);
		label.setSize(200, 90);



		// =========== 상단 로고 이미지 설정 ==================
		Image image = new ImageIcon("imag/logo.png").getImage().getScaledInstance(26, 34, 0);
		JLabel imageLabel = new JLabel(new ImageIcon(image));
		imageLabel.setLocation(167, 12);
		imageLabel.setSize(26, 34);




		//=======  로그아웃 ===============

		// ================== 로그아웃 버튼 설정  =====================

		JButton logOut = new JButton("로그아웃");
		logOut.setBorderPainted(false);
		logOut.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		logOut.setForeground(new Color(163, 152, 134));
		logOut.setBackground(new Color(239, 234, 222));
		logOut.setLocation(11, 12);
		logOut.setSize(100, 27);




		//=========== 마이이지 ==============

		// ========== 마이페이지 버튼 설정 ===================

		JButton myPage = new JButton("마이페이지");
		myPage.setBorderPainted(false);
		myPage.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		myPage.setForeground(new Color(163, 152, 134));
		myPage.setBackground(new Color(239, 234, 222));
		myPage.setLocation(220, 12);
		myPage.setSize(140, 27);

		// ============== 마이페이지 버튼 누를 시 이벤트 ================




		// =============== 개인 좌석 버튼 설정 ===================
		for(int i = 0; i < iuser.length; i++) {
			String num = (i+1)+"";
			iuser[i] = new JButton(num);
			iuser[i].setBackground(Color.WHITE);
			iuser[i].setFont(new Font("맑은 고딕", Font.BOLD, 11));
			iuser[i].setForeground(new Color(163, 152, 134));
			iuser[i].setLocation(x,y);
			iuser[i].setSize(47,47);

			iuser[i].addMouseListener(this);


			x += 48;

			if((i+1) % 5 == 0 && i != 0) {
				if(i == 4 || i == 14) {
					y += 68;
				}else {
					y += 52;
				}
				x = 5;
			}

		}

		// ================= 4인실룸 버튼 설정 ==================
		for(int i = 0; i < 2; i++) {
			if(i == 0) {
				name = "4-A";
				y = 151; 
			} else {
				name = "4-B";
				y += 75;

			}
			dfuser[i] = new JButton(name);
			dfuser[i].setFont(new Font("맑은 고딕", Font.BOLD, 18));
			dfuser[i].setBackground(Color.WHITE);
			dfuser[i].setForeground(new Color(163, 152, 134));
			dfuser[i].setLocation(250, y);
			dfuser[i].setSize(90, 64);
			if(onum == 1) {
				dfuser[i].setEnabled(false);
			}
			dfuser[i].addMouseListener(this); 

		}	

		//================== 8인실룸 버튼 설정 =====================
		deuser[0] =new JButton("8-A");
		deuser[0].setFont(new Font("맑은 고딕", Font.BOLD, 18));
		deuser[0].setBackground(Color.WHITE);
		deuser[0].setForeground(new Color(163, 152, 134));
		deuser[0].setLocation(250, 302);
		deuser[0].setSize(90, 140);
		if(onum == 1) {
			deuser[0].setEnabled(false);
		}
		deuser[0].addMouseListener(this); 


		// =============== 6인실룸 버튼 설정 ======================
		for(int i = 0; i < 2; i++) {
			if(i == 0) {
				name = "6-A";
				y = 5;
			}else if(i == 1) {
				name = "6-B";
				y += 172;
			}

			dsuser[i] = new JButton(name);
			dsuser[i].setFont(new Font("맑은 고딕", Font.BOLD, 18));
			dsuser[i].setBackground(Color.WHITE);
			dsuser[i].setForeground(new Color(163, 152, 134));
			dsuser[i].setLocation(y, 458);
			dsuser[i].setSize(160 , 65);
			if(onum == 1) {
				dsuser[i].setEnabled(false);
			}
			dsuser[i].addMouseListener(this); 

		}

		//========  해당 좌석 정보를 읽어 좌석 색 칠하고 선택 불가능 ==========
		//====== 수정해야함  =====
		KoskManager kkm = new KoskManager();
		KoskDao kd = new KoskDao();
		int num2 = 0; 
		for(int i=0; i<kd.seatin().size();i++) {
			if((kd.seatin().get(i)).length() < 3) {
				if(Integer.parseInt(kd.seatin().get(i))<26) {
					num = Integer.parseInt(kd.seatin().get(i));
				}
			}else {
				if(kd.seatin().get(i).equals("4-A")) {
					num = 25;
				} else if(kd.seatin().get(i).equals("4-B")) {
					num = 26;
				} else if(kd.seatin().get(i).equals("6-A")) {
					num = 27;
				} else if(kd.seatin().get(i).equals("6-B")) {
					num = 28;
				}else {
					num = 29;
				}
			}

			if(num>0 && num<25) {
				iuser[num].setBackground(new Color(163, 152, 134));
				iuser[num].setForeground(Color.WHITE);
				iuser[num].setEnabled(false);
			} else {
				if(num == 25) {
					dfuser[0].setBackground(new Color(163, 152, 134));
					dfuser[0].setForeground(Color.WHITE);
					dfuser[0].setEnabled(false);
				} else if(num == 26) {
					dfuser[1].setBackground(new Color(163, 152, 134));
					dfuser[1].setForeground(Color.WHITE);
					dfuser[1].setEnabled(false);
				}else if(num == 27) {
					dsuser[0].setBackground(new Color(163, 152, 134));
					dsuser[0].setForeground(Color.WHITE);
					dsuser[0].setEnabled(false);
				}else if(num == 28) {
					dsuser[1].setBackground(new Color(163, 152, 134));
					dsuser[1].setForeground(Color.WHITE);
					dsuser[1].setEnabled(false);
				}else {
					deuser[0].setBackground(new Color(163, 152, 134));
					deuser[0].setForeground(Color.WHITE);
					deuser[0].setEnabled(false);
				}
				System.out.println("좌석 번호 : " + num);

			}

			panel.add(myPage);
			panel.add(logOut);
			panel.add(label);
			panel.add(imageLabel);

			for(int j=0; j<25;j++) {
				panel.add(iuser[j]);
			}
			for(int k=0; k<2; k++) {
				panel.add(dfuser[k]);
				panel.add(dsuser[k]);
			}
			panel.add(deuser[0]);
			mf.add(panel);



			//================================================




			logOut.addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					ChangePanel.changePanel(mf, panel, new KoskLogin(mf));
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub

				}
			});
			myPage.addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseClicked (MouseEvent e) {
					// TODO Auto-generated method stub

					ChangePanel.changePanel(mf,panel, new KoskMypage(mf,panel,phnum));

				}
			});
			Font font = new Font("맑은 고딕", Font.BOLD, 16);
			for(int u=0; u<25; u++) {
				iuser[u].addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub


						// ================= 좌석 선택시 좌석 색깔 변경 설정 =======================
						// 개인석

						for(int a = 0; a < inds.length; a++) {
							if(e.getSource() == iuser[a]) {
								if(inds[a] != true) {

									((JComponent) e.getSource()).setBackground(new Color(163, 152, 134));
									((JComponent) e.getSource()).setForeground(Color.WHITE);
									num = a;
									user2.setSeatNum(Integer.toString(a));
									seatnum = user2.getSeatNum();
									if(seatnum == null) {
									} else {
										for(int i = 0; i < inds.length; i++) {
											if(i == a) {
												inds[a] = false;
											} else {
												inds[i] = true;
												for(int f = 0; f < grfs.length; f++) {
													grfs[f] = true;
												}
												for(int s = 0; s < grss.length; s++) {
													grss[s] = true;
												}
												gres[0] = true;

											}

										}
										if(onum == 1) {
											for(int i=0; i<iuser.length; i++) {
												iuser[i].setEnabled(false);
											}
											for(int i=0; i<deuser.length; i++) {
												deuser[i].setEnabled(false);
											}
											for(int i=0; i<dfuser.length; i++) {
												dfuser[i].setEnabled(false);
												dsuser[i].setEnabled(false);
											}
										}

										System.out.println(seatnum+"좌석");
										KoskManager km = new KoskManager();
										JButton pre = new JButton("선택취소");
										pre.setFont(font);
										pre.setBackground(new Color(189, 177, 157));
										pre.setForeground(Color.WHITE);
										pre.setLocation(5, 531);
										pre.setSize(160 ,53);
										panel.add(pre);

										JButton confirm = new JButton("Confirm");
										confirm.setFont(font);
										confirm.setBackground(new Color(163, 152, 134));
										confirm.setForeground(Color.WHITE);
										confirm.setLocation(175, 531);
										confirm.setSize(160,53);
										//confirm.setVisible(b);

										panel.repaint();
										/*panel.add(pre);*/
										panel.add(confirm);
										//==== 개인좌석 선택 패널 =====
										JPanel thw = new JPanel();
										thw.setBounds(10, 100, 400, 250);
										thw.setBackground(wallPapers);
										thw.setLayout(null);
										KoskTimeHourWeek kth = new KoskTimeHourWeek();
										thw.add(kth.KoskTimeHourWeek(mf));

										//== 버튼============
										JButton thwcf = new JButton("1일권");
										thwcf.setFont(font);
										thwcf.setBounds(0, 70, 100, 68);
										thwcf.setBackground(paper);
										thwcf.setForeground(paper1);


										JButton thwcc = new JButton("기간권");
										thwcc.setFont(font);
										thwcc.setBounds(105, 70, 100, 68);
										thwcc.setBackground(paper);
										thwcc.setForeground(paper1);


										JButton rtime = new JButton("잔여시간");
										rtime.setFont(font);
										rtime.setBounds(210,70,100,68);
										rtime.setBackground(paper);
										rtime.setForeground(paper1);
										thw.add(thwcc,0); // 개인 기간권
										thw.add(thwcf,0); // 개인 1일권 버튼
										thw.add(rtime,0);
										panel.repaint();
										//===================================
										//=== 시간권 패널 ====================
										JPanel tmch = new JPanel();
										tmch.setBounds(20, 100, 300, 400);
										tmch.setLayout(null);

										//===============================
										//==== 시간권 패널 버튼 =============
										Image confirmimg = new ImageIcon("img/confirmbtnimg.png").getImage().getScaledInstance(117, 50, 0);
										JButton tmcfbtn = new JButton(new ImageIcon(confirmimg));
										tmcfbtn.setBounds(138, 280, 117, 50);

										Image cancelimg = new ImageIcon("img/Cancelbtnimg.png").getImage().getScaledInstance(117, 50, 0);
										JButton tmccbtn = new JButton(new ImageIcon(cancelimg));
										tmccbtn.setBounds(20, 280, 117, 50);

										tmch.add(tmcfbtn,0);
										tmch.add(tmccbtn,0);
										tmch.repaint();

										//============ 개인석 패널 ==========================
										//===== 개인석 1일권 cancel버튼 =======================
										tmccbtn.addActionListener(new ActionListener() {

											@Override
											public void actionPerformed(ActionEvent e) {
												// TODO Auto-generated method stub
												panel.remove(tmch);
												ChangePanel.changePanel(mf, panel, new KoskSeatTable(mf,phnum,num));
												panel.repaint();

											}
										});

										User user = new User();
										//===============================================
										//================================================
										//======== 1일권  버튼 confirm============================
										thwcf.addActionListener(new ActionListener() {

											@Override
											public void actionPerformed(ActionEvent e) {
												// TODO Auto-generated method stub
												user.setSeatType(0);
												panel.remove(thw);
												tmch.add(kip.KoskIndividualPanel(mf));
												panel.add(tmch,0);
												panel.repaint();

											}
										});
										//======== 개인 기간권 버튼 =========================
										thwcc.addActionListener(new ActionListener() {

											@Override
											public void actionPerformed(ActionEvent e) {
												// TODO Auto-generated method stub
												user.setSeatType(1);
												panel.remove(thw);
												tmch.add(kip2.KoskIndividualPanel2(mf));
												panel.add(tmch,0);     
												panel.repaint();
											}
										});

										tmcfbtn.addActionListener(new ActionListener() {

											@Override
											public void actionPerformed(ActionEvent e) {
												// TODO Auto-generated method stub
												panel.remove(tmch);
												mf.repaint();
												if(user.getSeatType()==0) {
													ChangePanel.changePanel(mf, panel, new KoskPayment(mf, panel, phnum, kip.indi(),seatnum,0));
													System.out.println("1일권 선택");
													System.out.println(kip.indi());
												} else if(user.getSeatType() == 1) {
													ChangePanel.changePanel(mf, panel, new KoskPayment(mf, panel, phnum, kip2.daytime(),seatnum,1));
													System.out.println(kip2.daytime());
													System.out.println("기간권 선택");
												}


											}
										});
										//=============================================

										//=============================================

										//===================================

										//====== 좌석 선택하면 나오는 confirm 버튼 이벤트 ===============
										confirm.addActionListener(new ActionListener() {

											@Override
											public void actionPerformed(ActionEvent e) {
												// TODO Auto-generated method stub
												kkm.seatss(user2.getSeatNum());
												System.out.println(kkm.seatim()+"불러옴");
												for(int i=0; i<iuser.length; i++) {
													iuser[i].setEnabled(false);
												}
												for(int i=0; i<deuser.length; i++) {
													deuser[i].setEnabled(false);
												}
												for(int i=0; i<dfuser.length; i++) {
													dfuser[i].setEnabled(false);
													dsuser[i].setEnabled(false);
												}
												if(onum == 1) {
													kd.Kosktimeplus(phnum,seatnum,num);
													ChangePanel.changePanel(mf, panel, new KoskSeatManagement(mf, panel, koskdao, phnum, phnum, onum));
												} else if(onum == 2) {
													panel.add(thw,0);
													mf.repaint();
												}
											}
										});
										//================================================
										//===== 좌석 선택하면 나오는 cancel버튼 액션 ================
										pre.addActionListener(new ActionListener() {

											@Override
											public void actionPerformed(ActionEvent e) {
												// TODO Auto-generated method stub

												ChangePanel.changePanel(mf, panel, new KoskSeatTable(mf,phnum,num));
											}
										});
										//==============================================
									}
								} 
							}

						}

					}
				});
			}
			// ============= group패널 ===============
			JPanel group = new JPanel();
			group.setBounds(25, 40, 300, 400);
			group.setLayout(null);
			group.setBackground(wallPapers);
			//======================================
			//=== group패널 버튼 =====================
			Image confirmimg = new ImageIcon("img/confirmbtnimg.png").getImage().getScaledInstance(117, 50, 0);
			JButton groupcf = new JButton(new ImageIcon(confirmimg));
			groupcf.setBounds(139,280,117,50);

			Image cancelimg = new ImageIcon("img/Cancelbtnimg.png").getImage().getScaledInstance(117, 50, 0);
			JButton groupcc = new JButton(new ImageIcon(cancelimg));
			groupcc.setBounds(20, 280, 117, 50);

			group.add(groupcf);
			group.add(groupcc);



			//==== (단체석)그룹 패널 cancel버튼  액션 ===================
			groupcc.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					panel.remove(group);
					panel.repaint();
				}
			});
			//=============================================
			//==== (단체석)그룹 confirm 버튼 액션 =======================
			groupcf.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					panel.remove(group);
					ChangePanel.changePanel(mf, panel, new KoskPayment(mf, panel, phnum, kgp.gptm(),seatnum, 0));
					// 단체 
					System.out.println("단체석 누름");
					System.out.println(kgp.gptm());
				}
			});
			//=====================================================

			//4인실
			for(int f=0; f<2; f++) {
				dfuser[f].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						for(int b = 0; b < grfs.length; b++) {
							if(e.getSource() == dfuser[b]) {
								if(grfs[b] != true) {
									((JComponent) e.getSource()).setBackground(new Color(163, 152, 134));
									((JComponent) e.getSource()).setForeground(Color.WHITE);
									if(b == 0) {
										seatnum = "25";
									} else {
										seatnum = "26";
									} 
									user2.setSeatNum((seatnum));
									if(seatnum == null) {
									} else {
										for(int i = 0; i < inds.length; i++) {
											if(i == b) {
												grfs[b] = false;
											} else {

												grfs[i] = true;
												for( i = 0; i < inds.length; i++) {
													inds[i] = true;
												}
												for(int s = 0; s < grss.length; s++) {
													grss[s] = true;
													gres[0] = true;
												}
											}
										}
										System.out.println(seatnum+"좌석");
										KoskManager km = new KoskManager();
										JButton pre = new JButton("선택취소");
										pre.setFont(font);
										pre.setBackground(new Color(189, 177, 157));
										pre.setForeground(Color.WHITE);
										pre.setLocation(5, 531);
										pre.setSize(160 ,53);
										//panel.add(pre);

										JButton confirm = new JButton("Confirm");
										confirm.setFont(font);
										confirm.setBackground(new Color(163, 152, 134));
										confirm.setForeground(Color.WHITE);
										confirm.setLocation(175, 531);
										confirm.setSize(160,53);
										//confirm.setVisible(b);

										panel.repaint();
										panel.add(pre);
										panel.add(confirm);


										confirm.addActionListener(new ActionListener() {

											@Override
											public void actionPerformed(ActionEvent e) {
												// TODO Auto-generated method stub
												for(int i=0; i<iuser.length; i++) {
													iuser[i].setEnabled(false);
												}
												for(int i=0; i<deuser.length; i++) {
													deuser[i].setEnabled(false);
												}
												for(int i=0; i<dfuser.length; i++) {
													dfuser[i].setEnabled(false);
													dsuser[0].setEnabled(false);
												}
												System.out.println(kkm.seatim()+"불러옴");


												group.add(kgp.KoskGroupPanel(mf,seatnum));
												panel.add(group,0);
												panel.repaint();

											}
										});
										pre.addActionListener(new ActionListener() {

											@Override
											public void actionPerformed(ActionEvent e) {
												// TODO Auto-generated method stub
												ChangePanel.changePanel(mf, panel, new KoskSeatTable(mf,phnum,num));
											}
										});
									}
								}

							}
						}
					}
				});
			}
			//6인석
			for(int s=0; s<2; s++) {
				dsuser[s].addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						for(int c = 0; c < grss.length; c++) {
							if(e.getSource() == dsuser[c]) {
								if(grss[c] != true) {
									((JComponent) e.getSource()).setBackground(new Color(163, 152, 134));
									((JComponent) e.getSource()).setForeground(Color.WHITE);
									String seatnum;
									if(c == 0) {
										seatnum = "27";
									} else {
										seatnum = "28";
									} if(seatnum == null) {
									} else {
										for(int i = 0; i < inds.length; i++) {
											if(i == c) {
												grss[c] = false;
											} else {
												grss[i] = true;
												for( i = 0; i < inds.length; i++) {
													inds[i] = true;
												}
												for(int f = 0; f < grfs.length; f++) {
													grfs[f] = true;
													gres[0] = true;
												}
											}
										}
										user2.setSeatNum((seatnum));
										System.out.println(seatnum+"좌석");
										KoskManager km = new KoskManager();
										JButton pre = new JButton("선택취소");
										pre.setFont(font);
										pre.setBackground(new Color(189, 177, 157));
										pre.setForeground(Color.WHITE);
										pre.setLocation(5, 531);
										pre.setSize(160 ,53);
										panel.add(pre);

										JButton confirm = new JButton("Confirm");
										confirm.setFont(font);
										confirm.setBackground(new Color(163, 152, 134));
										confirm.setForeground(Color.WHITE);
										confirm.setLocation(175, 531);
										confirm.setSize(160,53);
										//confirm.setVisible(b);

										panel.repaint();
										panel.add(pre);
										panel.add(confirm);


										confirm.addActionListener(new ActionListener() {

											@Override
											public void actionPerformed(ActionEvent e) {
												// TODO Auto-generated method stub

												//	kkm.seatsv(user2.getSeatNum());

												for(int i=0; i<iuser.length; i++) {
													iuser[i].setEnabled(false);
												}
												for(int i=0; i<deuser.length; i++) {
													deuser[i].setEnabled(false);
												}
												for(int i=0; i<dfuser.length; i++) {
													dfuser[i].setEnabled(false);
													dsuser[0].setEnabled(false);
												}
												group.add(kgp.KoskGroupPanel(mf,seatnum));
												panel.add(group,0);
												panel.repaint();

											}
										});
										pre.addActionListener(new ActionListener() {

											@Override
											public void actionPerformed(ActionEvent e) {
												// TODO Auto-generated method stub
												ChangePanel.changePanel(mf, panel, new KoskSeatTable(mf,phnum,num));
											}
										});

									}

								}
							}
						}
					}
				});
			}
			deuser[0].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub

					for(int d = 0; d < gres.length; d++) {
						if(e.getSource() == deuser[d]) { 
							if(gres[d] != true) {
								((JComponent) e.getSource()).setBackground(new Color(163, 152, 134));
								((JComponent) e.getSource()).setForeground(Color.WHITE);

								seatnum = "29";
								if(seatnum == null) {
								} else {
									gres[0] = true;
									for(int i = 0; i < inds.length; i++) {
										inds[i] = true;
									}
									for(int f = 0; f < grfs.length; f++) {
										grfs[f] = true;
									}
									for(int s = 0; s < grss.length; s++) {
										grss[s] = true;
									}
								}
								user2.setSeatNum((seatnum));
								System.out.println(seatnum+"좌석");
								KoskManager km = new KoskManager();
								JButton pre = new JButton("선택취소");
								pre.setFont(font);
								pre.setBackground(new Color(189, 177, 157));
								pre.setForeground(Color.WHITE);
								pre.setLocation(5, 531);
								pre.setSize(160 ,53);
								panel.add(pre);
								JButton confirm = new JButton("Confirm");
								confirm.setFont(font);
								confirm.setBackground(new Color(163, 152, 134));
								confirm.setForeground(Color.WHITE);
								confirm.setLocation(175, 531);
								confirm.setSize(160,53);
								panel.repaint();
								panel.add(pre);
								panel.add(confirm);
								confirm.addActionListener(new ActionListener() {
									@Override
									public void actionPerformed(ActionEvent e) {

										for(int i=0; i<iuser.length; i++) {
											iuser[i].setEnabled(false);
										}
										for(int i=0; i<deuser.length; i++) {
											deuser[i].setEnabled(false);
										}
										for(int i=0; i<dfuser.length; i++) {
											dfuser[i].setEnabled(false);
											dsuser[0].setEnabled(false);
										}
										group.add(kgp.KoskGroupPanel(mf,seatnum));
										panel.add(group,0);
										panel.repaint();
									}
								});
								pre.addActionListener(new ActionListener() {
									@Override
									public void actionPerformed(ActionEvent e) {
										// TODO Auto-generated method stub
										ChangePanel.changePanel(mf, panel, new KoskSeatTable(mf,phnum,num));
									}
								});
							}
						}
					}
				}
			});
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
	@Override
	public void mousePressed(MouseEvent e) {
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}
}





