package kr.or.ddit.basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueueTest {
	/*
	 * Stack => 후입선출(Last In First Out) ex.메서드(실행 후 리턴), ctrl+z (바로 뒤로 돌아감) call
	 * stack Queue => 선입선출(First In First Out) ex.프린터
	 * 
	 * Stack 과 QUeue는 LinkedList를 이용하여 사용할 수 있다.
	 */

	public static void main(String[] args) {
		/*
		 * stack의 명령어
		 * 1. 자료입력 : push (입력값);
		 * 2. 자료출력 : pop(); -> 스택에서 자료를 꺼내온 후 자료를 스택에서 삭제한다.
		 * 			  peek(); -> 삭제없이 자료를 꺼내온다.
		 */
		Stack<String> stack = new Stack<String>();
		
		stack.push("이정후");
		stack.push("박다혜");
		stack.push("이다솜");
		stack.push("안은실");
		
		System.out.println("현재 stack : "+stack);
		
		String data =  stack.pop();
		System.out.println("1.pop으로 꺼내온 값 : " + data); //첫번째 방법
		System.out.println("2.pop으로 꺼내온 값 : " + stack.pop()); //두번째 방법 
		
		stack.push("집에가자");
		System.out.println("3.추가 후 stack값 : " + stack);
		
		System.out.println("4.pop으로 꺼내온 값 : "+ stack.pop());
		System.out.println("5.pop으로 꺼내온 후 stack 값 : " + stack);
		
		stack.push("야자해야되나");
		System.out.println("6.삭제없이 peek으로 꺼내온 값 : "+ stack.peek());
		System.out.println("7.peek이후 현재 stack : " + stack);
		
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		
		/*
		 * Queue의 명령
		 * 1. 자료 입력 : offer(입력값)
		 * 2. 자료 출력 : poll() -> 자료를 Queue에서 꺼내온 후 그 자료를 Queue에서 삭제한다.
		 * 			   peek() -> 자료를 삭제없이 꺼내오는 것.
		 */
		System.out.println("======================================================================================");
		Queue<String>queue = new LinkedList<String>();
		queue.offer("안은실");
		queue.offer("이다솜");
		queue.offer("박다혜");
		queue.offer("이정후");
		
		System.out.println("1.현재 queue : " + queue);
		
		String temp = queue.poll();
		System.out.println("2.poll로 꺼내온 값 : "+ temp);
		System.out.println("3.현재 남은 queue 값 : " + queue);
		
		queue.offer("졸려요");
		System.out.println("4.현재 queue 값 : "+ queue);
		System.out.println("5.poll로 꺼내온 값 : "+ queue.poll());
		System.out.println("6.poll로 꺼내고 난 뒤 queue값 : " + queue);
		
		System.out.println("7.삭제없이 꺼내온 값 : " + queue.peek());
		System.out.println("8.peek이후의 queue값 : " + queue);
	}
}
