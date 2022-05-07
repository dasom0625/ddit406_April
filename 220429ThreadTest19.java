package kr.or.ddit.basic;

public class ThreadTest19 {

	public static void main(String[] args) {
//8.
		DataBox databox = new DataBox();
		
		ProducerThread th1 = new ProducerThread(databox);
		ConsumerThread th2 = new ConsumerThread(databox);
		
		th1.start();
		th2.start();
	}
}

////////////////////////////////////////////////////////////////


//4. 데이터를 넣어주는 쓰레드를 만들기
class ProducerThread extends Thread{
	private DataBox databox;

	//5. 생성자
	public ProducerThread(DataBox databox) {
		this.databox = databox;
	}
	//6. 데이터 넣어주기
	@Override
	public void run() {
		for(int i = 1; i<=3 ;i++) { //데이터 세개 넣어주기
			databox.setData("졸린 공급데이터 "+i);
		}
	}
	
}
////////////////////////////////////////////////////////////////

//7. 데이터 꺼내서 사용하느 쓰레드 만들기
class ConsumerThread extends Thread{
	private DataBox databox;

	public ConsumerThread(DataBox databox) {
		this.databox = databox;
	}
	//데이터 넣은만큼 데이터 빼기(3개)
	@Override
	public void run() {
		for(int i = 1 ; i<=3 ;i++) {
			String temp  = databox.getData();//꺼내온 값을 출력하지 않는 이유는 getter에서 한번 출력을 해주기 떄문
		}
	}
	
}
////////////////////////////////////////////////////////////////

//1.공통객체 만들기
class DataBox{
	private String data;
	//2.
	//data값이 null이면 data변수에 문자열이 채워질때까지 기다리고,
	//data값이 있으면 해당 문자열을 반환하고, 반환후에는 data값을 null을 줘서 다시 지워줘야한다.//=>이 작업들을 get에서 함.
	public synchronized String getData() {
		if(data==null) {
			try {
				wait();//데이터 값이 채워졌을 때 빠져나오겟지
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		//데이터가 null이 아니고 값이 있으면?
		String temp = data;//임시변수에 data값을 넣고,
		System.out.println("쓰레드가 읽은 데이터 : "+temp);
		System.out.println();
		data = null;//이제 다시 data는 null을 만들어줌.
		
		//set에 잇는 쓰레드 깨워주기
		notify();
		return temp;
		
	}
////////////////////////////////////////////////////////////////
	
	//3.
	//data변수에 값이 있으면 data변수값이 null이 될때까지 기다리고,
	//data변수값이 null이되면 새로운 data값을 저장한다. =>set에서 함. 
	public synchronized void setData(String data) {
		if(this.data!=null) {//data에 값이 잇으면 
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		this.data = data;//데이터 저장
		System.out.println("Thread에서 새로 저장한 데이터 : "+data);
		notify();//혹시나 잠들었을 수 있어서 깨워주는 작업을 함
	}
}

