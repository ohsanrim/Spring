package sample05;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Setter;
@Setter
@Component
public class SungJukOutput implements SungJuk {
	@Autowired
	private List <SungJukDTO2>list;
	@Override
	public void execute() {
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		for(SungJukDTO2 data:list) {
			System.out.println(data.getName()+"\t"+data.getKor()+"\t"+data.getEng()+"\t"+data.getMath()+"\t"+data.getTot()+"\t"+data.getAvg());
		}
		System.out.println(list.get(0).getName());
	}
}
