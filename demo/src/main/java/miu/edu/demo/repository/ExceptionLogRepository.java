package miu.edu.demo.repository;

import miu.edu.demo.domain.ExceptionLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExceptionLogRepository extends CrudRepository<ExceptionLog, Long> {

}
