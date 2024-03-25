package project.msa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.msa.dto.StudentDto;
import project.msa.service.StudentServiceImplementation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/personal")
public class StudentController {

    @Autowired
    StudentServiceImplementation studentService;

    @GetMapping("/get-all-details")
    ResponseEntity<List<HashMap<String, Object>>> getAllDetails() {
        return studentService.getAllDetails();
    }

    @GetMapping("/get-all-details/{studentId}")
    ResponseEntity<HashMap<String, Object>> getAllDetailsById(@PathVariable long studentId) {
        return studentService.getAllDetailsById(studentId);
    }

    @GetMapping("/get-all-personal-details")
    ResponseEntity<List<StudentDto>> getAllPersonalDetails() {
        return studentService.getAllPersonalDetails();
    }

    @GetMapping("/get-personal-details/{studentId}")
    ResponseEntity<StudentDto> getPersonalDetailsById(@PathVariable long studentId) {
        return studentService.getPersonalDetailsById(studentId);
    }

    @PostMapping("/add-personal-details")
    ResponseEntity<StudentDto> addPersonalDetails(@RequestBody StudentDto studentDto) {
        return studentService.addPersonalDetails(studentDto);
    }

    @PutMapping("/update-personal-details")
    ResponseEntity<StudentDto> updatePersonalDetails(@RequestBody StudentDto studentDto) {
        return studentService.updatePersonalDetails(studentDto);
    }

    @GetMapping("/exists/{studentId}")
    ResponseEntity<Boolean> studentExists(@PathVariable long studentId) {
        return studentService.studentExists(studentId);
    }

}
