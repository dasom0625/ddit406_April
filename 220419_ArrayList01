package kr.or.ddit.basic;

import java.util.ArrayList;

public class ArrayListTest01 {

	public static void main(String[] args) {
		//ArrayList는 기본적으로 Vector와 사용법이 같다.
		
		ArrayList list1 = new ArrayList();
		
		//1. add();메서드를 이용해서 데이터를 추가한다.
		list1.add("aaa");
		list1.add("bbb");
		list1.add(123);
		list1.add('k');
		list1.add(true);
		list1.add(3.14);
		
		System.out.println("size : "+list1.size());	
		
		System.out.println("list1 : "+list1);
	
		//2. get(index);메서드로 데이터를 꺼내온다.
		System.out.println("*1번째 자료 : "+list1.get(1));
	
		//3. set();메서드로 데이터 변경하기.
		String temp = (String)list1.set(1, "zzz");
		System.out.println("*temp : "+temp);
		System.out.println("*1번째 자료바뀐거 확인 : "+ list1);
		
		//4. remove(index);로 삭제하기
		list1.remove(3);
		System.out.println("*3번째 index 삭제 후 list1 : " + list1);
		
		//4-1. remove("데이터");로 삭제하기
		list1.remove("aaa");
		System.out.println("*aaa가 삭제 된 list1 : "+list1);
		
		//5. 제네릭 사용
		System.out.println("-----------------------------------------------------------------------------");
		ArrayList<String>list2 = new ArrayList<String>();
		list2.add("AAAA");
		list2.add("BBBB");
		list2.add("CCCC");
		list2.add("DDDD");
		list2.add("EEEE");

		//5-1.for문을 이용하여 첨자와 함께 값 가져오기
		for (int i = 0; i < list2.size(); i++) {
			System.out.println("*"+ i + " 번째 : " + list2.get(i));
		}
		
		//5-2.향상된 for문
		for (String str : list2) {
			System.out.println("*" + str);
		}
		
		//6. contains("비교객체") : 리스트에 '비교객체'가 있으면 true / 없으면 false를 반환
		System.out.println("*DDDD 값 : "+list2.contains("DDDD"));
		System.out.println("*ZZZZ 값 : "+list2.contains("ZZZZ"));
		
		//7. indexOf("비교객체")
		//: 데이터를 찾을 때 앞에서 뒤쪽으로 검색
		//: 리스트에 '비교객체'가 있으면 '비교객체'가 위치한 'index값'을 반환
		//					 없으면 '-1'을 반환한다.
		System.out.println("-----------------------------------------------------");
		System.out.println("*DDDD값의 위치 : " + list2.indexOf("DDDD"));
		System.out.println("*ZZZZ값의 위치 : " + list2.indexOf("ZZZZ"));
		
		
		//8. lastIndexOf("비교객체")
		//: 데이터를 찾을 때 뒤에서 앞쪽으로 검색
		//: 리스트에 '비교객체'가 있으면 '비교객체'가 위치한 'index값'을 반환
		//					 없으면 '-1'을 반환한다.
		System.out.println("-----------------------------------------------------");
		System.out.println("*DDDD값의 위치 : " + list2.indexOf("DDDD"));
		System.out.println("*ZZZZ값의 위치 : " + list2.indexOf("ZZZZ"));
		
		//9. toArray(); 
		//:리스트 안의 데이터를 배열로 변환하여 반환한다.
		//=>기본적으로 Object형 배열로 변환한다.
		System.out.println("-----------------------------------------------------");
		Object[] strArr = list2.toArray();
		System.out.println("*배열의 개수 : " + strArr.length);
		
		//10. toArray(new 제네릭타입[0]); 
		//: 제네릭 타입형 배열로 반환한다.
		System.out.println("-----------------------------------------------------");
		String[] strArr2 = list2.toArray(new String[0]);
		for (int i = 0; i < strArr2.length; i++) {
			System.out.println(i + "번째 : " + strArr2[i]);
		}
		
	}

}
