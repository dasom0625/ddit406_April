/*
 * 문제 ) Set을 이용하여 숫자야구 게임 프로그램을 작성해보자.
 * 		컴퓨터의 숫자는 난수를 이용하여 구한다. (이 때, Set을 이용하며 출력은 x)
 * 		(출력 할 때 스트라이크는 'S', 볼은 'B'로 나타낸다.)
 * 
 *  예시)
 *  	컴퓨터의 난수 : 9 5 7	=>출력은 하지 않는다.
 *  
 * 	실행 및 출력 예시)
 *  	숫자 입력 받기 => 3 5 9
 *  	3 5 9 => 1S 1B
 *  	숫자 입력 받기 => 7 8 9
 *   	7 8 9 => 0S 2B
 *   	숫자 입력 받기 => 9 5 7
 *   	9 5 7 => 3S 0B
 *   	축하합니다.
 *   	당신은 3번만에 맞췄군요!
 */

package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BaseBallTest {
	ArrayList<Integer>numList; 	//난수가 저장될 List
	ArrayList<Integer>userList; //사용자가 입력한 값이 저장 될 List
	
	Scanner scan = new Scanner(System.in);
	
	int S;	//스트라이크
	int B; 	//볼

////////////////////////////////////////////////////////////////////////////////////////	
	public void gameStart() {
		//난수만드는 메서드 호출
		creatNum();
		
		//확인용
		System.out.println("컴퓨터 랜덤수 : " + numList);  //제대로 되는지 확인후 정식으로 할 때는 지우면 됨.
		
		//몇번만에 맞췄는지 저장되는 변수 선언
		int count = 0 ; 
		
		//3스트라이크가 아니면 계속 진행되게 do-while활용
		do {
			count++;	//한번할때마다 count증가
			inputNum(); //사용자 입력하는 메서드 호출
			
			ballCount();//판정하는 메서드 호출
			
		}while(S!=3);
		
		System.out.println();
		System.out.println("축하합니다! 당신은 "+count +"번만에 정답을 맞추었습니다.");
		
	}
///////////////////////////////////////////////////////////////////////////////////////////	
	
	//1~9사이의 서로 다른 난수 3개를 만들어서 List에 저장하는 메소드 (Set이용)
	public void creatNum() {
		Set<Integer>numSet = new HashSet<Integer>();
		
		//1~9사이의 난수 3개 만들기
		while (numSet.size()<3) {
			numSet.add((int)(Math.random()*9+1));
		}
		
		//만들어진 난수들 List에 저장
		numList = new ArrayList<Integer>(numSet);
		
		//List의 데이터를 shuffle로 섞어주기
		Collections.shuffle(numList);
	}
///////////////////////////////////////////////////////////////////////////
	
	//사용자에게 3개의 정수를 입력받아 List에 저장하는 메서드
	public void inputNum() {
		//입력한 정수가 저장 될 변수 세개 선언
		int num1,num2,num3; 
		
		//입력한 정수 중복검사하여 중복 될 경우 다시 입력하게 하기=>do~while문으로 묶는다.
		do {
		System.out.println("숫자 입력 > ");
		num1 = scan.nextInt();
		num2 = scan.nextInt();
		num3 = scan.nextInt();

		if(num1==num2 ||  num1 == num3 || num2 ==num3) {
			System.out.println("중복되는 숫자는 입력 할 수 없습니다. 다시 입력하세요");
		}
		}while((num1==num2 ||  num1 == num3 || num2 ==num3));
		
		
		//입력한 정수를 Lsit에  저장
		userList = new ArrayList<Integer>();
		
		userList.add(num1);
		userList.add(num2);
		userList.add(num3);
	}
///////////////////////////////////////////////////////////////////////////
	//스트라이크와 볼을 판정하고 결과를 출력하는 메서드
	public void ballCount() {
		//스트라이크와 볼 초기화
		S = 0;
		B = 0;
		
		for (int i = 0; i < numList.size(); i++) {
			for (int j = 0; j < userList.size(); j++) {
				if (numList.get(i) == userList.get(j)) { // index와 관계없이 같은 값이있는지 검사
					if (i == j) { // 인덱스까지 같은지 검사
						S++;
					} else {
						B++;
					}
				}
			}
		}

		
		//결과 출력하기
		System.out.println(userList.get(0)+","+userList.get(1)+","+userList.get(2)+ 
				" => "+" Strike : "+ S + "/ Ball : "+ B);
	}
	
///////////////////////////////////////////////////////////////////////////
	
	public static void main(String[] args) {
		new BaseBallTest().gameStart();
		
	}
}
