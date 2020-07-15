package sample03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		//ApplicationContext context = new FileSystemXmlApplicationContext("src/applicationContext.xml");
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");//객체가 아무리 많이생성이 되어도 싱글톤으로 생성이 된다. 
		
		MessageBean Bean = (MessageBean)context.getBean("messageBean");
		Bean.sayHello("spring");
		
		MessageBean Bean2 = context.getBean("messageBean",MessageBean.class);  //리턴하는 클래스 타입 역시 설정할 수 있음
		Bean2.sayHello("spring");
		
		MessageBean Bean3 = (MessageBean)context.getBean("messageBean");
		Bean3.sayHello("spring");
	}
}
