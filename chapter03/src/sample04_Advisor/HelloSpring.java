package sample04_Advisor;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext04.xml");
		MessageBean bean = context.getBean("proxy",MessageBean.class);
		
		//study와 공통의 관심사만 삽입
		bean.study();
		System.out.println("----------------");
		System.out.println("결과="+bean.game());
		System.out.println("----------------");
		bean.lesson();
	}

}
