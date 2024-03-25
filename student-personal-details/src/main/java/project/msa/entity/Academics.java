package project.msa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Component
public class Academics {
    private long academicId;
    private long studentId;
    private Course course;
    private int semester;
    private int numSubjects;
    private int marksObtained;
    private int totalMarks;
    private double grade;
}
