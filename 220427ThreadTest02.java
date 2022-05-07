//		< 멀티쓰레드 프로그램 만들기 >
//		
//		Thread를 사용하는 방법 
//		
//		방법 1. Thread클래스를 상속하는 방법
//		Thread클랙스를 상속하는 class를 작성 한 후, 이 class의 인스턴스를 생성한다.
//		이 인스턴스의 start()메서드를 호출해서 실행한다.
//	
//		방법2. Runnable 인터페이스를 구현하는 방법
//		Runnable인터페이스를 구현한 class를 작성한 후 이 class의 인스턴스를 생성한다.
//		실행 할 Thread객체를 생성하는데 이 때 Thread객체의 생성자에 Runnable을 구현한 class의 인스턴스를 
//		인수값으로 넣어준다.
//		이 때 생성된 Thread객체의 start()메서드를 호출해서 실행한다.
//		
//		방법3. 익명구현체를 이용하는 방법(방법2와 관련있음)
		
//////////////////////////////////////////////////////////////////////////////////
package kr.or.ddit.basic;

public class ThreadTest02 {

	public static void main(String[] args) {
		
//방법1-1.인스턴스 생성하기
		MyThread1 th1 = new MyThread1();
		th1.start();
		
//////////////////////////////////////////////////////////////////////////////////
//방법 2-1.
		MyThread2 r = new MyThread2(); // 인스턴스 생성
		Thread th2 = new Thread(r); // Thread객체 생성
		th2.start();
		


//////////////////////////////////////////////////////////////////////////////////
//방법 3. 익명구현체를 이용하는 방법-1회용 방법 (한번밖에 생성이 안된다는 의미)
//구현이 일부만 되어있는건 추상클래스로, 객체를 생서할 수 없다.

		Runnable r2 = new Runnable() {
			@Override
			public void run() {
				for (int i = 1; i <= 200; i++) {
					System.out.print("@");
					// try-catch사용
					try {
						Thread.sleep(100); // Thread.sleep(시간); => 주어진 '시간'동안 작업을 잠시 멈춘다.
											// '시간'은 1초를 1000으로 표현한다.
					} catch (InterruptedException e) {
					}
				}
			}
		};
		Thread th3 = new Thread(r2);
		th3.start();

		System.out.println("=main메서드 끝=");// 이걸 실행하면, 메인메서드느 thread를 실행해주자마자 그 역할이 끝남.
	}
}
//////////////////////////////////////////////////////////////////////////////////
//방법1.에 해당하는 class작성(쓰레드를 상속하는 클래스)

//class MyThread1 extends Thread implements dd { =>이렇게 쓸 수 있다(쓰레드를쓰면서 상속도 받을 수 있음)
class MyThread1 extends Thread {
	// run이라는 메서드를 재정의한다. => run쓰고 ctrl+space
	@Override
	public void run() {
		// 이 run()메서드는 쓰레드가 처리할 내용을 기술하는 영역이다.
		for (int i = 1; i <= 200; i++) {
			System.out.print("*");
			// try-catch사용
			try {
				Thread.sleep(100);  // Thread.sleep(시간); => 주어진 '시간'동안 작업을 잠시 멈춘다.
									// '시간'은 1초를 1000으로 표현한다.
			} catch (InterruptedException e) {
			}
		}
	}
}
//////////////////////////////////////////////////////////////////////////////////
//방법 2.에 해당하는 class작성
class MyThread2 implements Runnable {	//자바의 단일 상속을 보완해주기 위해 Runnable이 나옴.
	// run()메서드를 재정의한다.
	@Override
	public void run() {
		// 이 run() 메서드는 쓰레드가 처리할 내용을 기술하는 영역이다.
		for (int i = 1; i <= 200; i++) {
			System.out.print("$");

			// try-catch사용
			try {
				Thread.sleep(100);  // Thread.sleep(시간); => 주어진 '시간'동안 작업을 잠시 멈춘다.
									// '시간'은 1초를 1000으로 표현한다.
			} catch (InterruptedException e) {
			}
		}
	}
}

//////////////////////////////////////////////////////////////////////////////////
//th1과 th2를 동시에 실행시키는게 쓰레드이다. 
//싱글 쓰레드 같은 경우에는, 위에꺼 먼저 실행하고 차례대로 실행한다면, 
//멀티 쓰레드의 경우에는 동시에 실행된다.
//그걸 보여주기 위해서 Thread.sleep(100)을 사용하여 어떻게 실행되는지 실행사항을 보여주는 것이다.
//
//start()는 쓰레드가 작업할 실행환경을 만들어주고, run()을 실행
//
//지금까지는 메인메서드가 끝나면 프로그램이 종료되어왔지만,
//멀티쓰레드는 run()이라는 메서드의 처리가 다 끝나야지만 프로그램이 끝난다.
