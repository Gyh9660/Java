package chap17.Ex17;

import java.util.LinkedList;
import java.util.Queue;

//Queue : FIFO(First In First Out) : 처음 들어간 값이 처음으로 나온다.


public class QueueMethod {

	public static void main(String[] args) {
		Queue<Integer> queue1 = new LinkedList <Integer>();
		
		//1. 예외 처리를 미포함한 메소드 (add(), element(), remove())
			//1. add() : 큐에 값을 추가할때.
				//System.out.println(queue1.element()); //실행시 예외  발생, 예외처리가 안되어 있다.
				queue1.add(3);
				queue1.add(4);
				queue1.add(5);
			//2.element();
				System.out.println(queue1.element()); //제일 먼저 나올 값을 확인
			
			//3.E remove(); 큐의 값을 끄집어 낼떄 사용.
				System.out.println(queue1.remove()); //3
				System.out.println(queue1.remove()); //4
				System.out.println(queue1.remove()); //5
				//System.out.println(queue1.remove()); //모두 끄집어 내고나서 끄집어 낼때 예외 발생 예외처리가 안되어있다.
				System.out.println("========================================================");
				
		//2. 예외처리 포함한 메소드 (offer(), peek(), poll() )<==권장사항
			Queue<Integer> queue2 = new LinkedList<Integer>();
				
				System.out.println(queue2.peek());//실행시 예외 발생안함, 예외처리가 되어 있다. 기능은같다.
				
				//1. offer(E item) : 값을 추가
					queue2.offer(3);
					queue2.offer(4);
					queue2.offer(5);
				
				//2. peek() : 출력할 값을 미리 보는것	
					System.out.println(queue2.peek()); 
					
				//3. poll(); 값을 끄집어 내기
					System.out.println(queue2.poll()); //3
					System.out.println(queue2.poll()); //4
					System.out.println(queue2.poll()); //5
					System.out.println(queue2.poll()); //다 끄집어 내고나서 끄집어 내도 에외발생x 예외처리되어있다.
			
	}

}
