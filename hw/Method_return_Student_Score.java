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

	//이 클래스는 학생 한명을 표현하는 클래스 //알바의 역할


	//student에 메서드만들기
	//student는 학생 한명이 할 수 있는 일...
	
	//메서드 : 학생이 할 일 (학생이름 받기, 점수받기, 합계 받기, 평균받기, 석차받기)
	//파라미터 : 일을 하기위해 필요한 것(학생이름 넣기, 학생별 점수, 과목별 점수...?)
	//리턴타입 : 일을 하고 난 후 돌려주는것 (학생이름 알려주기, 점수 알려주기, 합계랑 평균 알려주기, 석차알려주기)
	

	//1.학생들의름
	
	// 2. 랜덤점수
	void random() {
		kor = (int) (Math.random() * 101);
		eng = (int) (Math.random() * 101);
		math = (int) (Math.random() * 101);
	}

	// 3. 합계
	int sum() {
		sum = kor + eng + math;
		return sum;
	}

	// 4. 평균
	double avg() {
		avg = Math.round((double) sum / 3 * 100) / 100.00;
		return avg;
	}

================================================================================================================
package e_oop.score2;

import java.util.Arrays;

public class Score {

	public static void main(String[] args) {

		// 메서드 호출해서 사용
		String[] names = { "권흥종", "김민정", "김서인", "김수원", "김은태"
				, "문승제", "박다혜", "신현국", "안은실", "윤정영"
				, "은주영", "이가은", "이규범","이다솜", "이상학"
				, "이소정", "이재원", "이정후", "이희경", "임정은"
				, "전윤미", "최민정", "최지연", "최지은", "황명성" };

		Student[] member = new Student[names.length];

		Student st = new Student();

		System.out.println("이름 \t국어\t수학\t영어\t합계\t평균\t석차");
		System.out.println("====================================================");

		for (int i = 0; i < names.length; i++) {
			member[i] = new Student();
			// 1. 과목 점수 받아오기.
			member[i].random();

			// 2. 학생별 합계
			member[i].sum();

			// 3. 학생별 평균
			member[i].avg();
		}
		
		
		//과목별 합계와 평균
		int[] subSum = new int[3];
		for (int i = 0; i < names.length; i++) {
			// 4. 과목별 합계
			subSum[0] += member[i].kor;
			subSum[1] += member[i].eng;
			subSum[2] += member[i].math;
		}

		// 5. 과목별 평균
		double[] subAvg = new double[3];
		for (int i = 0; i < 3; i++) {
			subAvg[i] = Math.round((double) subSum[i] / 25 * 100) / 100.0;
		}

		// 6. 학생 석차
		for (int i = 0; i < names.length; i++) {
			for (int j = 0; j < names.length; j++) {
				if (member[i].sum < member[j].sum) {
					member[i].rank++;
				}
			}
		}

		// 출력
		for (int i = 0; i < names.length; i++) {
			System.out.print(names[i] + "\t" + member[i].kor + "\t" + member[i].eng + "\t" + member[i].math + "\t"
					+ member[i].sum + "\t" + member[i].avg + "\t" + member[i].rank + "\n");
		}
		System.out.println("=====================================================");
		System.out.print("과목 합계 :");
		for (int i = 0; i < 3; i++) {
			System.out.print(subSum[i] + "\t");
		}
		System.out.print("\n과목평균 : ");
		for (int i = 0; i < 3; i++) {
			System.out.print(subAvg[i] + "\t");
		}

	---------------------------------------------------------------------------------------
  출력 값 : 
  이름 	국어	수학	영어	합계	평균	석차
====================================================
권흥종	49	32	6	87	29.0	20
김민정	54	46	37	137	45.67	10
김서인	95	77	91	263	87.67	0
김수원	75	0	61	136	45.33	11
김은태	65	37	15	117	39.0	14
문승제	37	20	58	115	38.33	15
박다혜	2	8	38	48	16.0	23
신현국	84	32	67	183	61.0	5
안은실	26	2	3	31	10.33	24
윤정영	46	2	90	138	46.0	9
은주영	64	83	92	239	79.67	2
이가은	16	60	83	159	53.0	6
이규범	63	76	93	232	77.33	3
이다솜	19	2	42	63	21.0	22
이상학	45	5	81	131	43.67	12
이소정	11	7	56	74	24.67	21
이재원	68	29	2	99	33.0	19
이정후	44	4	67	115	38.33	15
이희경	25	43	44	112	37.33	17
임정은	54	38	55	147	49.0	7
전윤미	50	33	28	111	37.0	18
최민정	1	44	84	129	43.0	13
최지연	25	79	37	141	47.0	8
최지은	90	97	65	252	84.0	1
황명성	81	48	85	214	71.33	4
