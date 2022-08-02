package e_oop;
//과제 1. JVM과 메모리구조에 대해서 찾아보세요.
public class TV {
	boolean power = false; //전원은 꺼진상태로 시작할거라서 
	int channel=1; //채널
	int volume=5; //음량
	
	//상수로 제한=>final : 변수를 상수로 바꾸는것.(변수의 값이 바뀌지 않게 하는것/한번저장하면 바뀌지 않음.)
	//상수 : 프로그램 안에서 자주 사용되는 의미있는 값을 표현할때 사용.
	//상수는 항상 대문자를 써야함.
	final int MIN_CHANNEL = 1;
	final int MAX_CHANNEL = 100;
	final int MIN_VOLUME = 0;
	final int MAX_VOLUME = 10;
	//전원 온오프
	void power() {
		power =!power; //=>true인경우에는 false가 되게 함. 반대로 false면 true가 저장되게함.
		System.out.println(power ? "TV ON " : "TV OFF");
	}
	
	//특정 채널 =>값을 받을 수 없어서 파라미터를 넣어줌
	 void changeChannel(int channel) {
		 if(power) {
			 if(MIN_CHANNEL <= channel && channel <=MAX_CHANNEL) {
				 this.channel = channel;
			 }
			 System.out.println("채널."+ this.channel);
		 }
	 }
	
	//채널 업
	void channelUp(){
		changeChannel(channel +1);	//위의 특정채널과 수식가 거의 같아서 가져다 쓰고, 파라미터에 원하는 값을 넣음.
	}
	//채널다운
	void channelDown(){
		changeChannel(channel -1);	//위의 특정채널과 수식가 거의 같아서 가져다 쓰고, 파라미터에 원하는 값을 넣음.
	}
	
	//음량 업
	void volumeUp() {
		if(power) {
			if(volume <= MAX_VOLUME) {
				volume++;
			}
			showVolume(); //볼륨을 출력하는 메소드를 미리 만듬.
		}
	}
	

	//음량 다운
	void volumeDown() {
		if (power) {
			if (MIN_VOLUME <=volume) {
				volume--;
			}
			showVolume();
		}
	}

	//showVolume 메소드 만들기
	void showVolume() {
		System.out.print("음량." );
		for(int i = MIN_VOLUME +1 ; i <= MAX_VOLUME ; i++) {
			if(i <= volume) {
				System.out.print("★");
			}else {
				System.out.print("☆");
			}
		}
		System.out.println();
	}

	
  
  
  ===============================================================
  public static void main(String[] args) {
  		TV tv = new TV();
		while (true) {
			System.out.println("1.전원  2.채널변경   3.채널업   4.채널다운 \n5.볼륨업   6.볼륨다운   0.종료>");
			int input = ScanUtil.nextInt();
			
			switch(input) {
			case 1:
				tv.power();
				break;
				
			case 2:
				System.out.print("변경할 채널(1~100)>");
				int ch = ScanUtil.nextInt();
				tv.changeChannel(ch);
				break;
				
			case 3:
				tv.channelUp();
				break;
				
			case 4:
				tv.channelDown();
				break;
				
			case 5:
				tv.volumeUp();
				break;
				
			case 6:
				tv.volumeDown();
				break;
				
			case 0:
				System.out.println("종료되었습니다.");
				System.exit(0);		//system.exit(0); : 프로그램을 종료시키는 메소드
									//파라미터 안의 0대신 아무숫자나 넣어도 상관없으나 비워두면 안됨.
			}
		}
		}
	
}
