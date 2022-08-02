package j_collection;

import java.util.ArrayList;

public class Score {

	
	
	public static void main(String[] args) {

		//학생
		String[] student = {"이정후", "은주영", "박다혜", "이다솜", "윤정영", 
     			"이가은", "이상학", "신현국", "김은태", "황명성", 
     			"이재원", "문승제", "권흥종", "이규범", "안은실", 
     			"이희경", "오세영", "김민정", "최민정", "전윤미", 
     			"김수원", "이소정", "임정은", "최지은", "최지연"};

		ArrayList<String>name = new ArrayList<String>();
		
		for(int i =0 ; i <student.length ; i++) {
			name.add(student[i]);
		}

		
		//25명의 7과목의 점수
		ArrayList<ArrayList<Integer>> member25 = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> score7 = new ArrayList<Integer>();
	
		for (int i = 0; i < 25; i++) {
			score7 = new ArrayList<Integer>();
			for(int j=0 ; j<7 ; j++) {
				score7.add((int) (Math.random() * 101));
			}
			member25.add(score7);
//			System.out.println(score7);	
		}

		// 25명의 각각 합계와 평균
		ArrayList<Integer>sums25 = new ArrayList<Integer>();
		ArrayList<Double>avgs25 = new ArrayList<Double>();

		for (int i = 0; i < member25.size(); i++) {
			int sum = 0;
			for (int j = 0; j < member25.get(i).size(); j++) {
				sum += member25.get(i).get(j);
			}
			sums25.add(sum);
			avgs25.add(Math.round(((double) sum/ member25.get(i).size())*100)/100.0);
		}
//		System.out.println(sums25 +"\n"+avgs25);
		
		//과목별 합계와 평균
		ArrayList<Integer>subsums7 = new ArrayList<Integer>();
		ArrayList<Double>subavgs7 = new ArrayList<Double>();
		for(int i = 0 ; i < member25.get(i).size() ; i++) {
			int subsum = 0;
			for (int j = 0; j < member25.size(); j++) {
				subsum += member25.get(j).get(i);
			}
			subsums7.add(subsum);
			subavgs7.add(Math.round(((double) subsum/ member25.size())*100)/100.0);
		}
//		System.out.println("\n"+subsums7 + "\n" + subavgs7);

		
		// 석차
		ArrayList<Integer> rank = new ArrayList<Integer>();
		
		for (int i = 0; i < sums25.size(); i++) {
			rank.add(1);
			for (int j = 0; j < sums25.size(); j++) {
				if(sums25.get(i)<sums25.get(j)) {
					rank.set(i,rank.get(i)+1);
				}
			}
		}
		
		System.out.println("--------------------------------------------------------------------------------------");
		System.out.println("이름\t국어\t영어\t수학\t사회\t과학\tOracle\tJava\t합계\t평균\t석차");

		System.out.println("--------------------------------------------------------------------------------------");
//		for(int i = 0 ; i<name.size(); i++) {
//			System.out.println();
//		}
		//이름 출력
		for(int i = 0 ; i< name.size(); i++) {
			System.out.print(name.get(i) + "\t");
		//점수 출력
			for(int j= 0 ; j<member25.get(i).size(); j++) {
				System.out.print(member25.get(i).get(j)+"\t");
			}
		//점수 합계, 평균, 석차 출력
			System.out.print(sums25.get(i) +"\t"+avgs25.get(i)+"\t"+rank.get(i));
			System.out.println("");
		}
		//과목 합계
		System.out.print("과목합계 ");
		for(int i =0 ; i< subsums7.size();i++) {
			System.out.print(subsums7.get(i)+"\t");
		}
		//과목 평균
		System.out.print("\n과목평균 ");
		for(int i= 0 ; i< subavgs7.size();i++) {
			System.out.print(subavgs7.get(i)+"\t");
		}
	}

}

/////////////////////////////////////////////////////////////////////////////
출력값 : 
--------------------------------------------------------------------------------------
이름	국어	영어	수학	사회	과학	Oracle	Java	합계	평균	석차
--------------------------------------------------------------------------------------
이정후	88	31	61	10	64	36	93	383	54.71	11
은주영	43	64	90	62	74	88	52	473	67.57	2
박다혜	51	20	22	61	63	39	23	279	39.86	22
이다솜	45	63	53	57	89	84	99	490	70.0	1
윤정영	65	14	59	15	92	92	79	416	59.43	7
이가은	61	25	39	83	65	47	30	350	50.0	14
이상학	96	91	31	14	52	25	52	361	51.57	13
신현국	72	30	63	49	55	24	13	306	43.71	17
김은태	75	72	74	35	6	7	66	335	47.86	16
황명성	21	21	98	79	87	65	100	471	67.29	3
이재원	48	18	92	48	90	73	69	438	62.57	5
문승제	1	54	40	25	55	10	100	285	40.71	20
권흥종	92	98	57	69	54	79	5	454	64.86	4
이규범	17	19	78	96	28	52	11	301	43.0	18
안은실	52	74	80	3	78	43	55	385	55.0	10
이희경	64	8	4	89	8	65	40	278	39.71	23
오세영	76	10	43	20	65	35	33	282	40.29	21
김민정	91	50	94	47	33	55	17	387	55.29	9
최민정	11	21	88	26	38	40	52	276	39.43	24
전윤미	67	36	39	8	48	4	33	235	33.57	25
김수원	6	19	86	51	92	12	72	338	48.29	15
이소정	28	70	43	69	78	65	18	371	53.0	12
임정은	71	19	4	20	86	79	16	295	42.14	19
최지은	10	48	95	59	57	97	57	423	60.43	6
최지연	2	12	55	89	98	85	48	389	55.57	8
과목합계 1253	987	1488	1184	1555	1301	1233	
과목평균 50.12	39.48	59.52	47.36	62.2	52.04	49.32	
