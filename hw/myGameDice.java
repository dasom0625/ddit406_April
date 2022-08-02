package f_game.diceGame;
//게임 할 user클래스
public class User {

	String name; //이름
	int money; //게임 머니
	int win; //이긴 횟수
	int lose; //폐배 횟수
	int record; //전적
	int userdice1;
	int userdice2;
	int userdice3;
	int userdice4;
	int userPoint; //주사위 1번 굴리는것의 포인트
	int totalPoint; //주사위 5번 굴리는것의 총 포인트
//초기화
	User(String name){
		this.name = name;
		money = 100000;
		win = 0;
		lose = 0;
		record = win+lose;

		userdice1=0;
		userdice2=0;
		userdice3=0;
		userdice4=0;
		userPoint=0;
		totalPoint=0;
	}
	
	//user의 정보를 볼 수 있는 메소드
	void showStatus() {
	
		System.out.println("\n┎───────────────────────────────┐");
		System.out.println("           < 나의 정보  >"+"\n");
		System.out.println(" 이름 : " + name);
		System.out.println(" 보유 머니 : " + money);
		System.out.println(" 이긴 횟수 : " + win + " / "+(win+lose));
		System.out.println(" 패배 횟수 : " + lose + " / "+(win+lose)+"\n");
		System.out.println("└───────────────────────────────┘\n");
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
	}
	
	// user의 주사위
	void userDice() {
		userPoint = 0;// 한번의 게임당 한번씩만 포인트를 보여주게 초기화.
		int[] userDice = new int[4];

		// 주사위 랜덤 값
		for (int i = 0; i < userDice.length; i++) {
			userDice[i] = (int) (Math.random() * 6) + 1;
		}

		// 주사위 작은수부터 선택정렬
		for (int i = 0; i < userDice.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < userDice.length; j++) {
				if (userDice[j] < userDice[min]) {
					min = j;
				}
			}
			int temp = userDice[i];
			userDice[i] = userDice[min];
			userDice[min] = temp;

			// 주사위 값 저장
			userdice1 = userDice[0];
			userdice2 = userDice[1];
			userdice3 = userDice[2];
			userdice4 = userDice[3];
		}

		// 게임 조건
		for (int i = 0; i < userDice.length; i++) {
			if (userDice[i] == 1) {
				userPoint = userPoint + 10;
				totalPoint = totalPoint + 10;
			}
			if (userDice[i] == 5) {
				userPoint = userPoint + 50;
				totalPoint = totalPoint + 50;
			}
		}

		// 주사위 숫자 스트레이트일경우 + 500점
		for (int i = 1; i <= 3; i++) {
			if (userDice[0] == i && userDice[1] == i + 1 && userDice[2] == i + 2 && userDice[3] == i + 3) {
				if (userDice[0] == 1) {
					userPoint = userPoint + 490;
					totalPoint = totalPoint + 490;
					System.out.println("😄 straight~!!!!! "+name+"님이 500 point를 획득했어요~!\n");
				} else if (userDice[2] == 5 || userDice[3] == 5) {
					userPoint = userPoint + 450;
					totalPoint = totalPoint + 450;
					System.out.println("😄 straight~!!!!!"+name+" 500 point를 획득했어요~!\n");
				}
			}
		}

		//주사위 숫자가 모두 동일할 경우
		for (int i = 2; i <= 4; i++) {
			if (userDice[0] == i && userDice[1] == i && userDice[2] == i && userDice[3] == i) {
				if (i == 1) {
					userPoint = userPoint + 960;
					totalPoint = totalPoint + 960;
					System.out.println("😆 WoW~!! Jackpot!!!!! "+name+"님이 이긴거나 다름 없어요!!\n");
				} else if (i == 5) {
					userPoint = userPoint + 800;
					totalPoint = totalPoint + 800;
					System.out.println("😆 WoW~!! Jackpot!!!!! "+name+"님이 이긴거나 다름 없어요!!\n");
				} else
					userPoint = userPoint + 1000;
				totalPoint = totalPoint + 1000;
				System.out.println("😆WoW~!! Jackpot!!!!! "+name+"님이 이긴거나 다름 없어요!!\n");

			}

		}
	}
}



=======================================================================================================

package f_game.diceGame;

public class Com {
	
	String name; //이름

	int comdice1;
	int comdice2;
	int comdice3;
	int comdice4;
	int comPoint;
	int totalPoint;
	
	Com(String name){
		this.name = name;
		comdice1=0;
		comdice2=0;
		comdice3=0;
		comdice4=0;
		comPoint=0;
		totalPoint=0;
	}

	
	void comDice() {
		
		comPoint=0;	//한번의 게임당 한번씩만 포인트를 보여주게 초기화.
		
		int[]comRandom = new int [4];
		for(int i = 0; i<comRandom.length; i++) {
			comRandom[i] = (int)(Math.random()*6)+1;}
		
		//주사위 작은값부터 선택정렬
		for (int i = 0; i < comDice.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < comDice.length; j++) {
				if (comDice[j] < comDice[min]) {
					min = j;
				}
			}
			int temp = comDice[i];
			comDice[i] = comDice[min];
			comDice[min] = temp;

			//정렬된 주사위 저장
			comdice1 = comDice[0];
			comdice2 = comDice[1];
			comdice3 = comDice[2];
			comdice4 = comDice[3];
		}

		
		//주사위가 1일때와 5일떄 점수
		for (int i = 0; i < comDice.length; i++) {
			if (comDice[i] == 1) {
				comPoint = comPoint + 10;
				totalPoint = totalPoint + 10;
			}
			if (comDice[i] == 5) {
				comPoint = comPoint + 50;
				totalPoint = totalPoint + 50;
			}
		}

		//주사위가 스트레이트일때 점수
		for (int i = 1; i <= 3 ; i++) {
			if (comDice[0] == i && comDice[1] == i+1 && comDice[2] == i+2 && comDice[3] == i+3) {
				if(comDice[0] == 1) {
				comPoint = comPoint + 490;
				totalPoint = totalPoint + 490;
				System.out.println("오마이갓~ "+name+"님이 500점이나 획득했어요...\n");
				}else if(comDice[2]==5 || comDice[3]==5){
					comPoint = comPoint + 450;
					totalPoint = totalPoint +450;
					System.out.println("오마이갓~ "+name+"님이 500점이나 획득했어요...\n");
				}
			}
		}
		
		//주사위 숫자 모두 같을때 
		for(int i = 2; i <= 4 ; i++) {
			if(comDice[0] == i && comDice[1] == i && comDice[2] == i && comDice[3] ==i) {
				if(i == 1) {
					comPoint = comPoint + 960;
					totalPoint = totalPoint + 960;
					System.out.println("※ 삐용삐용 응급상황이에요!! "+name+"님이 1000점을 획득했어요!  ※ \n");
				} else if (i == 5) {
					comPoint = comPoint + 800;
					totalPoint = totalPoint + 800;
					System.out.println("※ 삐용삐용 응급상황이에요!! "+name+"님이 1000점을 획득했어요!  ※ \n");
				} else
					comPoint = comPoint + 1000;
				totalPoint = totalPoint + 1000;
				System.out.println("※ 삐용삐용 응급상황이에요!! "+name+"님이 1000점을 획득했어요!  ※ \n");	
			}

		}
	}

}


==============================================================================================

package f_game.diceGame;

import java.util.Random;

import e_oop.ScanUtil;


public class DiceGame {
	

		User u;
		Com c;

		int count = 0; //주사위 돌리는 횟수
		int batting; // 배팅금 입력
		int replay; // 재도전 여부
	
		//캐릭터 이름 입력받기
		{
			System.out.println("\n⚀    ⚁    ⚂    ⚃    ⚄    ⚅  주사위 게임  ⚀    ⚁    ⚂    ⚃    ⚄    ⚅");
			System.out.println("\n캐릭터의 이름을 입력해주세요 > ");
			String name = ScanUtil.nextLine();
			u = new User(name);

			System.out.println("\n상대자(컴퓨터)의 이름을 입력하세요 > ");
			String cName = ScanUtil.nextLine();
			c = new Com(cName);

		}
		
		//메인 메소드에서 게임 내용 만들기
		public static void main(String[] args) {
			new DiceGame().start();
		}
		
		void start() {
			while (true) {
				System.out.println("\n■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("\n" + "\t< Dice Game >" + "\n");
				System.out.println("1. Game Start \n2.My Information \n3.End Game");
				System.out.print("\n" + "선택 > ");
				int select = ScanUtil.nextInt(); // 게임 메뉴 선택
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");

				switch (select) { // swtich start
				case 1: // 게임 시작
					dice();
					System.out.println("--------------------------------");
					break;

				case 2: // 내 정보보여주기.
					u.showStatus();
					break;

				case 3:
					System.out.println("게임이 종료됩니다.");
					System.exit(0);

				}
			}
		}
		
		//case 1을 위한 메소드
		void dice() {

			// 배팅금액 먼저 입력받기
			System.out.println("\n배팅 금액을 입력해주세요.");
			batting = ScanUtil.nextInt();

			if (batting <= u.money) {
				System.out.println("\n" + "=================================");
				System.out.println("\n" + "\tGame Start");

				// 게임 (5번 반복)
				System.out.println("1.첫번째게임  2.두번째게임  3.세번째게임  4.네번째게임  5.다섯번째게임 >>");
				System.out.println("──────────────────────────────────");
				count = ScanUtil.nextInt();
				while (count != 6) {

					u.userDice();
					c.comDice();

					System.out.println(u.name + "님의 주사위 값 : " + u.userdice1 + " / " + u.userdice2 + " / " + u.userdice3
							+ " / " + u.userdice4 + "\n<<" + u.name + "님의 GET POINT>>  " + u.userPoint + " / "
							+ u.totalPoint);// 내 주사위들 번호
					System.out.println();
					System.out.println(c.name + "님의 주사위 값 : " + c.comdice1 + " / " + c.comdice2 + " / " + c.comdice3
							+ " / " + c.comdice4 + "\n<<" + c.name + "님의  GET POINT>>  " + c.comPoint + " / "
							+ c.totalPoint);// com주사위들 번호
					System.out.println("──────────────────────────────────");

					count = Integer.parseInt(ScanUtil.nextLine());
					// point(); //point메서드 받아오기
				}
				point(); // point메서드 받아오기

				// 포인트가 높은쪽의 승리 선언
				if (u.totalPoint > c.totalPoint) {
					System.out.println("\t congratulation");
					System.out.println("축하합니다! " + u.name + "님이 이겼습니다! \n");
					u.money = u.money + batting;
					u.totalPoint = 0;
					c.totalPoint = 0;
					regame();

				} else if (u.totalPoint == c.totalPoint) {
					System.out.println("어라라라랏 비겼어용 재도전 가시죠");
					u.totalPoint = 0;
					c.totalPoint = 0;
					regame();
				} else
					System.out.println("이런.. " + c.name + "님이 이겼어요! 재도전 고고? \n"); // 재도전 여부
				u.money = u.money - batting;
				u.totalPoint = 0;
				c.totalPoint = 0;
				regame();

			} else
				System.out.println("나의 잔고가 부족해요!!");

		}
		
		// totalPoint에 따른 전적쌓기
		void point() {
			if (u.totalPoint > c.totalPoint) {
				u.win++;
			} else if (u.totalPoint < c.totalPoint) {
				u.lose++;
			}
		}
		
		//게임 다시 시작 메소드
		void regame() {
			System.out.println("1.묻고 따블로 가!\t2.워후~벌만큼 벌었으니 이제 그만~>>");
			replay = ScanUtil.nextInt();

			switch (replay) {
			case 1:
				if (u.money <= 0) {
					System.out.println("\n띠로리....파산했어요....good bye...");
				} else

					dice();
				break;
			case 2:
				start();
				break;
			}
		}
	}
