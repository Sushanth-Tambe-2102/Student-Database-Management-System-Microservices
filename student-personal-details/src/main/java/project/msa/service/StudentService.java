package project.msa.service;

import org.springframework.http.ResponseEntity;
import project.msa.dto.StudentDto;

import java.util.HashMap;
import java.util.List;


public interface StudentService {

    ResponseEntity<List<HashMap<String, Object>>> getAllDetails();
    ResponseEntity<HashMap<String, Object>> getAllDetailsById(long studentId);
    ResponseEntity<List<StudentDto>> getAllPersonalDetails();
    ResponseEntity<StudentDto> getPersonalDetailsById(long studentId);
    ResponseEntity<StudentDto> addPersonalDetails(StudentDto studentDto);
    ResponseEntity<StudentDto> updatePersonalDetails(StudentDto studentDto);
    ResponseEntity<Boolean> studentExists(long studentId);

}
