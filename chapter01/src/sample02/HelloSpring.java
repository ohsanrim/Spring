package sample02;

public class HelloSpring {

	public static void main(String[] args) {
		//MessageBeanKo messageBean = new MessageBeanKo();  //1:1 관계, 결합도 100%
		
		MessageBean messageBean = new MessageBeanEn();//부모 = 자식(다형성)
		messageBean.sayHello("spring");
	}

}
