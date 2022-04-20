package kr.or.ddit.basic;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		Browser b = new Browser();
		b.goURL("1.네이버");
		b.history();

		b.goURL("2.인스타그램");
		b.history();
		
		b.goURL("3.카카오톡");
		b.history();

		b.goURL("4.구글");
		b.history();
		
		System.out.println("뒤로가기 후 > ");
		b.goBack();
		b.history();
		
		System.out.println("뒤로가기 후 > ");
		b.goBack();
		b.history();
		
		System.out.println("뒤로가기 후 > ");
		b.goBack();
		b.history();

		System.out.println("앞으로가기 후 > ");
		b.goForward();
		b.history();
		
		System.out.println("새로운 사이트 접속 후  > ");
		b.goURL("5.DDIT");
		b.history();
	}

}


// 웹 브라오저의 앞으로 가기, 뒤로가기 기능 구현하기 (Stack이용)
class Browser{
	private Stack<String> back;		//이전 방문 내역이 저장 될 스택 변수
	private Stack<String> forward;	//다음 방문 내역이 저장 될 스택 변수
	private String currentURL;		//현재 보고있는 페이지
	
	//생성자 생성
	public Browser() {
		back = new Stack<String>();
		forward = new Stack<String>();
		currentURL = "";
	
	}
	
//사이트를 방문하는 메서드 : 인수값으로 방문할 URL을 지정한다.
	public void goURL(String url) {
		System.out.println(url + "사이트에 접속합니다...");

		if(currentURL!=null && !"".equals(currentURL) ) {	//현재페이지가 null이 아니고, 현재페이지가 공백(보고있는 페이지가 있다는 뜻)이 아니면의 조건.=>즉, 보고있는 페이지가 있으면
			back.push(currentURL);
			forward.clear();   //forward스택 데이터 전체 삭제(새로운 사이트로 접속할 경우 사용됨)
		}
		
		currentURL = url; //현재페이지를 back스택에 추가한다.
	}
	
	
//뒤로가기 메서드
	public void goBack() {
		//back 스택이 비어있는지 검사하기 =>isEmpty();사용
		if(!back.isEmpty()) {	//back스택이 비어있지 않으면..
			forward.push(currentURL); 	//현재 페이지를 forward스택에 추가
			currentURL = back.pop();    //back스택에서 1개의 요소를 꺼내와 현재페이지로 한다.
		}
	}
//앞으로가기 메서드
	public void goForward() {
		//goForward 스택이 비어있는지 검사하기 
		if(!forward.isEmpty()) {
			back.push(currentURL); //현재 페이지를 back스택에 추가
			currentURL = forward.pop();
		}
	}
//방문기록 확인하는 메소드
	public void history() {
		System.out.println();
		System.out.println("-----------------");
		System.out.println("   방    문    기    록   ");
		System.out.println("-----------------");
		System.out.println("back    > "+ back);
		System.out.println("현재          > "+ currentURL);
		System.out.println("forward > "+ forward);
		System.out.println("-----------------");
		
	}

		
		
}
