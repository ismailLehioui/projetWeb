package Logging;

import java.util.logging.LogManager;

import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
private static final Logger logger =LogManager.getLogger(LoggingAspect.class);
@Before("execution(* tn.enicarthage.service.*.*(..))")
public void logMethodEntry(JoinPoint joinPoint) {
String name = joinPoint.getSignature().getName();
logger.info("In method " + name + " : ");
}
}
