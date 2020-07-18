package user.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import user.service.UserService;
@Component
public class HelloSpring {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/spring/applicationContext.xml");
		new HelloSpring().menu(context);
	}
	
	public void menu(ApplicationContext context) {
		
		while(true) {
			System.out.println("**********");
			System.out.println("1. 입력");
			System.out.println("2. 출력");
			System.out.println("3. 수정"); 
			System.out.println("4. 삭제");
			System.out.println("5. 끝");
			System.out.println("**********");
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			UserService userService=null;
			
			if(choice==1) {
				userService = (UserService) context.getBean("userInsertService");
				
			} else if(choice==2) {
				userService = (UserService) context.getBean("userSelectService");
				
			} else if(choice==3) {
				userService = (UserService) context.getBean("userUpdateService");
				
			} else if(choice==4) {
				userService = (UserService) context.getBean("userDeleteService");
				
			} else if(choice==5) {
				System.out.println("이용해주셔서 감사합니다!");
				break;
			} else {
				System.out.println("1~5번까지의 번호만 입력해주세요!");
				continue;
			}
			userService.execute();
		}
	}
}
