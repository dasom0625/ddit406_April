//쓰레드가 수행되는 시간을 체크해보자.

package kr.or.ddit.basic;

public class ThreadTest03 {

	public static void main(String[] args) {

//2.
		Thread th = new Thread(new MyRunner());
		//start하기 전과 후에 System.currentTimeMillis()를 이용하여 시간을 저장해서 수행되는 시간을 체크 할 수 있다.
		//1970년1월1일0시0분(표준시간)부터 경과한 시간을 0.0001초(1000분의 1초) 단위로 반환한다.
		long startTime = System.currentTimeMillis();//쓰레드를 시작한 시간
		th.start();
		
		try {
			th.join();//현재 실행중인 쓰레드에서 대상이 되는 쓰레드(여기서는 th변수)가 끝날때까지 기다린다.//즉,th가 끝날때까지 기다려.
		} catch (InterruptedException e) {
			
		}
		
		long finishTime= System.currentTimeMillis();//쓰레드가 끝난시간
		System.out.println("경과시간 : "+ (finishTime - startTime));
	}

}
//////////////////////////////////////////////////////////
//1.
class MyRunner implements Runnable {
	@Override
	public void run() {
		long sum = 0L;
		for (long i = 1L; i <= 1_000_000_000L; i++) {	//숫자자리수가 길때 _를 쓰면, ,의 역할과 비슷한데 출력할땐 나오지 않는다.
			sum += i;
		}
		System.out.println("합계 : " + sum);

	}
}
