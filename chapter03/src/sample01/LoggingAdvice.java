package sample01;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

//공통 관심사항
//Aspect
public class LoggingAdvice {
	public void beforeTrace() {
		System.out.println("Before trace...");
	}
	public void afterTrace() {
		System.out.println("After trace...");
	}
	public void trace(ProceedingJoinPoint joinPoint) throws Throwable{
		String methodName= joinPoint.getSignature().toShortString();
		System.out.println("메소드="+methodName);
		
		StopWatch sw = new StopWatch();
		sw.start(methodName);
		
		//핵심 관심사항을 부른 후 처리하고 돌아옴
		joinPoint.proceed();
		
		sw.stop();
		System.out.println("처리시간="+sw.getTotalTimeMillis()/1000+"초");
	}
}
