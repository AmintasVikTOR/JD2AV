package av.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LogAspect {

  private static final Logger log = Logger.getLogger(LogAspect.class);

  @Before("within(av.dao.jdbctemplate.*)")
  public void logBefore(JoinPoint joinPoint) {
    log.info("Method " + joinPoint.getSignature().getName() + " start");
  }
}