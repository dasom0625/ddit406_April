package b_operator;

import java.util.Scanner;

public class SimpleCalculator {

	public static void main(String[] args) {
		/*
		 * 두개의 숫자와 연산자를 입력받아 연산결과를 알려주는 프로그램을 만들어주세요.
		 */

		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫번째 숫자>");
		double n1 = Double.parseDouble(sc.nextLine());
		System.out.print("두번째 숫자>");
		double n2 = Double.parseDouble(sc.nextLine());
		
		System.out.print("연산자 입력>");
		String cal= sc.nextLine();
		
		//연산자에 +를 입력하면 n1+n2, -를 입력하면 n1-n2, *를 입력하면 n1*n2, /를 입력하면 n1/n2, %를 입력하면 n1%n2가 나오도록 출력
		double result = "+".equals(cal) ? n1+n2 :("-".equals(cal) ? n1-n2 : ("*".equals(cal) ? n1*n2 : ("/".equals(cal) ? n1/n2 : ("%".equals(cal) ? n1%n2 : 0))));
		
		System.out.println(result);
		
		
		
		//정답
		Scanner s = new Scanner (System.in);
		int x = Integer.parseInt(s.nextLine());
		System.out.print("연산자>");
		String l = s.nextLine();
		System.out.print("두번째 숫자>");
		int y = Integer.parseInt(s.nextLine());
				
				
		int res = l.equals("+")? x + y
				: l.equals("-")? x - y
				: l.equals("*")? x * y
				: l.equals("/")? x / y
				: x % y;
		System.out.println(x+""+ l+ "" + y + "=" + res);
		
		
	
	}

}
