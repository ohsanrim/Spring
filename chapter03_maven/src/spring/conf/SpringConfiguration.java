package spring.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import sample01.LoggingAdvice;
import sample01.MessageBeanImpl;
@Configuration
public class SpringConfiguration {
	@Bean(name="messageBeanImpl")
	public MessageBeanImpl getMessageBeanImpl(){
		return new MessageBeanImpl();
	}
	@Bean(name="logginAdvice")
	public LoggingAdvice getLogginAdvice(){
		return new LoggingAdvice();
	}
	
}
