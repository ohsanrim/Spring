package sample05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sample04.Calc;
import sample04.CalcAdd;

public class HelloSpring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");//객체가 아무리 많이생성이 되어도 싱글톤으로 생성이 된다. 
		SungJuk sungJuk  = (SungJuk)context.getBean("sungJukImpl");
		sungJuk.calc();
		sungJuk.display();
	}

}
