package sample03;

public class MessageBeanKo implements MessageBean {
	private int num=0;
	public MessageBeanKo() {
		System.out.println("MessageBeanKo의 기본생성자");
	}

	@Override
	public void sayHello(String name) {
		num++;
		System.out.println("num="+num);
		System.out.println("안녕하세요 " +name+"!!");
		
	}

}
