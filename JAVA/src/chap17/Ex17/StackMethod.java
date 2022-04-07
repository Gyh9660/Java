package chap17.Ex17;

import java.util.Stack;

//Stack 자료구조 : LIFO (Last In First Out) :제일 마지막에 저장된 값이 제일 처음 나온다.


public class StackMethod {

	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<Integer>();
		
		//1. E push (E element) : 스택에 값을 넣을떄 사용.
		stack.push(2);
		stack.push(5);
		stack.push(3);
		stack.push(7);
		
		//2. E peek() : 가져올 값을 위에서 처다봄.
		System.out.println(stack.peek()); //7
		System.out.println(stack.size()); //4
		System.out.println();
		
		//3. search(Object o) :검색 (값을 넣엇을떄 index 번호를 출력,주의 : 방번호는 위에서부터 1번부터 할당)
		System.out.println(stack.search(7)); //방번호 1
		System.out.println(stack.search(3)); //방번호 2
		System.out.println(stack.search(5)); //방번호 3
		System.out.println(stack.search(2)); //방번호 4
		System.out.println(stack.search(9)); //값이 존재하지 않을경우 -1리턴
		System.out.println("=====================");
		//4. E pop() :스택의 값을 가져오기, 제일 마지막에 넣은 값부터 가져올 수 있다.
		System.out.println(stack.pop()); //7
		System.out.println(stack.pop()); //3
		System.out.println(stack.pop()); //5
		System.out.println(stack.pop()); //2
		//System.out.println(stack.pop()); 없으면 오류발생
		
		//5. empty() : 비어있으면 true 값이 있으면false
		System.out.println(stack.empty());
		
		
		
		
	}

}
