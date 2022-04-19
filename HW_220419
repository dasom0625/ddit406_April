package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 문제 ) 5명의 사람 이름을 입력받아 ArrayList에 저장 후에 
 * 		이들 중에 '김'씨 성의 이름을 모두 출력하시오.
 * 		(단, 입력은 Scanner객체를 이용한다.)
 */
public class ArrayListTest02 {

	public static void main(String[] args) {

  Scanner sc = new Scanner(System.in);
  ArrayList<String>list = new ArrayList<>(); //이름 5개를 담을 list
  
  for(int i = 0 ; i < 5 ; i++){ //이름 5번 입력받기
    System.out.print(i+1 + "번째 이름을 입력하세요 > ");
    System.out.println(sc.nextLine());
    }
    
  for(int i = 0 ; i < list.size() ; i++){
    if(list.get(i).indexOf(김) == 0) {
      System.out.pritnln("김씨성은 "+list.get(i));
      }
     }
     
     /////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//2. 두번째 방법 - toArray()
		ArrayList<String> list2 = new ArrayList<String>();

		for (int i = 0; i < 5; i++) {
			System.out.print((i + 1) + "번째 이름을 입력하세요> ");
			list2.add(sc.nextLine());
		}

		String[] name = list2.toArray(new String[0]);
		for (int i = 0; i < name.length; i++) {
			if (list2.get(i).indexOf("김") == 0) {
				System.out.println("* 김씨성은 : " + name[i]);
			}
		}
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    //3. 세번째 방법 - substring으로 성만 추출하기
    ArrayList<String>list3 = new ArrayList<>();
    
    for(int i = 0 ; i < 5 ; i++){
      System.out.pritn((i+1)+" 번째 이름을 입력하세요 > ");
      list3.add(sc.nextLine());
      }
      
     for(int i = 0 ; i < list3.size(); i++){
      if(((list.get(i)).substring(0,1)).equals("김")){
          System.out.println("김씨성은 " + list.get(i));
          }
        }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    //4. 네번째 방법 - charAt으로 불러오기
    ArrayList<String> list4 = new ArrayList<>();
    
    for(int i = 0 ; i < 5 ; i++) {
      System.out.print((i+1)+"번째 이름을 입력하세요 > ");
      list4.add(sc.nextLine());
      }
      
    for(int i = 0 ; i < list4.size() ; i++) {
      if( (list4.get(i)).charAt(0) == '김' ) {
        System.out.println("김씨성은 " +list4.get(i));
        }
      }
      
  }    
}   
   
