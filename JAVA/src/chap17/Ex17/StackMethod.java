package chap17.Ex17;

import java.util.Stack;

//Stack �ڷᱸ�� : LIFO (Last In First Out) :���� �������� ����� ���� ���� ó�� ���´�.


public class StackMethod {

	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<Integer>();
		
		//1. E push (E element) : ���ÿ� ���� ������ ���.
		stack.push(2);
		stack.push(5);
		stack.push(3);
		stack.push(7);
		
		//2. E peek() : ������ ���� ������ ó�ٺ�.
		System.out.println(stack.peek()); //7
		System.out.println(stack.size()); //4
		System.out.println();
		
		//3. search(Object o) :�˻� (���� �־����� index ��ȣ�� ���,���� : ���ȣ�� ���������� 1������ �Ҵ�)
		System.out.println(stack.search(7)); //���ȣ 1
		System.out.println(stack.search(3)); //���ȣ 2
		System.out.println(stack.search(5)); //���ȣ 3
		System.out.println(stack.search(2)); //���ȣ 4
		System.out.println(stack.search(9)); //���� �������� ������� -1����
		System.out.println("=====================");
		//4. E pop() :������ ���� ��������, ���� �������� ���� ������ ������ �� �ִ�.
		System.out.println(stack.pop()); //7
		System.out.println(stack.pop()); //3
		System.out.println(stack.pop()); //5
		System.out.println(stack.pop()); //2
		//System.out.println(stack.pop()); ������ �����߻�
		
		//5. empty() : ��������� true ���� ������false
		System.out.println(stack.empty());
		
		
		
		
	}

}
