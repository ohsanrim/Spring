package sample02;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class CalcAdd implements Calc {
	
	@NonNull private int num;
	@NonNull private int num2;
	@Override
	public void calculate() {
		System.out.println(num+"+"+num2+"="+(num+num2));
		
	}

}
