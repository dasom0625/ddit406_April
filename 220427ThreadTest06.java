package kr.or.ddit.basic;

import javax.swing.JOptionPane;

public class ThreadTest06 {

	public static void main(String[] args) {
//3. 		
		Thread th1 = new DataInput();
		Thread th2 = new CountDown();
		
		th1.start();
		th2.start();
	}
}
////////////////////////////////////////////////////////////////////////////////

//1. 데이터를 입력하는 쓰레드 만들기
class DataInput extends Thread{
	
	//4. 입력여부를 확인하기 위한 변수 선언.-쓰레드에서 공통으로 사용할 변수(1,2번만 실행하면 값을 입력해도 카운트다운이 계속되거든....)
	public static boolean inputCheck = false;	//입력이 완료되면 true로 변경 된다.
	
	@Override
	public void run() {

		String str = JOptionPane.showInputDialog("아무거나 입력 해 보던지~.~");
	
		inputCheck = true; //4-1.입력이 완료되었으므로 true값으로 변경한다.
		
		System.out.println("뭐라고 쓸래? > "+str);	//이때 취소버튼 누르면  null이 나온다. 
		
	}
}

////////////////////////////////////////////////////////////////////////////////

//2. 카운트 다운을 진행하는 쓰레드
class CountDown extends Thread{
	

	
	@Override
	public void run() {
		for(int i = 10; i>=1 ; i--) {
			//3-2.입력이 완료되었는지 여부를 검사한다. -> 입력이 완료되었으면 쓰레드를 종료시킨다.
			if(DataInput.inputCheck==true) {
				return;	//run()메소드가 끝냈으니 자기자리로 돌아가라고 return하기
			}
			System.out.println(i);
			try {
				Thread.sleep(1000);	//1초동안 멈춰있으세요!!
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
		System.out.println("10초가 지나버렸지 뭐야~~~~프로그램 종료시킨닷");
		System.exit(0);
	}
}
