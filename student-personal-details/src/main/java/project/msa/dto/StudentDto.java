package project.msa.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentDto {

    private long studentId;
    private String studentRollNo;
    private String studentName;
    private String studentEmailId;
    private String studentContact;
    private String studentAddress;
    private String studentFatherName;
    private String studentFatherProfession;
    private String studentFatherContact;
    private String studentMotherName;
    private String studentMotherProfession;
    private String studentMotherContact;

}
