package miu.edu.demo.aspects;

import miu.edu.demo.domain.ExceptionLog;
import miu.edu.demo.repository.ExceptionLogRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Aspect
@Component
public class ExceptionLogAspect {

    @Autowired
    private ExceptionLogRepository exceptionRepository;

    @Pointcut("@annotation(miu.edu.demo.aspects.annotation.LoggerInfo)")
    public void exceptionLogPointcut() {

    }

    @AfterThrowing(pointcut = "exceptionLogPointcut()", throwing = "e")
    public void logException(JoinPoint joinPoint, Throwable e) {
        String operation = joinPoint.getSignature().toShortString();
        String principle = "fake_user"; // Replace with actual logic to get the user principle

        ExceptionLog exceptionEntity = new ExceptionLog();
        exceptionEntity.setDate(LocalDate.now());
        exceptionEntity.setTime(LocalTime.now());
        exceptionEntity.setPrinciple(principle);
        exceptionEntity.setOperation(operation);
        exceptionEntity.setExceptionType(e.getClass().getSimpleName());

        exceptionRepository.save(exceptionEntity); // Assuming you have implemented save() method in the repository for ExceptionEntity
    }
}
