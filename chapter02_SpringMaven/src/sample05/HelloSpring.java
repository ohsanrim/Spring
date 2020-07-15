package sample05;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class HelloSpring {
	@Autowired
	private List<SungJukDTO2>list;

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		new HelloSpring().menu(context);
	}
	
	public void menu(ApplicationContext context) {

		SungJuk sungJukModify = (SungJuk)context.getBean("sungJukModify");
		SungJuk sungJukOutput = (SungJuk)context.getBean("sungJukOutput");
		SungJuk sungJukDelete = (SungJuk)context.getBean("sungJukDelete");
		
		List list = (List)context.getBean("list");
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
			
			if(choice==1) {
				SungJuk sungJukInput = (SungJuk)context.getBean("sungJukInput");
				sungJukInput.execute();
				//System.out.println(list.size());
			} else if(choice==2) {
				sungJukOutput.execute();
			} else if(choice==3) {
				sungJukModify.execute();
			} else if(choice==4) {
				sungJukDelete.execute();
			} else if(choice==5) {
				System.out.println("이용해주셔서 감사합니다!");
				break;
			}
		}
	}
}
