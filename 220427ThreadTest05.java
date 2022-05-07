package kr.or.ddit.basic;

import javax.swing.JOptionPane;

public class ThreadTest05 {

	public static void main(String[] args) {
		//1. 싱글쓰레드를 이용한 게임
		//1-1. 사용자로부터 데이터 입력받기
		String str = JOptionPane.showInputDialog("아무거나 입력하세요 .");
		System.out.println("입력한 값 > "+str);	//이때 취소버튼 누르면  null이 나온다. 
		
		for(int i = 10; i>=1 ; i--) {

			System.out.println(i);
			try {
				Thread.sleep(1000);	//1초동안 멈춰있으세요!!
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}

}
