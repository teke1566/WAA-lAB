package miu.edu.demo.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@Setter
@Getter
@Table(name = "log_exceptions")
public class ExceptionLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String principle;
    String operation;
    String exceptionType;
    Date date;
}