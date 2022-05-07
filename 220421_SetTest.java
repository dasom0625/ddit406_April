/*
 * List와 Set의 차이점
 * 
 *  1. List 
 *   - 데이터의 순서(index)가 있다.
 *   - 중복되는 데이터를 저장 할 수 있다.
 *   
 *  2. Set
 *   - 데이터의 순서(index)가 없다.
 *   - 중복되는 데이터를 저장 할 수 없다.
 */
package kr.or.ddit.basic;

import java.util.HashSet;

public class SetTest {

	public static void main(String[] args) {

		HashSet hs1 = new HashSet();
		
		//1.Set에 데이터를 추가할 때도 add();메서드를 사용한다.
		hs1.add("DD");
		hs1.add("AA");
		hs1.add(2);
		hs1.add("CC");
		hs1.add("BB");
		hs1.add("1");
		hs1.add(3);
		
		System.out.println("1-1. Set의 size > "+hs1.size());
		System.out.println("1-2. Set의 데이터 > "+hs1); //내가 집어넣은 순서와 꺼내오는 순서가 다르다.
		System.out.println();
		
		//2.Set에는 중복되는 데이터를 추가하면, flase를 반환하고, 데이터를 추가하지 않는다.
		//2-1. 중복되지 않은 데이터 집어넣기
		boolean isAdd = hs1.add("FF");
		System.out.println("2-1.중복되지 않은 데이터 > "+isAdd);
		System.out.println("2-1.Set 의 데이터 > "+hs1);
		System.out.println();
		
		//2-2. 중복된 데이터 집어넣기
		isAdd=hs1.add("DD");
		System.out.println("2-2.중복된 데이터 > "+isAdd);
		System.out.println("2-2.Set 의 데이터 > "+hs1);
		System.out.println();
		
		//3.Set의 데이터 수정하기(수정이 불가능하기 때문에 해당 데이터를 삭제하고 새로 집어넣는 방법으로 해야 함.)
		//4.Set 삭제하는 메서드 : remove(삭제할 자료); => 반환값 : 삭제성공 : true / 삭제실패 : false
		//					: clear(); => Set에 있는 모든 데이터 삭제
		//3&4. "FF"데이터를 "EE"로 변경하기
		hs1.remove("FF");
		System.out.println("3&4-1. FF 삭제 후 Set > "+hs1);
		hs1.add("EE");
		System.out.println("3&4-2. EE 추가 후 Set > "+hs1);
		System.out.println();
		
		hs1.clear();
		System.out.println("3&4-3. clear() 사용 후 Set > "+hs1);
		System.out.println();
		
		
////////////////////////////////////////////////////////////////////////////////////////////		
/*[ Iterator ]
 * 
 * Set에는 데이터 순서 (index)가 없기 때문에 List처럼 index로 데이터를 하나씩 불러 올 수 없다.
 * 그래서 데이터를 하나씩 얻기 위해서는 Iterator형 객체로 변환해서 꺼내와야한다.
 * 
 * **iterator도 순서가 없지만 일단 데이터를 일렬로 정렬하여 포인터를 이용하여 포인터가 가장 위에서 부터 데이터를 가리키고 있다.
 * **포인터를 이동시키고 나서 데이터를 꺼내오고 출력함.
 * 
 * - iterator(); : Set형의 데이터를 Iterator형 객체로 변환해주는 메서드
 * 
 */
		
	System.out.println("===============Iterator시작==================");
	Iterator it = hs1.iterator();	//Set의 데이터를 Iterator로 변환하기
	
	//Iterator의 hasNext()메서드 
	//	=>Iterator의 포인터가 가리키는 곳의 다음번째에 데이터가 있는 지 검사하는 메소드.
	//	=>반환값 : 데이터가 있으면 true / 없으면 false를 반환
	while(it.hasNext()) {	
		//Iterator의 next()메서드 
		//	=>Iterator의 포인터를 다음 위치로 이동시킨 후 이동한 위치의 데이터를 반환함.
		System.out.println(it.next());
	}
	System.out.println("===============Iterator마침==================");
	
////////////////////////////////////////////////////////////////////////////////////////////
	//Iterator대신 향상된 for문 사용해서 꺼내오기
	for(Object obj : hs1) {	//hs1의HashSet에 제네릭을 쓰지 않았기 때문에  Object를 씀. 만약 Integer같은 제네릭이 있으면 Integer로 쓰면됨.
		System.out.println("Iterator 대신 for문으로 꺼내오기 > " +obj);
	}
////////////////////////////////////////////////////////////////////////////////////////////
	//Set유형의 자료를 List형으로 변환해서 꺼내오기
	ArrayList testList = new ArrayList(hs1); //제네릭 없이 해보기
	for(int i = 0 ; i < testList.size(); i++) {
		System.out.println("Iterator 대신 List형으로 변환해서 출력 > " +testList.get(i));
	}
////////////////////////////////////////////////////////////////////////////////////////////		
	System.out.println("\n=================Set 예제==================");
	//1. 우리반 학생들 중 번호를 이용하여 추첨하는 프로그램을 작성해보자.
	//	  번호는 1번부터 25번까지 있고, 추첨 할 인원은 3명이다.
	//	 당첨자를 출력해보시오.
	
	//난수형 만들기 공식 1. 최소값~최대값 사이의 정수형 난수 만들기
	//(int)(Math.random()*(최대값-최소값+1)+최소값);
	
//	Random random = new Random();
	
	HashSet<Integer> testSet = new HashSet<>();
	while (testSet.size() < 3) {
		testSet.add((int) (Math.random() * (25 - 1 + 1) + 1));
	}
	}

}
