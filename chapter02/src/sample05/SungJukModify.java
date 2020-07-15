package sample05;

import java.util.List;
import java.util.Scanner;

import lombok.Setter;

@Setter
public class SungJukModify implements SungJuk {
	private List <SungJukDTO2> list;
	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		System.out.println("수정할 이름 입력:");
		String searchName = sc.nextLine();
		
		int searchUser=0;
		for(SungJukDTO2 data:list) {
			if(data.getName().equals(searchName)) {
				searchUser++;
				System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
				System.out.println(data.getName()+"\t"+data.getKor()+"\t"+data.getEng()+"\t"+data.getMath()+"\t"+data.getTot()+"\t"+data.getAvg());
				
				System.out.println("국어 점수 입력:");
				data.setKor(sc.nextInt());
				System.out.println("영어 점수 입력:");
				data.setEng(sc.nextInt());
				System.out.println("수학 점수 입력:");
				data.setMath(sc.nextInt());
				
				data.setTot(data.getKor()+data.getEng()+data.getMath());
				data.setAvg((double)data.getTot()/3);
				
				System.out.println(data.getName()+"님의 데이터를 수정하였습니다.");
			}
		}
		
		if(searchUser==0) System.out.println("찾고자 하는 이름이 존재하지 않습니다.");
	}

}
