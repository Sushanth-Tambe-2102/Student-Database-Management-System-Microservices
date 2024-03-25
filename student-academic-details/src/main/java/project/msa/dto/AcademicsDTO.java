package project.msa.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.msa.entity.Course;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AcademicsDTO {
    private long studentId;

    private Course course;

    private int semester;

    private int numSubjects;

    private int marksObtained;

    private int totalMarks;

    private double grade;


}
