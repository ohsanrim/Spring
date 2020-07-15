package sample01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {
	public static void main(String[] args) {
		//MessageBean messageBean = new MessageBeanImpl();
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MessageBean messageBean = context.getBean("messageBeanImpl",MessageBean.class);
		messageBean.sayHello();
	    messageBean.sayHello("참외", 10000);
	    messageBean.sayHello("수박", 12000, 3);
	}

}
