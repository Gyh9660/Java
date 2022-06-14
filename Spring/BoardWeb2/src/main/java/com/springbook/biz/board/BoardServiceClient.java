package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

<<<<<<< HEAD
import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

=======
>>>>>>> 9e0d4adb58faea260cdc14d29e5db0017df7b0c2

public class BoardServiceClient {
	public static void main(String[] args) {
		// 1. Spring �����̳ʸ� �����Ѵ�.
		AbstractApplicationContext container = 
				new GenericXmlApplicationContext("applicationContext.xml");

		// 2. Spring �����̳ʷκ��� BoardServiceImpl ��ü�� Lookup�Ѵ�.
		BoardService boardService = 
				(BoardService) container.getBean("boardService");

		// 3. �� ��� ��� �׽�Ʈ
		BoardVO vo = new BoardVO();
<<<<<<< HEAD
		//vo.setSeq(200);             // �ӽ÷� ���� �߻� ��Ű�� ���ؼ� ����(AfterThrowing ����)
		vo.setTitle("�� ����300");
		vo.setWriter("ȫ�浿300");
		vo.setContent("�� ����300..............");
=======
		vo.setSeq(200);             // �ӽ÷� ���� �߻� ��Ű�� ���ؼ� ����(AfterThrowing ����)
		vo.setTitle("�ӽ� ����300");
		vo.setWriter("ȫ�浿300");
		vo.setContent("�ӽ� ����300..............");
>>>>>>> 9e0d4adb58faea260cdc14d29e5db0017df7b0c2
		boardService.insertBoard(vo);
		

		// 4. �� ��� �˻� ��� �׽�Ʈ
		
<<<<<<< HEAD
		vo.setSearchCondition("TITLE");  //SQL�� TITLE �÷��� �˻�
		vo.setSearchKeyword("��");		// TITLE �÷��� �� "�ӽ�" �˻� 
	
=======
		vo.setSearchCondition("TITLE"); //SQL�� TITLE�÷��� �˻�
		vo.setSearchKeyword("�ӽ�"); //TiTle�÷��� �� �ӽö�� �� �˻�
		
>>>>>>> 9e0d4adb58faea260cdc14d29e5db0017df7b0c2
		List<BoardVO> boardList = boardService.getBoardList(vo);
		for (BoardVO board : boardList) {
			System.out.println("---> " + board.toString());
		}
		

		
		// 5. Spring �����̳� ����
		container.close();
		
		
	}
}