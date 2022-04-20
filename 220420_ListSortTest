package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * 정렬과 관련된 interface는 Comparable,Comparator 이렇게 두가지가 있다.
 * 
 * Comparable(내부정렬) : Collection에 추가되는 데이터 자체에 정렬 기준을 넣고 싶을 때 구현하는 인터페이스이다.
 * 				(이것은 내부 정렬 기준이라고 한다.)
 * 				=>CompareTo();메서드를 재정의 해야 함.
 * 
 * Comparator(외부정렬) : 외부에 별도로 정렬 기준을 구현하고 싶을 때 사용하는 인터페이스이다.
 * 				(이것은 외부 정렬 기준이라고 한다.)
 * 				=>Compare();메서드를 재정의 해야 함.
 * 
 * String클래스, Wrapper클래스, Date클래스, File클래스 등에는 내부 정렬 기준이 구현되어 있다. 
 * (이 내부 정렬 기준은 기본적으로 오름차순 하도록 구현되어 있다.)
 * 
 */


public class ListSortTest01 {

	public static void main(String[] args) {

		ArrayList<String>list = new ArrayList<>();
		
		list.add("이다솜");
		list.add("김다솜");
		list.add("박다솜");
		list.add("정다솜");
		list.add("솜다솜");
		
		System.out.println("list정렬 전 > "+ list);
		
		//정렬은 Collections.sort();메서드를 이용하여 정렬한다.
		//Colledtions.sort()메서드는 기본적으로 내부 정렬(괄호안의 것들) 기준으로 정렬한다.
		
		Collections.sort(list);
		System.out.println("정렬 후 > " + list);	//오름차순 기준으로 정렬됨.
		
/////////////////////////////////////////////////////////////////////////////////////////////////////
		
		Collections.shuffle(list);	//shuffle : 데이터를 섞어주는 것
		System.out.println("shuffle이용 후 > "+ list);
		
		//외부 정렬기준을 적용해서 정렬하기
		Collections.sort(list, new Desc()); //list를 Desc(외부정렬기준)를 통해 정렬
		
		System.out.println("내림차순 정렬 후 : "+ list);
		
	}
}
		
////////////////////////////////////////////////////////////////////////////////////////////////////		

		//정렬방식을 정해주는 Class를 작성(외부정렬 기준 클래스라고 함)
		//=> Comparator();인터페이스를 구현해서 작성한다.
		class Desc implements Comparator<String>{
			
			//compare()메서드를 이용해서 정렬화고자 하는 기준을 정한다.
			
	        /*
			 * compare()메서드의 반환값
			 * 반환값이 0 <=> 두 값이 같다.
			 * 반환값이 양수 <=> 두 값의 순서를 바꾼다.
			 * 반환값이 음수 <=> 두 값의 순서를 바꾸지 않는다.
			 * 예) 오름차순일 경우 => 앞의 값이 크면 양수, 같으면 0, 뒤의 값이 크면 음수가 반환되도록 구현한다.
			 */
			@Override
			public int compare(String str1, String str2) {	//sort에 있는 데이터 중 앞에 있는 데이터가 str1, 뒤에 있는 데이터가 str2
				//내림차순으로 정렬하고자 한다. 
				if (str1.compareTo(str2) > 0) { //데이터가 많아도 인접해 있는 데이터 두개를 가지고만 비교
					return -1;
				} else if (str1.compareTo(str2) < 0) {
					return 1;
				} else {
					return 0;
				}
//================>
//str1 - str2가 양수이면(>0) -1을 반환해서 순서를 바꾸지 않고, 
//str1 - str2가 음수이면 (<0) 1을 반환해서 순서를 바꿔줌.
//str1 = str2가 같으면 0을 반환해서 순서를 유지해줌.
				
				
				
			}

		}
