package sample05;

import java.text.DecimalFormat;
import java.util.Scanner;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component("sungJukImpl")
@Scope("prototype")
public class SungJukImpl implements SungJuk {
	public String name;
	public int kok;
	public int eng;
	public int math;
	public int tot;
	public String avg;
	public SungJukImpl() {
		Scanner sc = new Scanner(System.in);
		System.out.println("이름 입력:");
		name=sc.nextLine();
		System.out.println("국어 입력:");
		kok=sc.nextInt();
		System.out.println("영어 입력:");
		eng=sc.nextInt();
		System.out.println("수학 입력:");
		math=sc.nextInt();
	}
	@Override
	public void calc() {
		tot= math+kok+eng;
		avg=String.format("%.3f",(double)tot/3);
	}

	@Override
	public void display() {
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		System.out.println(name+"\t"+kok+"\t"+eng+"\t"+math+"\t"+tot+"\t"+avg);

	}

}
