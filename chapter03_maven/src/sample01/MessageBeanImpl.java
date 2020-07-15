package sample01;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

//핵심관심사항
//target
@ComponentScan("spring.conf")
public class MessageBeanImpl implements MessageBean {
	private @Value("Have a nice day!")String str;
	public void setStr(String str) {
		this.str = str;
	}
	//메소드 전부가 joinpoint 가 됨
	//그 중에서도 showPrintBefore() 와 viewPrintBefore()가 pointcut에 해당한다. 
	@Override
	public void showPrintBefore() {
		System.out.println("showPointBefore 메세지=+"+str);
	}
	
	@Override
	public void viewPrintBefore() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("viewPrintBefore 메세지="+str);
	}
	

	@Override
	public void showPrintAfter() {
		System.out.println("showPrintAfter 메세지="+str);
		
	}
	@Override
	public void viewPrintAfter() {
		System.out.println("viewPrintAfter 메세지="+str);
		
	}
	@Override
	public String showPrint() {
		System.out.println("showPrint 메세지="+str);
		return "바부";
	}
	@Override
	public void viewPrint() {
		System.out.println("viewPrint 메세지="+str);
	}
	
	@Override
	public void display() {
		System.out.println("display 메세지="+str);		
	}



}
