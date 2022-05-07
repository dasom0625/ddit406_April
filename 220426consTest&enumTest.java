/*
 * 상수는 변하지 않는 값
 */

package kr.or.ddit.basic;

public class ConsTest {
//색상과 관련된 상수들
public final static int RED = 1;
public final static int GREEN = 2;
public final static int BLUE = 3;

//카운트와 관련된 상수들
public final static int ONE = 1;
public final static int TWO = 2;
public final static int THREE = 3;

}




=========================================================



/*
 * enum(열거형) => 서로 관련있는 상수들의 집합을 나타낸다.
 * 			  => 클래스처럼 보이게하는 상수
 * 			  => 작성 방법 : 클래스 처럼 독립된 java파일에 만들수 있고, 하나의 java파일에 클래스오와 같이 만들수 있고,
 * 						 클래스 안에 내부 클래스처럼 만들수 있다.
 * 			  =>열거형의 속성 및 메서드
 * 				1) name()  	 => 열거형 상수의 이름을 문자열로 반환한다.
 * 				2) ordinal() => 열거형 상수의 정의된 순서값(index값)을 반환한다. (인덱스는 0부터시작)
 * 				3) valueOf("열거형상수명") => 지정한 열거형에서 '열거형 상수명'과 일치하는 열거형 상수를 반환한다.
 * 				4) 열거형이름.상수명 => valueOf()메서드와 결과가 같다.
 * 
 * 			  =>열거형 상수 정의하기
 * 				방법1) enum열거형 이름{상수명1 , 상수명2, 상수명3,....}
 * 				방법2) 열거형 상수에 값을 지정해서 사용할때...
 * 				   enum 열거형 이름 {
 * 					상수명1(값들...),
 * 				   	상수명2(값들...)
 * 					...
 * 					상수명n(값들...);
 * 					//'값들'이 저장될 변수들을 선언한다.
 * 					ex) private 자료형이름  변수명;
 * 						... 
 * 
 * 					//열거형의 생성자를 만든다.
 * 					//열거형의 생성자는 '열거형 상수'에 '값들'을 세팅하는 역할을 한다.
 * 					//그리고, 열거형 생성자는 묵시적으로 private이다.
 * 					
 * 					//'번수명'은 '값들'의 개수와 같고, 각각의 '값들'과 자료형이 맞아야 한다.
 * 					private 열거형이름 (자료형 변수명, ...){
 * 						위에 선언된 변수들을 초기화 하는 작업을 수행한다.
 * 						...
 * 				}
 * 				//위에 선언된 변수들의 값을 외부에서 사용할 수 있도록 getter메서드를 작성한다.
 * 
 * 		}
 */
package kr.or.ddit.basic;

public class EnumTest {
	public enum Color { RED, GREEN, BLUE }

	public enum Count { ONE, TWO, THREE }
	
	public enum Season{	//방법2 열거영 상수값을 지정해서 사용할때
		//방법2-1. 상수명(값들...)형식의 선언
		봄("3월부터 5월까지 ",15),	//"3월부터 5월까지"=>String month / 15=>int data
		여름("6월부터 8월까지",30),
		가을("9월부터 11월까지",17),
		겨울("12월부터 2월까지",-2);
		
		//방법2-2. 값들이 지정될 변수 선언
		private String info;
		private int temp;
		
		//방법2-3. 생성자
		Season(String month, int data){	//private가 생략됨
			info = month;	//자료들을 변수에 초기화 한다.
			temp = data;
			
		}
		//방법2-4. getter메서드 작성
		public String getinfo() {
			return this.info;
		}
	
		public int getTemp() {
			return this.temp;
		}

	
	}
	
	public static void main(String[] args) {
//		System.out.println("RED > "+ConsTest.RED);
//		System.out.println("THREE > "+ConsTest.THREE);
//		
//		if(ConsTest.RED ==ConsTest.ONE) {
//			System.out.println("맞냐?");	//실행은 잘되지만 결과가 잘못 나올 가능성이 있음.
//		}else {
//			System.out.println("안맞냐?");
//		}
		
		Color mycol = Color.valueOf("GREEN"); //Color.GREEN 으로 쓴느것과 같다.
		Count mycnt = Count.ONE;			  //Count.valueOf("ONE");으로 쓰는것과 같다.
		System.out.println("mycol 은 뭘까요~ > "+mycol.name()+"이지 뭐야");
		System.out.println("mycnt 은 뭘까요~ > "+mycnt.name()+"이지 뭐야");
		System.out.println("mycol의 ordinal > "+mycol.ordinal());
		System.out.println("mycnt의 ordinal > "+mycnt.ordinal());
		
		//서로 다른 종류의 열거형끼리의 비교는 불가하다. 그래서 오류가 뜸.
//		if(Color.RED == Count.ONE) {
//			System.out.println("어떻게 되죠?");
//		}
		
		if(mycol == Color.GREEN) {
			System.out.println("mycol == Color.GREEN의 결과는 같을껄?");
		}
		System.out.println("==========================================");
		
		//열거형은 switch문에서도 사용할 수 있다.
		switch(mycnt) {
		//case Count.ONE =>Switch에서 사용하는 열거형상수를 지정할때는 '열거형'이름은 생략하고
		//					'상수명'만 기술한다.
		case ONE : System.out.println("★ONE★"); break;
		case TWO : System.out.println("★★TWO★★"); break;
		case THREE : System.out.println("★★★THREE★★★"); break;
		
		}System.out.println("=========================================");
		
		//방법2-5. 
		Season ss = Season.valueOf("봄");
		System.out.println("name : "+ss.name());	//"봄"의 이름이 뭔지
		System.out.println("name : "+ss.ordinal());	//"봄"이 몇번째 데이터 인지
		System.out.println("info : "+ss.getinfo());	//"봄"이 몇월부터 몇월인지 
		System.out.println("temp : "+ss.getTemp());	//"봄"의 온도가 몇도인지
		System.out.println();
		
		//방법2-6.
		//열거형이름.values() => 모든 상수들을 배열로 반환한다.
		for(Season s : Season.values()) {
			System.out.println(s.name()+"=="+s+" > "+s.getinfo()+" / 온도 > "+s.getTemp());
		}
		
		for(Color col : Color.values()) {
			System.out.println(col + " > " + col.ordinal() );
		}
		
		
	}
	
}
