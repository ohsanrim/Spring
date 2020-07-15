package sample02;

import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
public class CalcMul implements Calc {
	
	private int num;
	private int num2;
	
	@Override
	public void calculate() {
		System.out.println(num+"*"+num2+"="+(num*num2));
	}

}
