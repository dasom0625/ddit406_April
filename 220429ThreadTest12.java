//yield()메서드 연스

package kr.or.ddit.basic;

public class ThreadTest12 {

	public static void main(String[] args) {
		//5.
		YieldTest th1 = new YieldTest("1번쓰레드");
		YieldTest th2 = new YieldTest("2번쓰레드");
		
		th1.start();
		th2.start();
		
		//6.
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.out.println("*****************************111111");	//위치표시를 위해서 해봣오
		
		//7.
		th1.work = false;

		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.out.println("*****************************222222");	//위치표시를 위해서 해봣오
	
		
		//9.
		th1.work = true;
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.out.println("*****************************333333");	//위치표시를 위해서 해봣오
	
		
		
		
		//8.
		th1.stop = true;
		th2.stop = true;
	
	}

}
//////////////////////////////////////////////////////////////////
//1. yield()메서드 연습용 쓰레드
class YieldTest extends Thread{
	//2. 스탑변수와 워크 변수 선언먼저 해주기
	public boolean stop = false;
	public boolean work = true;
	
	public YieldTest(String name) {
		super(name); //3.쓰레드의 이름을 설정
		
	}
	
	//4. run()만들기
	@Override
	public void run() {
		while(!stop) {
			if(work) {
				System.out.println(getName()+" ~~작업 중~~ ");
			}else {
				System.out.println(getName()+"양보좀 해주어어어어");
				Thread.yield();//9.양보를 해줘...
			}
		}
	System.out.println(getName()+"ㅌ  ㅏ ㄹ  ㅊ ㅜ ㄹ!!");
	}
}
