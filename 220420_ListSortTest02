package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListSortTest02 {

   public static void main(String[] args) {
      //내부정렬기준 적용(Comparable,compareTo)
      
      ArrayList<Member> memList = new ArrayList<Member>();
      
      memList.add(new Member(1, "홍길동", "010-111-1111"));
      memList.add(new Member(5, "이순신", "010-222-1111"));
      memList.add(new Member(9, "성춘향", "010-333-1111"));
      memList.add(new Member(3, "강감찬", "010-444-1111"));
      memList.add(new Member(6, "일지매", "010-555-1111"));
      memList.add(new Member(2, "변학도", "010-666-1111"));
   
      System.out.println("정렬전.....");
      for(Member mem : memList) {
         System.out.println(mem);
      }
      
      System.out.println("------------------------------------------");
      Collections.sort(memList);
      System.out.println("회원번호 내림차순 정렬 후...");
      for(Member mem : memList) {
         System.out.println(mem);
      }
      
      //2-1.과제 
      System.out.println("-------------------------------------------");
      Collections.sort(memList, new sortNameAsc());
      System.out.println("회원 이름 오름차순 정렬 후...");
      for(Member name1 : memList ) {
    	  System.out.println(name1);
      }
   }
}

//2.회원 이름의 오름차순으로 정렬될 수 있는 외부 정렬 기준 클래스를 작성하시오.(Comparator / Compare();)
//2-1.과제 클래스명 sortNameAsc
class sortNameAsc implements Comparator<Member>{

	@Override
	public int compare(Member name1, Member name2) {
		if(name1.getName().compareTo(name2.getName())>0) {
			return 1;
		}else if(name1.getName().compareTo(name2.getName())<0) {
			return -1;
		}else
		
		return 0;
	}
}




//회원 관리를 위한 Member클래스 작성하기
//회원번호의 오름차순으로 정렬될 수 있는 내부 정렬 기준을 추가해서 작성한다.
class Member implements Comparable<Member>{
   private int num; //회원번호
   private String name; //회원이름
   private String tel; //전화번호
   
   
   //생성자
   public Member(int num, String name, String tel) { 
      super();
      this.num = num;
      this.name = name;
      this.tel = tel;
   }


   public int getNum() {
      return num;
   }


   public void setNum(int num) {
      this.num = num;
   }


   public String getName() {
      return name;
   }


   public void setName(String name) {
      this.name = name;
   }


   public String getTel() {
      return tel;
   }


   public void setTel(String tel) {
      this.tel = tel;
   }


   @Override    //1
   public String toString() {
      return "Member [num=" + num + ", name=" + name + ", tel=" + tel + "]";
   }


   //회원번호의 오름차순을 기준으로 만든다.
   @Override
   public int compareTo(Member mem) {    
   if(this.num >mem.getNum()) {		//this.num(2)-mem.getNum(1)이면 양수이므로 순서를 바꿔야 하므로 1을 반납
      return 1;
   }else if (this.num <mem.getNum()) {	//this.num(1)-mem.getNum(2)이면 음수이므로 순서가 유지되서 -1을 반납
      return -1;
   }else {      
      return 0;}
   }

   
   
   
   
   
   
   
}
