package kr.or.ddit.basic;

import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
		//Collection 객체들은 객체만 저장 할 수 있다.
		// 기본자료형(int, char...)은 collection에 넣을때 자동으로 변환시켜줌

		// Vector : 자바 초창기부터 지원하는 객체로, 동기화(데이터를 보호할 목적으로 만든 것)처리가 되어 있다.

		// 객체 생성
		Vector v1 = new Vector();

		System.out.println("처음 size : " + v1.size());

		// 1. 데이터 추가하기 
		// : add메소드 사용 => add(추가할 데이터);
		// 반환 값 : 추가 성공 -> true / 추가 실패 -> false
		v1.add("aaaa");
		v1.add(new Integer(111)); // 래퍼클래스
		v1.add(123); // 오토박싱이 일어남.
		v1.add('a');
		v1.add(true);
		boolean r = v1.add(123.45);

		System.out.println("추가 후 size : " + v1.size());
		System.out.println("반환값 : " + r);

		// 1-2. 데이터 추가하기 
		// : addElement => addElement(추가할 데이터)
		// : 이전 버전의 프로그램도 사용할수 있도록 하기위해 남아있는 메서드
		v1.addElement("CCC");
		System.out.println("v1 : " + v1.toString()); // v1.toString() : add한 순서대로 v1에 들어있는 모든 데이터 불러오기
		System.out.println("v1 : " + v1); // toStrnig()은 생략가능 (위와 결과 똑같이 나옴)

		// 데이터 추가하기 3.
		// : add(index,"데이터");
		// => 'index'번째에 '데이터'를 끼워 넣는다.(덮어쓰기x)
		// => 'index'는 0번부터 시작한다.
		// => 반환값 없음
		v1.add(1, "kkk");
		System.out.println("v1 : " + v1);

/////////////////////////////////////////////////////////////////////////////////////////////////////////////

		// 데이터 꺼내오기 1.
		// : get(index); //꺼내오려는 값의 형태로 형변환 필요
		// => 'index'번째의 데이터를 꺼내와 반환한다.
		int data = (int) v1.get(2); // 오토 언박싱 작업이 이루어진다.
		System.out.println("꺼내온 index 2번째 데이터 : " + data);

////////////////////////////////////////////////////////////////////////////////////////////////////////////

		// 데이터 수정하기 1.
		// : set(index, 새로운 데이터) //수정하려는 값의 형태로 형변환 필요
		// => 'index'번째의 데이터를 '새로운 데이터'로 덮어 쓴다.
		// => 반환 값 : 변경되기 전인 원래의 데이터가 반환 됨.
		String temp = (String) v1.set(0, "ㅋㅋㅋㅋ");

		System.out.println("v1 : " + v1);
		System.out.println("원래의 데이터 : " + temp);

////////////////////////////////////////////////////////////////////////////////////////////////////////////

		// 데이터 삭제하기 1.
		// :remove(index)
		// =>'index'번째의 데이터를 삭제한다.
		// => 반환값 : 삭제 된 데이터
		String temp2 = (String) v1.remove(0);

		System.out.println("v1 : " + v1);
		System.out.println("*0번째 데이터 삭제 된 데이터 : " + temp2);

		// 데이터 삭제하기2.
		// :remove("삭제 할 데이터");
		// =>'삭제 할 데이터'를 찾아서 삭제한다.
		// =>'삭제 할 데이터'가 여러개이면 앞에서부터 삭제된다.
		// =>반환값 : 삭제성공 : true / 삭제실패 : false
		// =>'삭제할 데이터'가 '정수형'이거나 'char'형일 경우에는 반드시 객체로 변환해서 사용해야 한다.
		v1.remove("CCC");
		System.out.println("삭제 후 v1 : " + v1);

//		v1.remove(123); =>123번째의 index를 삭제하게 되는것으로 생각하기때문에, 객체화 시켜줘야 함.
//		v1.remove(new Integer(123));
		v1.remove(Integer.valueOf(123));
		System.out.println("*123을 삭제 후 v1 : " + v1);

//		v1.remove('a'); =>작은 따옴표로 문자를 감싸면 그것을 숫자로 생각하기때문에, 객체화 시켜줘야 함.
//		v1.remove(new Character('a'));
		v1.remove(Character.valueOf('a'));
		System.out.println("*'a'삭제 후 v1 : " + v1);
		
		v1.remove(true); //논리형 데이터 삭제
		System.out.println("*true 삭제 후 v1 : " + v1);
		
		v1.remove(123.45); //논리형 데이터 삭제
		System.out.println("*123.45 삭제 후 v1 : " + v1);
		
//============================================================================================================//
//============================================================================================================//
		/*
		 * 제네릭 타입 (Generic Type) 
		 * => 클래스 내부에서 사용할 데이터의 타입을 외부에서 지정하는 기법으로 
		 * 	    객체를 선언할 때 < >괄호 안에 그 객체의 내부에서 사용할 데이터의 타입을 정해주는 것.
		 * 	    이런식으로 선언하게 되면 지정한 데이터 타입 이외의 다른 종류의 데이터를 저장 할 수 없다.
		 * 	    이 때 제네릭으로 선언될 수 있는 데이터 타입은 클래스형이어야 한다.
		 * 	    그래서, int는 Integer, boolean은 Boolean, char는 Character등으로 대체해서 사용해야 한다.
		 * 
		 * 	  제네릭 타입으로 선언하게 되면 데이터를 꺼내올 때도 별도의 형변환이 필요없다.
		 */
		
		Vector<String> v2 = new Vector<String>();	//String만 저장할 수 있는 백터
		Vector<Integer> v3 = new Vector<>();	//int형만 저장할 수 있는 백터 =>new뒤에 Integer은 생략가능
		
		//1. 데이터 저장하기 
		v2.add("안녕하세요");
//		v2.add(100); //오류 : 다른 종류의 데이터를 저장 할 수 없다.
		
		//2. 데이터 꺼내오기
		String temp3 = v2.get(0);	//데이터를 꺼내올 때 형변환이 필요없음(왜? 제네릭타입으로 이미 타입을 지정해줬으니까)
		System.out.println("*v2의 0번째 값 : " + temp3);
		
		//3. 전체 데이터 삭제하기
		//: clear();
		v2.clear();
		System.out.println("*v2의 size : " + v2.size());
		
		v2.add("AAAA");
		v2.add("BBBB");
		v2.add("CCCC");
		v2.add("DDDD");
		v2.add("EEEE");
		
		Vector<String> v4 = new Vector<>();	//String만 저장할 수 있는 백터
		v4.add("BBBB");
		v4.add("EEEE");
		
		System.out.println("*v2 : "+v2);
		System.out.println("*v4 : "+v4);
		
		//4. 데이터 삭제하기 
		//: removeAll(Collection 객체);
		//=>현재 백터에 있는 데이터 중에서 'Collection객체'가 가지고 있는 데이터를 모두 삭제한다.
		//=>반환 값 : 삭제 성공 : true / 삭제 실패 : false
		v2.removeAll(v4);	//v2에 있는 데이터 중에서 v4와 같은 데이터를 모두 삭제한다.
		System.out.println("*v2에서 v4와 같은 값 삭제 후 : "+v2);
		
		System.out.println("--------------------------------------------------------");

		//5.백터의 데이터를 순서대로 모두 가져와 사용하고 싶으면 반복문을 사용하면 된다. (주로  for문을 사용)
		v2.clear();
		v2.add("AAAA");
		v2.add("BBBB");
		v2.add("CCCC");
		v2.add("DDDD");
		v2.add("EEEE");
		
		for (int i = 0; i < v2.size(); i++) {
			System.out.println(i + " 번째 데이터 : " + v2.get(i));
		}
		
		//5-1.첨자(index)가 굳이 필요없고 데이터만 필요하면 향상된 for문 사용해서도 가져올 수 있음.
		for (String str : v2) {
			System.out.println(str);
		}
		
		
		
	}

}
