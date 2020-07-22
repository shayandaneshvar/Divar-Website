package ir.ac.kntu.divar.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("@annotation(Loggable)")
    public void executeLogging() {
    }

    @Before("executeLogging()")
    public void logMethodCall(JoinPoint joinPoint) {
        StringBuilder builder = new StringBuilder();
        var args = joinPoint.getArgs();
        builder.append(joinPoint.getSignature().getName())
                .append("[args](");
        Arrays.stream(args).forEach(z -> builder.append(z).append(","));
        builder.append(" )");
        LOGGER.info(builder.toString());
    }

    @Around("executeLogging()")
    public Object measurePerformance(ProceedingJoinPoint joinPoint)
            throws Throwable {
        StringBuilder builder = new StringBuilder();
        builder.append(joinPoint.getSignature());
        long start = System.currentTimeMillis();
        long end;
        Object ret;
        ret = joinPoint.proceed();
        end = System.currentTimeMillis();
        builder.append((end - start));
        LOGGER.info(builder.toString());
        return ret;
    }

    @AfterReturning(pointcut = "executeLogging()", returning = "returnValue")
    public void logMethodResult(JoinPoint joinPoint, Object returnValue) {
        String builder = joinPoint.getSignature() + " returned: " + returnValue;
        LOGGER.info(builder);
    }
}