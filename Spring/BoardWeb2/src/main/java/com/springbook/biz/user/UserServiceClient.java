package com.springbook.biz.user;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

<<<<<<< HEAD

=======
<<<<<<< HEAD

=======
>>>>>>> 9e0d4adb58faea260cdc14d29e5db0017df7b0c2
>>>>>>> 7a6b14bb83f22218a13c7a0564af8bc7b4fb36c6
public class UserServiceClient {
	public static void main(String[] args) {
		// 1. Spring �����̳ʸ� �����Ѵ�.
		AbstractApplicationContext container = 
				new GenericXmlApplicationContext("applicationContext.xml");

		// 2. Spring �����̳ʷκ��� UserServiceImpl ��ü�� Lookup �Ѵ�.
		UserService userService = 
				(UserService) container.getBean("userService");

		// 3. �α��� ��� �׽�Ʈ
		UserVO vo = new UserVO();
		vo.setId("admin");
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 7a6b14bb83f22218a13c7a0564af8bc7b4fb36c6
		vo.setPass("1234");

		UserVO user = userService.getUser(vo);
		System.out.println("aaa"+user);
<<<<<<< HEAD
=======
=======
		vo.setPassword("1234");

		UserVO user = userService.getUser(vo);
>>>>>>> 9e0d4adb58faea260cdc14d29e5db0017df7b0c2
>>>>>>> 7a6b14bb83f22218a13c7a0564af8bc7b4fb36c6
		if (user != null) {
			System.out.println(user.getName() + "�� ȯ���մϴ�.");
		} else {
			System.out.println("�α��� ����");
		}

		// 4. Spring �����̳ʸ� �����Ѵ�.
		container.close();
	}
}