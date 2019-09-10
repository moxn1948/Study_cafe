package com.kh.studyCafe.kosk.controller;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import com.kh.studyCafe.admin.model.service.AdmUserInfoChk;
import com.kh.studyCafe.admin.model.vo.AdmUserTable;
import com.kh.studyCafe.kosk.model.dao.KoskDao;
import com.kh.studyCafe.kosk.view.popup.KoskPasswordDoNot;
import com.kh.studyCafe.model.service.SignUpService;
import com.kh.studyCafe.model.vo.User;

public class KoskManager {
	public KoskManager() {}
	
	private KoskDao kd = new KoskDao();
	
	
	public ArrayList<User> moveSeatNum(String phoneNum, String seatNum) {
		return kd.KoskLineSeat(phoneNum, seatNum);
		
	}
	
	
	
	public boolean KoskSgin (ArrayList number2) { // KoskSignUp에서 정보를 받아옴
	      Iterator it = number2.iterator();
	      
	      String[] value = new String[4];// 0번부터 3번까지 순서대로 정보를 value에 저장함
	      int i =0;
	      while(it.hasNext()) {
	         value[i] =(String)it.next();
	         i++;
	      }
	      SignUpService ss = new SignUpService();
	      ss.signupservice(value);
	         BufferedWriter bw = null;
	         if(ss.signupservice(value)== true) {
	            
	            try {
	               bw = new BufferedWriter(new FileWriter("user.dat",true));
	               bw.write(value[0]+"/");
	               bw.write(value[1]+"/");
	               bw.write(value[2]+"/");// 파일 입력하는 부분
	               bw.write(value[3]+"\r\n");
	               
	            } catch (IOException e) {
	               
	               e.printStackTrace();
	            } finally {
	               try {
	                  bw.close();
	               } catch (IOException e) {
	                  
	               }
	            }
	         }
	         return ss.signupservice(value);
	         
	      }
	public void seatManger(String seatnum) {
		BufferedWriter bw = null;
		BufferedReader br = null;
			
					try {
						br = new BufferedReader(new FileReader("userlist.txt"));
						
						bw = new BufferedWriter(new FileWriter("userlist.txt",true)); 
						//bw.write(seatnum+"\n");
						String str = null;
						str = br.readLine();
						if(str == null) {
							bw.write(seatnum);
						} else {
							bw.write("\n"+seatnum);
						}
						
						
							bw.flush();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		
		System.out.println(seatnum+"번 좌석 Manager로 이동완료");
		
	}
	private String num ;
	
	
	public void seatsv(String seatnum) {
		BufferedWriter bw = null;
		BufferedReader br = null;
		
					try {
						br = new BufferedReader(new FileReader("userlist.txt"));
						
						bw = new BufferedWriter(new FileWriter("userlist.txt",true)); 
						//bw.write(seatnum+"\n");
						String str = null;
						str = br.readLine();
						if(str == null) {
							bw.write(seatnum);
						} else {
							bw.write("\n"+seatnum);
						}
							bw.flush();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						try {
							bw.close();
							br.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
		
		System.out.println(seatnum+"번 좌석 Manager로 이동완료");
	}
	//== 파일 저장 ===
	public void seatss(String seatim) {
		BufferedWriter bw = null;
		ArrayList seat = new ArrayList();

		seat.add(seatim);
		try {
			bw = new BufferedWriter(new FileWriter("seatsv.txt")); 
			//	bw.write(  );(seat);
				bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(seat+"저장됨");

	}
	
	//====   파일 읽어오는 것 =============
	public String seatim() {
		String seatim = null;
		BufferedWriter bw = null;
		BufferedReader br = null;
		
					try {
						br = new BufferedReader(new FileReader("seatsv.txt"));
						
						seatim = br.readLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(seatim+"파일 읽어옴");
		
		return seatim;
	}
	public ArrayList seat() {
		
		BufferedReader br = null;
		String read =null;
		ArrayList seatlist = new ArrayList();
		try {
			br = new BufferedReader(new FileReader("userlist.txt"));
			while((read = br.readLine())!= null) {
			
				seatlist.add(read);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return seatlist; 
		
	}
	public int[] seatint() {
		ArrayList num = this.seat();
		Iterator it = (Iterator) num.iterator();
		int[] a = new int[num.size()];
		
		for(int i=0; i<num.size(); i++) {
			a[i] = (int) num.get(i);
		}
		
		return a;
	}
	public int a;
	public void intime(int time) {
		BufferedWriter bw = null;
		BufferedReader br = null;
			
					try {
						br = new BufferedReader(new FileReader("time.txt"));
						
						bw = new BufferedWriter(new FileWriter("time.txt")); 
						//bw.write(seatnum+"\n");
						String str = null;
						
							bw.write(time);
							bw.flush();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		
		System.out.println(time+"시 선택시간 Manager로 이동완료");	
	}
	
	public int gettime() {
		BufferedReader br = null;
			
		try {
			br = new BufferedReader(new FileReader("time.txt"));
			
			a = br.read();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		return a;
	}
	
	  public void Reader() {
	      try {
	         BufferedReader br = new BufferedReader(new FileReader("user.dat"));
	         String temp;
	         while((temp = br.readLine())!= null) {
	            System.out.println(temp);
	         }
	      } catch (FileNotFoundException e) {
	         
	         e.printStackTrace();
	      } catch (IOException e) {
	         
	         e.printStackTrace();
	      }finally {
	         
	      }
	   }
	  public ArrayList<User> userdat() {
			ArrayList<User> userList = null;

			try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
				userList = (ArrayList<User>) ois.readObject();
				
				String[] aa = new String[userList.size()];
				int a = 0;
				while(a < userList.size()) {
					aa[a] = userList.get(a).toString();
					System.out.println(aa[a]);
					a++;
				}
				
			} catch (ClassNotFoundException | IOException e) {
				System.out.println("user.dat에 첫번째 입력");
			}

			return userList;
		}
	  
	}
