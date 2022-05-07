//쓰레드의 상태를 출력하는 예제
package kr.or.ddit.basic;

public class ThreadTest09 {

	public static void main(String[] args) {
		//3.
		TargetThread target = new TargetThread();
		
		displayThreadSate th = new displayThreadSate(target);
		
		th.start();
		

	}

}
//2.TargetThread의 상태값을 출력하는 쓰레드
class displayThreadSate extends Thread{
	private TargetThread target; 
	
	//생성자
	public displayThreadSate(TargetThread target) {
		this.target = target;
	}
	
	@Override
	public void run() {
		while(true) {	//무한반복문 만들기
			//쓰레드의 현재 상태값 구하기
			Thread.State state = target.getState();	//이게 쓰레드의 상태값을구하는 메서드임
			System.out.println("Thread의 상태값 : "+state);
			
			if(state == Thread.State.NEW) {	//쓰레드의 상태가 NEW상태이면??
				target.start();
			}
			if(state == Thread.State.TERMINATED) { //작업이 다 끝낸상태라면?(쓰레드의 상태가 종료상태라면?)
				break;
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}
	
}

//1. 쓰레드 상태의 검사 대상이 되는 쓰레드
class TargetThread extends Thread {
	
	@Override
	public void run() {
		//무언가가 쭉 나온다는걸 표현하기 위해..
		for(long i = 1L ; i<=10_000_000_000L ; i++) {}	//시간 지연용
			
			try {
				Thread.sleep(1500);//1.5초동안 기다려~~!
				//└>(출력해보면, 1.5초동안 위에 dispalyThreadSate에 있는 Thread.sleep(500)인 0.5초마다 스레드의 상태가 timed_waiting이 출력된다.)
				
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		
		for(long i = 1L ; i<=10_000_000_000L ; i++) {} //시간 지연용
	}
}
