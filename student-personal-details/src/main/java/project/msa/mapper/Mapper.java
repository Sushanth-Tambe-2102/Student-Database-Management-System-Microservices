package project.msa.mapper;

import project.msa.dto.StudentDto;
import project.msa.entity.Student;

public class Mapper {

    public static StudentDto mapToStudentDto(Student student) {
        return new StudentDto(
                student.getStudentId(),
                student.getStudentRollNo(),
                student.getStudentName(),
                student.getStudentEmailId(),
                student.getStudentContact(),
                student.getStudentAddress(),
                student.getStudentFatherName(),
                student.getStudentFatherProfession(),
                student.getStudentFatherContact(),
                student.getStudentMotherName(),
                student.getStudentMotherProfession(),
                student.getStudentMotherContact()
        );
    }

    public static Student mapToStudent(StudentDto studentDto) {
        return new Student(
                studentDto.getStudentId(),
                studentDto.getStudentRollNo(),
                studentDto.getStudentName(),
                studentDto.getStudentEmailId(),
                studentDto.getStudentContact(),
                studentDto.getStudentAddress(),
                studentDto.getStudentFatherName(),
                studentDto.getStudentFatherProfession(),
                studentDto.getStudentFatherContact(),
                studentDto.getStudentMotherName(),
                studentDto.getStudentMotherProfession(),
                studentDto.getStudentMotherContact()
        );
    }

}
