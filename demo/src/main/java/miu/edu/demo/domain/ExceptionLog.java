package miu.edu.demo.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Data
@Setter
@Getter
@Table(name = "exception_log")
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private String transactionId;


    private LocalDate date;


    private LocalTime time;


    private String principle;


    private String operation;


    private String exceptionType;


    public ExceptionLog(String transactionId, String date, String time, String principle, String operation, String exceptionType) {
        this.transactionId = transactionId;
        this.date = LocalDate.parse(date);
        this.time = LocalTime.parse(time);
        this.principle = principle;
        this.operation = operation;
        this.exceptionType = exceptionType;
    }

    public void setDate(Date date) {
    }
}