package miu.edu.demo.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "Logger")
public class Logger {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    int id;
    private String principle;
    private String operation;
    private Date date;
    private String executionTime;
    public void setExecutionTime(String executionTime) {
        this.executionTime = executionTime;
    }
    public void setDate(LocalDate date) {
        // Convert LocalDate to Date
        Date convertedDate = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
        this.date = convertedDate;
    }
}