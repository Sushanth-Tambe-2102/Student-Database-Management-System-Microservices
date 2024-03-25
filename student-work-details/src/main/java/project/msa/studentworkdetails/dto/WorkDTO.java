package project.msa.studentworkdetails.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class WorkDTO {
    @Column(nullable = false)
    @Id
    private long studentId ;
    @Column(nullable = false)
    private String employmentType;
    @Column(nullable = false)
    private String companyName;
    @Column(nullable = false)
    private double duration;
    @Column(nullable = false)
    private String domain;
}
