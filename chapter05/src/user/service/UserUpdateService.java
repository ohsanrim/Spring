package user.service;

import java.util.List;
import java.util.Scanner;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;
@Setter
public class UserUpdateService implements UserService {
	private UserDTO userDTO;
	private UserDAO userDAO;
	@Override
	public void execute() {
		Scanner sc = new Scanner (System.in);
		System.out.println("수정할 아이디 입력:");
		String id=sc.next();
		int su = userDAO.getUserCount(id);
		
		if(su==1) {
			sc.nextLine();
			System.out.println("수정할 이름 입력:");
			String name = sc.nextLine();
			System.out.println("수정할 비밀번호 입력");
			String pwd = sc.nextLine();
			userDTO.setId(id);
			userDTO.setName(name);
			userDTO.setPwd(pwd);
			userDAO.modify(userDTO);
			System.out.println("수정이 완료되었습니다!");
		} else {
			System.out.println("입력하신 아이디는 존재하지 않는 아이디입니다.");
		}
	}

}
