package e_oop;
//과제 1. JVM과 메모리구조에 대해서 찾아보세요.
public class TV {
	// 전원 변수 -메소드1개 : 위의 변수의 상태를 변경할 수 있는것 (전원을 변경하는 매서드 하나(버튼을 누르면 껏다 켜지니까)
	// 채널 변수 -매소드3개 : 채널을 위로 올리는 매서드, 아래로 내리는 매서드, 채널을 변경하는 매서드
	// 볼륨 변수-매소드2개 : 볼륨을 높이는 매서드, 볼륨을 낮추는 매서드
	boolean power;
	int channul = 5;
	int volume = 5;

	// 1. 전원 온/오프
	

	public void power() {
	while (true){
		System.out.println("1: TV ON  /  2: TV OFF");
		int onoff = ScanUtil.nextInt();
		
		if(onoff ==1 ) {
			System.out.println("TV ON");
			break;
			
		}else if (onoff == 2 ) 
			power=false;
			System.out.println("TV OFF");
  	}

	// 2. 특정 채널로 변경
	public void input_cha() {

		while (true) {
			if(power == false) 
			{System.out.println("전원을 켜주세요");
			 break;}
			
			System.out.print("채널을 입력하세요 > ");
			int input = ScanUtil.nextInt();
			channul = input;

			if (channul < 100 && channul > 0) {
				System.out.println("CH : " + channul);
				channul = input;
				break;
			} else
				System.out.println("없는 채널입니다.");
		}
	}
	
	// 3. 채널 up
	public void chaU() {
		
		while (true) {
			if(power == false) 
			{System.out.println("전원을 켜주세요");
			 break;}
			
			channul += 1;

			if (channul < 100 && channul > 0) {
				System.out.println("CH : " + channul);
				break;
			} else
				System.out.println("없는 채널입니다.");
			break;
		}
	}
	
	
	// 4. 채널 다운
	public void chaD() {
		while (true) {
			if(power == false) 
			{System.out.println("전원을 켜주세요");
			 break;}
			channul -= 1;

			if (channul < 100 && channul > 0) {
				System.out.println("CH : " + channul);
				break;
			} else
				System.out.println("없는 채널입니다.");
			break;
		}
	}
	

	// 5. 음량 업
	public void volU() {
		while (true) {
			if(power == false) 
			{System.out.println("전원을 켜주세요");
			 break;}
			
			volume += 1;

			if (volume < 10) {
				System.out.println("VOL : " + volume);
				break;
			} else
				System.out.println("볼륨을 더 높일 수 없습니다.");
			break;
		}
	}

	// 6. 음량 다운
	public void volD() {
		while (true) {
			if(power == false) 
			{System.out.println("전원을 켜주세요");
			 break;}
			
			volume -= 1;
			if (volume > 0) {
				System.out.println("VOL : " + volume);
				break;
			} else
				System.out.println("볼륨을 더 낮출 수 없습니다.");
			break;
		}
	}


	
	// 0. 종료
	

	
//================================================//
	public static void main(String[] args) {

		TV tv = new TV();
		while (true) {
			System.out.println("1.전원  2.채널변경   3.채널업   4.채널다운   5.볼륨업   6.볼륨다운   0.종료>");
			int input = ScanUtil.nextInt();
			
			if (input == 1) {
				tv.power();
			}
			if (input == 2) {
				tv.input_cha();
			}
			if (input == 3) {
				tv.chaU();
			}
			if (input == 4) {
				tv.chaD();
			}
			if (input == 5) {
				tv.volU();
			}
			if (input == 6) {
				tv.volD();
			}
			if (input == 0) {
				System.out.println("TV를 종료합니다.");
				break;
			}
		}
	}
}
