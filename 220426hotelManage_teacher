package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import Util.ScanUtil;

public class hotel_teacher {

	HashMap<Integer, Rooms> hotelMap;
	
	
	//1.생성자
	public hotel_teacher() {
		hotelMap = new HashMap<Integer, Rooms>();
		
		//2. 객실 초기화
		for(int i = 2 ; i<=4; i++) {
			String roomType = null;
			switch(i) {
			case 2 : roomType = "싱글룸"; break;
			case 3 : roomType = "더블룸"; break;
			case 4 : roomType = "스위트룸"; break;
			}
			for(int j = 1; j<10 ; j++) {
				int roomNum = i*100+j;
				Rooms room = new Rooms(roomNum, roomType);
				hotelMap.put(roomNum, room);
//				hotelMap.put(room, new Room(roomNum,roomType)); 이렇게 한번에 써도 됨
			}
		}
		
	}
/////////////////////////////////////////////////////////////////////////////////////
	
	public static void main(String[] args) {
		
		new hotel_teacher().hotelStart();
		
	}
/////////////////////////////////////////////////////////////////////////////////////
	public void hotelStart() {
		System.out.println();
		System.out.println("**********************************");
		System.out.println("호텔문을 열었습니다. 어서오십시오.");
		System.out.println("**********************************");
		System.out.println();
		while (true) {
			int input = menu();
			switch (input) {
			case 1:
				checkIn();
				break;
			case 2:
				checkOut();
				break;
			case 3:
				roomState();
				break;
			case 4:
				System.out.println("호텔문을 닫았습니다.");
				return;
			default:
				System.out.println("메뉴를 다시 선택해주세요.");
			}
		}
	}	
/////////////////////////////////////////////////////////////////////////////////////
private void checkIn() {
	System.out.println();
	System.out.println("<< CHECK IN >>");
	System.out.println("-------------------------------------");
	System.out.println("* 201-209 : " + "싱글룸");
	System.out.println("* 301-309 : " + "더블룸");
	System.out.println("* 401-409 : " + "스위트룸 ");
	System.out.println("-------------------------------------");
	System.out.print("객실 선택 >> ");
	int num = ScanUtil.nextInt();
	//입력한 값이 Map의 key가 없으면 없는 방번호이다.
	if(!hotelMap.containsKey(num)) {
		System.out.println(num+"은 존재하지 않는 객실입니다.");
	}else if(hotelMap.get(num).getGestName()!=null){	//해당 객실에 다른 투숙객이 있는지 검사
		System.out.println(num + "호 객실에는 이미 다른 고객님이 투숙중입니다.");
	}else {
		System.out.print("체크인 존함을 입력해주세요 > ");
		String name = ScanUtil.nextLine();
		//입력받은 투숙객 이름을 해당 객실에 투숙객 명단에 저장하기
		hotelMap.get(num).setGestName(name);
	}
	
}
/////////////////////////////////////////////////////////////////////////////////////
private void checkOut() {
	System.out.println("-------------------------------------");
	System.out.println("<< CHECK OUT >>");
	System.out.println("-------------------------------------");
	System.out.print("check out 방 번호 >> ");
	int num = ScanUtil.nextInt();
	if(!hotelMap.containsKey(num)) {
		System.out.println(num+"호 객실은 존재하지 않습니다.");
		return;
	}else if(hotelMap.get(num).getGestName() == null) {
		System.out.println(num+"호 객실에는 체크인한 고객이 없습니다.");
		return;
	}else {	//체크아웃 작업은 해당 객실의 투숙객 이름은 null로 변경하면 된다.
		String name = hotelMap.get(num).getGestName(); //현재 투숙객 이름 구하기
		
		hotelMap.get(num).setGestName(null);//투숙객 이름을 null 로 설정
		System.out.println(num+"호 객실의 "+name+"님이 체크아웃을 완료하였습니다.");
		
		}
		
	}
/////////////////////////////////////////////////////////////////////////////////////

private void roomState() {
	// 방번호를 순서대로 나오게 하기 위해서 방번호만 List에 넣은 후 정렬하여 사용한다.
	//방번호는 Map의 Key값
	ArrayList<Integer>roomNumList = new ArrayList<Integer>(hotelMap.keySet());
	
	//방번호의 오름차순으로 정렬한다.
	Collections.sort(roomNumList);

	System.out.println();
	System.out.println("-------------------------------------");
	System.out.println("<< ROOM STATE >>");
	System.out.println("-------------------------------------");
	System.out.println("Room Number\tRoom Type\tGuest Name");
	System.out.println("-------------------------------------");
	
	//List에서 방번호를 하나씩 꺼내와 Map에서 해당방번호에 해당하는 Room객체를 구해서 출력한다.
	for(int num : roomNumList) {
		Rooms r = hotelMap.get(num);
		System.out.print(r.getRoomNum()+"\t"+r.getRoomType()+"\t");
		System.out.println(r.getGestName()==null ? "-" : r.getGestName());
		
	}

}
/////////////////////////////////////////////////////////////////////////////////////
	public int menu() {
		System.out.println();
		System.out.println("=====================================");
		System.out.println("1.체크인  2.체크아웃  3.객실상태  4.업무종료");
		System.out.println("=====================================");
		System.out.print("선택 >> ");
		return ScanUtil.nextInt();

	}
/////////////////////////////////////////////////////////////////////////////////////


}

class Rooms{
	private int roomNum;
	private String roomType;
	private String gestName;
	
	public Rooms(int roomNum, String roomType) {
		super();
		this.roomNum = roomNum;
		this.roomType = roomType;
	}

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getGestName() {
		return gestName;
	}

	public void setGestName(String gestName) {
		this.gestName = gestName;
	}
	
	
}

===============================================================================
