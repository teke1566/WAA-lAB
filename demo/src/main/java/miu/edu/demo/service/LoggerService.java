package miu.edu.demo.service;

import miu.edu.demo.domain.Logger;
import miu.edu.demo.repository.LoggerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class LoggerService {
    @Autowired
    private LoggerRepository loggerRepository;

    public void logInfo(String message) {
        Logger logger = new Logger();
        logger.setDate(LocalDate.now());
        logger.setExecutionTime(String.valueOf(LocalTime.now()));
        logger.setOperation("INFO");
        logger.setPrinciple("PostController");
        loggerRepository.save(logger);
    }

    public void logExecutionTime(String operation, String principle, LocalTime executionTime) {
        Logger logger = new Logger();
        logger.setDate(LocalDate.now());
        logger.setExecutionTime(String.valueOf(executionTime));
        logger.setOperation(operation);
        logger.setPrinciple(principle);
        loggerRepository.save(logger);
    }
}
