package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;

public class ThreadTest15 {

	public static void main(String[] args) {
		ShareObject sObj = new ShareObject();

//3. 똑같은쓰레드를 두개만들어 작동방식을 비교해보자
		TestThread th1 = new TestThread("첫번째쓰레드", sObj);
		TestThread th2 = new TestThread("두번째쓰레드", sObj);

		th1.start();
		th2.start();
	}
}

//2.
class TestThread extends Thread {

	private ShareObject sObj;

	public TestThread(String name, ShareObject sObj) {
		super(name); // 쓰레드의 이름 설정
		this.sObj = sObj;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			sObj.add();// 공통클래스의 더하기 값 호출
		}
	}

}

// 1. 공통으로 사용할 클래스
class ShareObject {

	private int sum = 0;
	
	//4. 메소드 자체에 synchronized를 붙여서 lock을 걸고 동기화 처리하기 
	//먼저 들어온 쓰레드 데이터가 락을걸고 먼저 다 처리를 하고나면 락이 해제되고, 그러고나면 다음 쓰레드가 재빠르게 들어온다. 
	
	
	//4-1.synchronized를 메서드에 붙여서 사용하는 방법
//	public synchronized void add() {
//		int n = sum;
//		n += 10;
//		sum = n;
//		System.out.println(Thread.currentThread().getName() + "합계 : " + sum);
//
//	}
	
	//4-2.메서드 안에다가 synchronized블럭을 만들어서 사용하는 방법
	public void add() {
		synchronized (this) {
		int n = sum;
		n += 10;
		sum = n;
		System.out.println(Thread.currentThread().getName() + "합계 : " + sum);
		}
	}
	
}
