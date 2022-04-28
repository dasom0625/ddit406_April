//10마리의 말들이 경주하는 경마 프로그램을 작성해 보자.
//말은 Horse라는 이름의 쓰레드 클래스를 작성하는데, 
//이 클래스는 말 이름(String), 등수(int), 현재위치(int)를 멤버변수로 받는다.
//(v)그리고 이 클래스에는 등수를 오름차순으로 처리할 수 있는 내부정렬 기준이 있다.(Comparable인터페이스 구현)
//
//경기구간은 1-50구간이다. (말의 현재 위치는 현재 말이 달리고 있는 구간을 말한다)
//
//경기 중 중간 강간에 각 말들의 위치를 아래와 같이 나타내시오.
//예)
//01번말 ---->-----------------------------
//02번말 -------->-------------------------
//03번말 ------------------->--------------
//...
//10번말 ------------------------>---------
//
//경기가 끝나면 등수순으로 출력한다.
//쓰레드는 최소 두개(말 10마리에 대한 각 쓰레드(근데 ThreadTest10에서 한것처럼 1개에서 for문 돌려도 되지 않을까?), 위의 그림을 출력하는 쓰레드)
//말의 속도는 random이다.
package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;

public class ThreadTest11 {
	static int Rank =1;
	public static void main(String[] args) {
		
		//6. Horse 10마리를 리스트에 담기
		ArrayList<Horse>hList = new ArrayList<Horse>();
		
	
		hList.add(new Horse("달래", 1));
		hList.add(new Horse("솜솜", 2));
		hList.add(new Horse("후후", 3));
		hList.add(new Horse("실실", 4));
		hList.add(new Horse("민초", 5));
		hList.add(new Horse("띵구", 6));
		hList.add(new Horse("섭섭", 7));
		hList.add(new Horse("송송", 8));
		hList.add(new Horse("엽엽", 9));
		hList.add(new Horse("룡룡", 10));
		
		
		//7.
		for(Horse h : hList) {
			h.start();
		}
		//8.
			try {
				for (Horse h : hList) {
				h.join();  // 10마리의 말이 다 달릴때까지 좀 기다려.
				}
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		
	
		System.out.println();
		System.out.println("경기 결과");
		System.out.println("순위");
		
		Collections.sort(hList);
		for (Horse horse : hList) {
			
			System.out.println(horse.gethName()+" "+horse.getWhere()+" "+horse.getRank()+"등");
		
		}
		
	}

}

///////////////////////////////////////////////////////////
//1. 1-50구간을 달리는 한마리의 HORSE라는 말의 쓰레드
class Horse extends Thread implements Comparable<Horse>{
	int Rank = 0;//2. 출력을 끝낸 순서대로 쓰레드 이름이 추가되는 변수(멤버변수)
	private String hName;	//말 이름 저장하기 위해(멤버변수)
	private int where;	//말의 현재위치를 알려주기위해(멤버변수)
	

	protected int getRank() {
		return Rank;
	}


	protected void setRank(int rank) {
		Rank = rank;
	}


	protected String gethName() {
		return hName;
	}


	protected void sethName(String hName) {
		this.hName = hName;
	}


	protected int getWhere() {
		return where;
	}


	protected void setWhere(int where) {
		this.where = where;
	}


	//3. 생성자
	public Horse(String hName,int where) {
		this.hName = hName;
		this.where = where;
	}


	@Override
	public String toString() {
		return "Horse [Rank=" + Rank + ", hName=" + hName + ", where=" + where + "]";
	}

	
	//5. 
	@Override
	public void run() {
		
		int count = 0;
		
		do {	//50번 반복
			
		
		for (int i = 1; i <= 50; i++) {	//말의 구간은 1-50구간임.
			System.out.print("\n"+hName + " : ");
			for(int j = 0 ; j<i ; j++) {	//앞에 1구간부터 넣을 선
			System.out.print("_");
			}
			
			System.out.print(where);	//말의 위치
			
			for(int j=49 ; j>i ; j--) {	//뒤에 50구간부터 넣을 선인데 말의 위치가 포함되어있어서 -1한 49부터 시작
				System.out.print("_");
			}
			System.out.println("\n\n");
			
			
			try {
				Thread.sleep((int) (Math.random() * 100));
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}	System.out.println("\n"+hName + "말이 도착했습니다!!!");
		System.out.println();
		setRank(ThreadTest11.Rank);
		ThreadTest11.Rank++;
		System.out.println();
		
	} while (count == 50);
		
		System.out.println(gethName()+" "+getWhere()+" "+getRank()+"등");

}
	
	
	//4. 랭킹 오름차순 정렬
	@Override
	public int compareTo(Horse hs) {
		if (this.Rank > hs.getRank()) {
			return 1;
		} else if (this.Rank < hs.getRank()) {
			return -1;
		} else {
			return 0;
		}
	}
}













