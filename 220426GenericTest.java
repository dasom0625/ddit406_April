/*
 * 제네릭을 적용하는 클래스 만드는 방법
 * 형식 ) 
 * 		class 클래스명<제네릭타입 글자>{	//<>안에 보통 대문자 한글자 정도 씀.
 * 		제네릭 타입글자 변수명;	//변수 선언에 제네릭을 사용하는 경우
 * 		...
 * 	
 * 		제네릭 타입 글자 메서드명 (){	//반환값이 있는 메서드를 사용하는 경우
 * 
 * 		...
 * 		return 값;
 * 		}
 * 
 * 
 * 		반환값 타입 메서드명 (제네릭타입글자 변수명, ...){	//메서드의 매개변수에 제네릭을 사용하는 경우
 * 		...
 * 		...
 * 
 * 		}
 * 	}
 * 
 */

package kr.or.ddit.basic;

public class GenericTest {

	public static void main(String[] args) {

		//1-1.제네릭을 적용하지 않는 클래스
		nonGenericObj ng1 = new nonGenericObj();
		ng1.setData("병아리");
		
		nonGenericObj ng2 = new nonGenericObj();
		ng2.setData(178);
		
		String returnData = (String)ng1.getData();
		System.out.print("1-1. 문자열 반환값 returnData > "+returnData+"\n");
		int returnData2 = (Integer)ng2.getData();
		System.out.print("1-2. 숫자열 반환값 returnData2 > "+returnData2+"\n");
		int returnData3 = (int)ng2.getData();
		System.out.println("1-3.숫자열 반환값 이렇게 해도 되지롱\n(이건 바로 정수형 반환값) > "+ returnData2);
		System.out.println("=================================================================");
		
		nonGenericObj ng3 = new nonGenericObj();
		ng3.setData(13);
		String myData = (String)ng3.getData();
		System.out.println("myData > "+ myData);
		
/////////////////////////////////////////////////////////////////////////////////////////////
		//3.
		GenericObj<String>g1 = new GenericObj<String>();
		g1.setData("큰 병아리");
		GenericObj<Integer>g2 = new GenericObj<Integer>();
		g2.setData(31);
		
		String genericReturn = g1.getData();
		System.out.println("2. 형변환 없이 제네릭 클래스는 꺼내울 수 있지롱  > "+ genericReturn);
		
		int genericReturn1 = g2.getData();
		System.out.println("2-1. 제네릭 정수형 반환값 genericRetrun2 > "+ genericReturn1 );
		//4.
		GenericObj<Integer> g3 = new GenericObj<Integer>();
		g3.setData(333);
		
//		String MyData2 = g3.getData();
		 
		
	}

}

//////////////////////////////////////////////////////////////////////////////////////////////////
//1. 제네릭을 적용하지 않은 클래스
class nonGenericObj{
	private Object data;	//아무거나 쓰기위해 타입을 Object type으로 줌.

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	
}
//////////////////////////////////////////////////////////////////////////////////////////////////

//2. 제네릭을 적용하는 클래스
class GenericObj<T>{
	private T data;	//type에 제네릭으로 선언한 T를 작성
	
	public void setData(T data) {
		this.data = data;
	}
	
	public T getData() {
		return data;
	}
	
	
}
