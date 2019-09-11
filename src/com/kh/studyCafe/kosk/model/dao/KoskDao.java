package com.kh.studyCafe.kosk.model.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.sound.midi.Synthesizer;

import com.kh.studyCafe.model.vo.User;

public class KoskDao {

	private String phoneNum;
	private String password;
	private String seatNum;
	private int num;
	private String name;
	private int term;
	private int light;
	public int KoskWrite(ArrayList<User> user) {
		int result = 0;

		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.dat"))) {
			oos.writeObject(user);

			oos.flush();
			result++;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

	// 좌석번호 수정
	
    // ==== 퇴시 =====
	

	public String toEnterInfo(String phoneNum) { 
		this.phoneNum = phoneNum;
		String seatNum = null;
		ArrayList<User> userList = null;

		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
			userList = (ArrayList<User>) ois.readObject();

			for (int i = 0; i < userList.size(); i++) {
				if(userList.get(i).getPhoneNum().equals(phoneNum)) 
					seatNum = userList.get(i).getSeatNum();
				break;
			}
		}catch (ClassNotFoundException | IOException e) {
			System.out.println("user.dat에 첫번째 입력");
		}

		return seatNum;
	}

	
	public ArrayList<String> seatin(){
		
		ArrayList<User> userList = null;
		ArrayList<String> seatnum = null;
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
			userList = (ArrayList<User>) ois.readObject();
			
			seatnum = new ArrayList<String>();
			for (int i = 0; i < userList.size(); i++) {
				if(!userList.get(i).getSeatNum().equals("0")) {
					seatnum.add(userList.get(i).getSeatNum());
				}
				System.out.println(userList.get(i));
				
			}
		}catch (ClassNotFoundException | IOException e) {
			System.out.println("user.dat에 첫번째 입력");
		}
		
		
		return seatnum;
		
	}
	public int login(String phoneNum, String password) { 
		this.phoneNum = phoneNum;
		this.password = password;
		//this.phonenumber = phonenumber;
		ArrayList<User> userList = null;
		ArrayList<String> seatnum = null;
		
		int a = 0 ;
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
			userList = (ArrayList<User>) ois.readObject();
			
			seatnum = new ArrayList<String>();
			for (int i = 0; i < userList.size(); i++) {
				if(userList.get(i).getPhoneNum().equals(phoneNum)) {
					if(userList.get(i).getPassword().equals(password)) {
						if(!userList.get(i).getSeatNum().equals("0")) {
							a = 1; // 회원정보 있으면서 좌석까지 있음
						} else {
							a = 2; // 회원정보 있으나 좌석이 없음
						}
					} else {
					}
				}
			}
		}catch (ClassNotFoundException | IOException e) {
			System.out.println("user.dat에 첫번째 입력");
		}
		return a;
	}
	
	//== 시트 저장 ==
		public ArrayList<User> KoskLineSeat(String phoneNum, String seatNum){
			this.phoneNum = phoneNum;
			this.seatNum =seatNum;
			ArrayList<User> userList = null;

			try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
				userList = (ArrayList<User>) ois.readObject();

				for (int i = 0; i < userList.size(); i++) {
					if(userList.get(i).getPhoneNum().equals(phoneNum)) {
						userList.get(i).setSeatNum(seatNum);
						System.out.println(userList);
						KoskWrite(userList); // 
						
					}
				}

			} catch (ClassNotFoundException | IOException e) {
				System.out.println("user.dat에 첫번째 입력");
			}

			return userList;
		}
		public String Koskmove(String phoneNum){
			this.phoneNum =phoneNum;
			ArrayList<User> userList = null;
			String user = new String();
			try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
				userList = (ArrayList<User>) ois.readObject();

				
				for (int i = 0; i < userList.size(); i++) {
					if(userList.get(i).getPhoneNum().equals(phoneNum)) {
						user = (userList.get(i).toString());
						
					}
				}
			

			} catch (Exception e) {
				System.out.println("user.dat에 첫번째 입력");
			} 
			
			return user;
		}
		
		
		public ArrayList<User> KoskExitSeat(String phoneNum){
			this.phoneNum = phoneNum;
			ArrayList<User> userList = null;

			try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
				userList = (ArrayList<User>) ois.readObject();

				for (int i = 0; i < userList.size(); i++) {
					if(userList.get(i).getPhoneNum().equals(phoneNum)) {
						userList.get(i).setInTime(0);
						userList.get(i).setSeatNum("0");
						userList.get(i).setOutTime(0);
						userList.get(i).setRemainTime(0);
						KoskWrite(userList); // 
					} else {
						System.out.println(userList.get(i).getPhoneNum());
					
					}
				}

			} catch (ClassNotFoundException | IOException e) {
				System.out.println("user.dat에 첫번째 입력");
			}

			return userList;
		}
		
		public boolean compare(String phoneNum, String name) { 
			this.phoneNum = phoneNum;
			this.name = name;
			
			ArrayList<User> userList = null;
			ArrayList<String> seatnum = null;
			
			boolean a = false;
			
			try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
				userList = (ArrayList<User>) ois.readObject();
				
				seatnum = new ArrayList<String>();
				for (int i = 0; i < userList.size(); i++) {
					if(userList.get(i).getPhoneNum().equals(phoneNum)) {
						if(userList.get(i).getName().equals(name)) {
								a = true; 	
						} 				
					}
				}
			}catch (ClassNotFoundException | IOException e) {
				System.out.println("user.dat에 첫번째 입력");
			}
		
			return a;
		}

		public ArrayList<User> KoskPsswdChange(String phoneNum, String password){
			this.phoneNum = phoneNum;
			this.password = password;
			ArrayList<User> userList = null;

			try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
				userList = (ArrayList<User>) ois.readObject();

				for (int i = 0; i < userList.size(); i++) {
					if(userList.get(i).getPhoneNum().equals(phoneNum)) {
						if(userList.get(i).getPassword().equals(password)) {
							userList.get(i).setPassword(password);
							KoskWrite(userList); // 
						}
						
					}
				}

			} catch (ClassNotFoundException | IOException e) {
				System.out.println("user.dat에 첫번째 입력");
			}

			return userList;
		}
		public void Kosktimeplus(String phoneNum ,long time, String seatNum, int num) {
			this.seatNum =seatNum;
			this.phoneNum = phoneNum;
			this.num = num;
			ArrayList<User> userList = null;
			
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
				userList = (ArrayList<User>) ois.readObject();
				
				for(int i=0; i<userList.size(); i++) {
					if(userList.get(i).getPhoneNum().equals(phoneNum)) {
						if(num == 0) {
							userList.get(i).setRemainTime((((time)*3600000)*(time*24)) + userList.get(i).getRemainTime());
							userList.get(i).setOutTime((((time)*3600000)*(time*24)) + userList.get(i).getOutTime());
						} else if(num == 1) {
							userList.get(i).setRemainTime(((time)*3600000) + userList.get(i).getRemainTime());
							userList.get(i).setOutTime((time*3600000) + userList.get(i).getOutTime());
						}
							int a = Integer.parseInt(seatNum);
							
							if(a>0 && a<26) {
								userList.get(i).setSeatNum(seatNum);
							} else if(a == 25) {
								userList.get(i).setSeatNum("4-A");
							} else if(a == 26) {
								userList.get(i).setSeatNum("4-B");
							} else if(a == 27) {
								userList.get(i).setSeatNum("6-A");
							} else if(a == 28) {
								userList.get(i).setSeatNum("6-B");
							} else if(a == 29) {
								userList.get(i).setSeatNum("8-A");
							}
						
						KoskWrite(userList);
						System.out.println(userList.get(i).getSeatNum()+"저장");
					}
				}
				
			} catch (ClassNotFoundException |IOException e) {
				e.printStackTrace();
			}
			
		
		}
		public void Kosktimeplus2(ArrayList<User> uList,int light,long seattime,String phnum) {
			this.light = light;
			this.phoneNum = phnum;
			ArrayList<User> userList = null;
			String seatNum = null;
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
				userList = (ArrayList<User>) ois.readObject();
				System.out.println("불러온 좌석 값 : " + light);
				System.out.println("불러온 휴대폰값 : " + phnum);
							for(int i=0; i<userList.size(); i++) {
								if(userList.get(i).getPhoneNum().equals(phnum)) {
									 if(light>0 && light<25) {
										 userList.get(i).setSeatNum((light)+"");
										 System.out.println(light+"좌석");
										 System.out.println(userList.get(i).getSeatNum()+"좌석 "+i+": 번째 저장된 좌석");
									 } else if(light == 0) {
										 userList.get(i).setSeatNum("1");
										 System.out.println(userList.get(i).getSeatNum()+"좌석 "+i+": 번째 저장된 좌석");
									 }else if(light == 25) {
										userList.get(i).setSeatNum("4-A");
										System.out.println(userList.get(i).getSeatNum()+"좌석 "+i+": 번째 저장된 좌석");
									} else if(light == 26) {
										userList.get(i).setSeatNum("4-B");
										System.out.println(userList.get(i).getSeatNum()+"좌석 "+i+": 번째 저장된 좌석");
									} else if(light == 27) {
										userList.get(i).setSeatNum("6-A");
										System.out.println(userList.get(i).getSeatNum()+"좌석 "+i+": 번째 저장된 좌석");
									} else if(light == 28) {
										userList.get(i).setSeatNum("6-B");
										System.out.println(userList.get(i).getSeatNum()+"좌석 "+i+": 번째 저장된 좌석");
									} else if(light == 29) {
										userList.get(i).setSeatNum("8-A");
										System.out.println(userList.get(i).getSeatNum()+"좌석 "+i+": 번째 저장된 좌석");
									}	
									
								}
							}
							 KoskWrite(userList);
						
				System.out.println(light+"전달하는 값");
				
			} catch (ClassNotFoundException |IOException e) {
				e.printStackTrace();
			}
			
		
		}
		  public String myPage(String phoneNum) { 
		         this.phoneNum = phoneNum;
		         ArrayList<User> userList = null;
		         ArrayList<String> seatnum = null;
		         
		         String myPageInfo = null;
		         String name = null;
		         String remainTime = null;
		         String point = null;
		         String rank = null;
		                     
		         try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
		            userList = (ArrayList<User>) ois.readObject();
		   
		            
		            seatnum = new ArrayList<String>();
		            
		            for (int i = 0; i < userList.size(); i++) {
		               if(userList.get(i).getPhoneNum().equals(phoneNum)) {
		                  name = userList.get(i).getName();
		                  phoneNum = userList.get(i).getPhoneNum();
		                  remainTime = userList.get(i).getRemainTime() + "";
		                  point = userList.get(i).getPoint() + "";
		                  rank = userList.get(i).getRank();
		               }
		            }
		         }catch (ClassNotFoundException | IOException e) {
		            System.out.println("user.dat에 첫번째 입력");
		         }
		         return name + "," + phoneNum + "," + remainTime + ","  + point + "," + rank;
		      }
		      
		      public int myPage1(String phoneNum) { 
		         this.phoneNum = phoneNum;
		         ArrayList<User> userList = null;
		         ArrayList<String> seatnum = null;
		         
		         int a = 0 ;
		         
		         try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
		            userList = (ArrayList<User>) ois.readObject();
		            
		            seatnum = new ArrayList<String>();
		            for (int i = 0; i < userList.size(); i++) {
		               if(userList.get(i).getPhoneNum().equals(phoneNum)) {   
		                     if(!userList.get(i).getSeatNum().equals("0")) {
		                        a = 1; // 회원정보 있으면서 좌석까지 있음
		                     } else {
		                        a = 2; // 회원정보 있으나 좌석이 없음
		                     }
		                  } 
		               }
		            
		         }catch (ClassNotFoundException | IOException e) {
		            System.out.println("user.dat에 첫번째 입력");
		         }
		         return a;
		      }
		      
		      public long remainTime(String phoneNum) { 
		         this.phoneNum = phoneNum;
		         ArrayList<User> userList = null;
		         ArrayList<String> seatnum = null;
		         
		         long a = 0 ;
		         
		         try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
		            userList = (ArrayList<User>) ois.readObject();
		            
		            seatnum = new ArrayList<String>();
		            for (int i = 0; i < userList.size(); i++) {
		               if(userList.get(i).getPhoneNum().equals(phoneNum)) {   
		                     a = userList.get(i).getRemainTime();
		                  } 
		               }
		            
		         }catch (ClassNotFoundException | IOException e) {
		            System.out.println("user.dat에 첫번째 입력");
		         }
		         return a;
		      }
		      public String seatread(String phoneNum) {
		    	  this.phoneNum = phoneNum;
		    	  ArrayList<User> userList = null;
			         String seatnum = null;
		    	  
		    	 try  (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))){
		    		 userList = (ArrayList<User>) ois.readObject();
		    		 
		    		 seatnum = new String();
		    		 for(int i=0; i<userList.size(); i++) {
		    			 if(userList.get(i).getPhoneNum().equals(phoneNum)) {
		    				 seatnum = (userList.get(i).getSeatNum());
		    			 }
		    		 }
		    	 } catch (Exception e) {
		    		 System.out.println("user.dat에 첫번째 입력");
		    	 }
		    	  return seatnum;
		      }
		      public ArrayList<User> uList(){
		    	  ArrayList<User> userList = null;
		    	 ArrayList<User> list = new ArrayList<User>();
		    	  
		    	  try  (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))){
			    		 userList = (ArrayList<User>) ois.readObject();
			    		 
			    		 for(int i=0; i<userList.size(); i++) {
			    			 if(userList.get(i).getPhoneNum().equals(phoneNum)) {
			    				list.add(userList.get(i));
			    			 }
			    		 }
			    	 } catch (Exception e) {
			    		 System.out.println("user.dat에 첫번째 입력");
			    	 }
		    	  
		    	  return userList;
		      }
		      
		      /*public String getphnum(ArrayList<User> uList) {
		    	  ArrayList<User> userList = null;
		    	  String phnum;
		    	  try  (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))){
			    		 userList = (ArrayList<User>) ois.readObject();
			    		 
			    		 for(int i=0; i<userList.size(); i++) {
			    			 if(userList.get(i).getPhoneNum().equals(phoneNum)) {
			    				phnum = (userList.get(i).getPhoneNum());
			    			 }
			    		 }
			    	 } catch (Exception e) {
			    		 System.out.println("user.dat에 첫번째 입력");
			    	 }
		    	  return "";
		      }*/
}