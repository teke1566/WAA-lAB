package miu.edu.demo.aspects;

import miu.edu.demo.domain.Logger;
import miu.edu.demo.repository.LoggerRepository;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class LoggerAspect {

    @Autowired
    private LoggerRepository loggerRepo;


    @Pointcut("@annotation(miu.edu.demo.aspects.annotation.LoggerInfo)")
    public void LogInfo(){}

    @Before("LogInfo()")
    public void logBefore(JoinPoint joinPoint) {
        logOperation(joinPoint);
    }

    public void logOperation(JoinPoint joinPoint) {
        String operation =  joinPoint.getSignature().toShortString();

        String principle = "hi teke";

        Logger log = new Logger();
        log.setPrinciple(principle);
        log.setOperation(operation);
        log.setDate(new Date());

        this.saveLogEntry(log);
    }

    private void saveLogEntry(Logger log) {
        loggerRepo.save(log);
    }
}