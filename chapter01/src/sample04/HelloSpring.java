package sample04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class HelloSpring {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");//객체가 아무리 많이생성이 되어도 싱글톤으로 생성이 된다. 
		
		Calc c1 = (CalcAdd)context.getBean("calcAdd");
		c1.calculate(25,36);
		Calc c2 = (CalcMul)context.getBean("calcMul");
		c2.calculate(25,36);
	}

}
