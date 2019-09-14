package com.kh.studyCafe.kosk.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import com.kh.studyCafe.client.ClientBack;
import com.kh.studyCafe.model.vo.User;

public class KoskDao {

	private String phoneNum;
	private String password;
	private String seatNum;
	private int num;
	private String name;
	private int term;
	private int light;
	private int hOfw;
	private long seattime;

	public int KoskWrite(ArrayList<User> user) {
		int result = 0;

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.dat"))) {
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

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
			userList = (ArrayList<User>) ois.readObject();

			for (int i = 0; i < userList.size(); i++) {
				if (userList.get(i).getPhoneNum().equals(phoneNum))
					seatNum = userList.get(i).getSeatNum();
			}
		} catch (ClassNotFoundException | IOException e) {
			System.out.println("user.dat에 첫번째 입력");
		}

		return seatNum;
	}

	public ArrayList<String> seatin() {

		ArrayList<User> userList = null;
		ArrayList<String> seatnum = null;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
			userList = (ArrayList<User>) ois.readObject();

			seatnum = new ArrayList<String>();
			for (int i = 0; i < userList.size(); i++) {
				if (!userList.get(i).getSeatNum().equals("0")) {
					seatnum.add(userList.get(i).getSeatNum());
				}
				System.out.println(userList.get(i));

			}
		} catch (ClassNotFoundException | IOException e) {
			System.out.println("user.dat에 첫번째 입력");
		}

		return seatnum;

	}

	public int login(String phoneNum, String password) {
		this.phoneNum = phoneNum;
		this.password = password;
		ArrayList<User> userList = null;
		ArrayList<String> seatnum = null;

		int a = 0;

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
			userList = (ArrayList<User>) ois.readObject();

			seatnum = new ArrayList<String>();
			for (int i = 0; i < userList.size(); i++) {
				if (userList.get(i).getPhoneNum().equals(phoneNum)) {
					if (userList.get(i).getPassword().equals(password)) {
						System.out.println(userList.get(i).getSeatNum());
						if (!userList.get(i).getSeatNum().equals("0")) {
							a = 1; // 회원정보 있으면서 좌석까지 있음
						} else {
							a = 2; // 회원정보 있으나 좌석이 없음
						}
					} else {
					}
				}
			}
		} catch (ClassNotFoundException | IOException e) {
			System.out.println("user.dat에 첫번째 입력");
		}
		return a;
	}

	// == 시트 저장 ==
	public ArrayList<User> KoskLineSeat(String phoneNum, String seatNum) {
		this.phoneNum = phoneNum;
		this.seatNum = seatNum;
		ArrayList<User> userList = null;

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
			userList = (ArrayList<User>) ois.readObject();

			for (int i = 0; i < userList.size(); i++) {
				if (userList.get(i).getPhoneNum().equals(phoneNum)) {
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

	public String Koskmove(String phoneNum) {
		this.phoneNum = phoneNum;
		ArrayList<User> userList = null;
		String user = new String();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
			userList = (ArrayList<User>) ois.readObject();

			for (int i = 0; i < userList.size(); i++) {
				if (userList.get(i).getPhoneNum().equals(phoneNum)) {
					user = (userList.get(i).toString());

				}
			}

		} catch (Exception e) {
			System.out.println("user.dat에 첫번째 입력");
		}

		return user;
	}

	public void KoskExitSeat(String phoneNum) {
		this.phoneNum = phoneNum;
		ArrayList<User> userList = null;

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
			userList = (ArrayList<User>) ois.readObject();

			for (int i = 0; i < userList.size(); i++) {
				if (userList.get(i).getPhoneNum().equals(phoneNum)) {
					if(findPhoneToSeatType(phoneNum) == User.WEEKSEAT) { // 기간권
						userList.get(i).setInTime(0);
						
					}else { // 1일권
						userList.get(i).setInTime(0);
						userList.get(i).setOutTime(0);
						userList.get(i).setRemainTime(0);
						userList.get(i).setSeatNum("0");
						userList.get(i).setSeatType(User.NOSEAT);
							
					}
					KoskWrite(userList); //
				}
			}

		} catch (ClassNotFoundException | IOException e) {
			System.out.println("user.dat에 첫번째 입력");
		}

	}

	public boolean compare(String phoneNum, String name) {
		this.phoneNum = phoneNum;
		this.name = name;

		ArrayList<User> userList = null;
		ArrayList<String> seatnum = null;

		boolean a = false;

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
			userList = (ArrayList<User>) ois.readObject();

			seatnum = new ArrayList<String>();
			for (int i = 0; i < userList.size(); i++) {
				if (userList.get(i).getPhoneNum().equals(phoneNum)) {
					if (userList.get(i).getName().equals(name)) {
						a = true;
					}
				}
			}
		} catch (ClassNotFoundException | IOException e) {
			System.out.println("user.dat에 첫번째 입력");
		}

		return a;
	}

	public ArrayList<User> KoskPsswdChange(String phoneNum, String password) {
		this.phoneNum = phoneNum;
		this.password = password;
		ArrayList<User> userList = null;

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
			userList = (ArrayList<User>) ois.readObject();

			for (int i = 0; i < userList.size(); i++) {
				if (userList.get(i).getPhoneNum().equals(phoneNum)) {
					if (userList.get(i).getPassword().equals(password)) {
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

	public void Kosktimeplus(String phoneNum, long time, String seatNum, int num) {
		this.seatNum = seatNum;
		this.phoneNum = phoneNum;
		this.num = num;
		ArrayList<User> userList = null;

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
			userList = (ArrayList<User>) ois.readObject();

			for (int i = 0; i < userList.size(); i++) {
				if (userList.get(i).getPhoneNum().equals(phoneNum)) {
					if (num == 0) {
						userList.get(i)
								.setRemainTime((((time) * 3600000) * (time * 24)) + userList.get(i).getRemainTime());
						userList.get(i).setOutTime((((time) * 3600000) * (time * 24)) + userList.get(i).getOutTime());
					} else if (num == 1) {
						userList.get(i).setRemainTime(((time) * 3600000) + userList.get(i).getRemainTime());
						userList.get(i).setOutTime((time * 3600000) + userList.get(i).getOutTime());
					}
					int a = Integer.parseInt(seatNum);

					if (a > 0 && a < 26) {
						userList.get(i).setSeatNum(seatNum);
					} else if (a == 25) {
						userList.get(i).setSeatNum("25");
					} else if (a == 26) {
						userList.get(i).setSeatNum("26");
					} else if (a == 27) {
						userList.get(i).setSeatNum("27");
					} else if (a == 28) {
						userList.get(i).setSeatNum("28");
					} else if (a == 29) {
						userList.get(i).setSeatNum("29");
					}

					KoskWrite(userList);
					System.out.println(userList.get(i).getSeatNum() + "저장");
				}
			}

		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

	}

	public void Kosktimeplus2(ArrayList<User> uList, String seatnum, long seattime, String phnum, int hOfw) {
		this.seatNum = seatnum;
		this.phoneNum = phnum;
		this.hOfw = hOfw;
		this.seattime = seattime;
		ArrayList<User> userList = null;
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
			userList = (ArrayList<User>) ois.readObject();
			
			for (int i = 0; i < userList.size(); i++) {

				if (userList.get(i).getPhoneNum().equals(phnum)) {
					
					long timeNow = new Date(new GregorianCalendar().getTimeInMillis()).getTime();
					if (hOfw == 1) {
						userList.get(i).setSeatNum(seatnum);
						userList.get(i).setInTime(timeNow);
						userList.get(i).setOutTime(userList.get(i).getRemainTime() + timeNow + (seattime * 3600000L));
						userList.get(i).setRemainTime(userList.get(i).getRemainTime() + userList.get(i).getOutTime() - timeNow);
						userList.get(i).setSeatType(User.HOURSEAT);
						userList.get(i).setPointTime(userList.get(i).getPointTime() + (seattime * 3600000L));
						
						// 회원 등급 체크
						if (userList.get(i).getPointTime() > 360000000L) {
							userList.get(i).setRank("gold");
						} else if (userList.get(i).getPointTime() > 180000000L) {
							userList.get(i).setRank("silver");
						} else {
							userList.get(i).setRank("bronze");
						}

						break;
					} else {
						userList.get(i).setSeatNum(seatnum);
						userList.get(i).setInTime(timeNow);
						userList.get(i).setOutTime(userList.get(i).getRemainTime() + timeNow + (((seattime * 3600000L * 24L))));
						userList.get(i).setRemainTime(userList.get(i).getOutTime() - timeNow);
						userList.get(i).setSeatType(User.WEEKSEAT);
						userList.get(i).setPointTime(userList.get(i).getPointTime() + (seattime * 3600000L * 24L));
						
						// 회원 등급 체크
						if (userList.get(i).getPointTime() > 360000000L) {
							userList.get(i).setRank("gold");
						} else if (userList.get(i).getPointTime() > 180000000L) {
							userList.get(i).setRank("silver");
						} else {
							userList.get(i).setRank("bronze");
						}
						
					}
					
					break;
				}
				
				
			}
			System.out.println("여기여기 " + userList);
			KoskWrite(userList);

		} catch (ClassNotFoundException | IOException e) {
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

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
			userList = (ArrayList<User>) ois.readObject();

			seatnum = new ArrayList<String>();

			for (int i = 0; i < userList.size(); i++) {
				if (userList.get(i).getPhoneNum().equals(phoneNum)) {
					name = userList.get(i).getName();
					phoneNum = userList.get(i).getPhoneNum();
					remainTime = userList.get(i).getRemainTime() + "";
					rank = userList.get(i).getRank();
				}
			}
		} catch (ClassNotFoundException | IOException e) {
			System.out.println("user.dat에 첫번째 입력");
		}
		return name + "," + phoneNum + "," + remainTime + "," + point + "," + rank;
	}

	public int myPage1(String phoneNum) {
		this.phoneNum = phoneNum;
		ArrayList<User> userList = null;
		ArrayList<String> seatnum = null;

		int a = 0;

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
			userList = (ArrayList<User>) ois.readObject();

			seatnum = new ArrayList<String>();
			for (int i = 0; i < userList.size(); i++) {
				if (userList.get(i).getPhoneNum().equals(phoneNum)) {
					if (!userList.get(i).getSeatNum().equals("0")) {
						a = 1; // 회원정보 있으면서 좌석까지 있음
					} else {
						a = 2; // 회원정보 있으나 좌석이 없음
					}
				}
			}

		} catch (ClassNotFoundException | IOException e) {
			System.out.println("user.dat에 첫번째 입력");
		}
		return a;
	}

	public long remainTime(String phoneNum) {
		this.phoneNum = phoneNum;
		ArrayList<User> userList = null;
		ArrayList<String> seatnum = null;

		long a = 0;

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
			userList = (ArrayList<User>) ois.readObject();

			seatnum = new ArrayList<String>();
			for (int i = 0; i < userList.size(); i++) {
				if (userList.get(i).getPhoneNum().equals(phoneNum)) {
					a = userList.get(i).getRemainTime();
				}
			}

		} catch (ClassNotFoundException | IOException e) {
			System.out.println("user.dat에 첫번째 입력");
		}
		return a;
	}

	public String seatread(String phoneNum) {
		this.phoneNum = phoneNum;
		ArrayList<User> userList = null;
		String seatnum = null;

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
			userList = (ArrayList<User>) ois.readObject();

			seatnum = new String();
			for (int i = 0; i < userList.size(); i++) {
				if (userList.get(i).getPhoneNum().equals(phoneNum)) {
					seatnum = (userList.get(i).getSeatNum());
				}
			}
		} catch (Exception e) {
			System.out.println("user.dat에 첫번째 입력");
		}
		return seatnum;
	}

	public ArrayList<User> uList() {
		ArrayList<User> userList = null;
		ArrayList<User> list = new ArrayList<User>();

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
			userList = (ArrayList<User>) ois.readObject();

			for (int i = 0; i < userList.size(); i++) {
				if (userList.get(i).getPhoneNum().equals(phoneNum)) {
					list.add(userList.get(i));
				}
			}
		} catch (Exception e) {
			System.out.println("user.dat에 첫번째 입력");
		}

		return userList;
	}

	public int userindex(String phnum) {
		int indexnum = 0;
		ArrayList<User> userList = null;

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
			userList = (ArrayList<User>) ois.readObject();
			for (int i = 0; i < userList.size(); i++) {
				if (userList.get(i).getPhoneNum().equals(phnum)) {
					System.out.println(userList.get(i));
					System.out.println("idx : " + i);
					indexnum = i;
					break;
				}
			}
			System.out.println(indexnum + "인덱스");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return indexnum;
	}

	public String nowseat(String phnum) {
		String seatnum = null;
		ArrayList<User> userList = null;
		int a = 0;

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
			userList = (ArrayList<User>) ois.readObject();
			for (int i = 0; i < userList.size(); i++) {
				if (userList.get(i).getPhoneNum().equals(phnum)) {
					a = Integer.parseInt(userList.get(i).getSeatNum());
					if (a > 0 && a < 26) {
						seatnum = a + "";
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "";
	}

	public void changePasswd(String phoneNum, String password) {
		/*this.phoneNum = phoneNum;
		this.password = password;*/
		ArrayList<User> userList = null;

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
			userList = (ArrayList<User>) ois.readObject();
			System.out.println("aaaa");
			for (int i = 0; i < userList.size(); i++) {
				System.out.println("bbbb");
				if (userList.get(i).getPhoneNum().equals(phoneNum)) {
					System.out.println(password);
					userList.get(i).setPassword(password);
				}
			}
			
			KoskWrite(userList);
			System.out.println("변경후" + userList);
			
		} catch (ClassNotFoundException | IOException e) {
			System.out.println("user.dat에 첫번째 입력");
		}
	}
	
	public int discount(String phnum) {
		int dc = 0;
		ArrayList<User> userList = null;
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))){
			userList = ((ArrayList<User>) ois.readObject());
			
			for(int i=0; i<userList.size(); i++) {
				if(userList.get(i).getPhoneNum().equals(phnum)) {
					if(userList.get(i).getRank().equals("bronze")) {
						dc = 50;
					} else if(userList.get(i).getRank().equals("silver")) {
						dc = 100;
					} else if(userList.get(i).getRank().equals("gold")) {
						dc = 150;
					}
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dc;
	}
	
	// 핸드폰 번호로 입실 타입 찾기
	public int findPhoneToSeatType(String phnum) {
		int seatType = 0;
		ArrayList<User> userList = null;
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))){
			userList = ((ArrayList<User>) ois.readObject());
			
			for(int i=0; i<userList.size(); i++) {
				if(userList.get(i).getPhoneNum().equals(phnum)) {
					seatType = userList.get(i).getSeatType();
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return seatType;
	}

	// 핸드폰 번호로 user 찾기
	public User findPhoneToUser(String phnum) {
		User u = null;
		ArrayList<User> userList = null;
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))){
			userList = ((ArrayList<User>) ois.readObject());
			
			for(int i=0; i<userList.size(); i++) {
				if(userList.get(i).getPhoneNum().equals(phnum)) {
					u = userList.get(i);
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}
	
}