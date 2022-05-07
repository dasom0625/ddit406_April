//wait()와 notify()를 사용해보자

package kr.or.ddit.basic;

public class ThreadTest18 {

	public static void main(String[] args) {
		//6.wait(),notify()를 이용한 두 쓰레드에서 번갈아 한번씩 실행하는 예제
		//wait(),notify(), notifyAll()은 동기화 영역에서만 사용 가능하다.
		workObject workobj = new workObject();
		
		ThreadA th1 = new ThreadA(workobj);
		ThreadB th2 = new ThreadB(workobj);
		
		th1.start();
		th2.start();
		

	}

}
//3. WorkObject의 a()메서드를 호출하는 쓰레드
class ThreadA extends Thread{
	private workObject workobj;
	//4.생성자
	public ThreadA(workObject workobj) {
		this.workobj = workobj;
	}
	@Override
	public void run() {
		for(int i = 0 ; i<10; i++) {
			workobj.a();//a()메서드 호출
		}
		//6.2의 notify()를 깨워주기 위해 필요함.
		synchronized (workobj) {
			workobj.notify();
		}
		
	}
}

//5.workObject의 b()메서드를 호출하는 쓰레드
class ThreadB extends Thread{
	private workObject workobj;
	
	public ThreadB(workObject workobj) {
		this.workobj = workobj;
		
	}
	@Override
	public void run() {
		for(int i = 0 ; i<10; i++) {
			workobj.b();
		}
		//6.2번의 notify를 깨워줄 객체가 필요
		synchronized (workobj) {
			workobj.notify();
		}
	}
}

//1. 공통으로 사용할 클래스 만들기
class workObject{              	
	public synchronized void a() {//동기화 처리한 a()메서드
		System.out.println("a()메서드 실행중...");
		
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}
	
//2.	
		public synchronized void b() {//동기화 처리한 a()메서드
			System.out.println("b()메서드 실행중...");
			
			notify();
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
		
}
