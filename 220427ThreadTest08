//데몬쓰레드 연습 => 자동 저장하는 쓰레드

package kr.or.ddit.basic;

public class ThreadTest08 {

	public static void main(String[] args) {
		//5.
		AutoSave auto = new AutoSave();
		
		
		
		auto.setDaemon(true);//7.데몬쓰레드로 설정하기 -> ★★★★★반드시 start()메서드 호출 전★★★★★에 설정해줘야한다. 
							//이게 없으면, main쓰레드가 끝나도 아래의 AutoSave클래스쪽은 3초에 한번씩 계속 작동을 함.
							//이게 있으면, 설정한 시간인 20초뒤부터는 완전히 main쓰레드 종료와 함께 프로그램이 종료됨.
		
		auto.start();
		
		for(int i = 1 ; i<=20; i++) {
			System.out.println(i);
			try {
				//6.시간이 지나가는것처럼 보이게 하기 위해서 Thread.sleep만들어줌
				Thread.sleep(1000);
				
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
		System.out.println("main 쓰레드는 끝났당!");
	}

}


//1. 자동 저장하는 쓰레드 (3초에 한번씩 자동 저장하는 쓰레드)
class AutoSave extends Thread{
	
	//2.작업 내용을 저장하는 메서드
	public void save() {
		System.out.println("작업 내용을 저장해줄게^_^");
	}
	
	//3.
	@Override
	public void run() {
		while(true){	//무한루프형식을 반복문을 만든다.
			try {
				//4.3초짜리 Thread.sleep만들어주기
				Thread.sleep(3000);//3초에 한번씩 저장하려고 3초를 만듬
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			save();
		}
	}
	
}
