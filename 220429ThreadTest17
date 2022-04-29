//Vector는 내부적으로 동기화처리가 이미 되어있다.
//arraylist는 내부적으로 동기화처가 되어있지 않다.
package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

/*
 * vector, hashtable등 예전부터 존재하던  Collection객체들은 내부에 동기화 처리가 되어있다.
 * 
 * 그런데, 새로 구성된 Collection들은 동기화 처리가 되어있지 않다. 
 * 그래서, 동기화가 필요한 프로그램에서는 이런 Collection들을 사용하려면 동기화 처리를 한 후 사용해야 한다.
 * 
 */
public class ThreadTest17 {

	//1. 
	private Vector<Integer> vec = new Vector<Integer>();
	//6.list만들어보기(리스트는 동기화 처리 안되어잇는거 아시쥬?)
	private List<Integer>list1 = new ArrayList<Integer>();
	
	//7. 동기화 처리한 List(오?신세계)
	private List<Integer>list2 = Collections.synchronizedList(new ArrayList<Integer>());
	
	//2.
	public void myStart() {
		//4. 익명구현제 만들기
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				for(int i =0; i<10000;i++) {
//					vec.add(i);
//					list1.add(i);
					list2.add(i);
				}
			}
		};
	
	//5. 
	Thread[] ths =  new Thread[] {
			new Thread(r),new Thread(r),new Thread(r),new Thread(r),new     Thread(r)};
	for(Thread th : ths) {
		th.start();
	}
	for(Thread th :ths) {
		try {
			th.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}
//	System.out.println("vec개수 : "+vec.size());
//	System.out.println("list1개수 : "+list1.size());
	System.out.println("list2개수 : "+list2.size());
}
	public static void main(String[] args) {
		new ThreadTest17().myStart(); //3.
	}

}
