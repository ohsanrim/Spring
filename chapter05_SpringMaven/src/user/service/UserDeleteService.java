package user.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

import user.dao.UserDAO;
@ComponentScan("user.conf")
public class UserDeleteService implements UserService {
	@Autowired
	private UserDAO userDAO;
	@Override
	public void execute() {
		System.out.println("삭제할 계정의 id를 입력하세요");
		Scanner sc = new Scanner(System.in);
		String id = sc.nextLine();
		int su = userDAO.getUserCount(id);
		if(su==1) {
			userDAO.deleteUser(id);
			System.out.println("유저의 정보가 삭제되었습니다.");
		} else {
			System.out.println("유저의 정보가 존재하지 않습니다.");
		}
		
	}

}
