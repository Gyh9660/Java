package chap15.Ex14;


//쓰레드 상태
	//1. new : 쓰레드 객체 생성후 .start() 메서드가 호출되기전 상태
	//2. Runnable  : .start() 메소드가 호출되면 run()메소드 내부의 코드가 CPU에서 실행되고 있는 상태
	//3. Terminated :run()의 모든 코드가 실행되면 쓰레드 종료
	//4. Timed waiting : 특정 시간 동안만 대기상태, Thread.sleep(1000);
						//a.join (1000) <=== 현재 자신의 스워드는 1초 대시 상태에 있고, a객체를 실행 상태로 먼저보냄.(양보)
						//특정 시간이 종료되면 실행 상태로감, 인터럽트가 발생되면 예외를 발생시키고 실행 상태로감.
	//5. Block : 동기화 처리에서  Lock이 걸려서 접근이 잠시 차단된상태, 키를 반납한 경우 키를 획득해서 실행 상태로 감.
	//6. waiting : 무한정 대기 상태. 누가 꺠워줘야 실행으로 갈 수 있다. 다른 쓰레드가 꺠워줘야 한다.


public class NewRunnableTerminated {

	public static void main(String[] args) {

		//쓰레드의 상태를 저장해놓은 클래스다이다. 총 6의 상태를 저장 할 수 있다.
		Thread.State state; //state 변수에는 6가지 상수만 저장 ㄱ능
		
		//1. 객체 생성 (NEW) // ---익명 내부 클래스 생성
				//NEW : 쓰레드 객체 생성후  start()호출 되기 전까지
		Thread myThread = new Thread() {
			@Override
			public void run() {
				for (long i = 0 ; i< 100000000L; i++) {} //0.5초 시간 지연, CPU마다 상이
				//객체 생성시 약간의 시간이 필요
				//메모리의 할당시간이 필요.
			}
		};
		
		state = myThread.getState(); //쓰레드의 상태를 가지고 와서 state변수에 할당.
		System.out.println("myThread state : "+ state);//NEW
		
		//2. myThread 시작
		myThread.start(); //쓰레드를 시작시 CPU에서 실행
		state = myThread.getState();
		System.out.println("myThread state : "+ state);//RUNNABLE
		
		
		//3. myThread 종료
		
		//myThread.join(); 내 쓰레드(main)는 대기,myThread를 처리해라 
		try {myThread.join();} catch (InterruptedException e) {}
		state = myThread.getState();
		System.out.println("myThread state : " + state);//TERMINATED
		
		
		
	}

}
