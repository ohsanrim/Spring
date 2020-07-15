package sample01;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

//공통 관심사항
//Aspect
@Aspect  //공통모듈임을 명시
@ComponentScan("spring.conf")
public class LoggingAdvice {
	@Before("execution(public * *.*.*Before(..))")
	public void beforeTrace() {
		System.out.println("Before trace...");
	}
	
	@After("execution(public * *.*.*After(..))")
	public void afterTrace() {
		System.out.println("After trace...");
	}
	
	@Around("execution(public * *.*.*Print(..))")
	public void trace(ProceedingJoinPoint joinPoint) throws Throwable{
		String methodName= joinPoint.getSignature().toShortString();
		System.out.println("메소드="+methodName);
		
		StopWatch sw = new StopWatch();
		sw.start(methodName);
		
		//핵심 관심사항을 부른 후 처리하고 돌아옴
		Object ob = joinPoint.proceed();
		System.out.println("결과 ob=0"+ob);
		sw.stop();
		System.out.println("처리시간="+sw.getTotalTimeMillis()/1000+"초");
	}
}
