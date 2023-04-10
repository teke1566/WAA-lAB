package miu.edu.demo.domain;
import jakarta.persistence.*;
import lombok.*;

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
}