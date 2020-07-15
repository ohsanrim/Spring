package sample02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sample01.MessageBean;

public class HelloSpring {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Calc calc1 = context.getBean("calcAdd",Calc.class);
		calc1.calculate();
		Calc calc2 = context.getBean("calcMul",Calc.class);
		calc2.calculate();
	}
}
