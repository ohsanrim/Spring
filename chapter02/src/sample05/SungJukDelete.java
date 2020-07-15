package sample05;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import lombok.Setter;

@Setter
public class SungJukDelete implements SungJuk {
	private List <SungJukDTO2> list;
	
	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제할 이름 입력:");
		String searchName = sc.nextLine();
		
		int sw=0;
		Iterator<SungJukDTO2> it = list.iterator();
		while(it.hasNext()) {
			if(it.next().getName().equals(searchName)) {
				it.remove();
				sw=1;
				System.out.println("데이터가 삭제되었습니다.");
			}
		}
		if(sw==0) System.out.println("찾고자 하는 이름이 존재하지 않습니다.");
	}

}
