package c_statement;

import java.util.Scanner;

public class baseball3 {

	public static void main(String[] args) {

		Scanner s = new Scanner (System.in);
		System.out.println("야구게임을 시작합니다.");
		System.out.println("================");
		
		
		
		int r1, r2, r3 = 0;						//세자리수 랜덤값 받아오기(답)
		do {
		r1 = ((int)(Math.random()*9)+1);
		r2 = ((int)(Math.random()*9)+1);
		r3 = ((int)(Math.random()*9)+1);
		}while(r1 == r2 || r2==r3 || r1==r3);		//r1,r2,r3이 중복되면 안되므로 ||일 경우 다시 do 실행문을 돌게 만듬.
		
		
		int com = r1*100+r2*10+r3;
	
		
		System.out.println("정답은 "+ com +" 입니다.");
		
		
		int user = 0;
		do {
		int Strike = 0;			//Strike, Ball, OUt 출력
		int Ball = 0;
		int Out = 0;
		
		
		System.out.println("================");
		System.out.print("세자리 숫자를 입려하세요.>");				
		user = Integer.parseInt(s.nextLine());		//유저의 입력값 받아오기.
		
		
		int u1 = user/100;							//유저가 입력한 100의 자리
		int u2 = (user-(u1*100))/10;				//유저가 입력한 10의 자리
		int u3 = user-(u1*100)-(u2*10);				//유저가 입력한 1의 자리
		
		
		if(r1 == u1) {							//첫번째 숫자 비교
			Strike++;
		} else if (r1 == u2 || r1 == u3) {
			Ball++;
		} else {
			Out++;
		}
		
		if(r2 == u2) {							//두번쨰 숫자 비교
			Strike++;
		} else if (r2 == u1 || r2 == u3) {
			Ball++;
		} else {
			Out++;
		}
		
		if(r3 == u3) {							//세번째 숫자 비교
			Strike++;
		} else if (r3 == u1 || r3 == u2) {
			Ball++;
		} else {
			Out++;
		}
		
	
		System.out.println(user + ":" + "\t" + Strike +" Strike/ " + Ball + " Ball/ " + Out + " Out");
		
		
		}while (user != com);
		System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
		System.out.println("Wow~! Super 3 Strik~!");
		System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
		
		
		
	}

}
