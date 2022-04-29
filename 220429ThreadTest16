//은행 입출금을 쓰레드 처리로 하는 예제

package kr.or.ddit.basic;

public class ThreadTest16 {

	// 1.
	private int balance; // 잔액이 들어가 저장될 변수 선언

	// 2. getter setter만들기
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	
	// 3. 입금하는 메서드 구현
	public void deposit(int money) {	// 원래 입금할때도 동기화 처리를 해줘야하지만 일단,지금은 출금하는걸 기준으로 하는거라서 만들지 않았다
		balance += money;
	}//여기서 int money는 출금할 금액을 의미
	
	//4. 출금하는 메서드(반환값 : 출금 성공하면 true / 실패하면  false)
//	public boolean withdraw(int money) {
//		if (balance >= money) {
//			for (int i = 1; i <= 1000000000; i++)
//				;// 쓰레드가 변경되는걸 보여주기 위해 공회전시킨것.
//			balance -= money;
//			System.out.println("메서든 안에서 잔액(balance) : " + balance);
//			return true; // 출금 성공
//		} else {
//			return false; // 출금 실패
//		}
//	}

	//4-1. 동기화 블럭으로 하는 방법
	public boolean withdraw(int money) {
		synchronized (this) {//=>이게 동기화 블럭이에요
			if (balance >= money) {
				for (int i = 1; i <= 1000000000; i++)
					;// 쓰레드가 변경되는걸 보여주기 위해 공회전시킨것.
				balance -= money;
				System.out.println("메서든 안에서 잔액(balance) : " + balance);
				return true; // 출금 성공
			} else {
				return false; // 출금 실패
			}
		}

	}
	
	//5.
	public static void main(String[] args) {
		ThreadTest16 account = new ThreadTest16();	//객체 생성
		account.setBalance(10000);//잔액을 10000원이 있는걸로 설정한것.
		
		//6. 익명구현체로 쓰레드 구현(새로 쓰레드 만드는 대신)
		Runnable r = new Runnable() {
			
			@Override
			public synchronized void run() {//synchronized가 없으면 th1,th2둘다 출금이 성공이되서 잔액이 -2000원이 나오게 된다.
											//그렇기 때문에 먼저 시작된 thread가 실행이 끝날때까지 기다렸다가 실행할 수 있는 
											//synchornized를 넣어줘야 한다.
				boolean result = account.withdraw(6000);//6000원 출금해보자.
				System.out.println("쓰레드에서 result : "+result+", balance(잔액) : "+account.balance);
			}
		};

	//7.
		Thread th1 = new Thread(r);
		Thread th2 = new Thread(r);
	
		th1.start();
		th2.start();
		
	}

}
