package by.htp.main.controller;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private static final Logger myLogger = Logger.getLogger(LoggingAspect.class);

	@Before("execution(* by.htp.main.controller.*.*(..))")
	public void beforeAddNews(JoinPoint theJoinPoint) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("The controller method works ");
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		
		myLogger.info(">>>>>>>>>>>" + methodSig);
		Object[] args = theJoinPoint.getArgs();
		
		for (Object tempArg : args) {
			
			
			myLogger.info(tempArg);
		}
	}

}

