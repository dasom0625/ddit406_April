//3개의 쓰레드(솜솜, 후후, 달래)가 각각 알파벳A-Z까지 출력하는데 출력을 끝낸 순서대로 결과를 나타내는 프로그램 작성하기
//=>솜솜,후후,달래가 달리기 시합하는거랑 똑같음 ㅋㅋㅋㅋㅋㅋㅋㅋ
package kr.or.ddit.basic;

public class ThreadTest10 {

	public static void main(String[] args) {
		//5.
		DisplayCharacter[]charArr = new DisplayCharacter[] {
			new DisplayCharacter("달래"),	
			new DisplayCharacter("솜솜"),
			new DisplayCharacter("후후")	
		};
		
		//6.
		for(DisplayCharacter d : charArr) {
			d.start();
		}
		//7.
		try {
			for(DisplayCharacter d : charArr) {
				d.join();//세개의 쓰레드(달래, 솜솜, 후후)가 끝날때까지 기다리라는 뜻
			}	
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.out.println();
		System.out.println("경기 결과");
		System.out.println("순위 : " + DisplayCharacter.setRank);
	}

}
//1.A-Z까지 출력하는 한명에 해당하는 쓰레드
class DisplayCharacter extends Thread{
	
	public static String setRank = "";//2. 출력을 끝낸 순서대로 쓰레드 이름이 추가될 변수
	private String name;

	//3.생성자
	public DisplayCharacter(String name) {
		this.name = name;
	}
	//4.
	@Override
	public void run() {
		for (char c = 'A'; c<='Z' ; c++) {
			System.out.println(name + "씨의 출력문자 : "+ c);
			try {
				Thread.sleep((int)(Math.random()*500));	//0-499사이의 난수가 발생되어 출력되는 문자들의 출력되는 시간이  다 다른 시간이 적용되게 함.
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	System.out.println(name+"씨 출력 끝!");
	setRank += name+ "";//출력을 끝낸 순서대로 이름을 배치함.
	}
}
