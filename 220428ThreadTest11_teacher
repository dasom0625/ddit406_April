package kr.or.ddit.basic;

import java.util.Arrays;

public class ThreadTest11_Teacher {

	public static void main(String[] args) {
		//8.배열에 달릴 말 저장해줘
		Horse[]horses = new Horse[] {
				new Horse("01번 말"),new Horse("02번 말"),
				new Horse("03번 말"),new Horse("04번 말"),
				new Horse("05번 말"),new Horse("06번 말"),
				new Horse("07번 말"),new Horse("08번 말"),
				new Horse("09번 말"),new Horse("10번 말")	};
///////////////////////////////////////////////////////
		
		//15.
		GameState gs = new GameState(horses);
///////////////////////////////////////////////////////
		
		for(Horse h : horses) {
			h.start();//16.경주시작
		}
		
///////////////////////////////////////////////////////
		
		gs.start(); //17.경주가 시작하면 현재 상태를 나타내는애도 시작
///////////////////////////////////////////////////////
		
		//18. 모든 말들의 경기가 끝날대까지 기다린다. =>h.join();
		for(Horse h : horses) {
			try {
				h.join();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
///////////////////////////////////////////////////////
		
		//19. gs.join()으로 상태를 나타내는애도 끝날떄까지 기다린다.
		try {
			gs.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.out.println();
		System.out.println("경기가 끝났습니다.");

///////////////////////////////////////////////////////
		
		//22. 배열의 등수 오름차순 정렬
		Arrays.sort(horses);
		
///////////////////////////////////////////////////////
		//21.등수
		for(Horse h : horses) {
			System.out.println(h);
		}
	}
	

}

///////////////////////////////////////////////////////
///////////////////////////////////////////////////////
//1.
class Horse extends Thread implements Comparable<Horse>{
	public static int currentRank = 0; //7.말의 등수를 구하기 위한 변수
	
	
	private String horseName;	//말 이름
	private int rank;	//등수
	private int location; //현재 위치
	
///////////////////////////////////////////////////////
	//2. 생성자는 말이름만 만든다. 왜? 등수랑 현재위치는 계속 바뀌니까!
	public Horse(String horseName) {
		super();
		this.horseName = horseName;
	}

///////////////////////////////////////////////////////
	//3.gettersetter만들기
	public String getHorseName() {
		return horseName;
	}

	public void setHorseName(String horseName) {
		this.horseName = horseName;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}
///////////////////////////////////////////////////////
	
	//4.to String만들기 (return은 아래와 같이 좀 변경해줌)
	@Override
	public String toString() {
		return "경주마 " + horseName + "은(는)" + rank + "등입니다.";
	}
///////////////////////////////////////////////////////


	//5. 등수를 오름차순으로...
	@Override
	public int compareTo(Horse horse) {
		return Integer.compare(this.rank,horse.getRank());
	}
	
///////////////////////////////////////////////////////
	//6.쓰레드
	@Override
	public void run() {
		for(int i = 1 ; i<=50 ; i++) {
			this.location = i;	//말의 현재위치를 계속 i값으로 바꾸기 위해.
			try {
				Thread.sleep((int)(Math.random()*500));
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
///////////////////////////////////////////////////////
		//7. 6번의 반복문이 끝나면 등수(rank)를 구할 세팅을 해줘야 함.
		//모든 말들이 들어올때 공통적으로 앞에 먼저 들어온 말의 등수를 알아야 뒤의 말의 등수를 알 수 있겠찌?
		//맨위로 올라가 7.currentRank을 만들어줌
		currentRank++;	//경기가 끝나면 증가시켜줘
		this.rank = currentRank; //그리고 이제 rank에 currentRank를 다시 저장해줘
	}	
}
///////////////////////////////////////////////////////
//9. 경기 중간중간에 각 말의 위치를 알려주는 쓰레드 만들기
class GameState extends Thread{
	private Horse[]horses;	//맨위의 참가한 말들의 정보들이 저장될 배열(이름10개)
	
///////////////////////////////////////////////////////
	//10.생성자 초기화
	public GameState(Horse[] horses) {
		super();
		this.horses = horses;
	}
	
///////////////////////////////////////////////////////
	//11.쓰레드 작동
	@Override
	public void run() {
		while(true) {	//경기가 끝날떄까지 계속 진행되야 하기 때문에 무한 반복을 넣어둠.(그리고, 10등이 나오면 끝냄)
			//12.모든 말의 경주가 종료되엇는지 여부 검사
			if(Horse.currentRank == horses.length) {
				break;	//말의 등수가 10(horses.length의 배열길이)이 나오면 빠져나오세요~~
			}
			
///////////////////////////////////////////////////////

			//20. 출력창에서 깔끔하게 보이게 하기
			for(int i = 1; i<10; i++) {
				System.out.println();
			}
			
///////////////////////////////////////////////////////
			//13.출력
			for(int i =0; i<horses.length ; i++) {
				System.out.print(horses[i].getHorseName() + " : ");
				for(int j = 1 ; j<=50; j++) {	//구간1-50
					
					if(horses[i].getLocation()==j) {	//말의 현재 위치 여부 검사
						System.out.println(">");	//현재위치일때는 >로 표시
					}else {	//현재 위치가 아닐 떄는
					System.out.println("_"); //현재 위치가 아닐 경우에는 "_"로표시
				}
				}
				System.out.println();//줄바꿈
			}
			
///////////////////////////////////////////////////////
			//14.시간차를 두고 출력하기위해 0.1초를 넣어줌
			try {
				Thread.sleep(100);	//시간차를 두고 출력하려고.
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}
}
///////////////////////////////////////////////////////
	


















