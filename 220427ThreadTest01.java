package kr.or.ddit.basic;

public class ThreadTest01 {

	public static void main(String[] args) {

		//1.싱글쓰레드 프로그램 만들기 (*을 200개, $를 200개 출력해보기)
		for (int i = 1; i <= 200; i++) {	System.out.print("*");	}
		
		System.out.println();

		for (int i = 1; i <= 200; i++) {	System.out.print("$");	}
		
		
		
		
	}

}
