package com.group.libraryapp.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StopWatch;

import java.util.Arrays;

@Aspect
@Component
public class LogAspect {
    private static final Logger log = LoggerFactory.getLogger(LogAspect.class);

    // 모든 패키지 내의 aop package에 존재하는 클래스
    // Advice Type: @AfterThrowing 지정
    // Pointcuts : execution 문법으로 지정
//    @AfterThrowing(
//            value = "execution( * org.zerock.service.SampleService*.*(..) )",
//            throwing = "ex"
//    )
    @Around("@annotation(LogExecutionTime)")
    public Object logging(ProceedingJoinPoint pjp) throws Throwable{
        // 해당 클래스 처리 전의 시간
        StopWatch sw = new StopWatch();
        sw.start();

        // 해당하는 클래스의 메소드 핵심기능을 실행
        Object result = pjp.proceed();

        // 해당 클래스 처리 후의 시간
        sw.stop();
        long executionTime = sw.getTotalTimeMillis();

        String className = pjp.getTarget().getClass().getName();
        String methodName = pjp.getSignature().getName();
        String task = className+". "+methodName;

        log.debug("[ExecutionTime] " + task + "-->" + executionTime + "(ms)");
        System.out.println("[ExecutionTime] " + task + "-->" + executionTime + "(ms)");

        return result;
    }//logging


}//end


//@Transactional(
//        propagation = Propagation.MANDATORY,
//        isolation = Isolation.READ_COMMITTED
//)

//@Component
//@Aspect
//public class SampleAdvice {
//
//    private static final Logger logger = LoggerFactory.getLogger(SampleAdvice.class);
//
//    //@Before("execution(* org.zerock.service.MessageService*.*(..))")
//    public void startLog(JoinPoint jp) {
//
//        logger.info("----------------------------");
//        logger.info("----------------------------");
//        logger.info(Arrays.toString(jp.getArgs()));
//
//    }
//
//
//    // @Around("execution(* org.zerock.service.MessageService*.*(..))")
//    public Object timeLog(ProceedingJoinPoint pjp)throws Throwable{
//
//        long startTime = System.currentTimeMillis();
//        logger.info(Arrays.toString(pjp.getArgs()));
//
//        Object result = pjp.proceed();
//
//        long endTime = System.currentTimeMillis();
//        logger.info( pjp.getSignature().getName()+ " : " + (endTime - startTime) );
//        logger.info("=============================================");
//
//        return result;
//    }
//
//}