//컴퓨터와 가위바위보를 진행하는 프로그램을 작성하시오
//컴퓨터의 가위바위보는 난수를 이용하여 결정하고,
//사용자의 입력은 showInputDialog()메서드를 사용해서 입력받는다.
//입력시간은 5초로 제한하고 카운트다운을 진행한다.
//5초안에 입력이 없으면 게임에 진것으로 처리한다.
//5초안에 입력이 있으면 승패를 구해서 출력한다.
//결과 예시 1) 5초안에 입력을 못했을 경우
//		=> --결과--
//		  시간초과로 당신이 졌습니다.
//결과 예시2) 5초안에 입력했을 경우
//		=>--결과--
//		컴퓨터 : 가위
//		사용자 : 바위
//		결과	 : 당신이 이겼습니다.
////////////////////////////////////////////////////////////////////


package kr.or.ddit.basic;

import javax.swing.JOptionPane;

public class ThreadTest07_teacher {
	//4.
	public static boolean inputCheck = false;
	
	public static void main(String[] args) {
		//2.
		Game cd = new Game();
		
		//3.컴퓨터의 가위바위보 정하기(난수를 이용한다.)
		String[]data = {"가위","바위","보"};
		int index = (int)(Math.random()*3);	//0부터 2사이의 난수만들기(가위바위보는 각각 0,1,2의 인덱스니까)
		String com = data[index];	//데이터의 인덱스번째값을 가져온다 라는 의미
		
		//5.사용자의 가위 바위 보 입력받기
		cd.start();//카운트다운 시작
		
		//7.입력한 값이 가위바위보라는 단어가 아닐때 다시 시작하게 함.
		String man = null;
		do {		
		man = JOptionPane.showInputDialog("가위 바위 보를 입력하세요.");
		}while(!(man!=null&&man.equals("가위")||man.equals("바위")||man.equals("보"))	);
		
		
		
		
		inputCheck = true;
		
		//6-1. 결과 판정하기=>컴퓨터기준
		String result = "";
//		if(com.equals(man)) {
//			result = "비겼습니다.";
//		}else if(com.equals("가위")&&man.equals("보")||
//			com.equals("바위")&&man.equals("가위")||
//					com.equals("보")&&man.equals("바위")){
//			result = "당신이 졌습니다.";
//		}else {
//			result = "당신이 이겼습니다.";
//		}
		//6-2. switch문으로 결과판정하기 => 컴퓨터기준
		switch(com+man) {
		case"가위가위" : 
		case"바위바위" :
		case"보보"    : result = "비겼습니다.";break;
		case"가위보"	 :
		case"바위가위" :
		case"보바위"	 : result = "당신이 졌습니다."; break;
		default : result = "당신이 이겼습니다"; 
			
		}
		
		System.out.println();
		System.out.println("=======================");
		System.out.println("\t\t결과");
		System.out.println("=======================");
		System.out.println("컴퓨터 : "+com);
		System.out.println("사용자 : "+man);
		System.out.println("결과 : "+result);
		
	}

}

////////////////////////////////////////////////////////////////////
//1. 카운트 다운을 진행하는 쓰레드
class Game extends Thread{
	
	@Override
	public void run() {
		for(int i = 5 ; i>=1; i--) {
			//5-2.입력이 완료되었는지 여부 확인
			if(ThreadTest07_teacher.inputCheck==true) {

				return;	//run()메소드 끝났으니 반환해주기.
			}
			System.out.println(i);
			try {
				Thread.sleep(1000);//1초동안 멈추기
			} catch (InterruptedException e) {

			}
		}
		System.out.println("시간초과로 you Loser");
		System.exit(0);
	}
}

////////////////////////////////////////////////////////////////////
