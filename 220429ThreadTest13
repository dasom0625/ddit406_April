//Thread의 stop()메서드를 호출하면 해당 쓰레드가 바로 멈춘다.
//이 때, 사용하던 자원을 정리하지못하고, 프로그램이 종료되어 나중에 실행되는 프로그램에 영향을 줄 수 있다.
//그래서 stop()메서드는 비추천으로 되어있지롱

package kr.or.ddit.basic;

public class ThreadTest13 {

	public static void main(String[] args) {
///////////////////////////////////////////////////////////////////////////		
//5.쓰레드를 실행시킬곳을 만들어보세요.
		ThreadStopTest1 th1 = new ThreadStopTest1();
		th1.start();
		
		//6.1초에 하나씩 나오게 설정해야겠죠?
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
		//7.
		th1.setStop(true);//true값을 주면 쓰레드가 멈추겠죠?
		
		//8. 우리 th1.setStop(true)대신에 stop()메서드를 한번 써볼까요?
//		th1.stop();	//이건 비추천이라서 이렇게 나오지롱 신기하지?
					//근데 실행해보면 끝까지 실행못하고 중간에 끝나버린다?
					//그니까 정상적으로 사요하고 싶으면 이거 쓰지말고 그냥 th1.setStop(true)쓰라고~~
	
		//9.또한가지는 interrupt를 이용할 수 있다??밑으로 가봐
		
		
///////////////////////////////////////////////////////////////////////////		
		//12.밑에서 왔지? 어서와~이제 실행해볼까?//14.도 여기서 해~
		ThreadStopTest2 th2 = new ThreadStopTest2();
		th2.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		th2.interrupt();//얘는 끼어드는 애야ㅋㅋ...그게 무슨말인지...ㅠㅠㅠ
		//멈추게 할때 아래의 
	}

}


///////////////////////////////////////////////////////////////////////////		

//1. 쓰레드를 멈추게 하는 연습용 쓰레드를 만들어보자
class ThreadStopTest1 extends Thread{
	private boolean stop;	//변수를 하나주구요
	//2.
	public void setStop(boolean stop) { //setter를 하나 만들죠
		this.stop = stop;
	}
	//3.
	@Override
	public void run() {
		while(!stop) {//4.
			System.out.println("쓰레드 실행중....");//쓰레드가 반복적으로 작동한다고 치구요
		}
		//쓰레드의 작업이 끝났으면 사용하던 자원을 정리하는 부분이 필요하겠죠?
		System.out.println("자원 정리해라");//여기선 그냥 출력으로 그걸 대신할게요?
		System.out.println("쓰레드는 종료시켜-_-");//
	}
}

///////////////////////////////////////////////////////////////////////////		
//9.위에서 왔지? 어서와~ interrupt()메서드를 이용하여 쓰레드를 멈추게 해보자!
class ThreadStopTest2 extends Thread{
	//10. 변수없이 그냥 run 먼저 재정의 할게~~
	@Override
	public void run() {
//		11.근데 또 방법이 두가지가 있어..
//		방법 1은 interrupt()메서드와 sleep()메서드를 이용하는건데.
		try {	//우선 try-catch로 묶고
			while(true) {	//똑같이 무한 반복문 실행시켜어
				System.out.println("interrupt용으로 실행하고 있다..");	//얘는 처리하고싶은애야..
				Thread.sleep(1);	//1000분의 1초만 쉬어봐(일시정지)
									//일시정지 상태에서 interrupt()메서드가 실행되면 InterruptedException 이 발생한다.
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.out.println("interrupt용 자원 정리한다?");
		System.out.println("interrupt용 쓰레드도 종료한다?");	//이제 다시 위로 올라가
	
///////////////////////////////////////////////////////////////////////////		
		//13. 두번쩨방법이야.
		while(true) {	//무한반복 똑같이 써주고, 
			System.out.println("interrupt용 쓰레드2 실행중....");
			
			//intterupt()메서드가 호출되었는지 되지 않았는지 여부를 검사하는 거야아
			//검사방법이 두가지가 있는데
			//검사 방법 1번은 쓰레드의 인스턴스 메서드인 isIntterupted()메서드를 이용하는거.
			//			is Interrupted()메서드는 interrupt()메서드가 호출되면 true값을 반환해.
			if(this.isInterrupted()==true) {
				break;
			}
			
///////////////////////////////////////////////////////////////////////////		
//15.검사방법 2번재는 Thread의 정적 메서드인 interrupted()메서드를 이용하는거야.
//		intterupted()메서드도 interrup()가 호출되면 true를 반환해.
		if(Thread.interrupted()==true) {
			break;
		}

	}
		System.out.println("interrupt용 자원 정리한다?");
		System.out.println("interrupt용 쓰레드도 종료한다?");	
}
}
