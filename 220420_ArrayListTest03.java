package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest03 {

	public static void main(String[] args) {
		// 문제) 5명의 별명을 입력 받아 ArrayList에 저장한 후 이들 중 별명의길이가 가장 긴 별명들을 출력하시오
				Scanner sc = new Scanner(System.in);
//		ArrayList<ArrayList<String>>list2 = new ArrayList<ArrayList<String>>();
		ArrayList<String>list = new ArrayList<>();
		
		
		for(int i = 0 ; i < 5 ; i++) {
			System.out.println((i+1)+"번째 별명 > ");
			String alias = sc.nextLine();
			list.add(alias);
		}
		
		//제일 긴 별명의 길이가 저장 될 변수를 선언한다.
		//->이 변수에는 리스트의 첫번째 데이터의 길이로 초기화한다.
		int maxlength = list.get(0).length();
		
		for(int i = 1; i < list.size(); i++) {
			if(maxlength < list.get(i).length()) { //
				maxlength = list.get(i).length();
			}
		}
	
		
		System.out.println("가장 긴 별명은 > ");
		for(String alias : list) {
			if(alias.length() == maxlength) {
				System.out.println(alias);
			}
		}
	
	}

}
