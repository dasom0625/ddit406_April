//쓰레드에서 객체를 공통으로 사용하는 예제
//
//- 원주율을 계산하는 쓰레드와 
//  계산된 원주율을 출력하는 쓰레드가 있다.
//- 원주율을 저장하는 객체가 필요하다.
//	이 객체를 생성해서 두 쓰레드에서 공통으로 사용할 수 있도록 처리한다.

package kr.or.ddit.basic;

public class ThreadTest14 {

	public static void main(String[] args) {
		// 8.공통으로 사용할 객체 생성
		ShareData sd = new ShareData();
		
		//쓰레드 객체를 생성하고 공통으로 사용할 객체를 쓰레드에 주입한다.
		CalcPIThread th1 = new CalcPIThread();
		th1. setSd(sd);
		
		//출력하는 쓰레드
		PrintPIThread th2 = new PrintPIThread(sd);
		//=>이렇게 하면 두개의 쓰레드가 위의 8번에서 가지고 있는 shared data sd를 같이 쓰고 있는것.
		
		th1.start();
		th2.start();

	}

}
//////////////////////////////////////////////////////////////
//5. 원주율을 계산하는 쓰레드
class CalcPIThread extends Thread{
	private ShareData sd;


	//6. setter로 초기화하기
	public void setSd(ShareData sd) {
		this.sd = sd;
	}
	//7.run()메서드 만들기
	@Override
	public void run() {
		/*
		 *원주율  = (1/1 - 1/3 + 1/5 - 1/7 + 1/9-....)*4;
		 *			1  -  3  +  5  -  7  +  9  -....//
		 *			 
		 */
		double sum = 0.0;
		for(int i = 1 ; i<1000000000;i+=2) {//2씩 증가하게 한다. 
		if((i/2) %2 == 0) { //2로 나눈값의 나머지가 0이면 짝수
			sum += 1.0 / i;
		}else {	//몫이 홀수일때
			sum -=1.0/i;	
		}
			
		}
		sd.result = sum *4;	//원주율 계산 완료.
		sd.isOk = true;
	}
}


//////////////////////////////////////////////////////////////
//2.계산이 완료되면 계산된 원주율을 출력하는 쓰레드
class PrintPIThread extends Thread{
	private ShareData sd;//ShareData의 참조값이 저장될 변수 선언

	//3.생성자 만들기//생성자에서 공통으로 사용할 객체를 주입한다.
	public PrintPIThread(ShareData sd) {
		this.sd = sd;
	}
	
//4.	
@Override
public void run() {
	while(true) {
		if(sd.isOk == true) {//계산이 완료되었는지 여부 검사
			break;
		}
	}
	
	System.out.println();
	System.out.println("결과 : "+sd.result);
	System.out.println("PI : "+Math.PI);
}	
}





//////////////////////////////////////////////////////////////
//1. 원주율을 관리하는 클래스(공통으로 사용할 클래스)
class ShareData{
	public double result;		//계산된 원주율이 저장될 변수
	public volatile boolean isOk = false;	//계산이 완료되었는지 여부를 나타내는 변수(계산이 완료되면 true로 변경됨)
	//volatile : CPU의 각 코어에 캐시가 있는데 이 캐시를 사용하지 앟ㄴ고 메몰이ㅔ 데이터값을 입출력한다.
	
}










