package d_array;

import java.util.Arrays;
import java.util.Scanner;

public class Students {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		String[] student = { "권흥종", "김민정", "김서인", "김수원", "김은태", "문승제", "박다혜", "신현국", "안은실", "윤정영", "은주영", "이가은", "이규범",
				"이다솜", "이상학", "이소정", "이재원", "이정후", "이희경", "임정은", "전윤미", "최민정", "최지연", "최지은", "황명성" };
	
		
		int count = 0;
		System.out.println("=======제비뽑기=======");
		System.out.print("뽑을 인원수를 입력하세요.");	
					
		count = Integer.parseInt(s.nextLine());		//count = 뽑을 인원수를 콘솔에서 입력받아 옴. 
		
		
		String [] s_name =new String [count]; //s_name 배열에 입력한 카운트만큼 인덱스 
		
		for (int i = 0; i < count ; i++) { 		//입력한 인원수만큼 반복
		int a = 0;
		a = (int) (Math.random()*25)+ 1;	
		s_name[i]=student[a-1] ;
							//랜덤으로 이름 받기
		}	
			System.out.println("뽑은 인원 수 > " + count + " / " + "명단 > " + Arrays.toString(s_name));
		


	}

}

=============================================================================================================================
//선생님답
package d_array;

import java.util.Arrays;
import java.util.Scanner;

public class Student_teacher {

	public static void main(String[] args) {


		Scanner s = new Scanner(System.in);

		String[] students = { "권흥종", "김민정", "김서인", "김수원", "김은태", "문승제", "박다혜", "신현국", "안은실", "윤정영", "은주영", "이가은", "이규범",
				"이다솜", "이상학", "이소정", "이재원", "이정후", "이희경", "임정은", "전윤미", "최민정", "최지연", "최지은", "황명성" };

		System.out.print("몇명을 뽑으시겠습니까?> ");
		int count = s.nextInt();

		String[] pick = new String[count];
		int pickCount = 0;
		do {
			int random = (int) (Math.random() * students.length);
			boolean flag = true;
			for (int i = 0; i < pick.length; i++) {
				if (students[random].equals(pick[i])) {
					flag = false;
				}
			}

			if (flag) {
				pick[pickCount++] = students[random];
			}
		} while (pickCount < count);

		System.out.println(Arrays.deepToString(pick));
	}
}
