package kr.or.ddit.basic.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/*
   10마리의 말들이 경주하는 프로그램을 작성하시오.
   
   말은 Horse라는 이름의 쓰레드 클래스로 작성하는데 이 클래스는 말이름(String), 현재위치(int), 등수(int)를 멤버변수로 갖는다.
   그리고 이 클래스는 등수를 오름차순으로 처리할 수 있는 내부 정렬기준이 있다. (Comparable 인터페이스 구현)
   
   경기구간은 1 ~ 50 구간으로 되어있다.
   
   경기 중 중간 중간에 각 말들의 위치를 나타낸다.
   예)
   01번 말 -------->-----------------------------------------
   02번 말 ---------------->---------------------------------
   ...
   10번 말 ------------>-------------------------------------
   
   경기가 끝나면 등수 순으로 출력한다.
 */

public class ThreadTest14 {
   public static Random rnd = new Random();
   public static ArrayList<Horse> horses = new ArrayList<>();
   public static int rank = 1;

   public static void main(String[] args) {
      for(int i = 1; i<= 10; i++) {
         horses.add(new Horse(String.format("%02d번 말", i)));
      }
      for(Horse horse : horses) {
         horse.start();
      }
      DisplayHorseRacing dhr = new DisplayHorseRacing();
      dhr.start();
      try {
         dhr.join();
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      
      System.out.println("경기 끝!");
      System.out.println("최종 등수 : ");
      
      Collections.sort(horses);
      for(Horse horse : horses) {
         System.out.println(horse);
      }
   }

}

class DisplayHorseRacing extends Thread {
   @Override
   public void run() {
      int endRacingHorse = 0;
      do {
         endRacingHorse = 0;
         System.out.println();
         System.out.println();
         System.out.println();
         for(Horse horse : ThreadTest14.horses) {
            System.out.print(horse.getHorseName() + " ");
            if(horse.isAlive()) {
               for(int i = 0; i < 50; i++) {
                  if(horse.getPosition() != i) System.out.print(" ");
                  else System.out.print(">");
               }
               System.out.print("|");
            }else {
               if(horse.getRank() != 0) System.out.print(" {" + horse.getRank() + "등} ");
               endRacingHorse++;
            }
            System.out.println();
         }
         try {
            Thread.sleep(100);
         } catch (Exception e) {
            e.printStackTrace();
         }
      }while(endRacingHorse < ThreadTest14.horses.size());
   }
}

class Horse extends Thread implements Comparable<Horse> {
   private int rank = 0;
   private String horseName;
   private int position = 0;
   
   public int getRank() {
      return rank;
   }

   public int getPosition() {
      return position;
   }

   public String getHorseName() {
      return this.horseName;
   }
   
   public Horse(String horseName) {
      this.horseName = horseName;
   }

   @Override
   public String toString() {
      return String.format("%02d등\t%6s", this.rank, this.horseName);
   }

   @Override
   public void run() {
      for(int i = 0; i < 50; i++) {
         this.position = i;
         try {
            Thread.sleep(ThreadTest14.rnd.nextInt(300));
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
      this.rank = ThreadTest14.rank ++;
   }

   @Override
   public int compareTo(Horse h) {
      if(this.rank < h.getRank()) return -1;
      else if(this.rank > h.getRank()) return 1;
      else return 0;
   }
   
}
