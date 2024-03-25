package project.msa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Student {

    // Primary Key of the table
    @Id
    @Column(name="student_id")
    private long studentId;

    // Student's Personal Details
    @Column(name = "student_roll_no", nullable = false, unique = true)
    private String studentRollNo;

    @Column(name = "student_name", nullable = false)
    private String studentName;

    @Column(name = "student_email_id", nullable = false, unique = true)
    private String studentEmailId;

    @Column(name = "student_contact", nullable = false, unique = true)
    private String studentContact;

    @Column(name = "student_address", nullable = false)
    private String studentAddress;

    // Student's Parent's Details
    @Column(name = "student_father_name", nullable = false)
    private String studentFatherName;

    @Column(name = "student_father_profession", nullable = false)
    private String studentFatherProfession;

    @Column(name = "student_father_contact", nullable = false, unique = true)
    private String studentFatherContact;

    @Column(name = "student_mother_name", nullable = false)
    private String studentMotherName;

    @Column(name = "student_mother_profession", nullable = false)
    private String studentMotherProfession;

    @Column(name = "student_mother_contact", nullable = false, unique = true)
    private String studentMotherContact;

}
