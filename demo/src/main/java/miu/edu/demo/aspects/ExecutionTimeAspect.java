package miu.edu.demo.aspects;

import miu.edu.demo.domain.Logger;
import miu.edu.demo.repository.LoggerRepository;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Date;


@Aspect
@Component
public class ExecutionTimeAspect {
    @Autowired
    private LoggerRepository loggerRepo;

    @Pointcut("@annotation(miu.edu.demo.aspects.annotation.ExecutionTime)")
    public void ExecutionTime() {

    }

    @Around("ExecutionTime()")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.nanoTime();
        var result = proceedingJoinPoint.proceed();
        long finish = System.nanoTime();
        long exeTime = (finish - start);

        System.out.println(proceedingJoinPoint.getSignature().toShortString() + " teke: " + exeTime );

        String operation =  proceedingJoinPoint.getSignature().toShortString();

        String principle = "hi teke";

        Logger log = new Logger();
        log.setPrinciple(principle);
        log.setOperation(operation);
        log.setExecutionTime(String.valueOf(exeTime) + " ns");
        log.setDate(new Date());

        this.saveLogEntry(log);

        return result;
    }

    private void saveLogEntry(Logger log) {
        loggerRepo.save(log);
    }

}