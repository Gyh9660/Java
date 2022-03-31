package chap15.Ex14;


//������ ����
	//1. new : ������ ��ü ������ .start() �޼��尡 ȣ��Ǳ��� ����
	//2. Runnable  : .start() �޼ҵ尡 ȣ��Ǹ� run()�޼ҵ� ������ �ڵ尡 CPU���� ����ǰ� �ִ� ����
	//3. Terminated :run()�� ��� �ڵ尡 ����Ǹ� ������ ����
	//4. Timed waiting : Ư�� �ð� ���ȸ� ������, Thread.sleep(1000);
						//a.join (1000) <=== ���� �ڽ��� ������� 1�� ��� ���¿� �ְ�, a��ü�� ���� ���·� ��������.(�纸)
						//Ư�� �ð��� ����Ǹ� ���� ���·ΰ�, ���ͷ�Ʈ�� �߻��Ǹ� ���ܸ� �߻���Ű�� ���� ���·ΰ�.
	//5. Block : ����ȭ ó������  Lock�� �ɷ��� ������ ��� ���ܵȻ���, Ű�� �ݳ��� ��� Ű�� ȹ���ؼ� ���� ���·� ��.
	//6. waiting : ������ ��� ����. ���� �ƿ���� �������� �� �� �ִ�. �ٸ� �����尡 �ƿ���� �Ѵ�.


public class NewRunnableTerminated {

	public static void main(String[] args) {

		//�������� ���¸� �����س��� Ŭ�������̴�. �� 6�� ���¸� ���� �� �� �ִ�.
		Thread.State state; //state �������� 6���� ����� ���� ����
		
		//1. ��ü ���� (NEW) // ---�͸� ���� Ŭ���� ����
				//NEW : ������ ��ü ������  start()ȣ�� �Ǳ� ������
		Thread myThread = new Thread() {
			@Override
			public void run() {
				for (long i = 0 ; i< 100000000L; i++) {} //0.5�� �ð� ����, CPU���� ����
				//��ü ������ �ణ�� �ð��� �ʿ�
				//�޸��� �Ҵ�ð��� �ʿ�.
			}
		};
		
		state = myThread.getState(); //�������� ���¸� ������ �ͼ� state������ �Ҵ�.
		System.out.println("myThread state : "+ state);//NEW
		
		//2. myThread ����
		myThread.start(); //�����带 ���۽� CPU���� ����
		state = myThread.getState();
		System.out.println("myThread state : "+ state);//RUNNABLE
		
		
		//3. myThread ����
		
		//myThread.join(); �� ������(main)�� ���,myThread�� ó���ض� 
		try {myThread.join();} catch (InterruptedException e) {}
		state = myThread.getState();
		System.out.println("myThread state : " + state);//TERMINATED
		
		
		
	}

}
