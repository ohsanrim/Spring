package sample02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CalcMul implements Calc {
	
	private @Value("25")int num;
	private @Value("40")int num2;
	
	@Autowired
	public void setX(@Value("25")int num){
		this.num = num;
	}
	public void setY(@Value("36")int num2){
		this.num2= num2;
	}
	
	@Override
	public void calculate() {
		System.out.println(num+"*"+num2+"="+(num*num2));
	}
}
