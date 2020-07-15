package spring.conf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import sample03.SungJukDTO;
import sample03.SungJukImpl;
import sample05.SungJukDTO2;
import sample05.SungJukDelete;
import sample05.SungJukInput;
import sample05.SungJukModify;
import sample05.SungJukOutput;

@Configuration
public class SpringConfiguration {
	//메소드명을 빈명으로 인식한다
	//그래서 빈명을 getSungJukImpl으로 찾으므로 없어서 name="sungJukImpl"를 부여한 것이다
	@Bean(name="sungJukImpl")
	public SungJukImpl getSungJukImpl(){
		return new SungJukImpl();
	}
	
	@Bean
	public SungJukDTO sungJukDTO(){
		return new SungJukDTO();
	}
	
	@Bean
	public SungJukDTO2 sungJukDTO2() {
		return new SungJukDTO2();
	}
	@Bean
	public List<SungJukDTO2>list() {
		return new ArrayList<SungJukDTO2>();
	}
	@Bean
	public SungJukInput sungJukInput() {
		return new SungJukInput();
	}
	@Bean
	public SungJukOutput sungJukOutput() {
		return new SungJukOutput();
	}
	@Bean
	public SungJukDelete sungJukDelete() {
		return new SungJukDelete();
	}
	@Bean
	public SungJukModify sungJukModify() {
		return new SungJukModify();
	}
}
















