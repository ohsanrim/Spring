package sample05;

import java.util.List;
import java.util.Scanner;

import lombok.Setter;
@Setter
public class SungJukInput implements SungJuk {
	private List <SungJukDTO2> list;
	private SungJukDTO2 sungJukDTO2;

	@Override
	public void execute() {
		
		//sungJukDTO2 = new SungJukDTO2();
		if(list.size()!=0) System.out.println(list.size()+list.get(0).getName());
		Scanner sc = new Scanner(System.in);
		System.out.println("이름 입력:");
		sungJukDTO2.setName(sc.nextLine());
		System.out.println("국어점수 입력:");
		sungJukDTO2.setKor(sc.nextInt());
		System.out.println("영어점수 입력:");
		sungJukDTO2.setEng(sc.nextInt());
		System.out.println("수학점수 입력:");
		sungJukDTO2.setMath(sc.nextInt());
		
		sungJukDTO2.setTot(sungJukDTO2.getKor()+sungJukDTO2.getEng()+sungJukDTO2.getMath());
		sungJukDTO2.setAvg((double)sungJukDTO2.getTot()/3);
		
		list.add(sungJukDTO2);
		
		System.out.println(sungJukDTO2.getName()+"님의 데이터를 입력하였습니다.");
	}
}
