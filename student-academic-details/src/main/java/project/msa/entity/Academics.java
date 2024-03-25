package project.msa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Academics")
public class Academics {
    @Id
    @Column(nullable = false)
    private long studentId;

    @ManyToOne
    @JoinColumn(name = "courseId")
    private Course course;

    @Column(nullable = false)
    private int semester;

    @Column(nullable = false)
    private int numSubjects;

    @Column(nullable = false)
    private int marksObtained;

    @Column(nullable = false)
    private int totalMarks;

    @Column(nullable = false)
    private double grade;
}
