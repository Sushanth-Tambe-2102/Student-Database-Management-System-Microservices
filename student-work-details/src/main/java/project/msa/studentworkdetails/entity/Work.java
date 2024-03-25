package project.msa.studentworkdetails.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Work {
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
