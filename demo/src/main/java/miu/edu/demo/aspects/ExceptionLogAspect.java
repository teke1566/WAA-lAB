package miu.edu.demo.aspects;

import miu.edu.demo.domain.ExceptionLog;
import miu.edu.demo.repository.ExceptionLogRepository;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Aspect
public class ExceptionLogAspect {
    @Autowired
    ExceptionLogRepository exceptionRepo;
    @Pointcut("execution(* miu.edu.demo.*.*(..)) && " +
            "!execution(* miu.edu.demo.repository.ExceptionLogRepository.*(..)) &&" +
            "!execution(* miu.edu.demo.aspects.ExceptionLogAspect.*(..))")
    private void logException() {}

    @AfterThrowing(pointcut="logException()", throwing = "ex")
    public void logExceptionDetails(Throwable ex) {
        saveLog(ex);
    }

    private void saveLog(Throwable ex){
        var exception = new ExceptionLog();

        exception.setPrinciple("teke");
        exception.setOperation(ex.getMessage());
        exception.setExceptionType(ex.getStackTrace()[0].getClassName());
        exception.setDate(new Date());

        exceptionRepo.save(exception);
    }
}