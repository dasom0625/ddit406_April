package e_oop.score2;

import java.util.Arrays;

public class Student {
//이 클래스는 학생 한명을 표현하는 클래스 //알바의 역할
//메소드 만들어두는 곳.
	//전역 변수
	String name;
	int kor;
	int eng;
	int math;
	int sum;
	double avg;
	int rank;
  //점수발생
	void createRandomScore() {
		kor = (int) (Math.random() * 101);
		eng = (int) (Math.random() * 101);
		math = (int) (Math.random() * 101);
	}
//한명의 합계
	int getSum() {
		return sum = kor + eng + math;
	}
//한명의 평균
double getAvg() {
	return avg = Math.round(getSum() / 3.0 * 100) / 100.00;
							//=>sum이라는 변수를 사용하지 않고 getSum()이라는 메소드를 이용
							//getSum()보다 ㅎetAvg()를 먼저 사용할 경우의 수를 대비하여...
}
//석차 (비교할 대상이 없어서 여기서 못구하는게 아니라,parameter로 비교할 대상을 받으면 구할 수 있음.)
int getRank(Student[] students) {
			//=>비교할 대상이 필요해서 parameter를 통해 대상을 받아 올 것이다.
	rank = 1;
	
	for(int i = 0 ; i <students.length ; i++) {
		if(getSum() < students[i].getSum()) {
			rank++;
		}
	}
	return rank;
}
//석차정렬, 과목별 합계, 과목별 평균 (학생한명이 할 수 있는 일이 아니라서 여기서 못함)

//출력(메소드를 이용하여  변수들을 묶어서 문자열로 Score로 넘겨주면 됨)
String getInfo() {
	return name + "\t"+kor+"\t"+eng+"\t"+math+"\t"+sum+"\t"+avg+"\t"+rank;
}
}
=========================================================================================================
package e_oop.score2;

import java.util.Arrays;

public class Score {

	public static void main(String[] args) {
  	String[] StudentNames = { "권흥종", "김민정", "김서인", "김수원", "김은태"
			, "문승제", "박다혜", "신현국", "안은실", "윤정영"
			, "은주영", "이가은", "이규범","이다솜", "이상학"
			, "이소정", "이재원", "이정후", "이희경", "임정은"
			, "전윤미", "최민정", "최지연", "최지은", "황명성" };

	Student[] students = new Student[StudentNames.length];

	for(int i = 0; i<students.length; i++) {
		students[i] = new Student();
		students[i].name = StudentNames[i];
		students[i].createRandomScore();
		students[i].getSum();
		students[i].getAvg();
	}
	
	//석차
	for(int i = 0; i<students.length; i++) {
		students[i].getRank(students);
	}

	//석차정렬(버블정렬)
	for(int i = 0 ; i <students.length-1; i++) {
		boolean changed = false;
		for(int j= 0 ; j < students.length -i -1; j++) {
			if(students[j].getSum() < students[j + 1].getSum()) {
				Student temp = students[j];
				students[j] = students[j + 1];
				students[j + 1] = temp;
				changed =true;
			}
		}
		if(!changed) {
			break;
		}
	}

	// 과목별 합계
	int[] sums = new int[3];
	for (int i = 0; i < students.length; i++) {
		// 4. 과목별 합계
		sums[0] += students[i].kor;
		sums[1] += students[i].eng;
		sums[2] += students[i].math;
	}
	double[] avgs = new double[3];
	for (int i = 0; i < 3; i++) {
		avgs[i] = Math.round((double) sums[i] / students.length * 100) / 100.0;
	}

	System.out.println("이름\t국어\t영어\t수학\t합계\t평균\t석차");

	for (int i = 0; i < students.length; i++) {
		System.out.println(students[i].getInfo());
	}
	System.out.print("과목합계");
	for (int i = 0; i < sums.length; i++) {
		System.out.print("\t" + sums[i]);
	}
	System.out.print("\n과목평균");
	for (int i = 0; i < avgs.length; i++) {
		System.out.print("\t" + avgs[i]);
	}
}
}
