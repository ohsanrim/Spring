package user.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAOImpl;

@Service//component의 일종
public class UserInsertService implements UserService {
	@Autowired   
	private UserDTO userDTO;
	@Autowired
	private UserDAOImpl userDAO;

	@Override
	public void execute() {
	      Scanner scan = new Scanner(System.in);
	      System.out.print("이름 입력: ");
	      String name = scan.next();
	      System.out.print("아이디 입력: ");
	      String id = scan.next();
	      System.out.print("비밀번호 입력: ");
	      String pwd = scan.next();

	      userDTO.setName(name);
	      userDTO.setId(id);
	      userDTO.setPwd(pwd);
	      
	      userDAO.write(userDTO);
	      
	      System.out.println("저장 완료!");
	      
	}

}
