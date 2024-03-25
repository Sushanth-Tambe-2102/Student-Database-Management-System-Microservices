package project.msa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Component
public class Work {
    private long studentId;
    private String employmentType;
    private String companyName;
    private String domain;
    private double duration;
}
