package miu.edu.demo.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@Setter
@Getter
@Table(name = "log_exceptions")
public class ExceptionLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long transactionId;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "time")
    private LocalTime time;

    @Column(name = "principle")
    private String principle;

    @Column(name = "operation")
    private String operation;

    @Column(name = "exception_type")
    private String exceptionType;

    // Constructors, getters and setters

}